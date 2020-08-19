/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Dier;
import domein.Hond;
import domein.Kat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sv964
 */
public class DierenMapper
{
    public List<Dier> geefDieren()
    {
        List<Dier> dier = new ArrayList<>();
        dier.add(new Kat(2000));
        dier.add(new Hond(1998, "Fluffy"));
        dier.add(new Kat(2003));
        dier.add(new Hond(2005, "Lady"));
        return dier;
    }
}
