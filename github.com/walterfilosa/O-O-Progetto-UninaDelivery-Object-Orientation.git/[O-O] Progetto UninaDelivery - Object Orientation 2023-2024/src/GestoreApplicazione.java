import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GestoreApplicazione {
	
	LoginUtente loginUtente;
	OperatoreLoginFrame operatoreLoginFrame;
	RegistraUtenteFrame registraUtenteFrame;
	HomePageOperatore homePageOperatore;
	ModificaOperatoreInfo modificaOperatoreInfo;
	GestioneProdotti gestioneProdotti;
	AggiungiProdotto aggiungiProdotto;
	HomePageUtente homePageUtente;
	AggiungiOperatore aggiungiOperatore;
	InfoUtente infoUtente;
	InfoOperatore infoOperatore;
	InfoOperatoreLoggato infoOperatoreLoggato;
	ModificaUtenteFrame modificaUtenteFrame;
	ListaProdottiFrame listaProdottiFrame;
	InfoProdotto infoProdotto;
	CarrelloFrame carrelloFrame;
	Checkout checkout;
	PortfolioFrame portfolioFrame;
	AggiungiCartaFrame aggiungiCartaFrame;
	AggiungiImporto aggiungiImporto;
	StoricoOrdiniFrame storicoOrdiniFrame;
	InfoOrdineFrame infoOrdineFrame;
	InfoProdottoInOperatore infoProdottoInOperatore;
	ModificaProdottoFrame modificaProdottoFrame;
	GestioneCorrieriMezzi gestioneCorriereMezzi;
	InfoCorriere infoCorriere;
	InfoMezzo infoMezzo;
	ModificaCorriere modificaCorriere;
	ModificaMezzo modificaMezzo;
	AggiungiCorriere aggiungiCorriere;
	AggiungiMezzo aggiungiMezzo;
	VisualizzaOperatori visualizzaOperatori;
	GestioneOrdini gestioneOrdini;
	ReportMensileFrame reportMensileFrame;
	FiltraFrame filtraFrame;
	GestioneSpedizioni gestioneSpedizioni;
	CreaSpedizioneFrame creaSpedizioneFrame;
	ImpostaCorriereMezzo impostaCorriereMezzo;
	ScegliDataConsegna scegliDataConsegna;
	RiepilogoSpedizioneFrame riepilogoSpedizioneFrame;
	InfoSpedizione infoSpedizione;
	
	ArrayList<Utente> ListaUtenti = new ArrayList<Utente>();
	ArrayList<Prodotto> ListaProdotti = new ArrayList<Prodotto>();
	ArrayList<Operatore> ListaOperatori = new ArrayList<Operatore>();
	ArrayList<Ordine> ListaOrdini = new ArrayList<Ordine>();
	ArrayList<Corriere> ListaCorrieri = new ArrayList<Corriere>();
	ArrayList<MezzoDiTrasporto> ListaMezzi = new ArrayList<MezzoDiTrasporto>();
	ArrayList<Spedizione> ListaSpedizioni = new ArrayList<Spedizione>();
	ArrayList<Ordine> OrdiniGestiti = new ArrayList<Ordine>();
	
	
    public static void main(String[] args){
        GestoreApplicazione ga = new GestoreApplicazione();
    }
    

    public GestoreApplicazione(){
    	
    	ListaUtenti.add(new Utente("Mario", "De Maio", "0818991234", "Via Roma, Caserta", "DMEMRA03S13B963D", "mariodemaio@studenti.unina.it", "object2024"));
    	ListaUtenti.add(new Utente("Walter", "Filosa", "0818995678", "Corso Vittorio Emanuele, Napoli", "FLSWTR03A10M289M", "walterfilosa@studenti.unina.it", "object2024"));
    	
    	ListaOperatori.add(new Operatore("Elon", "Musk", "0818991316", "MSKLNE05K89C575S", "elon.musk@unina.it", "tesla"));
    	ListaOperatori.add(new Operatore("Bill", "Gates", "0818990934", "GTSBLI34M29N123Z", "bill.gates@unina.it", "microsoft"));
    	
    	ListaProdotti.add(new Prodotto("Laptop", "Laptop da gaming professionale. 32GB di RAM, 1TB di spazio di archiviazione.", "Sk49memu5g", 1024.00, 2, 3.50, "ASUS"));
    	ListaProdotti.add(new Prodotto("Tavoletta grafica", "Tavoletta grafica professionale, compatibile con tutti gli OS.", "Gvbmy2367m", 80.00, 12, 0.50, "WACOM"));
    	ListaProdotti.add(new Prodotto("Cuffie Wireless", "Cuffie Wireless professionali. Connettività Bluetooth 6.0. Con supporto per ascolto audio in 8D.", "Smbc56fd0a", 300.00, 20, 1.50, "Logitech"));
    	
    	Corriere c1 = new Corriere("Usain", "Bolt", "BLTSNU08B16C420D");
    	c1.generaIDCorriere();
    	ListaCorrieri.add(c1);
    	Corriere c2 = new Corriere("Jannik", "Sinner", "SNRJNK08U17C901M");
    	c2.generaIDCorriere();
    	ListaCorrieri.add(c2);
    	ListaMezzi.add(new MezzoDiTrasporto("Furgone", 1000.00, "NA123MM"));
    	ListaMezzi.add(new MezzoDiTrasporto("Scooter", 50.00, "NA789QQ"));
    	
    	loginUtente = new LoginUtente(this);
    	operatoreLoginFrame = new OperatoreLoginFrame(this);
    	registraUtenteFrame = new RegistraUtenteFrame(this);
    	homePageOperatore = new HomePageOperatore(this);
    	modificaOperatoreInfo = new ModificaOperatoreInfo(this);
    	gestioneProdotti = new GestioneProdotti(this);
    	aggiungiProdotto = new AggiungiProdotto(this);
    	homePageUtente = new HomePageUtente(this);
    	aggiungiOperatore = new AggiungiOperatore(this);
    	infoUtente = new InfoUtente(this);
    	infoOperatore = new InfoOperatore(this);
    	infoOperatoreLoggato = new InfoOperatoreLoggato(this);
    	modificaUtenteFrame = new ModificaUtenteFrame(this);
    	listaProdottiFrame = new ListaProdottiFrame(this);
    	infoProdotto = new InfoProdotto(this);
    	carrelloFrame = new CarrelloFrame(this);
    	checkout = new Checkout(this);
    	portfolioFrame = new PortfolioFrame(this);
    	aggiungiCartaFrame = new AggiungiCartaFrame(this);
    	aggiungiImporto = new AggiungiImporto(this);
    	storicoOrdiniFrame = new StoricoOrdiniFrame(this);
    	infoOrdineFrame = new InfoOrdineFrame(this);
    	infoProdottoInOperatore = new InfoProdottoInOperatore(this);
    	modificaProdottoFrame = new ModificaProdottoFrame(this);
    	gestioneCorriereMezzi = new GestioneCorrieriMezzi(this);
    	infoCorriere = new InfoCorriere(this);
    	infoMezzo = new InfoMezzo(this);
    	modificaCorriere = new ModificaCorriere(this);
    	modificaMezzo = new ModificaMezzo(this);
    	aggiungiCorriere = new AggiungiCorriere(this);
    	aggiungiMezzo = new AggiungiMezzo(this);
    	visualizzaOperatori = new VisualizzaOperatori(this);
    	gestioneOrdini = new GestioneOrdini(this);
    	reportMensileFrame = new ReportMensileFrame(this);
    	filtraFrame = new FiltraFrame(this);
    	gestioneSpedizioni = new GestioneSpedizioni(this);
    	creaSpedizioneFrame = new CreaSpedizioneFrame(this);
    	impostaCorriereMezzo = new ImpostaCorriereMezzo(this);
    	scegliDataConsegna = new ScegliDataConsegna(this);
    	riepilogoSpedizioneFrame = new RiepilogoSpedizioneFrame(this);
    	infoSpedizione = new InfoSpedizione(this);
    	
    	loginUtente.setVisible(true);
    	operatoreLoginFrame.setVisible(false);
    	registraUtenteFrame.setVisible(false);
    	homePageOperatore.setVisible(false);
    	modificaOperatoreInfo.setVisible(false);
    	gestioneProdotti.setVisible(false);
    	aggiungiProdotto.setVisible(false);
    	homePageUtente.setVisible(false);
    	aggiungiOperatore.setVisible(false);
    	infoUtente.setVisible(false);
    	infoOperatore.setVisible(false);
    	infoOperatoreLoggato.setVisible(false);
    	modificaUtenteFrame.setVisible(false);  
    	listaProdottiFrame.setVisible(false);
    	infoProdotto.setVisible(false);
    	carrelloFrame.setVisible(false);
    	checkout.setVisible(false);
    	portfolioFrame.setVisible(false);
    	aggiungiCartaFrame.setVisible(false);
    	aggiungiImporto.setVisible(false);
    	storicoOrdiniFrame.setVisible(false);
    	infoOrdineFrame.setVisible(false);
    	infoProdottoInOperatore.setVisible(false);
    	modificaProdottoFrame.setVisible(false);
    	infoMezzo.setVisible(false);
    	modificaCorriere.setVisible(false);
    	modificaMezzo.setVisible(false);
    	aggiungiCorriere.setVisible(false);
    	aggiungiMezzo.setVisible(false);
    	visualizzaOperatori.setVisible(false);
    	gestioneOrdini.setVisible(false);
    	reportMensileFrame.setVisible(false);
    	filtraFrame.setVisible(false);
    	gestioneSpedizioni.setVisible(false);
    	creaSpedizioneFrame.setVisible(false);
    	impostaCorriereMezzo.setVisible(false);
    	scegliDataConsegna.setVisible(false);
    	riepilogoSpedizioneFrame.setVisible(false);
    	infoSpedizione.setVisible(false);
    }
    
    public void switchLoginToOperatore() {
    	operatoreLoginFrame.setVisible(true);
    	loginUtente.setVisible(false);
    	
    }
    
    public void switchLoginToUtente() {
    	loginUtente.setVisible(true);
    	operatoreLoginFrame.setVisible(false);
    }
    
    public void switchToRegisterUser() {
    	loginUtente.setVisible(false);
    	registraUtenteFrame.setVisible(true);
    }
    
    public void backFromRegisterMenu() {
    	registraUtenteFrame.setVisible(false);
    	loginUtente.setVisible(true);
    }
    
    public void fromLoginOperatoreToHomePageOperatore() {
    	operatoreLoginFrame.setVisible(false);
    	homePageOperatore.setVisible(true);
    }
    
    public void fromHomePageOperatoreToLoginOperatore() {
    	operatoreLoginFrame.setVisible(true);
    	homePageOperatore.setVisible(false);
    }
    
    public void FromHomePageOperatoreToInfoOperatoreLoggato() {
    	homePageOperatore.setVisible(false);
    	infoOperatoreLoggato.setVisible(true);
    }
    
    public void fromInfoOperatoreLoggatoToHomePageOperatore() {
    	homePageOperatore.setVisible(true);
    	infoOperatoreLoggato.setVisible(false);
    }
    
    public void fromHomePageOperatoreToGestioneProdotti() {
    	homePageOperatore.setVisible(false);
		gestioneProdotti.setVisible(true);
    }
    
    public void fromGestioneProdottiToHomePageOperatore() {
    	homePageOperatore.setVisible(true);
		gestioneProdotti.setVisible(false);
    }
    
    public void registrazioneCompletata() {
    	registraUtenteFrame.setVisible(false);
    	loginUtente.setVisible(true);
    }
    
    public void fromLoginUtenteToHomePageUtente() {
    	loginUtente.setVisible(false);
    	homePageUtente.setVisible(true);
    }
    
    public void fromHomePageUtenteToLoginUtente() {
    	loginUtente.setVisible(true);
    	homePageUtente.setVisible(false);
    }
    
    public void fromHomePageUtenteToCheckout() {
    	carrelloFrame.setVisible(true);
    	homePageUtente.setVisible(false);
    }
    
    public void fromCheckoutToHomePageUtente() {
    	homePageUtente.setVisible(true);
    	carrelloFrame.setVisible(false);
    }
    
    public void fromCheckoutToListaProdotti() {
    	homePageUtente.setVisible(true);
    	listaProdottiFrame.setVisible(true);
    	carrelloFrame.setVisible(false);
    }
    
    public void fromCarrelloFrameToCheckout() {
    	checkout.setVisible(true);
    	carrelloFrame.setVisible(false);
    }
    
    public void fromCheckoutToCarrelloFrame() {
    	checkout.setVisible(false);
    	carrelloFrame.setVisible(true);
    }
    
    public void fromHomePageOperatoreToGestioneCorrieriMezzi() {
    	gestioneCorriereMezzi.setVisible(true);
    	homePageOperatore.setVisible(false);
    }
    
    public void fromGestioneCorrieriMezziToHomePageOperatore() {
    	gestioneCorriereMezzi.setVisible(false);
    	homePageOperatore.setVisible(true);
    }
    
    public void fromHomePageOperatoreToVisualizzaOperatori() {
    	homePageOperatore.setVisible(false);
    	visualizzaOperatori.setVisible(true);
    }
    
    public void fromVisualizzaOperatoriToHomePageOperatore() {
    	homePageOperatore.setVisible(true);
    	visualizzaOperatori.setVisible(false);
    }
    
    public void fromHomePageOperatoreToGestioneSpedizioni() {
    	homePageOperatore.setVisible(false);
    	gestioneOrdini.setVisible(true);
    }
    
    public void fromGestioneSpedizioniToHomePageOperatore() {
    	homePageOperatore.setVisible(true);
    	gestioneOrdini.setVisible(false);
    }
    
    public void fromGestioneOrdiniToReportMensileFrame() {
    	gestioneOrdini.setVisible(false);
    	reportMensileFrame.setVisible(true);
    }
    
    public void fromReportMensileFrameToGestioneOrdini() {
    	gestioneOrdini.setVisible(true);
    	reportMensileFrame.setVisible(false);
    }
    
    public void fromGestioneOrdiniToGestioneSpedizioni() {
    	gestioneOrdini.setVisible(false);
    	gestioneSpedizioni.setVisible(true);
    }
    
    public void fromGestioneSpedizioniToGestioneOrdini() {
    	gestioneOrdini.setVisible(true);
    	gestioneSpedizioni.setVisible(false);
    }
    
    public void fromImpostaCorriereMezzoToRiepilogoSpedizioneFrame() {
    	impostaCorriereMezzo.setVisible(false);
    	riepilogoSpedizioneFrame.setVisible(true);
    }
    
    public void fromRiepilogoSpedizioneFrameToImpostaCorriereMezzo() {
    	impostaCorriereMezzo.setVisible(true);
    	riepilogoSpedizioneFrame.setVisible(false);
    }

    
    public void setBluLink(JComponent jc) {
    	Color bluLink = new Color(0,2,160);
    	jc.setForeground(Color.black);
    	jc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jc.setForeground(bluLink);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jc.setForeground(Color.black);
			}
		});
    }
    
    public void setIconFrame(JFrame f)
    {
    	f.setIconImage(new ImageIcon("Icons/Logo.png").getImage());
    }
    
}
