INSERT INTO utenti (`id`, `username`, `password`, `nome`)
VALUES
  (1, 'logistic@galbanino.it', 'ciaociao123', 'Logistica Galbanino');

INSERT INTO tipologie_eventi (`id`, `nome`, `descrizione`)
VALUES
  (1, 'EVENTO PRATICLE', 'Evento proveniente da Particle'),
  (2, 'EVENTO HANNIBAL', 'Evento proveniente da Hannibal');

INSERT INTO stati_unita_logistiche (`id`, `nome`, `descrizione`)
VALUES
  ( 1, 'NORMALE', 'Unità funzionante che può essere usata' ),
  ( 2, 'ROTTA', 'Unità rotta' ),
  ( 3, 'IN VIAGGIO', 'Unità in viaggio' ),
  ( 4, 'IN ATTESA', 'Unità in attesa' );

INSERT INTO unita_logistiche (`id`, `codice`, `id_esterno`, `temp_massima`, `temp_minima`, `stato_id`)
VALUES ( 1, 'AAAA', 'UL2', 12, -12, 1);

INSERT INTO spedizioni (`id`, `codice_treno`, `partenza_il`, `partenza_da`, `arrivo_il`, `arrivo_a`)
VALUES
(1, 'TRAIN_AAAA', '2019-02-01', 'BRESCIA', '2019-05-03', 'MILANO');

INSERT INTO colli (`id`, `unita_logistica_id`, `spedizione_id`, `utente_id`)
VALUES ( 1,  1, 1, 1);

INSERT INTO eventi (`id`, `ricevuto_il`, `evento_tipo_id`, `collo_id`, `evento_tipo_dettaglio`)
VALUES
       (1, '2019-02-01 10:30:04', 2, 1, 2),
       (2, '2019-02-01 10:30:34', 1, 1, 1),
       (3, '2019-02-01 10:40:34', 1, 1, 1),
       (4, '2019-02-01 10:50:34', 1, 1, 1),
       (5, '2019-02-01 11:00:34', 1, 1, 1),
       (6, '2019-02-01 11:10:34', 1, 1, 1);

INSERT INTO eventi_hannibal (`id`, `codice_evento`, `codice_treno`)
VALUES  (1, 'EPARTE' , '0000010123');

INSERT INTO eventi_particle (`id`, `temperatura`, `umidita`, `porta_aperta`, `latitudine`, `longitudine`, `accuratezza`)
VALUES
      (2, 2.1, 80.6, 0, 45.556556, 10.216596, 100),
      (3, 2.7, 81.0, 0, 45.556556, 10.216596, 100),
      (4, 2.56, 80.8, 0, 45.556556, 10.216596, 100),
      (5, 2.82, 80.3, 0, 45.556556, 10.216596, 100),
      (6, 2.93, 79.9, 0, 45.556556, 10.216596, 100);

INSERT INTO contenuti (`id`, `nome`, `descrizione`, `temperatura_minima_ricchiesta`, `temperatura_massima_ricchiesta`, `quantita`, `unita_di_misura`, `collo_id`)
VALUES
      (1, 'CAVOLO CAPPUCCIO', 'Detto anche verza', 2, 5, 10, 'kg', 1),
      (2, 'STRACCHINO', 'Detto anche robbiola', 2, 3, 20, 'kg', 1);