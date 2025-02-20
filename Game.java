import java.util.Scanner;

public class Game{
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;
    private boolean gameEnd;

    public Game(){
        board = new Board();
        scanner = new Scanner(System.in);
        player1 = new Player("Player 1", 'O');
        player2 = new Player("Player 2", 'X');
        currentPlayer = player1;
        gameEnd = false;
    }

    public void play(){
        while(!gameEnd){
            board.printBoard();
            System.out.print(currentPlayer.getName() + " move (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(!board.placeMove(x, y, currentPlayer.getSymbol())){
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if(board.checkWin(currentPlayer.getSymbol())){
                board.printBoard();
                System.out.println(currentPlayer.getName() + " WIN!");
                gameEnd = true;
                break;
            }

            if(board.isTie()){
                board.printBoard();
                System.out.println("It's a tie!");
                gameEnd = true;
                break;
            }

            switchTurn();
        }
    }

    private void switchTurn(){
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
