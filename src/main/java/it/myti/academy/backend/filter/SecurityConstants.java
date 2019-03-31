package it.myti.academy.backend.filter;

public interface SecurityConstants {
    final static Long EXPIRATION_TIME = 3600000L;
    final static String TOKEN_PREFIX = "Bearer ";
    final static String HEADER_STRING = "Authorization";
    final static String SECRET = "this-is-a-secret";
    final static String SIGN_UP_URL = "/utente";
}
