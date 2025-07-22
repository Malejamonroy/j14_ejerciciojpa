package com.cursogetafe.ejerciciojpa.consultas;



import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta06 {

	public static void main(String[] args) {
		EntityManager em = Config.getEmf().createEntityManager();
		
		// Buscarla cantidad de clientes por categoria

		
		String jpql = "select c.categoria, count(c.idRol) from Cliente c group by c.categoria";
		List<Object[]> lista = em.createQuery(jpql,Object[].class).getResultList();
		
		for(Object[] objects :lista) {
			System.out.println(objects[0] + ":" + objects[1]);
			
		}
		
	}
	
	public static List<Object[]> cantClientePorCategoria() {
		EntityManager em = Config.getEmf().createEntityManager();
		
		// Buscarla cantidad de clientes por categoria

		
		String jpql = "select c.categoria, count(c.idRol) from Cliente c group by c.categoria";
		TypedQuery<Object[]> lista = em.createQuery(jpql,Object[].class);
		
		return lista.getResultList();
		
	}

}
