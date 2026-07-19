import Application.UI;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

void main() {

    Scanner sc = new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();

    while (true)
    {
        UI.printBoard(chessMatch.getPieces());
        System.out.println();

        System.out.print("Print source: ");
        ChessPosition source = UI.readChessPosition(sc);

        System.out.print("Print target: ");
        ChessPosition target = UI.readChessPosition(sc);

        ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
    }
}
