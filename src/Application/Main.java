import Application.UI;
import Chess.ChessMatch;

void main() {
    ChessMatch chessMatch = new ChessMatch();
    UI.printBoard(chessMatch.getPieces());
}
