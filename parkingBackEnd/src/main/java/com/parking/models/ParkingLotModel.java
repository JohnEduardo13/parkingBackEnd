package com.parking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parqueadero")
public class ParkingLotModel {
	
	@Id
	@Column(name = "id_parqueadero")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idParqueadero;
	@Column(name = "barrio")
	private String barrio;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private int telefono;
	@Column(name = "cupo_total")
	private int cupoTotal;
	@Column(name = "cupo_actual")
	private int cupoActual;
	@Column(name = "id_propietario")
	private int idPropietario;
	@Column(name = "loc_x")
	private double locX;
	@Column(name = "loc_y")
	private double locY;
	
	public int getIdParqueadero() {
		return idParqueadero;
	}
	public void setIdParqueadero(int idParqueadero) {
		this.idParqueadero = idParqueadero;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getCupoTotal() {
		return cupoTotal;
	}
	public void setCupoTotal(int cupoTotal) {
		this.cupoTotal = cupoTotal;
	}
	public int getCupoActual() {
		return cupoActual;
	}
	public void setCupoActual(int cupoActual) {
		this.cupoActual = cupoActual;
	}
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}
	public double getLocX() {
		return locX;
	}
	public void setLocX(double locX) {
		this.locX = locX;
	}
	public double getLocY() {
		return locY;
	}
	public void setLocY(double locY) {
		this.locY = locY;
	}

}
