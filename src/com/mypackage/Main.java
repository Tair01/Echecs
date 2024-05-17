package com.mypackage;

import com.mypackage.Board;
import com.mypackage.BoardConsoleRenderer;
import piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args){
        //Board board = new Board();
        //board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN("3k4/8/5n2/2N5/3B4/8/8/3K4 w - - 0 1");

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        //renderer.render(board);

        /*Piece piece = board.getPiece(new Coordinates(File.G, 8));
        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

        int x = 123;*/

        Game game = new Game(board);
        game.gameLoop();
    }
}
