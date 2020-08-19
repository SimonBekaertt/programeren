package domein;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Dier
{
    private final int geboortejaar;

    public Dier(int geboortejaar)
    {
        controleerGeboortejaar(geboortejaar);
        this.geboortejaar = geboortejaar;
    }

    public int getGeboortejaar()
    {
        return geboortejaar;
    }

    private void controleerGeboortejaar(int geboortejaar)
    {
        int hj = geefHuidigJaar();
        if (geboortejaar > hj)
        {
            throw new IllegalArgumentException("Het geboortejaar moet kleiner zijn of gelijk aan " + hj);
        }
    }

    protected int geefHuidigJaar()
    {
        Calendar cal = new GregorianCalendar();
        return cal.get(Calendar.YEAR);
    }

    public int berekenLeeftijd()
    {
        return geefHuidigJaar() - geboortejaar;
    }

    public abstract int berekenLeeftijdVolgensMens();

    @Override
    public String toString()
    {
        return String.format(
                "%S: leeftijd is %d en volgens de mens %d",
                this.getClass().getSimpleName(),
                berekenLeeftijd(), berekenLeeftijdVolgensMens());
    }

}
