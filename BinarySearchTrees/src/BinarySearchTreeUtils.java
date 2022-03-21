public class BinarySearchTreeUtils {
    /**
     * print all the nodes from given Binary Search Tree indicated by root in ascending order.
     *
     * @param root  the root of the binary search
     */
    public static void inorderTreeWalk(TreeNode root){
        if(root!=null){
            inorderTreeWalk(root.getLeftChild());
            System.out.println(root.getKey());
            inorderTreeWalk(root.getRightChild());
        }
    }

    /**
     * search key in BST indicated by root, if there is a TreeNode has the same value as key,
     * return this TreeNode, otherwise return null.
     *
     * @param root  indicate the BST to be searched for
     * @param key   the key that are looking for
     * @return  the corresponding TreeNode or null if it doesn't exist
     */
    public static TreeNode keySearch(TreeNode root, Integer key){
        if(root==null || root.getKey().equals(key)){
            return root;
        }
        if(key.compareTo(root.getKey())>0){
            return keySearch(root.getRightChild(), key);
        }else{
            return keySearch(root.getLeftChild(), key);
        }
    }

    //iterative
    public static TreeNode keySearch2(TreeNode root, Integer key){
        TreeNode cur = root;
        while(cur!=null && !cur.getKey().equals(key)){
            if(key.compareTo(root.getKey())>0){
                cur = root.getRightChild();
            }else{
                cur = root.getLeftChild();
            }
        }
        return cur;
    }

    /**
     * return the maximum of the BST indicated by root.
     * @param root  the root of the BST to be looked for maximum key
     * @return  the TreeNode which has the biggest key in BST
     */
    public static TreeNode getMinimum(TreeNode root){
        if(root.getLeftChild()==null)   return root;
        return getMinimum(root.getLeftChild());
    }

    //iterative
    public static TreeNode getMinimum2(TreeNode root){
        TreeNode cur = root;
        while(cur.getLeftChild()!=null) cur = cur.getLeftChild();
        return cur;
    }

    /**
     * return the minimum of the BST indicated by root.
     * @param root  the root of the BST to be looked for minimum key
     * @return  the TreeNode which has the smallest key in BST
     */
    public static TreeNode getMaximum(TreeNode root){
        if(root.getRightChild()==null)  return root;
        return getMaximum(root.getRightChild());
    }

    //iterative
    public static TreeNode getMaximum2(TreeNode root){
        TreeNode cur = root;
        while(cur.getRightChild()!=null)    cur = cur.getRightChild();
        return cur;
    }

    /**
     * return the TreeNode which is the successor of x in an inorder tree walk,
     * or null if the given TreeNode is with the biggest key in BST.
     *
     * @param x a TreeNode inside a BST
     * @return  the successor of x in an inorder tree walk
     */
    public static TreeNode getSuccessor(TreeNode x){
        if(x.getRightChild()!=null){
            return getMinimum(x.getRightChild());
        }
        TreeNode y = x.getParent();
        while(y!=null && y.getLeftChild()!=x){
            x = y;
            y = x.getParent();
        }
        return y;
    }

    /**
     * return the TreeNode which is the predecessor of x in an inorder tree walk,
     * or null if the given TreeNode is with the smallest key in BST.
     *
     * @param x a TreeNode inside a BST
     * @return  the predecessor of x in an inorder tree walk
     */
    public static TreeNode getPredecessor(TreeNode x){
        if(x.getLeftChild()!=null){
            return getMaximum(x.getLeftChild());
        }
        TreeNode y = x.getParent();
        while(y!=null && y.getRightChild()!=x){
            x = y;
            y = x.getParent();
        }
        return y;
    }

    /**
     * insert TreeNode x into a BST indicated by its root while maintaining its BST properties.
     * @requires root is not null
     * @param root  the root of the BST to be inserted
     * @param x the TreeNode to insert
     */
    public static void insert(TreeNode root, TreeNode x){
        TreeNode p = root, c = x.getKey().compareTo(p.getKey())<0 ? p.getLeftChild() : p.getRightChild();
        while(c!=null){
            p = c;
            c = x.getKey().compareTo(p.getKey())<0 ? p.getLeftChild() : p.getRightChild();
        }
        x.setParent(p);
        if(x.getKey().compareTo(p.getKey())<0){
            p.setLeftChild(x);
        }else{
            p.setRightChild(x);
        }
    }

    /**
     * move subtrees around within the binary search tree: replace subtree u as a child of its parent
     * with another subtree v.
     * @requires u and v belong to the same BST
     * @requires v is not the ancestor of u
     * @param u the root of a non-empty subtree
     * @param v the root of another non-empty subtree
     */
    public static void transplant(TreeNode u, TreeNode v){
        if(v.getParent().getLeftChild()==v){
            v.getParent().setLeftChild(null);
        }else{
            v.getParent().setRightChild(null);
        }

        if(u.getParent()==null){
            v.setParent(null);
        }else{
            if(u.getParent().getLeftChild()==u){
                u.getParent().setLeftChild(v);
            }else{
                u.getParent().setRightChild(v);
            }
            v.setParent(u.getParent());
        }
    }

    /**
     * delete TreeNode x from the BST it belongs to
     * @param x the TreeNode to be deleted
     */
    public static void delete(TreeNode x){
        if(x.getLeftChild()==null){
            transplant(x, x.getRightChild());
        }else if(x.getRightChild()==null){
            transplant(x, x.getLeftChild());
        }else{
            TreeNode successor = getSuccessor(x);
            if(successor!=x.getRightChild()){
                transplant(successor, successor.getRightChild());
                successor.setRightChild(x.getRightChild());
                x.getRightChild().setParent(successor);
            }
            transplant(x, successor);
            x.getLeftChild().setParent(successor);
            successor.setLeftChild(x.getLeftChild());
        }
    }
}
