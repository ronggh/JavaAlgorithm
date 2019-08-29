package prim;

public class PrimAlgorithm {
    //
    private static final int INF = Integer.MAX_VALUE;

    //
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        //邻接矩阵的关系使用二维数组表示,INF这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {INF,5,7,INF,INF,INF,2},
                {5,INF,INF,9,INF,INF,3},
                {7,INF,INF,INF,8,INF,INF},
                {INF,9,INF,INF,INF,4,INF},
                {INF,INF,8,INF,INF,5,4},
                {INF,INF,INF,4,5,INF,6},
                {2,3,INF,INF,4,6,INF},};

        //
        PrimGraph primGraph = new PrimGraph(data, weight);
        primGraph.show();

        //测试普利姆算法
        primGraph.prim(1);//

    }
}
