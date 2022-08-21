/**
 * This interface is used to observe the events that occur over one
 * section of the highway. There are two kinds of such events: (1)
 * detection of a speeding ("exces de vitesse avec un radar troncon"),
 * and (2) change in the number of cars driving over the section.
 **/
public interface SectionObserver {
    
    /**
     * This method must be invoked whenever a car exits the section
     * with a speeding ("exces de vitesse"). The number of the plate
     * ("plaque d'immatriculation") and the speed of the car must be
     * provided.
     **/
    public void flashSpeeding(String numberPlate,
                              float kilometersPerHour);

    /**
     * This method must be invoked whenever a car enters or exits the
     * road section. The number of cars that are now present over the
     * section must be reported.
     **/
    public void numberOfCarsChanged(int numberOfCars);
}
