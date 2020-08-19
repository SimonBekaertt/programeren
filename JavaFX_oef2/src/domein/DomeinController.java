package domein;

import java.util.List;

public class DomeinController
{
    private final DierRepository dierRepository;

    public DomeinController()
    {
        this.dierRepository = new DierRepository();
    }
    
    public void voegKatToe(int geboortejaar)
    {
        dierRepository.voegKatToe(geboortejaar);
    }

    public void voegHondToe(String naam, int geboortejaar)
    {
        dierRepository.voegHondToe(naam, geboortejaar);
    }
    
    public String maakOverzicht()
    {
        List<Dier> dieren = dierRepository.getDieren();
        
        if (dieren.isEmpty())
        {
            return "verzameling dieren is leeg";
        }

        String resultaat = "";
        for (Dier eenDier : dieren)
        {
            resultaat += "\n" + eenDier; // eenDier.toString()
        }
        return resultaat;

    }
    
}
