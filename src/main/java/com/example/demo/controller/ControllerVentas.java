package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Compra;
import com.example.demo.model.Estado;
import com.example.demo.model.Usuario;
import com.example.demo.services.EventoService;
import com.example.demo.services.PagoService;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/ventas")
public class ControllerVentas {

	
	@Autowired
	private UsuarioService uService;
	
	@Autowired
	private PagoService pService;
	
	@Autowired
	private EventoService eService;
	
	
	@PostMapping("/realizarVenta/{idUsuario}/{idEvento}")
	public Estado realizarVenta(@PathVariable("idUsuario") int idUsuario, @PathVariable("idEvento") int idEvento) {
	
		Estado status = new Estado();
		
		Usuario user = uService.getUsuarioById(idUsuario);
		
		status = pService.realizarPago(new Compra(eService.getEventoById(idEvento), user));
		
		return status;
		
	}
	
}
