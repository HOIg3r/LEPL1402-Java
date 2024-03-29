import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Launcher {

    /*
     * Instantiate and start each thread from "t" with its OWN Counter object,
     * then wait for all threads to finish and return the set of Counter objects
     * the threads ran on. Each thread must be named according to its index in the
     * "t" array.
     */
    public static Counter[] init(Thread[] t){
        Counter[] output = new Counter[t.length];
        for (int i = 0; i < t.length; i++) {
            output[i] = new Counter();
            t[i] = new Thread(output[i],String.valueOf(i));
            t[i].start();
        }

        for (Thread thread: t) {
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Thread[] t = new Thread[2];
        System.out.println(init(t)[0].getCount());
    }
}
