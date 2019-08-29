package kruskal;

/**
 * 边的类，它的对象实例就表示一条边
 */
public class Edge {
    char start; //边的一个点
    char end; //边的另外一个点
    int weight; //边的权值

    //
    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start = " + start +
                ", end = " + end +
                ", weight = " + weight +
                '}';
    }
}
