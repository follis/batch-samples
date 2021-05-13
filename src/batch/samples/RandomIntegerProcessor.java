package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;

@Dependent
public class RandomIntegerProcessor implements ItemProcessor {
	
	private static final Logger log = Logger.getLogger( RandomIntegerProcessor.class.getName() );

    /**
     * Default constructor. 
     */
    public RandomIntegerProcessor() {
    }

	/**
     * @throws SampleSkippableException 
	 * @see ItemProcessor#processItem(Object)
     */
    public Object processItem(Object arg0) throws SampleSkippableException {
    	
    	Integer value = (Integer)arg0;
		if (value.intValue()>100) {
			// Reader generates random values 0-110
			// For our purposes we'll consider anything over 100 to be bad and skip it
			
			log.log(Level.INFO, "Processor skipping value->"+value);
			
			SampleSkippableException sse = new SampleSkippableException();
			sse.badValue(value);
			throw sse;
		}
		return arg0;
    }

}
