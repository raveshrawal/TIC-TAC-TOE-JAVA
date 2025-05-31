import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        char[][] board = new char[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        
        Scanner rr = new Scanner(System.in);
        
        while(!gameOver){
            
            printBoard(board);

            System.out.print("Player " + player + " enter : ");
            int row = rr.nextInt();
            int col = rr.nextInt();
            if(board[row][col]==' '){
                board[row][col] = player;
                gameOver = hasWon(board,player);
                if(gameOver){
                    System.out.println("Player " + player + " has won");
                }else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Invalid Move... Try Again!!!");
            }
        }

    }

    private static void printBoard(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+ " | ");
            }
            System.out.println();
        }
    }

    private static boolean hasWon(char[][] board, char player){
        // check row
        for(int i=0;i<3;i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player ){
                return true;
            }
        }
        // check col
        for(int j=0;j<3;j++){
            if(board[0][j] == player && board[1][j] == player && board[2][j] == player ){
                return true;
            }
        }
        //Diagonal prim
        if(board[0][0]== player && board[1][1]== player && board[2][2]== player ){
            return true;
        }
        if(board[0][2]== player && board[1][1]== player && board[2][0]== player ){
            return true;
        }
        return false;
    }
}
