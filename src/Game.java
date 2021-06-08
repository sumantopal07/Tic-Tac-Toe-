import java.util.*;

public class Game {
    ArrayList<Player> players;
    Board board;
    Set<String> pieces; //set is used to maintain unique piece of each player
    int currentPlayerIndex;

    Game(){
        currentPlayerIndex=0;
        players = new ArrayList<>();
        pieces = new HashSet<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    //to add players and pieces
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
    public boolean move(int row,int col) {
        if (row < 1 || row > board.getSIZE() || col < 1 || col > board.getSIZE() || !board.getAr()[row][col].equals("-")) {
            System.out.println("INVALID MOVE");
            return false;
        }
        System.out.println("VALID MOVE");
        board.setAr(row, col, players.get(currentPlayerIndex).getChoice());
        return true;
    }
    public GameState state(){
        GameState state=board.gameState();
        board.print();
        if(state==GameState.WON){
            System.out.println(players.get(currentPlayerIndex).getName()+"won the match");
            return state;
        }
        if(state==GameState.DRAW){
            System.out.println("Match Drawn");
            return state;
        }
        currentPlayerIndex = (currentPlayerIndex + 1)%players.size();
        return state;
    }
}
