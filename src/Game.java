import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int stoneCountPlayer = 3;
        int stoneCountComputer = 3;

        int playerTurn = 0;
        int computerTurn = 0;

        int computerChoice;
        int playerChoice;

        int computerGuess=0;
        int playerGuess=0;

        while(true){

            Random rand = new Random();
            System.out.println("U igroka " + stoneCountPlayer + " kamuwkov" );
            System.out.println("U kompjutera " + stoneCountComputer + " kamuwkov" );

            computerChoice = rand.nextInt(stoneCountComputer);
            System.out.println("Kompjuter vibral chislo *");

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Viberete 4islo ot 0 do " + stoneCountPlayer);
                playerChoice = sc.nextInt();

                if (playerChoice > stoneCountPlayer || playerChoice < 0) {
                    System.out.println();
                    System.out.println("Vi ukazali nevernoe 4islo. Pozalujsta viberete vernoe 4islo");
                } else {
                    break;
                }
            }

            if ((playerTurn == 0 && computerTurn == 0) || (playerTurn == 0 && computerTurn == 1)){
                computerGuess = computerChoice + rand.nextInt(stoneCountPlayer);
                System.out.println("Kompjuter dumaet chto summa chisel " + computerGuess);
                while (true) {
                    System.out.print("VVedite 4islo, kotoroe vi dumaete vi oba zagadali");
                    playerGuess = sc.nextInt();
                    if (playerGuess == computerGuess) {
                        System.out.println();
                        System.out.print("Vi ne mozete zagadatj takoe ze 4islo. Zagadajte svojo 4islo");
                    } else {
                        break;
                    }
                }

            } else if (playerTurn == 1 && computerTurn == 0) {

                System.out.print("VVedite 4islo, kotoroe vi dumaete vi oba zagadali");
                playerGuess = sc.nextInt();
                while (true) {
                    computerGuess = computerChoice + rand.nextInt(stoneCountPlayer);
                    if (computerGuess == playerGuess) {
                        System.out.println();
                        System.out.print("Vi ne mozete zagadatj takoe ze 4islo. Zagadajte svojo 4islo");
                    } else {
                        System.out.println("Kompjuter dumaet chto summa chisel " + computerGuess);
                        break;
                    }
                }
            }
                int playesChoiceSum = playerChoice + computerChoice;
                if (computerGuess == playesChoiceSum) {
                    System.out.println("Pozdravljaem, vijgral compjuter");
                    --stoneCountComputer;
                    playerTurn = 0;
                    computerTurn = 1;
                    System.out.println( playerTurn + "i eto " +computerTurn);
                } else if (playerGuess == playesChoiceSum) {
                    System.out.println("Pozdravljaem, vijgral Igrok");
                    --stoneCountPlayer;
                    playerTurn = 1;
                    computerTurn = 0;
                    System.out.println( playerTurn + "i eto " +computerTurn);
                } else {
                    System.out.println("Nekto ne ugodal");
                }

                if(stoneCountComputer == 0){
                    System.out.println("Pobedu v igre oderzal Kompjuter");
                    break;
                } else if (stoneCountPlayer == 0){
                    System.out.println("Pobedu v igre oderzal Igrok");
                    break;
                }

        }
    }
}
