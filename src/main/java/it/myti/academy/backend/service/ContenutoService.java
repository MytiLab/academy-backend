package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Contenuto;

import java.util.List;

public interface ContenutoService {
    List<Contenuto> generaContenutoBaseByCollo(Collo collo);
}
