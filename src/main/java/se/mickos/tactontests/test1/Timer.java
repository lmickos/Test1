package se.mickos.tactontests.test1;

/**
 * Convenience util class for timing executions
 * Created by Lars-Erik on 2017-01-04.
 */
public class Timer {
    /**
     * This method takes a runnable, executes it and returns the execution time.
     * Measurements are made in ms precision so the total execution time must exceed 1 ms.
     * For shorter executions use the overloaded method which calculates the average time of multiple executions
     * @param r The runnable to measure
     * @return The execution time in double precision
     */
    static public double time(Runnable r){
        long startTime = System.currentTimeMillis();
        r.run();
        long stopTime = System.currentTimeMillis();
        return ((double)stopTime-startTime);
    }

    /**
     * This method takes a runnable, executes it a given amount of times and returns the average time.
     * Measurements are made in ms precision so the total execution time (all executions togethere) must exceed 1 ms.
     * @param r The runnable to measure
     * @param multiples How many times to execute before calculating the average
     * @return The average execution time in double precision
     */
    static public double time(Runnable r,int multiples){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < multiples; i++) {
            r.run();
        }
        long stopTime = System.currentTimeMillis();
        return ((double)stopTime-startTime)/multiples;
    }

    /**
     * This method takes a runnable, executes it a given amount of times and returns the average time in a human readable format.
     * Measurements are made in ms precision so the total execution time (all executions togethere) must exceed 1 ms.
     * @param r The runnable to measure
     * @param multiples How many times to execute before calculating the average
     * @return The average execution time as a String with the unit attached adapted to the size of the measurements (ns, ms, s)
     */
    static public String timeFormat(Runnable r,int multiples){
        float result = (float) time(r,multiples); // We do not need double precision when presenting results
        if (result<1) return result*1000+"ns";
        else if (result>1000) return result/1000+"s";
        else return result+"ms";
    }
}
