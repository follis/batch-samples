package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class BatchletSetExitStatusOk implements Batchlet {
	
	private static final Logger log = Logger.getLogger( BatchletSetExitStatusOk.class.getName() );

	@Inject
	private StepContext stepContext;

	
    /**
     * Default constructor. 
     */
    public BatchletSetExitStatusOk() {
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
		log.log(Level.INFO, "Batchlet in step "+stepContext.getStepName()+" setting exit status to OK");
		stepContext.setExitStatus("OK");
			return null;
    }

}
