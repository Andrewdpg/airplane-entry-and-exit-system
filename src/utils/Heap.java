package utils;

public abstract class Heap<K extends Comparable<K>,V> {

    protected Node<K, V>[] data;
    protected int heapSize;

    @SuppressWarnings("unchecked")
    public Heap(int size) {
        this.heapSize = 0;
        this.data = (Node<K, V>[]) new Node[size];
    }

    public Heap() {

    }

    public int size(){
        return heapSize;
    }

    protected abstract void heapify(int i);

    protected abstract void buildHeap();

    public abstract Node<K, V>[] heapSort();

    protected int right(int i) {
        return (2 * (i + 1));
    }

    protected int left(int i) {
        return (2 * (i + 1)) - 1;
    }

    protected int parent(int i) {
        return (int) Math.floor(i / 2);
    }

    protected void exchange(int a, int b) {
        Node<K, V> temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    protected void exchange(Node<K,V>[]array,int a, int b) {
        Node<K, V> temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    protected boolean isLeaf(int index){
        return right(index) >= heapSize && left(index) >= heapSize;
    }
}
