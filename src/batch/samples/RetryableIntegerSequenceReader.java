package batch.samples;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;

import batch.samples.helpers.IntegerReaderState;

@Dependent
public class RetryableIntegerSequenceReader implements ItemReader {

	private static final int maxInt = 100;
	
	private IntegerReaderState rs;
	
    /**
     * Default constructor. 
     */
    public RetryableIntegerSequenceReader() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ItemReader#readItem()
     */
    public Object readItem() {
    	Integer retVal;
    	
    	// If we're not done, get the current 'record'
    	if (rs.curInt().intValue()<=maxInt) {
    		retVal = rs.curInt();
        	// position for next read
        	rs.curInt(new Integer(rs.curInt().intValue()+1));
    	} else {
    		retVal = null;
    	}
    	
    	
    	return retVal;

    }

	/**
     * @see ItemReader#open(Serializable)
     */
    public void open(Serializable arg0) {
    	if (arg0==null) {
        	rs = new IntegerReaderState();    		
    	} else {
    		rs = (IntegerReaderState)arg0;
    	}

    }

	/**
     * @see ItemReader#close()
     */
    public void close() {
        // TODO Auto-generated method stub
    }

	/**
     * @see ItemReader#checkpointInfo()
     */
    public Serializable checkpointInfo() {
			return rs;
    }
    

}
