package com.mitocode.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
// clase pojo : solo get- set 
public class ExceptionResponse extends Exception{
	
	private Date timestamp;
	private String mensaje;
	private String detalles;
	private Object jsonSender;
	private String linea_nro;
	private String typeException;
	
	//httpsStatus
	private Integer code;
	private String error;
	
	public ExceptionResponse() {
	}
	public ExceptionResponse(Date timestamp, String mensaje, String detalles, Object jsonSender) {
 		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
		this.jsonSender = jsonSender;
	}
	public ExceptionResponse(Date timestamp, String mensaje) {
 		this.timestamp = timestamp;
		this.mensaje = mensaje;
	}
	
	public String getLinea_nro() {
		return linea_nro;
	}
	public void setLinea_nro(String linea_nro) {
		this.linea_nro = linea_nro;
	}
	
	
	public Object getJsonSender() {
		return jsonSender;
	}
	public void setJsonSender(Object jsonSender) {
		this.jsonSender = jsonSender;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getTypeException() {
		return typeException;
	}
	public void setTypeException(String typeException) {
		this.typeException = typeException;
	}

	
}
