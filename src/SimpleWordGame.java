import java.util.HashSet;
public class SimpleWordGame {
	
	public int points(String[] player, String[] dictionary){
		// you write code
		HashSet<String> count = new HashSet<String>();
		double counter = 0;
		
		outerloop:
		for(int i = 0; i < player.length; i++){
			while(count.contains(player[i])){
				if(i == (player.length)-1){
					break outerloop;
				}
				i++;
			}
			count.add(player[i]);
			
			for(int j= 0; j < dictionary.length; j++){
				if(player[i].equals(dictionary[j])){
					counter = counter + Math.pow(dictionary[j].length(), 2);
				}
			}
		}
	return (int)counter;
	}

}
