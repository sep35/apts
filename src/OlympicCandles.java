import java.util.Arrays;


public class OlympicCandles{ 
	public int numberOfNights(int[] candles){
		// write code 
		int numNights = 1;
		while(true){
			Arrays.sort(candles);
			for(int i = 0; i < numNights; i++){
				int index = candles.length - i - 1;
				if(index < 0 || candles[index] == 0) return numNights-1;
				else candles[index] --;				
			}
			numNights++;
		}
	}
}
