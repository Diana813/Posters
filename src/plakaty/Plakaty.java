/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plakaty;

/**
 *
 * @author diana
 */
import java.io.*;
import java.util.*;


public class Plakaty {

    public static void main(String[] args) throws FileNotFoundException {
        

        Scanner in = new Scanner(new File("pla0.in"));// Pobieram plik danych

        int[] numberOfBuildings = new int[250000];//Tablica z maksymalną ilością budynków w rzędzie
        int numberOfHouses = in.nextInt();//Pobieram rzeczywistą ilość budynków z pliku danych
        int posters = 0;//Ilość plakatów.
        int positionsInArray = 0;// Ilość pozycji (budynków) w tablicy .


        for (int i=1; i <= numberOfHouses; i++)
        {
            int widthsOfTheBuildings = in.nextInt();// Pobieram szerokosci budynków z pliku danych
            int heightsOfTheBuildings = in.nextInt();// Pobieram wysokości budynków z pliku danych.
            
            /** W tablicy numberOfBuildings używam tylko wysokości budynków z pliku.
            * Jeśli budynek jest niższy niż poprzedni, to nie można dalej rozciągać plakatu. Trzeba dodać jeden plakat
            * do zużytych. Należy też odjąć jeden budynek, gdyż został już oklejony.
            **/
            while (heightsOfTheBuildings < numberOfBuildings[positionsInArray])  
            {   posters++;
                numberOfBuildings[positionsInArray--] = heightsOfTheBuildings;// Najpierw dodajemy plakat, a dopiero później odejmujemy budynek.
            }
            //Jeśli budynek jest wyższy niż poprzedni, to dodajemy budynek do oklejenia ("górkę").
            while (heightsOfTheBuildings >  numberOfBuildings[positionsInArray]){ 
                numberOfBuildings[++positionsInArray] = heightsOfTheBuildings;}
        }
        /**Ilość plakatów potrzebnych do oklejenia wszystkich budynków jest równa ilości "górek" i  
         * plakatów zużytych do oklejenia niższych budynków. 
         **/
        posters += positionsInArray;
        System.out.println(posters);
        PrintWriter save = new PrintWriter("pla0.out");//Drukowanie wyniku do pliku pla.out
        save.println(posters);
        save.close();
        }
}
