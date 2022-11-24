package org.iesalixar.servidor.repository;

import org.iesalixar.servidor.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> {

	public Plan findBynombre(String nombre);
}
