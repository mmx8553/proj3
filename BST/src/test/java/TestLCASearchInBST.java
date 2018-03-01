import org.junit.Test;
import org.junit.Assert;
import java.util.Random;
import static org.hamcrest.core.Is.is;
/**
 * Created by mmx on 03.11.2017.
 */
public class TestLCASearchInBST {
    @Test
    /**
     *
     */
    public void FirstSimpeTestOfLCA() {
        BST myBST= new BST();

        myBST.add(50);
        myBST.add(70);
        myBST.add(40);
        Node rootNode = myBST.getRootNode();
        Assert.assertThat(rootNode,is(BSTUtils.findNearestCommonParent(myBST,rootNode,rootNode)));
        Assert.assertThat(rootNode,is(BSTUtils.findNearestCommonParent(myBST,rootNode.leftChild,rootNode.rightChild)));
        Assert.assertThat(rootNode,is(BSTUtils.findNearestCommonParent(myBST,rootNode.leftChild,rootNode)));
    }

    @Test
    public void SecondSimpeTestOfLCA() {
        BST myBST= new BST();

        Random rn = new Random();
        for (int i=0; i<40; i++){
            myBST.add(rn.nextInt(100));
        }

        Node firstNode = BSTUtils.getRandomNodeFromBST(myBST);
        Node secondNode = BSTUtils.getRandomNodeFromBST(myBST);
        Node rootNode = myBST.getRootNode();

        Assert.assertTrue(rootNode.deepnessLevel <= firstNode.deepnessLevel);
        Assert.assertTrue(rootNode.deepnessLevel <= secondNode.deepnessLevel);
    }

    @Test
    public void TestOfLCA() {
        BST myBST= new BST();
        myBST.add(50);
        myBST.add(40);
        myBST.add(60);
        myBST.add(43);

        Node firstNode = BSTUtils.getFirstMacthNodeByValue(myBST, 43);
        Node secondNode = BSTUtils.getFirstMacthNodeByValue(myBST, 60);
        Node rootNode = myBST.getRootNode();
        Node nodeLCA = BSTUtils.findNearestCommonParent(myBST,firstNode, secondNode);
        Assert.assertThat(nodeLCA, is (rootNode));

    }

}
