public class Operatore {
    private String Nome;
    private String Cognome;
    private String NumeroDiTelefono;
    private String CodiceFiscale;
    private String Email;
    private String Password;

    public Operatore(String nome, String cognome, String numeroDiTelefono, String codiceFiscale, String email, String password) {
        Nome = nome;
        Cognome = cognome;
        NumeroDiTelefono = numeroDiTelefono;
        CodiceFiscale = codiceFiscale;
        Email = email;
        Password = password;
    }

    //Getter e Setter
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
}
