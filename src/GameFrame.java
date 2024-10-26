import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame {
    private Game game;
    private Board board;

    public GameFrame() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        game = new Game();
        board = game.getBoard(); // Now we can use game.getBoard()

        add(board);
        setVisible(true);
    }

    public void announceWinner(Player winner) {
        JOptionPane.showMessageDialog(this, winner.getName() + " wins!");
        game.resetGame();
    }

    public void announceDraw() {
        JOptionPane.showMessageDialog(this, "It's a draw!");
        game.resetGame();
    }
}
