package com.mypackage;

import piece.Piece;

import java.util.Set;

public class Game {
    private final Board board;
    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();
    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop(){
        boolean isWhiteToMove = true;
        while(true){
            // render
            renderer.render(board);

            if(isWhiteToMove){
                System.out.println("Mouvement de blanc");
            }else{
                System.out.println("Mouvement de noir");
            }
            // input
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(isWhiteToMove ? Color.WHITE : Color.BLACK, board);

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);

            // make move
            board.movePiece(sourceCoordinates, targetCoordinates);
            // pass move
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
