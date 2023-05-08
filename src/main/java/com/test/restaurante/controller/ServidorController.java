package com.test.restaurante.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.restaurante.dao.PromocionesDao;
import com.test.restaurante.entity.Cliente;
import com.test.restaurante.entity.Empleados;
import com.test.restaurante.entity.Facturas;
import com.test.restaurante.entity.Ingredientes;
import com.test.restaurante.entity.Menu;
import com.test.restaurante.entity.Orden;
import com.test.restaurante.entity.Proveedores;
import com.test.restaurante.entity.Reservas;
import com.test.restaurante.entity.Valoraciones;
import com.test.restaurante.entity.promociones;
import com.test.restaurante.service.ServidorServices;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class ServidorController {
	@Autowired
	ServidorServices servidorServices;

	@GetMapping("/proveedores")
	public List<Proveedores> getProveedores() {
		return servidorServices.obtenertodos();
	}

	@GetMapping("/ingredientes")
	public List<Ingredientes> getIngredientes() {
		return servidorServices.obtenerIngresientes();
	}

	@GetMapping("/promociones")
	public List<promociones> getpromociones() {
		return servidorServices.obtenerPromociones();
	}

	@GetMapping("/clientes")
	public List<Cliente> getCleintes() {
		return servidorServices.obtenerClientes();
	}

	@GetMapping("/reservas")
	public List<Reservas> getReservas() {
		return servidorServices.obtenerReservas();
	}

	@GetMapping("/facturas")
	public List<Facturas> getFacturas() {
		return servidorServices.obtenerFacturas();
	}

	@GetMapping("/menus")
	public List<Menu> getMenus() {
		return servidorServices.obtenerMenus();
	}

	@GetMapping("/valoraciones")
	public List<Valoraciones> getValoraciones() {
		return servidorServices.obtenerValoraciones();
	}

	@GetMapping("/empleados")
	public List<Empleados> getEmpleados() {
		return servidorServices.obtenerEmpleados();
	}

	@GetMapping("/ordenes")
	public List<Orden> getOrdenes() {
		return servidorServices.obtenerOrdenes();
	}
	
	//GUARDAR

	@PostMapping("/promocion")
	public ResponseEntity<?> crearPromociones(@RequestBody promociones promocion, BindingResult result)
			throws Exception {
		promociones promocionNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			promocion.setDescripcion(promocion.getDescripcion());
			promocion.setPorcentaje_descuento(promocion.getPorcentaje_descuento());
			promocion.setFecha_inicio(promocion.getFecha_inicio());
			promocion.setFecha_fin(promocion.getFecha_fin());

			promocionNew = servidorServices.crearPromociones(promocion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Ocurrio un error en el sistema");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(promocionNew);
	}

	@PostMapping("/proveedor")
	public ResponseEntity<Proveedores> guardarProveedores(@RequestBody Proveedores proveedores) {

		Proveedores saveProveedores = servidorServices.crearProveedores(proveedores);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProveedores);
	}

	@PostMapping("/ingrediente")
	public ResponseEntity<Ingredientes> guardarIngredientes(@RequestBody Ingredientes ingredientes,
			Proveedores proveedores) {

		Ingredientes saveIngredientes = servidorServices.crearIngredientes(ingredientes);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveIngredientes);
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> guardarClientes(@RequestBody Cliente cliente) {

		Cliente saveClientes = servidorServices.crearClientes(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveClientes);
	}
	
	@PostMapping("/reserva")
	public ResponseEntity<Reservas> guardarReservas(@RequestBody Reservas reservas) {

		Reservas saveReservas = servidorServices.crearReservas(reservas);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveReservas);
	}
	
	@PostMapping("/factura")
	public ResponseEntity<Facturas> guardarFacturas(@RequestBody Facturas facturas) {

		Facturas saveFacturas = servidorServices.crearFacturas(facturas);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveFacturas);
	}
	
	@PostMapping("/menu")
	public ResponseEntity<Menu> guardarFacturas(@RequestBody Menu menu) {

		Menu saveMenu = servidorServices.crearMenus(menu);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveMenu);
	}
	
	@PostMapping("/empleado")
	public ResponseEntity<Empleados> guardarEmpleados(@RequestBody Empleados empleados) {

		Empleados saveEmpleados = servidorServices.crearEmpleados(empleados);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEmpleados);
	}
	
	@PostMapping("/valoracion")
	public ResponseEntity<Valoraciones> guardarValoraciones(@RequestBody Valoraciones valoraciones) {

		Valoraciones saveValoraciones = servidorServices.crearValoraciones(valoraciones);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveValoraciones);
	}
	
	@PostMapping("/orden")
	public ResponseEntity<Orden> guardarOrdenes(@RequestBody Orden orden) {

		Orden saveOrden = servidorServices.crearOrdenes(orden);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveOrden);
	}

	
	// Actualizar

	@PutMapping("/promocion/{id}")
	public ResponseEntity<?> actualizarPromocion(@PathVariable Long id, @RequestBody promociones promocion,
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();

			
		var verificarId = servidorServices.verificarExistenciaPorId(id);
		if(verificarId != true) {
			response.put("mensaje", "Error: no se pudo editar, la promocion ID: "
					.concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		

		promociones promo = new promociones();
		try {
			promo = servidorServices.actualizarPromociones(id, promocion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la promocion en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La promocion se ha modificado con éxito");
		response.put("Promocion", promo);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	// ELIMINAR

	@DeleteMapping("/promocion/{id_promociones}")
	public ResponseEntity<?> eliminarPersona(@PathVariable Long id_promociones) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarPromocion(id_promociones);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, la promocion ID: "
					.concat(id_promociones + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "La promocion se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
