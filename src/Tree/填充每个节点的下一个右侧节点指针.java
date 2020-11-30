package Tree;

import classes.Node;

public class 填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Node p = root;
        Node tmp = p.left;
        while (tmp != null) {
            while (p!=null){
                p.left.next = p.right;
                if (p.next!=null){
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            p=tmp;
            tmp = tmp.left;
        }
        return root;
    }
}
