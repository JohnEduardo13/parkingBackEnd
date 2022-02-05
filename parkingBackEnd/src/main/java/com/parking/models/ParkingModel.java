package com.parking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking")
public class ParkingModel {
	
	@Id
	@Column(name = "id_parking")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idParking;
	@Column(name = "placa_vehiculo")
	private String placaVehiculo;
	@Column(name = "id_usuario")
	private int idUsuario;
	@Column(name = "id_parqueadero")
	private int idParqueadero;
	@Column(name = "fecha_parking")
	private String fechaParking;
	@Column(name = "hora_ingreso")
	private String horaIngreso;
	@Column(name = "hora_salida")
	private String horaSalida;
	
	public int getIdParking() {
		return idParking;
	}
	public void setIdParking(int idParking) {
		this.idParking = idParking;
	}
	public String getPlacaVehiculo() {
		return placaVehiculo;
	}
	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdParqueadero() {
		return idParqueadero;
	}
	public void setIdParqueadero(int idParqueadero) {
		this.idParqueadero = idParqueadero;
	}
	public String getFechaParking() {
		return fechaParking;
	}
	public void setFechaParking(String fechaParking) {
		this.fechaParking = fechaParking;
	}
	public String getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

}
