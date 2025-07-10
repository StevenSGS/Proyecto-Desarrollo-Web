
package com.proyecto.service;

import com.proyecto.domain.Reserva;
import java.util.List;


public interface ReservaService {
        //asigna el metodo para despues implementarlo en el serviceImpl (Read)
    public List<Reserva> getReservas(boolean activos);
    
    public Reserva getReserva(Reserva reserva);
    
    public void save(Reserva reserva);
    
    public void delete(Reserva reserva);
    
}
