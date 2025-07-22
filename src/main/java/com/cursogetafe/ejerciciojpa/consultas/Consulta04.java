package com.cursogetafe.ejerciciojpa.consultas;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta04 {

	public static void main(String[] args) {
		//Clientes VIP que han comprado discos
		String categoria = "VIP";
		String producto = "disco";
		
		EntityManager em = Config.getEmf().createEntityManager();
		String jpql = 
				"select c from Cliente c join c.productos p where c.categoria = :cat and p.producto like :prod";
		TypedQuery<Cliente> q = em.createQuery(jpql,Cliente.class);
		q.setParameter("cat", categoria);
		q.setParameter("prod", "%"+ producto + "%");
		
		q.getResultList().forEach(
				c ->{
						System.out.println(c);
						System.out.println(c.getProductos());
					});
		
		
		

	}

}
