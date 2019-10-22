package io.github.cedricmeu.util;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Base class for subjects on which can be observed for events
 * @author cedricmeukens
 */
public class Subject {
    private ArrayList<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    /**
     * Emit an <code>Event</code> and call the listener function
     * for this <code>Event</code> in the <code>Observer</code>s
     * if one is present
     * @param e The event to be emitted
     */
    protected void emit(Event e) {
        if (e == null) throw new NullPointerException("Events cannot be null");

        for (Observer o : observers) {
            Method eventHandler;
            try {
                eventHandler = o.getClass().getMethod("listen", e.getClass());
            } catch (Exception exc) {
                eventHandler = null;
            }

            if (eventHandler != null) {
                try {
                    eventHandler.invoke(o, e);
                } catch (Exception exc) {
                    System.out.println("Something went wrong with the implementation of an event listener");
                }
            }
        }
    }

    /**
     * Add an <code>Observer</code> to the <code>Subject</code>
     * and notify if <code>Event</code>s are triggered and the
     * <code>Observer</code> has a function implemented that listens
     * for that specific <code>Event</code>
     * @param observer The <code>Observer</code> to be added
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
