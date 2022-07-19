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

    public T removeFirst(){
        T data = firstNode.getData();

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

        if(lastNode.getLastNode() != null){
            lastNode = lastNode.getLastNode();
            return data;
        }

        firstNode = null;
        lastNode = null;
        return data;
    }

    public T remove(int index){
        Node<T> node = firstNode;
        for(int i = 0; i < index; i++){
            if(node.getNextNode() != null){
                node = node.getNextNode();
            }
            else {
                IndexOutOfBoundsException e = new IndexOutOfBoundsException(i);
                throw new RuntimeException(e);
            }
        }
        return node.getData();
    }

    public T remove(T item){
        Node<T> node = firstNode;
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

    public T contains(T item){
        Node<T> node = firstNode;
        for(int i = 0; i < numEntries; i++){
            if(node.getData().equals(item)){
                return node.getData();
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

    public void clear(){
        firstNode = null;
        lastNode = null;
        numEntries = 0;
    }

}
