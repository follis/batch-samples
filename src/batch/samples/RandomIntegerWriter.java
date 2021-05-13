package batch.samples;

import java.io.Serializable;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;

@Dependent
public class RandomIntegerWriter implements ItemWriter {

	private static final Logger log = Logger.getLogger( RandomIntegerWriter.class.getName() );
	
    /**
     * Default constructor. 
     */
    public RandomIntegerWriter() {
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
     * @see ItemWriter#writeItems(List<java.lang.Object>)
     */
    public void writeItems(List<java.lang.Object> arg0) {
    	Iterator<java.lang.Object> iterator = arg0.iterator();

    	while (iterator.hasNext()) {
    		Integer value = (Integer)iterator.next();
    		log.log(Level.INFO, "Writer received->"+value);
    	}
    	log.log(Level.INFO, "--------------------");
    }

	/**
     * @see ItemWriter#checkpointInfo()
     */
    public Serializable checkpointInfo() {
			return null;
    }

}
