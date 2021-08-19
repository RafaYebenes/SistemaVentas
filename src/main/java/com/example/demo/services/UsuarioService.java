package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	public String url ="http://usuario";
	
	public Usuario getUsuarioById(int idUsuario) {
		return restTemplate.getForObject(url +"/api/getUsuarioById/{idusuario}",Usuario.class, idUsuario);
	}
	
}
