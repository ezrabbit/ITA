public class TreeNode {
    private Integer key;
    private TreeNode parent;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(Integer key, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
        this.key = key;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        String key, parent, left, right;
        key = getKey().toString();
        if(getParent()!=null){
            parent = "parent=" + getParent().getKey();
        }else{
            parent= "parent=null";
        }
        if(getLeftChild()!=null){
            left = "left=" + getLeftChild().getKey();
        }else{
            left = "left=null";
        }
        if(getRightChild()!=null){
            right = "right=" + getRightChild().getKey();
        }else{
            right = "right=null";
        }

        return key + ", " + parent + "," + left + "," + right;
    }
}
