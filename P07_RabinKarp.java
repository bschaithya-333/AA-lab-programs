// 16. Graph Matching Combinations Finding
import java.util.*;
public class P16_GraphMatching {
    static int[][] edges = {{0,1},{1,2},{2,3},{0,3}};

    static void findMatchings(int index, List<int[]> matching, boolean[] used) {
        if (index == edges.length) {
            StringBuilder sb = new StringBuilder("{");
            for (int[] e : matching) sb.append("(").append(e[0]).append(",").append(e[1]).append(") ");
            System.out.println(sb + "}");
            return;
        }
        int[] edge = edges[index];
        int u = edge[0], v = edge[1];
        if (!used[u] && !used[v]) {
            used[u] = used[v] = true;
            matching.add(edge);
            findMatchings(index + 1, matching, used);
            matching.remove(matching.size() - 1);
            used[u] = used[v] = false;
        }
        findMatchings(index + 1, matching, used);
    }

    public static void main(String[] args) {
        System.out.println("All matchings:");
        findMatchings(0, new ArrayList<>(), new boolean[4]);
    }
}
