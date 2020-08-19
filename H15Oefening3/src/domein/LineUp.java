package domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LineUp implements Serializable
{
    private final List<Artiest> artiesten;
    
    public LineUp()
    {
        artiesten = new ArrayList<> ();
    }
    
    public Artiest geefArtiest(int i)
    {  return artiesten.get(i);  }
    
    public int geefAantalArtiesten()
    {  return artiesten.size();  }
    
    public void voegNieuweArtiestToe(Artiest a)
    {  artiesten.add(a);     }
    
    @Override
    public String toString()
    {
        String overzicht = "";
        for (Artiest a : artiesten)
            overzicht += a.toString() + "\n";
        return overzicht;
    }
}
