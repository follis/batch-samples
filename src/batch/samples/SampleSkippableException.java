package batch.samples;

public class SampleSkippableException extends Exception {
	
	private static final long serialVersionUID = 5232667559006234399L;
	int badValue;
	
	public void badValue(int i) {
		badValue = i;
	}
	
	public int badValue() {
		return badValue;
	}

}
