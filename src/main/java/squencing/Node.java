package squencing;

public class Node<T> {
    private Node<T> lastNode;
    private Node<T> nextNode;
    private T data;

    Node(T data, Node<T> nextNode){
        lastNode = null;
        this.nextNode = nextNode;
        this.data = data;
    }

    Node(T data){
        lastNode = null;
        nextNode = null;
        this.data = data;
    }

    public boolean setNext(Node<T> nextNode) {
        boolean result = false;

        this.nextNode = nextNode;
        result = nextNode.setLast(this);

        return result;
    }

    protected boolean setLast(Node<T> lastNode) {
        boolean result = false;

        this.lastNode = lastNode;

        if(this.lastNode.equals(lastNode)) {
            result = true;
        }

        return result;
    }

    public boolean setData(T data) {
        boolean result = false;

        this.data = data;

        if(this.data.equals(data)) {
            result = true;
        }


        return result;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public Node<T> getLastNode(){
        return lastNode;
    }

    public T getData(){
        return data;
    }

    public boolean equals(Node<T> aNode) {
        if(data.equals(aNode.getData())) {
            return true;
        }
        else {
            return false;
        }
    }

}
