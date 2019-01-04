
public class Transaction {

	String sender; //전달자
	String receiver; //수신자
	double amount; //코인의 양
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Transaction(String sender, String receiver, double amount) {
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}
	
	public String getTransactionInformation() {
		return sender + "이(가)" + receiver + " 에게" + amount + " 개의 코인을 보냈습니다.";
	}
	
}
