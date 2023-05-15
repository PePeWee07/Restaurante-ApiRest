package com.test.restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.restaurante.dao.ClienteDao;
import com.test.restaurante.dao.EmpleadosDao;
import com.test.restaurante.dao.FacturasDao;
import com.test.restaurante.dao.IngredientesDao;
import com.test.restaurante.dao.MenuDao;
import com.test.restaurante.dao.OrdenesDao;
import com.test.restaurante.dao.PromocionesDao;
import com.test.restaurante.dao.ProveedoresDao;
import com.test.restaurante.dao.ReservasDao;
import com.test.restaurante.dao.ValoracionesDao;
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

@Service
public class ServidorServiceImpl implements ServidorServices {

	@Autowired
	ProveedoresDao proveedorDAO;

	@Autowired
	IngredientesDao ingredientesDao;

	@Autowired
	PromocionesDao promocionesDao;

	@Autowired
	ClienteDao clienteDao;

	@Autowired
	ReservasDao reservasDao;

	@Autowired
	FacturasDao facturasDao;

	@Autowired
	MenuDao menuDao;

	@Autowired
	ValoracionesDao valoracionesDao;

	@Autowired
	EmpleadosDao empleadosDao;

	@Autowired
	OrdenesDao ordenesDao;

	@Override
	public List<Proveedores> obtenertodos() {
		// TODO Auto-generated method stub
		return proveedorDAO.findAll();
	}

	@Override
	public List<Ingredientes> obtenerIngresientes() {
		// TODO Auto-generated method stub
		return ingredientesDao.findAll();
	}

	@Override
	public List<promociones> obtenerPromociones() {
		return promocionesDao.findAll();
	}

	@Override
	public List<Cliente> obtenerClientes() {
		return clienteDao.findAll();
	}

	@Override
	public List<Reservas> obtenerReservas() {
		return reservasDao.findAll();
	}

	@Override
	public List<Facturas> obtenerFacturas() {
		return facturasDao.findAll();
	}

	@Override
	public List<Menu> obtenerMenus() {
		return menuDao.findAll();
	}

	@Override
	public List<Valoraciones> obtenerValoraciones() {
		return valoracionesDao.findAll();
	}

	@Override
	public List<Empleados> obtenerEmpleados() {
		return empleadosDao.findAll();
	}

	@Override
	public List<Orden> obtenerOrdenes() {
		return ordenesDao.findAll();
	}

	// GUARDAR

	@Override
	public promociones crearPromociones(promociones promocion) {
		return promocionesDao.save(promocion);
	}

	@Override
	public Proveedores crearProveedores(Proveedores proveedores) {
		return proveedorDAO.save(proveedores);
	}

	@Override
	public Ingredientes crearIngredientes(Ingredientes ingredientes) {
		return ingredientesDao.save(ingredientes);
	}
	
	@Override
	public Cliente crearClientes(Cliente cliente) {
		return clienteDao.save(cliente);
	}
	
	@Override
	public Reservas crearReservas(Reservas reservas) {
		return reservasDao.save(reservas);
	}
	
	@Override
	public Facturas crearFacturas(Facturas facturas) {
		return facturasDao.save(facturas);
	}
	
	@Override
	public Menu crearMenus(Menu menu) {
		return menuDao.save(menu);
	}
	
	@Override
	public Empleados crearEmpleados(Empleados empleados) {
		return empleadosDao.save(empleados);
	}
	
	@Override
	public Valoraciones crearValoraciones(Valoraciones valoraciones) {
		return valoracionesDao.save(valoraciones);
	}
	
	@Override
	public Orden crearOrdenes(Orden orden) {
		return ordenesDao.save(orden);
	}

	
	
	// ACTUALIZAR
	@Override
	public promociones actualizarPromociones(Long id_promocion, promociones promocion) {
		promocion.setId_promocion(id_promocion);
		return promocionesDao.save(promocion);
	}
	
	@Override
	public Proveedores actualizarProveedores(Long id_proveedores, Proveedores proveedores) {
		proveedores.setId_proveedor(id_proveedores);
		return proveedorDAO.save(proveedores);
	}
	
	@Override
	public Ingredientes actualizarIngredientes(Ingredientes ingredientes) {		
		return ingredientesDao.save(ingredientes);
	}
	
	@Override
	public Cliente actualizarClientes(Long id_cliente, Cliente cliente) {
		cliente.setId_cliente(id_cliente);
		return clienteDao.save(cliente);
	}
	
	@Override
	public Facturas actualizarFacturas(Facturas facturas) {		
		return facturasDao.save(facturas);
	}
	
	@Override
	public Reservas actualizarReservas(Reservas reservas) {		
		return reservasDao.save(reservas);
	}
	
	@Override
	public Menu actualizarMenus(Long id_menu, Menu menu) {
		menu.setId_menu(id_menu);
		return menuDao.save(menu);
	}
	
	@Override
	public Empleados actualizarEmpleados(Long id_empleado, Empleados empleados) {
		empleados.setId_empleado(id_empleado);
		return empleadosDao.save(empleados);
	}
	
	@Override
	public Orden actualizarOrdenes(Orden orden) {
		return ordenesDao.save(orden);
	}
	
	
 
	// ELIMINAR
	@Override
	public void eliminarPromociones(Long id_promociones) {
		promocionesDao.deleteById(id_promociones);
	}
	@Override
	public void eliminarProveedores(Long id_proveedor) {
		proveedorDAO.deleteById(id_proveedor);
	}
	@Override
	public void eliminarIngredientes(Long id_ingrediente) {
		ingredientesDao.deleteById(id_ingrediente);
	}
	
	
	@Override
	public void eliminarClientes(Long id_cliente) {
		clienteDao.deleteById(id_cliente);
	}
	@Override
	public void eliminarReservas(Long id_reserva) {
		reservasDao.deleteById(id_reserva);
	}
	@Override
	public void eliminarFacturas(Long id_factura) {
		facturasDao.deleteById(id_factura);
	}
	@Override
	public void elimnarMenus(Long id_menu) {
		menuDao.deleteById(id_menu);
	}
	@Override
	public void elimianrEmpleados(Long id_empleado) {
		empleadosDao.deleteById(id_empleado);
	}
	@Override
	public void eliminarOrden(Long id_orden) {
		ordenesDao.deleteById(id_orden);
	}
	@Override
	public void eliminarValoraciones(Long id_valoracion) {
		valoracionesDao.deleteById(id_valoracion);
	}
	
	

	
	// VERIFICACION POR ID
	@Override
	public boolean verificarIdPromocion(Long id) {
		return promocionesDao.findById(id).isPresent();
	}
	@Override
	public boolean verificarIdProveedor(Long id) {
		return proveedorDAO.findById(id).isPresent();
	}
	@Override
	public boolean verificarIdCliente(Long id) {
		return clienteDao.findById(id).isPresent();
	}
	@Override
	public boolean verificarIdMenu(Long id) {
		return menuDao.findById(id).isPresent();
	}
	@Override
	public boolean verificarIdEmpleado(Long id) {
		return empleadosDao.findById(id).isPresent();
	}

}
