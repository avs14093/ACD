package at.apa_it.ACD.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.apa_it.ACD.domain.Tenant;

@Repository
public class TenantJpaRepository extends AbstractJpaRepository<Tenant>{
	@Override
	public List<Tenant> findAll() {
		return entityManager().createQuery("SELECT t FROM Tenant t", Tenant.class).getResultList();
	}
	
	@Override
	public Tenant findById(Long id) {
		 return entityManager().find(Tenant.class, id);
	}
}

