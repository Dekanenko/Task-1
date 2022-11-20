package part2;

import java.util.*;

public class MyContainer implements List {
    private Product[] arr = new Product[0];

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null)
                return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if(!(o instanceof Product))
            throw new ClassCastException("Wrong object : "+o);
        Product product = (Product) o;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(product))
                return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public boolean add(Object o) throws ClassCastException{
        if(!(o instanceof Product))
            throw new ClassCastException("Wrong object : "+o);
        arr = Arrays.copyOf(arr, arr.length+1);
        arr[arr.length-1] = (Product) o;
        return true;
    }

    @Override
    public boolean remove(Object o) throws ClassCastException{
        int i;
        for(i = 0; i < arr.length; i++){
            if(arr[i].equals(o)) {
                arr[i] = null;
                if(nullPusher(i))
                    arr = Arrays.copyOf(arr, arr.length-1);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if(c.size()>0){
            int i = arr.length;
            arr = Arrays.copyOf(arr, arr.length+c.size());
            for(Object elem : c.toArray()){
                arr[i] = (Product) elem;
                i++;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) throws IndexOutOfBoundsException{
        if(index >= 0 && index <= arr.length && c.size()>0){
            for(Object elem : c.toArray()){
                add(index, elem);
                index++;
            }
            return true;
        } throw new IndexOutOfBoundsException("Incorrect index : "+index);
    }

    @Override
    public void clear() {
        arr = Arrays.copyOf(arr, 0);
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException{
        if(index >= 0 && index < arr.length)
            return arr[index];
        throw new IndexOutOfBoundsException("Incorrect index : "+index);
    }

    @Override
    public Object set(int index, Object element) throws IndexOutOfBoundsException, ClassCastException{
        if(!(element instanceof Product))
            throw new ClassCastException("Wrong object : "+element);
        Product tmp = null;
        if(index >= 0 && index < arr.length){
            tmp = arr[index];
            arr[index] = (Product) element;
            return tmp;
        }
        throw new IndexOutOfBoundsException("Incorrect index : "+index);
    }

    @Override
    public void add(int index, Object element) throws IndexOutOfBoundsException, ClassCastException{
        if(!(element instanceof Product))
            throw new ClassCastException("Wrong object : "+element);
        int i;
        if(index >= 0 && index <= arr.length){
            arr = Arrays.copyOf(arr, arr.length+1);
            for(i = arr.length-1; i > index; i--){
                arr[i] = arr[i-1];
            }
            arr[i] = (Product) element;
        }else
            throw new IndexOutOfBoundsException("Incorrect index : "+index);
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException{
        Product tmp = null;
        if(index >= 0 && index < arr.length){
            tmp = arr[index];
            arr[index] = null;
            nullPusher(index);
            arr = Arrays.copyOf(arr, arr.length-1);
            return tmp;
        }
        throw new IndexOutOfBoundsException("Incorrect index : "+index);
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        int i, counter = 0;
        for(i = 0; i < arr.length; i++){
            if(!c.contains(arr[i])) {
                arr[i] = null;
                counter++;
            }
        }
        nullMultiPusher(counter);
        arr = Arrays.copyOf(arr, arr.length-counter);
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        int i, counter = 0;
        for(i = 0; i < arr.length; i++){
            if(c.contains(arr[i])) {
                arr[i] = null;
                counter++;
            }
        }
        nullMultiPusher(counter);
        arr = Arrays.copyOf(arr, arr.length-counter);
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Object elem : c.toArray()){
            if(!contains(elem))
                return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return Arrays.stream(a).toArray();
    }

    private boolean nullPusher(int index){
        for(int i = index; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = null;
        return true;
    }

    private boolean nullMultiPusher(int size){
        for(int k = 0; k < size; k++){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == null){
                    nullPusher(i);
                }
            }
        }
        return true;
    }
}
