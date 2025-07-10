
package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;



@Data
@Entity
@Table(name="reserva")
public class Reserva implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_reserva")
    private Long idReserva;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private int cantidadPersonas;
    private String estadoReserva;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    //private Usuario usuario;
    private String descripcion;
    private boolean activo;

    public Reserva() {
    }
    
    
    public Reserva(String reserva, boolean activo) {
        this.descripcion = reserva;
        this.activo = activo;
    }
    
}
    

