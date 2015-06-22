
public class GridGame { 
	private char[][] myGrid = new char[4][4];
	public int winningMoves(String[] grid){
		// fill in code here 
		for(int r=0; r < 4; r++) { 
			for(int c=0; c < 4; c++) { 
				myGrid[r][c] = grid[r].charAt(c);
			}
		}
		return findWins();
	}
	private int findWins(){
		int total = 0;
		for(int r=0; r < 4; r++){
			for(int c=0; c < 4; c++){
				if (canPlace(r,c)){ 
					// open for a move 
					myGrid[r][c] = 'X'; 
					int oppwins = findWins();
					// update total here 
					if(oppwins == 0) total += 1;
					// reset myGrid here
					myGrid[r][c] = '.';
				}
			}
		}
		return total;
	}
	public boolean canPlace(int r, int c){
		if(myGrid[r][c] == 'X') return false;	
		if(r > 0 && myGrid[r-1][c] == 'X') return false;
		if(r < 3 && myGrid[r+1][c] == 'X') return false;
		if(c > 0 && myGrid[r][c-1] == 'X') return false;
		if(c < 3 && myGrid[r][c+1] == 'X') return false;
		return true;
	}
}
