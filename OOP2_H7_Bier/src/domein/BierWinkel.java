package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import persistentie.BierMapper;


public class BierWinkel
{
    private final List<Bier> bieren;
    private final BierMapper bierMapper;

    public BierWinkel()
    {
        bierMapper=new BierMapper();
        bieren = bierMapper.inlezenBieren("bieren.txt");
    }

    public List<Bier> getBieren()
    {
        return bieren;
    }
    
    public long geefAantalBierenMetMinAlcoholPercentage(double percentage)
    {
        return geefAlleBierenMetMinAlcoholPercentage(percentage).size();
    }
   
    public List<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage)
    {
        List<Bier> minstensgraden = new ArrayList<>();
        for(Bier bier : bieren)
            if(bier.getAlcoholgehalte() >= percentage)
                minstensgraden.add(bier);
        
        return minstensgraden;
    }

    //Bier met hoogst aantal graden
    public Bier geefBierMetHoogsteAlcoholPercentage()
    {
        Bier[] bierenGesorteerd = sorteerVolgensAlcoholGehalte();
        return bierenGesorteerd[bierenGesorteerd.length-1];
    }

    //Bier met laagst aantal graden
    public Bier geefBierMetLaagsteAlcoholPercentage()
    {
        return sorteerVolgensAlcoholGehalte()[0];
    }
    
    //Hulpmethode voor bier met hoogste/laagste alcoholgehalte
    public Bier[] sorteerVolgensAlcoholGehalte()
    {
        Bier[] bierenAlsArray = new Bier[bieren.size()];
        Arrays.sort(bieren.toArray(bierenAlsArray));
        return bierenAlsArray;
    }

    /*Zorg ervoor dat het resultaat gesorteerd wordt op alcoholgehalte van hoog naar laag, 
     en bij gelijk aantal graden op naam (alfabetisch).
     */
    public List<Bier> sorteerOpAlcoholGehalteEnNaam()
    {
//        Oplossing met array
        Bier[] bierenAlsArray = new Bier[bieren.size()];
        Arrays.sort(bieren.toArray(bierenAlsArray),new BierComparator());
        return Arrays.asList(bierenAlsArray);
        
//        Lijst kent sedert Java8 de methode sort
//        bieren.sort(new BierComparator()) ;
//        return bieren;

    }   
    
    public List<String> geefNamenBieren()
    {
//        List<String> namen = 
//                bieren.stream()
//                          .map(bier -> bier.getNaam())
//                          .collect(Collectors.toList());
    	List<String> namen = new ArrayList<>();
    	for(Bier bier: bieren)
    		namen.add(bier.getNaam());
        return namen;
    }

}
