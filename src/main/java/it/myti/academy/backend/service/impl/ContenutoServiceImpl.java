package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Contenuto;
import it.myti.academy.backend.model.ContenutoBase;
import it.myti.academy.backend.service.ContenutoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContenutoServiceImpl implements ContenutoService {
    @Override
    public List<Contenuto> generaContenutoBaseByCollo(Collo collo) {

        return collo.getContenuti().stream().map(contenuto -> {
            ContenutoBase contenutoBase = new ContenutoBase();
            contenutoBase.setDescrizione(contenuto.getDescrizione());
            contenutoBase.setId(contenuto.getId());
            contenutoBase.setNome(contenuto.getNome());
            contenutoBase.setQuantita(contenuto.getQuantita());
            contenutoBase.setTempMaxRichiesta(contenuto.getTempMaxRichiesta());
            contenutoBase.setTempMinRichiesta(contenuto.getTempMinRichiesta());
            contenutoBase.setUnitaDiMisura(contenuto.getUnitaDiMisura());
            return contenutoBase;
        }).collect(Collectors.toList());
    }
}