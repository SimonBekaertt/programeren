package ui;

import domein.Bier;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class BierApplicatie
{
    public static void main(String[] args)
    {
        BierApplicatie ba = new BierApplicatie();
        Scanner s = new Scanner(System.in);
        int min = 0;
        do
        {
        	try
        	{
        		System.out.print("Geef het minimum percentage alcohol: ");
        		min = s.nextInt();
        	}
        	catch (InputMismatchException e)
        	{
        		System.err.println("Geheel getal nodig voor minimum percentage alcohol!");
        		s.nextLine();
        		min = -1;
        	}
        }
        while (min < 0 || min > 100);
        List<Bier> lijst = ba.leesBierenMetMinAlcohol(min);
        String bestand = String.format("bierenMet%dofMeerPercentAlcohol.txt", min);
        ba.toonEnSchrijf(lijst, bestand);
    }
    
    private List<Bier> leesBierenMetMinAlcohol(int min)
    {
        List<Bier> deBieren = new ArrayList<>();
        final String bestand = "bieren.txt";       

    	try (Scanner s = new Scanner(Files.newInputStream(Paths.get(bestand)));)
    	{	
            while (s.hasNext())
            {
                try
                {
                    String naam = s.next(); // naam met underscores!
                    naam = naam.replaceAll("_", " "); // zonder
                    String soort = s.next();
                    double alcohol = s.nextDouble();
                	double oordeel = s.nextDouble();
                	String brouwer = s.nextLine();
                    if (alcohol >= min)
                    {
                    	Bier b = new Bier(naam, soort, alcohol, oordeel, brouwer);
                    	deBieren.add(b);
                    }
                }
                catch (InputMismatchException e)
                {
                    System.err.println("Type gegevens klopt niet!");
                }
                catch (NoSuchElementException e)
                {
                    System.err.println("Er ontbreken gegevens!");
                }
                catch (IllegalArgumentException e)
                {
                    System.err.println(e.getMessage());
                }
            }
    	}
        catch(IOException e)
        {
        	System.err.println("Lezen uit " + bestand + " is niet gelukt");
        }
        return deBieren;
    }
    
    private void toonEnSchrijf(List<Bier> lijst, String bestand)
    {
        try (Formatter f = new Formatter(Files.newOutputStream(Paths.get(bestand)));)
        {
            for (Bier b : lijst)
            {
                f.format("%s\n", b); // in bestand
                System.out.printf("%s\n", b); // op scherm                
            }
        }
        catch (IOException e)
        {
            System.err.printf("Het wegschrijven van de bieren is niet gelukt!");
        }        
    }
}
