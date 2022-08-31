public class SharedCounter {

    private int counter = 0;

    synchronized public void inc(){
        counter++;
        notify();
    }

    synchronized public void dec(){
        try {
            while (counter <= 0){
                wait();
            }
        }catch (InterruptedException e){}
        counter--;
    }

    public int get(){
        return counter;
    }

}