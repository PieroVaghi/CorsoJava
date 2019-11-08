package aggregatore;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import enities.*;

public class Azienda {
	
	private List<Dipartimento> dipartimenti = new ArrayList<Dipartimento>();
	private Database db;
	
	public Azienda(String percorso, String username, String pw) {
		db = new Database(percorso, username, pw);
		caricaDipartimenti();
	}

	public void caricaDipartimenti() {
		db.apriConnessione();
		String query = "SELECT * FROM dipartimenti;";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet tabsql = s.executeQuery(query);							// un oggetto ResultSet  è un'intera tabella di SQL, sia dati che metadati
			while(tabsql.next()) {
				Dipartimento d = new Dipartimento(	tabsql.getInt("id"),
													tabsql.getInt("massimacapienza"),
													tabsql.getString("nome"),
													tabsql.getString("citta"),
													tabsql.getDouble("budget"));
				dipartimenti.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
	}
	
	public List<Dipendente> caricaDipendenti() {
		List<Dipendente> dipendenti = new ArrayList<Dipendente>();
		db.apriConnessione();
		String query = "SELECT * FROM azienda.dipendenti;";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);							// un oggetto ResultSet  è un'intera tabella di SQL, sia dati che metadati
			while(rs.next()) {
				Dipendente d = new Dipendente(	rs.getInt("id"),
												rs.getInt("mensilita"),
												rs.getString("nome"),
												rs.getString("cognome"),
												rs.getString("genere"),
												rs.getString("dataNascita"),
												rs.getString("ruolo"),
												rs.getString("citta"),
												rs.getInt("iddipartimento"),
												rs.getString("dataassunzione"),
												rs.getInt("idresponsabile"),
												rs.getDouble("budget"));
				dipendenti.add(d);
				for (Dipartimento dip : dipartimenti) {
					if(dip.aggiungiDipendente(d))
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
		return dipendenti;
	}
	
}
