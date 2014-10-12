package teht8;

public class Tilaus {

    private Asiakas asiakas;
    private Tuote tuote;

    public Tilaus(Asiakas asiakas, Tuote tuote) {
        this.asiakas = asiakas;
        this.tuote = tuote;
    }

    public Tuote getTuote() {
        return tuote;
    }
    
    public Asiakas getAsiakas() {
        return asiakas;
    }

}
