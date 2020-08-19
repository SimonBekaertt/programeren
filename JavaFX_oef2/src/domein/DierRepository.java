package domein;

import java.util.List;
import persistentie.DierenMapper;

public class DierRepository
{
    private final DierenMapper dierenMapper;

    private final List<Dier> dieren;

    public DierRepository()
    {
        dierenMapper = new DierenMapper();
        dieren = dierenMapper.geefDieren();
    }

    public List<Dier> getDieren()
    {
        return dieren;
    }

    public void voegKatToe(int geboortejaar)
    {
        Dier nieuwDier = new Kat(geboortejaar);
        dieren.add(nieuwDier);
    }

    public void voegHondToe(String naam, int geboortejaar)
    {
        Dier nieuwDier = new Hond(geboortejaar, naam);
        dieren.add(nieuwDier);
    }

}
