package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Plan;

public interface PlanService {

	public Plan insertPlan(Plan plan);
	public List<Plan> getAllPlans();
	public void deletePlanById(Long id);

}
