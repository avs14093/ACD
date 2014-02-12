package at.apa_it.ACD.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import at.apa_it.ACD.domain.AuthToken;
import at.apa_it.ACD.repositoryjpa.AuthTokenJpaRepository;

public class WhenUsingAuthToken extends AbstractDomainPersistenceTest{
	
	@Test
	public void EnsureAuthTokenPersistsCorrectly() throws Exception {
		AuthToken authToken = new AuthToken();
		authToken.setUqid("UQID123");
		assertThat(authToken.getId(), is(nullValue()));
		
		entityManager().persist(authToken);
		
		assertThat(authToken.getId(), is(notNullValue()));
	}
	

}
