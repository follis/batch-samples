package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class BatchletTransientReceiver implements Batchlet {
	
	private static final Logger log = Logger.getLogger( BatchletTransientReceiver.class.getName() );

	
	@Inject
	private JobContext jobContext;
	@Inject
	private StepContext stepContext;


	
    /**
     * Default constructor. 
     */
    public BatchletTransientReceiver() {
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
    	String data = (String)jobContext.getTransientUserData();
		log.log(Level.INFO, "Batchlet in step "+stepContext.getStepName()+" received data *"+data+"*");
			return null;
    }

}
