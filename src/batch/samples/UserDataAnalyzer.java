package batch.samples;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.partition.PartitionAnalyzer;
import javax.batch.runtime.BatchStatus;
import javax.enterprise.context.Dependent;

@Dependent
public class UserDataAnalyzer implements PartitionAnalyzer {

	private static final Logger log = Logger.getLogger( UserDataAnalyzer.class.getName() );

    /**
     * Default constructor. 
     */
    public UserDataAnalyzer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see PartitionAnalyzer#analyzeStatus(BatchStatus, String)
     */
    public void analyzeStatus(BatchStatus arg0, String arg1) {
    	log.log(Level.INFO, "PartitionAnalyzer analyzeStatus:  BatchStatus="+arg0+" arg1="+arg1);
    }

	/**
     * @see PartitionAnalyzer#analyzeCollectorData(Serializable)
     */
    public void analyzeCollectorData(Serializable arg0) {
    	String collectorData = (String)arg0;
    	
    	log.log(Level.INFO, "PartitionAnalyzer analyzeCollectorData:  dataWritten="+collectorData);

    }

}
