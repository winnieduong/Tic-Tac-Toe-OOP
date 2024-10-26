import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTTileButton extends JButton {
    private int row;
    private int col;
    private char marker;
    private Game game;

    public TTTTileButton(int row, int col, Game game) {
        this.row = row;
        this.col = col;
        this.game = game;
        this.marker = ' ';
        setText(String.valueOf(marker));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (marker == ' ') {
                    marker = game.getCurrentPlayer().getMarker();
                    setText(String.valueOf(marker));

                    if (game.checkWin()) {
                        ((GameFrame) getTopLevelAncestor()).announceWinner(game.getCurrentPlayer());
                    } else if (game.getBoard().isFull()) { // Now accessible
                        ((GameFrame) getTopLevelAncestor()).announceDraw();
                    } else {
                        game.switchTurn();
                    }
                }
            }
        });
    }

    public char getMarker() {
        return marker;
    }

    public void reset() {
        marker = ' ';
        setText(String.valueOf(marker));
    }
}
