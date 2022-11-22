package com.syuez;

/**
 * 不断通过门的人
 */
public class UserThread extends Thread {
    /**
     * 要通过的门
     */
    // private final Gate gate;
    private final GateSafety gate;
    /**
     * 姓名
     */
    private final String myName;
    /**
     * 出生地
     */
    private final String myAddress;

    public UserThread(GateSafety gate, String myName, String myAddress) {
        this.gate = gate;
        this.myName = myName;
        this.myAddress = myAddress;
    }
    /*
     * 线程首先显示通过者姓名和 BEGIN 字样，随后执行 while 无限循环，
     * 并在循环中反复调用 pass 方法来表示这个人在门里不断地穿梭通过。
     * */
    @Override
    public void run() {
        System.out.println(myName + " BEGIN");
        while (true) {
            gate.pass(myName, myAddress);
        }
    }
}
