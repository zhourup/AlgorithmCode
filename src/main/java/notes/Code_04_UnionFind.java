package main.java.notes;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 */
public class Code_04_UnionFind {

    public static class Node {

    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }
}
