
public class Gravity {

	int time;
	int velo;
	
	public double falling(double time, double velo){ 
		// Fill in code here
		double meters = (velo*time) + 0.5*9.8*(time*time);
		return meters;
	}

}
