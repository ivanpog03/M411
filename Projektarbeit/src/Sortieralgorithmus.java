public interface Sortieralgorithmus {


    public default void sort(int[] liste){

    }

    public default int getVergleiche(){
        return 0;
    }

    public default int getZeit(){
        return 0;
    }

    public default int getSpeicherbedarf(){
        return 0;
    }

    public default int getSchreibzugriffe(){
        return 0;
    }

}
