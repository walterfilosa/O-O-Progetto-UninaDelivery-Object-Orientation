public class CartaDiCredito {
    private String NomeIntestatario;
    private String NumeroCarta;
    private String CVV;
    private int MeseScadenza;
    private int AnnoScadenza;
    

	private Double Saldo = 0.0;

    public CartaDiCredito(String nomeIntestatario, String numeroCarta, String CVV, int meseScadenza, int annoScadenza) {
        NomeIntestatario = nomeIntestatario;
        NumeroCarta = numeroCarta;
        this.CVV = CVV;
        MeseScadenza = meseScadenza;
        AnnoScadenza = annoScadenza;
    }

    //Getter e Setter
    public String getNomeIntestatario() {
        return NomeIntestatario;
    }

    public void setNomeIntestatario(String nomeIntestatario) {
        NomeIntestatario = nomeIntestatario;
    }

    public String getNumeroCarta() {
        return NumeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        NumeroCarta = numeroCarta;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public int getMeseScadenza() {
        return MeseScadenza;
    }

    public void setMeseScadenza(int meseScadenza) {
        MeseScadenza = meseScadenza;
    }
    
    public int getAnnoScadenza() {
		return AnnoScadenza;
	}

	public void setAnnoScadenza(int annoScadenza) {
		AnnoScadenza = annoScadenza;
	}

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }
}
