/**
* <p>Title: RectangleArea.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: RectangleArea</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 上午10:21:35
 */
public class RectangleArea {
    /**
    * <p>Description: 横坐标的4个值是 A C E G 
    * 纵坐标的4个值是 B D F H。
    * 相当于要找出横坐标中间的2个值， 纵坐标中间的2个值。
    * 一开始理解错了，以为是求相交面积，实质是求覆盖面积。
    * 覆盖面积 = 2个矩形面积 - 相交面积</p>
    * @param A
    * @param B
    * @param C
    * @param D
    * @param E
    * @param F
    * @param G
    * @param H
    * @return
    */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //如果没有交叉，则面积为2个矩形之和
    	int area = Math.abs(A - C) * Math.abs(B - D) + Math.abs(E - G) * Math.abs(F - H);
    	if(C <= E || D <= F || G <= A || H <= B) return area;
    	
    	//else C > E and D > F and G > A AND H > B, 左下坐标<=右上坐标。
    	//综合有 A, E < C; A,E < G， 横坐标取 | max(A, E), min(C, G)|
    	//B, F < D; B, F < H, 纵坐标取|max(B, F), min(D, H)|
    	return area - Math.abs(Math.max(A, E) - Math.min(C, G)) * Math.abs(Math.max(B, F) - Math.min(D, H));
    }
    
    public static void main(String[] args) {
		RectangleArea so = new RectangleArea();
		System.out.println(so.computeArea(0, 0, 0, 0, -1, -1, 1, 1));
	}
}
