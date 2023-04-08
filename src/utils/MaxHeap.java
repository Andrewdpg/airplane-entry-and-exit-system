package utils;

public class MaxHeap<V> extends Heap<Double, V> implements IPriorityQueue<Double, V> {

    public MaxHeap(int size) {
        super(size);
    }

    @Override
    public void heapify(int i) {
        heapify(data, heapSize, i);
    }

    public Node<Double, V>[] gett() {
        return data;
    }

    private void heapify(Node<Double, V>[] array, int heapSize, int index) {
        if (isLeaf(index))
            return;
        int largest = index;
        int left = left(index);
        int right = right(index);
        if (left < heapSize - 1) {
            if (array[largest].getKey().compareTo(array[left].getKey()) < 0) {
                largest = left;
            }
        }
        if (right < heapSize - 1) {
            if (array[largest].getKey().compareTo(array[right].getKey()) < 0) {
                largest = right;
            }
        }
        if (largest != index) {
            exchange(array, largest, index);
            heapify(array, heapSize, largest);
        }
    }

    @Override
    public void buildHeap() {
        buildHeap(data);
    }

    public void buildHeap(Node<Double, V>[] array) {
        for (int i = Math.floorDiv(heapSize, 2); i > 0; i--) {
            heapify(array, heapSize, i - 1);
        }
        data = array;
    }

    @Override
    public Node<Double, V>[] heapSort() {
        int size = heapSize;
        Node<Double, V>[] values = data.clone();
        buildHeap();
        for (int i = size - 1; i >= 2; i--) {
            exchange(values, i, 0);
            size--;
            heapify(values, size, 0);
        }
        return values;
    }

    @Override
    public void insert(Double key, V value) throws IndexOutOfBoundsException {
        if(heapSize >= data.length){
            throw new IndexOutOfBoundsException();
        }
        Node<Double, V> node = new Node<>(key, value);
        heapSize++;
        data[heapSize - 1] = new Node<>(Double.MIN_VALUE, value);
        increaseKey(heapSize - 1, node);
    }

    @Override
    public void increaseKey(int i, Node<Double, V> node) {
        if (data[i] != null) {
            if (node.getKey().compareTo(data[i].getKey()) < 0) {
                return;
            }
        }
        data[i] = node;
        while (i > 0 && data[parent(i)].getKey().compareTo(data[i].getKey()) < 0) {
            exchange(i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public V extract() {
        if (heapSize == 0) {
            return null;
        }
        V max = data[0].getValue();
        heapSize--;
        data[0] = data[heapSize];
        data[heapSize] = null;
        heapify(0);
        return max;
    }
}
