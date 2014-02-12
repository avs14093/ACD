package at.apa_it.ACD.repositoryjpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import at.apa_it.ACD.domain.AuthToken;

public class WhenUsingAuthTokenJpaRepository extends AbstractJpaRepositoryTest{
	
	@Test
	public void EnsureAuthTokenCantBeFoundByIdCorrectly() throws Exception {
		AuthTokenJpaRepository authTokenJpaRepository = new AuthTokenJpaRepository();
		authTokenJpaRepository.setEntityManager(entityManager);
		AuthToken authToken = authTokenJpaRepository.findById(01L);
		
		assertThat(authToken, is(nullValue()));
	}
	
	@Test
	public void EnsurePersistedAuthTokenCanBeFoundByIdCorrectly() throws Exception {
		AuthTokenJpaRepository authTokenJpaRepository = new AuthTokenJpaRepository();
		authTokenJpaRepository.setEntityManager(entityManager);
		
		AuthToken givenAuthToken = new AuthToken();
		givenAuthToken.setUqid("UQIDAUTHTOKEN123");
		
		authTokenJpaRepository.persist(givenAuthToken);
		
		AuthToken authTokenFound = authTokenJpaRepository.findById(givenAuthToken.getId());
		
		assertThat(authTokenFound, equalTo(givenAuthToken));
	}
	
	@Test
	public void EnsureGivenUserAuthTokenListCanBeFoundCorrectly() throws Exception {
		AuthTokenJpaRepository authTokenJpaRepository = new AuthTokenJpaRepository();
		authTokenJpaRepository.setEntityManager(entityManager);
		
		List<AuthToken> givenAuthTokens = new ArrayList<>();
		givenAuthTokens.add(new AuthToken("Token1"));
		givenAuthTokens.add(new AuthToken("Token2"));
		givenAuthTokens.add(new AuthToken("Token3"));
		
		authTokenJpaRepository.persist(givenAuthTokens.get(0));
		authTokenJpaRepository.persist(givenAuthTokens.get(1));
		authTokenJpaRepository.persist(givenAuthTokens.get(2));
		
		List<AuthToken> foundAuthTokens = authTokenJpaRepository.findAll();
		
		assertThat(foundAuthTokens, equalTo(givenAuthTokens));
	}
}
