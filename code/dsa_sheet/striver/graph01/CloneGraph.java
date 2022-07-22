package dsa_sheet.striver.graph01;
//https://leetcode.com/problems/clone-graph/

/*
        Intuition
        - Graph can have cycle and its undirected so each child
            should have parent node also in their adj list
        - Knowing the constraints, narrowed down to a fixed size array instead of dynamic list/map
        - level order with both original and copy
        - can be done with dfs also ;)
 */

import java.util.*;
public class CloneGraph {

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

    class Solution {
        public Node cloneGraph(Node node) {
            if(node==null)
                return null;
            if(node.neighbors.size()==0)
                return new Node(node.val);

            Node[] visited = new Node[101];

            Node source = new Node(node.val);
            visited[source.val] = source;
            Queue<Node> levelQ = new ArrayDeque<>();
            levelQ.offer(node);
            levelQ.offer(source);

            while(levelQ.size()>0) {
                Node originalNode = levelQ.poll();
                Node copyNode = levelQ.poll();

                for(Node neighbor: originalNode.neighbors) {
                    Node copyNeighbor;

                    if(visited[neighbor.val]!=null) {

                        copyNeighbor = visited[neighbor.val];

                    } else {
                        copyNeighbor = new Node(neighbor.val);

                        levelQ.offer(neighbor);
                        levelQ.offer(copyNeighbor);

                        visited[copyNeighbor.val] = copyNeighbor;
                    }
                    copyNode.neighbors.add(copyNeighbor);
                }
            }

            return source;
        }
    }

}
