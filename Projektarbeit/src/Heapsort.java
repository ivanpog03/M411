/**
 * @author Hermann Witte
 */
public class Heapsort implements Sortieralgorithmus{
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;


    /**
     * Die Methode gibt den Benötigten Attributen ihren wert und startet den Algorithmus mittels
     * aufruf der methode heapSort().
     * @param liste Die zu sortierende Liste als Array.
     * @return Gibt die Sortierte Liste in form eines Arrays zurück.
     */
    @Override
    public int[] sort(int[] liste) {
        zeit = System.nanoTime();
        heapSort(liste);
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
        return liste;
    }

    /**
     *
     * @param liste
     */
    private void heapSort(int[] liste) {
        BuildMaxHeap(liste);
        for(int i = liste.length -1; i > 0; i--) {
            vergleiche++;
            tausche(liste, i, 0);
            versickern(liste,0, i);
        }
        vergleiche++;
    }

    /**
     *
     * @param liste
     */
    private void BuildMaxHeap(int[] liste) {
        for(int i = (liste.length / 2) - 1; i >= 0 ; i--) {
            vergleiche++;
            versickern(liste, i, liste.length);
        }
        vergleiche++;
    }

    /**
     *
     * @param liste
     * @param i
     * @param j
     */
    private void versickern(int[] liste, int i, int j) {
        while(i <= (j / 2) - 1) {
            vergleiche++;
            int kindIndex = ((i+1) * 2) - 1;
            if(kindIndex + 1 <= j -1) {
                if(liste[kindIndex] < liste[kindIndex+1]) {
                    kindIndex++;
                }
                vergleiche++;
            }
            vergleiche++;

            if(liste[i] < liste[kindIndex]) {
                tausche(liste,i,kindIndex);
                i = kindIndex;
            } else break;
            vergleiche++;
        }
        vergleiche++;
    }

    /**
     *
     * @param arr
     * @param i
     * @param kindIndex
     */
    private void tausche(int[] arr, int i, int kindIndex) {
        int k = arr[i];
        arr[i] = arr[kindIndex];
        schreibzugriffe++;
        arr[kindIndex] = k;
        schreibzugriffe++;
    }

    /**
     *
     * @return
     */
    @Override
    public int getVergleiche() {
        return vergleiche;
    }

    /**
     *
     * @return
     */
    @Override
    public double getZeit() {
        return zeit;
    }

    /**
     *
     * @return
     */
    @Override
    public long getSpeicherbedarf() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /**
     *
     * @return
     */
    @Override
    public int getSchreibzugriffe() {
        return schreibzugriffe;
    }
}
