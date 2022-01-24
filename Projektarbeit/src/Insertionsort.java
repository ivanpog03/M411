public class Insertionsort implements Sortieralgorithmus {
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;
    private int length;
    private int[] liste;

    @Override
    public void sort(int[] liste) {
        zeit = System.nanoTime();
        length = liste.length;
        this.liste = liste;
        insertionsort();
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
    }

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
