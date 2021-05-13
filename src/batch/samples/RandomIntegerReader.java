package batch.samples;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;

@Dependent
public class RandomIntegerReader implements ItemReader {

	private static final Logger log = Logger.getLogger( RandomIntegerReader.class.getName() );
	
	private Random rand = new Random();
	private int itemsRead = 0;
	private int maxItemsRead = 100;
	
    /**
     * Default constructor. 
     */
    public RandomIntegerReader() {
    }

	/**
     * @see ItemReader#readItem()
     */
    public Object readItem() {
    	
    	int value = rand.nextInt(110); // Random between 0-110

    	Object retVal = new Integer(value);
    	
    	// Something to stop the loop
    	++itemsRead;
    	if (itemsRead>=maxItemsRead) {
    		retVal = null;
    	}

       	log.log(Level.INFO, "Reader returning->"+retVal);
    	
    	return retVal;
    	
    }

	/**
     * @see ItemReader#open(Serializable)
     */
    public void open(Serializable arg0) {
    }

	/**
     * @see ItemReader#close()
     */
    public void close() {
    }

	/**
     * @see ItemReader#checkpointInfo()
     */
    public Serializable checkpointInfo() {
			return null;
    }

}
