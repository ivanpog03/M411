public interface Sortieralgorithmus {


    public default int[] sort(int[] liste){
        return null;
    }

    public default long getVergleiche(){
        return 0;
    }

    public default double getZeit(){
        return 0;
    }

    public default long getSpeicherbedarf(){
        return 0;
    }

    public default long getSchreibzugriffe(){
        return 0;
    }
}
