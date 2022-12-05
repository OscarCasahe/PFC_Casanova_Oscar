package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Plan;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	PlanRepository planRepo;
	
	@Override
	public Plan insertPlan(Plan plan) {
		
		if (plan!=null) {
			
			return planRepo.save(plan);
		}
		
		return null;
		
	}
	

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> planes = planRepo.findAll();

		// Verificando que he obtenido algo
		if (planes != null && planes.size() > 0) {

			return planes;
		}
		return new ArrayList<Plan>();

}
	
	
	@Override
	public void deletePlanById(Long id) {
		planRepo.deleteById(id);
		

	}


	public Optional<Plan> findPlanById(Long id) {
		Optional<Plan> plan = planRepo.findById(id);

		return plan;
	}


}
