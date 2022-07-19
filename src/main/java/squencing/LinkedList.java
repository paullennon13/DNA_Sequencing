package squencing;

public class LinkedList<T> {
    private Node<T> firstNode;
    private  Node<T> lastNode;
    int numEntries = 0;

    LinkedList(T entry){
        Node<T> node = new Node<>(entry);
        firstNode = node;
        lastNode = node;
        numEntries++;
    }

    public void addFirst(T entry){
        Node<T> node = new Node<>(entry);
        node.setNext(firstNode);
        firstNode.setLast(node);
        firstNode = node;
        numEntries++;
    }

    public void addLast(T entry){
        Node<T> node = new Node<>(entry);
        node.setLast(lastNode);
        lastNode.setNext(node);
        lastNode = node;
        numEntries++;
    }

    public void addAtIndex(T entry, int index){
        Node<T> node = firstNode;
        Node<T> newNode = new Node<>(entry);
        Node<T> lastNode;

        if(index > numEntries){
            IndexOutOfBoundsException e = new IndexOutOfBoundsException(index);
            throw new RuntimeException(e);
        }

        for(int i = 0; i < index; i++){
            node = node.getNextNode();
        }
        lastNode = node.getLastNode();
        newNode.setNext(node);
        newNode.setLast(node.getLastNode());
        lastNode.setNext(newNode);
        node.setLast(newNode);

    }

    public T removeFirst(){
        T data = firstNode.getData();
        numEntries--;

        if(firstNode.getNextNode() != null){
            firstNode = firstNode.getNextNode();
            return data;
        }

        firstNode = null;
        lastNode = null;
        return data;
    }

    public T removeLast(){
        T data = lastNode.getData();
        numEntries--;

        if(lastNode.getLastNode() != null){
            lastNode = lastNode.getLastNode();
            lastNode.setNext(null);
            return data;
        }

        firstNode = null;
        lastNode = null;
        return data;
    }

    public T remove(int index){
        Node<T> node = firstNode;
        numEntries--;
        for(int i = 0; i < index; i++){

            if(node.getNextNode() != null){
                node = node.getNextNode();
            }
            else {
                IndexOutOfBoundsException e = new IndexOutOfBoundsException(i);
                throw new RuntimeException(e);
            }
        }
        Node<T> last = node.getLastNode();
        Node<T> next = node.getNextNode();
        last.setNext(next);
        next.setLast(last);
        return node.getData();
    }

    public T remove(T item){
        Node<T> node = firstNode;
        numEntries--;
        for(int i = 0; i < numEntries; i++){
            if(node.getData().equals(item)){
                T data = node.getData();

                Node<T> last = node.getLastNode();
                Node<T> next = node.getNextNode();
                last.setNext(next);
                next.setLast(last);

                return data;
            }
            if(node.getNextNode() != null){
                node = node.getNextNode();
            }
            else {
                IndexOutOfBoundsException e = new IndexOutOfBoundsException(i);
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public int contains(T item){
        Node<T> node = firstNode;
        int index = -1;
        for(int i = 0; i < numEntries; i++){
            if(node.getData().equals(item)){
                index = i;
            }
            if(node.getNextNode() != null){
                node = node.getNextNode();
            }
            else if(node.equals(lastNode)){
                if(node.getData().equals(item)){
                    index = i;
                }
                break;
            }
            else {
                IndexOutOfBoundsException e = new IndexOutOfBoundsException(i);
                throw new RuntimeException(e);
            }
        }
        return index;
    }

    public void clear(){
        firstNode = null;
        lastNode = null;
        numEntries = 0;
    }

    public int getSize(){
        return numEntries;
    }

    public String toString(){
        if(firstNode == null){
            return null;
        }

        StringBuilder string = new StringBuilder();
        Node<T> node = firstNode;

        while(node.getNextNode() != null){
            string.append(node.getData());
            string.append(", ");
            node = node.getNextNode();
        }
        string.append(node.getData());

        return string.toString();
    }

}
