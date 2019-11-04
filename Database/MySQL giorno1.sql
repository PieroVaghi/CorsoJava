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


