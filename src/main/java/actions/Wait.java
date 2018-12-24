package actions;

import org.apache.log4j.Logger;

public class Wait {

    private static Logger log=Logger.getLogger(Wait.class);

    public void forSeconds(int seconds) {
        try{
            Thread.sleep(seconds*900);
            log.info("Waited for "+seconds+" seconds");
        }catch (InterruptedException e){
            log.warn("Failed to execute thread.sleep()");
        }
    }

}
