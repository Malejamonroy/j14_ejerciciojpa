package com.cursogetafe.ejerciciojpa.consultas;



import java.util.LinkedList;
import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.ClienteCategoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta06 {

	public static void main(String[] args) {
//		EntityManager em = Config.getEmf().createEntityManager();
//		
//		// Buscarla cantidad de clientes por categoria
//
//		
//		String jpql = "select c.categoria, count(c.idRol) from Cliente c group by c.categoria";
//		List<Object[]> lista = em.createQuery(jpql,Object[].class).getResultList();
//		
//		for(Object[] objects :lista) {
//			System.out.println(objects[0] + ":" + objects[1]);
//			
//		}
		
		cantClientePorCategoria().forEach(System.out::println);
	}
	
	public static List<ClienteCategoria> cantClientePorCategoria() {
		EntityManager em = Config.getEmf().createEntityManager();
		
		// Buscarla cantidad de clientes por categoria
		
		//forma 1 de hacer la Query 
		String jpql = "select new com.cursogetafe.ejerciciojpa.modelo.ClienteCategoria(c.categoria, count(c.idRol))"
				+ " from Cliente c group by c.categoria";
		//forma de 2 de hacer la Query
//		String jpql = "select c.categoria, count(c.idRol)"
//				+ " from Cliente c group by c.categoria";
		TypedQuery<ClienteCategoria> lista = em.createQuery(jpql,ClienteCategoria.class);
		
		return lista.getResultList();
		
	}

	
	public static List<ClienteCategoria> cantClientePorCategoriaManual() {
		EntityManager em = Config.getEmf().createEntityManager();
		
		// Buscarla cantidad de clientes por categoria

		
		String jpql = "select c.categoria, count(c.idRol) from Cliente c group by c.categoria";
		TypedQuery<Object[]> lista = em.createQuery(jpql,Object[].class);
		
		List<Object[]> objetos = lista.getResultList();
		
		List<ClienteCategoria> resu = new LinkedList<>();
		
		for(Object[] array : objetos) {
			resu.add(new ClienteCategoria((String)array[0], (Long)array[1]));
			
		}
		return resu;
	}
}
