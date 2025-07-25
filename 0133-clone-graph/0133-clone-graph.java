/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node  == null) return null;
        Map<Integer,Node> nodemap = new HashMap<>();
        nodemap.put(1,new Node(1));
        
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while(!que.isEmpty()){
            Node cur = que.poll();
            int v = cur.val;
            for(Node nei:cur.neighbors){
                int val = nei.val;
                if(!nodemap.containsKey(val)){
                    nodemap.put(val,new Node(val));
                    que.add(nei);
                }
                nodemap.get(v).neighbors.add(nodemap.get(val));

            }
        }

        return nodemap.get(1);
    }
}