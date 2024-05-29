package DSA.Tree;

/**
 * refer https://www.geeksforgeeks.org/batch/interview-101-9/track/DSASP-Tree/article/NzY0MQ%3D%3D
 */
public class BurnATreeFromLeaf {
    int distance;
    public int calculateBurnTime(Node root, int leaf) {
        if(root.data == leaf) return 0;
        int ldistance = (root.left != null) ? calculateBurnTime(root.left, leaf) : 0;
        int rdistance = (root.right != null) ? calculateBurnTime(root.right, leaf) : 0;
        distance = Math.max(distance, 1 +  ldistance + rdistance);
        return 1 + Math.max(ldistance, rdistance);
    }
    public int burnTime(Node root, int leaf) {
        distance = 0;
        calculateBurnTime(root, leaf);
        return distance;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.left.left = new Node(8);
		root.left.right.left = new Node(9);
		root.left.right.right = new Node(10);
		root.left.right.left.left = new Node(11);

        System.out.println(new BurnATreeFromLeaf().burnTime(root, 11));
    }
}
