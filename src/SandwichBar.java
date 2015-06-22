import java.util.HashSet;

public class SandwichBar {

	public int whichOrder(String[] available, String[] orders){
		// fill in code here
		int counter = -1;
		
		HashSet<String> ordercounter = new HashSet<String>();
		HashSet<String> availcounter = new HashSet<String>();
		
	for(int l = 0; l < available.length; l++){
		availcounter.add(available[l]);
	}	
	outerloop:
	for(int i = 0; i < orders.length; i++){
		String[] parts= orders[i].split(" ");
			for(int j = 0; j < parts.length; j++){
				ordercounter.add(parts[j]);
			}
	        if(availcounter.containsAll(ordercounter)){
	        	counter = i;
	        	break outerloop;
	        }
	        ordercounter.clear();
		}	
		return counter;
	}
}