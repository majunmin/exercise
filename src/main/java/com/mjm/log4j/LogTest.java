package com.mjm.log4j;

import lombok.extern.log4j.Log4j2;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-08-29 11:03
 * @since
 */
@Log4j2
public class LogTest {

    public static void main(String[] args) {
        log.error("error: hello world");
        log.warn("warn: hello world");
        log.info("info: hello world");
        log.debug("debug: hello world");
    }
}
