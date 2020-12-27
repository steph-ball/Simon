
public class TimeManager {
 
	private int speed; 
	
	public TimeManager(int speed) {
		this.speed = speed; 
	}
	
	public boolean timesUp() {
		boolean result = false;
		long start = System.currentTimeMillis();
		long end = start + (speed * 1000);
		long current = System.currentTimeMillis();
		while(current >= end) {
			current = System.currentTimeMillis();
		}
		if(current >= end) {
			result = true;
		}
		return result;
	}
}
