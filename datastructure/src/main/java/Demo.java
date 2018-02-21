import com.structure.LinkedList;
import com.structure.impl.SinglyLinkedList;

public class Demo {

    public static void main(String[] args) {
        LinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();

        singlyLinkedList.append(1);
//        singlyLinkedList.append(2);
//        singlyLinkedList.append(3);
//        singlyLinkedList.append(4);
//        singlyLinkedList.append(5);
        System.out.println(singlyLinkedList.size());

        singlyLinkedList.remove();

        System.out.println(singlyLinkedList.size());

//        singlyLinkedList.removeGreaterThan(0);
//        System.out.println("-----------------------");
//        System.out.println(singlyLinkedList.size());
    }
}