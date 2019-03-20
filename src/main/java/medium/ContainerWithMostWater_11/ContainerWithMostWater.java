package medium.ContainerWithMostWater_11;

/**
 * @author : tom
 * @date : 2019-03-20 20:02
 **/
public class ContainerWithMostWater {

    /**
     * 11
     *
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
     *
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     */

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
            if (height[left] > height[right]) {
                // 左边比较高,希望找一个更高的,所以让右边
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
