package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
	
}