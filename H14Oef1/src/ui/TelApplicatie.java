package ui;

import domein.EigenString;
import java.util.Scanner;

public class TelApplicatie 
{
    public TelApplicatie(EigenString eigenString)
    {
        Scanner invoer = new Scanner (System.in);
        String tekst = "";
        boolean flag = true;
        do 
        {
            try 
            {
                System.out.print("Geef een tekst: ");
                tekst = invoer.nextLine();
                if (tekst==null || tekst.isEmpty())
                    throw new IllegalArgumentException("De tekst mag niet leeg zijn. Probeer opnieuw.");
                flag = false;
            } 
            catch (IllegalArgumentException ex) 
            {
                System.out.println(ex.getMessage());
            }
        } while (flag); 
        
        eigenString.setTekst(tekst);

        System.out.printf("%s%n", eigenString.telKaraktersVolgensSoort());
    }
}
