import java.util.*; // Import necessary utility classes like List, Map, Queue, Set

/**
 * Implements the Breadth-First Search (BFS) algorithm to traverse a graph.
 * This class represents a graph using an adjacency list and provides a method
 * to perform BFS starting from a given node.
 */
public class BFSAlgorithm {

    // --- Graph Representation ---
    // We'll use a Map to represent the graph.
    // Each key in the map is a 'node' (like a person's name or a city).
    // The value associated with each key is a List of its 'neighbors'
    // (other nodes it's connected to).
    private Map<Integer, List<Integer>> adjList;

    /**
     * Constructor for the BFSAlgorithm class.
     * Initializes an empty adjacency list.
     */
    public BFSAlgorithm() {
        adjList = new HashMap<>();
    }

    /**
     * Adds an edge (a connection) between two nodes in the graph.
     * Since this is for an undirected graph, we add the edge in both directions.
     * For example, if A is connected to B, B is also connected to A.
     *
     * @param u The first node.
     * @param v The second node.
     */
    public void addEdge(int u, int v) {
        // If node 'u' doesn't have an entry in the map yet, create a new list for it.
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        // Do the same for node 'v' to make it an undirected graph.
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    /**
     * Performs the Breadth-First Search (BFS) starting from a given 'startNode'.
     * It prints the nodes as they are visited in BFS order.
     *
     * @param startNode The node from which to start the BFS traversal.
     */
    public void bfs(int startNode) {
        // --- Core BFS Data Structures ---

        // 1. Queue: This is like our "to-do list" or "line of people" waiting to be explored.
        //    We add nodes here that we need to visit soon, making sure to visit them
        //    in the order they were discovered (first in, first out).
        Queue<Integer> queue = new LinkedList<>();

        // 2. Visited Set: This is like a "tracker" to remember which nodes we've
        //    already explored. We don't want to visit the same node multiple times
        //    or get stuck in a loop.
        Set<Integer> visited = new HashSet<>();

        // --- BFS Initialization ---

        // 1. Add the starting node to our queue. It's the first thing we want to explore.
        queue.add(startNode);
        // 2. Mark the starting node as visited so we don't process it again.
        visited.add(startNode);

        System.out.println("BFS Traversal starting from node " + startNode + ":");

        // --- BFS Traversal Loop ---

        // Keep going as long as there are nodes left in our queue to explore.
        while (!queue.isEmpty()) {
            // 1. Take a node from the front of the queue. This is our "current" node.
            int currentNode = queue.poll(); // .poll() removes and returns the head of the queue

            // 2. Print or process the current node. This means we've "visited" it.
            System.out.print(currentNode + " ");

            // 3. Explore Neighbors: Look at all the friends (neighbors) of the current node.
            //    First, check if the current node actually has any neighbors in our graph.
            if (adjList.containsKey(currentNode)) {
                for (int neighbor : adjList.get(currentNode)) {
                    // For each neighbor:
                    // Check if we have NOT visited this neighbor before.
                    if (!visited.contains(neighbor)) {
                        // If not visited:
                        // a. Mark it as visited (so we don't add it again).
                        visited.add(neighbor);
                        // b. Add it to the queue. It will be explored later, after all
                        //    nodes on the current "level" are processed.
                        queue.add(neighbor);
                    }
                }
            }
        }
        System.out.println("\nBFS Traversal Complete!");
    }

    /**
     * Main method to demonstrate the BFS algorithm.
     * This is where we create our graph and run BFS.
     */
    public static void main(String[] args) {
        BFSAlgorithm graph = new BFSAlgorithm();

        // Let's build a simple graph (like our friend network):
        // Node 0 is connected to 1, 2
        // Node 1 is connected to 0, 3, 4
        // Node 2 is connected to 0, 5
        // Node 3 is connected to 1
        // Node 4 is connected to 1
        // Node 5 is connected to 2

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        // Note: We don't need to add 3-1, 4-1, 5-2 because addEdge handles both directions.

        System.out.println("--- Graph Created ---");
        System.out.println("Adjacency List: " + graph.adjList);
        System.out.println("---------------------");

        // Now, let's perform BFS starting from node 0.
        // It should visit nodes in this order (or similar, depending on adjList internal order):
        // 0 -> 1, 2 -> 3, 4, 5
        graph.bfs(0);

        System.out.println("\n--- Another BFS Example ---");
        // Let's try BFS from a different starting node, say node 1.
        // It might visit: 1 -> 0, 3, 4 -> 2, 5
        graph.bfs(1);

        System.out.println("\n--- Graph with a disconnected part ---");
        BFSAlgorithm disconnectedGraph = new BFSAlgorithm();
        disconnectedGraph.addEdge(1, 2);
        disconnectedGraph.addEdge(2, 3);
        disconnectedGraph.addEdge(4, 5); // Node 4 and 5 are not connected to 1,2,3
        disconnectedGraph.addEdge(5, 6);

        System.out.println("Adjacency List: " + disconnectedGraph.adjList);
        System.out.println("Starting BFS from node 1 (will not reach 4,5,6):");
        disconnectedGraph.bfs(1);

        System.out.println("\nStarting BFS from node 4 (will reach 5,6):");
        disconnectedGraph.bfs(4);
    }
}
