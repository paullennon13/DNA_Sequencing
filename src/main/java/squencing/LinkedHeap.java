package squencing;

// Linked Heap
public class LinkedHeap<T> {
    // data storage
    private LinkedList<T> list;

    // Class constructor
    LinkedHeap(){
        list = new LinkedList<>();
    }

    // Adds entry
    public void add(T entry){
        // Size of list
        int size = list.getSize();

        // If list is empty just add the element
        if (size == 0) {
            list.addFirst(entry);
        }
        // Else add element and sort
        else {
            list.addLast(entry);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapSort(i);
            }
        }
    }

    // deletes given entry
    public void delete(T entry){
        // Gets list size
        int size = list.getSize();
        int i;

        // Finds element in list
        for (i = 0; i < size; i++)
        {
            if (entry.equals(list.get(i)))
                break;
        }

        // Sets element as last in list
        T temp = list.get(i);
        list.set(list.get(size-1), i);
        list.set(temp, size-1);

        // Removes element and sorts heap
        list.remove(size-1);
        for (int j = size / 2 - 1; j >= 0; j--)
        {
            heapSort(j);
        }
    }



    // Sorts heap
    public void heapSort(int i){
        int size = list.getSize();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && (int) list.get(l) > (int) list.get(largest))
            largest = l;
        if (r < size && (int) list.get(r) > (int) list.get(largest))
            largest = r;

        if (largest != i) {
            T temp = list.get(largest);
            list.set(list.get(i), largest);
            list.set(temp, i);

            heapSort(largest);
        }
    }


}
