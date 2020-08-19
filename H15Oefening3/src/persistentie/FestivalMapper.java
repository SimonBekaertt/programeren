package persistentie;

import domein.Artiest;
import domein.Festival;
import domein.LineUp;
import domein.MuziekGenre;
import domein.Podium;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author lvu621
 */
public class FestivalMapper
{
   public List<Artiest> leesArtiestenUit(String naamBestand)
   {
       List<Artiest> deLijst = new ArrayList<> ();
       try (Scanner s = new Scanner(Files.newInputStream(Paths.get(naamBestand)));)
       {
           while (s.hasNext())
           {
               try
               {
                String genre = s.next();
                String artiest = s.nextLine();
                Artiest a = new Artiest(artiest, MuziekGenre.valueOf(genre));
                deLijst.add(a);
               }
               catch (InputMismatchException e)
               {
                   System.err.println("De ingelezen gegevens voldoen niet aan het type "
                           + "verwacht voor een artiest");
               }
               catch (NoSuchElementException e)
               {
                   System.err.println("Aantal ingelezen gegevens klopt niet!");
               }
           }
       }
       catch (IOException e)
       {
           System.err.println("Er kan niet gelezen worden uit " + naamBestand);
       }
       return deLijst;
   }
   
   public List<Podium> maakPodia(String naamBestand, List<Artiest> artiesten)
   {
	   List<Podium> deLijst = new ArrayList<> ();
	   int indexArtiest = 0;
       try (Scanner s = new Scanner(Files.newInputStream(Paths.get(naamBestand)));)
       {
           while (s.hasNext())
           {
               try
               {
            	   String podiumInfo = s.nextLine();
            	   String[] dagen = podiumInfo.split(" ");
            	   int aantalDagen = dagen.length;
            	   Podium p = new Podium(aantalDagen);
            	   for (String dag : dagen)
            	   {
            		   LineUp lu = new LineUp();
            		   int aantalArtiesten = Integer.parseInt(dag);
            		   for (int nr=0; nr<aantalArtiesten; nr++)
            			   lu.voegNieuweArtiestToe(artiesten.get(indexArtiest+nr));
            		   p.voegLineUpToe(lu);
            		   indexArtiest += aantalArtiesten;
            	   }
            	   deLijst.add(p);
               }
               catch (IndexOutOfBoundsException e)
               {
            	   System.err.println("Het aantal artiesten klopt niet met de verwachte line-up van het festival");
               }
               catch (InputMismatchException e)
               {
                   System.err.println("Er wordt een aantal gehele getallen verwacht, dat telkens het aantal artiesten per LineUp per dag voorstelt");
               }
               catch (NoSuchElementException e)
               {
                   System.err.println("Aantal ingelezen gegevens klopt niet!");
               }
           }
       }
       catch (IOException e)
       {
           System.err.println("Er kan niet gelezen worden "
                   + "uit " + naamBestand);
       }
       return deLijst;
   }
   
   public void schrijfFestivalWeg(Festival f)
   {
       try (ObjectOutputStream oos = new ObjectOutputStream
               (new FileOutputStream("festival.ser")))
       {
           oos.writeObject(f);
       }
      catch (IOException e)
       {
           System.err.println("Kan niet schrijven naar festival.ser");
       }
   }
}
