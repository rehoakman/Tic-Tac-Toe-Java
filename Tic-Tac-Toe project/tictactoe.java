import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TO DO:


//class tictactoe contains function called "main"
class tictactoe{

    //function
    public static void main(String[] args){
        //creates 2D array char data type variable named board
        char[][] board = new char[3][3];
        //initializes it,
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
    
    // 1.put input here for player names and put into variables type string
    Scanner in = new Scanner(System.in); //scanner object created
    System.out.println("Welcome to tic tac toe");
    System.out.println("Player 1 please enter name: ");
    String player1 = in.nextLine();
    System.out.println("Player 2 please enter name: ");
    String player2 = in.nextLine();
    //in.close();

    //1.1 random assignment who goes first 
// used random object and nextInt method setting bound at 2 + 1 b/c the bound is excluded
    Random random = new Random();
    int turn = random.nextInt(2) + 1;
    // conditionals that determine who goes first based on what variable:'turn' is.
    if (turn == 1){
        //do something here
        System.out.println(player1 + "'s turn (x)");
    }
    else{
        System.out.println(player2 + "'s turn (o)");
    }

    //this will store which letter to use based on who's turn it is
    // if turn is 1, playe 1 goes and uses x, else player 2 goes and uses o
    char c = '-';
    if(turn == 1){
        c = 'x';
    }
    else{
        c = 'o';
    }

    //initialize row and col variables that will be used as indexes
    // for the board
    int row = 0;
    int col = 0;

    // while loop to make sure user enters valid input for
    //selecting position on board. use break to end it

    while(true){
        System.out.print("Select which row to place (0,1,2): ");
        row = in.nextInt();
        System.out.print("Select which col to place (0,1,2): ");
        col = in.nextInt();

        //to check if row and col are valid
        if(row < 0 || col < 0 || row > 2 || col > 2){
            System.out.println("Position not valid, please re-enter.");
        }
        // if position is already taken by another character thats not '-'
        else if(board[row][col] != '-'){
            System.out.println("Position already taken, re-enter");
        }
        // else case for if position is valid, change position to c variable
        // then break
        else{
            board[row][col] = c;
            break;
            }  
         }        
    displayBoard(board);
    //To see if someone won or not. // playerWon checks the symbol at a spot
    // and the code below will check to see what it is, and determine winner
    if(playerWon(board) == 'x'){
        System.out.println(player1 + " has won the game");
        System.exit(0);
    }
    else if(playerWon(board) == 'o'){
        System.out.println(player2 + " has won the game");
        System.exit(0);
    }
    else{
        if (boardFull(board)){
            System.out.println("Game is a draw");
            System.exit(0);
        }
    }

    }

                    // takes parameter of double char array called board
                    //which is the same board being inititialized
    public static void displayBoard(char[][] board){       
        for (char[] row: board){
            for (char c : row){
                System.out.print(c);         
            }
            
            System.out.println();
        } 
    }
    //function to check if a player won or not
    public static char playerWon(char[][] board){
        // to check each individual row
        //for loop is saying that i which is 0 will be added by 1 as long as
        // it is less than 3. And for each iteration of i, do the if statement 
        // in brackets
        for(int i=0; i < 3; i++){
            // comparing the board at [i](row) and a different [col] to see
            // if all of them are not equal to '-'
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] &&
            board[i][0] != '-'){
                return board[i][0];
            }
        }
        //checking column, similiar rules to above
        for (int j=0; j < 3; j++){
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] &&
            board[0][j] != '-'){
                return board[0][j];
            }
        }
        // check diagonals both left and right, similiar rules
        //hardchecking each spot in a diagonal pattern and comparing to eachother
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] &&
        board[0][0] != '-'){
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] == board[0][2] &&
        board[2][0] != '-'){
            return board[2][0];
        }

        //if nobody won yet
        return ' ';

    }
    //function that checks all spots on the board to see if
    //board is full
    public static boolean boardFull(char[][] board){
     //   double for loop iterates thru array and elements
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }



}

