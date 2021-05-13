package batch.samples;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class BatchletTransientSender implements Batchlet {

	
	@Inject
	private JobContext jobContext;
	
	
    /**
     * Default constructor. 
     */
    public BatchletTransientSender() {
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
    	jobContext.setTransientUserData(new String("Hello from Step1"));
			return null;
    }

}
