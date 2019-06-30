public interface NodeList<T> {
    ListNode getRoot();
    boolean add(T node);
    boolean remove(T node);
    boolean remove(int index);
    T get(T node);
    T get(int index);
    int size();
    void print();
}
