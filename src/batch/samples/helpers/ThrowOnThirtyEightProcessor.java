package batch.samples.helpers;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;


@Dependent
public class ThrowOnThirtyEightProcessor implements ItemProcessor {

	public boolean thrownOnce = false;
	
    /**
     * Default constructor. 
     */
    public ThrowOnThirtyEightProcessor() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @throws Exception 
	 * @see ItemProcessor#processItem(Object)
     */
    public Object processItem(Object arg0) throws Exception {
    	Integer i = (Integer)arg0;
    	
    	if ((i.intValue()==38)&&(!thrownOnce)) {
    		thrownOnce = true;
    		Exception ex = new java.lang.IllegalArgumentException();
    		throw ex;
    	} 
    	
    	return arg0;
    	
    }

}
