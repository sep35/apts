
public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2){
		// you write code here
		int counter = 0;
		
		for ( int i = 0; i < x.length; i++){
			if (inCircle(x[i], y[i], r[i], x1, y1) &&! inCircle(x[i], y[i], r[i], x2, y2) ){
				counter++;
			}
			if (inCircle(x[i], y[i], r[i], x2, y2) &&! inCircle(x[i], y[i], r[i], x1, y1) ){
				counter++;
			}
		}
		return counter;}
		
	public boolean inCircle(int x, int y, int r, int x1, int y1){
		if (Math.sqrt(Math.pow(x-x1, 2)+ Math.pow(y-y1, 2)) < r){
			return true;
		} else {
			return false;
		}
	}
	
	}