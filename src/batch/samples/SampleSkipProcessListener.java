package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.listener.SkipProcessListener;
import javax.enterprise.context.Dependent;

@Dependent
public class SampleSkipProcessListener implements SkipProcessListener {
	
	private static final Logger log = Logger.getLogger( SampleSkipProcessListener.class.getName() );

    /**
     * Default constructor. 
     */
    public SampleSkipProcessListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see SkipProcessListener#onSkipProcessItem(Object, Exception)
     */
    public void onSkipProcessItem(Object arg0, Exception arg1) {
    	log.log(Level.INFO, "Handling skip value->"+((SampleSkippableException)arg1).badValue());
    }

}
