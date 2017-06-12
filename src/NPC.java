import java.io.File;

public class NPC extends Character {

	private String speach;
	private boolean willMove;
	
	public NPC(File f) {
		super(f);
		willMove = sc.nextBoolean();
		speach = sc.nextLine();
	}

	public Hitbox getHitbox() {
		return super.hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		super.hitbox = hitbox;
	}
	
	public String speak(){
		return speach;
	}
	
	public String toString(){
		return super.toString()+"\nSpeach: "+speach;
	}

	public static void main(String[] args) {
		NPC test = new NPC(new File("resources/Characters/TestNPC.txt"));
		System.out.println(test.speak());
	}

}
