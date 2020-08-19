package domein;

public class Kat extends Dier
{
    public Kat(int geboortejaar)
    {
        super(geboortejaar);
        controleerGeboortejaar(geboortejaar);
    }

    private void controleerGeboortejaar(int geboortejaar)
    {
        int hj = geefHuidigJaar();
        if (hj - geboortejaar > 27)
            throw new IllegalArgumentException("Een kat kan maximaal 27 jaar worden!");
        
    }

    @Override
    public int berekenLeeftijdVolgensMens()
    {
        return berekenLeeftijd() * 7;
    }
}
