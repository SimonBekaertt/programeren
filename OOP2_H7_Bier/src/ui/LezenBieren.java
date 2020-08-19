package ui;

import persistentie.BierMapper;


/**
 *
 * @author hr047
 */
public class LezenBieren
{
    public static void main(String[] args)
    {
        BierMapper bm = new BierMapper();
        System.out.println(bm.inlezenBieren("bieren.txt"));
    }
            
}
