/**
 * Der Mergesort ist ein stabiler Sortieralgorithmus. Die Komplexität
 * liegt bei egal welchem Fall bei O(n * log(n)).
 * @author Hermann Witte
 */
public class Mergesort implements Sortieralgorithmus{
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;

    /**
     * Die Methode gibt den Benötigten Attributen ihren wert und startet den Algorithmus mittels
     * aufruf der methode mergesort().
     * @param liste Die zu sortierende Liste als Array.
     * @return Gibt die Sortierte Liste in form eines Arrays zurück.
     */
    @Override
    public int[] sort(int[] liste) {
        zeit = System.nanoTime();
        liste = mergesort(liste);
        schreibzugriffe++;
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
        return liste;
    }

    /**
     * Die Methode speichert mittels Rekursion alle zahlen in einzelne Arrays und ruft
     * anschliessend die Methode verschmelze() auf.
     * @param a Die Methode benötigt das zu sortierende Array
     * @return Gibt das sortierte array zurück
     */
    public  int[] mergesort(int[] a) {
        if (a.length > 1) {
            vergleiche++;
            int mitte = (int)(a.length / 2);
            int[] l = new int[mitte];
            for (int i = 0; i <= mitte - 1; i++) {
                vergleiche++;
                l[i] = a[i];
                schreibzugriffe++;
            }
            vergleiche++;

            int[] r = new int[a.length - mitte];
            for (int i = mitte; i <= a.length - 1; i++) {
                vergleiche++;
                r[i - mitte] = a[i];
                schreibzugriffe++;
            }
            vergleiche++;

            l = mergesort(l);
            r = mergesort(r);
            return verschmelze(l, r);
        }
        else {
            vergleiche++;
            return a;
        }
    }

    /**
     * Die Methode pberprüft welches der beiden Werte in den Arrays grösser ist und
     * führt diese dann korrekt (in der richtigen Reihenfolge) zusammen.
     * @param l Das linke Array
     * @param r Das rechte Array
     * @return Das neue, "verschmelzte" Array.
     */
    private int[] verschmelze(int[] l, int[] r) {
        int[] neul = new int[l.length + r.length];
        int indexl = 0;
        int indexr = 0;
        int indexergebnis = 0;
        while (indexl < l.length && indexr < r.length) {
            vergleiche++;
            if (l[indexl] < r[indexr]) {
                vergleiche++;
                neul[indexergebnis] = l[indexl];
                schreibzugriffe++;
                indexl += 1;
            } else {
                vergleiche++;
                neul[indexergebnis] = r[indexr];
                schreibzugriffe++;
                indexr += 1;
            }
            indexergebnis += 1;
        }
        vergleiche++;
        while (indexl < l.length) {
            vergleiche++;
            neul[indexergebnis] = l[indexl];
            schreibzugriffe++;
            indexl += 1;
            indexergebnis += 1;
        }
        vergleiche++;
        while (indexr < r.length) {
            vergleiche++;
            neul[indexergebnis] = r[indexr];
            schreibzugriffe++;
            indexr += 1;
            indexergebnis += 1;
        }
        vergleiche++;
        return neul;
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
