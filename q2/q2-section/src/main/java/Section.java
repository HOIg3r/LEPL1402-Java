// You can add imports

import java.util.ArrayList;
import java.util.HashMap;

/**
 * "Section" is the only class to be implemented. An object of this
 * class represents one road section of a highway.
 * <p>
 * Cars enter the road section through a gate, then exit through
 * another gate. Those two gates are equipped with cameras that signal
 * the plate number of the cars as they enter/exit the section,
 * together with the timestamp of such events.
 **/
public class Section implements GateObserver, SectionObservable {

    /**
     * We suggest you to use the class "ArrayList" to store the list
     * of the observers, and the class "HashMap" to store the cars
     * that are currently driving over the road section (this
     * information is needed to detect speedings).
     * <p>
     * Use IntelliJ auto-completion or JavaDoc to get information
     * about how to use these standard classes. For this task, the
     * most important methods are:
     * <p>
     * - For "ArrayList": iterators, add()
     * - For "HashMap": size(), get(), put(), remove(), containsKey()
     * <p>
     * Feel free to use other data structures if you feel more
     * comfortable with them. Complexity will not be taken into
     * account in this task.
     **/
    private ArrayList<SectionObserver> observers;
    private HashMap<String, Float> currentCars;
    private float maximumSpeed;
    private float length;
    private int count = 0;

    /**
     * Constructor of the road section. The caller must provide the
     * maximum speed over this section (expressed in kilometers/hour),
     * and the length of the section (expressed in kilometers).
     **/
    Section(float maximumSpeed, float length) {
        observers = new ArrayList<>();
        currentCars = new HashMap<>();
        this.maximumSpeed = maximumSpeed;
        this.length = length;
    }

    public void addcar(){
        count++;
        for (SectionObserver observer : observers) {
            observer.numberOfCarsChanged(count);
        }
    }

    public void removeCar(){
        count--;
        for (SectionObserver observer : observers) {
            observer.numberOfCarsChanged(count);
        }
    }

    public void isFlashed(String numberPlate, float Kmh){
        for (SectionObserver observer : observers) {
            observer.flashSpeeding(numberPlate, Kmh);
        }
    }

    @Override
    public void carEntered(String numberPlate, float hoursSinceEpoch) {
        if (currentCars.containsKey(numberPlate) || hoursSinceEpoch < 0) {
            throw new IllegalArgumentException("Voiture déja sur la portion de route");
        } else {
            currentCars.put(numberPlate, hoursSinceEpoch);
            addcar();
        }
    }

    @Override
    public void carExited(String numberPlate, float hoursSinceEpoch) {
        if (!currentCars.containsKey(numberPlate)) {
            throw new IllegalArgumentException();
        }
        if ((hoursSinceEpoch - currentCars.get(numberPlate)) < 0) {
            throw new IllegalArgumentException();
        }
        float speed = (length)/(hoursSinceEpoch - currentCars.get(numberPlate));
        currentCars.remove(numberPlate);
        removeCar();
        if(speed > this.maximumSpeed){
            isFlashed(numberPlate,speed);
        }
    }

    @Override
    public void register(SectionObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
}
