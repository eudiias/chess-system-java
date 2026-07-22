package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position aux = new Position(0, 0);

        //above
        aux.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //below
        aux.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //left
        aux.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //right
        aux.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //north-west
        aux.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //north-east
        aux.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //sul-west
        aux.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //sul-east
        aux.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        // Special move castling

        if (getMoveCount() == 0 && !chessMatch.getCheck())
        {
            // small rook
            Position positionRook1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(positionRook1))
            {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null)
                {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // large rook
            Position positionRook2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(positionRook2))
            {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null)
                {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }

    private boolean canMove(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);

        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }
}
