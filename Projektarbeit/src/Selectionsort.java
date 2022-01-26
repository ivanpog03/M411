/**
 * Der Selectionsort arbeitet in-place und ist ein instabiler Sortieralgorithmus (Grundform).
 * Im Best-, Worst- und Averagecase hat der Selection sort eine Komplexität von O(n^2).
 * @author Hermann Witte
 * @since 12.01.2022
 *
 */
public class Selectionsort implements Sortieralgorithmus{
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;
    private int length;


    /**
     * @param liste Die zu sortierende Liste als Array.
     * @return Gibt die Sortierte Liste in form eines Arrays zurück.
     */
    @Override
    public int[] sort(int[] liste) {
        zeit = System.nanoTime();
        length = liste.length;
        selectionSort(liste);
        return liste;
    }

    /**
     * Die Methode sortiert die Liste mittels Selectionsort.
     * @param liste Die Methode benötigt das zu sortierende Array.
     */
    public void selectionSort(int[] liste){
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (liste[i] > liste[j]) {
                    int zahl = liste[j];
                    liste[j] = liste[i];
                    liste[i] = zahl;
                    schreibzugriffe += 2;
                }
            }
        }
        vergleiche = length * ((length-1) * 2) + length + 1;
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
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
        return length * 32 + 3 * 32;
    }

    /**
     * @return Gibt die Anzahl der Speicherzugriffe auf das zu sortierende Array zurück.
     */
    @Override
    public int getSchreibzugriffe() {
        return schreibzugriffe;
    }
}
