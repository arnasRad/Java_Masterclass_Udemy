import java.util.prefs.NodeChangeEvent;

public class MyLinkedList<T extends ListNode> implements NodeList<T> {
    private T root;

    public MyLinkedList() {
        this(null);
    }

    public MyLinkedList(T node) {
        this.root = node;
    }

    @Override
    public boolean add(T node) {
        if (this.root == null) { // current root is head root
            this.root = node;
            return true;
        }

        T currentItem = this.root;
        while(currentItem != null) {
            int compareResult = currentItem.compareTo(node);
            if (compareResult < 0) {
                // current is less than new root; move right if possible
                if (currentItem.hasNext()) {
                    currentItem = (T) currentItem.getNext();
                } else {
                    // current item has no next root; insert at the end of the list
                    currentItem.setNext(node).setPrevious(currentItem);
                    return true;
                }
            } else if (compareResult > 0) {
                // current is greater than new
                if (currentItem.hasPrevious()) {
                    // insert before;
                    currentItem.getPrevious().setNext(node).setPrevious(currentItem.getPrevious());
                    node.setNext(currentItem).setPrevious(node);
                } else {
                    // current item is root. Change root to new root
                    node.setNext(this.root).setPrevious(node);
                    this.root = node;
                }
                return false;
            } else
                return false;
        }
        return false;
    }

    @Override
    public int size() {
        int i = 0;
        ListNode currentItem = this.root;
        while (currentItem != null) {
            ++i;
            currentItem = currentItem.getNext();
        }

        return i;
    }

    @Override
    public boolean remove(T node) {
        if (this.root.compareTo(node) == 0) {
            this.root = (T) this.root.getNext();
            return true;
        }

        ListNode nodeToRemove = get(node);
        if (nodeToRemove == null) {
            return false;
        } else {
            return nodeToRemove.remove();
        }
    }

    @Override
    public boolean remove(int index) {
        if (index == 0) {
            this.root = (T) this.root.getNext();
            return true;
        }

        ListNode nodeToRemove = get(index);
        if (nodeToRemove == null) {
            return false;
        } else {
            return nodeToRemove.remove();
        }
    }

    @Override
    public T getRoot() {
        return this.root;
    }

    public T getLast() {
        ListNode currentItem = this.root;

        while(currentItem.hasNext()) {
            currentItem = currentItem.getNext();
        }

        return (T) currentItem;
    }

    @Override
    public T get(int index) {
        int i = 0;
        ListNode currentItem = this.root;
        while(i != index) {
            ++i;
            currentItem = currentItem.getNext();
            if (currentItem == null)
                return null;
        }

        return (T) currentItem;
    }

    @Override
    public T get(ListNode node) {
        ListNode currentItem = this.root;
        while (currentItem.compareTo(node) != 0) {
            currentItem = currentItem.getNext();
            if (currentItem == null)
                return null;
        }

        return (T) currentItem;
    }

    @Override
    public void print() {
        int i = 1;
        ListNode currentItem = this.root;
        while (currentItem != null) {
            System.out.println("[" + i + "]: " + currentItem.toString());
            currentItem = currentItem.getNext();
            ++i;
        }
    }
}
