package com.cursogetafe.ejerciciojpa.consultas;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consultas02 {

	public static void main(String[] args) {
		// Buscar Clientes de una categoria determinada
		
		String categoria = "VIP";

		
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select c from Cliente c where c.categoria = :cat"; //?1 = parametro 1 
		TypedQuery<Cliente> q = em.createQuery(jpql,Cliente.class);
		q.setParameter("cat", categoria);
		
		q.getResultList().forEach(System.out ::println);
		
		System.out.println("-------------------------");
		
		jpql = "select c from Cliente c where c.categoria = ?1";
		q = em.createQuery(jpql, Cliente.class);
		q.setParameter(1, categoria);
		
		q.getResultList().forEach(System.out::println);
	}

}
