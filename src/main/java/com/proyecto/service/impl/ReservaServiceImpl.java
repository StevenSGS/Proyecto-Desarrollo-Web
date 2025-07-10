
package com.proyecto.service.impl;

import com.proyecto.dao.ReservaDao;
import com.proyecto.domain.Reserva;
import com.proyecto.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaDao reservaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Reserva> getReservas(boolean activos) {
        var lista=reservaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Reserva getReserva(Reserva reserva){
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);  
    }
    
    @Override
    @Transactional
    public void save(Reserva reserva){
        reservaDao.save(reserva);
    
    }
    
    @Override
    @Transactional
    public void delete(Reserva reserva){
        reservaDao.delete(reserva);
    
    }
}