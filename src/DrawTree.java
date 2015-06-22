import java.util.*;

public class DrawTree { 
	private  int[] parent;
	private  String[] name;
	private  List<String> done = new ArrayList<String>();

	public String[] draw(int[] parents, String[] names) {
		parent = parents;
		name = names;
		String prefix = "";
		helper(prefix, -1);
		String[] answer = new String[names.length];
		for(int i=0; i<names.length; i++){
			answer[i] = done.get(i);
		}
		return answer;
	}
	public void helper(String prefix, int index){
		int amount = indeces(index);
		for(int i = 0; i < parent.length; i++){
			if(index == parent[i]){
				amount-=1;
				if(amount == 0){
					done.add(prefix + "+-" + name[i]);
					helper(prefix+"  ", i);
				} else {
					done.add(prefix + "+-" + name[i]);
					helper( prefix+"|"+ " ", i);
				}
			}
		}
	}

	public int indeces(int index){
		int answer = 0;
		for(int i = 0; i < parent.length; i++){
			if(parent[i] == index){
				answer+=1;				
			}
		}
		return answer;
	}
}