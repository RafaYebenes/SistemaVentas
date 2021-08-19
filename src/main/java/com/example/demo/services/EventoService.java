package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Evento;

@Service
public class EventoService {

	@Autowired
	private RestTemplate restTemplate;
	
	private String url = "http:/PasarelaPago";
	
	public Evento getEventoById(int idEvento) {
		
		Evento evento = new Evento();
		
		//return restTemplate.getForObject(url +"/api/getEventoById/{idEvento}",Evento.class, idEvento);
		
		return evento;
	}
}
