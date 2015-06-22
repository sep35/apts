import java.util.ArrayList;
import java.util.Collections;

public class ClientsList {
	public String[] dataCleanup(String[] names){
		String[] answer = new String[names.length];
		Name a;
		ArrayList<Name> panswer = new ArrayList<Name>();
	
			for(int i =0; i < names.length; i++){					
					
					if(names[i].contains(",")){
					String[] parts = names[i].split("\\, ");
					 a = new Name(parts[1], parts[0]);
					} else {
					String[] parts = names[i].split(" ");
					 a = new Name(parts[0], parts[1]);
					}
					panswer.add(a);
				}
	Collections.sort(panswer);
	for(int i =0; i < panswer.size(); i++){
		answer[i] = panswer.get(i).toString();
	}


		return answer;
	}
	
	public class Name implements Comparable<Name>{
		private String myFirstName;
		private String myLastName;

		public Name(String first, String last){
			myFirstName = first;
			myLastName = last;
		}

		public String toString(){
			return myFirstName + " " + myLastName;
		}
		@Override
		public int compareTo(Name o) {			
			int temp = (this.myLastName).compareTo(o.myLastName);

			if(temp == 0 ){
				return (this.myFirstName).compareTo(o.myFirstName);
			}

			return temp;
		}
	}

}
