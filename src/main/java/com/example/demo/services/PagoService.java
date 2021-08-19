package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Compra;
import com.example.demo.model.Estado;

@Service
public class PagoService {

	
	@Autowired
	private RestTemplate restTemplate;
	
	private String url = "http://PasarelaPago/pasarela";
	
	public Estado realizarPago(Compra compra) {
		
		Estado status = new Estado();
		
		System.out.println("Sistema de Ventas\n" + compra.toString());
		status = restTemplate.postForObject(url + "/compra", compra, Estado.class);
			          
		return status;
	}
	
}
