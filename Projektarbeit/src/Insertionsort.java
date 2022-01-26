/**
 * Der Insertionsort arbeitet nach dem stabilen Sortierverfahren und hat eine
 * Komplexitöt von O(n^2) im schlechtesten und durschnittlichen Fall. Im Besten Fall
 * hat der Algorithmus eine Komplexität von O(n).
 * @author Hermann Witte
 */
public class Insertionsort implements Sortieralgorithmus {
    private long vergleiche = 0;
    private double zeit;
    private long schreibzugriffe = 0;
    private int length;
    private int[] liste;

    /**
     *Die Methode gibt den Benötigten Attributen ihren wert und startet den Algorithmus mittels
     * aufruf der methode insertion().
     * @param liste
     * @return
     */
    @Override
    public int[] sort(int[] liste) {
        zeit = System.nanoTime();
        length = liste.length;
        this.liste = liste;
        insertionsort();
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
        return this.liste;
    }

    /**
     * Die Logik des Insertionsorts. Mittelso fori-Schleifen werden Die Werte iteriert und
     * verglichen un wenn nötig vertauscht.
     */
    private void insertionsort() {
        int b;
        int tmp;

        for (int i = 0; i < length -1; i++) {
            vergleiche++;
            b = i+1;
            tmp = liste[b];
            while (b > 0 && liste[b-1]>tmp) {
                vergleiche++;
                liste[b] = liste[b-1];
                schreibzugriffe++;
                b--;
            }
            vergleiche++;
            liste[b] = tmp;
            schreibzugriffe++;
        }
        vergleiche++;
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
        return length * 32 + 3 * 32;
    }

    /**
     * @return Gibt die Anzahl der Speicherzugriffe auf das zu sortierende Array zurück.
     */
    @Override
    public long getSchreibzugriffe() {
        return schreibzugriffe;
    }
}
