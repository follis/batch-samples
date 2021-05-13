package batch.samples.helpers;

import java.io.Serializable;

public class IntegerReaderState implements Serializable {
	private static final long serialVersionUID = 3907191126941874291L;
	private Integer curInt;
	
	public IntegerReaderState() {curInt = new Integer(1);}
	public Integer curInt() {return curInt;}
	public void curInt(Integer i) {curInt = i;}


}
