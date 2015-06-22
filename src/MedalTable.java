import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class MedalTable {
	public String[] generate(String[] results){

		HashMap<String, Integer[]> 	map = new HashMap<String, Integer[]>();

		for(int i =0; i < results.length; i++){
			String[] parts = results[i].split(" ");

			for(int j=0; j<3; j++){
				if(map.containsKey(parts[j])){
					Integer[] n = map.get(parts[j]);

					if(j== 0){
						int k = n[0]+1;
						n = new Integer[]{k, n[1], n[2]};
						map.put(parts[j], n );
					}

					if(j == 1){
						int k = n[1]+1;
						n = new Integer[]{n[0], k, n[2]};					
						map.put(parts[j], n);
					}

					if(j==2){
						int k = n[2]+1;
						n = new Integer[]{n[0], n[1], k};						
						map.put(parts[j], n );
					}

				} else {
					if(j==0){
					map.put(parts[0], new Integer[]{1, 0, 0,});
					}
					if(j == 1){
					map.put(parts[1], new Integer[]{0, 1, 0,});
					}
					if(j == 2){
					map.put(parts[2], new Integer[]{0, 0, 1,});
					}
				}
			}
		}

		ArrayList<Wins> help = new ArrayList<Wins>();
		for(String j: map.keySet()){
			Integer[] n = (Integer[])map.get(j);
			String win = j+ " " + n[0] +" " + n[1]+ " " + n[2];

			Wins lets = new Wins(win);
			help.add(lets);
		}

		Collections.sort(help);
		String[] answer = new String[help.size()];
		for(int i = 0; i<help.size(); i++){
			answer[i] = help.get(i).toString();
		}

		return answer;
	}

	public class Wins implements Comparable<Wins>{
		private String country;
		private Integer goldcount;
		private Integer silvercount;
		private Integer bronzecount;
		private String[] parts;

		public Wins(String first){
			parts      = first.split(" ");
			country    = parts[0];
			goldcount  = Integer.parseInt(parts[1]);
			silvercount= Integer.parseInt(parts[2]);
			bronzecount= Integer.parseInt(parts[3]);
		}

		public String toString(){
			return (country + " " + goldcount + " " + silvercount + " " + bronzecount);
		}
		@Override
		public int compareTo(Wins o) {

			int temp = (this.goldcount).compareTo(o.goldcount);

			if(temp ==0){
				temp = (this.silvercount).compareTo(o.silvercount);
				if(temp == 0){
					temp =(this.bronzecount).compareTo(o.bronzecount);	
					if(temp == 0){
						temp = -(this.country).compareTo(o.country);
					}			
				}
			}
			return -temp;
		}
	}
}
