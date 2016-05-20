public class SumMatrix implements Runnable{
    static String SumGlobal;
    static int row , col;
    static String matrix[][];
    int id;
    
    static{
        row = 4;
        col = 4;
        matrix = new String[row][col];
        
        for(int i = 0 ; i < row; i++)
            for(int j = 0; j < col; j++){
                int tmp = (int)(Math.random() * 36) + 1; 
                
                String result = "";
                int toString = 0;
                for(int k = 0; k < tmp; k++){
                    toString = (int)(Math.random() * 25) + 97;
                    result += new Character((char)toString).toString();
                }
                matrix[i][j] =  result;
            }
    }
    
    SumMatrix(int _id) { id = _id; }
    
    public void run(){
        String sumLoc = "";
        int max = 0;
        for(int i = 0; i < row; i++){
            if(max < matrix[id][i].length()){
                max = matrix[id][i].length();
                sumLoc = matrix[id][i];
            }
        }
        System.out.println("Thread's " + id + " max string is : " + sumLoc);
        SumGlobal += sumLoc;
    }
    
    public static void main(String args[]){
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                System.out.print(matrix[i][j] + " ");
                if(j == row - 1)
                    System.out.println();
            }
        
        for(int i = 0; i < row; i++)
            (new Thread(new SumMatrix(i))).start();
        try{
            Thread.sleep(1100);
        }catch(Exception e){}
        System.out.println("Cредняя длина всех строк равна : " + SumGlobal.length() / row);
    }
}

