public abstract class ListNode {
    protected Object value;
    protected ListNode previous = null;
    protected ListNode next = null;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public abstract ListNode getPrevious();
    public abstract ListNode setPrevious(ListNode previous);
    public abstract ListNode getNext();
    public abstract ListNode setNext(ListNode next);
    public abstract boolean hasPrevious();
    public abstract boolean hasNext();
    public abstract int compareTo(ListNode node);

    public boolean remove() {
        if (this.hasNext()) {
            this.getPrevious().setNext(this.getNext())
                    .setPrevious(this.getPrevious());
            return true;
        } else {
            this.getPrevious().setNext(null);
            return true;
        }
    }
}
