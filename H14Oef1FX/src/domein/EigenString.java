package domein;

public class EigenString 
{
    private String tekst;

    public EigenString(String tekst) 
    { 
        setTekst(tekst);
    }
    public String getTekst() 
    { 
        return tekst; 
    }
    public final void setTekst(String tekst) 
    { 
        if (tekst == null || tekst.isEmpty())
            throw new IllegalArgumentException("Tekst moet ingevuld zijn!");
        this.tekst = tekst;
    }

    public String telKaraktersVolgensSoort()
    {
	int klinker=0, medeklinker=0, cijfer=0, andere=0, hoofd=0, klein=0;
	char karakters[]=tekst.toCharArray();
	for(int i=0; i<karakters.length; i++)
	{
		if(Character.isLetter(karakters[i]))
		{
		    char kar=Character.toLowerCase(karakters[i]);
		    if(kar=='a' || kar =='e' || kar =='i' || kar =='o' || kar=='u')
			klinker++;
		    else
			medeklinker++;
		    if (Character.isLowerCase(karakters[i]))
			klein++;
		    else
			hoofd++;

		}
		else
		    if(Character.isDigit(karakters[i]))
			cijfer++;
		    else
			andere++;
	}
	String res = String.format("In de zin \" %s \" %n%n",tekst);
        res += String.format("%20s%20s%n%20s%20d%n%20s%20d%n%20s%20d%n%20s%20d%n%20s%20d%n%20s%20d%n",
                           "Soort karakter","Aantal","Klinker", klinker,"Medeklinker",
                             medeklinker,"Cijfer",cijfer,"Andere",andere,
                             "Kleine letter",klein,"Hoofdletter",hoofd);
        return res;
    }
}
