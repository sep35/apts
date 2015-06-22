
public class Tourney { 
	public String winner(String[] bracket, String results) {		
		int j = 0;

		return calculator(bracket, results, j);		
	}

	public String calculator(String[] bracket, String results, int j){

		String[] rounds = new String[bracket.length/2];

		for(int i = 0; i < bracket.length; i+=2){
			if(bracket[i].equals("bye") || bracket[i+1].equals("bye") ){				
				if(bracket[i].equals("bye")){
					rounds[i/2] = bracket[i+1];			
				} else {
					rounds[i/2] = bracket[i];
				}
			} else {
				if(results.charAt(j) == 'H'){
					rounds[i/2] = bracket[i];
				} else {
					rounds[i/2] = bracket[i + 1];
				}
				j+=1;				
			}
		}
		if(rounds.length == 1){
			return rounds[0];
		}
		return calculator(rounds, results, j);	
	}
}