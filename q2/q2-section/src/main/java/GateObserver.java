/**
 * This interface is used to observe the events that occur at a gate
 * that is located at the enter or at the exit of a road
 * section. There are two kinds of such events: (1) A car has entered
 * the section, and (2) a car has exited the section.
 **/
public interface GateObserver {
    
    /**
     * This method is invoked whenever a car enters the observed road
     * section. The number of the plate of the car ("plaque
     * d'immatriculation") and the timestamp are provided. The
     * timestamp is expressed as the floating-point number of hours
     * since the Epoch (i.e. Thursday 1 January 1970 00:00:00 UTC).
     *
     * This method must throw an "IllegalArgumentException" if a car
     * with the same plate number is already driving over the section.
     **/
    public void carEntered(String numberPlate,
                           float hoursSinceEpoch);

    /**
     * This method is invoked whenever a car exits the observed road
     * section. The arguments are the same as for "carEntered()".
     *
     * This method must throw an "IllegalArgumentException" if there
     * is no car with the provided plate number that is currently
     * driving over the section, or if the computed speed is negative
     * (which indicates bad timestamps).
     **/
    public void carExited(String numberPlate,
                          float hoursSinceEpoch);
}
