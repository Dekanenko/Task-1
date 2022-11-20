package part2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class MyIteratorTest {
    static Product p1;
    static Product p2;
    static Product p3;
    static Product p4;
    static Product p5;
    static MyContainer arr;

    @BeforeAll
    static void initAll() {
        p1 = new Product("P1", 1, Product.KILO, 1);
        p2 = new Product("P2", 2, Product.UNIT, 2);
        p3 = new Product("P3", 3, Product.KILO, 2);
        p4 = new Product("P4", 1, Product.UNIT, 2);
        p5 = new Product("P1", 5, Product.KILO, 5);
        arr = new MyContainer();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);
        arr.add(p5);

    }

    @Test
    void simpleIteratorTest(){
        Iterator simpleIter = arr.iterator();
        Product[] expected = {p1, p2, p3, p4, p5};
        Product[] actual = new Product[5];
        int i = 0;
        while(simpleIter.hasNext()){
            actual[i] = (Product) simpleIter.next();
            i++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    void MyIteratorHasNextTrueTest(){
        MyIterator myIter = (MyIterator) arr.iterator();
        myIter.addPattern(p2);

        assertEquals(true, myIter.hasNext());
    }

    @Test
    void MyIteratorHasNextFalseTest(){
        MyIterator myIter = (MyIterator) arr.iterator();
        Product product = new Product("", 0, "", 0);
        myIter.addPattern(product);

        assertEquals(false, myIter.hasNext());
    }

    @Test
    void MyIteratorNextExistTest(){
        MyIterator myIter = (MyIterator) arr.iterator();
        Product pattern = new Product();
        pattern.setName("P1");
        myIter.addPattern(pattern);

        assertEquals(p1, myIter.next());
    }

    @Test
    void MyIteratorNextNotExistTest(){
        MyIterator myIter = (MyIterator) arr.iterator();
        Product pattern = new Product();
        pattern.setName("");
        myIter.addPattern(pattern);

        assertEquals(null, myIter.next());
    }

    @Test
    void MyIteratorNamePatternTest(){
        Product[] expected = {p1, p5};
        MyContainer actual = new MyContainer();

        MyIterator myIter = (MyIterator) arr.iterator();
        Product pattern = new Product();
        pattern.setName("P1");
        myIter.addPattern(pattern);

        while(myIter.hasNext()){
            actual.add(myIter.next());
        }
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void MyIteratorAmountPatternTest(){
        Product[] expected = {p1, p4};
        MyContainer actual = new MyContainer();

        MyIterator myIter = (MyIterator) arr.iterator();
        Product pattern = new Product();
        pattern.setAmount(1);
        myIter.addPattern(pattern);

        while(myIter.hasNext()){
            actual.add(myIter.next());
        }
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void MyIteratorMeasurePatternTest(){
        Product[] expected = {p1, p3, p5};
        MyContainer actual = new MyContainer();

        MyIterator myIter = (MyIterator) arr.iterator();
        Product pattern = new Product();
        pattern.setMeasure(Product.KILO);
        myIter.addPattern(pattern);

        while(myIter.hasNext()){
            actual.add(myIter.next());
        }
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void MyIteratorPricePatternTest(){
        Product[] expected = {p2, p3, p4};
        MyContainer actual = new MyContainer();

        MyIterator myIter = (MyIterator) arr.iterator();
        Product pattern = new Product();
        pattern.setPrice(2);
        myIter.addPattern(pattern);

        while(myIter.hasNext()){
            actual.add(myIter.next());
        }
        assertArrayEquals(expected, actual.toArray());
    }
}
