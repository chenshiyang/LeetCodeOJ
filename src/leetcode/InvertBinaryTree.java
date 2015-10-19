/**
* <p>Title: InvertBinaryTree.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: InvertBinaryTree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 上午8:46:47
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        depthFirstSearch(root);
        return root;
    }
    
    private void depthFirstSearch(TreeNode node){
    	if(node == null) return;
    	//invert
    	TreeNode temp = node.left; node.left = node.right; node.right = temp;
    	
    	//recursive traverse
    	depthFirstSearch(node.left);
    	depthFirstSearch(node.right);
    	return;
    }
    
    public void display(TreeNode node){
    	if(node == null) return;

    	if(node.left != null)
    		System.out.println(node.left.val);
    	else
    		System.out.println("null");
    	if(node.right != null)
    		System.out.println(node.right.val);
    	else
    		System.out.println("null");
    	
    	display(node.left);
    	display(node.right);
    }
    
    public static void main(String[] args) {
		InvertBinaryTree ibt = new InvertBinaryTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n9;
		n4.right = n7;
		n6.left = n10;
		n6.right = n8;
		
		ibt.display(n1);
		ibt.invertTree(n1);
		System.out.println("After invert");
		ibt.display(n1);
	}
}
