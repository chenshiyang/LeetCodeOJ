/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 上午10:02:20
 */
public class Solution {
	 class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	 
	public List<String> binaryTreePaths(TreeNode root) {
	        List<String> paths = new ArrayList<String>();
	        if(root != null)
	        	depthFirstSearch(root, paths, "");
	        return paths;
	}
	
	private List<String> depthFirstSearch(TreeNode root, List<String> paths, String path){
		if(root.left == null && root.right == null){//thi is a leave
			String p = path + root.val;
			paths.add(p);
			return paths;
		}
		if(root.left != null){
			depthFirstSearch(root.left, paths, path + root.val + "->");
		}
		if(root.right != null){
			depthFirstSearch(root.right, paths, path + root.val + "->");
		}
		return paths;
	}
	
	public static void main(String[] args) {
		Solution so = new Solution();
		TreeNode n1 = so.new TreeNode(1);
		TreeNode n2 = so.new TreeNode(2);
		TreeNode n3 = so.new TreeNode(3);
		TreeNode n4 = so.new TreeNode(4);
		TreeNode n5 = so.new TreeNode(5);
		TreeNode n6 = so.new TreeNode(6);
		TreeNode n7 = so.new TreeNode(7);
		TreeNode n8 = so.new TreeNode(8);
		TreeNode n9 = so.new TreeNode(9);
		TreeNode n10 = so.new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n9;
		n4.right = n7;
		n6.left = n10;
		n6.right = n8;
	
		System.out.println(so.binaryTreePaths(n1));
		System.out.println(so.binaryTreePaths(n9));
	}
}
