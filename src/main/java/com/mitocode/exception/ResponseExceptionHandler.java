package com.mitocode.exception;

import java.util.Date;

import javax.naming.AuthenticationException;

import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.gson.Gson;

@ControllerAdvice // simula Inteceptor , lo convierte en transversal a todas las capas del
					// proyecto
@RestController // para exponer respuesta como rpta de un servicio rest
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ResponseExceptionHandler.class);

	@ExceptionHandler(ExceptionResponse.class) // 500
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public final ExceptionResponse handleException(ExceptionResponse ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMensaje(), ex.getDetalles(),
				ex.getJsonSender());

		exceptionResponse.setStackTrace(new StackTraceElement[0]);
		exceptionResponse.setTypeException(ex.getStackTrace()[0].getClassName());
		exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setError("¡OCURRIO UN ERROR INTERNO EN EL SERVIDOR!");
		String json = null;
		try {
			if (ex.getJsonSender() != null) {
				Gson gson = new Gson();
				json = gson.toJson(ex.getJsonSender());
			}else {
				json="No tiene variables de entrada";
			}
		} catch (Exception e) {
			LOG.error(ex.getMensaje(), new RuntimeException(ex.getDetalles()));
			return exceptionResponse;
		}
		LOG.error(ex.getMensaje() + " -- jsonSender:" + json, ex.getDetalles());
		return exceptionResponse;
		// return new ResponseEntity<ExceptionResponse>(exceptionResponse,
		// HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
		exceptionResponse.setStackTrace(new StackTraceElement[0]);
		exceptionResponse.setTypeException(ex.getStackTrace()[0].getClassName());
		exceptionResponse.setCode(status.value());
		exceptionResponse.setError(status.name());

		return new ResponseEntity<Object>(exceptionResponse, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {// 400
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
		exceptionResponse.setDetalles("Error al hacer una solicitud a la ruta: " + request.getDescription(false));
		exceptionResponse.setStackTrace(new StackTraceElement[0]);
		exceptionResponse.setTypeException(ex.getStackTrace()[0].getClassName());
		exceptionResponse.setCode(status.value());
		exceptionResponse.setError(status.name());

		LOG.error(exceptionResponse.getMensaje(), exceptionResponse.getDetalles());

		return new ResponseEntity<Object>(exceptionResponse, headers, status);

	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {// 405
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
		exceptionResponse.setDetalles("Error al hacer una solicitud a la ruta: " + request.getDescription(false));
		exceptionResponse.setStackTrace(new StackTraceElement[0]);
		exceptionResponse.setTypeException(ex.getStackTrace()[0].getClassName());
		exceptionResponse.setCode(status.value());
		exceptionResponse.setError(status.name());

		LOG.error(exceptionResponse.getMensaje(), exceptionResponse.getDetalles());

		return new ResponseEntity<Object>(exceptionResponse, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {// 415
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
		exceptionResponse.setDetalles("Error al hacer una solicitud a la ruta: " + request.getDescription(false));
		exceptionResponse.setStackTrace(new StackTraceElement[0]);
		exceptionResponse.setTypeException(ex.getStackTrace()[0].getClassName());
		exceptionResponse.setCode(status.value());
		exceptionResponse.setError(status.name());

		LOG.error(exceptionResponse.getMensaje(), exceptionResponse.getDetalles());

		return new ResponseEntity<Object>(exceptionResponse, headers, status);
	}

}
