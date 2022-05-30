package codeTest;

import java.util.Calendar;
import java.util.Date;

public class Year2016 {

	public static void main(String[] args) {
		
		String answer = "";
		
		int a = 2;
		int b = 29;
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, a - 1, b);
		
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case 1: {
				answer = "SUN";
				break;
			}
			case 2: {
				answer = "MON";
				break;
			}
			case 3: {
				answer = "TUE";
				break;
			}
			case 4: {
				answer = "WED";
				break;
			}
			case 5: {
				answer = "THU";
				break;
			}
			case 6: {
				answer = "FRI";
				break;
			}
			case 7: {
				answer = "SAT";
				break;
			}
		}
		
		System.out.println(answer);
	}
}
