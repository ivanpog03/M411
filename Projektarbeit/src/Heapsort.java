/**
 * Der Heapsort ist instabil obwohl er in-place arbeitet. Die Komplexität
 * liegt in jedem Fall bei O(n * log(n)).
 * @author Hermann Witte
 */
public class Heapsort implements Sortieralgorithmus{
    private long vergleiche = 0;
    private double zeit;
    private long schreibzugriffe = 0;
    private int speicherbedarf;


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
        speicherbedarf = liste.length * 32 + 4 * 32;
        return liste;
    }

    /**
     * Mittels fori-Schleife ruft diese Methode die methode tausche() und versickern() für
     * jedes Element in der Liste auf.
     * @param liste Liste, welche sortiert werden soll.
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
     * Mittels fori-Schlaufe wird die Methode versickern() aufgerufen.
     * @param liste Liste, welche sortiert wird.
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
     * @param liste Liste, welche sortiert wird.
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
     * @param arr Liste welche sortiert wird.
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
     * @return Gibt die Anzahl der vergleiche, welcher der Algorithmus benötigt zurück.
     */
    @Override
    public long getVergleiche() {
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
        return speicherbedarf;
    }

    /**
     * @return Gibt die Anzahl der Speicherzugriffe auf das zu sortierende Array zurück.
     */
    @Override
    public long getSchreibzugriffe() {
        return schreibzugriffe;
    }
}
