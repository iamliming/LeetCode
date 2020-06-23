package graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

/**
 * google guava图数据结构
 *
 * @author liming
 * @version [版本号, 六月 12, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class GraphDemo
{
    public static void main(String[] args)
    {

        for(int i = 1; i<= 31; i++){
            System.out.println(Math.log(1 + (Math.E - 1) * i / 31));
        }

        System.out.println();
        MutableGraph<String> graph = GraphBuilder.directed().build();
        graph.putEdge("A", "B");
        graph.putEdge("A", "C");
        graph.putEdge("A", "E");
        graph.putEdge("B", "K");
        for(EndpointPair<String> pair :graph.edges()){
            System.out.println(pair.nodeU()+"<>"+pair.nodeV());
        }
        //System.out.println(graph.successors("A").contains("K"));
        System.out.println(graph.adjacentNodes("A").contains("K"));
        System.out.println(graph.successors("A").contains("B"));
        System.out.println(graph.successors("B").contains("A"));

        //System.out.println(graph.predecessors("A").contains("K"));
    }
}
