import java.util.Random;
import java.util.Scanner;

public class GameMatch {
    public static void main(String[] args) {

        Random rand = new Random();
        int matchCount = rand.nextInt(1)+1;
        int matchLeft;

        while(true) {

            System.out.print("Igrok nr.1 viberite kolli4estvo spi4ek ot 1 do 3");
            Scanner sc = new Scanner(System.in);
            int player1 = sc.nextInt();
            int player2 = rand.nextInt(2) + 1;
            if(!checkPlayersChoise(player1)){
                System.out.println("Vi vibrali 4islo v nepraveljnom diapazone. Viberete 4islo");
                player1 = sc.nextInt();
            }
            matchLeft = matchCount - player1;
            matchCount = matchLeft;

            if(matchLeft <=0){
                System.out.println("Vijgral igrok nr.2");
                break;
            }
            System.out.println("Igrok nr.2 vitawil spi4ek: " + player2);
            matchLeft = matchCount - player2;
            matchCount = matchLeft;
            if(matchLeft <=0){
                System.out.println("Vijgral igrok nr.1");
                break;
            }
            System.out.println("Poexali daljwe");
        }

    }

    public static boolean checkPlayersChoise(int a){
        if( a >= 1 && a <= 3){
            return true;
        }
        return false;
    }
}
