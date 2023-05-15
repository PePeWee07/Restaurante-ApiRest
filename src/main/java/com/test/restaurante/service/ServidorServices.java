package com.test.restaurante.service;

import java.util.List;

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

public interface ServidorServices {
	
	//OBTENER
	List<Proveedores> obtenertodos();
	List<Ingredientes> obtenerIngresientes();
	List<promociones> obtenerPromociones();
	List<Cliente> obtenerClientes();
	List<Reservas> obtenerReservas();
	List<Facturas> obtenerFacturas();
	List<Menu> obtenerMenus();
	List<Valoraciones> obtenerValoraciones();
	List<Empleados> obtenerEmpleados();
	List<Orden> obtenerOrdenes();
	
	//GUARDAR 
	promociones crearPromociones(promociones promocion);
	Proveedores crearProveedores(Proveedores proveedores);
	Ingredientes crearIngredientes(Ingredientes ingredientes);
	Cliente crearClientes(Cliente cliente);
	Reservas crearReservas(Reservas reservas);
	Facturas crearFacturas(Facturas facturas);
	Menu crearMenus(Menu menu);
	Empleados crearEmpleados(Empleados empleados);
	Valoraciones crearValoraciones(Valoraciones valoraciones);
	Orden crearOrdenes(Orden orden);
	
	//ACTUALIZAR
	promociones actualizarPromociones(Long id_promocion,promociones promocion);
	Proveedores actualizarProveedores(Long id_proveedor, Proveedores proveedores);
	Ingredientes actualizarIngredientes(Ingredientes ingredientes);
	Cliente actualizarClientes(Long id_cliente, Cliente cliente);
	Facturas actualizarFacturas(Facturas facturas);	
	Reservas actualizarReservas(Reservas reservas);
	Menu actualizarMenus(Long id_menu, Menu menu);
	Empleados actualizarEmpleados(Long id_empleado, Empleados empleados);
	Orden actualizarOrdenes(Orden orden);
	
	//ELIMINAR
	public void eliminarPromociones(Long id_promociones);
	public void eliminarProveedores(Long id_proveedor);
	public void eliminarIngredientes(Long id_ingredinte);
	public void eliminarClientes(Long id_cliente);
	public void eliminarReservas(Long id_reserva);
	public void eliminarFacturas(Long id_factura);
	public void elimnarMenus(Long id_menu);
	public void elimianrEmpleados(Long id_empleado);
	public void eliminarOrden(Long id_orden);
	public void eliminarValoraciones(Long id_valoracion);
	
	//VERIFICACION DE ID
	boolean verificarIdPromocion(Long id);
	boolean verificarIdProveedor(Long id);
	boolean verificarIdCliente(Long id);
	boolean verificarIdMenu(Long id);
	boolean verificarIdEmpleado(Long id);
	

	

}
