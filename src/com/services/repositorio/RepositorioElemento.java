package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.Elemento;

public class RepositorioElemento {
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioElemento(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}
	
	/**
	 * Guarda en la base de datos en la tabla Elemento
	 * @param destino
	 */
	public void salvar(Elemento elemento){
		em.getTransaction().begin();
		em.merge(elemento);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla Elemento
	 * @param elemento
	 */
	public void eliminar(Elemento elemento){
		em.getTransaction().begin();
		em.remove(elemento);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos Elementos
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public List<Elemento> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select elemento from Elemento elemento");
		List<Elemento> cursos = consulta.getResultList();
		emf.close();
		return cursos;
	}
	
	/*
	 * Buscar por id
	 */
	
	public Elemento objetoId(long id){
		em.getTransaction().begin();
		Elemento elementos = em.find(Elemento.class, id);
		em.getTransaction().commit();
		return elementos;
	}


	
}
