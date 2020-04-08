package com.mjm.listener;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-22 14:52
 * @since
 */
public class DoorListener1 implements DoorListener {
    @Override
    public void doorEvent(DoorEvent doorEvent) {
        if (doorEvent.getDoorState().equals(DoorState.OPEN)){
            System.out.println("DoorListener1: door is open!");
        } else {
            System.out.println("DoorListener1: door is close!");
        }
    }
}
