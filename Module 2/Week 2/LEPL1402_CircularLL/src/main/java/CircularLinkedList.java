class ListNode<Item> {

    private Item item;
    private ListNode<Item> next;

    public ListNode(Item item){
        this.item = item;
        this.next = null;
    }

    public ListNode(Item item, ListNode<Item> next) {
        this.item = item;
        this.next = next;
    }

    /**
     * Return the item of the node
     *
     * @return The item contained in the node
     */
    public Item getItem() {
        return item;
    }

    /**
     * Get the next node in the list
     *
     * @return the next node in the list
     */
    public ListNode<Item> getNext() {
        return this.next;
    }

    /**
     * Set the followers of this node in the list
     *
     * @param next The node to put after this one
     */
    public void setNext(ListNode<Item> next) {
        this.next = next;
    }
}

public class CircularLinkedList<Item> {

    private int size;
    private ListNode<Item> first;
    private ListNode<Item> last;

    public CircularLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Add an element to the list
     *
     * @param item The element to add at the end of the list
     */
    public void enqueue(Item item) {
        ListNode<Item> node = new ListNode<>(item);
        if(this.getFirst() == null){
            node.setNext(node);
            first = node;
            last = node;
        }else {
            node.setNext(this.getFirst());
            last.setNext(node);
            last = node;
        }
        size++;
    }

    /**
     * Remove an element of the list
     *
     * @param index The index of the element to remove
     * @throws IndexOutOfBoundsException if the index is
     *         less than 0 or greater to the size
     *         of the list
     */
    public Item remove(int index) {
        if(index < 0 || index > this.size() || this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        ListNode<Item> current = first;

        if(size() == 1){
            Item node = first.getItem();
            first = null;
            last = null;
            size--;
            return node;
        }

        if (index == 0){
            last.setNext(first.getNext());
            Item node = first.getItem();
            first.setNext(null);
            first = last.getNext();
            size--;
            return node;
        }

        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }

        if(current.getNext() == getLast()){
            current.setNext(first);
            Item node = getLast().getItem();
            last = current;
            size--;
            return node;
        }else {
            current.setNext(current.getNext().getNext());
            Item node = current.getNext().getItem();
            size--;
            return node;
        }






    }

    /**
     * The size of the list
     *
     * @return The size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Is the list empty
     *
     * @return true if there is no element in the list
     *         and false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the first element of the list
     *
     * @return The first ListNode in the list
     */
    public ListNode<Item> getFirst() {
        return this.first;
    }

    /**
     * Get the last element of the list
     *
     * @return The last ListNode in the list
     */
    public ListNode<Item> getLast() {
        return this.last;
    }

}
