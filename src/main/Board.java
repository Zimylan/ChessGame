package main;

import main.pieces.*;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPieces(Coordinates coordinates,Piece piece) {
        pieces.put(coordinates, piece);
        piece.coordinates = coordinates; // Обновление координат фигуры при расположении на доске
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    public void setupDefaultPiecesPositions() {
        for (File file : File.values()) {
            setPieces(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPieces(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));
            if (file == File.A || file == File.H) {
                setPieces(new Coordinates(file, 1), new Rook(Color.WHITE, new Coordinates(file, 1)));
                setPieces(new Coordinates(file, 8), new Rook(Color.BLACK, new Coordinates(file, 8)));
            }
            if (file == File.B || file == File.G) {
                setPieces(new Coordinates(file, 1), new Knight(Color.WHITE, new Coordinates(file, 1)));
                setPieces(new Coordinates(file, 8), new Knight(Color.BLACK, new Coordinates(file, 8)));
            }
            if (file == File.C || file == File.F) {
                setPieces(new Coordinates(file, 1), new Bishop(Color.WHITE, new Coordinates(file, 1)));
                setPieces(new Coordinates(file, 8), new Bishop(Color.BLACK, new Coordinates(file, 8)));
            }
            if (file == File.D) {
                setPieces(new Coordinates(file, 1), new Queen(Color.WHITE, new Coordinates(file, 1)));
                setPieces(new Coordinates(file, 8), new Queen(Color.BLACK, new Coordinates(file, 8)));
            }
            if (file == File.E) {
                setPieces(new Coordinates(file, 1), new King(Color.WHITE, new Coordinates(file, 1)));
                setPieces(new Coordinates(file, 8), new King(Color.BLACK, new Coordinates(file, 8)));
            }
        }
    }

    public static boolean cellIsBlack(Coordinates coordinates) {
        boolean isBlack = (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
        return  isBlack;
    }
}
