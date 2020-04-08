package com.mjm.listener;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-22 14:55
 * @since
 */
public class App {

    public static void main(String[] args) {
        DoorManager doorManager = new DoorManager();
        doorManager.addDoorListeners(new DoorListener1());
        doorManager.addDoorListeners(new DoorListener2());
        doorManager.fireOpenDoorEvent();
        System.out.println("door opend...");
        doorManager.fireCloseDoorEvent();
        System.out.println("door closed...");
    }
}
