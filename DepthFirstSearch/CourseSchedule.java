//207. Course Schedule   Add to List QuestionEditorial Solution  My Submissions
//Total Accepted: 67231
//Total Submissions: 220472
//Difficulty: Medium
//Contributors: Admin
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
//2, [[1,0],[0,1]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//Note:
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//
//click to show more hints.
//
//Hints:
//This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
//Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
//Topological sort could also be done via BFS.
public class CourseSchedule {
	/*
	 * Solution: 
	 * 1.If there is a cycle exists in a directed graph, no topological
	 * ordering exists and therefore it will be impossible to take all courses.
	 * 2.Use DFS to travel the graph
	 * 3.Use a set to remember the node that is OK in case to travel it twice. 
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites.length == 0)
			return true;

		ArrayList<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<>();
		for (int[] pre : prerequisites)
			graph[pre[0]].add(pre[1]);
		boolean[] visited = new boolean[numCourses];

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numCourses; i++)
			if (!set.contains(i) && DFS(numCourses, i, graph, visited, set) == false)
				return false;

		return true;
	}

	private boolean DFS(int numCourses, int i, ArrayList<Integer>[] graph, boolean[] visited, Set<Integer> set) {
		if (visited[i] == true)
			return false;

		visited[i] = true;
		for (int j = 0; j < graph[i].size(); j++)
			if (!set.contains(graph[i].get(j)) && DFS(numCourses, (int) graph[i].get(j), graph, visited, set) == false)
				return false;
		visited[i] = false;

		set.add(i);
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new CourseSchedule().canFinish(2, new int[][] { { 0, 1 }, { 1, 0 } }));

	}

}

