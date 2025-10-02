import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        while(true){
            int[] kosci = losowanie(ilosc_kosci());
            liczenie_punktow(kosci);
            kontynuowac();
        }


    }
    public static int ilosc_kosci(){
        int ilosc = 0;
        while(ilosc < 3 || ilosc > 10){
            System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
            Scanner sc = new Scanner(System.in);
            ilosc = sc.nextInt();
        }
        return ilosc;
    }
    public static int[] losowanie(int ilosc_kosci){
        int[] ilosc = new int[ilosc_kosci];
        Random rand = new Random();
        int punkty = 0;
        for(int i = 0; i < ilosc_kosci; i++) {
            ilosc[i] = rand.nextInt(6);
            ilosc[i] = ilosc[i] + 1;
            System.out.println("Kostka " + (i + 1) + ": " + ilosc[i]);

        }
        return ilosc;
    }
    public static void kontynuowac(){
        System.out.println("Jeszcze raz? (t/n)");
        Scanner sc = new Scanner(System.in);
        String wynik = sc.next();
        if(wynik.equals("n")){
            System.exit(0);
        }
    }
    public static void liczenie_punktow(int kosci[]){
        int suma = 0;
        for(int i = 1; i <= 6; i++){
            int ilosc_i = 0;
            for(int j = 0; j < kosci.length; j++){
                if(i == kosci[j]){
                    ilosc_i++;
                }
            }
            if(ilosc_i > 1){
                suma += ilosc_i * i;
            }
        }
        System.out.println("Liczba uzyskanych punktów: " + suma);
    }
}