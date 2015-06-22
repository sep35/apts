import java.util.ArrayList;

public class WordLadder { 	
	private  ArrayList<String> check = new ArrayList<String>();
	
	public String ladderExists(String[] words, String from, String to) {
		int k = 0;
		int t = 0;

		for(int i =0; i < words.length; i++){
			for(int j = 0; j < words[i].length(); j++){
				if(from.charAt(j) != words[i].charAt(j)){
					k +=1;					
				}
			}
			if(k == 1){
				for(int j =0; j<words[i].length(); j++){
					if(words[i].charAt(j) != to.charAt(j)){
						t += 1;
					}
				}
				if(t == 1){
					return "ladder";
				} else {
					if(!check.contains(words[i])){
						check.add(words[i]);
						return ladderExists(words, words[i], to);
					}
				}		
			}
			t = 0;
			k = 0;
		}
		for(int i =0; i < words.length; i++){
			if(!check.contains(words[i])){
				check.add(words[i]);
				return ladderExists(words, words[i], to);
			}
		}
		return "none";		
	}
}