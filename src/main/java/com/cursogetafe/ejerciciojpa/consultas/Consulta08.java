package com.cursogetafe.ejerciciojpa.consultas;

import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import registrosdto.ClienteDTO;

public class Consulta08 {

	public static void main(String[] args) {
		
		// Todos los clientes de dto que compran discos 
		
		todosClientesDTO().forEach(System.out::println);

	}
	
	public static List<ClienteDTO> todosClientesDTO(){
		String producto = "disco";
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select new registrosdto.ClienteDTO(c.idRol, c.persona.apellidos, c.nroCliente, c.categoria) "
				+ "from Cliente c join c.productos p where p.producto like :prod";
		TypedQuery<ClienteDTO> lista = em.createQuery(jpql,ClienteDTO.class);
		lista.setParameter("prod", "%"+ producto + "%");
		
		return lista.getResultList();
		
	}

}
