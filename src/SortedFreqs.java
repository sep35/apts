import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class SortedFreqs {
	public int[] freqs(String[] data) {
		
		int n = 0;
		
		HashMap<String, Integer> check = new HashMap<String, Integer>();
		ArrayList<String> panswer = new ArrayList<String>();
		
		for(int i =0; i< data.length; i++){
			if(check.containsKey(data[i])){
				n = check.get(data[i]);
				check.put(data[i], n+1);				
			} else {
				check.put(data[i], 1);
			}
		}
		
		for(String t: check.keySet()){
			panswer.add(t);
		}
		
	
		Collections.sort(panswer);
		panswer.trimToSize();
		int[] answer = new int[panswer.size()];
		for(int i =0; i< check.size(); i++){
			answer[i] = check.get(panswer.get(i));
		}


		return answer;
	}
}