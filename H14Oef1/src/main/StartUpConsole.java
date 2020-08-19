package main;

import domein.EigenString;
import ui.TelApplicatie;

public class StartUpConsole 
{
    public static void main (String[] args)
    {
    	EigenString es = new EigenString("iets");
        new TelApplicatie(es);
    }
}
