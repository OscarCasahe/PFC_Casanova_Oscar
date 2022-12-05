package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Plan;

public interface PlanService {

	public Plan insertPlan(Plan plan);
	public Optional<Plan> findPlanById(Long id);
	public List<Plan> getAllPlans();
	public void deletePlanById(Long id);

}
