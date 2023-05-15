package com.test.restaurante.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import com.test.restaurante.dao.ClienteDao;
import com.test.restaurante.dao.EmpleadosDao;
import com.test.restaurante.dao.FacturasDao;
import com.test.restaurante.dao.IngredientesDao;
import com.test.restaurante.dao.MenuDao;
import com.test.restaurante.dao.OrdenesDao;
import com.test.restaurante.dao.PromocionesDao;
import com.test.restaurante.dao.ProveedoresDao;
import com.test.restaurante.dao.ReservasDao;
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

	
	// GUARDAR

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
	public ResponseEntity<?> guardarProveedores(@RequestBody Proveedores proveedores, BindingResult result)
			throws Exception {
		Proveedores proveedorNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			proveedores.setNombre_proveedor(proveedores.getNombre_proveedor());
			proveedores.setDireccion(proveedores.getDireccion());
			proveedores.setTelefono(proveedores.getTelefono());
			proveedores.setCorreo_electronico(proveedores.getCorreo_electronico());
			proveedores.setProductos(proveedores.getProductos());

			proveedorNew = servidorServices.crearProveedores(proveedores);
		} catch (DataAccessException e) {
			response.put("mensaje", "Ocurrio un error en el sistema");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorNew);

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

		var verificarId = servidorServices.verificarIdPromocion(id);
		if (verificarId != true) {
			response.put("mensaje",
					"Error: no se pudo editar, la promocion ID: ".concat(id + " no existe en la base de datos!"));
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

	@PutMapping("/proveedor/{id}")
	public ResponseEntity<?> actualizarProveedores(@PathVariable Long id, @RequestBody Proveedores proveedores,
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		var verificarId = servidorServices.verificarIdProveedor(id);
		if (verificarId != true) {
			response.put("mensaje",
					"Error: no se pudo editar, el proveedor ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Proveedores proveedor = new Proveedores();
		try {
			proveedor = servidorServices.actualizarProveedores(id, proveedores);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el proveedor en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El proveedor se ha modificado con éxito");
		response.put("Proveedor", proveedor);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Autowired
	IngredientesDao ingredientesDao;
	@Autowired
	ProveedoresDao proveedorDAO;

	@PutMapping("/ingrediente/{id}")
	public ResponseEntity<?> actualizarIngredientes(@PathVariable Long id, @RequestBody Ingredientes ingredientes,
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		Optional<Ingredientes> obtenerIngrediente = ingredientesDao.findById(id);
		var verificarId = proveedorDAO.findById(ingredientes.getProveedores().getId_proveedor()).isPresent();

		if (obtenerIngrediente.isPresent() != true) {
			response.put("mensaje",
					"Error: no se pudo editar, el ingrediente ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} else if (verificarId != true) {
			response.put("mensaje", "Error: no se pudo editar, el id del provedor no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Ingredientes ingredienteActualizados = new Ingredientes();
		try {
			Ingredientes ingrediente = obtenerIngrediente.get();
			Proveedores proveedor = proveedorDAO.findById(ingredientes.getProveedores().getId_proveedor())
					.orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado"));

			ingrediente.setNombre_ingrediente(ingredientes.getNombre_ingrediente());
			ingrediente.setCantidad_disponible(ingredientes.getCantidad_disponible());
			ingrediente.setFecha_caducidad(ingredientes.getFecha_caducidad());
			ingrediente.setProveedores(proveedor);

			ingredienteActualizados = servidorServices.actualizarIngredientes(ingrediente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el Ingrediente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El ingrediente se ha modificado con éxito");
		response.put("Ingrediente", ingredienteActualizados);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/cliente/{id}")
	public ResponseEntity<?> actualizarClientes(@PathVariable Long id, @RequestBody Cliente cliente,
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		var verificarId = servidorServices.verificarIdCliente(id);
		if (verificarId != true) {
			response.put("mensaje",
					"Error: no se pudo editar, el cliente ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Cliente clientes = new Cliente();
		try {
			clientes = servidorServices.actualizarClientes(id, cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente se ha modificado con éxito");
		response.put("Cliente", clientes);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Autowired
	ClienteDao clienteDao;

	@Autowired
	FacturasDao facturasDao;

	@PutMapping("/factura/{id}")
	public ResponseEntity<?> actualizarFacturas(@PathVariable Long id, @RequestBody Facturas facturas,
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		Optional<Facturas> obtenerID = facturasDao.findById(id);
		var verificarId = clienteDao.findById(facturas.getCliente().getId_cliente()).isPresent();

		if (obtenerID.isPresent() != true) {
			response.put("mensaje",
					"Error: no se pudo editar, La factura ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} else if (verificarId != true) {
			response.put("mensaje", "Error: no se pudo editar, el id del cliente no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Facturas facturasActualizados = new Facturas();
		try {
			Facturas factura = obtenerID.get();
			Cliente cliente = clienteDao.findById(facturas.getCliente().getId_cliente())
					.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

			factura.setNum_mesa(facturas.getNum_mesa());
			factura.setFecha_transaccion(facturas.getFecha_transaccion());
			factura.setMetodo_pago(facturas.getMetodo_pago());
			factura.setTotal(facturas.getTotal());
			factura.setCliente(cliente);

			facturasActualizados = servidorServices.actualizarFacturas(factura);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la factura en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La factura se ha modificado con éxito");
		response.put("Factura", facturasActualizados);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Autowired
	ReservasDao reservasDao;

	@PutMapping("/reserva/{id}")
	public ResponseEntity<?> actualizarReserva(@PathVariable Long id, @RequestBody Reservas reservas,
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		Optional<Reservas> obtenerID = reservasDao.findById(id);
		var verificarId = clienteDao.findById(reservas.getCliente().getId_cliente()).isPresent();

		if (obtenerID.isPresent() != true) {
			response.put("mensaje",
					"Error: no se pudo editar, La reserva ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} else if (verificarId != true) {
			response.put("mensaje", "Error: no se pudo editar, el id del cliente no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Reservas reservasActualizados = new Reservas();
		try {
			Reservas reserva = obtenerID.get();
			Cliente cliente = clienteDao.findById(reservas.getCliente().getId_cliente())
					.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

			reserva.setNum_mesa(reservas.getNum_mesa());
			reserva.setFecha_reserva(reservas.getFecha_reserva());
			reserva.setHora_reserva(reservas.getHora_reserva());
			reserva.setTelefono_cliente(reservas.getTelefono_cliente());
			reserva.setCliente(cliente);

			reservasActualizados = servidorServices.actualizarReservas(reserva);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la reserva en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La reserva se ha modificado con éxito");
		response.put("Reserva", reservasActualizados);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/menu/{id}")
	public ResponseEntity<?> actualizarMenus(@PathVariable Long id, @RequestBody Menu menu, BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		var verificarId = servidorServices.verificarIdMenu(id);
		if (verificarId != true) {
			response.put("mensaje",
					"Error: no se pudo editar, el menu ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Menu menus = new Menu();
		try {
			menus = servidorServices.actualizarMenus(id, menu);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el menu en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El menu se ha modificado con éxito");
		response.put("Menu", menus);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/empleado/{id}")
	public ResponseEntity<?> actualizarMenus(@PathVariable Long id, @RequestBody Empleados empleados,
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		var verificarId = servidorServices.verificarIdEmpleado(id);
		if (verificarId != true) {
			response.put("mensaje",
					"Error: no se pudo editar, el empleado ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Empleados empleado = new Empleados();
		try {
			empleado = servidorServices.actualizarEmpleados(id, empleados);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar empleado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El empleado se ha modificado con éxito");
		response.put("Empleado", empleado);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Autowired
	EmpleadosDao empleadosDao;

	@Autowired
	OrdenesDao ordenesDao;

	@Autowired
	MenuDao menuDao;

	@PutMapping("/orden/{id}")
	public ResponseEntity<?> actualizarReserva(@PathVariable Long id, @RequestBody Orden orden, BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		Optional<Orden> obtenerID = ordenesDao.findById(id);
		var verificarIdMenu = menuDao.findById(orden.getMenu().getId_menu()).isPresent();
		var verificarIdCliente = clienteDao.findById(orden.getCliente().getId_cliente()).isPresent();
		var verificarIdEmpleado = empleadosDao.findById(orden.getEmpleado().getId_empleado()).isPresent();

		if (obtenerID.isPresent() != true) {
			response.put("mensaje",
					"Error: no se pudo editar, La orden ID: ".concat(id + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} else if (verificarIdMenu != true) {
			response.put("mensaje", "Error: no se pudo editar, el id del menu no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} else if (verificarIdCliente != true) {
			response.put("mensaje", "Error: no se pudo editar, el id del cliente no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} else if (verificarIdEmpleado != true) {
			response.put("mensaje", "Error: no se pudo editar, el id del empleado no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		Orden ordenActualizados = new Orden();
		try {
			Orden ordenes = obtenerID.get();
			Menu menus = menuDao.findById(orden.getMenu().getId_menu())
					.orElseThrow(() -> new IllegalArgumentException("Menu no encontrado"));
			Cliente cliente = clienteDao.findById(orden.getCliente().getId_cliente())
					.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
			Empleados empleado = empleadosDao.findById(orden.getEmpleado().getId_empleado())
					.orElseThrow(() -> new IllegalArgumentException("Empleado no econtrado"));

			ordenes.setNum_mesa(orden.getNum_mesa());
			ordenes.setFecha_pedido(orden.getFecha_pedido());
			ordenes.setCantidad(orden.getCantidad());
			ordenes.setMenu(menus);
			ordenes.setCliente(cliente);
			ordenes.setEmpleado(empleado);

			ordenActualizados = servidorServices.actualizarOrdenes(ordenes);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la orden en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La orden se ha modificado con éxito");
		response.put("Orden", ordenActualizados);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	
	// ELIMINAR

	@DeleteMapping("/promocion/{id_promociones}")
	public ResponseEntity<?> eliminarPromociones(@PathVariable Long id_promociones) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarPromociones(id_promociones);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, la promocion ID: "
					.concat(id_promociones + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "La promocion se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/proveedor/{id_proveedor}")
	public ResponseEntity<?> eliminarProveedores(@PathVariable Long id_proveedor) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarProveedores(id_proveedor);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, el proveedir ID: "
					.concat(id_proveedor + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "El proveedor se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/ingrediente/{id_ingrediente}")
	public ResponseEntity<?> eliminarIngredientes(@PathVariable Long id_ingrediente) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarIngredientes(id_ingrediente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, el ingrediente ID: "
					.concat(id_ingrediente + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "El ingrediente se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/cliente/{id_cliente}")
	public ResponseEntity<?> eliminarClientes(@PathVariable Long id_cliente) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarClientes(id_cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, el cliente ID: "
					.concat(id_cliente + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "El cliente se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/reserva/{id_reserva}")
	public ResponseEntity<?> eliminarReservas(@PathVariable Long id_reserva) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarReservas(id_reserva);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, la reserva ID: "
					.concat(id_reserva + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "La reserva se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/factura/{id_factura}")
	public ResponseEntity<?> eliminarFacturas(@PathVariable Long id_factura) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarFacturas(id_factura);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, la factura ID: "
					.concat(id_factura + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "La factura se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/menu/{id_menu}")
	public ResponseEntity<?> elimnarMenus(@PathVariable Long id_menu) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.elimnarMenus(id_menu);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, el menu ID: "
					.concat(id_menu + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "El menu se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/empleado/{id_empleado}")
	public ResponseEntity<?> elimianrEmpleados(@PathVariable Long id_empleado) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.elimianrEmpleados(id_empleado);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, el empleado ID: "
					.concat(id_empleado + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "El empleado se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/orden/{id_orden}")
	public ResponseEntity<?> eliminarOrden(@PathVariable Long id_orden) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarOrden(id_orden);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, la orden ID: "
					.concat(id_orden + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "La orden se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/valoracion/{id_valoracion}")
	public ResponseEntity<?> eliminarValoraciones(@PathVariable Long id_valoracion) {

		Map<String, Object> response = new HashMap<>();
		try {
			servidorServices.eliminarValoraciones(id_valoracion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: no se pudo eliminar, la valoracion ID: "
					.concat(id_valoracion + " no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "La valoracion se ha eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
