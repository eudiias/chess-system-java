package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class Pawn extends ChessPiece {
    ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if(getColor() == Color.WHITE)
        {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positioExists(p) && !getBoard().thereIsAPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positioExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positioExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0)
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positioExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positioExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // en passant left

            if (position.getRow() == 3)
            {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positioExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnpassantVulnerable())
                {
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }
            }

            if (position.getRow() == 3)
            {
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positioExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnpassantVulnerable())
                {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }
        else
        {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positioExists(p) && !getBoard().thereIsAPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positioExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positioExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0)
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positioExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positioExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // en passant

            if (position.getRow() == 3)
            {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positioExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnpassantVulnerable())
                {
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }
            }

            if (position.getRow() == 4)
            {
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positioExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnpassantVulnerable())
                {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        return mat;
    }
}
