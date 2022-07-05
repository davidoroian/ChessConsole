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
        if (((this.getX()==1&&this.id==7)||(this.getX()==6&&this.id==1))&& Math.abs(this.getX()-x)==2 && (this.getX() != x || this.getY() != y))
            if (y == this.getY() && board[x][y] == 0) { //forward if no piece in front
                if (board[x][y] == 0) return true;
            }
        if (Math.abs(this.getX()-x)==1 && (x >= 0 && x < 8) && (y >= 0 && y < 8) && (this.getX() != x || this.getY() != y)) { //one step forward at a time in any direction
            if (y == this.getY() && board[x][y] == 0) { //forward if no piece in front
                if (board[x][y] == 0) return true;
            }
            if (Math.abs(this.getY()-y)==1 && board[x][y] != 0) { //to the sides to attack
                if (board[x][y] >= 7 && board[x][y] <= 12 && this.id==1) return true;
                if (board[x][y] >= 1 && board[x][y] <= 6 && this.id==7) return true;
            }
        }
        return false;
    }

}
