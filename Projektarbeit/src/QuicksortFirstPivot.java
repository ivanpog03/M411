/**
 * @author Hermann Witte
 */
public class QuicksortFirstPivot implements Sortieralgorithmus{
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;
    private int length;

    /**
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
     *
     * @param liste Die zu sortierende Liste
     * @param start
     * @param end
     * @return
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
     *
     * @param liste Die zu sortierende Liste
     * @param start
     * @param end
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
