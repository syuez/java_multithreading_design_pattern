package com.syuez;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 使用 Java BlockingQueue 队列
 */
public class GateQueue {
    /**
     * 到目前为止已通过这道门的“人数”
     */
    private int counter = 0;

    private BlockingQueue<String[]> q = new LinkedBlockingDeque<>();

    public void pass(String name, String address) {
        final String[] info = new String[2];
        this.counter++;
        info[0] = name;
        info[1] = address;
        q.add(info);
        check();

    }
    private void check() {
        final String name;
        final String address;
        String[] info;
        try {
            info = q.take();
            name = info[0];
            address = info[1];
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + "No." + counter + ": " + name + ", " + address);
        }
    }
}
