import java.util.Scanner;

public class MineSweeperMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Değerlendirme 7
        int rows,cols;
        System.out.println("Please give row count of your game : "); //I could do these in a method but ı will not because ı will use this
        // once so there is no repeating.
        rows = input.nextInt();
        System.out.println("Please give column count of your game: ");
        cols = input.nextInt();
        //before starting lets verify user inputs right numbers.
        if (rows < 0 || cols <0 ){
            System.out.println("Cannot start the game with these index numbers!");
        }else {
            MineSweeper game = new MineSweeper(rows, cols); //let's get our MineSweeper class
            game.playthegame();
        }
    }
}
