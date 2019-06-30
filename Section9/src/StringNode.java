public class StringNode extends ListNode {
    public StringNode(String value) {
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
        return (String) value;
    }

    @Override
    public int compareTo(ListNode node) {
        return ((String) getValue()).compareTo((String) node.getValue());
    }
}
