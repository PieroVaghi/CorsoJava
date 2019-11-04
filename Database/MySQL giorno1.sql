-- Commento in SQL Creazione DB
create database azienda;

use azienda;

create table dipendenti 
(
	id int primary key auto_increment,
    nome varchar(100) not null,
    cognome varchar(100) not null,
    datanascita date, -- yyyy-mm-dd
    cf varchar(16),
    genere varchar(1),
    ruolo varchar(100),
    anniexp int,
    stipendio float not null,
    mensilita int,
    cittaresidenza varchar(100)
);

commit;

SELECT * FROM azienda.dipendenti;

insert into dipendenti values
(1,'Clara','Bianchini','1995-02-04','xxxx','F','programmatore','2',1200,13,'Milano'),
(2,'Carlo','Verdi','1985-01-29','xxxx','M','pm',13,1800.23,14,'Varese');

insert into dipendenti 
(nome, cognome, genere, ruolo, anniexp, stipendio, mensilita, cittaresidenza, datanascita)
 values
('David','Salvio','M','Attetto pulizie',15,1700,14,'Napoli','1975-12-27'),
('Eleonora','Rossi','F','Programmatore',2,1200,11,'Milano','1993-12-27'),
('Simone','Simoni','M','Addetto vendite',22,2300,14,'Roma','1970-12-27'),
('Andrea','Invernezi','F','Pm',23,2400,13,'Reggio Calabria','1980-12-27');

insert into dipendenti 
(nome, cognome, genere, ruolo, anniexp, stipendio, mensilita, cittaresidenza, datanascita)
 values
('Carlo','Bello','M','pm',5,1900,14,'Empoli','1990-12-27'),
('Valentino','Rossi','M','Programmatore',1,1300,12,'Buguggiate','1994-12-27'),
('Simone','Cristicchi','M','Addetto pulizie',25,1200,14,'Renate','1969-12-27'),
('Beatrice','Lavatrice','F','Responsabile',10,2200,13,'Casorate','1984-12-27');

select nome, cognome, cittaresidenza,
'dipendente' dipendenti
from dipendenti;

-- arrotonda a tre cifre decimali
select nome, cognome, cittaresidenza,
stipendio, round(stipendio*mensilita,3) stipendioannuo
from dipendenti;

-- tronca tutti i decimali
select nome, cognome, cittaresidenza,
stipendio, floor(stipendio*mensilita) stipendioannuo
from dipendenti;

-- arrotonda tutto per eccesso
select nome, cognome, cittaresidenza,
stipendio, ceil(stipendio*mensilita) stipendioannuo
from dipendenti;

-- concatena in una colonna di contenuto testuale
select concat(nome, ' ', cognome) nomimativo, cittaresidenza,
stipendio, round(stipendio*mensilita,2) stipendioannuo
from dipendenti;

-- ricerca di un id specifico
select concat(nome, ' ', cognome) nomimativo, cittaresidenza
from dipendenti
where id = 3;

-- ESERCIZI --------------------------------------------------------

-- voglio visualizzare il nome, cognome, ruolo e stipendio dei dipendenti che prendono uno stipendio > di 2000€
select nome, cognome, ruolo, stipendio
from dipendenti
where stipendio > 2000;

-- visualizza nome, cognome, genere, cittaresidenza delle persone che vivono a milano, varese, verona e sono maschie
select nome, cognome, genere, cittaresidenza
from dipendenti
where (cittaresidenza = 'milano' or cittaresidenza = 'varese' or cittaresidenza = 'verona') and genere = 'M';

-- visualizza nome, cognome, genere, cittaresidenza delle persone che vivono a milano, varese, verona e sono maschie
select nome, cognome, genere, cittaresidenza
from dipendenti
where cittaresidenza in('milano','varese','verona') and genere = 'm';

-- voglio visualizzare le persone che hanno il ruolo che inizia per addetto
select nome, cognome, ruolo, stipendio
from dipendenti
where ruolo like 'addet%';

