package part2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyContainerTest {
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
    void addWithoutIndexTest(){
        MyContainer actual = new MyContainer();
        Product[] expected = {p1};
        actual.add(p1);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void addWithIndexTest(){
        MyContainer actual = new MyContainer();
        Product[] expected = {p1, p5, p2};
        actual.add(p1);
        actual.add(p2);

        actual.add(1, p5);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void addAllWithoutIndexTest(){
        MyContainer actual = new MyContainer();
        actual.add(p1);
        actual.add(p2);

        Product[] expected = {p1, p2, p3, p4};

        MyContainer c = new MyContainer();
        c.add(p3);
        c.add(p4);

        actual.addAll(c);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void addAllWithIndexTest(){
        MyContainer actual = new MyContainer();
        actual.add(p1);
        actual.add(p2);

        Product[] expected = {p1, p3, p4, p2};

        MyContainer c = new MyContainer();
        c.add(p3);
        c.add(p4);

        actual.addAll(1, c);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void getTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);

        assertEquals(p2, arr.get(1));
    }

    @Test
    void setTest(){
        MyContainer actual = new MyContainer();
        Product[] expected = {p1, p5, p2};
        actual.add(p1);
        actual.add(p2);
        actual.add(p2);

        actual.set(1, p5);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void removeWithoutIndexTest(){
        MyContainer actual = new MyContainer();
        Product[] expected = {p1, p3};
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);

        actual.remove(p2);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void removeWithoutIndexNotRemoveTest(){
        MyContainer actual = new MyContainer();
        Product[] expected = {p1, p2, p3};
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);

        actual.remove(p4);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void removeWithIndexTest(){
        MyContainer actual = new MyContainer();
        Product[] expected = {p1, p3};
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);

        actual.remove(1);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void isEmptyTrueTest(){
        MyContainer arr = new MyContainer();
        assertEquals(true, arr.isEmpty());
    }

    @Test
    void isEmptyFalseTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        assertEquals(false, arr.isEmpty());
    }

    @Test
    void containsTrueTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        assertEquals(true, arr.contains(p2));
    }

    @Test
    void containsFalseTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        assertEquals(false, arr.contains(p5));
    }

    @Test
    void clearTest(){
        MyContainer actual = new MyContainer();
        Product[] expected = {};
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);
        actual.clear();
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void indexOfExistTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        assertEquals(1, arr.indexOf(p2));
    }

    @Test
    void indexOfNotExistTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        assertEquals(-1, arr.indexOf(p5));
    }

    @Test
    void lastIndexOfExistTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p2);
        arr.add(p3);
        assertEquals(2, arr.lastIndexOf(p2));
    }

    @Test
    void lastIndexOfNotExistTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        assertEquals(-1, arr.lastIndexOf(p5));
    }

    @Test
    void containsAllTrueTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);

        MyContainer c = new MyContainer();
        c.add(p2);
        c.add(p4);

        assertEquals(true, arr.containsAll(c));
    }

    @Test
    void containsAllFalseTest(){
        MyContainer arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);

        MyContainer c = new MyContainer();
        c.add(p2);
        c.add(p5);

        assertEquals(false, arr.containsAll(c));
    }

    @Test
    void removeAllTest(){
        MyContainer actual = new MyContainer();
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);
        actual.add(p4);

        Product[] expected = {p1, p3};

        MyContainer c = new MyContainer();
        c.add(p2);
        c.add(p4);

        actual.removeAll(c);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void removeAllNoRemoveTest(){
        MyContainer actual = new MyContainer();
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);

        Product[] expected = {p1, p2, p3};

        MyContainer c = new MyContainer();
        c.add(p4);
        c.add(p5);

        actual.removeAll(c);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void retainAllTest(){
        MyContainer actual = new MyContainer();
        actual.add(p4);
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);
        actual.add(p4);

        Product[] expected = {p4, p2, p4};

        MyContainer c = new MyContainer();
        c.add(p2);
        c.add(p4);

        actual.retainAll(c);
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void retainAllNoIntersectionTest(){
        MyContainer actual = new MyContainer();
        actual.add(p1);
        actual.add(p2);
        actual.add(p3);

        Product[] expected = {};

        MyContainer c = new MyContainer();
        c.add(p4);
        c.add(p5);

        actual.retainAll(c);
        assertArrayEquals(expected, actual.toArray());
    }
}
