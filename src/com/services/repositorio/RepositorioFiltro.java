package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.Filtro;

public class RepositorioFiltro {

	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioFiltro(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}
	
	/**
	 * Guarda en la base de datos en la tabla Filtro
	 * @param Filtro
	 */
	public void salvar(Filtro filtro){
		
			em.getTransaction().begin();
			em.merge(filtro);
			em.getTransaction().commit();
			emf.close();		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla TipoFiltro
	 * @param Filtro
	 */
	public void eliminar(Filtro filtro){
		em.getTransaction().begin();
		em.remove(filtro);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos
	 * @param TipoFiltro
	 */
	
	@SuppressWarnings("unchecked")
	public List<Filtro> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select filtro from Filtro filtro, TipoFiltro tipoFiltro where filtro.idCatTipoFiltro =tipoFiltro.idCatTipoFiltro ");
		List<Filtro> filtros = consulta.getResultList();
		emf.close();
		return filtros;
	}
	
	/*
	 * Buscar por id
	 */
	
	public Filtro objetoId(long id){
		em.getTransaction().begin();
		Filtro filtro = em.find(Filtro.class, id);
		em.getTransaction().commit();
		return filtro;
	}

	
}
