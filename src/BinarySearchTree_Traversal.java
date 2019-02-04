// Java program to demonstate traversal operation on a binary serach tree
class BinarySearchTree_Traversal {

    /* Class containing left and right child of current node and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of binary search tree
    Node root;

    // Constructor
    BinarySearchTree_Traversal() {

        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {

        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    //wrappers over the recursive methods
    void inorder() {

        inorderRec(root);
    }
    void preorder(){
        preorderRecursion(root);
    }
    void postorder(){
        postorderRecursion(root);
    }

    //postorder traversal
    private void postorderRecursion(Node root) {
        if (root!=null){
            postorderRecursion(root.left);
            postorderRecursion(root.right);
            System.out.print(root.key+"\t");
        }

    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {

        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key +"\t");
            inorderRec(root.right);
        }
    }

    //preorder traversal
    void preorderRecursion(Node root){
        if (root!=null){
            System.out.print(root.key +"\t");
            preorderRecursion(root.left);
            preorderRecursion(root.right);
        }

    }


    public static void main(String[] args) {
        BinarySearchTree_Traversal tree = new BinarySearchTree_Traversal();

		/* Let us create following BST
			40
		/	    \
		20	     70
		/ \     /   80\
	   10  25   60
	        \    /
	         30  50   */
        tree.insert(40);//root node
        tree.insert(80);
        tree.insert(30);
        tree.insert(20);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(10);
        tree.insert(25);



        // print inorder traversal of the BST
        System.out.println("Inorder traversal");
        tree.inorder();

        System.out.println("\n---------------------------------------------");
        //preorder traversal
        System.out.println("Preorder traversal");
        tree.preorder();

        System.out.println("\n---------------------------------------------");
        System.out.println("Postorder traversal");
        tree.postorder();
    }
}

