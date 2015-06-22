
public class RatRoute {
	private char[][] myGrid;
	public int numRoutes(String[] enc) {
		int m = 0;
		int n = 0;
		int o = 0;
		int p = 0;

		myGrid  = new char[enc.length][enc[0].length()];		
		for(int i = 0; i < enc.length; i++){
			for(int j =0; j < enc[i].length(); j++){
				myGrid[i][j] = enc[i].charAt(j);
				if(enc[i].charAt(j) == 'R'){
					m = i;
					n = j;
				}
				if(enc[i].charAt(j) == 'C'){
					o = i;
					p = j;
				}
			}
		}		
		return routecount(m, n, o, p, distance(m,n,o,p), enc);
	}

	public int routecount(int x, int y, int xcheese, int ycheese, double distance, String[] enc){
		if(distance(x,y,xcheese,ycheese) > distance) return 0;
		if(myGrid[x][y] == 'C') return 1;		
		if(myGrid[x][y] == 'X') return 0;
		
		int left=0, right = 0, up = 0, down = 0;
		
		if( y != 0) left = routecount(x, y-1, xcheese, ycheese, distance(x, y, xcheese, ycheese), enc);
		if( y != enc[0].length()) right = routecount(x, y+1, xcheese, ycheese, distance(x, y, xcheese, ycheese), enc);
		if( x != 0) up   = routecount(x-1, y, xcheese, ycheese, distance(x, y, xcheese, ycheese), enc);
		if( x != enc.length -1)  down = routecount(x+1, y, xcheese, ycheese, distance(x, y, xcheese, ycheese), enc);
		return up+down+left+right;
	}
	public double distance(int x, int y, int xcheese, int ycheese){
		return Math.sqrt(Math.pow(xcheese - x, 2) + Math.pow(ycheese - y, 2));
	}
}
