package com.cursogetafe.ejerciciojpa.consultas;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = Config.getEmf().createEntityManager();
		//fetch hace que el comportamiento sera eager
		
		//busca todos los clientes con todos sus datos que por defecto estan en modo eager.
		//no carga ñps productos (lazy)
		//Para cargar los datos de la Persona, realiza una consulta por cada idRol
		String jpql1 = "select c from Cliente c ";   
		
		//Realiza una consulata con join a personas con todos los datos 
		//no carga los productos (lazy)
		String jpql2 = "select c from Cliente c join fetch c.persona"; 
		
		//Realiza una sola consulta de clientes join roles join perosnas join clientes_productos join productos
		//Devuelve los productos en modo eager
		String jpql3 = "select c from Cliente c join fetch c.persona left join fetch c.productos"; 
		
		TypedQuery<Cliente> q = em.createQuery(jpql3,Cliente.class); //left join fetch c.productos muestra todo los productos
		
		for(Cliente cli: q.getResultList()) {
			System.out.println(cli);
			System.out.println("\t" + cli.getProductos());
		}
	}

}
