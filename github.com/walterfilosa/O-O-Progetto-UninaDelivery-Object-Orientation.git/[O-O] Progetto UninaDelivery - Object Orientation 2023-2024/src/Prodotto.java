public class Prodotto {
    private String Nome;
    private String Descrizione;
    private String IdProdotto;
    private double Prezzo;
    private int QuantitàDisponibile;
    private double Peso;
    private String AziendaVenditrice;
    private int quantitàAlCarrello;
    private int quantitàAcquistata;

    

	

	public Prodotto(String nome, String descrizione, String idProdotto, double prezzo, int quantitàDisponibile, double peso, String aziendaVenditrice) {
        Nome = nome;
        Descrizione = descrizione;
        IdProdotto = idProdotto;
        Prezzo = prezzo;
        QuantitàDisponibile = quantitàDisponibile;
        Peso = peso;
        AziendaVenditrice = aziendaVenditrice;
    }

    //Getter e Setter
    public int getQuantitàAcquistata() {
		return quantitàAcquistata;
	}

	public void setQuantitàAcquistata(int quantitàAcquistata) {
		this.quantitàAcquistata = quantitàAcquistata;
	}
	
	public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public String getIdProdotto() {
        return IdProdotto;
    }

    public void setIdProdotto(String idProdotto) {
        IdProdotto = idProdotto;
    }

    public double getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(double prezzo) {
        Prezzo = prezzo;
    }

    public int getQuantitàDisponibile() {
        return QuantitàDisponibile;
    }

    public void setQuantitàDisponibile(int quantitàDisponibile) {
        QuantitàDisponibile = quantitàDisponibile;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public String getAziendaVenditrice() {
        return AziendaVenditrice;
    }

    public void setAziendaVenditrice(String aziendaVenditrice) {
        AziendaVenditrice = aziendaVenditrice;
    }
    
    public int getQuantitàAlCarrello() {
		return quantitàAlCarrello;
	}

	public void setQuantitàAlCarrello(int quantitàAlCarrello) {
		this.quantitàAlCarrello = quantitàAlCarrello;
	}
}
