package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.BatchProperty;
import javax.batch.api.Batchlet;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class UserDataPartitonedBatchlet implements Batchlet {

	private static final Logger log = Logger.getLogger( UserDataPartitonedBatchlet.class.getName() );
	
    @Inject
    @BatchProperty(name = "filename")
    String filename;

	@Inject
	private StepContext stepContext;
	
    /**
     * Default constructor. 
     */
    public UserDataPartitonedBatchlet() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see Batchlet#stop()
     */
    public void stop() {
        // TODO Auto-generated method stub
    }

	/**
     * @see Batchlet#process()
     */
    public String process() {
		log.log(Level.INFO, "Processing file "+filename);
		stepContext.setTransientUserData(filename);
		stepContext.setExitStatus("Processing from "+Thread.currentThread().getId()+" completed successfully");
		return null;
    }

}
