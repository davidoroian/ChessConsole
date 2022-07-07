import javax.swing.*;
import java.util.*;

public class Game {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Game game=new Game();

        ChessBoard chessBoard = new ChessBoard(); //empty board
        //chessBoard.displayBoard();

        Map<Integer,Integer>takenPieces=new HashMap<>(){{//map to store the id of the pieces and the number of pieces that are taken
            for (int i=1;i<=12;i++)
                put(i,0);
        }};

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
            int takenID=-1;//get the (eventual) ID of the piece that is taken by the piece. if  it remains -1, no piece is taken

            switch (chessBoard.getBoard()[pieceX][pieceY]) { //getting the id of the piece, so I know what piece I want to move
                case 1 -> {
                    for (int i = 0; i < 8; i++) {
                        if (blackPawn[i].getX() == pieceX && blackPawn[i].getY() == pieceY) {//finding the right black pawn
                            blackPawn[i].move(chessBoard.getBoard(), toX, toY);//moving the pawn
                            takenID=blackPawn[i].getTakenID();//update the ID of the taken piece
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < 2; i++) {
                        if (blackRook[i].getX() == pieceX && blackRook[i].getY() == pieceY) { //finding the right black rook
                            blackRook[i].move(chessBoard.getBoard(), toX, toY);   //moving the rook
                            takenID=blackRook[i].getTakenID();
                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < 2; i++) {
                        if (blackKnight[i].getX() == pieceX && blackKnight[i].getY() == pieceY) { //finding the right black knight
                            blackKnight[i].move(chessBoard.getBoard(), toX, toY);   //moving the knight
                            takenID=blackKnight[i].getTakenID();
                        }
                    }
                }
                case 4 -> {
                    for (int i = 0; i < 2; i++) {
                        if (blackBishop[i].getX() == pieceX && blackBishop[i].getY() == pieceY) { //finding the right black bishop
                            blackBishop[i].move(chessBoard.getBoard(), toX, toY);   //moving the bishop
                            takenID=blackBishop[i].getTakenID();
                        }
                    }
                }
                case 5 -> {
                    blackKing.move(chessBoard.getBoard(), toX, toY);
                    takenID=blackKing.getTakenID();
                }
                case 6 -> {
                    blackQueen.move(chessBoard.getBoard(), toX, toY);
                    takenID= blackQueen.getTakenID();
                }
                case 7 -> {
                    for (int i = 0; i < 8; i++) {
                        if (whitePawn[i].getX() == pieceX && whitePawn[i].getY() == pieceY) { //finding the right white pawn
                            whitePawn[i].move(chessBoard.getBoard(), toX, toY);   //moving the pawn
                            takenID=whitePawn[i].getTakenID();
                        }
                    }
                }
                case 8 -> {
                    for (int i = 0; i < 2; i++) {
                        if (whiteRook[i].getX() == pieceX && whiteRook[i].getY() == pieceY) { //finding the right white rook
                            whiteRook[i].move(chessBoard.getBoard(), toX, toY);   //moving the rook
                            takenID=whiteRook[i].getTakenID();
                        }
                    }
                }
                case 9 -> {
                    for (int i = 0; i < 2; i++) {
                        if (whiteKnight[i].getX() == pieceX && whiteKnight[i].getY() == pieceY) { //finding the right white knight
                            whiteKnight[i].move(chessBoard.getBoard(), toX, toY);   //moving the knight
                            takenID= whiteKnight[i].getTakenID();
                        }
                    }
                }
                case 10 -> {
                    for (int i = 0; i < 2; i++) {
                        if (whiteBishop[i].getX() == pieceX && whiteBishop[i].getY() == pieceY) { //finding the right white bishop
                            whiteBishop[i].move(chessBoard.getBoard(), toX, toY);   //moving the bishop
                            takenID=whiteBishop[i].getTakenID();
                        }
                    }
                }
                case 11 -> {
                    whiteKing.move(chessBoard.getBoard(), toX, toY);
                    takenID=whiteKing.getTakenID();
                }
                case 12 -> {
                    whiteQueen.move(chessBoard.getBoard(), toX, toY);
                    takenID=whiteQueen.getTakenID();
                }
                default -> throw new IllegalStateException("Unexpected value: " + chessBoard.getBoard()[pieceX][pieceY]);
            }
            if (takenID!=-1)//verify if a piece was taken
                takenPieces.put(takenID,takenPieces.get(takenID)+1);

            if (pieceX!=toX)
                game.putNewID(chessBoard,toX,toY,takenPieces);

            chessBoard.displayBoard();

            for (Integer x : takenPieces.values())//display the values from the map
                System.out.println(x);

        }
    }

    public int checkTop(int id, int x,Map<Integer,Integer>takenPieces){//check if the piece arrived at the other end of the board
        if (Arrays.asList(1,2,3,4,6).contains(id) && x==0){
            //ask to introduce the piece id (from the removed ones) you want to change the current piece
            String answear;
            do{
                System.out.println("Do you want to replace the piece with an removed one? (Y/N): ");
                answear=in.next();
            }while (!Objects.equals(answear, "Y") && !Objects.equals(answear, "N"));

            if (answear.equals("Y")) {
                System.out.println("What piece do you want to put? Enter the id (1-6) ");
                while (true) {
                    int newID = in.nextInt();
                    if (takenPieces.get(newID) != 0 && Arrays.asList(1,2,3,4,6).contains(newID)) {
                        takenPieces.put(newID, takenPieces.get(newID) - 1);//subtract them from the map
                        return newID;
                    } else
                        System.out.println("Piece isn't taken!");
                }
            }
        }
        if (Arrays.asList(7,8,9,10,12).contains(id) && x==7){
            String answear;
            do{
                System.out.println("Do you want to replace the piece with an removed one? (Y/N): ");
                answear=in.next();
            }while (!Objects.equals(answear, "Y") && !Objects.equals(answear, "N"));

            if (answear.equals("Y")) {

                System.out.println("What piece do you want to put? Enter the id (7-12) ");
                while (true) {
                    int newID = in.nextInt();
                    if (takenPieces.get(newID) != 0 && Arrays.asList(7,8,9,10,12).contains(newID)) {
                        takenPieces.put(newID, takenPieces.get(newID) - 1);
                        return newID;
                    } else
                        System.out.println("Piece isn't taken!");
                }
            }
        }
        return -1;
    }

    public void putNewID(ChessBoard chessBoard, int x, int y, Map<Integer,Integer>takenPieces){
        int id=chessBoard.getBoard()[x][y];
        int newID=checkTop(id,x,takenPieces);
        if (newID!=-1) {
            takenPieces.put(id,takenPieces.get(id)+1);//take the piece out
            chessBoard.getBoard()[x][y] = newID;//put the new piece on the board
        }
    }
}
