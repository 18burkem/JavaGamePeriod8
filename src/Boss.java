import java.io.File;

public class Boss extends Enemy {

	public Boss(File f) {
		super(f);
	}
	
	public static void main(String args){
		Enemy kendall = new Enemy(new File("resources/Characters/TestEnemy.txt"));
		System.out.println(kendall);
		for(int i = 0; i < 20; i++){
			kendall.update(10, NORTH);
		}
	}

}
