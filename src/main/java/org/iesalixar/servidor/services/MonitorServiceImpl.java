package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Monitor;
import org.iesalixar.servidor.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService{

	@Autowired
	MonitorRepository monitorRepo;
	
	@Override
	public Monitor insertMonitor(Monitor monitor) {
		
		if (monitor!=null) {
			
			return monitorRepo.save(monitor);
		}
		
		return null;
		
	}
	

	@Override
	public List<Monitor> getAllMonitores() {
		List<Monitor> monitores = monitorRepo.findAll();

		// Verificando que he obtenido algo
		if (monitores != null && monitores.size() > 0) {

			return monitores;
		}
		return new ArrayList<Monitor>();

}
	
	
	@Override
	public void deleteMonitorById(Long id) {
		monitorRepo.deleteById(id);
		

	}

	
}
