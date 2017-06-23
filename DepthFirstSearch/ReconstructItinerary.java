package com.hm;

import java.util.*;
//332. Reconstruct Itinerary
//        DescriptionHintsSubmissionsSolutions
//        Discuss   Editorial Solution Pick One
//        Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
//        Note:
//        If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//        All airports are represented by three capital letters (IATA code).
//        You may assume all tickets form at least one valid itinerary.
//        Example 1:
//        tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//        Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
//        Example 2:
//        tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
//        Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
/**
 * Created by hm on 17-6-23.
 */
public class ReconstructItinerary {
    /*
    Solution: 1.dfs the eulerian graph from first node "JFK"
              2.use priority queue to get the airport in lexical order.
     */

    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> path = new LinkedList<>();
        Map<String, Queue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        dfs(path, graph, "JFK");
        return path;
    }

    private void dfs(LinkedList<String> path, Map<String, Queue<String>> graph, String from) {
        Queue<String> neighbors = graph.get(from);
        while (neighbors != null && neighbors.size() > 0) {
            String to = neighbors.poll();
            dfs(path, graph, to);
        }
        path.addFirst(from);
    }

    public static void main(String[] args) {

    }
}
