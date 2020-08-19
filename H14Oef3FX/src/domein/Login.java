package domein;

public class Login {
	
	private String gebruikersnaam, wachtwoord;
	
	public Login() {
		
	}
	public Login(String gebruikersnaam, String wachtwoord) {
		setGebruikersnaam(gebruikersnaam);
		setWachtwoord(wachtwoord);
	}
	private boolean controleLengte(String s, int l) {
		if(s.length() < l)
			return false;
		return true;
	}
	 @Override
	    public String toString() 
	    {
	        return String.format("Gebruikersnaam = %s%nWachtwoord = %s%n", 
	                                gebruikersnaam, wachtwoord ); 
	    } 
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	public void setGebruikersnaam(String gebruikersnaam) {
		String[] gebruikersnaamWoorden = gebruikersnaam.split(" ");
		if(gebruikersnaamWoorden.length != 2) {
			throw new IllegalArgumentException("De gebruikersnaam moet uit twee woorden bestaan!");
		}
		if(!controleLengte(gebruikersnaamWoorden[0], 4)) {
			throw new IllegalArgumentException("Het eerste woord van de gebruikersnaam moet 4 karakters bevatten!");
		}
		if(!(gebruikersnaamWoorden[0].charAt(0) <'Z' && gebruikersnaamWoorden[0].charAt(0) >'A')) {
			throw new IllegalArgumentException("Het eerste karakter van het eerste woord van de gebruikersnaam moet een hoofdletter zijn!");
		}
		if(!controleLengte(gebruikersnaamWoorden[1], 8)) {
			throw new IllegalArgumentException("Het eerste woord van de gebruikersnaam moet 4 karakters bevatten!");
		}
		if(!(gebruikersnaamWoorden[1].charAt(gebruikersnaamWoorden[1].length()-1) <'9' && gebruikersnaamWoorden[1].charAt(gebruikersnaamWoorden[1].length()-1) >'0')) {
			throw new IllegalArgumentException("Het laatste karakter van het eerste woord van de gebruikersnaam moet een cijfer zijn!");
		}
		
		this.gebruikersnaam = gebruikersnaam;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		if(!controleLengte(wachtwoord, 6)) {
			throw new IllegalArgumentException("Het wachtwoord moet 6 karakters bevatten!");
		}
		if(!(wachtwoord.matches("([a-z]*\\d[a-z]*){2,}"))) {
			throw new IllegalArgumentException("Het wachtwoord moet exact twee cijfers bevatten!");
		}if(!(wachtwoord.matches("([a-z]|\\d){6,}"))){
			throw new IllegalArgumentException("Het wachtwoord moet uit minstens 2 cijfers bevatten"
					+ " Derest van de karakters moeten kleine letters bestaan.");
		}
		this.wachtwoord = wachtwoord;
	}
	
}
/*package domein;

public class Login 
{
    private String gebruikersnaam, wachtwoord;

    public Login() 
    {
    }
    
    public Login(String gebruikersnaam, String wachtwoord) 
    {
        setGebruikersnaam (gebruikersnaam);
        setWachtwoord (wachtwoord);
    }

    public String getGebruikersnaam() 
    {
        return gebruikersnaam;
    }

    public String getWachtwoord() 
    {
        return wachtwoord;
    }

    public final void setWachtwoord(String wachtwoord) 
    {
        if (wachtwoord == null)
            throw new IllegalArgumentException("Gelieve een wachtwoord in te voeren");
        if (!controleLengte(wachtwoord,6))
            throw new IllegalArgumentException("Het wachtwoord moet minstens 6 kars bevatten");
        if (!wachtwoord.matches("[a-z]*\\d+[a-z]*\\d+[a-z]*"))
            throw new IllegalArgumentException("Het wachtwoord moet minstens 2 cijfers bevatten en kleine kars"); 
        this.wachtwoord = wachtwoord;
    }

    public final void setGebruikersnaam(String gebruikersnaam) 
    {
        if (gebruikersnaam == null)
            throw new IllegalArgumentException("Gelieve een gebruikersnaam in te voeren");
        String[] delen = gebruikersnaam.split(" ");
        if (delen.length != 2)
            throw new IllegalArgumentException("De gebruikersnaam moet uit 2 delen bestaan!");
        if (!(controleLengte(delen[0], 4) && controleLengte(delen[1],8)))
            throw new IllegalArgumentException("Het eerste woord moet minstens 4 kars lang zijn, het tweede minstens 8 kars");  
        if (!(Character.isUpperCase(delen[0].charAt(0)) && Character.isDigit(delen[1].charAt(delen[1].length()-1))))
            throw new IllegalArgumentException("Het eerste woord moet beginnen met een hoofdletter en het tweede woord moet eindigen met een cijfer!");    
        this.gebruikersnaam = gebruikersnaam;
    }

    private boolean controleLengte(String s,int l)
    {
        return s.length() >= l;
    }
    
    @Override
    public String toString() 
    {
        return String.format("Gebruikersnaam = %s%nWachtwoord = %s%n", 
                                gebruikersnaam, wachtwoord ); 
    } 
}*/
