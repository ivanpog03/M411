/**
 * @author Hermann Witte
 */
class BST implements Sortieralgorithmus{
    private static int vergleiche = 0;
    private double zeit;
    private static int schreibzugriffe = 0;
    private int[] liste;
    private int cntr = 0;
    Node node;

    /**
     * Die Methode gibt den Benötigten Attributen ihren wert und startet den Algorithmus mittels
     * aufruf der methode mergesort().
     * @param list Die zu sortierende Liste als Array.
     * @return Gibt die Sortierte Liste in form eines Arrays zurück.
     */
    @Override
    public int[] sort(int[] list) {
        zeit = System.nanoTime();
        liste = list;

        BST bst = new BST(this.liste[0]);
        for(int num : this.liste){
            bst.insert(bst.node, num);
        }
        bst.inOrder(bst.node, liste);
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
        return liste;
    }

    /**
     * Konstruktor
     * @param value Wert des knotenpunktes
     */
    BST(int value){
        node = new Node(value);
    }

    /**
     * Überprüft ob es den Knotenpunkt schon gibt, instanziert einen falls nicht und fügt
     * die Kleineren und grösseren Werte (links/rechts) an. Diese werden mittels der rekursion
     * Instanziert.
     * @param node
     * @param value
     * @return
     */
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

    /**
     * Die Knotenpunkte (Node) werden in der korrekten Reihenfolge in ein Array eingefügt.
     * @param node Einer der Knotenpunkte, dessen linken und Rechten Knotenpunkte ermittelt
     *             werden müssen.
     * @param liste Die Liste, in welche die Werte der Knotenpunkte gespeichert werden müssen.
     */
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


    /**
     * @return Gibt die Anzahl der vergleiche, welcher der Algorithmus benötigt zurück.
     */
    @Override
    public int getVergleiche() {
        return vergleiche;
    }

    /**
     * @return Gibt die Zeit, welche der Algorithmus benötigt hat um das Array zu sortieren zurück.
     */
    @Override
    public double getZeit() {
        return zeit;
    }

    /**
     * @return Gibt den Speicherbedarf des Algorithmus, inklusive des zu sortierende Array zurück.
     */
    @Override
    public long getSpeicherbedarf() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /**
     * @return Gibt die Anzahl der Speicherzugriffe auf das zu sortierende Array zurück.
     */
    @Override
    public int getSchreibzugriffe() {
        return schreibzugriffe;
    }
}
