import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object[] list;
    private int size;


    public MyArrayList(int initSize) {
        if(initSize <= 1){
            throw new IndexOutOfBoundsException("Must use a size higher than 1");
        }
        list = new Object[initSize];
        size = 0;
    }


    public void resize() {
        Object[] newArray = new Object[size() * 2];
        for (int i = 0; i < list.length; i++) {
            newArray[i] = list[i];
        }
        list = newArray;
    }

    /*
     * Checks if 'list' needs to be resized then add the element at the end
     * of the list.
     */
    public void enqueue(Item item) {
        if (list.length == size()) {
            resize();
        }
        list[size()] = item;
        size++;
    }


    /*
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list. You dont need to
     * resize when removing an element.
     */
    public Item remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Item tmp = (Item) list[index];
        for (int i = index + 1; i < size() - 1; i++) {
            list[i - 1] = list[i];
        }

        list[size() - 1] = null;
        size--;
        return tmp;
    }


    public int size() {
        return this.size;
    }


    public Object[] getList() {
        return this.list;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {

        private int index = 0;
        private int size = MyArrayList.this.size();

        @Override
        public boolean hasNext() {
            if (size != MyArrayList.this.size) {
                throw new ConcurrentModificationException();
            }
            return index < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index++;
            return (Item) list[index - 1];

        }
        // YOUR CODE HERE
    }

}