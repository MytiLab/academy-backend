package it.myti.academy.backend.model.req;

import lombok.Data;

/**
 * Created by david at 2019-03-20
 */
@Data
public class NewUtente {
    private String nome;
    private String username;
    private String password;
}
