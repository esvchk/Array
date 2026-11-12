package com.innowise.course.observer;

import com.innowise.course.entity.GenericArray;
import com.innowise.course.exception.ArrayException;


import java.util.ArrayList;
import java.util.List;

public class ArraySubject  {

    private final List<ArrayObserver> observers = new ArrayList<>();

    public void register(ArrayObserver obs){
        if (obs != null) {
            observers.add(obs);
        }
    }

    public void delete(ArrayObserver obs){
        if (obs != null) {
            observers.remove(obs);
        }
    }

    public void notifyOnChanged(GenericArray array) throws ArrayException {
            for (ArrayObserver o : new ArrayList<>(observers)){
                o.onArrayChanged(array);
            }
        }
}
