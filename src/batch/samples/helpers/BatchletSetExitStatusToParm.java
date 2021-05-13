package batch.samples.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.BatchProperty;
import javax.batch.api.Batchlet;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import batch.samples.BatchletSetExitStatusOk;

@Dependent
public class BatchletSetExitStatusToParm implements Batchlet {

   
	private static final Logger log = Logger.getLogger( BatchletSetExitStatusToParm.class.getName() );

	@Inject
	private StepContext stepContext;

    @Inject
    @BatchProperty(name = "useExitStatus")
    String useExitStatus;
	
    /**
     * Default constructor. 
     */
    public BatchletSetExitStatusToParm() {
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
		log.log(Level.INFO, "Batchlet in step "+stepContext.getStepName()+" setting exit status to "+useExitStatus);
		stepContext.setExitStatus(useExitStatus);
		return null;
    }

}
