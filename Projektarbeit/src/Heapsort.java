public class Heapsort implements Sortieralgorithmus{
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
        heapSort();
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
    }

    private void heapSort() {
        BuildMaxHeap();
        for(int i = liste.length -1; i > 0; i--) {
            vergleiche++;
            tausche(liste, i, 0);
            versickern(0, i);
        }
        vergleiche++;
    }

    private void BuildMaxHeap() {
        for(int i = (liste.length / 2) - 1; i >= 0 ; i--) {
            vergleiche++;
            versickern(i, liste.length);
        }
        vergleiche++;
    }

    private void versickern(int i, int j) {
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

    private void tausche(int[] arr, int i, int kindIndex) {
        int k = arr[i];
        arr[i] = arr[kindIndex];
        schreibzugriffe++;
        arr[kindIndex] = k;
        schreibzugriffe++;
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
