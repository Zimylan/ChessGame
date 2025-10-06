package main;

import main.pieces.Piece;
import main.pieces.PiecesSprites;

public class BoardConsoleRenderer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_CELL_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_CELL_BACKGROUND = "\u001B[0;100m";

    public void render(Board board) {
        for (int rank = 8; rank >= 1 ; rank--) {
            String line = "";
            for (File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isCellEmpty(coordinates)) {
                    line += getSpriteForEmptyCell(coordinates);
                } else {
                    line += getPieceSprite(board.getPiece(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    public String colorizeSprite(String sprite, Color pieceColor, boolean isCellBlack) {
        String result = sprite;

        if (pieceColor == Color.BLACK) {
            result = ANSI_BLACK_PIECE_COLOR + result;
        } else {
            result = ANSI_WHITE_PIECE_COLOR + result;
        }

        if (isCellBlack) {
            result = ANSI_BLACK_CELL_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_CELL_BACKGROUND + result;
        }
    return result;
    }

    public String setPieceSprite(Piece piece) {
        switch(piece.getClass().getSimpleName()){
            case "Bishop" :
                return PiecesSprites.Bishop.sprite;
            case "King" :
                return PiecesSprites.King.sprite;
            case "Knight" :
                return PiecesSprites.Knight.sprite;
            case "Pawn" :
                return PiecesSprites.Pawn.sprite;
            case "Queen" :
                return PiecesSprites.Queen.sprite;
            case "Rook" :
                return PiecesSprites.Rook.sprite;
        } return "";
    }

    public String getSpriteForEmptyCell(Coordinates coordinates) {
        return colorizeSprite("   ", Color.WHITE, Board.cellIsBlack(coordinates));
    }

    private String getPieceSprite(Piece piece) {
        return colorizeSprite(" " + setPieceSprite(piece) + " ", piece.color, Board.cellIsBlack(piece.coordinates));
    }

}
