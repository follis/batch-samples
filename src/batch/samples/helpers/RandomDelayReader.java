package batch.samples.helpers;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;


@Dependent
public class RandomDelayReader implements ItemReader {
	
	private static final Logger log = Logger.getLogger( RandomDelayReader.class.getName() );
	
	private Random rand = new Random();
	private int itemsRead = 0;
	private int maxItemsRead = 100;

    /**
     * Default constructor. 
     */
    public RandomDelayReader() {
    }

	/**
     * @throws InterruptedException 
	 * @see ItemReader#readItem()
     */
    public Object readItem() throws InterruptedException {
    	
    	Object retVal = new Object();
    	
    	int delay = rand.nextInt(500); // Random between 0-500
    	Thread.sleep(delay);  // nap up to half a second

//    	log.log(Level.INFO, "Reader delay = "+delay);
    	
    	// Something to stop the loop
    	++itemsRead;
    	if (itemsRead>=maxItemsRead) {
    		retVal = null;
    	}
    	
//    	log.log(Level.INFO, "Reader itemsRead = "+itemsRead);
    	
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
