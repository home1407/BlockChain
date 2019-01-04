import java.util.ArrayList;

public class BlockMain {
	public static void main(String[] args) {
		
		Block block = new Block(1, 0, new ArrayList(), null);
		block.mine();
		block.getBlockInformation(); //첫번째 블록 정보
		
		Block block2 = new Block(2, 0, new ArrayList(), block.getBlockHash());
		block2.addTransaction(new Transaction("A", "B", 1.5));
		block2.addTransaction(new Transaction("D", "A", 11.5));
		block2.addTransaction(new Transaction("B", "C", 3.2));
		block2.mine();
		block2.getBlockInformation();  //두번째 블록 채굴시도(0부터 시작, 난이도는 5자리, 00000)
		
		Block block3 = new Block(3, 0, new ArrayList(), block2.getBlockHash());
		block3.addTransaction(new Transaction("B", "C", 0.5));
		block3.addTransaction(new Transaction("C", "A", 5.5));
		block3.mine();
		block3.getBlockInformation(); 
		
		Block block4 = new Block(4, 0, new ArrayList(), block3.getBlockHash());
		block4.addTransaction(new Transaction("B", "D", 5.4));
		block4.addTransaction(new Transaction("C", "B", 1.5));
		block4.mine(); 
		block4.getBlockInformation();
		
		
		
		
		/*int nonce = 0;
		while(true) {
			if(Util.getHash(nonce+"").substring(0,6).equals("0000000")) {
				System.out.println("정답 :" + nonce);
				System.out.println("채굴 해쉬값 : "+ Util.getHash(nonce+ ""));
				break;
			}
			nonce++;
		}
		System.out.println(Util.getHash("해쉬합시다"));
		*/
	}
}
