package domein;

public class Hond extends Dier
{
    private final String naam;

    public Hond(int geboortejaar, String naam)
    {
        super(geboortejaar);
        controleerNaam(naam);
        controleerGeboortejaar(geboortejaar);
        this.naam = naam;
    }

    public Hond(int geboortejaar)
    {
        this(geboortejaar, "onbekend");
    }

    private void controleerNaam(String naam)
    {
        if (naam == null || naam.length() == 0)
           throw new IllegalArgumentException("Naam mag niet leeg zijn!");
    }
    
    public String getNaam()
    {
        return naam;
    }

    private void controleerGeboortejaar(int geboortejaar)
    {
        int hj = geefHuidigJaar();
        if (hj - geboortejaar > 29)
            throw new IllegalArgumentException("Een hond kan maximaal 29 jaar worden!");
        
    }

    @Override
    public int berekenLeeftijdVolgensMens()
    {
        final int GRENS = 5;
        int leeftijdVolgensMens = 0;
        int leeftijdDier = berekenLeeftijd();
        int getal = 10;
        for (int i = 1; i <= leeftijdDier && i <= GRENS; i++)
        {
            leeftijdVolgensMens += (getal--);
        }

        if (leeftijdDier > GRENS)
        {
            leeftijdVolgensMens += ((leeftijdDier - GRENS) * GRENS);
        }
        return leeftijdVolgensMens;
    }

    @Override
    public String toString()
    {
        return String.format("%s, naam is %S",
                super.toString(), naam);
    }
}
