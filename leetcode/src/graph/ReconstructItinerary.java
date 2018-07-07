package graph;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 *
 * Input: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 */
public class ReconstructItinerary {
    Map<String,PriorityQueue<String>> flights;
    LinkedList<String> path;
    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();

        if (tickets.length == 0)
            return path;
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        String start = "JFK";
        dfs(start);
        return path;
    }

    private void dfs(String strFlight) {
        PriorityQueue<String> arr = flights.get(strFlight);

        while (arr != null && !arr.isEmpty()) {
            dfs(arr.poll());
        }

        //SJC,SFO,LHR,MUC,JFK 栈递归回溯添加结果
        path.addFirst(strFlight);
    }
}
