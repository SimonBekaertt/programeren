/*package ui;

import java.util.Scanner;

public class OefH14Oef2 
{
    public static void main(String[] args)
    {
       String stringArray[] = new String [10], uitvoer = "", naam;
       int indexEerste = 0,indexLaatste = 0;
       
       Scanner invoer = new Scanner (System.in);
       
       for (int teller = 0; teller < stringArray.length;teller++)
       {
         System.out.print("Geef een naam in (of stop met een lege naam): ");
         naam = invoer.nextLine();  
         if(naam.isEmpty()) break;
         
         stringArray[teller] = naam;
         if (teller != 0)
            {
                 if (vergelijkMetEerste( stringArray[indexEerste],stringArray[teller]))
                        indexEerste = teller;
                 else
                        if (vergelijkMetLaatste( stringArray[indexLaatste],stringArray[teller]))
                            indexLaatste = teller;
            }    
            
       }

       uitvoer = bepaalUitvoer(stringArray,indexEerste,indexLaatste);
       System.out.printf("%s%n", uitvoer);
    }

    private static boolean vergelijkMetEerste(String string1, String string2) 
    {
        return string1.compareTo(string2)>0;
    }

    private static boolean vergelijkMetLaatste(String string1, String string2) 
    {
        return string1.compareTo(string2)<0;
    }
    
    private static String bepaalUitvoer(String[] stringArray, int indexEerste, int indexLaatste)
    {
        String uitvoer = "";
        int index=0; 
        for (String naam: stringArray)
        {
           if (naam == null) 
               break;
           if (index == indexEerste)
               uitvoer += String.format("%s   EERSTE%n", naam);               
           else
                 if (index == indexLaatste)
                    uitvoer += String.format("%s   LAATSTE%n",naam);
                  else
                     uitvoer += String.format("%s%n", naam);
           index++;
         }
        return uitvoer;
    }
}*/
package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OefH14Oef2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> namen = new ArrayList<>();
		String eerste = "", laatste = "";
		try {
			// het programma blijft in mijn do-while-loop steken als ik een lege string als naam meegeef.
			do {
				System.out.print("Geef een naam in (of stop met een lege naam: ");
				namen.add(s.nextLine());
				System.out.println();
				if(namen.size()==1) {
					eerste = namen.get(0);
					laatste = namen.get(0);
				}else{
					if(vergelijkMetEerste(eerste, namen.get(namen.size()-1)))
						eerste = namen.get(namen.size()-1);
					else if(vergelijkMetLaatste(laatste, namen.get(namen.size()-1)))
						laatste = namen.get(namen.size()-1);
				}
			}while(!namen.get(namen.size()-1).isEmpty() || namen.size()<2);
			int indexEerste = namen.indexOf(eerste);
			int indexLaatste = namen.indexOf(laatste);
			
			String[] namenArray = new String[namen.size()];
			namenArray = namen.toArray(namenArray);
			System.out.print(bepaalUitvoer(namenArray, indexEerste, indexLaatste));
			
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		

		
		

	}
	private static boolean vergelijkMetEerste(String string1, String string2) {
		String eerste = string1;
		// we maken van string1 de kortste string
		if(string1.length()>string2.length()) {
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		int i = -1;
		do {
			i++;
		}while(string1.charAt(i)!=string2.charAt(i) && i==string1.length()-1);
		
		// als de letters op de index(laatste letter van kortste string) gelijk zijn
		if(string1.charAt(i) == string2.charAt(i)) {
			// als de strings even lang zijn
			if(string1.length() == string2.length()) {
				throw new IllegalArgumentException("Er zijn twee gelijke strings!");
			// als de strings niet even lang zijn
			}else {
				// als de kortste string gelijk is aan eerste
				if(string1.equals(eerste))
					return false;
				// als de kortste string niet gelijk is aan eerste
				return true;
			}
		
		// als de letters ergens niet gelijk zijn
		}else {
			// als de letter op plaats waar letters ongelijk waren van string1 kleiner was dan de letter op plaats waar letters ongelijk waren van string2
			if(string1.charAt(i)<string2.charAt(i)) {
				// indien string 1 al gelijk was aan eerste
				if(string1.equals(eerste))
					return false;
				// indien string 1 nog niet gelijk was aan eerste
				return true;
			// als de letter op plaats waar letters ongelijk waren van string2 kleiner was dan de letter op plaats waar letters ongelijk waren van string1
			}else {
				// indien string 2 al gelijk was aan eerste
				if(string2.equals(eerste))
					return false;
				// indien string 2 nog niet gelijk was aan eerste
				return true;
			}
		}
		
		
	}
	private static boolean vergelijkMetLaatste(String string1, String string2) {
		String laatste = string1;
		// we maken van string1 de kortste string
		if(string1.length()>string2.length()) {
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		int i = -1;
		do {
			i++;
		}while(string1.charAt(i)!=string2.charAt(i) && i==string1.length()-1);
		
		// als de letters op de index(laatste letter van kortste string) gelijk zijn
		if(string1.charAt(i) == string2.charAt(i)) {
			// als de strings even lang zijn
			if(string1.length() == string2.length()) {
				throw new IllegalArgumentException("Er zijn twee gelijke strings!");
			// als de strings niet even lang zijn
			}else {
				// als de langste string gelijk is aan laatste
				if(string2.equals(laatste))
					return false;
				// als de langste string niet gelijk is aan laatste
				return true;
			}
		
		// als de letters ergens niet gelijk zijn
		}else {
			// als de letter op plaats waar letters ongelijk waren van string1 kleiner was dan de letter op plaats waar letters ongelijk waren van string2
			if(string1.charAt(i)>string2.charAt(i)) {
				// indien string 1 al gelijk was aan laatste
				if(string1.equals(laatste))
					return false;
				// indien string 1 nog niet gelijk was aan laatste
				return true;
			// als de letter op plaats waar letters ongelijk waren van string2 kleiner was dan de letter op plaats waar letters ongelijk waren van string1
			}else {
				// indien string 2 al gelijk was aan laatste
				if(string2.equals(laatste))
					return false;
				// indien string 2 nog niet gelijk was aan laatste
				return true;
			}
		}

		
		
	}
	private static String bepaalUitvoer(String[] stringArray, int indexEerste, int indexLaatste) {
		String uitvoer = "";
		String[] namen = stringArray;
		for(int i=0;i<namen.length;i++) {
			uitvoer += namen[i];
			if(i == indexEerste)
				uitvoer += "\tEERSTE";
			else if(i == indexLaatste)
				uitvoer += "\tLAATSTE";
			uitvoer += "\n";
		}
		return uitvoer;
	}

}

