package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.TipoFiltro;;

public class RepositorioTipoFiltro {
  
	EntityManagerFactory emf;
	EntityManager em;
	public RepositorioTipoFiltro(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}

	/**
	 * Guarda en la base de datos en la tabla TipoFiltro
	 * @param TipoFiltro
	 */
	public void salvar(TipoFiltro tipoFiltro){
		
			em.getTransaction().begin();
			em.merge(tipoFiltro);
			em.getTransaction().commit();
			emf.close();		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla TipoFiltro
	 * @param TipoFiltro
	 */
	public void eliminar(TipoFiltro tipoFiltro){
		em.getTransaction().begin();
		em.remove(tipoFiltro);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos
	 * @param TipoFiltro
	 */
	
	@SuppressWarnings("unchecked")
	public List<TipoFiltro> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select tf from TipoFiltro tf ");
		List<TipoFiltro> tipoFiltros = consulta.getResultList();
		emf.close();
		return tipoFiltros;
	}
	
	/*
	 * Buscar por id
	 */
	
	public TipoFiltro objetoId(long id){
		em.getTransaction().begin();
		TipoFiltro tipoFiltro = em.find(TipoFiltro.class, id);
		em.getTransaction().commit();
		return tipoFiltro;
	}

	
	
}
