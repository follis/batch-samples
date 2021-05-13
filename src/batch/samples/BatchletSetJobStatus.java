package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class BatchletSetJobStatus implements Batchlet {

	private static final Logger log = Logger.getLogger( BatchletSetJobStatus.class.getName() );

	@Inject
	private JobContext jobContext;

	
    /**
     * Default constructor. 
     */
    public BatchletSetJobStatus() {
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
    	String oldStatus = jobContext.getExitStatus();
    	String status = new String("Batchlet Set Job Exit Status");
    	jobContext.setExitStatus(status);
		log.log(Level.INFO, "Batchlet setting job exit status from *"+oldStatus+"* to *"+status+"*");
			return null;
    }
	
	
}
