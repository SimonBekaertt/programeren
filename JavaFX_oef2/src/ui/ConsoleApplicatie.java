/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DierSoort;
import domein.DomeinController;
import java.util.Scanner;

/**
 *
 * @author sv964
 */
public class ConsoleApplicatie
{

    public ConsoleApplicatie(DomeinController domeinController)
    {
        System.out.println(domeinController.maakOverzicht());

        int keuze = 0;
        String jaar;
        String[] gegHond;
        do
        {
            keuze = maakKeuze();
            if (keuze != 3)
            {
                switch (DierSoort.values()[keuze - 1])
                {
                    case KAT:
                        int jaartal = geefGegevensKat();
                        domeinController.voegKatToe(jaartal);
                        break;
                    case HOND:
                        gegHond = geefGegevensHond();
                        domeinController.voegHondToe(gegHond[0], Integer.parseInt(gegHond[1]));
                        break;
                }
            }
            System.out.println(domeinController.maakOverzicht());

        } while (keuze != 3);
    }

    private int maakKeuze()
    {
        int keuze;
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.println("\nMaak je keuze: \n 1: toevoegen kat\n 2: toevoegen hond\n 3: stoppen");
            keuze = input.nextInt();
        } while (keuze < 1 || keuze > 3);

        return keuze;
    }

    private int geefGegevensKat()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef geboortejaar:");
        String jaarS = input.next();
        return Integer.parseInt(jaarS);
    }

    private String[] geefGegevensHond()
    {
        String[] gegHond = new String[2];
        Scanner input = new Scanner(System.in);
        System.out.println("\nGeef geboortejaar van de hond: ");
        gegHond[1] = input.next();
        input.nextLine();
        System.out.println("\nGeef naam van de hond: ");
        gegHond[0] = input.nextLine();
        return gegHond;
    }

}
