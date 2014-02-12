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

public class WhenUsingUser extends AbstractDomainPersistenceTest{
	
	@Test
	public void EnsureUserPersistsCorrectly() throws Exception {
		User user = new User();
		user.setUsername("Testusername1");
		assertThat(user.getId(), is(nullValue()));
		
		entityManager().persist(user);
		
		assertThat(user.getId(), is(notNullValue()));
	}
	

}
