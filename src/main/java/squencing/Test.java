package squencing;

public class Test {

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>("testing");
        list.addLast("my");
        list.addLast("list");
        list.addFirst("I");
        list.addAtIndex("am", 1);
        System.out.println(list);
        System.out.println(list.contains("my"));
        System.out.println(list.getSize());
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.getSize());
        list.clear();
        System.out.println(list);
    }

}
