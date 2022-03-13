package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}

	private boolean canMove(Position position) {
		ChessPiece aux = (ChessPiece) getBoard().piece(position);
		return aux == null || aux.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position aux = new Position(0, 0);

		aux.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		aux.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		aux.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		aux.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		aux.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		aux.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		aux.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		aux.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		return mat;
	}

}
