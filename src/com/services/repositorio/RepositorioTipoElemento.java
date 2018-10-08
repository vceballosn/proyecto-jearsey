package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.TipoElemento;

public class RepositorioTipoElemento {
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioTipoElemento(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}
	
	
	/**
	 * Guarda en la base de datos en la tabla TipoElemento
	 * @param TipoElemento
	 */
	public void salvar(TipoElemento tipoElemento){
		em.getTransaction().begin();
		em.merge(tipoElemento);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla TipoElemento
	 * @param TipoElemento
	 */
	public void eliminar(TipoElemento tipoElemento){
		em.getTransaction().begin();
		em.remove(tipoElemento);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos TipoElemento
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public List<TipoElemento> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select curso from Curso curso");
		List<TipoElemento> tipoElementos = consulta.getResultList();
		emf.close();
		return tipoElementos;
	}
	
	/*
	 * Buscar por id
	 */
	
	public TipoElemento objetoId(long id){
		em.getTransaction().begin();
		TipoElemento tipoElemento = em.find(TipoElemento.class, id);
		em.getTransaction().commit();
		return tipoElemento;
	}


}
