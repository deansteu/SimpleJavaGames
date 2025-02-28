package tictactoe;
import java.util.Arrays;
import java.util.Scanner;


public class TicTacToe {

    public char[] playerBoard = new char[9];
    public char currentPlayer = 'X';


    public static void main(String[] args){
        System.out.println("Hello World From TicTacToe V1");
        TicTacToe game = new TicTacToe();
        game.run();
    }

    public boolean isOpen(int pos){
        if( pos < 0 || pos >= playerBoard.length ){
            return false;
        }

        if(playerBoard[pos] == '\0'){
            playerBoard[pos] = currentPlayer;
            if(currentPlayer == 'X'){
                currentPlayer = 'O';
            }else{
                currentPlayer = 'X';
            }
            return true;
        }

        return false;
    }

    public void getUserInput(){
        boolean isValidInput = false;
        while(!isValidInput){
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter board position player " + String.valueOf(currentPlayer));
            int n = reader.nextInt();
            if(n == -1){
                System.exit(0);
            }
            if(isOpen(n)){
                isValidInput=true;

            }
        }


    }

    private void drawBoard(){
        char[] arr1 = Arrays.copyOfRange(playerBoard, 0, 3);
        char[] arr2 = Arrays.copyOfRange(playerBoard, 3, 6);
        char[] arr3 = Arrays.copyOfRange(playerBoard, 6, 9);
        //System.out.println(new String(playerBoard));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }

    private boolean hasWon(){
        //TODO: Need to consider the logic here, will be ugly
        // horizontal easy
        // vertical very specific
        // diagonal very specific
        // Idea: do the array trick above, for vertical and diagonal check explicit positions


        char[] arr1 = Arrays.copyOfRange(playerBoard, 0, 3);
        char[] arr2 = Arrays.copyOfRange(playerBoard, 3, 6);
        char[] arr3 = Arrays.copyOfRange(playerBoard, 6, 9);

        // check for horizonal

        return false;
    }

    public void run(){
        Boolean gameWon = false;

        int counter = 0;

        while(!gameWon){
            //temporary
            counter+=1;
            if(counter >= 10){
                gameWon = true;
            }
            getUserInput();
            drawBoard();
            hasWon();
            System.out.println(gameWon);
        }
    }


}
