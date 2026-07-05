// 12. Topological Sorting using DFS
import java.util.*;
public class P12_TopoSortDFS {
    static void dfs(int v, List<List<Integer>> graph, boolean[] visited, Deque<Integer> stack) {
        visited[v] = true;
        for (int adj : graph.get(v)) if (!visited[adj]) dfs(adj, graph, visited, stack);
        stack.push(v);
    }

    public static void main(String[] args) {
        int v = 6;
        int[][] edges = {{0,1},{2,3},{1,3},{4,5},{5,1},{5,2}};
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) graph.get(e[0]).add(e[1]);

        boolean[] visited = new boolean[v];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < v; i++) if (!visited[i]) dfs(i, graph, visited, stack);

        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
        System.out.println();
    }
}
