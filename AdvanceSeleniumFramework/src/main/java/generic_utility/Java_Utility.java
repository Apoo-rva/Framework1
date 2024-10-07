package generic_utility;

import java.util.Random;

public class Java_Utility {
/**
 * this method returns to avoid duplicates
 * @return
 */
	public int getRandomnum() {
	
		Random ran = new Random();
 		int ranNum = ran.nextInt(1000);
		return ranNum;

	}

}
