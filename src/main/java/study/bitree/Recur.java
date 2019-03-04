package study.bitree;

/**
 * @author : tom
 * @date : 2019-03-04 16:20
 **/
public class Recur {

    public static void preOrderRecur (Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void inOrderRecur (Node root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.value + " ");
        inOrderRecur(root.right);
    }

    public static void posOrderRecur (Node root) {
        if (root == null) {
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.value + " ");
    }

}
