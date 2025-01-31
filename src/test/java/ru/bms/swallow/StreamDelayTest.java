package ru.bms.swallow;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StreamDelayTest {
    @Test
    public void test() {
        Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9")
                .map(s-> handle((String)s))
                .forEach(s-> System.out.println("result = " + s));
    }

    private String handle(String s){
        System.out.println("s = " + s);
        return s;
    }
}
