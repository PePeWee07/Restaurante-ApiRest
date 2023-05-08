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
	
	//Guardar 
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
	
	//Actualizar
	promociones actualizarPromociones(Long id_promocion,promociones promocion);
	
	//ELIMINAR
	public void eliminarPromocion(Long id_promociones);
	
	//Verificaicon si existe ID
	boolean verificarExistenciaPorId(Long id); 
	
	

}
