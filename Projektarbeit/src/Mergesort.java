public class Mergesort implements Sortieralgorithmus{
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;
    private int length;
    private int[] liste;

    @Override
    public void sort(int[] liste) {
        zeit = System.nanoTime();
        length = liste.length;
        this.liste = mergesort(liste);
        schreibzugriffe++;
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
    }

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
