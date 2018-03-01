import java.util.ArrayList;
import java.util.Random;

public class BSTUtils {
    public static  ArrayList<Node> treeToList(BST bst) {
        ArrayList<Node> listNode= new ArrayList<Node>();

        if (bst.getRootNode() == null) {
            return listNode;
        } else {
            Node previosNode = bst.getRootNode();
            Node currentNode = bst.getRootNode();
            Node nextNode = bst.getNextNode(currentNode, previosNode);

            while (nextNode != currentNode) {
                listNode.add(currentNode);
                previosNode = currentNode;
                currentNode = nextNode;
                nextNode = bst.getNextNode(currentNode,previosNode);
            }
            return listNode;
        }
    }

    /**
     *
     * @param bst
     * @param firstNode
     * @param secondNode
     * @return  Node - CommonParent of 1&2 nodes
     *  return null - in not found Common Parent one
     */
    public static Node findNearestCommonParent(BST bst, Node firstNode, Node secondNode) {

        Node nodeA = firstNode;
        Node nodeB = secondNode;



        while (nodeA.deepnessLevel != nodeB.deepnessLevel) {
            if (nodeA.deepnessLevel > nodeB.deepnessLevel) {
                nodeA = nodeA.parentNode;
            }
            if (nodeB.deepnessLevel > nodeA.deepnessLevel) {
                nodeB = nodeB.parentNode;
            }

        }

        while (nodeA != nodeB) {
            nodeA = nodeA.parentNode;
            nodeB = nodeB.parentNode;
        }
        return(nodeA);
    }

    public static Node getRandomNodeFromBST(BST bst) {
        Random randomGenerator = new Random();
        ArrayList<Node> al = BSTUtils.treeToList(bst);
        return al.get(randomGenerator.nextInt(al.size()));
    }

    public static Node getFirstMacthNodeByValue(BST bst, int value) {

        for (Object n1 : BSTUtils.treeToList(bst).toArray()) {
            if ((((Node) n1).value) == value) {
                return ((Node) n1);
            }
        }
        return null;
    }

}
