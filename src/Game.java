public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game() {
        board = new Board(this); // Link to the game object
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {  // New method to get the Board instance
        return board;
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean checkWin() {
        return board.checkWin(currentPlayer.getMarker());
    }

    public void resetGame() {
        board.resetBoard();
        currentPlayer = player1;
    }
}
