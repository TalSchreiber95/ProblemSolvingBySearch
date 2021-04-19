import java.io.*;

public class Ex1 {
    private static String gameType="";
    private static String timeMode="";
    private static String openMode="";
    private static String arrSize="";
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        String a= "src/input2.txt";
        String b= "src/input.txt";
        if(readFileAndIns(b)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
    public static boolean readFileAndIns(String filePath) throws IOException {
        String c=readFile(filePath);
        updatePar(c);
        updateArr(c);
        return true;
    }

    //was taken: https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
    public static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        }
        catch (FileNotFoundException e){
            System.out.println("\n file Not found \n");
            e.printStackTrace();
            return "";
        }
        finally {
            reader.close();
        }
    }
    static void updatePar(String file) {
        int lineN=0;
        for(int i =0 ; i<file.length();i++){
            if(file.charAt(i)=='\n'){
                lineN++;
            }
            switch (lineN) {
                case 0:
                    gameType += file.charAt(i);
                    break;
                case 1:
                    timeMode+= file.charAt(i+1);
                    break;
                case 2:
                    openMode+=file.charAt(i+1);
                    break;
                case 3:
                    arrSize+=file.charAt(i+1);
                    break;
            }
        }
        System.out.println("gameType= "+gameType);
        System.out.print("timeNode= "+timeMode);
        System.out.print("openMode= "+openMode);
        System.out.print("arrSize= "+arrSize);
    }
    static void updateArr(String filePath){
        int side=0,r,c;
        String row="",col="";
        for (int i = 0; i <arrSize.length()-1 ; i++) {
            if(arrSize.charAt(i)=='x') {
                side = 1;
                i++;
            }
            if(side==0)
                row+=arrSize.charAt(i);
            else
                col+=arrSize.charAt(i);
        }
        col = col.replace(col.substring(col.length()-1), "");
        r= Integer.parseInt(row);
        c=Integer.parseInt(col);
        System.out.println("r="+r+"\nc="+c);
        arr=new int[r][c];
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        insertInArr(filePath);
        System.out.println("\nprint the arr:\n");
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    static void insertInArr(String file){
        int lineN=0;
        System.out.println("asdsa dsadasd sa");
        System.out.println("row="+arr.length);
        System.out.println("col="+arr[0].length);
        String arrStr="";
        for(int i =0 ; i<file.length();i++){
            if(file.charAt(i)=='\n'){
                lineN++;
            }
            if(lineN>=4 && lineN<arr.length+4){
                arrStr+=file.charAt(i);
            }
        }
        System.out.println(arrStr);
    }
}
