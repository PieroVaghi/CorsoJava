package aggregatore;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import enities.*;

public class Azienda implements IAzienda{
	
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
			Statement s = db.getConnection().createStatement(); 				// createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet tabsql = s.executeQuery(query);							// un oggetto ResultSet è un'intera tabella di SQL, sia dati che metadati
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
												rs.getDouble("stipendio"));
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
	
	public List<Lingua> caricaLingue() {
		List<Lingua> lingue = new ArrayList<Lingua>();
		db.apriConnessione();
		String query = "select lingue.id, lingue.nome, lingue.bonus, parla.iddipendente, parla.competenza from parla join lingue on parla.idlingua = lingue.id";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);							// un oggetto ResultSet  è un'intera tabella di SQL, sia dati che metadati
			while(rs.next()) {
				Lingua l = new Lingua(	rs.getInt("id"),
												rs.getInt("competenza"),
												rs.getInt("iddipendente"),
												rs.getString("nome"),
												rs.getDouble("bonus"));
				lingue.add(l);
				for (Dipartimento dip : dipartimenti) 
					for(Dipendente d : dip.getDipendenti())
						if(d.aggiungiLingua(l))
							break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
		return lingue;
	}

	public int numDip() {
		int cont = 0;
		for(Dipartimento dipa : dipartimenti)
			cont += dipa.getDipendenti().size();
		return cont;
	}
	
	@Override
	public double totstipendi() {
		double ris = 0;
		for(Dipartimento dipa : dipartimenti)
			for(Dipendente dipe : dipa.getDipendenti())
				ris += dipe.getStipendio();
	return ris;
	}

	@Override
	public double avgstipendi() {
		return totstipendi()/numDip();
	}

	@Override
	public double minstipendi() {
		double min = Double.MAX_VALUE;
		for(Dipartimento dipa : dipartimenti)
			for(Dipendente dipe : dipa.getDipendenti())
				min = (min > dipe.getStipendio()) ? dipe.getStipendio() : min;
	return min;
	}

	@Override
	public double maxstipendi() {
		double max = Double.MIN_VALUE;
		for(Dipartimento dipa : dipartimenti)
			for(Dipendente dipe : dipa.getDipendenti())
				max = (max < dipe.getStipendio()) ? dipe.getStipendio() : max;
	return max;
	}

	@Override
	public double totstipendiNonORM() {
		db.apriConnessione();
		String query = "select round(sum(stipendio),2) totStipendi from dipendenti;";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);
			return (rs.next() && rs != null) ? rs.getDouble("totStipendi") : 0;		
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			db.chiudiConnessione();
		}
	}

	@Override
	public double avgstipendiNonORM() {
		db.apriConnessione();
		String query = "select round(avg(stipendio),2) totStipendi from dipendenti;";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);
			return (rs.next() && rs != null) ? rs.getDouble("totStipendi") : 0;		
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			db.chiudiConnessione();
		}
	}

	@Override
	public double minstipendiNonORM() {
		db.apriConnessione();
		String query = "select round(min(stipendio),2) totStipendi from dipendenti;";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);
			return (rs.next() && rs != null) ? rs.getDouble("totStipendi") : 0;		
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			db.chiudiConnessione();
		}
	}

	@Override
	public double maxstipendiNonORM() {
		db.apriConnessione();
		String query = "select round(max(stipendio),2) totStipendi from dipendenti;";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);
			return (rs.next() && rs != null) ? rs.getDouble("totStipendi") : 0;		
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			db.chiudiConnessione();
		}
	}
	
}
