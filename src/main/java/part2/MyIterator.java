package part2;

import java.util.Iterator;

public class MyIterator implements Iterator<Product> {
    private MyContainer arr;
    private int currentIndex = 0;
    private Product pattern = new Product();

    public MyIterator(MyContainer arr) {
        this.arr = arr;
    }

    public void addPattern(Product pattern){
        this.pattern = pattern;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return findNext() != -1;
    }

    @Override
    public Product next() {
        int tmp = findNext();
        if(tmp != -1){
            currentIndex = tmp+1;
            return (Product)arr.get(tmp);
        }
        return null;
    }

    private int findNext(){
        int index = currentIndex, counter;
        Product tmp;
        while (index < arr.size()){
            counter = 0;
            tmp = (Product) arr.get(index);
            if(pattern.getAmount() != -1){
                if(pattern.getAmount() == tmp.getAmount()){
                    counter++;
                }
            }else {
                counter++;
            }

            if(pattern.getPrice() != -1){
                if(pattern.getPrice() == tmp.getPrice()){
                    counter++;
                }
            }else {
                counter++;
            }

            if(pattern.getName() != null){
                if(pattern.getName().equals(tmp.getName())){
                    counter++;
                }
            }else {
                counter++;
            }

            if(pattern.getMeasure() != null){
                if(pattern.getMeasure().equals(tmp.getMeasure())){
                    counter++;
                }
            }else {
                counter++;
            }

            if(counter == 4){
                return index;
            }
            index++;
        }
        return -1;
    }
}
