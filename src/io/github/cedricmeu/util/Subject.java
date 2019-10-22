package io.github.cedricmeu.util;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    protected void emit(Event e) {
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

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
