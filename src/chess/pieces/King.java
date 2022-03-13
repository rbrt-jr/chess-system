package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

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

	private boolean canMove(Position position) {
		ChessPiece aux = (ChessPiece) getBoard().piece(position);
		return aux == null || aux.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece aux = (ChessPiece) getBoard().piece(position);
		return aux != null && aux instanceof Rook && aux.getColor() == getColor() && aux.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position aux = new Position(0, 0);

		// above
		aux.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// below
		aux.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// left
		aux.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// right
		aux.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// north-west
		aux.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// north-east
		aux.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// south-west
		aux.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// south-east
		aux.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(aux) && canMove(aux)) {
			mat[aux.getRow()][aux.getColumn()] = true;
		}

		// move castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// castling kingside rook
			Position posRook1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(posRook1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}

			}

			// castling queenside rook
			Position posRook2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(posRook2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}

			}
		}

		return mat;
	}

}
