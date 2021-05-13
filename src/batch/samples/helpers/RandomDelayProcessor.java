package batch.samples.helpers;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;

@Dependent
public class RandomDelayProcessor implements ItemProcessor {

	private static final Logger log = Logger.getLogger( RandomDelayProcessor.class.getName() );
	
	private Random rand = new Random();
	
    /**
     * Default constructor. 
     */
    public RandomDelayProcessor() {
    }

	/**
     * @throws InterruptedException 
	 * @see ItemProcessor#processItem(Object)
     */
    public Object processItem(Object arg0) throws InterruptedException {
    	
    	int delay = rand.nextInt(500); 
    	Thread.sleep(delay);  // nap up to half a second
    	
 //   	log.log(Level.INFO, "Processor delay = "+delay);

    	return new Object();
    }

}
