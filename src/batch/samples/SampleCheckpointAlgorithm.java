package batch.samples;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.CheckpointAlgorithm;
import javax.enterprise.context.Dependent;

@Dependent
public class SampleCheckpointAlgorithm implements CheckpointAlgorithm {
	
	private static final Logger log = Logger.getLogger( SampleCheckpointAlgorithm.class.getName() );


	private long chunkStartTime;
	private long startTimeThisIteration;
	private long totalTimeThisChunk;
	private int iterationCount=0;
	private int chunkCount = 0;
	private long totalWriteTime;
	
	private long chunkTimeGoal = 5000; // 5 seconds

    /**
     * Default constructor. 
     */
    public SampleCheckpointAlgorithm() {
    }

	/**
     * @see CheckpointAlgorithm#checkpointTimeout()
     */
    public int checkpointTimeout() {
    	return 30;  // just a backstop in case things go wrong
    }

	/**
     * @see CheckpointAlgorithm#endCheckpoint()
     */
    public void endCheckpoint() {
    	long currentTime = System.currentTimeMillis();
    	long writeTime = currentTime - chunkStartTime - totalTimeThisChunk;
    	++chunkCount;
    	totalWriteTime +=writeTime;
 //   	log.log(Level.INFO, "ChunkEnded - writeTime = "+writeTime);
    	
    	log.log(Level.INFO, "ChunkEnded - iterations = "+iterationCount+" missed target by = "+(currentTime-chunkStartTime-chunkTimeGoal));
    }

	/**
     * @see CheckpointAlgorithm#beginCheckpoint()
     */
    public void beginCheckpoint() {
    	totalTimeThisChunk = 0;
    	iterationCount = 0;
    	chunkStartTime = System.currentTimeMillis();
    	startTimeThisIteration = chunkStartTime; // initialize for first pass
//		log.log(Level.INFO, "Chunk started at "+startTimeThisIteration);

    }

	/**
     * @see CheckpointAlgorithm#isReadyToCheckpoint()
     */
    public boolean isReadyToCheckpoint() {
    	boolean ready;
    	
    	++iterationCount;
    	
    	long currentTime = System.currentTimeMillis();
    	long timeThisIteration = currentTime - startTimeThisIteration; // how long for this pass?
    	startTimeThisIteration = currentTime;  // reset for next iteration
    	totalTimeThisChunk += timeThisIteration; // update running total
    	
//		log.log(Level.INFO, "isReadyToCheckpoint - timeThisIteration = "+timeThisIteration);
//		log.log(Level.INFO, "isReadyToCheckpoint - totalTimeThisChunk = "+totalTimeThisChunk);
    	
    	long writeGuess;
    	
    	if (chunkCount==0) { // first time, no idea how long the write will take
    		writeGuess = 300; // guess...
    	} else {
    		writeGuess = totalWriteTime/chunkCount; // average write time
    	}

//		log.log(Level.INFO, "isReadyToCheckpoint - writeGuess = "+writeGuess);
    	
    	long estimatedChunkTime = totalTimeThisChunk + writeGuess;

//		log.log(Level.INFO, "isReadyToCheckpoint - estimatedChunkTime = "+estimatedChunkTime);
    	
    	if (estimatedChunkTime > chunkTimeGoal) {
    		ready = true;
    	} else {
    		ready = false;
    	}
    	
//		log.log(Level.INFO, "isReadyToCheckpoint - ready = "+ready);    	
    	
    	return ready;
    }

}
