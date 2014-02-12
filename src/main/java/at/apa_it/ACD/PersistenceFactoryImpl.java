package at.apa_it.ACD;

import java.util.HashMap;

import javax.persistence.EntityManager;

import at.apa_it.ACD.repositoryjpa.AuthTokenJpaRepository;
import at.apa_it.ACD.repositoryjpa.JpaRepository;
import at.apa_it.ACD.repositoryjpa.PersistenceFactory;
import at.apa_it.ACD.repositoryjpa.TenantJpaRepository;
import at.apa_it.ACD.repositoryjpa.UserJpaRepository;

/**
 * The factory for all repositories...
 */
public class PersistenceFactoryImpl implements PersistenceFactory {

    private final HashMap<Class<?>, JpaRepository> repositories = new HashMap<Class<?>, JpaRepository>();

    public PersistenceFactoryImpl(EntityManager entityManager) {
        UserJpaRepository userJpaRepository = new UserJpaRepository();
        userJpaRepository.setEntityManager(entityManager);
        repositories.put(UserJpaRepository.class, userJpaRepository);
    }

	public UserJpaRepository userJpaRepository() {
		return (UserJpaRepository) repositories.get(UserJpaRepository.class);
	}

	public TenantJpaRepository tenantJpaRepository() {
		return (TenantJpaRepository) repositories.get(TenantJpaRepository.class);
	}

	public AuthTokenJpaRepository authTokenJpaRepository() {
		return (AuthTokenJpaRepository) repositories.get(AuthTokenJpaRepository.class);
	}
    
    
}
