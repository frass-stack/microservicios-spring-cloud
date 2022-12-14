package com.formacionbdi.springboot.app.productos.models.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
		
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id){
		Producto producto = productoService.findById(id);
		producto.setPort(port);
		
		//Simulamos un error para probar Hystrix
		//boolean ok = false;
		//if(!ok) {
		//	throw new RuntimeException("No se pudo cargar el producto");
		//}
		
		//Simulamos latencia
		//try {
		//	Thread.sleep(2000L);
		//} catch (InterruptedException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		return producto;
	}
}