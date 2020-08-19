package domein;


public class Bier
{
   private final String naam, soort, brouwerij;
   private double alcoholPercentage,  beoordeling;
   
   public Bier(String naam, String soort, double alcoholPercentage, 
                double beoordeling, String brouwerij)
   {
	   controleerLeeg(naam, "naam");
	   this.naam = naam;
	   controleerLeeg(soort, "soort");
	   this.soort = soort;
	   controleerLeeg(brouwerij, "brouwerij");
       this.brouwerij = brouwerij;
       this.setAlcoholPercentage(alcoholPercentage);
       this.setBeoordeling(beoordeling);
   }

    public String getNaam()   { return naam; }
    public String getSoort()  { return soort; }
    public String getBrouwerij()  { return brouwerij; }
    public double getAlcoholPercentage() { return alcoholPercentage; }
    public double getBeoordeling() { return beoordeling; }
  
    private void controleerLeeg(String gegeven, String fout)
    {
    	if (gegeven == null || gegeven.equals(""))
    		throw new IllegalArgumentException(fout + "invullen!");
    }    
    
    private void setAlcoholPercentage(double alcoholPercentage)
    {
        if (alcoholPercentage < 0 || alcoholPercentage > 50)
            throw new IllegalArgumentException("alcoholpercentage fout!");
        this.alcoholPercentage = alcoholPercentage;
    }

    private void setBeoordeling(double beoordeling)
    {
       if (beoordeling < 0 || beoordeling > 10)
            throw new IllegalArgumentException("beoordeling fout!");
        this.beoordeling = beoordeling;
    }

	@Override
    public String toString()
    {
        String naamMetStreepjes = naam.replaceAll(" ", "_"); 
        return naamMetStreepjes;
    }
}
