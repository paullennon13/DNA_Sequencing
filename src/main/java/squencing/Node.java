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
    public void setNext(Node<T> nextNode) {

        if(nextNode == null){
            this.nextNode = null;
        }

        this.nextNode = nextNode;
        nextNode.setLast(this);
    }

    // Links last node
    public void setLast(Node<T> lastNode) {
        this.lastNode = lastNode;
    }

    // Sets User data
    public void setData(T data) {
        this.data = data;
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
        return data.equals(aNode.getData());
    }

}
