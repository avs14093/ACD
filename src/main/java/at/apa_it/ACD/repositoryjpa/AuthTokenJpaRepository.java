package at.apa_it.ACD.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.apa_it.ACD.domain.AuthToken;

@Repository
public class AuthTokenJpaRepository extends AbstractJpaRepository<AuthToken>{
	@Override
	public List<AuthToken> findAll() {
		return entityManager().createQuery("SELECT a FROM AuthToken a", AuthToken.class).getResultList();
	}
	
	@Override
	public AuthToken findById(Long id) {
		 return entityManager().find(AuthToken.class, id);
	}
}

