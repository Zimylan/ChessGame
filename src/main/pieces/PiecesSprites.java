package main.pieces;

public enum PiecesSprites {
    Bishop("♗"),
    King("♔"),
    Knight("♘"),
    Pawn("♙"),
    Queen("♕"),
    Rook("♖");

    public final String sprite;

    PiecesSprites(String pieceSprite) {
        this.sprite = pieceSprite;
    }

}