-- voglio visualizzare il nome, cognome, stipendio delle persone di genere femminile residenti a milano
select nome, cognome, stipendio
from dipendenti
where genere = 'f' and cittaresidenza = 'milano';

-- voglio visualizzare il nome, ruolo e stipendioannuo dei programmatori voglio che la tabella abbia l'alias D.
select d.nome, d.ruolo, concat(d.stipendio*d.mensilita,' €') stipendioannuo
from dipendenti d
where d.ruolo = 'programmatore';

-- voglio visualizzare le persone che hanno l'iniziale nome compreso tra la lettera L e la lettera P
select nome, cognome
from dipendenti
where nome between 'l' and 'p'; -- OCCHIO che si ferma a p

-- voglio visualizzare i nominativi per ordine alfabetico decrescente
select concat(nome, ' ', cognome) nominativo
from dipendenti
order by nominativo desc;

-- voglio visualizzare i nominativi per ordine alfabetico decrescente
select concat(nome, ' ', cognome) nominativo
from dipendenti
order by concat(nome, ' ', cognome) desc; -- alcuni casi di DBMS non gestiscono gli alias e quindi dobbiamo scrivere così

-- voglio visualizzare i nomi e cognomi per ordine alfabetico decrescente e i cognomi in ordine alfabetico crescente
select nome, cognome 
from dipendenti
order by nome desc, cognome asc; -- il primo ha prevalenza, in caso di uguaglianze passa alla seconda condizione

-- visualizzare le persone che sono nate tra il 1980 e 1999
select *
from dipendenti
where datanascita between '1980-01-01' and '1999-12-31';
-- Usiamo la funzione scalare year
select *, dayname(datanascita) giorno, year(datanascita) anno
from dipendenti
where year(datanascita) between 1980 and 1999
order by anno
-- Esiste anche month e day

-- visualizza che giorno era nel mese e nella settimana quando sono nati i nostri dipendenti
select dayofyear(datanascita) giornoAnno, dayofmonth(datanascita) giornoMese, dayofweek(datanascita) giornoSettimana
from dipendenti
-- domenica è 1

-- visualizza che giorno era nel mese e nella settimana quando sono nati i nostri dipendenti
select dayofyear(datanascita) giornoAnno, dayofmonth(datanascita) giornoMese, dayofweek(datanascita) giornoSettimana, dayname(datanascita) nomeGiorno
from dipendenti
-- domenica è 1

-- visualizza l'età dei dipenenti
select year(now()) - year(datanascita) eta
from dipendenti
order by eta;
select floor(datediff(now(), datanascita)/365.25) eta
from dipendenti
order by eta;
-- datediff restituisce differenza in giorni

-- voglio visualizzare il numero dei dipendenti
select count(*)
from dipendenti

-- voglio calcolare la somma di tutti gli stipendi
-- count è l'unica funzione di gruppo che può avere l'asterisco tra le tonde
-- le altre devono per forza avee almeno una colonna come strumento di calcolo
select sum(stipendio)
from dipendenti;

-- voglio calcolare la media di tutti gli stipendi
select concat(round(avg(stipendio),2),' €') madiaStipendi
from dipendenti;

-- voglio visualizzare lo stipendio più alto
-- MODO 1 - Furbo
select nome, stipendio
from dipendenti
order by stipendio desc limit 1; -- OCCHIO!! la seconda persona, nel caso di identico stipendio, non verrà visualizzata
-- MODO 2 - Saggio e con la conoscenza delle funzioni di gruppo
select concat(round(max(stipendio)),' €') StipendioMax
from dipendenti;
-- MODO 2 - SBAGLIATO!!!!
select nome, concat(round(max(stipendio)),' €') StipendioMax 
from dipendenti; -- SBAGLIATO!! ci restituisce il primo nome! non quello dello stipendio più alto! 

-- voglio visualizzare lo stipendio più basso
-- FURBO
select stipendio
from dipendenti
order by stipendio limit 1; -- OCCHIO!! la seconda persona, nel caso di identico stipendio, non verrà visualizzata
-- SAGGIO
select concat(round(min(stipendio)),' €') stipendioMin
from dipendenti;