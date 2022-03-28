package homework;


import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class sumYinRangeX {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input the disk path of your dateJ file:");
        String dataJName = scanner.nextLine();
        System.out.print("please input the disk path of your rangeJ file:");
        String rangeJName = scanner.nextLine();
        Scanner dataJ = null, rangeJ = null;
        BinarySearchTree bst = new BinarySearchTree();
        int x, y, a, b;
        try {
            URL dataJPath = sumYinRangeX.class.getResource(dataJName + ".txt");
            URL rangeJPath = sumYinRangeX.class.getResource(rangeJName + ".txt");
            dataJ  = new Scanner(new File(dataJPath.getFile()));
            rangeJ  = new Scanner(new File(rangeJPath.getFile()));

            while(dataJ.hasNextInt()){
                x = dataJ.nextInt();
                y = dataJ.nextInt();
                insert(bst, x, y);
            }

            while(rangeJ.hasNextInt()){
                a = rangeJ.nextInt();
                b = rangeJ.nextInt();
                int sum = btreeSumYinRange(bst, a, b);
                System.out.println(a + " " + b + " " + sum);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(dataJ!=null) {
                try {
                    dataJ.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(rangeJ!=null){
                try {
                    rangeJ.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insert(BinarySearchTree bst, int x, int y){
        Node newNode = new Node(x, y);
        newNode.sum = y;
        if(bst.root == null){
            bst.root = newNode;
        }else{
            Node p = bst.root, c = x >= p.x ? p.right : p.left;
            p.sum+=y;
            while(c!=null){
                p = c;
                c = x >= p.x ? p.right : p.left;
                p.sum+=y;
            }
            if(x>=p.x){
                p.right = newNode;
                newNode.parent = p.right;
            }else{
                p.left = newNode;
                newNode.parent = p.left;
            }
        }
    }

    public static int btreeSumYinRange(BinarySearchTree bst, int a, int b){
        Node root = bst.root, cur = root;
        if(root == null)    return 0;
        while(cur!=null && (cur.x < a || cur.y > b)){
            if(cur.x < a){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        if(cur == null) return 0;

        int sum = cur.sum;

        Node tmp = cur;
        int sumGreaterThanA = cur.sum;
        while(tmp!=null){
            if(tmp.x > a){
                tmp = tmp.left;
            }else if(tmp.x < a){
                sumGreaterThanA -= tmp.y;
                if(tmp.left!=null)  sumGreaterThanA -= tmp.left.sum;
                tmp = tmp.right;
            }else{
                if(tmp.left!=null)  sumGreaterThanA -= tmp.left.sum;
                break;
            }
        }

        tmp = cur;
        int sumSmallerThanB = cur.sum;
        while(tmp!=null){
            if(tmp.x > b){
                sumSmallerThanB -= tmp.y;
                if(tmp.right!=null) sumSmallerThanB -= tmp.right.sum;
                tmp = tmp.left;
            }else if(tmp.x < b){
                tmp = tmp.right;
            }else{
                if(tmp.right!=null) sumSmallerThanB -= tmp.right.sum;
                break;
            }
        }

        return sumGreaterThanA + sumSmallerThanB - sum;
    }
}
