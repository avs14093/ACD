package at.apa_it.ACD.repositoryjpa;

public interface PersistenceFactory {
	
    UserJpaRepository userJpaRepository();
    TenantJpaRepository tenantJpaRepository();
    AuthTokenJpaRepository authTokenJpaRepository();
}