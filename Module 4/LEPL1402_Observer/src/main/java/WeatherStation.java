import java.util.ArrayList;
import java.util.List;

public class WeatherStation extends Observable{

    protected List<Pair<String, Integer>> zones = new ArrayList<>();

    protected List<Observer> subscribers = new ArrayList<>();

    @Override
    public Observer[] getSubscribers() {
        Observer[] output = new Observer[subscribers.size()];
        for (int i = 0; i < subscribers.size(); i++) {
            output[i] = subscribers.get(i);
        }
        return output;
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        for (Observer ob:subscribers) {
            if (ob.getZone() == pair.getZone()){
                ob.update(pair.getAlert());
            }
        }
    }

    @Override
    public void addObserver(Observer sub) {
        if (!subscribers.contains(sub)){
            subscribers.add(sub);
        }
    }

    @Override
    public boolean removeObserver(Observer sub) {
        if (subscribers.contains(sub)){
            subscribers.remove(sub);
            return true;
        }
        return false;
    }

    @Override
    public void setAlert(String alert, int zone) {
        for (Observer ob: subscribers) {
            if(ob.getZone() == zone){
                ob.update(alert);
            }
        }
    }
}
