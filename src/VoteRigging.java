import java.util.Arrays;

public class VoteRigging { 
	public int minimumVotes(int[] votes) {
		// fill in code here 
		int rigg = 0;
		if(votes.length ==1) return 0;

		int[] others = new int[votes.length-1];
		for(int i=0; i < others.length; i++){
			others[i]= votes[i+1];
		}
		Arrays.sort(others);

		while(rigg + votes[0] <= others[others.length-1]){
			others[others.length-1]--;
			rigg++;
			Arrays.sort(others);
		}

		return rigg;
	}
} 