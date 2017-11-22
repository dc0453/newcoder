package newcoder;

/**
 * https://www.nowcoder.com/ta/coding-interviews
 * 二维数组中的查找
 *
 * @author: diwenchen
 * @since: 2017/11/21 下午6:20
 */
public class Solution {
    /**
     * 从右上角开始找，小于则砍掉最右列，大于则砍掉第一行
     * 递归方式复杂度o(m+n)
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        boolean result = false;
        int xLength = array.length;
        if (xLength == 0 ) {
            return result;
        }
        int yLength = array[0].length;
        if (yLength == 0) {
            return result;
        }
        int last = array[0][yLength - 1];
        if (target == last) {
            result = true;
        } else if (target < last) {
            return Find(target, removeLastcolumnArray(array));
        } else {
            return Find(target, removeFirstRowArray(array));
        }
        return result;
    }

    public int[][] removeLastcolumnArray(int[][] source) {
        int[][] destination = new int[source.length][source[0].length - 1];
        for (int i = 0; i < source.length; ++i) {
            System.arraycopy(source[i],0, destination[i], 0, source[i].length - 1);
        }
        return destination;
    }

    public int[][] removeFirstRowArray(int[][] source) {
        int[][] destination = new int[source.length - 1][source[0].length];
        System.arraycopy(source,1, destination, 0, source.length - 1);
        return destination;
    }


    /**
     * 从右上角开始找，小于则砍掉最右列，大于则砍掉第一行
     * 循环方式复杂度o(m+n)
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int [][] array) {
        boolean result = false;
        int row = 0;
        int column = array[row].length - 1;

        while (row < array.length && column >= 0) {
            int last = array[row][column];
            if (target == last) {
                result = true;
                break;
            } else if (target < last) {
                column--;
            } else {
                row++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 16;
        Solution s = new Solution();
        boolean result = s.Find2(target, array);
        System.out.println(result);
    }
}
