
package teht8;

public class TilaustenKasittely {

    private Hinnoittelija hinnoittelija;

    public void setHinnoittelija(Hinnoittelija hinnoittelija) {
        this.hinnoittelija = hinnoittelija;
    }

    public void käsittele(Tilaus tilaus) {

        float alennusProsentti = hinnoittelija.getAlennusProsentti(
                tilaus.getAsiakas(), tilaus.getTuote());
        float alennusHinta = tilaus.getTuote().getHinta()
                * (1 - (alennusProsentti / 100));
        tilaus.getAsiakas().setSaldo(
                tilaus.getAsiakas().getSaldo() - alennusHinta);
    }
}
