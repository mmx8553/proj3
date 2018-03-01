
public class BST {
    private Node root = null;

    public BST()
    {
        this.root = null;
    }

    void add(int value){
        this.root = add( this.root, value);
        this.root.parentNode = this.root;
        this.root.deepnessLevel = 0;
    }

    public Node getRootNode() {
        return this.root;
    }

    /**
     *
     * @param root - узел для рекурсивной вставки
     * @param value - значение узла
     * @return
     */
    private Node add(Node root, int value) {
        if (root == null){
            root = new Node(value);
        } else {
            if(root.value > value){
                root.leftChild = add(root.leftChild, value);
                root.leftChild.parentNode = root;
                root.leftChild.deepnessLevel = root.deepnessLevel +1 ;
            } else{
                root.rightChild = add(root.rightChild, value);
                root.rightChild.parentNode = root;
                root.rightChild.deepnessLevel = root.deepnessLevel + 1;
            }
        }

        return root;
    }

    /**
     *
     * @param currentNode - текущая нода для которой ищется след. левый для посещения узел
     * @param previosNode - предыдущая посещенная нода для ориентации куда идти
     * @return - ссылка на след узел к посещению
     */
    private Node getNextLeftNode(Node currentNode, Node previosNode){
        //предварит обработка левых ветвей - чтоб не зациклится
        // [0] - возврат по правым ветвям
        if ((currentNode.rightChild != null) && (currentNode.rightChild == previosNode ) ) {
            return currentNode.parentNode;
        }
        // [1] - если левовго поддеоева нет - поход на правое дерево
        if (currentNode.leftChild == null){
            return this.getNextRightNode(currentNode, previosNode);
        }
        // [2] - если левовго поддеоева нет - поход на правое дерево
        if ((currentNode.leftChild != null)&&(currentNode.leftChild == previosNode)){
            return this.getNextRightNode(currentNode, previosNode);
        }
        //[3] - левое дерево существеут и не отсеялось на предыдущих шагах - значит посещаем его
        return currentNode.leftChild;
    }

    /**
     *
     * @param currentNode - текущая нода для которой ищется след. правый для посещения узел
     * @param previosNode - предыдущая посещенная нода для ориентации куда идти
     * @return - ссылка на след узел к посещению
     */
    private Node getNextRightNode(Node currentNode, Node previosNode){

        //[5] - правого не существует - возврат по правой стороне
        if (currentNode.rightChild == null)  {
            return currentNode.parentNode;
        }
        //[6] = [0] - возврат по правым ветвям
        if ((currentNode.rightChild != null) && (currentNode.rightChild == previosNode ) ) {
            return currentNode.parentNode;
        }
        //[7] - правое дерево существеут и не отсеялось на предыдущих шагах - значит посещаем его
        return currentNode.rightChild;    }

    Node getNextNode(Node currentNode, Node previosNode) {
        return getNextLeftNode(currentNode, previosNode);
    }

}
