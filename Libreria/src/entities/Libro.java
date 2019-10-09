package entities;

public class Libro {
		public String titolo;
		public String autore;
		public int nPag;
		public String genere;
		public String casaEditrice;
		double prezzo;
		
		
		/**
		 * 
		 * @return
		 * Ritorna il prezzo in base alle pagine del libro
		 * tenendo conto dei costi per pagina
		 */
		
		public double costo() {
			prezzo = nPag;
			if (isAudioLibro())
				prezzo = 15.0;
			else
				switch (genere.toLowerCase()) {
					case "horror":
						prezzo *= 0.04;
					break;
					case "giallo":
						prezzo *= 0.02;
					break;
					default:
						prezzo *= 0.06;
					break;
				}
			return prezzo;
		}
		

		public String etichettaSconto() {
			String risposta = "";
			if(casaEditrice.equalsIgnoreCase("gloraifantasia"))
				risposta += "hai lo sconto del 10%";
			if(casaEditrice.equalsIgnoreCase("pazienza"))
				risposta += "hai lo sconto del 5%";
			return risposta;
		}
		

		public double valoreSconto() {
			double risposta = 0;
			if(casaEditrice.equalsIgnoreCase("gloraifantasia"))
				risposta = costo()*0.1 ;
			if(casaEditrice.equalsIgnoreCase("pazienza"))
				risposta = costo()*0.05;
			return risposta;
		}
		
		/**
		 * 
		 * @return
		 * Restituisco il prezzo del libro scontato,
		 * dipende dalla casa editrice
		 */
		
		public double sconto() {
//			prezzo = costo();
//			switch (casaEditrice.toLowerCase()) {
//				case "gloria fantasia":
//					prezzo -= valoreSconto();
//				break;
//				case "pazienza":
//					prezzo -= valoreSconto();
//				break;
//				default:
//				break; 
//			}
			return costo()-valoreSconto();
		}
		
		/**
		 * 
		 * @return
		 * True se è audiolibro
		 * False se non lo è
		 */
		
		public boolean isAudioLibro() {
			return nPag == 0;
		}
		
		/**
		 * 
		 * @return
		 * True se il genere è uno dei preferiti di GLoria:
		 * Fantasy, Fantascienza o Horror
		 */
		
		public boolean isGenereGloriaPref() {
			return  genere.equalsIgnoreCase("fantasy") 		||
					genere.equalsIgnoreCase("fantascienza") ||
					genere.equalsIgnoreCase("horror");
		}
		
		/**
		 * 
		 * @return
		 * Ritorna un oggetto Libro che è la copia di quello su cui è stato chiamato.
		 */
		
		public Libro copia() {
			Libro copia = new Libro();
			copia.titolo = titolo;
			copia.autore = autore;
			copia.nPag = nPag;
			copia.genere = genere;
			copia.casaEditrice = casaEditrice;
			return copia;
		}
		
		/**
		 * 
		 * @return
		 * Restituisce la scheda del libro
		 */
		
		public String scheda() {
			return	"SCHEDA LIBRO:" +
					"\n-------------------------------------------------------" +
					"\nTitolo:\t\t\t" 		+ titolo 		+
					"\nAutore:\t\t\t" 		+ autore 		+
					"\nNumero Pagine:\t\t" 	+ nPag 			+
					"\nGenere:\t\t" 		+ genere 		+
					"\nCasa Editrice:\t\t"	+ casaEditrice 	+
					"\nCosto Scontato:\t\t"	+ sconto()		+
					"\nE' un audiolibro?:\t"+ (isAudioLibro() ? "Si è un audiolibro" : "No");
		}
}
