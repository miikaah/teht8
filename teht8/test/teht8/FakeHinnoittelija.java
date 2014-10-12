/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teht8;

/**
 *
 * @author Terrorist
 */
public class FakeHinnoittelija extends Hinnoittelija {
    private float alennus;
    
    public FakeHinnoittelija(float alennus) {
        this.alennus = alennus;
    }
    
    @Override
    public float getAlennusProsentti(Asiakas asiakas, Tuote tuote) {
        return alennus;
    }
}
