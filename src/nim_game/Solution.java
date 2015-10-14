/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月14日
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
 * 想一下，假如你是后手，无论对手出几，你都能通过调整自己的牌使得你们的和为一个固定的数，
 * 这个数会是多少？ 是4. 这个应该不难理解。
 * 然后，我们的策略就是你现在是先手，你要通过选择你出的第一张牌后，创造出一种你是后手，同时
 * 你最后一定能达到目标的局面。
 * 因此关键在于你第一次出什么牌。这取决于n，假设你第一次出的x(1<=x<=3)。这个游戏就变成你是后手，
 * n' = n - x的游戏。前面说过了，若n'为x的倍数，你就必然会赢，因为后手的你一定可以在每回合配出
 * 和为4的一次回合。
 * n = x + n'。 x可能为1，2，3.则若n对4取模为 1，2，或3，则先手的你一定会赢，只要你第一次出的x = n % 4.
 * 
 *  当然若n刚好为4的倍数，先手的你一定会输。
 * @author chenshiyang
 * @date 2015年10月14日
 * @time 下午5:02:18
 */
public class Solution {
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}
