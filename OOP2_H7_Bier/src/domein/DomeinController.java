package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController
{

    private final BierWinkel bierWinkel;

    public DomeinController()
    {
        bierWinkel = new BierWinkel();
    }   

    public long geefAantalBierenMetMinAlcoholPercentage(double percentage)
    {
        return bierWinkel.geefAantalBierenMetMinAlcoholPercentage(percentage);
    }
    
    public List<String> geefLijstAlleBierenMetMinAlcoholPercentage(double percentage)
    {
        List<Bier> bieren
                =bierWinkel.geefAlleBierenMetMinAlcoholPercentage(percentage);
        
        List<String> lijstres = new ArrayList<>();
        for(Bier bier : bieren)
            lijstres.add(bier.toString());
        return lijstres;
    }
    
    public String geefNamenBieren()
    {
        List<String> namen = bierWinkel.geefNamenBieren();
        
        String res = "";
        for(String bier : namen)
            res += bier + "\n";
        return res;
    }
    
    public String geefBierMetHoogsteAlcoholPercentage()
    {
        return bierWinkel.geefBierMetHoogsteAlcoholPercentage().toString();
    }
    
    public String geefBierMetLaagsteAlcoholPercentage()
    {
        return bierWinkel.geefBierMetLaagsteAlcoholPercentage().toString();
    }
    
    public List<String> sorteerOpAlcoholGehalteEnNaam()
    {
        List<Bier> bieren=bierWinkel.sorteerOpAlcoholGehalteEnNaam();
        
        List<String> lijstres = new ArrayList<>();
        for(Bier bier : bieren)
            lijstres.add(bier.toString());
        return lijstres;
    }
    

}
