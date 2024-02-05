import java.time.LocalDate;
import java.util.ArrayList;


public class Ordine {
    private String IdOrdine;
    private ArrayList<Prodotto> ProdottiAcquistati = new ArrayList<Prodotto>();
    private Double PrezzoTotale;
    private Utente Acquirente;
    private String IndirizzoDiSpedizione;
    private Corriere CorriereAssegnato;
    private MezzoDiTrasporto MezzoAssegnato;
    private LocalDate DataDiConsegna;
    private LocalDate DataAcquisto;
    private CartaDiCredito MetodoPagamento;
    private boolean assegnataASpedizione;

 
	public Ordine(String idOrdine, Double prezzoTotale, Utente acquirente, String indirizzoDiSpedizione, LocalDate dataAcquisto, CartaDiCredito metodoPagamento) {
        IdOrdine = idOrdine;
		PrezzoTotale = prezzoTotale;
        Acquirente = acquirente;
        IndirizzoDiSpedizione = indirizzoDiSpedizione;
        DataAcquisto = dataAcquisto;
        MetodoPagamento = metodoPagamento;
    }

    //Getter e Setter

    public boolean isAssegnataASpedizione() {
		return assegnataASpedizione;
	}

	public void setAssegnataASpedizione(boolean assegnataASpedizione) {
		this.assegnataASpedizione = assegnataASpedizione;
	}
	
	public CartaDiCredito getMetodoPagamento() {
		return MetodoPagamento;
	}

	public void setMetodoPagamento(CartaDiCredito metodoPagamento) {
		MetodoPagamento = metodoPagamento;
	}
	
	public String getIdOrdine() {
        return IdOrdine;
    }

    public void setIdOrdine(String idOrdine) {
        IdOrdine = idOrdine;
    }

    public ArrayList<Prodotto> getProdottiAcquisti() {
        return ProdottiAcquistati;
    }

    public void setProdottiAcquisti(ArrayList<Prodotto> prodottiAcquisti) {
        ProdottiAcquistati = prodottiAcquisti;
    }

    public Double getPrezzoTotale() {
        return PrezzoTotale;
    }

    public void setPrezzoTotale(Double prezzoTotale) {
        PrezzoTotale = prezzoTotale;
    }

    public Utente getAcquirente() {
        return Acquirente;
    }

    public void setAcquirente(Utente acquirente) {
        Acquirente = acquirente;
    }

    public String getIndirizzoDiSpedizione() {
        return IndirizzoDiSpedizione;
    }

    public void setIndirizzoDiSpedizione(String indirizzoDiSpedizione) {
        IndirizzoDiSpedizione = indirizzoDiSpedizione;
    }

    public Corriere getCorriereAssegnato() {
        return CorriereAssegnato;
    }

    public void setCorriereAssegnato(Corriere corriereAssegnato) {
        CorriereAssegnato = corriereAssegnato;
    }

    public MezzoDiTrasporto getMezzoAssegnato() {
        return MezzoAssegnato;
    }

    public void setMezzoAssegnato(MezzoDiTrasporto mezzoAssegnato) {
        MezzoAssegnato = mezzoAssegnato;
    }

    public LocalDate getDataDiConsegna() {
        return DataDiConsegna;
    }

    public void setDataDiConsegna(LocalDate dataDiConsegna) {
        DataDiConsegna = dataDiConsegna;
    }

    public LocalDate getDataAcquisto() {
        return DataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        DataAcquisto = dataAcquisto;
    }

    //Metodi
    
    public void riempiOrdine(){
        for(Prodotto pr: Acquirente.getCarrello()){
           Prodotto p = new Prodotto(pr.getNome(), pr.getDescrizione(), pr.getIdProdotto(), pr.getPrezzo(), pr.getQuantitàDisponibile(), pr.getPeso(), pr.getAziendaVenditrice());
           p.setQuantitàAcquistata(pr.getQuantitàAcquistata());
           ProdottiAcquistati.add(p);
        }
    }

    public void updateStoricoOrdini(){
        Acquirente.getStoricoOrdini().add(this);
    }
    
    public double calcolaPesoTotaleOrdine() {
    	double pesoTotaleOrdine = 0.0;
    	for(Prodotto p : ProdottiAcquistati)
    		pesoTotaleOrdine += p.getQuantitàAcquistata() * p.getPeso();
    	return pesoTotaleOrdine;
    }
}