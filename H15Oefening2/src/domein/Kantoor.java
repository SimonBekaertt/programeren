package domein;

import java.io.Serializable;

public class Kantoor implements Serializable
{
    private int postcode;
    private String gemeente, adres;

    public Kantoor(int postcode, String gemeente, String adres)
    {
        this.setPostcode(postcode);
        this.setGemeente(gemeente);
        this.setAdres(adres);
    }

    public int getPostcode()
    {
        return postcode;
    }

    public String getGemeente()
    {
        return gemeente;
    }

    public String getAdres()
    {
        return adres;
    }

    private void setPostcode(int postcode)
    {
        if (postcode < 1000 || postcode > 9999)
        {
            throw new IllegalArgumentException("postcode fout!");
        }
        this.postcode = postcode;
    }

    private void setGemeente(String gemeente)
    {
        if (gemeente == null || gemeente.isEmpty())
        {
            throw new IllegalArgumentException("gemeente fout!");
        }
        this.gemeente = gemeente;
    }

    private void setAdres(String adres)
    {
        if (adres == null || adres.isEmpty())
        {
            throw new IllegalArgumentException("adres fout!");
        }
        this.adres = adres;
    }

    @Override
    public String toString()
    {
        return String.format("%d %s %s", postcode, gemeente, adres);
    }
}
