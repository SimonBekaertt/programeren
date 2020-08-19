package domein;

import java.io.Serializable;


public class Podium implements Serializable
{
    private final LineUp[] lineups;
    
    public Podium(int aantalDagen)
    {
        lineups = new LineUp[aantalDagen];
    }
    
    public int geefAantalDagenInGebruik()
    {
        return lineups.length;
    }
    
    public void voegLineUpToe(LineUp lineup)
    {
        int vrijeIndex = 0;
        for (int index = 0; index < geefAantalDagenInGebruik(); index++)
            if (lineups[index] == null)
            {
                vrijeIndex = index;
                break;
            }
        lineups[vrijeIndex] = lineup;
    }
    
    public LineUp geefLineUp(int i)
    {
        return lineups[i];
    }
    
    @Override
    public String toString()
    {
        String overzicht = "";
        int dag = 1;
        for (LineUp lu : lineups)
        {
            overzicht += String.format("Dag %d\n", dag);
            overzicht += lu.toString() + "\n";
            dag++;
        }
        return overzicht;
    }
}
