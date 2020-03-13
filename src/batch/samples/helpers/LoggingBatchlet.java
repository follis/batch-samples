package batch.samples.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;


@Dependent
public class LoggingBatchlet implements Batchlet {
	
	private static final Logger log = Logger.getLogger( LoggingBatchlet.class.getName() );

	@Inject
	private StepContext stepContext;


    /**
     * Default constructor. 
     */
    public LoggingBatchlet() {
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
		log.log(Level.INFO, "Batchlet in control in step "+stepContext.getStepName());
			return null;
    }

}
