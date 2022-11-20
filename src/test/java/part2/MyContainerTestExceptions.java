package part2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyContainerTestExceptions {
    static Product p1;
    static Product p2;
    static Product p3;
    static Product p4;
    static Product p5;

    @BeforeAll
    static void initAll() {
        p1 = new Product("P1", 1, Product.KILO, 1);
        p2 = new Product("P2", 2, Product.UNIT, 2);
        p3 = new Product("P3", 3, Product.KILO, 3);
        p4 = new Product("P4", 4, Product.UNIT, 4);
        p5 = new Product("P5", 5, Product.KILO, 5);
    }

    @Test
    void addWithNegativeIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.add(-1, p1));
        assertEquals(actualEx.getMessage(), "Incorrect index : -1");
    }

    @Test
    void addWithPositiveIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.add(2, p1));
        assertEquals(actualEx.getMessage(), "Incorrect index : 2");
    }

    @Test
    void addAllIndexIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        MyContainer c = new MyContainer();
        c.add(p1);
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.addAll(1, c));
        assertEquals(actualEx.getMessage(), "Incorrect index : 1");
    }

    @Test
    void addClasCastExceptionTest(){
        MyContainer arr = new MyContainer();
        Object obj = new Object();
        ClassCastException actualEx = assertThrows(ClassCastException.class, ()-> arr.add(obj));
        assertEquals(actualEx.getMessage(), "Wrong object : "+obj);
    }

    @Test
    void addWithIndexClasCastExceptionTest(){
        MyContainer arr = new MyContainer();
        Object obj = new Object();
        ClassCastException actualEx = assertThrows(ClassCastException.class, ()-> arr.add(0, obj));
        assertEquals(actualEx.getMessage(), "Wrong object : "+obj);
    }

    @Test
    void containsClasCastExceptionTest(){
        MyContainer arr = new MyContainer();
        Object obj = new Object();
        arr.add(p1);
        ClassCastException actualEx = assertThrows(ClassCastException.class, ()-> arr.contains(obj));
        assertEquals(actualEx.getMessage(), "Wrong object : "+obj);
    }

    @Test
    void getWithNegativeIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.get(-1));
        assertEquals(actualEx.getMessage(), "Incorrect index : -1");
    }

    @Test
    void getWithPositiveIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.get(1));
        assertEquals(actualEx.getMessage(), "Incorrect index : 1");
    }

    @Test
    void setWithNegativeIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.set(-1, p1  ));
        assertEquals(actualEx.getMessage(), "Incorrect index : -1");
    }

    @Test
    void setWithPositiveIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.set(1, p2));
        assertEquals(actualEx.getMessage(), "Incorrect index : 1");
    }

    @Test
    void setClasCastExceptionTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        Object obj = new Object();
        ClassCastException actualEx = assertThrows(ClassCastException.class, ()-> arr.set(0, obj));
        assertEquals(actualEx.getMessage(), "Wrong object : "+obj);
    }

    @Test
    void removeWithNegativeIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.remove(-1));
        assertEquals(actualEx.getMessage(), "Incorrect index : -1");
    }

    @Test
    void removeWithPositiveIndexExceptionTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        IndexOutOfBoundsException actualEx = assertThrows(IndexOutOfBoundsException.class, ()-> arr.remove(1));
        assertEquals(actualEx.getMessage(), "Incorrect index : 1");
    }
}
