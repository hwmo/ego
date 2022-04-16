package com.hwmo.test.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryTest {

    static class A{

    }

    public static void main(String[] args) throws InterruptedException {
        List<A> list = new ArrayList<A>();
        while(true){
            list.add(new A());
            Thread.sleep(1);
        }
    }
}
