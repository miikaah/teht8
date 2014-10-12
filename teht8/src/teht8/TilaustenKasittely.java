
package teht8;

public class TilaustenKasittely {

    private Hinnoittelija hinnoittelija;

    public void setHinnoittelija(Hinnoittelija hinnoittelija) {
        this.hinnoittelija = hinnoittelija;
    }

    /*public void käsittele(Tilaus tilaus) {

        float alennusProsentti = hinnoittelija.getAlennusProsentti(
                tilaus.getAsiakas(), tilaus.getTuote());
        float alennusHinta = tilaus.getTuote().getHinta()
                * (1 - (alennusProsentti / 100));
        tilaus.getAsiakas().setSaldo(
                tilaus.getAsiakas().getSaldo() - alennusHinta);
    }*/
    
    public void käsittele(Tilaus tilaus) {
        Asiakas asiakas = tilaus.getAsiakas();
        Tuote tuote = tilaus.getTuote();
        hinnoittelija.aloita();
        float prosentti = hinnoittelija.getAlennusProsentti(asiakas, tuote);
        
        if (tuote.getHinta() >= 100) {
            hinnoittelija.setAlennusProsentti(asiakas, prosentti + 5);
        }
        
        prosentti = hinnoittelija.getAlennusProsentti(asiakas, tuote);
        float alennusHinta = tuote.getHinta() * (1 - (prosentti / 100));
        asiakas.setSaldo(asiakas.getSaldo() - alennusHinta);
        hinnoittelija.lopeta();
    }
}
