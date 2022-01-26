/**
 * Node ist die Klasse für die Datenstruktur des Binary search tree Sortieralgorithmus.
 * @author Hermann Witte
 */
class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}