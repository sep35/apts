
public class FloodRelief {
	private  StringBuilder[] heightscopy;
	public  int minimumPumps(String[] heights){
		// fill in code here
		int pipes = 0;
		heightscopy = new StringBuilder[heights.length];
		for(int i = 0; i < heights.length; i++){
			StringBuilder newstring = new StringBuilder(heights[i]);
			heightscopy[i] = newstring;
		}

		for(int i =0; i < heights.length; i++){
			for(int j = 0; j<heights[i].length(); j++){
				if(heightscopy[i].charAt(j) != 'A'){
					if(minimumPump(heights, i, j, heights[i].charAt(j)) == 0){
						pipes = pipes + 1;
					}
				}
			}
		}
		return pipes;
	}
	private  int minimumPump(String[] heights, int x, int y, Character check){
		if(heightscopy[x].charAt(y) == 'A') return 0;
		if(heights[x].charAt(y) > check) return 0;
		if(heights[x].charAt(y) < check) return 1;
		if(heights[x].charAt(y) == check){
			heightscopy[x].setCharAt(y, 'A');
			System.out.println(heightscopy[x]);
		}
		int right = 0;
		int down = 0;
		int left = 0;
		int up   = 0;

		if(y < heights[x].length()-1){
			if(heightscopy[x].charAt(y+1) != 'A'){
				right = minimumPump(heights, x, y+1, check);
			} else {
				if(heights[x].charAt(y+1) < check) right = 1;
			}
		}
		if(y != 0){
			if(heightscopy[x].charAt(y-1) != 'A'){
				left = minimumPump(heights, x , y-1, check);
			} else {
				if(heights[x].charAt(y-1) < check) left = 1;
			}
		}
		if(x != heights.length-1) {
			if(heightscopy[x+1].charAt(y) != 'A'){
				down  = minimumPump(heights, x+1, y, check);
			} else {
				if(heights[x+1].charAt(y) < check) down = 1;
			}
		}
		if(x != 0){
			if(heightscopy[x-1].charAt(y) != 'A'){
				up   = minimumPump(heights, x-1, y, check);
			} else {
				if(heights[x-1].charAt(y) < check) up = 1;
			}
		}
		return(right + down+ left + up);
	}
}
