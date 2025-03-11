package interview;

@FunctionalInterface
interface Sink extends Runnable {
}

public class ThreadSink implements Sink {

    public static void main(String[] args) {

        // Define the lambda for the Sink interface
        Sink sink = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda method called: " + i);
            }
        };

        // Create and start a thread for the lambda
        Thread lambdaThread = new Thread(sink);
        lambdaThread.start();

        // Create and start a thread for the ThreadSink instance
        ThreadSink threadSink = new ThreadSink();
        Thread threadSinkThread = new Thread(threadSink);
        threadSinkThread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Run called: " + i);
        }
    }
}
