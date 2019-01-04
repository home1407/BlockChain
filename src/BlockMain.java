import java.util.ArrayList;

public class BlockMain {
	public static void main(String[] args) {
		
		Block block = new Block(1, 0, new ArrayList(), null);
		block.mine();
		block.getBlockInformation(); //ù��° ��� ����
		
		Block block2 = new Block(2, 0, new ArrayList(), block.getBlockHash());
		block2.addTransaction(new Transaction("A", "B", 1.5));
		block2.addTransaction(new Transaction("D", "A", 11.5));
		block2.addTransaction(new Transaction("B", "C", 3.2));
		block2.mine();
		block2.getBlockInformation();  //�ι�° ��� ä���õ�(0���� ����, ���̵��� 5�ڸ�, 00000)
		
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
				System.out.println("���� :" + nonce);
				System.out.println("ä�� �ؽ��� : "+ Util.getHash(nonce+ ""));
				break;
			}
			nonce++;
		}
		System.out.println(Util.getHash("�ؽ��սô�"));
		*/
	}
}
