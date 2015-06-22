import java.util.ArrayList;
import java.util.Collections;

public class Dirsort { 

	public String[] sort(String[] dirs) {
		// you write this function } }
		String[] answer = new String[dirs.length];
		ArrayList<Direct> panswer = new ArrayList<Direct>();

		
		for(int i =0; i< dirs.length; i++){
			String parts = dirs[i];
			System.out.println(parts);
			Direct a = new Direct(parts);	
			System.out.println(a);
			panswer.add(a);
		}
		System.out.println(panswer);
		Collections.sort(panswer);
		for(int i =0; i < panswer.size(); i++){
			answer[i] = panswer.get(i).toString();
		}
		
		return answer;
	}


	public  class Direct implements Comparable<Direct>{

		private int depth;
		private String[] parts;

		public  Direct(String first){
			parts = first.split("\\/");
			depth = parts.length;
			
		}

		public String toString(){
			String answer= "";
			if(parts.length == 0){
				answer = "/";
			}
			for(int i = 0; i < parts.length; i++){
				answer = answer + parts[i] + "/";
			}
			return answer;
		}
		@Override
		public int compareTo(Direct o) {
			int j =1;  
			if(this.parts.length == 0){
				return -1;
			}
			if(o.parts.length == 0){
				return 1;
			}
			int temp = (this.parts[0]).compareTo(o.parts[0]);
			if(parts.length > 1){
			while(temp == 0 ){
				temp = (this.parts[j]).compareTo(o.parts[j]);
				j++;
				if(j == parts.length || j == o.depth){
					break;
				}
			}
			}
			if(this.depth > o.depth){
				return 1;
			} 
			if(this.depth < o.depth){
				return -1;
			}

			return temp;
		}
	}

}
