import java.util.Scanner;
public class Simon {

	public static void main(String[] args) throws InterruptedException {
		
		argsManager argsMan = new argsManager(args);
		int numAtPlay = argsMan.getNumAtPlay();
		int max = argsMan.getMaxIteration();
		int speed = argsMan.getSpeed();
		int numRounds = 1;
		boolean match = true;
		NumberManager numMan = new NumberManager(speed,numAtPlay,max);
		Scanner scan, keyboard;
	
		
		while(numRounds <= max && match) {
			numMan.play(numRounds);
			
			scan = new Scanner(System.in);
			for(int i = 0; i < 100; i++) System.out.println();
			System.out.println("Your turn: ");
			
			String newLine = scan.nextLine();	
			
			keyboard = new Scanner(newLine);
			int i = 0;
			while(keyboard.hasNext()) {
				int num = Integer.parseInt(keyboard.next());
				numMan.setPlayerArray(i, num);
				i++;
			}
			if(numRounds == max && match) {
				System.out.println("You won!");
			}
			numRounds ++;
			match = numMan.compareArrays();
			if(!match) {
				System.out.println("Game Over");
			}
			
		}
	}
}
