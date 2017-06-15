import java.io.File;

public class NPC extends Character {

	private String speach;
	private boolean willMove;
	
	public NPC(File f) {
		super(f);
//		willMove = sc.nextBoolean();
		speach = sc.nextLine();
	}

	public Hitbox getHitbox() {
		return super.hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		super.hitbox = hitbox;
	}
	
	public String toString(){
		return super.toString()+"\nSpeach: "+speach;
	}
	
	public String update(int playerDistance, int playerDirection){
		if(playerDistance<2){
			return speach;
		}
		return null;
	}

	public static void main(String[] args) {
//		NPC test = new NPC(new File("resources/Characters/TestNPC.txt"));
//		System.out.println(test.speak());
		
		Character eli = new NPC(new File("resources/Characters/TestNPC.txt"));
		Character kendall = new Enemy(new File("resources/Characters/TestEnemy.txt"));
//		System.out.println(kendall.getHitbox().getIntX() + " "+kendall.getHitbox().getIntY());
//		System.out.println(kendall);
		for(int i = 0; i < 100; i++){
//			System.out.println(eli.update(i, EAST));
			kendall.update(3, NORTH);
			System.out.println(kendall.getHitbox().getLocation());
		}
	}

}