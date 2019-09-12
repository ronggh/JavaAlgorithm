package floyd;

import java.util.Arrays;

// 弗洛伊德算法(最短路径问题) floyd
public class FloydGraph {
    private char[] vertex; // 存放顶点的数组
    private int[][] dis; // 保存，从各个顶点出发到其它顶点的距离，最后的结果，也是保留在该数组
    private int[][] pre;// 保存到达目标顶点的前驱顶点

    /**
     * 构造器
     * @param matrix,,邻接矩阵
     * @param vertex,顶点数组
     */
    public FloydGraph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.dis = matrix;
        int length = vertex.length;
        this.pre = new int[length][length];
        // 对pre数组初始化, 注意存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    // 显示pre数组和dis数组
    public void show(char[] vertex) {
        for (int i= 0; i < dis.length; i++) {
            // 先将pre数组输出的一行
            for (int j = 0; j < dis.length; j++) {
                System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();
            // 输出dis数组的一行数据
            for (int j = 0; j < dis.length; j++) {
                System.out.print("[" + vertex[i] + "-" + vertex[j] + "(" + dis[i][j] + ")] ");
            }
            System.out.println();
            System.out.println();
        }
    }

    //弗洛伊德算法, 比较容易理解，而且容易实现，三层循环实现
    public void floyd() {
        int len = 0; //变量保存距离
        //对中间顶点遍历， k 就是中间顶点的下标 [A, B, C, D, E, F, G]
        for (int k = 0; k < dis.length; k++) { //
            //从i顶点开始出发 [A, B, C, D, E, F, G]
            for (int i = 0; i < dis.length; i++) {
                //到达j顶点 // [A, B, C, D, E, F, G]
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];// => 求出从i 顶点出发，经过 k中间顶点，到达 j 顶点距离
                    //如果len小于 dis[i][j]
                    if (len < dis[i][j]) {
                        dis[i][j] = len;//更新距离
                        pre[i][j] = pre[k][j];//更新前驱顶点
                    }
                }
            }
        }
    }
}
