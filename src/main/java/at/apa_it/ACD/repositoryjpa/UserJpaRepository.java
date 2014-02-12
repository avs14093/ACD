package at.apa_it.ACD.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.apa_it.ACD.domain.User;

@Repository
public class UserJpaRepository extends AbstractJpaRepository<User>{
	@Override
	public List<User> findAll() {
		return entityManager().createQuery("SELECT u FROM User u", User.class).getResultList();
	}
	
	@Override
	public User findById(Long id) {
		 return entityManager().find(User.class, id);
	}
}