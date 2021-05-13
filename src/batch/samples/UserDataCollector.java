package batch.samples;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.partition.PartitionCollector;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class UserDataCollector implements PartitionCollector {
	
	private static final Logger log = Logger.getLogger( UserDataCollector.class.getName() );


	@Inject
	private StepContext stepContext;
	
    /**
     * Default constructor. 
     */
    public UserDataCollector() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see PartitionCollector#collectPartitionData()
     */
    public Serializable collectPartitionData() {
    	String userData = (String)stepContext.getTransientUserData();
    	userData = "Collector Data:  "+userData;

    	log.log(Level.INFO, "PartitionCollector collectPartitionData, dataWritten = "+userData);

    	return userData;
    }

}
