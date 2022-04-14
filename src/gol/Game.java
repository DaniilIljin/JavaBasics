package gol;

public class Game {

    private boolean[][] board = new boolean[20][15];

    public void markAlive(int x, int y) {
        board[x][y] = true;
    }

    public boolean isAlive(int x, int y) {
        return board[x][y];
    }

    public void toggle(int x, int y) {
        if(isAlive(x, y)){
            board[y][x] = false;
        }else {
            markAlive(x, y);
        }
    }

    public boolean findNeighbour(int x, int y){
        try {
            return board[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public Integer getNeighbourCount(int x, int y) {
        int counter = 0;
        int localX = x - 1;
        for (int i = 0; i < 3; i++) {
            int localY = y - 1;
            for (int j = 0; j < 3; j++) {
                if(findNeighbour(localX, localY) && (localX != x || localY != y)){
                    counter++;
                }
                localY++;
            }
            localX++;
        }
        return counter;
    }

    public void nextFrame() {
        boolean[][] copy = new boolean[20][15];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                copy[x][y] = nextState(board[x][y], getNeighbourCount(x, y));
            }
        }
        board = copy;
    }

    public void clear() {
        board = new boolean[20][15];
    }

    public boolean nextState(boolean isLiving, int neighborCount) {
        if (neighborCount == 2 || neighborCount == 3){
            if(neighborCount == 2){
                return isLiving;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
