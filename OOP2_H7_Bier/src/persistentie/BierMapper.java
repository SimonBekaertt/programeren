package persistentie;

import domein.Bier;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BierMapper
{

    public List<Bier> inlezenBieren(String naamBestand)
    {
//TODO
        List<Bier> bieren = new ArrayList<>();
        String naam, soort, brouwerij;
        double graden, beoord;

        try (Scanner scanner = new Scanner(new File(naamBestand)))
        {
            while (scanner.hasNext())
            {
                naam = scanner.next();
                soort = scanner.next();
                graden = scanner.nextDouble();
                beoord = scanner.nextDouble();
                brouwerij = scanner.nextLine();
                bieren.add(new Bier(naam, soort, graden, beoord, brouwerij));
            }
        } catch (IOException ex)
        {
            System.err.println("Bestand niet gevonden");
        }
        return bieren;
    }


}
