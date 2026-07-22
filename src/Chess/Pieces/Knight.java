package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position aux = new Position(0, 0);

        aux.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positioExists(aux) && canMove(aux))
        {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        return mat;
    }

    private boolean canMove(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);

        return p == null || p.getColor() != getColor();
    }
}
