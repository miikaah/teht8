/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teht8;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Terrorist
 */
public class TilaustenKasittelyEasymockTest {

    @Test
    public void testaaKäsittelijäWithEasyMockHinnoittelija() {
        // arrange
        float alkuSaldo = 100.0f;
        float listaHinta = 30.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));

        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija
                = createMock(Hinnoittelija.class);

        // record
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote))
                .andReturn(alennus).times(2);
        hinnoittelija.aloita();
        hinnoittelija.lopeta();
        replay(hinnoittelija);        
        
        // act
        TilaustenKasittely käsittelijä = new TilaustenKasittely();
        käsittelijä.setHinnoittelija(hinnoittelija);
        käsittelijä.käsittele(new Tilaus(asiakas, tuote));
        
        // assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelija);
    }
    
    @Test
    public void testaaKasittelijaaYliSatasella() {
        // arrange
        float alkuSaldo = 200.0f;
        float listaHinta = 150.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));

        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija
                = createMock(Hinnoittelija.class);

        // record
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote))
                .andReturn(alennus).times(2);
        hinnoittelija.aloita();
        hinnoittelija.setAlennusProsentti(asiakas, alennus + 5);
        hinnoittelija.lopeta();
        replay(hinnoittelija);        
        
        // act
        TilaustenKasittely käsittelijä = new TilaustenKasittely();
        käsittelijä.setHinnoittelija(hinnoittelija);
        käsittelijä.käsittele(new Tilaus(asiakas, tuote));
        
        // assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelija);
    }
}
