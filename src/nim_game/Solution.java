/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��14��
* @version jdk8.0
*/
package nim_game;

/**
 * <p>Title: Solution</p>
 * <p>Description: You are playing the following Nim Game with your friend: 
 * There is a heap of stones on the table, each time one of you take turns 
 * to remove 1 to 3 stones. The one who removes the last stone will be the 
 * winner. You will take the first turn to remove the stones.Both of you are 
 * very clever and have optimal strategies for the game. Write a function to 
 * determine whether you can win the game given the number of stones in the 
 * heap.For example, if there are 4 stones in the heap, then you will never 
 * win the game: no matter 1, 2, or 3 stones you remove, the last stone will 
 * always be removed by your friend.</p>
 * ��һ�£��������Ǻ��֣����۶��ֳ������㶼��ͨ�������Լ�����ʹ�����ǵĺ�Ϊһ���̶�������
 * ��������Ƕ��٣� ��4. ���Ӧ�ò�����⡣
 * Ȼ�����ǵĲ��Ծ��������������֣���Ҫͨ��ѡ������ĵ�һ���ƺ󣬴����һ�����Ǻ��֣�ͬʱ
 * �����һ���ܴﵽĿ��ľ��档
 * ��˹ؼ��������һ�γ�ʲô�ơ���ȡ����n���������һ�γ���x(1<=x<=3)�������Ϸ�ͱ�����Ǻ��֣�
 * n' = n - x����Ϸ��ǰ��˵���ˣ���n'Ϊx�ı�������ͱ�Ȼ��Ӯ����Ϊ���ֵ���һ��������ÿ�غ����
 * ��Ϊ4��һ�λغϡ�
 * n = x + n'�� x����Ϊ1��2��3.����n��4ȡģΪ 1��2����3�������ֵ���һ����Ӯ��ֻҪ���һ�γ���x = n % 4.
 * 
 *  ��Ȼ��n�պ�Ϊ4�ı��������ֵ���һ�����䡣
 * @author chenshiyang
 * @date 2015��10��14��
 * @time ����5:02:18
 */
public class Solution {
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}
