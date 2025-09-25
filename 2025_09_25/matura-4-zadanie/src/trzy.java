import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileWriter;

public class trzy {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("liczby.txt"));
        ArrayList liczby =  new ArrayList();
        while (scanner.hasNextLine()) {
            liczby.add(Integer.parseInt(scanner.nextLine()));
        }
        Collections.sort(liczby);
        int poprawnetrojki = 0;


        for (Object o : liczby) {
            for(Object o2 : liczby){
                for(Object o3 : liczby){
                    if (!o.equals(o2) && !o2.equals(o3)){
                        int i = Integer.parseInt(o.toString());
                        int j = Integer.parseInt(o2.toString());
                        int k = Integer.parseInt(o3.toString());
                        if(j%i==0 && k%j==0){
                            poprawnetrojki++;
                        }
                    }
                }
            }
        }

        int poprawnepiatki = 0;
        for (Object o : liczby) {
            for(Object o2 : liczby){
                int i = Integer.parseInt(o.toString());
                int j = Integer.parseInt(o2.toString());
                if(j%i==0 && j!=i){
                    for(Object o3 : liczby){
                        int k = Integer.parseInt(o3.toString());
                        if(k%j==0 && k!=j) {
                            for (Object o4 : liczby) {
                                int l = Integer.parseInt(o4.toString());
                                if (l % k == 0 && l != k) {
                                    for (Object o5 : liczby) {
                                        int m = Integer.parseInt(o5.toString());
                                        if (m % l == 0 && l != m) {
                                            poprawnepiatki++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(poprawnetrojki + " " + poprawnepiatki);
}}
