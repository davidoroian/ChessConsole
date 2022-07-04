import java.util.Scanner;

public class Game {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(); //empty board
        //chessBoard.displayBoard();

        Pawn[] blackPawn = new Pawn[8];   //black pawns
        for (int i = 0; i < 8; i++) {
            blackPawn[i] = new Pawn(6, i, "black");
            chessBoard.placePiece(blackPawn[i]);
        }

        Pawn[] whitePawn = new Pawn[8];   //white pawns
        for (int i = 0; i < 8; i++) {
            whitePawn[i] = new Pawn(1, i, "white");
            chessBoard.placePiece(whitePawn[i]);
        }

        Rook[] blackRook = new Rook[2]; // black rooks
        blackRook[0] = new Rook(7, 0, "black");
        chessBoard.placePiece(blackRook[0]);
        blackRook[1] = new Rook(7, 7, "black");
        chessBoard.placePiece(blackRook[1]);

        Rook[] whiteRook = new Rook[2]; // white rooks
        whiteRook[0] = new Rook(0, 0, "white");
        chessBoard.placePiece(whiteRook[0]);
        whiteRook[1] = new Rook(0, 7, "white");
        chessBoard.placePiece(whiteRook[1]);

        Knight[] blackKnight = new Knight[2]; // black knights
        blackKnight[0] = new Knight(7, 1, "black");
        chessBoard.placePiece(blackKnight[0]);
        blackKnight[1] = new Knight(7, 6, "black");
        chessBoard.placePiece(blackKnight[1]);

        Knight[] whiteKnight = new Knight[2]; // white rooks
        whiteKnight[0] = new Knight(0, 1, "white");
        chessBoard.placePiece(whiteKnight[0]);
        whiteKnight[1] = new Knight(0, 6, "white");
        chessBoard.placePiece(whiteKnight[1]);

        Bishop[] blackBishop = new Bishop[2]; // black bishops
        blackBishop[0] = new Bishop(7, 2, "black");
        chessBoard.placePiece(blackBishop[0]);
        blackBishop[1] = new Bishop(7, 5, "black");
        chessBoard.placePiece(blackBishop[1]);

        Bishop[] whiteBishop = new Bishop[2]; // white bishops
        whiteBishop[0] = new Bishop(0, 2, "white");
        chessBoard.placePiece(whiteBishop[0]);
        whiteBishop[1] = new Bishop(0, 5, "white");
        chessBoard.placePiece(whiteBishop[1]);

        King blackKing = new King(7, 3, "black"); //black king
        chessBoard.placePiece(blackKing);

        King whiteKing = new King(0, 3, "white"); // white king
        chessBoard.placePiece(whiteKing);

        Queen blackQueen = new Queen(7, 4, "black"); //black queen
        chessBoard.placePiece(blackQueen);

        Queen whiteQueen = new Queen(0, 4, "white"); //white queen
        chessBoard.placePiece(whiteQueen);

        chessBoard.displayBoard();
        while (true) {
            int pieceX, pieceY;    //what piece you want to move
            System.out.print("Write the coordinates of the piece you want to move: ");
            pieceX = in.nextInt();
            pieceY = in.nextInt();
            while (chessBoard.getBoard()[pieceX][pieceY] == 0) { //verify if the piece you want to move exists
                System.out.print("There is no piece there, write the coordinates again: ");
                pieceX = in.nextInt();
                pieceY = in.nextInt();
            }

            int toX, toY;    //destination
            System.out.print("Write the coordinates where you want to move the piece: ");
            toX = in.nextInt();
            toY = in.nextInt();
            switch (chessBoard.getBoard()[pieceX][pieceY]) { //getting the id of the piece, so I know what piece I want to move
                case 1 -> {
                    for (int i = 0; i < 8; i++) {
                        if (blackPawn[i].getX() == pieceX && blackPawn[i].getY() == pieceY) { //finding the right black pawn
                            blackPawn[i].move(chessBoard.getBoard(), toX, toY);   //moving the pawn
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < 2; i++) {
                        if (blackRook[i].getX() == pieceX && blackRook[i].getY() == pieceY) { //finding the right black rook
                            blackRook[i].move(chessBoard.getBoard(), toX, toY);   //moving the rook
                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < 2; i++) {
                        if (blackKnight[i].getX() == pieceX && blackKnight[i].getY() == pieceY) { //finding the right black knight
                            blackKnight[i].move(chessBoard.getBoard(), toX, toY);   //moving the knight
                        }
                    }
                }
                case 4 -> {
                    for (int i = 0; i < 2; i++) {
                        if (blackBishop[i].getX() == pieceX && blackBishop[i].getY() == pieceY) { //finding the right black bishop
                            blackBishop[i].move(chessBoard.getBoard(), toX, toY);   //moving the bishop
                        }
                    }
                }
                case 5 -> {
                    blackKing.move(chessBoard.getBoard(), toX, toY);
                }
                case 6 -> {
                    blackQueen.move(chessBoard.getBoard(), toX, toY);
                }
                case 7 -> {
                    for (int i = 0; i < 8; i++) {
                        if (whitePawn[i].getX() == pieceX && whitePawn[i].getY() == pieceY) { //finding the right white pawn
                            whitePawn[i].move(chessBoard.getBoard(), toX, toY);   //moving the pawn
                        }
                    }
                }
                case 8 -> {
                    for (int i = 0; i < 2; i++) {
                        if (whiteRook[i].getX() == pieceX && whiteRook[i].getY() == pieceY) { //finding the right white rook
                            whiteRook[i].move(chessBoard.getBoard(), toX, toY);   //moving the rook
                        }
                    }
                }
                case 9 -> {
                    for (int i = 0; i < 2; i++) {
                        if (whiteKnight[i].getX() == pieceX && whiteKnight[i].getY() == pieceY) { //finding the right white knight
                            whiteKnight[i].move(chessBoard.getBoard(), toX, toY);   //moving the knight
                        }
                    }
                }
                case 10 -> {
                    for (int i = 0; i < 2; i++) {
                        if (whiteBishop[i].getX() == pieceX && whiteBishop[i].getY() == pieceY) { //finding the right white bishop
                            whiteBishop[i].move(chessBoard.getBoard(), toX, toY);   //moving the bishop
                        }
                    }
                }
                case 11 -> {
                    whiteKing.move(chessBoard.getBoard(), toX, toY);
                }
                case 12 -> {
                    whiteQueen.move(chessBoard.getBoard(), toX, toY);
                }
                default -> throw new IllegalStateException("Unexpected value: " + chessBoard.getBoard()[pieceX][pieceY]);
            }
            chessBoard.displayBoard();
        }
    }
}
