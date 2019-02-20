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
       (1, 'TRAIN_AAAA', '2019-02-01', 'BRESCIA', '2019-02-03', 'MILANO');

INSERT INTO colli (`id`, `unita_logistica_id`, `spedizione_id`, `utente_id`)
VALUES ( 1,  1, 1, 1);