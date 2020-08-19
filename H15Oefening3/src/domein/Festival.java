package domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import persistentie.FestivalMapper;

public class Festival implements Serializable
{
   private List<Podium> podia;
   private final transient FestivalMapper festivalMapper;
   
   public Podium geefPodium(int i)
   {  return podia.get(i); }
   
   public int geefAantalPodia()
   {  return podia.size(); }
   
   public Festival()
   {
       festivalMapper = new FestivalMapper();
       initPodia();
   }
   
   private void initPodia()
   {
       List<Artiest> artiesten = festivalMapper.leesArtiestenUit("artiesten.txt");
       podia = festivalMapper.maakPodia("podia.txt", artiesten); 
   }
   
   public void schrijfWeg()
   {
       festivalMapper.schrijfFestivalWeg(this);
   }
   
   @Override
   public String toString()
   {
       int aantalPodia = podia.size();
       String overzicht = String.format("Festival met %d podia%n%n", aantalPodia);
       // alle podia
       for (int podnr = 0; podnr < aantalPodia; podnr++)
       {
           overzicht += String.format("Podium %d%n", podnr + 1);
           overzicht += geefPodium(podnr);
       }  
       return overzicht;
   }
}
