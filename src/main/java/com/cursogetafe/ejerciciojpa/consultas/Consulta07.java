package com.cursogetafe.ejerciciojpa.consultas;

import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import registrosdto.ClienteDTO;

public class Consulta07 {

	public static void main(String[] args) {
		// Todos los clientes del listado dto
		
		todosClientesDTO().forEach(System.out::println);

	}
	
	public static List<ClienteDTO> todosClientesDTO(){
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select new registrosdto.ClienteDTO(c.idRol, c.persona.apellidos, c.nroCliente, c.categoria) from Cliente c";
		TypedQuery<ClienteDTO> lista = em.createQuery(jpql,ClienteDTO.class);
		
		return lista.getResultList();
		
	}

}
