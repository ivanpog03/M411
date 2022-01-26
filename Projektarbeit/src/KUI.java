import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class KUI{

    public static XSSFWorkbook workbook=new XSSFWorkbook();
    public static XSSFSheet sheetQuicksortFirstPivot=workbook.createSheet("QuickSortFirstPivot");
    public static XSSFSheet sheetHeapsort= workbook.createSheet("HeapSort");
    public static XSSFSheet sheetInsertionSort= workbook.createSheet("InsertionSort");
    public static XSSFSheet sheetMergeSort= workbook.createSheet("MergeSort");
    public static XSSFSheet sheetSelectionSort= workbook.createSheet("SelectionSort");
    public static XSSFSheet sheetQicksortRandomPivot= workbook.createSheet("QuickSortRandomPivot");
    public static XSSFSheet sheetBST= workbook.createSheet("BST");




    public void quicksortFirstPivot (int[] array, int i, String input){
        Sortieralgorithmus quicksortFirstPivot = new QuicksortFirstPivot();
        quicksortFirstPivot.sort(array);

        sheetQuicksortFirstPivot.getRow(0).createCell(i).setCellValue(input);
        sheetQuicksortFirstPivot.getRow(1).createCell(i).setCellValue(quicksortFirstPivot.getVergleiche());
        sheetQuicksortFirstPivot.getRow(2).createCell(i).setCellValue(quicksortFirstPivot.getZeit());
        sheetQuicksortFirstPivot.getRow(3).createCell(i).setCellValue(quicksortFirstPivot.getSpeicherbedarf());
        sheetQuicksortFirstPivot.getRow(4).createCell(i).setCellValue(quicksortFirstPivot.getSchreibzugriffe());

    }

    public void heapSort (int[] array, int i, String input){
        Sortieralgorithmus heapsort=new Heapsort();
        heapsort.sort(array);

        sheetHeapsort.getRow(0).createCell(i).setCellValue(input);
        sheetHeapsort.getRow(1).createCell(i).setCellValue(heapsort.getVergleiche());
        sheetHeapsort.getRow(2).createCell(i).setCellValue(heapsort.getZeit());
        sheetHeapsort.getRow(3).createCell(i).setCellValue(heapsort.getSpeicherbedarf());
        sheetHeapsort.getRow(4).createCell(i).setCellValue(heapsort.getSchreibzugriffe());


    }

    public void insertionSort (int[] array, int i, String input){
        Insertionsort insertionsort=new Insertionsort();
        insertionsort.sort(array);

        sheetInsertionSort.getRow(0).createCell(i).setCellValue(input);
        sheetInsertionSort.getRow(1).createCell(i).setCellValue(insertionsort.getVergleiche());
        sheetInsertionSort.getRow(2).createCell(i).setCellValue(insertionsort.getZeit());
        sheetInsertionSort.getRow(3).createCell(i).setCellValue(insertionsort.getSpeicherbedarf());
        sheetInsertionSort.getRow(4).createCell(i).setCellValue(insertionsort.getSchreibzugriffe());


    }

    public void mergeSort (int[] array, int i, String input){
        Sortieralgorithmus mergesort=new Mergesort();
        mergesort.sort(array);

        sheetMergeSort.getRow(0).createCell(i).setCellValue(input);
        sheetMergeSort.getRow(1).createCell(i).setCellValue(mergesort.getVergleiche());
        sheetMergeSort.getRow(2).createCell(i).setCellValue(mergesort.getZeit());
        sheetMergeSort.getRow(3).createCell(i).setCellValue(mergesort.getSpeicherbedarf());
        sheetMergeSort.getRow(4).createCell(i).setCellValue(mergesort.getSchreibzugriffe());

    }

    public void selectionSort (int[] array, int i, String input){
        Sortieralgorithmus selectionsort=new Selectionsort();
        selectionsort.sort(array);

        sheetSelectionSort.getRow(0).createCell(i).setCellValue(input);
        sheetSelectionSort.getRow(1).createCell(i).setCellValue(selectionsort.getVergleiche());
        sheetSelectionSort.getRow(2).createCell(i).setCellValue(selectionsort.getZeit());
        sheetSelectionSort.getRow(3).createCell(i).setCellValue(selectionsort.getSpeicherbedarf());
        sheetSelectionSort.getRow(4).createCell(i).setCellValue(selectionsort.getSchreibzugriffe());

    }

    public void quicksortRandomPivot (int[] array, int i, String input){
        Sortieralgorithmus quicksortrandompivot=new QuicksortRandomPivot();
        quicksortrandompivot.sort(array);

        sheetQicksortRandomPivot.getRow(0).createCell(i).setCellValue(input);
        sheetQicksortRandomPivot.getRow(1).createCell(i).setCellValue(quicksortrandompivot.getVergleiche());
        sheetQicksortRandomPivot.getRow(2).createCell(i).setCellValue(quicksortrandompivot.getZeit());
        sheetQicksortRandomPivot.getRow(3).createCell(i).setCellValue(quicksortrandompivot.getSpeicherbedarf());
        sheetQicksortRandomPivot.getRow(4).createCell(i).setCellValue(quicksortrandompivot.getSchreibzugriffe());


    }

    public void bST (int[] array, int i, String input){
        Sortieralgorithmus bst=new BST(0);
        bst.sort(array);

        sheetBST.getRow(0).createCell(i).setCellValue(input);
        sheetBST.getRow(1).createCell(i).setCellValue(bst.getVergleiche());
        sheetBST.getRow(2).createCell(i).setCellValue(bst.getZeit());
        sheetBST.getRow(3).createCell(i).setCellValue(bst.getSpeicherbedarf());
        sheetBST.getRow(4).createCell(i).setCellValue(bst.getSchreibzugriffe());


    }

    public static void main(String[] args) throws IOException {

        sheetQuicksortFirstPivot.createRow(0);
        sheetQuicksortFirstPivot.createRow(1);
        sheetQuicksortFirstPivot.createRow(2);
        sheetQuicksortFirstPivot.createRow(3);
        sheetQuicksortFirstPivot.createRow(4);



        sheetHeapsort.createRow(0);
        sheetHeapsort.createRow(1);
        sheetHeapsort.createRow(2);
        sheetHeapsort.createRow(3);
        sheetHeapsort.createRow(4);


        sheetInsertionSort.createRow(0);
        sheetInsertionSort.createRow(1);
        sheetInsertionSort.createRow(2);
        sheetInsertionSort.createRow(3);
        sheetInsertionSort.createRow(4);


        sheetMergeSort.createRow(0);
        sheetMergeSort.createRow(1);
        sheetMergeSort.createRow(2);
        sheetMergeSort.createRow(3);
        sheetMergeSort.createRow(4);


        sheetSelectionSort.createRow(0);
        sheetSelectionSort.createRow(1);
        sheetSelectionSort.createRow(2);
        sheetSelectionSort.createRow(3);
        sheetSelectionSort.createRow(4);


        sheetQicksortRandomPivot.createRow(0);
        sheetQicksortRandomPivot.createRow(1);
        sheetQicksortRandomPivot.createRow(2);
        sheetQicksortRandomPivot.createRow(3);
        sheetQicksortRandomPivot.createRow(4);


        sheetBST.createRow(0);
        sheetBST.createRow(1);
        sheetBST.createRow(2);
        sheetBST.createRow(3);
        sheetBST.createRow(4);


        KUI kui=new KUI();



        int[] inversTeilSortiert1000= readFiles("Testdaten\\InversTeilsortiert1000.dat");
       // System.out.println(Arrays.toString(inversTeilSortiert1000));
        int[] inversTeilSortiert10000= readFiles("Testdaten\\InversTeilsortiert10000.dat");
        //System.out.println(Arrays.toString(inversTeilSortiert10000));
        int[] inversTeilSortiert100000= readFiles("Testdaten\\InversTeilsortiert100000.dat");
       // System.out.println(Arrays.toString(inversTeilSortiert100000));

        int[] random1000= readFiles("Testdaten\\Random1000.dat");
       // System.out.println(Arrays.toString(random1000));
        int[] random10000= readFiles("Testdaten\\Random10000.dat");
       // System.out.println(Arrays.toString(random10000));
        int[] random100000= readFiles("Testdaten\\Random100000.dat");
       // System.out.println(Arrays.toString(random100000));

        int[] teilsortiert1000= readFiles("Testdaten\\Teilsortiert1000.dat");
       // System.out.println(Arrays.toString(teilsortiert1000));
        int[] teilsortiert10000= readFiles("Testdaten\\Teilsortiert10000.dat");
       // System.out.println(Arrays.toString(teilsortiert10000));
        int[] teilsortiert100000= readFiles("Testdaten\\Teilsortiert100000.dat");
        //System.out.println(Arrays.toString(teilsortiert100000))

        //Sortieren

       kui.quicksortFirstPivot(inversTeilSortiert1000, 0,"inversTeilSortiert1000");
        kui.quicksortFirstPivot(inversTeilSortiert10000, 1,"inversTeilSortiert10000");
        kui.quicksortFirstPivot(inversTeilSortiert100000, 2,"inversTeilSortiert100000");
        kui.quicksortFirstPivot(random1000, 3,"random1000");
        kui.quicksortFirstPivot(random10000, 4,"random10000");
        kui.quicksortFirstPivot(random100000, 5,"random100000");
        kui.quicksortFirstPivot(teilsortiert1000, 6,"teilsortiert1000");
        kui.quicksortFirstPivot(teilsortiert10000, 7,"teilsortiert10000");
        kui.quicksortFirstPivot(teilsortiert100000, 8,"teilsortiert100000");

        kui.heapSort(inversTeilSortiert1000,0,"inversTeilSortiert1000");
        kui.heapSort(inversTeilSortiert10000,1,"inversTeilSortiert10000");
        kui.heapSort(inversTeilSortiert100000,2,"inversTeilSortiert100000");
        kui.heapSort(random1000,3,"random1000");
        kui.heapSort(random10000,4,"random10000");
        kui.heapSort(random100000,5,"random100000");
        kui.heapSort(teilsortiert1000,6,"teilsortiert1000");
        kui.heapSort(teilsortiert10000,7,"teilsortiert10000");
        kui.heapSort(teilsortiert100000,8,"teilsortiert100000");

        kui.insertionSort(inversTeilSortiert1000,0,"inversTeilSortiert1000");
        kui.insertionSort(inversTeilSortiert10000,1,"inversTeilSortiert10000");
        kui.insertionSort(inversTeilSortiert100000,2,"inversTeilSortiert100000");
        kui.insertionSort(random1000,3,"random1000");
        kui.insertionSort(random10000,4,"random10000");
        kui.insertionSort(random100000,5,"random100000");
        kui.insertionSort(teilsortiert1000,6,"teilsortiert1000");
        kui.insertionSort(teilsortiert10000,7,"teilsortiert10000");
        kui.insertionSort(teilsortiert100000,8,"teilsortiert100000");

        kui.mergeSort(inversTeilSortiert1000,0,"inversTeilSortiert1000");
        kui.mergeSort(inversTeilSortiert10000,1,"inversTeilSortiert10000");
        kui.mergeSort(inversTeilSortiert100000,2,"inversTeilSortiert100000");
        kui.mergeSort(random1000,3,"random1000");
        kui.mergeSort(random10000,4,"random10000");
        kui.mergeSort(random100000,5,"random100000");
        kui.mergeSort(teilsortiert1000,6,"teilsortiert1000");
        kui.mergeSort(teilsortiert10000,7,"teilsortiert10000");
        kui.mergeSort(teilsortiert100000,8,"teilsortiert100000");

        kui.selectionSort(inversTeilSortiert1000,0,"inversTeilSortiert1000");
        kui.selectionSort(inversTeilSortiert10000,1,"inversTeilSortiert10000");
        kui.selectionSort(inversTeilSortiert100000,2,"inversTeilSortiert100000");
        kui.selectionSort(random1000,3,"random1000");
        kui.selectionSort(random10000,4,"random10000");
        kui.selectionSort(random100000,5,"random100000");
        kui.selectionSort(teilsortiert1000,6,"teilsortiert1000");
        kui.selectionSort(teilsortiert10000,7,"teilsortiert10000");
        kui.selectionSort(teilsortiert100000,8,"teilsortiert100000");

        kui.quicksortRandomPivot(inversTeilSortiert1000,0,"inversTeilSortiert1000");
        kui.quicksortRandomPivot(inversTeilSortiert10000,1,"inversTeilSortiert10000");
        kui.quicksortRandomPivot(inversTeilSortiert100000,2,"inversTeilSortiert100000");
        kui.quicksortRandomPivot(random1000,3,"random1000");
        kui.quicksortRandomPivot(random10000,4,"random10000");
        kui.quicksortRandomPivot(random100000,5,"random100000");
        kui.quicksortRandomPivot(teilsortiert1000,6,"teilsortiert1000");
        kui.quicksortRandomPivot(teilsortiert10000,7,"teilsortiert10000");
        kui.quicksortRandomPivot(teilsortiert100000,8,"teilsortiert100000");


        kui.bST(inversTeilSortiert1000,0,"inversTeilSortiert1000");
        kui.bST(inversTeilSortiert10000,1,"inversTeilSortiert10000");
        kui.bST(inversTeilSortiert100000,2,"inversTeilSortiert100000");
        kui.bST(random1000,3,"random1000");
        kui.bST(random10000,4,"random10000");
        kui.bST(random100000,5,"random100000");
        kui.bST(teilsortiert1000,6,"teilsortiert1000");
        kui.bST(teilsortiert10000,7,"teilsortiert10000");
        kui.bST(teilsortiert100000,8,"teilsortiert100000z");



        System.out.println("finished");

        FileOutputStream out = new FileOutputStream(new File("lb2.xlsx"));
        workbook.write(out);
        out.close();

    }

    private static int[] readFiles(String file) throws FileNotFoundException {

        File f=new File(file);
        Scanner s= new Scanner(f);
        int cntr=0;
        while(s.hasNextInt()){
            cntr++;
            s.nextInt();
        }

        Scanner ss=new Scanner(f);
        int[] arr=new int[cntr];
        for(int i=0; i<arr.length;i++){
            arr[i]=ss.nextInt();
        }

        return arr;

    }
}
