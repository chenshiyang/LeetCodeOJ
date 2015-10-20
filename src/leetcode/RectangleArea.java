/**
* <p>Title: RectangleArea.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��19��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: RectangleArea</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��19��
 * @time ����10:21:35
 */
public class RectangleArea {
    /**
    * <p>Description: �������4��ֵ�� A C E G 
    * �������4��ֵ�� B D F H��
    * �൱��Ҫ�ҳ��������м��2��ֵ�� �������м��2��ֵ��
    * һ��ʼ�����ˣ���Ϊ�����ཻ�����ʵ�����󸲸������
    * ������� = 2��������� - �ཻ���</p>
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
        //���û�н��棬�����Ϊ2������֮��
    	int area = Math.abs(A - C) * Math.abs(B - D) + Math.abs(E - G) * Math.abs(F - H);
    	if(C <= E || D <= F || G <= A || H <= B) return area;
    	
    	//else C > E and D > F and G > A AND H > B, ��������<=�������ꡣ
    	//�ۺ��� A, E < C; A,E < G�� ������ȡ | max(A, E), min(C, G)|
    	//B, F < D; B, F < H, ������ȡ|max(B, F), min(D, H)|
    	return area - Math.abs(Math.max(A, E) - Math.min(C, G)) * Math.abs(Math.max(B, F) - Math.min(D, H));
    }
    
    public static void main(String[] args) {
		RectangleArea so = new RectangleArea();
		System.out.println(so.computeArea(0, 0, 0, 0, -1, -1, 1, 1));
	}
}
