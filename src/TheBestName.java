import java.util.Collections;
import java.util.ArrayList;

public class TheBestName { 

	public String[] sort(String[] names) {
		String[] answer = new String[names.length];
		ArrayList<Name> check = new ArrayList<Name>();

		for(int i =0; i< names.length; i++){
			Name a = new Name(names[i]);
			check.add(a);
		}

		Collections.sort(check);
		for(int i =0; i < check.size(); i++){
			answer[i] = check.get(i).toString();
		}

		return answer;
	}

	public class Name implements Comparable<Name>{
		private String fullname;
		private Character[] characters;


		public Name(String first){
			fullname = first;
			characters = new Character[first.length()];
			for(int i = 0; i < first.length(); i++){
				characters[i] = fullname.charAt(i);
			}
		}

		public String toString(){
			String answer = "";
			for(int i =0; i< characters.length; i++){
				answer = answer + characters[i].toString();
			}
			return answer;
		}
		@Override
		public int compareTo(Name o) {	
			int temp = 0;
			if((o.fullname).equals("JOHN") || (this.fullname).equals("JOHN")){
				if((o.fullname).equals("JOHN")){
					return 1;
				}
				if((this.fullname).equals("JOHN")){
					return -1;
				}
			} else {
				int size =0;
				int sice =0;
				for(int i = 0; i < o.characters.length; i++){
					size = size + (o.characters[i]).charValue()-64;
				}
				for(int i = 0; i < this.characters.length; i++){
					sice = sice + (this.characters[i]).charValue()-64;
				}
				if(sice > size){
					temp = -1;
				}
				if(sice < size){
					temp = 1;
				}
				if(sice == size){
					temp = (this.fullname).compareTo(o.fullname);
				}
			}

			return temp;	
		}
	}
}
