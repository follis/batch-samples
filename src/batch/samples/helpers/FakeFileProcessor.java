package batch.samples.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.BatchProperty;
import javax.batch.api.Batchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class FakeFileProcessor implements Batchlet {

	private static final Logger log = Logger.getLogger( FakeFileProcessor.class.getName() );
	
    @Inject
    @BatchProperty(name = "filename")
    String filename;
	
    /**
     * Default constructor. 
     */
    public FakeFileProcessor() {
    }

	/**
     * @see Batchlet#stop()
     */
    public void stop() {
    }

	/**
     * @see Batchlet#process()
     */
    public String process() {
		log.log(Level.INFO, "Processing file "+filename);
			return null;
    }

}
