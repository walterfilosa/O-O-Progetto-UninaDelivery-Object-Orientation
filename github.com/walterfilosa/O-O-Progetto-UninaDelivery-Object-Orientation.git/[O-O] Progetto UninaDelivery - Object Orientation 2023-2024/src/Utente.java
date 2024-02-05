import java.time.LocalDate;
import java.util.ArrayList;

public class Utente {
    private String Nome;
    private String Cognome;
	private String NumeroDiTelefono;
    private String CodiceFiscale;
    private String IndirizzoDiResidenza;
    private String Email;
    private String Password;
    private ArrayList<Ordine> StoricoOrdini = new ArrayList<Ordine>();
    private ArrayList<Prodotto> Carrello = new ArrayList<Prodotto>();
    private CartaDiCredito Carta;


    public Utente(String nome, String cognome, String numeroDiTelefono, String indirizzoDiResidenza, String codiceFiscale, String email, String password) {
        Nome = nome;
        Cognome = cognome;
        NumeroDiTelefono = numeroDiTelefono;
        IndirizzoDiResidenza = indirizzoDiResidenza;
        CodiceFiscale = codiceFiscale;
        Email = email;
        Password = password;
    }

    //Getter e Setter
     public CartaDiCredito getCarta() {
		return Carta;
	}

	public void setCarta(CartaDiCredito carta) {
		Carta = carta;
	}
	
	public ArrayList<Prodotto> getCarrello() {
        return Carrello;
    }

    public void setCarrello(ArrayList<Prodotto> carrello) {
        Carrello = carrello;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getNumeroDiTelefono() {
		return NumeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		NumeroDiTelefono = numeroDiTelefono;
	}

	public String getIndirizzoDiResidenza() {
        return IndirizzoDiResidenza;
    }

    public void setIndirizzoDiResidenza(String indirizzoDiResidenza) {
        IndirizzoDiResidenza = indirizzoDiResidenza;
    }

    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        CodiceFiscale = codiceFiscale;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public ArrayList<Ordine> getStoricoOrdini() {
        return StoricoOrdini;
    }

    public void setStoricoOrdini(ArrayList<Ordine> storicoOrdini) {
        StoricoOrdini = storicoOrdini;
    }

    //Metodi
    public void aggiungiOrdineAlllStorico(Ordine o){
        StoricoOrdini.add(o);
    }

    public void rimuoviOrdineDalloStorico(Ordine o){
        StoricoOrdini.remove(o);
    }
    
    public void aggiungiProdottoAlCarrello(Prodotto pr){
        Carrello.add(pr);
    }

    public void rimuoviProdottoDalCarrello(Prodotto pr){
        Carrello.remove(pr);
    }

    public void svuotaCarrello(){
        Carrello.clear();
    }
    
    public void incrementaQuantita(int posizione){
    	Carrello.get(posizione).setQuantitàDisponibile(Carrello.get(posizione).getQuantitàDisponibile() + 1);
    }
    
    public void decrementaQuantita(int posizione) {
    	Carrello.get(posizione).setQuantitàDisponibile(Carrello.get(posizione).getQuantitàDisponibile() - 1);
    }

}
