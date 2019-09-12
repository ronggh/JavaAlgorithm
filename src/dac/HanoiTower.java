package dac;

// 分治算法
public class HanoiTower {
    //
    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
    }

    /**
     * 使用分治算法，解决汉诺塔的移动的方法
     * @param num：盘数
     * @param a：源柱
     * @param b：中转柱
     * @param c：目标柱
     **/
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //如果有 n >= 2 情况，总是可以看做是两个盘：
            // 1）最下边的一个盘
            // 2) 上面的其它所有盘看成一个整体,递归调用
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
            hanoiTower(num - 1, a, c, b);
            //2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
