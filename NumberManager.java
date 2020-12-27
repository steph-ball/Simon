import java.util.Arrays;
import java.util.Random;
//Generates random number
//Compares two arrays
// 
public class NumberManager {

	private int numAtPlay;
	private int max;
	private Random rand = new Random();
	private int[] simonArray;
	private int[] playerArray;
	private int numCnt = 0;
	private int speed;
	
	public NumberManager(int speed, int num, int max){
		this.speed = speed * 1000;
		this.numAtPlay = num;
		this.max = max;
		simonArray = new int[max];
		playerArray = new int[max];
	}
	
	/**
	 * Returns a random number within the 
	 * range specified from user. 
	 * @return
	 */
	public int getRandomNum() {
		int randNum = -1;
		if(numAtPlay < 0) {
			while(randNum < 3) {
				randNum = rand.nextInt(21);
			}
		}else {
			randNum = rand.nextInt(numAtPlay);
		}
		for(int i = 0; i < 100; i++) System.out.println();
		System.out.println(randNum);
		return randNum;
	}
	
	public void setPlayerArray(int index, int num) {
		playerArray[index] = num;
	}
	
	public void setSimonArray(int index, int num) {
		simonArray[index] = num;
	}
	
	
	public boolean compareArrays() {
		if(Arrays.equals(simonArray, playerArray)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void play(int numRounds) throws InterruptedException {
		for(int i = 0; i < 100; i++) System.out.println();
		if(numRounds == max) {
			System.out.println("Final Round!");
		}else {
			System.out.println("Round " + numRounds + "!");
		}
		Thread.sleep(speed);
		for(int i = 0; i < numRounds; i++) {
			int num = this.getRandomNum();
			Thread.sleep(speed);
			this.setSimonArray(i, num);
		}
	}
}
