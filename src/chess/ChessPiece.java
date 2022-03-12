package chess;
//2okay
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}	

	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece aux = (ChessPiece)getBoard().piece(position);
		return aux != null && aux.getColor() != color;
	}
	
	
		
	
}
