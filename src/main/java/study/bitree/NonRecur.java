package study.bitree;

import java.util.Stack;

public class NonRecur {

    public static void preOrderNonRecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(root);
            while (!stack.empty()) {
                root = stack.pop();
                System.out.print(root.value + " ");
                if (root.right != null) {
                    stack.add(root.right);
                }
                if (root.left != null) {
                    stack.add(root.left);
                }
            }
        }
    }

    public static void inOrderNonRecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.empty() || root != null) {
                if (root != null) {
                    stack.add(root);
                    // 一直向左,把所有左节点放入stack
                    root = root.left;
                } else {// 无右节点
                    // 当第一进入这里时,这个root为最左子节点
                    // 此时可以弹出,然后把指针指向右节点
                    // 弹出后,此时stack最上面节点为父节点
                    root = stack.pop();
                    System.out.print(root.value + " ");
                    // 指向右节点后,继续走上面把左节点入栈
                    root = root.right;
                }
            }
        }
    }

    public static void posOrderNonRecur(Node root) {
        // 输出顺序是 左->右->根,先构造一个stack存放 根->右->左,然后在放入另一个栈,
        if (root != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();

            s1.push(root);
            while (!s1.empty()) {
                // 跟
                root = s1.pop();
                s2.push(root);
                if (root.left != null) {
                    // 左
                    s1.push(root.left);
                }
                if (root.right != null) {
                    // 右
                    s1.push(root.right);
                }
            }

            while (!s2.empty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
    }

    public static void posOrderNonRecurWithOneStack (Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(root);
            Node n;
            while (!stack.empty()) {
                n = stack.peek();
                if (n.left != null && root != n.left && root != n.right) {
                    stack.push(n.left);
                } else if (n.right != null && n.right != root) {
                    stack.push(n.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    root = n;
                }
            }
        }
    }
}
