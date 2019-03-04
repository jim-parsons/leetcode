package study.bitree;

import org.junit.Test;

import static study.bitree.NonRecur.*;
import static study.bitree.Recur.inOrderRecur;
import static study.bitree.Recur.preOrderRecur;

public class BiTreeTest {

    public static Node root = new Node(1);

    static {
        root.left = new Node(2);
        root.right = new Node(3);
    }

    @Test
    public void testRecur() {
        preOrderRecur(root);
        System.out.println();
        inOrderRecur(root);
        System.out.println();
        preOrderRecur(root);
    }

    @Test
    public void testNonRecur() {
        preOrderNonRecur(root);
        System.out.println();
        inOrderNonRecur(root);
        System.out.println();
        posOrderNonRecur(root);
        System.out.println();
        posOrderNonRecurWithOneStack(root);
    }

}
