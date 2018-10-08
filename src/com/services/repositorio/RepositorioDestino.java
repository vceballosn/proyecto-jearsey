package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.Destino;

public class RepositorioDestino {
	

	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioDestino(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}
	/**
	 * Guarda en la base de datos en la tabla destino
	 * @param destino
	 */
	public void salvar(Destino destino){
		em.getTransaction().begin();
		em.merge(destino);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla destino
	 * @param destino
	 */
	public void eliminar(Destino destino){
		em.getTransaction().begin();
		em.remove(destino);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos
	 * @param destino
	 */
	
	@SuppressWarnings("unchecked")
	public List<Destino> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select destino from Destino destino");
		List<Destino> funciones = consulta.getResultList();
		emf.close();
		return funciones;
	}
	
	/*
	 * Buscar por id
	 */
	
	public Destino objetoId(long id){
		em.getTransaction().begin();
		Destino destino = em.find(Destino.class, id);
		em.getTransaction().commit();
		return destino;
	}

}
