package com.services.test;


import com.services.modelo.Funcion;
import com.services.repositorio.RepositorioFuncion;


public class AppTest {

	

	public static void main(String[] args) {
	
		RepositorioFuncion RepositorioFuncion = new RepositorioFuncion();
		Funcion funcion = new Funcion();
		funcion.setNombre("001");
		funcion.setDescripcion("Analista de sistema");
		RepositorioFuncion.salvar(funcion);
	}
	
}
