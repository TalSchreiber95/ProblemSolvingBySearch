import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex1 {
    private static String gameType="";
    private static String timeMode="";
    private static String openMode="";
    private static String arrSize="";
    private static String[][] arrSrc;
    private static String[][] arrDst;
    private static int rows,cols;
    public static void main(String[] args) throws IOException {
        String a= "src/input2.txt";
        String b= "src/input.txt";
        startGame(b);
    }

    //taken from: https://www.w3schools.com/java/java_files_read.asp
    public static void startGame(String args) {
        LinkedList<String> arrStr = new LinkedList<String>();
        try {
            File myObj = new File(args);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arrStr.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found !.");
            e.printStackTrace();
        }
        System.out.println(arrStr);
        updatePar(arrStr);
        updateArr(arrStr);
//        outPut();
    }

    static void updatePar(LinkedList arr) {
        gameType=arr.get(0).toString();
        timeMode=arr.get(1).toString();
        openMode=arr.get(2).toString();
        arrSize=arr.get(3).toString();
        System.out.println("gameType= "+gameType);
        System.out.println("timeNode= "+timeMode);
        System.out.println("openMode= "+openMode);
        System.out.println("arrSize= "+arrSize);
    }
    static void updateArr(LinkedList arrl){
        boolean side=true;
        String row="",col="";
        for (int i = 0; i <arrSize.length()-1 ; i++) {
            if(arrSize.charAt(i)=='x') {
                side = false;
                i++;
            }
            if(side)
                row+=arrSize.charAt(i);
            else
                col+=arrSize.charAt(i);
        }
        rows= Integer.parseInt(row);
        cols=Integer.parseInt(col);
        arrSrc =new String[rows][cols];
        arrDst =new String[rows][cols];
        insertInArr(arrl,true,4);
        insertInArr(arrl,false,4+rows+1);
        System.out.println("\nprint the arrSrc:\n");
        System.out.println(Arrays.deepToString(arrSrc));
        System.out.println("\nprint the arrDst:\n");
        System.out.println(Arrays.deepToString(arrDst));

    }
    static void insertInArr(LinkedList arrl,Boolean f,int point){
        int j=0;
        String[][] container=new String[rows][];
        for(int i =point; i<rows+point;i++){
            String[] temp= arrl.get(i).toString().split(",");
            container[j++]=temp;
        }
        for (int i = 0; i < container.length; i++) {
            for (int c = 0; c < container[0].length; c++) {
                if(f)
                    arrSrc[i][c]=container[i][c];
                else
                    arrDst[i][c]=container[i][c];
            }
        }
    }
}
