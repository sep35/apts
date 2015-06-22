
public class CountAppearances {
	public int numberTimesAppear(int number, int digit) {
		
		// fill in code
		String numbers = Integer.toString(number);
		String digits = Integer.toString(digit);
		char digitf = digits.charAt(0); 
		
		  int counter = 0;
		
		for (int i = 0; i < numbers.length(); i++){
			
				if (numbers.charAt(i) == digitf){
					counter++;
				} 		
		}
	return counter;
	}
}