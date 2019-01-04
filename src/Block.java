import java.util.ArrayList;

public class Block {
	private int blockID;
	private int nonce; //ä���� ���� ��(�� ���� �ɋ�����)
	private ArrayList<Transaction> transactionList;  //Transaction ��ü�� ������ �ִ� transactionList
	private String previousBlockHash; //���� �ؽ���
	
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
		System.out.println("��� ��ȣ : " + getBlockID());
		System.out.println("ä�� ���� �� : " + getNonce());
		System.out.println("�ŷ� �õ� �� : " + transactionList.size());
		for(int i= 0; i<transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getTransactionInformation());
		} //�ŷ��� ������ arrayList���� �ϳ��� ���ͼ� ���.
		System.out.println("��� �ؽ� :" + getBlockHash());
		System.out.println("���� ��� �ؽ� :" + getPreviousBlockHash());
		System.out.println("--------------------------------------");
	}
	
	public String getBlockHash() {  //����� �ؽ����� ä�� ������ + �ŷ� ������ ���ڿ� �� + ���� ����� �ؽ� ���̴�. �ѱ��ڶ� �ٲ�� �� ���� �ؽ����� ��� �ٲ�Ե�.
		String transactionInformation = "";
		for(int i= 0; i< transactionList.size(); i++) {
			transactionInformation += transactionList.get(i).getTransactionInformation();
		}
		return Util.getHash(nonce + transactionInformation + previousBlockHash);
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 5).equals("00000")) {  //ä���� ���̵��� 5�ڸ��̸�, 5�ڸ��� 00000�� �ɶ����� ���ѷ���
																  //true�� ä�� ����, break;
				System.out.println(blockID + "��° ��� ä�� ����"); 
				System.out.println("����� �ؽ��� : "+ getBlockHash());
				break;
			}
			nonce++;
		}
	}
}
