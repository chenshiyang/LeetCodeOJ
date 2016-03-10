/**
* <p>Title: BinaryTreePaths.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 10, 2016
* @version version 1.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Title: BinaryTreePaths</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 10, 2016
 * @time 10:31:43 AM
 */
public class BinaryTreePaths {
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
	BinaryTreePaths so = new BinaryTreePaths();
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

	System.out.println(so.binaryTreePaths(n1));
	System.out.println(so.binaryTreePaths(n9));
}
}
