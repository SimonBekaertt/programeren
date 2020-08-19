package ui;

import domein.Kantoor;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class KantoorApplicatie 
{
    public static void main(String[] args) 
    {
        KantoorApplicatie kka = new KantoorApplicatie();
        List<Kantoor> kantoren, kantorenInRegio;
        kantoren = kka.leesKantoren("adressen.txt");
        int eigenPostcode = kka.vraagPostcode();
        int eersteCijfer = eigenPostcode / 1000;
        kantorenInRegio = kka.filter(kantoren, eersteCijfer);
        String uitvoerBestand = "kantorenbeginnendmet" + eersteCijfer + ".ser";
        kka.serialiseer(kantorenInRegio, uitvoerBestand);
    }
    
    private List<Kantoor> leesKantoren(String invoerBestand)
    {
        List<Kantoor> lijst = new ArrayList<>();
        try (Scanner s = new Scanner(Files.newInputStream(Paths.get(invoerBestand)));)
        {
            while (s.hasNext())
            {
                try
                {
                    int postcode = s.nextInt();
                    String gemeente = s.next(); 
                    String adres = s.nextLine();
                    Kantoor kk = new Kantoor(postcode, gemeente, adres);
                    lijst.add(kk);
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
            System.err.println("Lezen uit " + invoerBestand + " is niet gelukt");
        }
        return lijst;
    }
    
    private int vraagPostcode()
    {
        Scanner s = new Scanner(System.in);
        int postcode = 0;
        do
        {
            try
            {
                System.out.print("Geef je postcode: ");
                postcode = s.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Geef een getal in!");
                s.nextLine();
            }
        }
        while (postcode < 1000 || postcode > 9999);
        return postcode;
    }
    
    private List<Kantoor> filter (List<Kantoor> kantoren, int eersteCijfer)
    {
        List<Kantoor> gefilterdeLijst = new ArrayList<> ();
        for (Kantoor kantoor : kantoren)
        {
            int postcodeKantoor = kantoor.getPostcode();
            int eersteCijferKantoor = postcodeKantoor / 1000;
            if (eersteCijferKantoor == eersteCijfer)
                gefilterdeLijst.add(kantoor);
        }
        return gefilterdeLijst;
    }
    
    private void serialiseer (List<Kantoor> lijst, String uitvoerBestand)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(uitvoerBestand))))
        {
            oos.writeObject(lijst);
        } 
        catch (IOException ex) 
        {
            System.out.println("Kan niet schrijven naar " + uitvoerBestand);
        }
    }
}