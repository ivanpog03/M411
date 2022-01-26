/**
 * Der Quicksort ist ein schneller und instabiler Sortieralgorithmus, welcher alle Werte mit dem Pivot
 * (in diesem Fall das Erste Element des Arrays) vergleicht. Durchschnittlich werden O(n * log(n)) Vergleiche
 * benötigt. Im schlechtesten Fall sind es O(n^2) und im besten Fall O(n * log(n)).
 * @author Hermann Witte
 */
public class QuicksortFirstPivot implements Sortieralgorithmus{
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;
    private int length;

    /**
     * Diese Methode dient zu der Wertzuweisung der Attribute und ruft de Methode Quicksort auf,
     * um den Algorithmus zu starten. Ausserdem wird die Zeit gemessen.
     * @param liste Die zu sortierende Liste als Array.
     * @return Gibt die Sortierte Liste als Array zurück.
     */
    @Override
    public int[] sort(int[] liste) {
        zeit = System.nanoTime();
        length = liste.length;
        quicksort(liste,0, length-1);
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
        return liste;
    }

    /**
     * Die Methode überprüft mittels fori Schleife ob die Werte kleiner als der Pivot sind
     * und verschiebt diese dann im Array. Der Rückgabewert ist wichtig für den erneuten
     * Aufruf der Methode, da der Start- und Ende-Index angepasst werden können
     * @param liste Die zu sortierende Liste
     * @param start Der Start-Index des Arrays
     * @param end Der Ende-Index des Arrays
     * @return P1 -> Wichtig für erneuten aufruf der Methode (Start- & Ende-Index)
     */
    int partition(int[] liste, int start, int end) {
        int pivot = liste[start];
        int p1 = start + 1;
        for(int i = start + 1; i <= end; i++) {
            if(liste[i] < pivot) {
                if(i != p1) {
                    int temp = liste[p1];
                    liste[p1] = liste[i];
                    liste[i] = temp;
                    schreibzugriffe += 2;
                }
                vergleiche++;
                p1++;
            }
            vergleiche += 2;
        }
        vergleiche++;
        liste[start] = liste[p1-1];
        liste[p1-1] = pivot;
        schreibzugriffe += 2;
        return p1 - 1;
    }

    /**
     * Die Methode ruft sich mittels Rekursion so lange auf, bis es einmal jeden, ausser
     * den letzten Wert aus dem Array durchlaufen hat. Die Methode ruft dann jeweils
     * die Methode partition() mit verschiedenen Start- und Ende-Indexen auf. Dies
     * funktioniert mittels dem p1-Attribut.
     * @param liste Die zu sortierende Liste
     * @param start Start-Index für Aufruf der Methode partition()
     * @param end Ende-Index für Aufruf der Methode partition()
     */
    void quicksort(int liste[], int start, int end) {
        int p1;
        if(start < end) {
            p1 = partition(liste, start, end);
            quicksort(liste, start, p1-1);
            quicksort(liste, p1+1, end);
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
        return length * 32 + 4 * 32;
    }

    /**
     * @return Gibt die Anzahl der Speicherzugriffe auf das zu sortierende Array zurück.
     */
    @Override
    public int getSchreibzugriffe() {
        return schreibzugriffe;
    }
}
