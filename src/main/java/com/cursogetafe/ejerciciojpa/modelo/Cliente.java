package com.cursogetafe.ejerciciojpa.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Rol implements Serializable{

	

	private int nroCliente;
	private String categoria;
	
	
	@ManyToMany //es una relacion muchos a muchos 
	@JoinTable(name = "clientes_productos" , 
				joinColumns =  @JoinColumn(name="idrol"),
				inverseJoinColumns = @JoinColumn(name = "idProducto"))
	private List<Producto> productos;
	
	public Cliente(){
		setRol("CLIENTE");
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Cliente [" + nroCliente + "," + categoria + "," + getIdRol()
				+ "," + getPersona() + "," + getIdPersona() + ","
				+ getApellidos() + "]";
	}
	
	
}
