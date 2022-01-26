public interface Sortieralgorithmus {


    public default int[] sort(int[] liste){
        return null;
    }

    public default int getVergleiche(){
        return 0;
    }

    public default double getZeit(){
        return 0;
    }

    public default long getSpeicherbedarf(){
        return 0;
    }

    public default int getSchreibzugriffe(){
        return 0;
    }
}
