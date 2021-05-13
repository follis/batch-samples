package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.listener.JobListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class JobListenerSetJobStatus implements JobListener {

	private static final Logger log = Logger.getLogger( JobListenerSetJobStatus.class.getName() );

	@Inject
	private JobContext jobContext;

	
    /**
     * Default constructor. 
     */
    public JobListenerSetJobStatus() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see JobListener#afterJob()
     */
    public void afterJob() {
    	String oldStatus = jobContext.getExitStatus();
    	String status = new String("Job Listener Set Job Exit Status");
    	jobContext.setExitStatus(status);
		log.log(Level.INFO, "Job Listener setting job exit status from *"+oldStatus+"* to *"+status+"*");
    }

	/**
     * @see JobListener#beforeJob()
     */
    public void beforeJob() {
        // TODO Auto-generated method stub
    }

}
