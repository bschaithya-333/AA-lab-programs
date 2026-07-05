// 11. Topological Sorting using Kahn's Algorithm
import java.util.*;
public class P11_TopoSortKahn {
    public static void main(String[] args) {
        int v = 6;
        int[][] edges = {{0,1},{1,2},{2,3},{4,5},{5,1},{5,2}};
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[v];
        for (int[] e : edges) { graph.get(e[0]).add(e[1]); indegree[e[1]]++; }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) if (indegree[i] == 0) q.add(i);

        System.out.println("Topological sort: ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int adj : graph.get(node)) if (--indegree[adj] == 0) q.add(adj);
        }
        System.out.println();
    }
}
