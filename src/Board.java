public class Board {
    private int SIZE;

    private String[][] ar;

    public String[][] getAr() {
        return ar;
    }

    public void print(){
        for(int i=1;i<=SIZE;i++) {
            for (int j = 1; j <= SIZE; j++) {
                System.out.print(ar[i][j]);
            }
            System.out.println();
        }
    }
    public void setAr(int row,int col,String piece) {
        this.ar[row][col]=piece;
    }

    Board(){
        SIZE=3;
    }
    public int getSIZE() {
        return SIZE;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
        this.ar=new String[SIZE+1][SIZE+1];
        for(int i=0;i<=SIZE;i++){
            for (int j=0;j<=SIZE;j++){
                this.ar[i][j]="-";
            }
        }
    }
    public GameState gameState(){
        if(winnerInRow()==GameState.WON)
            return GameState.WON;
        if(winnerInColumn()==GameState.WON)
            return GameState.WON;
        if(winnerInFirstDiagonal()==GameState.WON)
            return GameState.WON;
        if(winnerInSecondDiagonal()==GameState.WON)
            return GameState.WON;
        if(gameDrawn()==GameState.DRAW)
            return GameState.DRAW;
        return GameState.PROGRESS;
    }

    private GameState winnerInSecondDiagonal() {
        String current=this.ar[1][SIZE];
        if(this.ar[1][SIZE].equals("-"))
            return GameState.PROGRESS;
        for(int i=1,j=SIZE;i<=SIZE && j>=1;i++,j--){
                if(!current.equals(this.ar[i][j]) || ar[i][j].equals("-"))
                    return GameState.PROGRESS;
        }
        return GameState.WON;
    }

    private GameState gameDrawn() {
        for(int i=1;i<=SIZE;i++){
            for(int j=1;j<=SIZE;j++)
                if(this.ar[i][j].equals("-"))
                    return GameState.PROGRESS;
        }
        return GameState.DRAW;
    }

    private GameState winnerInFirstDiagonal() {
        String current=this.ar[1][1];
        if(this.ar[1][1].equals("-"))
            return GameState.PROGRESS;
        for(int i=1;i<=SIZE;i++){
            if(!current.equals(this.ar[i][i]) || ar[i][i].equals("-")) {
                return GameState.PROGRESS;
            }
        }
        return GameState.WON;
    }

    private GameState winnerInColumn() {
        for(int col=1;col<=SIZE;col++)
        {
            String current=ar[1][col];
            boolean winnerFound=true;
            for(int row=1;row<=SIZE;row++) {
                if(!current.equals(ar[row][col]) || ar[row][col].equals("-")) {
                    winnerFound=false;
                    break;
                }
            }
            if (winnerFound){
                return GameState.WON;
            }
        }
        return GameState.PROGRESS;
    }

    private GameState winnerInRow() {
        for(int row=1;row<=SIZE;row++)
        {
            String current=ar[row][1];
            boolean winnerFound=true;
            for(int col=1;col<=SIZE;col++) {
                if(!current.equals(ar[row][col]) || ar[row][col].equals("-")) {
                    winnerFound=false;
                    break;
                }
            }
            if (winnerFound){
                return GameState.WON;
            }
        }
        return GameState.PROGRESS;
    }

}
