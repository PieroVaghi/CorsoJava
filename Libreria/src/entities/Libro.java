package entities;

public class Libro {
		public String titolo;
		public String autore;
		public int nPag;
		public String genere;
		public String casaEditrice;
		double prezzo;
		
		
		public double costo() {
			if (isAudioLibro())
				prezzo = 15.0;
			else
				switch (genere.toLowerCase()) {
					case "horror":
						prezzo = nPag * 0.04;
					break;
					case "giallo":
						prezzo = nPag * 0.02;
					break;
					default:
						prezzo = nPag * 0.06;
					break;
				}
			return prezzo;
		}
		
		public double sconto() {
			prezzo = costo();
			switch (casaEditrice.toLowerCase()) {
				case "gloria fantasia":
					prezzo -= prezzo/100*10;
				break;
				case "pazienza":
					prezzo = prezzo/100*5;
				break;
				default:
				break; 
			}
			return prezzo;
		}
		
		public boolean isAudioLibro() {
			return nPag == 0;
		}
		
		public boolean isGenereGloriaPref() {
			return (genere.equalsIgnoreCase("fantasy") 		||
					genere.equalsIgnoreCase("fantascienza") ||
					genere.equalsIgnoreCase("horror"));
		}
		
		public String scheda() {
			String risposta = 	"SCHEDA LIBRO:" +
								"\n-----------------------------------" +
								"\nTitolo:\t\t\t" 		+ titolo 		+
								"\nAutore:\t\t\t" 		+ autore 		+
								"\nNumero Pagine:\t\t" 	+ nPag 			+
								"\nCasa Editrice:\t\t"	+ casaEditrice 	+
								"\nCosto Scontato:\t\t"	+ sconto()		+
								"\nE' un audiolibro?:\t"+ isAudioLibro();
;			return risposta;
		}
}
