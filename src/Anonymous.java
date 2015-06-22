import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Anonymous {


	public int howMany(String[] headlines, String [] messages){
		// fill in code here

		String[] headline = lowercase(headlines);
		ArrayList<Character> headlinel = arraylistcreator(headline);
		String[] message = lowercase(messages);

		int count = 0;
		int counter = 0;

		for(int i=0; i<message.length; i++){			
			count = 0;
			ArrayList<Character> headlin = new ArrayList<Character>(headlinel);
				String messagess = message[i].replaceAll("\\s", "");

			for(int j=0; j<messagess.length(); j++){				
				
				for(int k=0; k<headlin.size(); k++){

					if(messagess.charAt(j) == (headlin.get(k)) ){
						headlin.remove(k);
						count++;	
						break;
					}
				}		
			}
			if( messagess.length() == count){
				counter++;
			}
		}

		return counter;	
	}

	public ArrayList<Character> arraylistcreator(String[] args){

		ArrayList<Character> set = new ArrayList<Character>();
		String[] args1= lowercase(args);

		for(int i = 0; i < args1.length; i++){
			String args2 = args1[i].replaceAll("\\s", "");
			for(int j = 0; j < args2.length(); j++){

				set.add((args2).charAt(j));
			}
		}
		return set;
	}


	public Set<Character> setcreator(String args){
		Set<Character> set = new HashSet<Character>();


		for(int j=0; j< args.length(); j++){
			set.add(args.charAt(j));
		}
		return set;
	}


	public String[] lowercase(String[] args){
		String[] arg = new String[args.length];

		for(int i=0; i < args.length; i++){			
			arg[i] = (args[i].replaceAll("\\s", "")).toLowerCase();
		}
		return arg;
	}
}