package batch.samples;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.BatchProperty;
import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionPlanImpl;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;


@Dependent
public class SamplePartitionMapper implements PartitionMapper {

	private static final Logger log = Logger.getLogger( SamplePartitionMapper.class.getName() );

	
    @Inject
    @BatchProperty(name = "inputDir")
    String inputDir;

	
    /**
     * Default constructor. 
     */
    public SamplePartitionMapper() {
    }

	/**
     * @throws IOException 
	 * @see PartitionMapper#mapPartitions()
     */
    public PartitionPlan mapPartitions() throws IOException {

    	// Just use the default plan implementation
    	PartitionPlan pp = new PartitionPlanImpl();
    	
    	// Get the list of files in the input directory
    	File sourceFolder = new File(inputDir);
        File[] listOfFiles = sourceFolder.listFiles();

        LinkedList<String> ll = new LinkedList<String>();
        
        // Are there any files?
        if (listOfFiles != null) {
            for (int i=0;i<listOfFiles.length;++i) {
                if ((listOfFiles[i].isFile()) && (listOfFiles[i].getName().endsWith(".txt"))) {
                	// Add to our list of files to process
                    ll.add(listOfFiles[i].getCanonicalPath());
            		log.log(Level.INFO, "Found file ->"+listOfFiles[i].getCanonicalPath());
                }
            }
            // If we ended up with any files, create a partition property for each one
            if (!ll.isEmpty()) {
            	int fileCount = ll.size();
            	Properties[] props = new Properties[fileCount];
            	int partitionNumber = 0;
            	Iterator<String> it = ll.iterator();
            	while (it.hasNext()) {
            		String filename = it.next();
            		props[partitionNumber] = new Properties();
            		props[partitionNumber].setProperty("filename",filename);
            		++partitionNumber;
            	}
            	
            	// Set the property array into the Partition Plan
            	pp.setPartitionProperties(props);
            	// As many partitions as we have files
            	pp.setPartitions(fileCount);
            	// As many threads as we have partitions
            	// Maybe this should be throttled somehow so we don't ask for thousands of threads
            	pp.setThreads(fileCount);
            	
            	pp.setPartitionsOverride(true);
            } else {
            	// no files
            	pp.setPartitions(0);
            }
        } else {
        	// no files
        	pp.setPartitions(0);
        }
        
        return pp;

    }

}
