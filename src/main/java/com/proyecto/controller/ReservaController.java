
package com.proyecto.controller;


import com.proyecto.domain.Reserva;
import com.proyecto.service.ReservaService;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ReservaController {

         @Autowired
    private ReservaService reservaService;

    @GetMapping("/listado")//localhost:8080/reserva/listado
    public String inicio(Model model) {
        var reservas = reservaService.getReservas(false);
        model.addAttribute("reservas", reservas);//Union del codigo con la vista
        model.addAttribute("totalReservas", reservas.size());
        return "/reserva/listado";
    }
    
    @GetMapping("/reserva")
    public String mostrarReserva() {
        return "reserva"; 
    }

    @GetMapping("/nuevo")//localhost:8080/reserva/nuevo
    public String reservaNuevo(Reserva reserva){
        return "/reserva/formulario";
    }
    
        
    @PostMapping("/guardar")
    public String guardarReserva(
            @RequestParam("fecha_reserva") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha,
            @RequestParam("hora_reserva") @DateTimeFormat(pattern = "HH:mm") LocalTime hora,
            @RequestParam("cantidad_personas") int cantidadPersonas,
            @RequestParam("id_usuario") Long idUsuario
    ) {
        Reserva reserva = new Reserva();
        reserva.setFechaReserva(fecha);
        reserva.setHoraReserva(hora);
        reserva.setCantidadPersonas(cantidadPersonas);
        reserva.setEstadoReserva("pendiente");

        //Usuario usuario = new Usuario();
        //usuario.setIdUsuario(idUsuario);
       // reserva.setUsuario(usuario);

        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }
     
@GetMapping("/eliminar/{idReserva}")
public String reservaEliminar(Reserva reserva) {
    reservaService.delete(reserva);
    return "redirect:/reserva/listado";
}

@GetMapping("/modificar/{idReserva}")
public String reservaModificar(Reserva reserva, Model model) {
    reserva = reservaService.getReserva(reserva);
    model.addAttribute("reserva", reserva);
    return "/reserva/formulario";
}}