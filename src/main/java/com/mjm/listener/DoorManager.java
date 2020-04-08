package com.mjm.listener;

import java.util.Collection;
import java.util.HashSet;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-22 14:55
 * @since
 */
public class DoorManager {

    private Collection<DoorListener> listeners;

    public void addDoorListeners(DoorListener doorListener){
        if (listeners == null){
            listeners = new HashSet();
        }
        listeners.add(doorListener);
    }

    public void removeDoorListeners(DoorListener doorListener){
        if (listeners == null)
            return;
        listeners.remove(doorListener);
    }

    public void fireOpenDoorEvent(){
        if (listeners == null)
            return;

        DoorEvent doorEvent = new DoorEvent(this, DoorState.OPEN);
        notifyListeners(doorEvent);
    }

    public void fireCloseDoorEvent(){
        if (listeners == null)
            return;

        DoorEvent doorEvent = new DoorEvent(this, DoorState.CLOSE);
        notifyListeners(doorEvent);
    }

    public void notifyListeners(DoorEvent doorEvent){

        if (listeners == null)
            return;
        for (DoorListener listener : listeners) {
            listener.doorEvent(doorEvent);
        }
    }
}
