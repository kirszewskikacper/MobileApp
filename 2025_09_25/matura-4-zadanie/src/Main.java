import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("liczby.txt"));

        String liczba;
        int licznik = 0;
        int pierwsza_liczba = 0;
        while (scanner.hasNextLine())
        {
                liczba = scanner.nextLine();

                if(liczba.charAt(0) == liczba.charAt(liczba.length() - 1))
                {
                    if(pierwsza_liczba == 0)
                    {
                        pierwsza_liczba = Integer.parseInt(liczba);
                    }
                    licznik++;
                }
        }
        scanner.close();
        System.out.println(licznik + " " + pierwsza_liczba);
    }
}

