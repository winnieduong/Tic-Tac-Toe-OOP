import javax.swing.JPanel;
import java.awt.GridLayout;

public class Board extends JPanel {
    private TTTTileButton[][] tiles;
    private Game game;

    public Board(Game game) {
        this.game = game;
        tiles = new TTTTileButton[3][3];
        setLayout(new GridLayout(3, 3));
        initBoard();
    }

    private void initBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col] = new TTTTileButton(row, col, game);
                add(tiles[row][col]);
            }
        }
    }

    public boolean checkWin(char marker) {
        // Horizontal, vertical, and diagonal win checks
        for (int i = 0; i < 3; i++) {
            if (tiles[i][0].getMarker() == marker && tiles[i][1].getMarker() == marker && tiles[i][2].getMarker() == marker)
                return true;
            if (tiles[0][i].getMarker() == marker && tiles[1][i].getMarker() == marker && tiles[2][i].getMarker() == marker)
                return true;
        }
        if (tiles[0][0].getMarker() == marker && tiles[1][1].getMarker() == marker && tiles[2][2].getMarker() == marker)
            return true;
        if (tiles[0][2].getMarker() == marker && tiles[1][1].getMarker() == marker && tiles[2][0].getMarker() == marker)
            return true;
        return false;
    }

    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col].reset();
            }
        }
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (tiles[row][col].getMarker() == ' ')
                    return false;
            }
        }
        return true;
    }
}
