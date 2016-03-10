/**
* <p>Title: ConstructBinaryTreeFromPreorderAndInorderTraversal.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 1, 2016
* @version version 1.0
*/
package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>Title: ConstructBinaryTreeFromPreorderAndInorderTraversal</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 1, 2016
 * @time 3:02:29 PM
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        root = buildAndReturnRoot(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }
    
    private TreeNode buildAndReturnRoot(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
    	if(pstart > pend || istart > iend){
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[pstart]);
    	//get root's index in inorder array, can use a hash map to improve this.
//    	int index = Arrays.search(inorder, istart, iend + 1, root.val);
    	int index = search(inorder, istart, iend + 1, root.val);
    	int numLeftChildren = index - istart;
    	int numRightChildren = iend - index;
    	int leftStart = pstart + 1;
    	root.left = buildAndReturnRoot(preorder, leftStart, leftStart + numLeftChildren - 1, inorder, istart, index - 1);
    	int rightStart = pstart + numLeftChildren + 1;
    	root.right = buildAndReturnRoot(preorder, rightStart, rightStart + numRightChildren - 1, inorder, index + 1, iend);
    	return root;
    }
    
    private int search(int[] array, int start, int end, int val){
    	for(int i = start; i < end; i ++){
    		if(array[i] == val){
    			return i;
    		}
    	}
    	return -1;
    }
    
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder==null || inorder==null || preorder.length!=inorder.length || preorder.length==0) { return null; }
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);  // the root of the entire tree
        s.addLast(root);  // also the current root
        for (int p=1, i=0; ;) {
            if (s.peekLast().val != inorder[i]) {  // current root!=current inorder element -- current root's left subtree is not done
                TreeNode left = new TreeNode(preorder[p++]);
                s.peekLast().left = left;
                s.addLast(left);  // push current root's left subtree root into the stack, as the current root
            } else {  //current root==current inorder element -- current root's left subtree is done, should traverse its rightsubtree 
                if (++i >= inorder.length) { break; }
                TreeNode curRoot = s.removeLast();
                if (!s.isEmpty() && s.peekLast().val==inorder[i]) { continue; }
                TreeNode right = new TreeNode(preorder[p++]);
                curRoot.right = right;
                s.addLast(right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal so = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		
/*		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(9);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n7.right = n9;*/
		
//		int[] pre = {5, 3, 2, 1, 4, 7, 6, 8, 9};
//		int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] pre = {1, 2};
		int[] in = {2, 1};
		TreeNode root = so.buildTree(pre, in);
		
		BinaryTreePreorderTraversal prt = new BinaryTreePreorderTraversal();
		
		BinaryTreeInorderTraversal intr = new BinaryTreeInorderTraversal();
		
		BinaryTreePostorderTraversal post = new BinaryTreePostorderTraversal();
		
		System.out.println("Preorder : " + prt.preorderTraversal(root));
		System.out.println("Inorder : " + intr.inorderTraversal(root));
		System.out.println("Postorder : " + post.postorderTraversal(root));
	}
}
