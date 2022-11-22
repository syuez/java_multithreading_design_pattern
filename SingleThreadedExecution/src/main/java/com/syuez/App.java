package com.syuez;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("测试门，按 Ctrl + C 键 退出");
        // Gate gate = new Gate();
        GateSafety gate = new GateSafety();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
