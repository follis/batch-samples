package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class SampleDecider implements Decider {

	private static final Logger log = Logger.getLogger( SampleDecider.class.getName() );

	
	// All these have to match the values in the JSL
	private static final String okInputStatus = new String("OK");
	private static final String badInputStatus = new String("BAD");
	
	private static final String okOutputStatus = new String("OK");
	private static final String badOutputStatus = new String("BAD");
	private static final String mixedOutputStatus = new String("MIXED");
	private static final String unknownOutputStatus = new String("UNKNOWN");
	
    /**
     * Default constructor. 
     */
    public SampleDecider() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see Decider#decide(StepExecution[])
     */
    public String decide(StepExecution[] arg0) {
    	
    	// The rules are:
    	// - If all input status values are ok, then output is ok
    	// - If all input status values are bad, then output is bad
    	// - If a combination, then output is mixed
    	// - If we don't find either one, output is unknown, stop the job
    	
    	String outputStatus = unknownOutputStatus;
    	boolean foundOk = false;
    	boolean foundBad = false;
    	
    	// Loop through the input status values
    	for (int i=0; i<arg0.length;i++) {
    		String flowStatus = arg0[i].getExitStatus();
    		
    		log.log(Level.INFO, "Decider evaluating exit status "+i+" from step "+arg0[i].getStepName() +" value="+flowStatus);
    		
    		if (flowStatus.contentEquals(okInputStatus)) {
    			foundOk = true;
    		}
    		if (flowStatus.equals(badInputStatus)) {
    			foundBad = true;
    		}
    	}
    	
    	if ((foundOk)&&(foundBad)) {
    		outputStatus = mixedOutputStatus;
    	} else if (foundOk) {
    		outputStatus = okOutputStatus;
    	} else if (foundBad) {
    		outputStatus = badOutputStatus;
    	}
    	
		log.log(Level.INFO, "Decider setting exit status to "+outputStatus);

		// Note that this also because the Job Exit Status
		// Also note - no StepContext exists for a Decider
		
		return outputStatus;
    }

}
