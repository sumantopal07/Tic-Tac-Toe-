import java.util.*;

public class Game {
    ArrayList<Player> players;
    Board board;
    Set<String> pieces;
    int currentPlayerIndex;

    Game(){
        currentPlayerIndex=0;
        players = new ArrayList<>();
        pieces = new HashSet<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Boolean setPlayerBuilder(Player player) {
        if(pieces.contains(player.getChoice()))
            return false;
        pieces.add(player.getChoice());
        players.add(player);
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    /***
     *
     * @return false if Game OVER; TRUE  IF Game is still not finished
     */
    public Boolean move(int row,int col){
        if(row<1 || row>board.getSIZE() || col<1 || col>board.getSIZE() || !board.getAr()[row][col].equals("-")){
            System.out.println("INVALID MOVE");
            return true;
        }
        board.setAr(row,col,players.get(currentPlayerIndex).getChoice());
        GameState state=board.gameState(players.get(currentPlayerIndex));
        currentPlayerIndex = (currentPlayerIndex + 1)%players.size();
        board.print();
        if(state==GameState.OVER)
            return false;
        return true;
    }
}
