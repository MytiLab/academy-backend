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