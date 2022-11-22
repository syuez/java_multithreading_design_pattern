package com.syuez;

/**
 * 非线程安全的 Gate（门）类，
 * 表示的是人通过的门
 */
public class Gate {
    /**
     * 到目前为止已通过这道门的“人数”
     */
    private int counter = 0;
    /**
     * 最后一个通行者的“姓名”
     */
    private String name = "Nobody";
    /**
     * 最后一个通行者的“出生地”
     */
    private String address = "Nowhere";

    /**
     * 通过门
     * @param name 通过之人的姓名
     * @param address 通过之人的出生地
     */
    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        /*
         * 检查门的当前状态（最后一个通行者的记录数据）是否正确。
         * 如果姓名与出生地首字母不同，那么说明记录数据是异常的。
         * 当发现记录数据异常时，则显示 Broken（出错了）的信息。
         * */
        check();
    }

    public String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
