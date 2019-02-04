/**
 * A binary tree node
 * a node consists of a key, and probably a right subtree denoted as 'right'
 * and a left subtree denoted as 'left'
 */
class Node {

    int key;
    Node left, right;

    Node(int k) {
        key = k;
        left = right = null;
    }
}


public class BalancedBST {


    static Node root;

    /**
     * Convert a sorted array into a binary search tree
     * @param keyArray - a sorted array to be converted to a Binary search tree
     * @param start - start index of the array
     * @param end - last index of the array
     * @return a Node
     */

    Node sortedArrayToBST(int[] keyArray, int start, int end){
        // base case
        if (end < start){
            return null;
        }

        int mid = (start + end)/2;
        Node node = new Node(keyArray[mid]);//root node

        //recursively build the left sub-tree
        node.left = sortedArrayToBST(keyArray, start, mid-1);

        //recursively build the right sub-tree
        node.right = sortedArrayToBST(keyArray, mid+1, end);

        return node;

    }

    //preorder traversal; root->left-> right
    public void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.key +"\t");
        preOrder(node.left);
        preOrder(node.right);

    }

    public static void main(String[] args){

        BalancedBST balancedBST = new BalancedBST();

        //a sorted array
        int[] numArray = new int[]{5, 6, 7, 8, 10};

        root = balancedBST.sortedArrayToBST(numArray, 0, numArray.length-1);

        System.out.println("Preorder traversal");
        balancedBST.preOrder(root);

    }
}
