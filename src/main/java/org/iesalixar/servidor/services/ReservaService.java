package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Reserva;

public interface ReservaService {

	public Reserva insertReserva(Reserva reserva);
	public List<Reserva> getAllReservas();
	public void deleteReservaById(Long id);

}
