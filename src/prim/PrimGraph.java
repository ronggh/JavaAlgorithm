package prim;

import java.util.Arrays;

// 普里姆算法(最小生成树，选点)
public class PrimGraph {
    char[] data;//存放结点数据
    int[][] weight; //存放边，就是我们的邻接矩阵

    //
    public PrimGraph(char[] data, int[][] weight) {
        this.data = data;
        this.weight = weight;
    }

    //
    public void show(){
        for(int[] link: weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * prim算法，得到最小生成树
     * @param index,从哪一个顶点开始构建，
     */
    public void prim(int index) {
        //visited[] 标记结点(顶点)是否被访问过
        int visited[] = new int[this.data.length];

        //把当前这个结点标记为已访问
        visited[index] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = Integer.MAX_VALUE; //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换

        //因为有 data.length顶点，普利姆算法结束后，有 data.length-1边
        for(int k = 1; k < this.data.length; k++) {

            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for(int i = 0; i < this.data.length; i++) {// i结点表示被访问过的结点
                for(int j = 0; j< this.data.length;j++) {//j结点表示还没有访问过的结点
                    if(visited[i] == 1 && visited[j] == 0 && this.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = this.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边 < " + this.data[h1] + "," + this.data[h2] + " > 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = Integer.MAX_VALUE;
        }

    }

}
