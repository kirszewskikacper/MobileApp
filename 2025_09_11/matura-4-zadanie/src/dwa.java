import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class dwa {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("przyklad.txt"));

        int maxdzielniki = 0;
        int maxliczba = 0;
        while (scanner.hasNextLine()) {
            int liczba =  Integer.parseInt(scanner.nextLine());
            int liczba2 = liczba;
            int dzielnik = 2;
            ArrayList dzielniki = new ArrayList();

            while(liczba2!=1){
                if(liczba2%dzielnik==0){
                    liczba2 /=dzielnik;
                    dzielniki.add(dzielnik);
                }
                else{
                    dzielnik++;
                }
            }

            if(dzielniki.size()>maxdzielniki){
                maxdzielniki = dzielniki.size();
                maxliczba = liczba;
            }

        }
        System.out.print(maxliczba + " " + maxdzielniki);
    }
}
