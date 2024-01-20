import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class MineSweeper { //Değerlendirme 5
    Scanner input = new Scanner(System.in); //Scanner object;
    int rows; //Row and Column numbers:
    int cols;
    int sizeofmap = (rows * cols);
    int minecount = sizeofmap / 4; //Our mine count according to formula

    boolean checkgame = true; //This checks the game is over or not.
    int counter = 1;//I will use this in mineController() to display how many mines around user inputted index;
    int succesfulmoves =0; // how many moves is succesful

    String[][] userMap;  //The map that user sees and plays
    String[][] mineMap;  //The map that user sees and plays

    // We need to use random from Math to insert mines.
    Random random = new Random();

    //Let's create constructor method for this class:

    MineSweeper(int rows, int cols) {

        this.rows = rows; //We do these because we need our parameter is now equals to class variable.
        this.cols = cols;
        this.userMap = new String[rows][cols];
        this.mineMap = new String[rows][cols];
        int sizeofmap = (rows * cols);
        this.sizeofmap = sizeofmap;
        int minecount = sizeofmap / 4; //Our mine count according to formula
        this.minecount = minecount;
    }
    // Let's take input from user to create board


    //Method that shows map:
    public void showmap(String[][] map) {
        // simple array displayer:
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[0].length; k++) {
                System.out.print("   \t ");
                System.out.print(map[i][k] + " "); //There should be no ln in print.
            }
            System.out.println(); // next row
        }
    }

    //Let's distribute mines with a method:
    public void mineDistributer() {
        //we can use random row and cols to insert random mine :
        //I tried this with so many approaches but none of them worked (yet, I will still work with after ı send this.
        int randrows;
        int randcols;
        int counter = 0;
        //We need to use while because we know how many times this will iterate.

        while (counter != minecount) {
            randrows = random.nextInt(rows);
            randcols = random.nextInt(cols);
            if (this.sizeofmap < 4) {
                System.out.println("Cannot created a map with that low sized");

                }
            if (mineMap[randrows][randcols] != " * ") {
                mineMap[randrows][randcols] = " * ";
                this.mineMap = mineMap;
                    counter++;
            }

            }


    }

    //This checks if there is mine or not (wher user played)
    //if not this controls how many mines are around.
    public void mineController(int row, int col) {
        // we need to check for 6 cases.


        if (userMap[row][col] == null) {
            if ((col<cols-1) && (mineMap[row][col + 1] == " * ")) {
                userMap[row][col] = String.valueOf(counter); //this updates null with mine number around user inputted index
                //also valueOf function needed to print int numbers in string array, ı found this on internet.
                 counter++;

            }
            if ((row>0) &&  (mineMap[row - 1][col] == " * ")) {
                userMap[row][col] = String.valueOf(counter);
                counter++;
            }
            if ((row < rows-1) && (mineMap[row + 1][col] == " * ")) {
                userMap[row][col] = String.valueOf(counter);
                 counter++;
            }
            if ((col > 0) && (mineMap[row][col - 1] == " * ")) {
                userMap[row][col] = String.valueOf(counter);
                counter++;
            }
            if ((row>0) && (col>0) && (mineMap[row - 1][col - 1] == " * ")) {
                userMap[row][col] = String.valueOf(counter);
                 counter++;
            }


            if ((row < rows -1) && (col < cols -1) && (mineMap[row + 1][col + 1] == " * ")) {
                    userMap[row][col] = String.valueOf(counter);
                     counter++;

            }
            if ((row>0) && (col < cols-1) && (mineMap[row - 1][col + 1] == " * ")) {
                    userMap[row][col] = String.valueOf(counter);
                    counter++;
            }
            if ((row < rows -1) &&(col>0) && (mineMap[row + 1][col - 1] == " * ")) {
                    userMap[row][col] = String.valueOf(counter);
                    counter++;

            }
        }

        }






    //Method that starts and plays the game :
    public void playthegame() {
        mineDistributer();
        int userrow; //row number when user plays the game
        int usercol; //col number when user plays the game
        showmap(mineMap);
        System.out.println("Game Started!");
        while(checkgame) { //this is while because I do not know how many times it will iterate.
            System.out.println("Turn Begins: ");
            System.out.println();
            showmap(userMap); //board that user sees.
            System.out.println("Please enter row number where you gonna play: ");
            userrow = input.nextInt();
            System.out.println("Please enter column number where you gonna play: ");
            usercol = input.nextInt();
            if(usercol > rows || userrow > cols) {
                System.out.println("Index you want to play does not exists! Please enter another index");
                continue;
            }

            // let's check if there is mine or not
            if(mineMap[userrow][usercol] != " * ") {
                mineController(userrow,usercol);
                succesfulmoves++;
                if(succesfulmoves == (sizeofmap - minecount)){ //Wining statement finish.
                    System.out.println("You Won!");
                    break;
                }

            } else {
                checkgame = false;
                System.out.println("You Lost!");
            }



        }
    }


}

