/**
 * This interface allows external classes to observe events that occur
 * over one section of the highway.
 **/
public interface SectionObservable {

    /**
     * Register the given observer, according to the
     * "Observers/Observables" design pattern.
     **/
    public void register(SectionObserver observer);
}
