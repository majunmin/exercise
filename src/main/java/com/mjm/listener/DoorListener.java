package com.mjm.listener;

import java.util.EventListener;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-22 14:50
 * @since
 */
public interface DoorListener extends EventListener {
    void doorEvent(DoorEvent doorEvent);
}
