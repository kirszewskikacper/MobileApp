import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class dwa {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("liczby.txt"));

        int maxdzielniki = 0;
        int maxliczba = 0;
        int maxroznychdzielnikow = 0;
        int maxliczbazroznymidzielnikami = 0;
        while (scanner.hasNextLine()) {
            int liczba =  Integer.parseInt(scanner.nextLine());
            int liczba2 = liczba;
            int dzielnik = 2;
            int ostatniDzielnik = 1;
            ArrayList dzielniki = new ArrayList();
            ArrayList rozneDzielniki = new ArrayList();

            while(liczba2!=1){
                if(liczba2%dzielnik==0){
                    liczba2 /=dzielnik;
                    dzielniki.add(dzielnik);
                    if(ostatniDzielnik!= dzielnik){
                        rozneDzielniki.add(dzielnik);
                        ostatniDzielnik = dzielnik;
                    }
                }
                else{
                    dzielnik++;
                }
            }

            if(dzielniki.size()>maxdzielniki){
                maxdzielniki = dzielniki.size();
                maxliczba = liczba;
            }

            if(rozneDzielniki.size()>maxroznychdzielnikow){
                maxroznychdzielnikow = rozneDzielniki.size();
                maxliczbazroznymidzielnikami = liczba;
            }

        }
        System.out.print(maxliczba + " " + maxdzielniki + " " + maxliczbazroznymidzielnikami + " " + maxroznychdzielnikow);
    }
}
