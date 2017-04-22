package learn.ocp.core.chapter10;

public class ObjectComposition {

	public static void main(String[] args) {
		MailerBox mailer =new MailerBox(new GiftBox());
		mailer.addPostage();
		mailer.seal();
		
	}
}

interface Box{
	void pack();
	void seal();
}
interface Mailer{
	void addPostage();
	void ship();
}
class GiftBox implements Box{
	@Override
	public void pack() {
		System.out.println("Packing the Box");	
	}
	@Override
	public void seal() {
		System.out.println("Sealing the Box");
	}
}

class MailerBox implements Box,Mailer{
	private Box box;
	public MailerBox(){
		this.box=new GiftBox();
	}
	public MailerBox(Box box){
		this.box=box;
	}
	@Override
	public void addPostage() {
		System.out.println("Posting to Hidden Leaf");
	}
	@Override
	public void ship(){
		System.out.println("Shipping to Hidden Sand");
	}
	
	@Override
	public void pack() {
		box.pack();
	}
	@Override
	public void seal() {
		box.seal();
	}
}