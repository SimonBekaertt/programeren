package domein;

import java.io.Serializable;

public class Artiest implements Serializable
{
    private final String naam;
    private MuziekGenre genre;
    
    public Artiest(String naam, MuziekGenre genre)
    {
        if (naam == null || naam.isEmpty())
            throw new IllegalArgumentException("Foute naam voor artiest!");
        this.naam = naam;
        this.genre = genre;
    }

    public String getNaam()   { return naam;  }
    public MuziekGenre getGenre()    {  return genre;  }
 
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " " + naam.trim()
                + " speelt het genre " + genre;
    }    
}
