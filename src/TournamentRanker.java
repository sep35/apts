import java.util.ArrayList;
import java.util.Collections;

public class TournamentRanker {	
	public  String[] rankTeams(String[] names, String[] lostTo){

		ArrayList<Winning> ranking = new ArrayList<Winning>();
		String[] rank = new String[names.length];
		int[] wins = new int[names.length];

		for(int i =0; i< names.length; i++){
			wins[i] = win(names[i], lostTo);
			Winning a = new Winning(names[i], wins[i], lostTo[i], names, lostTo);
			ranking.add(a);
		}
		Collections.sort(ranking);

		for(int i = 0; i < ranking.size(); i++){
			rank[i] = (ranking.get(i)).toString();
		}

		return rank;
	}

	public class Winning implements Comparable<Winning>{
		private String myName;
		private Integer myWins;
		private String myNext;
		private String[] losto;
		private String[] names;

		public Winning(String nam, int win, String lost, String[] Names, String[] lostTo){
			myName = nam;
			myWins = win;
			myNext = lost;
			names  =  Names;
			losto  = lostTo;
		}

		public String toString(){
			return myName;
		}

		public int compareTo(Winning o){
			Winning a= null, b = null;
			int temp = (o.myWins).compareTo(this.myWins);
			
			if(temp == 0){
				for(int i = 0 ; i < names.length; i++){
					if(this.myNext.equals(names[i])){
						int win = win(names[i], losto);
						 a = new Winning(names[i], win, losto[i], names, losto);
					}
					if(o.myNext.equals(names[i])){
						int win = win(names[i], losto);
						 b = new Winning(names[i], win, losto[i], names, losto);
					}
				}
				return a.compareTo(b);
			}

			return temp;
		}
	}

	public  int win(String args, String[] lostTo){
		int w = 0;
		for(int i =0; i < lostTo.length; i++){
			if(args.equals(lostTo[i])){
				w += 1;
			}
		}
		return w;
	}

}
