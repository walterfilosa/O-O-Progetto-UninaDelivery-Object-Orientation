import java.time.LocalDate;
import java.util.ArrayList;

public class MezzoDiTrasporto {
    private String Tipo;
    private Double PesoMassimoTrasportabile;
    private String Targa;
    private ArrayList<LocalDate> GiorniDiConsegna = new ArrayList<LocalDate>();

    public MezzoDiTrasporto(String tipo, Double pesoMax, String targa) {
        Tipo = tipo;
        PesoMassimoTrasportabile = pesoMax;
        Targa = targa;
    }

    //Getter e Setter

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Double getPesoMassimoTrasportabile() {
        return PesoMassimoTrasportabile;
    }

    public void setPesoMassimoTrasportabile(Double pesoMax) {
        PesoMassimoTrasportabile = pesoMax;
    }

    public String getTarga() {
        return Targa;
    }

    public void setTarga(String targa) {
        Targa = targa;
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
}
