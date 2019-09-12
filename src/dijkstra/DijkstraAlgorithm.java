package dijkstra;

// 迪杰斯特拉算法(最短路径问题) dijkstra
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = VisitedVertex.NO_ARRIVAL;// 表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        //创建 Graph对象
        DijkstraGraph graph = new DijkstraGraph(vertex, matrix);
        //显示图的邻接矩阵
        graph.show();

        // 杰斯特拉算法,结果：A(7) B(12) C(0) D(17) E(8) F(13) G(9)
        VisitedVertex vv = graph.dijkstra(2);
        vv.show(vertex);


    }


}
