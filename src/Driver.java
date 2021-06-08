import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Game game =new Game();

        System.out.println("Enter Grid Size");

        Board board = new Board();
        int SIZE= sc.nextInt();
        board.setSIZE(SIZE);
        game.setBoard(board);

        System.out.println("Enter number of Players");
        int numOfPlayer=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Player Details");
        for(int rep=1;rep<=numOfPlayer;rep++){
            Player player = new Player();
            String name=sc.nextLine();
            String piece=sc.nextLine();
            player.setName(name);
            player.setChoice(piece);

            if(game.setPlayerBuilder(player)){
                System.out.println("Player Detail added successfully");
            }
            else{
                System.out.println("Piece is already taken");
            }
        }
        System.out.println("Enter Moves");
        while(true){
            int row=sc.nextInt();
            int col= sc.nextInt();
            if(!game.move(row, col))
                break;
        }
    }
}
