package MyGame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static int stoneCountPlayer = 3;
    static int stoneCountComputer = 3;
    static int playerTurn = 1;
    public static void main(String[] args) {


        int computerChoice;
        int playerChoice;

        int computerGuess=0;
        int playerGuess=0;

        Random rand = new Random();
        while(true){
            System.out.println();
            gameIndroduction(stoneCountPlayer, stoneCountComputer);
            computerChoice = rand.nextInt(stoneCountComputer);

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Viberete 4islo ot 0 do " + stoneCountPlayer);
                playerChoice = sc.nextInt();

                if(checkPlayerEnter(playerChoice, stoneCountPlayer)) break;
            }

            if (playerTurn == 1){

                computerGuess = computerChoice + rand.nextInt(stoneCountPlayer);

                System.out.println("Kompjuter dumaet chto summa chisel " + computerGuess);

                while (true) {

                    System.out.print("VVedite 4islo, kotoroe vi dumaete vi oba zagadali");
                    playerGuess = sc.nextInt();

                    if(checkSameGuess(playerGuess, computerGuess)) break;
                }

            }
            else if (playerTurn == 2) {

                System.out.print("VVedite 4islo, kotoroe vi dumaete vi oba zagadali");
                playerGuess = sc.nextInt();
                while (true) {
                    computerGuess = computerChoice + rand.nextInt(stoneCountPlayer);

                    if(checkSameGuess(computerGuess, playerGuess)){
                        System.out.println("Kompjuter dumaet chto summa chisel " + computerGuess);
                        break;
                    }
                }
            }
                int playesChoiceSum = playerChoice + computerChoice;

                checkRoundWinner(computerGuess, playerGuess, playesChoiceSum);


                if(checkGameWinner(stoneCountComputer, stoneCountPlayer)) break;

        }
    }

    public static void gameIndroduction(int stoneCountPlayer, int stoneCountComputer){
        System.out.println("U igroka " + stoneCountPlayer + " kamuwkov" );
        System.out.println("U kompjutera " + stoneCountComputer + " kamuwkov" );
        System.out.println("Kompjuter vibral chislo *");
    }

    public static boolean checkPlayerEnter(int playerChoice, int stoneCountPlayer ){
        if (playerChoice > stoneCountPlayer || playerChoice < 0) {
            System.out.println();
            System.out.println("Vi ukazali nevernoe 4islo. Pozalujsta viberete vernoe 4islo");
            return false;

        } else {
            return true;
        }
    }

    public static boolean checkSameGuess(int playerGuess, int computerGuess){
        if (playerGuess == computerGuess) {
            System.out.println();
            System.out.print("Vi ne mozete zagadatj takoe ze 4islo. Zagadajte svojo 4islo");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkGameWinner(int stoneCountComputer, int stoneCountPlayer){
        if(stoneCountComputer == 0){
            System.out.println("Pobedu v igre oderzal Kompjuter");
            return true;
        } else if (stoneCountPlayer == 0){
            System.out.println("Pobedu v igre oderzal Igrok");
            return true;
        }
        return false;
    }

    public static  void checkRoundWinner(int computerGuess, int playerGuess, int playesChoiceSum){
        if (computerGuess == playesChoiceSum) {
            System.out.println("Pozdravljaem, vijgral compjuter");
            --stoneCountComputer;
            playerTurn =  1;
        } else if (playerGuess == playesChoiceSum) {
            System.out.println("Pozdravljaem, vijgral Igrok");
            --stoneCountPlayer;
            playerTurn =  2;
        } else {
            System.out.println("Nekto ne ugodal");
            playerTurn =  playerTurn;
        }
    }
}
