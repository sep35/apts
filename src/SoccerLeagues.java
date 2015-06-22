
public class SoccerLeagues {
	public int[] points(String[] matches){
		// My code to rule 
	
int[] teams = new int[matches.length];
	for (int i = 0; i < matches.length; i++){
	
		for (int j = 0; j < (matches[i]).length(); j++){
			
			// Check for no game
			if (i == j){
				teams[i] = teams[i] + 0;
			}
			// check for lost
			if ( (matches[i]).charAt(j) == 'L'){
				teams[j] = teams[j] + 3;
			}
			// check for win
			if ( (matches[i]).charAt(j) == 'W'){
				teams[i] = teams[i] + 3;
			}
			// check for tie
			if ( (matches[i]).charAt(j) == 'D'){
				teams[i] = teams[i] + 1;
				teams[j] = teams[j] + 1;
			}
		}
	}
	return teams;}
}
