import org.junit.Test;

public class TestBST {
    @Test
    public void test(){
        /*
                            6
                          /   \
                        1)5   2)7
                        / \     \
                      3)2  4)5   5)8
         */
        TreeNode root = new TreeNode(6);
        TreeNode node1, node2, node3, node4, node5;
        BinarySearchTreeUtils.insert(root, (node1 = new TreeNode(5)));
        BinarySearchTreeUtils.insert(root, (node2 = new TreeNode(7)));
        BinarySearchTreeUtils.insert(root, (node3 = new TreeNode(2)));
        BinarySearchTreeUtils.insert(root, (node4 = new TreeNode(5)));
        BinarySearchTreeUtils.insert(root, (node5 = new TreeNode(8)));

//        BinarySearchTreeUtils.transplant(node1, node3);
//        BinarySearchTreeUtils.inorderTreeWalk(root);

//        BinarySearchTreeUtils.delete(node2);
//        System.out.println(root);
//        System.out.println("****");
//        BinarySearchTreeUtils.inorderTreeWalk(root);

//        BinarySearchTreeUtils.delete(node1);
//        System.out.println(node4);
//        System.out.println("****");
//        BinarySearchTreeUtils.inorderTreeWalk(root);

//        BinarySearchTreeUtils.delete(root);
//        BinarySearchTreeUtils.inorderTreeWalk(node2);

//        System.out.println(BinarySearchTreeUtils.keySearch(root, 8));
//        System.out.println(BinarySearchTreeUtils.keySearch2(root, 7));

//        System.out.println(BinarySearchTreeUtils.getMaximum2(root));
//        System.out.println(BinarySearchTreeUtils.getMaximum(root));
//        System.out.println(BinarySearchTreeUtils.getMinimum2(root));
//        System.out.println(BinarySearchTreeUtils.getMinimum(root));


//        System.out.println(BinarySearchTreeUtils.getSuccessor(node1));
//        System.out.println(BinarySearchTreeUtils.getSuccessor(node4));
//        System.out.println(BinarySearchTreeUtils.getPredecessor(node1));
//        System.out.println(BinarySearchTreeUtils.getPredecessor(node3));

    }
}
