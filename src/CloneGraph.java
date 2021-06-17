import java.util.HashMap;

public class CloneGraph {
    private HashMap<Integer, Node> newNodes;

    public CloneGraph() {
        this.newNodes = new HashMap<Integer, Node>();
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        int val = node.val;
        if (!newNodes.containsKey(val)) {
            Node newNode = this.newNodes.getOrDefault(val, new Node(val));
            this.newNodes.putIfAbsent(val, newNode);
            for (Node existingNode: node.neighbors)
                newNode.neighbors.add(cloneGraph(existingNode));
            return newNode;
        } else
            return newNodes.get(val);
    }
}
