package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Monitor;


public interface MonitorService {

	public Monitor insertMonitor(Monitor monitor);
	public List<Monitor> getAllMonitores();
	public void deleteMonitorById(Long id);

}
