package DesignPattern;

import java.util.Observer;

/**
 * Interface of a subject in a "Observer DP".
 *
 * @author Rémy
 */

public interface Observable {
    /**
     * Adds an observer that observes the subject.
     *
     * @param obs an observer.
     */
    public void registerObserver(Observer obs);

    /**
     * Removes an observer that observes the subject.
     *
     * @param obs an observer
     */
    public void removeObserver(Observer obs);

    /**
     * Notifies all observers of a change.
     */
    public void notifyObservers();
}
