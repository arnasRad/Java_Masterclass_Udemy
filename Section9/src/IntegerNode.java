public class IntegerNode extends ListNode {
    public IntegerNode(int value) {
        this.value = value;
    }

    @Override
    public ListNode getPrevious() {
        return this.previous;
    }

    @Override
    public ListNode setPrevious(ListNode previous) {
        return this.previous = previous;
    }

    @Override
    public ListNode getNext() {
        return this.next;
    }

    @Override
    public ListNode setNext(ListNode next) {
        return this.next = next;
    }

    @Override
    public boolean hasPrevious() {
        return previous != null;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public int compareTo(ListNode node) {
        int thisValue = (Integer) getValue();
        int otherValue = (Integer)node.getValue();
        if (thisValue < otherValue)
            return -1;
        else if (thisValue > otherValue)
            return 1;
        else
            return 0;
        //return Integer.compare(otherValue, thisValue);
    }
}
