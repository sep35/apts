
public class AccessLevel {
	public String canAccess(int[] rights, int minPermission){
		// Fill in code here
		String answer = "";
		
		for (int i = 0; i < rights.length; i++){
			if (minPermission <= rights[i]){
				answer = answer + "A";
			} else {
				answer = answer + "D";
			}
		}
		return answer; 
	}
	public static void main(String[] args){
		AccessLevel test = new AccessLevel();
		int[] right = new int[6];
	
	    right[0] = 0;
		right[1] = 1;
		right[2] = 2;
	    right[3] = 3;
		right[4] = 4;
	    right[5] = 5;
	
         String tests = test.canAccess(right, 2);
	   System.out.println(tests);
	}
}
