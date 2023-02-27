public class StopWatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean isRunning = false;

    public void start() {
        this.startTime = System.nanoTime();
        this.isRunning = true;
    }

    public void stop() {
        this.stopTime = System.nanoTime();
        this.isRunning = false;
    }

    public void reset() {
        this.startTime = 0;
        this.stopTime = 0;
        isRunning = false;
    }
    public long getTime() {
        long elapsedTime;
        elapsedTime = (stopTime - startTime);
        return elapsedTime;
    }
}
