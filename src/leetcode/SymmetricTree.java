/**
* <p>Title: SymmetricTree.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月26日
* @version jdk8.0
*/
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: SymmetricTree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月26日
 * @time 下午3:08:54
 */
public class SymmetricTree {
    /**
    * <p>Description: 使用两个队列，迭代。</p>
    * @param root
    * @return
    */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftq = new LinkedList<TreeNode>();
        Queue<TreeNode> rightq = new LinkedList<TreeNode>();
        
        if(null == root || (null == root.left && null == root.right)) return true;
        leftq.add(root);
        rightq.add(root);
        while(leftq.size() != 0 && rightq.size() != 0){
        	TreeNode left = leftq.poll();
        	TreeNode right = rightq.poll();
        	if(null == left && null == right) continue;//if both null node.
        	if(null == left || null == right || left.val != right.val) return false;
        	leftq.add(left.left);
        	leftq.add(left.right);
        	
        	rightq.add(right.right);
        	rightq.add(right.left);
        }
        return leftq.size() == rightq.size();
    }
    
    // solution 2 : recursive 
    public boolean isSymmetric2(TreeNode root) {
    	return breadthFirstSearch(root, root);
    }
    
    private boolean breadthFirstSearch(TreeNode leftRoot, TreeNode rightRoot){
    	if(null == leftRoot && null == rightRoot) return true;
    	if(null == leftRoot || null == rightRoot || leftRoot.val != rightRoot.val) return false;
    	
    	return breadthFirstSearch(leftRoot.left, rightRoot.right) && breadthFirstSearch(leftRoot.right, rightRoot.left);
    }
    
    public static void main(String[] args) {
		SymmetricTree so = new SymmetricTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n7.right = n9;
		
		System.out.println(so.isSymmetric(n1) == true);
		System.out.println(so.isSymmetric(n2) == false);
		System.out.println(so.isSymmetric(n3) == false);
		System.out.println(so.isSymmetric(n9) == true);
		System.out.println(so.isSymmetric(null) == true);
		
		System.out.println(so.isSymmetric2(n1) == true);
		System.out.println(so.isSymmetric2(n2) == false);
		System.out.println(so.isSymmetric2(n3) == false);
		System.out.println(so.isSymmetric2(n9) == true);
		System.out.println(so.isSymmetric2(null) == true);
	}
}
