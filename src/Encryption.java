import java.util.HashSet;
public class Encryption {
	
//public static void main(String[] args){
//	String answer = encrypt("encryption");
//	System.out.println(answer);		
//	}
	
	public String encrypt(String message){
		// you write code here
		HashSet<Character> changed = new HashSet<Character>();
		char alphabet = 'a';
		char[] answer = new char[message.length()];		
		outerloop:
		for(int i = 0; i < message.length(); i++){	
			int n = 0;	
			
			while(changed.contains(message.charAt(i))){
				if( i == (message.length())-1 ){
					break outerloop;
				}
				i++;
			}
		    while(n != -1){		      
		      n = message.indexOf(Character.toString(message.charAt(i)), n);		      
		      if(n!= -1){
		    	  answer[n] = alphabet;
		    	  n++;
		      }
		    }
		    changed.add(message.charAt(i));		      
		     answer[i] = alphabet;		    
		    alphabet++;
		}
		String answers= "";
		for( int i =0; i < answer.length; i++){
			answers = answers + answer[i];			
		}
		return answers;
	}

}
