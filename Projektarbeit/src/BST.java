class BST implements Sortieralgorithmus{
    private static int vergleiche = 0;
    private double zeit;
    private static int schreibzugriffe = 0;
    private int length;
    private int[] liste;
    private int cntr = 0;
    Node node;

    @Override
    public void sort(int[] list) {
        zeit = System.nanoTime();
        length = list.length;
        liste = list;

        BST bst = new BST(this.liste[0]);
        for(int num : this.liste){
            bst.insert(bst.node, num);
        }
        bst.inOrder(bst.node, liste);
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
    }

    BST(int value){
        node = new Node(value);
    }

    public Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        vergleiche++;
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        else if(value > node.value){
            node.right = insert(node.right, value);
        }
        vergleiche++;
        return node;
    }

    public void inOrder(Node node, int[] liste){
        if(node != null) {
            inOrder(node.left, liste);
            liste[cntr] = node.value;
            schreibzugriffe++;
            cntr++;
            inOrder(node.right, liste);
        }
        vergleiche++;
    }


    @Override
    public int getVergleiche() {
        return vergleiche;
    }

    @Override
    public double getZeit() {
        return zeit;
    }

    @Override
    public long getSpeicherbedarf() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @Override
    public int getSchreibzugriffe() {
        return schreibzugriffe;
    }
}
