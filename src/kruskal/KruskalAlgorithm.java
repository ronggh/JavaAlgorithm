package kruskal;

// 克鲁斯卡尔算法(最小生成树，选边)
public class KruskalAlgorithm {
    //使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵,自身定为0，不连通记为INF
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.

        //KruskalGraph 对象实例
        KruskalGraph graph = new KruskalGraph(vertexs, matrix);
        //输出
        graph.show();

        //
        Edge[] edges = graph.kruskal();
        if (edges != null) {
            //<E,F> <C,D> <D,E> <B,F> <E,G> <A,B>。
            //统计并打印 "最小生成树", 输出  rets
            System.out.println("最小生成树为");
            for (int i = 0; i < edges.length - 1; i++) {
                System.out.println(edges[i]);
            }
        }
    }

}
