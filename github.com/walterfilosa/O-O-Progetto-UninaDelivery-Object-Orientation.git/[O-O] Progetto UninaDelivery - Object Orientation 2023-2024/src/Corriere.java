import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Corriere {
    private String Nome;
    private String Cognome;
    private String CodiceFiscale;
    private String ID;

	

	private ArrayList<LocalDate> GiorniDiConsegna = new ArrayList<LocalDate>();


    public Corriere(String nome, String cognome, String codiceFiscale) {
        Nome = nome;
        Cognome = cognome;
        CodiceFiscale = codiceFiscale;
    }

    //Getter e Setter
    public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        CodiceFiscale = codiceFiscale;
    }

    public ArrayList<LocalDate> getGiorniDiConsegna() {
        return GiorniDiConsegna;
    }

    public void setGiorniDiConsegna(ArrayList<LocalDate> giorniDiConsegna) {
        GiorniDiConsegna = giorniDiConsegna;
    }
    
    //Metodi
    public void aggiungiGiornoConsegna(LocalDate ld){
        GiorniDiConsegna.add(ld);
    }

    public void rimuoviGiornoConsegna(LocalDate ld){
        GiorniDiConsegna.remove(ld);
    }
    
    public void generaIDCorriere() {
	    int leftLimit = 48;
	    int rightLimit = 122;
	    int targetStringLength = 7;
	    Random random = new Random();
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    this.setID(generatedString);
    }
}
