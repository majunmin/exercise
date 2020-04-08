package com.mjm.listener;

import lombok.Getter;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-22 14:47
 * @since
 */
@Getter
public enum DoorState {

    OPEN(1),
    CLOSE(0);

    private Integer code;

    DoorState(int code){
        this.code = code;
    }

    public static void main(String[] args) {
        System.out.println(Integer.class);
    }
}
