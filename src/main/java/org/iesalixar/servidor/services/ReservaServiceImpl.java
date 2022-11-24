package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Reserva;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	ReservaRepository reservaRepo;
	
	@Override
	public Reserva insertReserva(Reserva reserva) {
		
		if (reserva!=null) {
			
			return reservaRepo.save(reserva);
		}
		
		return null;
		
	}
	

	@Override
	public List<Reserva> getAllReservas() {
		List<Reserva> reservas = reservaRepo.findAll();

		// Verificando que he obtenido algo
		if (reservas != null && reservas.size() > 0) {

			return reservas;
		}
		return new ArrayList<Reserva>();

}
	
	
	@Override
	public void deleteReservaById(Long id) {
		reservaRepo.deleteById(id);
		

	}

	
}
