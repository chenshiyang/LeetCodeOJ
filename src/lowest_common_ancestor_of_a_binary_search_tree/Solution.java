/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package lowest_common_ancestor_of_a_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 下午2:58:41
 */
public class Solution {
	class TreeNode {
	int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		
		public String toString(){
			return this.val + "";
		}
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(search(p, q))
        	return p;
        if(search(q, p))
        	return q;
        
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        //get a path from root to p.
        searchPath(root, p, path);
        //nodes in path list are all p's ancestors.
        TreeNode ancestor = null;
        for(int i = path.size() - 1; i >= 0; i --){
        	ancestor = path.get(i);
        	if(search(ancestor, q))
        		break;
        }
        return ancestor;
        
    }
    
    private boolean searchPath(TreeNode root, TreeNode target, ArrayList<TreeNode> paths){
    	if(root == null)
    		return false;
    	//add current node into path(root)
    	paths.add(root);
    	if(root == target)
    		return true;
    	boolean has = searchPath(root.left, target, paths) || searchPath(root.right, target, paths);
    	if(!has)
    		paths.remove(paths.size() - 1);
    	return has; 	
    }
    
    /**
    * <p>Description: Search if target node is the descendant of root node.</p>
    * @param root
    * @param target
    * @return
    */
    private boolean search(TreeNode root, TreeNode target){
    	if(root == null) return false;
    	if(root.left == target || root.right == target)
    		return true;

    	return search(root.left, target) || search(root.right, target);    	
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
		
		System.out.println(so.lowestCommonAncestor(n1, n8, n4));
		System.out.println(so.lowestCommonAncestor(n1, n1, n9));
		System.out.println(so.lowestCommonAncestor(n1, n5, n2));
		System.out.println(so.lowestCommonAncestor(n1, n5, n7));
		System.out.println(so.lowestCommonAncestor(n1, n8, n10));
		System.out.println(so.lowestCommonAncestor(n1, n10, n8));
		
	}
}
