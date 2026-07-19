import Application.UI;
import BoardGame.Board;
import Chess.ChessMatch;

void main() {
    ChessMatch chessMatch = new ChessMatch();
    UI.printBoard(chessMatch.getPieces());
}
