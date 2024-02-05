import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Spedizione {
	
	private ArrayList<Ordine> OrdiniNellaSpedizione;
	private LocalDate DataDiConsegna;
	private Corriere CorriereAssegnato;
	private MezzoDiTrasporto MezzoAssegnato;
	private String ID;
	private double PesoTotaleSpedizione;
	
	public Spedizione(ArrayList<Ordine> ordiniNellaSpedizione, LocalDate dataDiConsegna, Corriere corriereAssegnato,
			MezzoDiTrasporto mezzoAssegnato, String iD, double pesoTotaleSpedizione) {
		super();
		OrdiniNellaSpedizione = ordiniNellaSpedizione;
		DataDiConsegna = dataDiConsegna;
		CorriereAssegnato = corriereAssegnato;
		MezzoAssegnato = mezzoAssegnato;
		ID = iD;
		PesoTotaleSpedizione = pesoTotaleSpedizione;
	}

	
	public Spedizione(LocalDate dataDiConsegna, Corriere corriereAssegnato, MezzoDiTrasporto mezzoAssegnato) {
		super();
		DataDiConsegna = dataDiConsegna;
		CorriereAssegnato = corriereAssegnato;
		MezzoAssegnato = mezzoAssegnato;
	}
	
	public Spedizione() {
		super();
		OrdiniNellaSpedizione = new ArrayList<Ordine>();
	}
	
	// GETTERS AND SETTERS
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public ArrayList<Ordine> getOrdiniNellaSpedizione() {
		return OrdiniNellaSpedizione;
	}


	public void setOrdiniNellaSpedizione(ArrayList<Ordine> ordiniNellaSpedizione) {
		OrdiniNellaSpedizione = ordiniNellaSpedizione;
	}


	public LocalDate getDataDiConsegna() {
		return DataDiConsegna;
	}


	public void setDataDiConsegna(LocalDate dataDiConsegna) {
		DataDiConsegna = dataDiConsegna;
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


	public double getPesoTotaleSpedizione() {
		return PesoTotaleSpedizione;
	}


	public void setPesoTotaleSpedizione(double pesoTotaleSpedizione) {
		PesoTotaleSpedizione = pesoTotaleSpedizione;
	}
	
	public void aggiungiOrdineAllaSpedizione(Ordine o) {
		OrdiniNellaSpedizione.add(o);
	}
	
	public void rimuoviOrdineDallaSpedizione(int posizione) {
		OrdiniNellaSpedizione.remove(posizione);
	}
	
	public void clearOrdiniNellaSpedizione() {
		OrdiniNellaSpedizione.clear();
	}
	
	public void generaIDSpedizione() {
		int leftLimit = 48;
	    int rightLimit = 122;
	    int targetStringLength = 10;
	    Random random = new Random();
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    this.setID(generatedString);
	}
	
	public void calcolaPesoSpedizione() {
		for(Ordine o : OrdiniNellaSpedizione)
		{
			for(Prodotto p : o.getProdottiAcquisti())
				PesoTotaleSpedizione += p.getPeso();
		}
	}
}
