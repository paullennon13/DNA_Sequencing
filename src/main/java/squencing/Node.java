package squencing;

// Doubly linked list nodes
public class Node<T> {
    // Nodes
    private Node<T> lastNode, nextNode;
    // User data
    private T data;

    // Class constructor
    Node(T data){
        lastNode = null;
        nextNode = null;
        this.data = data;
    }

    // Links next node
    public boolean setNext(Node<T> nextNode) {
        boolean result = false;

        if(nextNode == null){
            this.nextNode = null;
            return true;
        }

        this.nextNode = nextNode;
        result = nextNode.setLast(this);

        return result;
    }

    // Links last node
    public boolean setLast(Node<T> lastNode) {
        boolean result = false;

        this.lastNode = lastNode;

        if(this.lastNode.equals(lastNode)) {
            result = true;
        }

        return result;
    }

    // Sets User data
    public boolean setData(T data) {
        boolean result = false;

        this.data = data;

        if(this.data.equals(data)) {
            result = true;
        }

        return result;
    }

    // Gets next node
    public Node<T> getNextNode(){
        return nextNode;
    }

    // Gets last node
    public Node<T> getLastNode(){
        return lastNode;
    }

    // Gets data
    public T getData(){
        return data;
    }

    // Checks if two nodes have the same data
    public boolean equals(Node<T> aNode) {
        if(data.equals(aNode.getData())) {
            return true;
        }
        else {
            return false;
        }
    }

}
