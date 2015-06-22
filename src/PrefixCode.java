
public class PrefixCode {
	public  String isOne(String[] words){
		// fill in body of this function

		String answer = "Yes";
		int worked= 0;
		int count = 50;

		for(int i = 0; i < words.length; i++){
			innerloop:    
				for(int k = 0; k < words.length; k++){
					worked = 0;
					for( int j = 0; j < words[i].length(); j++){				
						while (words[i].length() > words[k].length()){
							k++;
							if(k == words.length){
								worked = 1;
								break innerloop;
							}
						}	
						if( i == k){
							k++;
							if(k == words.length){
								worked = 1;
								break innerloop;
							}
						}
						if (words[i].charAt(j) != words[k].charAt(j)){
							worked = 1;
						}

					}
					if( worked == 0){
						if(count > i){
							answer = "No, " + i;
							count = i;
						}
						break innerloop;
					}				
				}
		}		
		return answer;
	}

}

