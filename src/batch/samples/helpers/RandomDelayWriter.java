package batch.samples.helpers;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;

@Dependent
public class RandomDelayWriter implements ItemWriter {
	
	private static final Logger log = Logger.getLogger( RandomDelayWriter.class.getName() );

	private Random rand = new Random();
	
    /**
     * Default constructor. 
     */
    public RandomDelayWriter() {
    }

	/**
     * @see ItemWriter#open(Serializable)
     */
    public void open(Serializable arg0) {
    }

	/**
     * @see ItemWriter#close()
     */
    public void close() {
    }

	/**
     * @throws InterruptedException 
	 * @see ItemWriter#writeItems(List<java.lang.Object>)
     */
    public void writeItems(List<java.lang.Object> arg0) throws InterruptedException {

    	int delay = rand.nextInt(500); 
    	Thread.sleep(delay);  // nap up to half a second
    	
//    	log.log(Level.INFO, "Writer delay = "+delay);
    }

	/**
     * @see ItemWriter#checkpointInfo()
     */
    public Serializable checkpointInfo() {
			return null;
    }

}
