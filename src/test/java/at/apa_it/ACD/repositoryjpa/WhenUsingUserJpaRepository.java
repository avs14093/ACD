package at.apa_it.ACD.repositoryjpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import at.apa_it.ACD.domain.User;

public class WhenUsingUserJpaRepository extends AbstractJpaRepositoryTest{
	
	@Test
	public void EnsureUserCantBeFoundByIdCorrectly() throws Exception {
		UserJpaRepository userJpaRepository = new UserJpaRepository();
		userJpaRepository.setEntityManager(entityManager);
		
		User user = userJpaRepository.findById(01L);
		
		assertThat(user, is(nullValue()));
	}
	
	@Test
	public void EnsurePersistedUserCanBeFoundByIdCorrectly() throws Exception {
		UserJpaRepository userJpaRepository = new UserJpaRepository();
		userJpaRepository.setEntityManager(entityManager);
		
		User userGiven = new User();
		userGiven.setUsername("Avsar");
		
		userJpaRepository.persist(userGiven);
		
		User userFound = userJpaRepository.findById(userGiven.getId());
		
		assertThat(userFound, equalTo(userGiven));
	}
	
	@Test
	public void EnsureGivenUserListCanBeFoundCorrectly() throws Exception {
		UserJpaRepository userJpaRepository = new UserJpaRepository();
		userJpaRepository.setEntityManager(entityManager);
		
		List<User> givenUsers = new ArrayList<>();
		givenUsers.add(new User("User1"));
		givenUsers.add(new User("User2"));
		givenUsers.add(new User("User3"));
		
		userJpaRepository.persist(givenUsers.get(0));
		userJpaRepository.persist(givenUsers.get(1));
		userJpaRepository.persist(givenUsers.get(2));
		
		List<User> foundUsers = userJpaRepository.findAll();
		
		assertThat(foundUsers, equalTo(givenUsers));
	}
}
