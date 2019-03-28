package it.myti.academy.backend.filter;

/**
 * Created by david at 2019-03-20
 */
public interface SecurityConstants {
    final static Long EXPIRATION = 3600000L;
    final static String TOKEN_PREFIX = "Bearer ";
    final static String HEADER_STRING = "Authorization";
    final static String SECRET = "this-is-a-secret";
}
