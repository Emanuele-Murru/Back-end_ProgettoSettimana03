package App;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import entities.Libri;
import entities.Periodicita;
import entities.Prestito;
import entities.Prodotto;
import entities.Riviste;
import entities.Utente;
import utils.CatalogoDAO;

public class Main {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoSettimana03");
	
	private static Logger log = Logger.getLogger(Main.class);

		public static void main(String[] args) {
			
			EntityManager em = emf.createEntityManager();
			
			CatalogoDAO cat = new CatalogoDAO(em);

			// -----------------------SAVE-------------------------------------
			Utente utente1 = new Utente("225487", "Emanuele", "Murru", LocalDate.of(1998, 04, 02));
			Utente utente2 = new Utente("984248", "Marco", "M&P", LocalDate.of(1983, 02, 25));

			Libri libro1 = new Libri(12345678915L, "Uno, Nessuno, Centomila", 1926, 224, "PIRANDELLO", "Romanzo - Narrativa");
			Libri libro2 = new Libri(1234567897840L, "Il Silmarillion", 2007, 682, "J.R.R. TOLKIEN", "Romanzo - Fantasy - Mitopoiesi");

			Riviste rivista1 = new Riviste(1584746548L, "Sorrisi&Canzoni", 1952, 38, Periodicita.SETTIMANALE);
			Riviste rivista2 = new Riviste(984516556854L, "QuattroRuote", 1956, 252, Periodicita.MENSILE);

			cat.addUtente(utente1);
			cat.addUtente(utente2);

			cat.addProdotto(libro1);
			cat.addProdotto(libro2);
			cat.addProdotto(rivista1);
			cat.addProdotto(rivista2);

			cat.cancellaTramiteIsbnCode(1584746548L);

			Prodotto item = cat.cercaTramiteIsbnCode(1584746548L);
			log.info(item);

			List<Prodotto> elementiAnno = cat.ricercaPerAnnoPubblicazione(2007);
			log.info(elementiAnno);

			List<Prodotto> elementiAutore = cat.cercaTramiteAutore("PIRANDELLO");
			log.info(elementiAutore);

			List<Prodotto> elementiTitolo = cat.cercaTramiteTitolo("QuattroRuote");
			log.info(elementiTitolo);

			Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.of(2023, 7, 15), LocalDate.of(2022, 9, 1),
					LocalDate.of(2023, 9, 15));
			cat.addPrestito(prestito1);
			
			Prestito prestito2 = new Prestito(utente2, rivista2, LocalDate.of(2023, 1, 1), LocalDate.of(2022, 2, 1),
					LocalDate.of(2023, 2, 5));
			cat.addPrestito(prestito2);

			List<Prestito> prestitiUtente = cat.cercaPrestitiUtente("984248");
			log.info(prestitiUtente);

			List<Prestito> prestitiScadutiNonRestituiti = cat.cercaPrestitiScaduti();
			log.info(prestitiScadutiNonRestituiti);

			em.close();
			emf.close();
	}
}
