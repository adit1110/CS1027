/**
 * This public class called DLStack implements a stack data structure using double-linked nodes.
 *
 * @param <T> the type of elements this stack holds
 * @author Adit Bhimani
 */
public class DLStack<T> implements DLStackADT<T> {
    private DoubleLinkedNode<T> top;
    private int numItems;

    /**
     * This public DLStack method initializes an empty stack.
     */
    public DLStack() {
        this.top = null;
        this.numItems = 0;
    }

    /**
     * This public void push method an item onto the top of this stack.
     *
     * @param dataItem the item to be pushed onto this stack
     */
    public void push(T dataItem) {
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(dataItem);

        if (top != null) {
            newNode.setPrevious(top);
            top.setNext(newNode);
        }
        top = newNode;
        numItems++;
    }

    /**
     * This public pop method removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Adit is dumb");
        }
        T storingTop = top.getElement();
        if (top.getPrevious() == null) {
            top = null;
        }else {
            top = top.getPrevious();
            top.setNext(null);
        }
        numItems --;

        return storingTop;
    }

    /**
     * This public peek method looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Empty stack");
        }

        return top.getElement();
    }

    /**
     * This public pop method has a similar functionality to the previous pop method, where it
     * removes the kth object from the top of this stack and returns that object as the value of this function.
     *
     * @param k the position from the top of the stack of the object to be removed
     * @return The kth object at the top of this stack
     * @throws EmptyStackException if this stack is empty
     * @throws InvalidItemException if k is invalid
     */
    @Override
    public T pop(int k) throws InvalidItemException, EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("whatevr");
        }

        if (k <= 0 || k > numItems) {
            throw new InvalidItemException("Invalid value of k.");
        }

        numItems--;

        DoubleLinkedNode<T> currentNode = top;
        for (int i = 1; i < k; i++) {
            currentNode = currentNode.getPrevious();
        }
        T removedItem = currentNode.getElement();

        DoubleLinkedNode<T> previousNode = currentNode.getPrevious();
        DoubleLinkedNode<T> nextNode = currentNode.getNext();

        if (previousNode != null) {
            previousNode.setNext(nextNode);
        } else {
            top = nextNode;
        }

        if (nextNode != null) {
            nextNode.setPrevious(previousNode);
        } else {
            // Update the top if we are removing the last element.
            top = previousNode;
        }

        return removedItem;
    }

    /**
     * This public boolean isEmpty method tests if this stack is empty.
     *
     * @return true if and only if this stack contains no items; false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * This size method returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size() {
        return numItems;
    }

    /**
     * This public DoubleLinkedNode method returns the top node of this stack.
     *
     * @return the top node of this stack
     */
    public DoubleLinkedNode getTop() {
        return top;
    }

    /**
     * This public toString method returns a string representation of this stack in the form of a list of nodes.
     *
     * @return a string representation of this stack
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DoubleLinkedNode<T> current = top;
        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(" ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}