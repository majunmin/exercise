package com.mjm.listener;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-22 14:53
 * @since
 */
public class DoorListener2 implements DoorListener {
    @Override
    public void doorEvent(DoorEvent doorEvent) {
        if (doorEvent.getDoorState().equals(DoorState.OPEN)){
            System.out.println("DoorListener2: door is open, open the light!");
        } else {
            System.out.println("DoorListener2: door is close, close the light!");
        }
    }
}
