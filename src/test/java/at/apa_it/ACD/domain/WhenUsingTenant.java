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

public class WhenUsingTenant extends AbstractDomainPersistenceTest{
	
	@Test
	public void EnsureUserPersistsCorrectly() throws Exception {
		Tenant tenant = new Tenant();
		tenant.setUqid("UQID555");
		tenant.setEnabled(true);
		tenant.setDescription("Example tenant");
		
		assertThat(tenant.getId(), is(nullValue()));
		
		entityManager().persist(tenant);
		
		assertThat(tenant.getId(), is(notNullValue()));
	}
	

}
