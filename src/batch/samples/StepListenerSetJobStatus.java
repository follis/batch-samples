package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.listener.StepListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class StepListenerSetJobStatus implements StepListener {

	private static final Logger log = Logger.getLogger( StepListenerSetJobStatus.class.getName() );

	@Inject
	private JobContext jobContext;

	
    /**
     * Default constructor. 
     */
    public StepListenerSetJobStatus() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see StepListener#beforeStep()
     */
    public void beforeStep() {
        // TODO Auto-generated method stub
    }

	/**
     * @see StepListener#afterStep()
     */
    public void afterStep() {
    	String oldStatus = jobContext.getExitStatus();
    	String status = new String("Step Listener Set Job Exit Status");
    	jobContext.setExitStatus(status);
		log.log(Level.INFO, "Step Listener setting job exit status from *"+oldStatus+"* to *"+status+"*");
    }

}
