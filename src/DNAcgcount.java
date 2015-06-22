
public class DNAcgcount {
	
	double cgcount = 0;
	
	public double ratio(String dna){

	for (int i = 0; i < (dna.length()) ; i++){
		
		if (dna.charAt(i) == 'c'){
			cgcount++;
		} 
		if ( dna.charAt(i) == 'g'){
			cgcount++;
		}
	}
	if (dna.length() == 0){
		double percent = 0;
					return percent;
	} else {
	double percent = (cgcount)/(dna.length());
	return percent;
	}
	}
}
