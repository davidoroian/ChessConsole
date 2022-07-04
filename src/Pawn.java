public class Pawn extends ChessPiece {
    public Pawn(int x, int y, String color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
        switch (color) {
            case "black" -> {
                this.id = 1;
            }
            case "white" -> {
                this.id = 7;
            }
            default -> System.out.println("Unexpected value: " + color);
        }
    }

    @Override
    public boolean movePossible(int[][] board, int x, int y) {
        switch (color) {
            case "black" -> {
                if ((x == this.getX() - 1 && x >= 0 && x < 8) && (y >= 0 && y < 8) && (this.getX() != x || this.getY() != y)) { //one step forward at a time in any direction
                    if (y == this.getY() && board[x][y] == 0) { //forward if no piece in front
                        if (board[x][y] == 0) return true;
                    }
                    if ((y == this.getY() - 1 || y == this.getY() + 1) && board[x][y] != 0) { //to the sides to attack
                        if (board[x][y] >= 7 && board[x][y] <= 12) return true;
                    }
                }
            }
            case "white" -> { //same but for white
                if ((x == this.getX() + 1 && x >= 0 && x < 8) && (y >= 0 && y < 8) && (this.getX() != x || this.getY() != y)) {
                    if (y == this.getY() && board[x][y] == 0) {
                        if (board[x][y] == 0) return true;
                    }
                    if ((y == this.getY() - 1 || y == this.getY() + 1) && board[x][y] != 0) {
                        if (board[x][y] >= 1 && board[x][y] <= 6) return true;
                    }
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + color);
        }
        return false;
    }

    @Override
    public void move(int[][] board, int x, int y) {
        int temp;
        if (movePossible(board, x, y)) {
            if (board[x][y] == 0) { //moving to an open position case
                temp = board[this.getX()][this.getY()];
                board[this.getX()][this.getY()] = board[x][y];
                board[x][y] = temp;
            } else { //attacking a piece
                board[x][y] = board[this.getX()][this.getY()];
                board[this.getX()][this.getY()] = 0;
            }
            this.setX(x);   //we update the coordinates of the piece
            this.setY(y);
        } else {
            System.out.println("\nMove was not possible!!\n");
        }
    }
}
