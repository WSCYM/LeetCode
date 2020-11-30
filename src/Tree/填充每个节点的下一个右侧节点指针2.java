package Tree;

import classes.Node;

public class 填充每个节点的下一个右侧节点指针2 {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Node p = root;
        Node tmp = findNext(p);
        while (tmp != null) {
            while (p!=null){
                if (p.left!=null && p.right!=null){
                    p.left.next = p.right;
                    p.right.next = findNext(p.next);
                }
                else if (p.left !=null && p.right==null){
                    p.left.next = findNext(p.next);

                } else if (p.left ==null && p.right!=null){
                    p.right.next = findNext(p.next);
                }
                p = p.next;
            }
            p=tmp;
            tmp = findNext(tmp);
        }
        return root;
    }

    Node findNext(Node q){
        if (q==null) return null;
        while (q!=null){
            if (q.left!=null){
                return q.left;
            }
            if (q.right!=null){
                return q.right;
            }
            q = q.next;
        }
        return null;
    }
}
