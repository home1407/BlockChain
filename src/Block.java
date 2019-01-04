import java.util.ArrayList;

public class Block {
	private int blockID;
	private int nonce; //채굴의 변수 값(이 값이 될떄까지)
	private ArrayList<Transaction> transactionList;  //Transaction 객체를 가지고 있는 transactionList
	private String previousBlockHash; //이전 해쉬값
	
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}
	
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	public Block(int blockID, int nonce, ArrayList transactionList, String previousBlockHash) {
		this.blockID = blockID;
		this.nonce = nonce;
		this.transactionList = transactionList;
		this.previousBlockHash = previousBlockHash;
	}
	
	public void getBlockInformation() {
		System.out.println("--------------------------------------");
		System.out.println("블록 번호 : " + getBlockID());
		System.out.println("채굴 변수 값 : " + getNonce());
		System.out.println("거래 시도 수 : " + transactionList.size());
		for(int i= 0; i<transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getTransactionInformation());
		} //거래의 정보를 arrayList에서 하나씩 빼와서 출력.
		System.out.println("블록 해쉬 :" + getBlockHash());
		System.out.println("이전 블록 해쉬 :" + getPreviousBlockHash());
		System.out.println("--------------------------------------");
	}
	
	public String getBlockHash() {  //블록의 해쉬값은 채굴 변수값 + 거래 정보의 문자열 합 + 이전 블록의 해쉬 값이다. 한글자라도 바뀌면 이 후의 해쉬값이 모두 바뀌게됨.
		String transactionInformation = "";
		for(int i= 0; i< transactionList.size(); i++) {
			transactionInformation += transactionList.get(i).getTransactionInformation();
		}
		return Util.getHash(nonce + transactionInformation + previousBlockHash);
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 5).equals("00000")) {  //채굴의 난이도는 5자리이며, 5자리가 00000이 될때까지 무한루프
																  //true면 채굴 성공, break;
				System.out.println(blockID + "번째 블록 채굴 성공"); 
				System.out.println("블록의 해쉬값 : "+ getBlockHash());
				break;
			}
			nonce++;
		}
	}
}
