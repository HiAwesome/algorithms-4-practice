/**
 * @author moqi
 * On 5/23/20 19:03
 */

public class P092LinkedList {

    /**
     * to be or not to be
     */
    public static void main(String[] args) {
        Node to1 = new Node("to", new Node("be", new Node("or",
                new Node("not", new Node("to", new Node("be"))))));

        for (Node x = to1; x != null; x = x.getNext()) {
            System.out.print(x.getItem() + " ");
        }
    }

}

class Node {
    private String item;
    private Node next;

    public Node(String item) {
        this.item = item;
    }

    public Node(String item, Node next) {
        this.item = item;
        this.next = next;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
