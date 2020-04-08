package com.mjm.listener;

import lombok.Data;

import java.io.Serializable;
import java.util.EventObject;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-22 14:45
 * @since
 */
@Data
public class DoorEvent extends EventObject implements Serializable {

    private DoorState doorState;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DoorEvent(Object source, DoorState doorState) {
        super(source);
        this.doorState = doorState;
    }
}
