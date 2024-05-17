package com.mypackage;

import piece.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input(){
        while(true){
            System.out.println("Entreez une coordinates (ex. a1)");

            String line = scanner.nextLine();

            if(line.length() !=2){
                System.out.println("Invalid format");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if(!Character.isLetter(fileChar)){
                System.out.println("Invalid format");
                continue;
            }

            if(!Character.isDigit(rankChar)){
                System.out.println("Invalid format");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);
            if( rank < 1 || rank > 8){
                System.out.println("Invalid format");
                continue;
            }

            File file = File.fromChar(fileChar);
            if(file == null){
                System.out.println("Invalid format");
                continue;
            }
            return new Coordinates(file, rank);
        }
    }
    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board){
        while(true){
            System.out.println("Entrez une coordinate pour qu'une piece se bouge");
            Coordinates coordinates = input();

            if(board.isSquareEmpty(coordinates)){
                System.out.println("Case vide");
                continue;
            }

            Piece piece = board.getPiece(coordinates);
            if(piece.color != color){
                System.out.println("Mauvaise couleur");
                continue;
            }

            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            if(availableMoveSquares.size() == 0){
                System.out.println("Piece est bloquée");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates){
        while(true){
            System.out.println("Entrez votre mouvement pour la pièce sélectionnée");
            Coordinates input = input();

            if(!coordinates.contains(input)){
                System.out.println("Carré non disponible");
                continue;
            }
            return input;
        }
    }

    public static void main(String[] args){
        Board board = new Board();
        board.setupDefaultPiecesPositions();

        Coordinates coordinates = inputPieceCoordinatesForColor(Color.WHITE, board);
        System.out.println(coordinates);
    }
}
