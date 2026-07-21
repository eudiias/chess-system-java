package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
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

        return mat;
    }

    private boolean canMove(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);

        return p == null || p.getColor() != getColor();
    }
}
