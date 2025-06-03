package com.cliente.main;

import com.cliente.ventas.VentaServicio;
import com.cliente.ventas.VentaServicioService;
import com.cliente.ventas.Producto;
import com.cliente.ventas.Venta;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class ClienteGUI extends JFrame {
    private VentaServicio port;
    private JTable tablaProductos;
    private JTable tablaVentas;
    private DefaultTableModel modeloProductos;
    private DefaultTableModel modeloVentas;
    private JTextField txtProducto;
    private JSpinner spinnerCantidad;
    private JTextArea txtResultado;
    private JTextArea txtEstadisticas;
    private JLabel lblEstado;
    private JLabel lblTotalVentas;
    private JComboBox<String> comboCategoria;
    private JComboBox<String> comboFiltroStock;
    private JTextField txtBusqueda;
    private TableRowSorter<DefaultTableModel> sorter;
    
    public ClienteGUI() {
        super("🛒 Sistema de Ventas SOAP - Versión Mejorada");
        inicializarServicio();
        inicializarInterfaz();
        cargarDatos();
    }
    
    private void inicializarServicio() {
        try {
            VentaServicioService servicio = new VentaServicioService();
            port = servicio.getVentaServicioPort();
            System.out.println("✅ Conexión al servicio establecida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al conectar con el servicio SOAP:\n" + e.getMessage() + 
                "\n\nAsegúrate de que el servidor esté ejecutándose en el puerto 9090",
                "Error de Conexión", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void inicializarInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel superior - Estado de conexión
        JPanel panelEstado = crearPanelEstado();
        add(panelEstado, BorderLayout.NORTH);
        
        // Panel central - Pestañas principales
        JTabbedPane pestanas = new JTabbedPane();
        pestanas.addTab("📦 Inventario", crearPanelInventario());
        pestanas.addTab("💰 Ventas", crearPanelVentas());
        pestanas.addTab("📊 Historial", crearPanelHistorial());
        pestanas.addTab("📈 Estadísticas", crearPanelEstadisticas());
        pestanas.addTab("🔧 Gestión", crearPanelGestion());
        add(pestanas, BorderLayout.CENTER);
        
        // Panel inferior - Total y controles
        JPanel panelInferior = crearPanelInferior();
        add(panelInferior, BorderLayout.SOUTH);
        
        // Configuración de la ventana
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private JPanel crearPanelEstado() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(46, 125, 50));
        
        lblEstado = new JLabel("🔌 Estado: Conectado al servicio SOAP");
        lblEstado.setForeground(Color.WHITE);
        lblEstado.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(lblEstado);
        
        return panel;
    }
    
    private JPanel crearPanelInventario() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Gestión de Inventario"));
        
        // Panel de filtros
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFiltros.setBorder(BorderFactory.createTitledBorder("Filtros"));
        
        // Filtro por categoría
        panelFiltros.add(new JLabel("Categoría:"));
        comboCategoria = new JComboBox<>();
        comboCategoria.addActionListener(e -> filtrarProductos());
        panelFiltros.add(comboCategoria);
        
        // Filtro por stock
        panelFiltros.add(new JLabel("Estado Stock:"));
        comboFiltroStock = new JComboBox<>(new String[]{"Todos", "Disponibles", "Agotados", "Bajo Stock"});
        comboFiltroStock.addActionListener(e -> filtrarProductos());
        panelFiltros.add(comboFiltroStock);
        
        // Búsqueda
        panelFiltros.add(new JLabel("Buscar:"));
        txtBusqueda = new JTextField(15);
        txtBusqueda.addActionListener(e -> filtrarProductos());
        panelFiltros.add(txtBusqueda);
        
        JButton btnBuscar = new JButton("🔍");
        btnBuscar.addActionListener(e -> filtrarProductos());
        panelFiltros.add(btnBuscar);
        
        panel.add(panelFiltros, BorderLayout.NORTH);
        
        // Tabla de productos mejorada
        String[] columnasProductos = {"Producto", "Precio", "Stock", "Categoría", "Estado"};
        modeloProductos = new DefaultTableModel(columnasProductos, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tablaProductos = new JTable(modeloProductos);
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Configurar colores de encabezado
        tablaProductos.getTableHeader().setBackground(new Color(63, 81, 181));
        tablaProductos.getTableHeader().setForeground(Color.WHITE);
        
        // Configurar ancho de columnas
        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(200); // Producto
        tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(100); // Precio
        tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(80);  // Stock
        tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(120); // Categoría
        tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(100); // Estado
        
        // Habilitar ordenamiento
        sorter = new TableRowSorter<>(modeloProductos);
        tablaProductos.setRowSorter(sorter);
        
        JScrollPane scrollProductos = new JScrollPane(tablaProductos);
        scrollProductos.setPreferredSize(new Dimension(0, 300));
        panel.add(scrollProductos, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnActualizar = new JButton("🔄 Actualizar");
        btnActualizar.addActionListener(e -> cargarProductos());
        
        JButton btnExportar = new JButton("📄 Exportar");
        btnExportar.addActionListener(e -> exportarInventario());
        
        panelBotones.add(btnActualizar);
        panelBotones.add(btnExportar);
        panel.add(panelBotones, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelVentas() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Panel izquierdo - Formulario de venta
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createTitledBorder("Registrar Nueva Venta"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Campo producto
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panelForm.add(new JLabel("🏷️ Producto:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtProducto = new JTextField(20);
        txtProducto.setToolTipText("Ingresa el nombre exacto del producto");
        panelForm.add(txtProducto, gbc);
        
        // Botón para seleccionar de la lista
        gbc.gridx = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        JButton btnSeleccionar = new JButton("📋 Seleccionar");
        btnSeleccionar.addActionListener(e -> seleccionarProducto());
        panelForm.add(btnSeleccionar, gbc);
        
        // Campo cantidad
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panelForm.add(new JLabel("🔢 Cantidad:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        panelForm.add(spinnerCantidad, gbc);
        
        // Información del producto
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblInfoProducto = new JLabel("💡 Selecciona un producto para ver su información");
        lblInfoProducto.setFont(new Font("Arial", Font.ITALIC, 12));
        panelForm.add(lblInfoProducto, gbc);
        
        // Botón registrar venta
        gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnRegistrarVenta = new JButton("💰 Registrar Venta");
        btnRegistrarVenta.setBackground(new Color(76, 175, 80));
        btnRegistrarVenta.setForeground(Color.WHITE);
        btnRegistrarVenta.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrarVenta.addActionListener(e -> registrarVenta());
        panelForm.add(btnRegistrarVenta, gbc);
        
        panel.add(panelForm, BorderLayout.WEST);
        
        // Panel derecho - Resultado de operaciones
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado de Operaciones"));
        
        txtResultado = new JTextArea(15, 30);
        txtResultado.setEditable(false);
        txtResultado.setBackground(new Color(248, 248, 248));
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollResultado = new JScrollPane(txtResultado);
        panelResultado.add(scrollResultado, BorderLayout.CENTER);
        
        // Botón limpiar resultado
        JButton btnLimpiar = new JButton("🗑️ Limpiar");
        btnLimpiar.addActionListener(e -> txtResultado.setText(""));
        panelResultado.add(btnLimpiar, BorderLayout.SOUTH);
        
        panel.add(panelResultado, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearPanelHistorial() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Historial de Ventas"));
        
        // Tabla de ventas
        String[] columnasVentas = {"#", "Producto", "Cantidad", "Total", "Fecha"};
        modeloVentas = new DefaultTableModel(columnasVentas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tablaVentas = new JTable(modeloVentas);
        tablaVentas.getTableHeader().setBackground(new Color(255, 152, 0));
        tablaVentas.getTableHeader().setForeground(Color.WHITE);
        
        // Configurar ancho de columnas
        tablaVentas.getColumnModel().getColumn(0).setPreferredWidth(50);  // #
        tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(200); // Producto
        tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(100); // Cantidad
        tablaVentas.getColumnModel().getColumn(3).setPreferredWidth(150); // Total
        tablaVentas.getColumnModel().getColumn(4).setPreferredWidth(150); // Fecha
        
        JScrollPane scrollVentas = new JScrollPane(tablaVentas);
        panel.add(scrollVentas, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnActualizarHistorial = new JButton("🔄 Actualizar");
        btnActualizarHistorial.addActionListener(e -> cargarHistorial());
        
        JButton btnExportarHistorial = new JButton("📄 Exportar");
        btnExportarHistorial.addActionListener(e -> exportarHistorial());
        
        panelBotones.add(btnActualizarHistorial);
        panelBotones.add(btnExportarHistorial);
        panel.add(panelBotones, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelEstadisticas() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Estadísticas del Sistema"));
        
        // Área de texto para estadísticas
        txtEstadisticas = new JTextArea(20, 40);
        txtEstadisticas.setEditable(false);
        txtEstadisticas.setBackground(new Color(248, 248, 248));
        txtEstadisticas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollEstadisticas = new JScrollPane(txtEstadisticas);
        panel.add(scrollEstadisticas, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnActualizarStats = new JButton("📊 Actualizar Estadísticas");
        btnActualizarStats.addActionListener(e -> cargarEstadisticas());
        
        JButton btnReporte = new JButton("📈 Generar Reporte");
        btnReporte.addActionListener(e -> generarReporte());
        
        panelBotones.add(btnActualizarStats);
        panelBotones.add(btnReporte);
        panel.add(panelBotones, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelGestion() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Gestión de Stock"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Consultar stock
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("🔍 Consultar Stock:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField txtConsultaStock = new JTextField(20);
        panel.add(txtConsultaStock, gbc);
        
        gbc.gridx = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        JButton btnConsultar = new JButton("🔍 Consultar");
        btnConsultar.addActionListener(e -> consultarStock(txtConsultaStock.getText().trim()));
        panel.add(btnConsultar, gbc);
        
        // Agregar stock
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("📦 Producto:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JTextField txtProductoStock = new JTextField(20);
        panel.add(txtProductoStock, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("➕ Cantidad:"), gbc);
        
        gbc.gridx = 1;
        JSpinner spinnerStock = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        panel.add(spinnerStock, gbc);
        
        gbc.gridx = 2; gbc.fill = GridBagConstraints.NONE;
        JButton btnAgregarStock = new JButton("📈 Agregar Stock");
        btnAgregarStock.addActionListener(e -> {
            String producto = txtProductoStock.getText().trim();
            int cantidad = (Integer) spinnerStock.getValue();
            agregarStock(producto, cantidad);
        });
        panel.add(btnAgregarStock, gbc);
        
        // Productos con bajo stock
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnBajoStock = new JButton("⚠️ Ver Productos con Bajo Stock");
        btnBajoStock.addActionListener(e -> mostrarProductosBajoStock());
        panel.add(btnBajoStock, gbc);
        
        // Productos agotados
        gbc.gridy = 4;
        JButton btnAgotados = new JButton("❌ Ver Productos Agotados");
        btnAgotados.addActionListener(e -> mostrarProductosAgotados());
        panel.add(btnAgotados, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelInferior() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());
        
        lblTotalVentas = new JLabel("💰 Total General: $0.00");
        lblTotalVentas.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalVentas.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panel.add(lblTotalVentas, BorderLayout.WEST);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnActualizarTodo = new JButton("🔄 Actualizar Todo");
        btnActualizarTodo.addActionListener(e -> cargarDatos());
        
        JButton btnAcerca = new JButton("ℹ️ Acerca de");
        btnAcerca.addActionListener(e -> mostrarAcercaDe());
        
        panelBotones.add(btnActualizarTodo);
        panelBotones.add(btnAcerca);
        panel.add(panelBotones, BorderLayout.EAST);
        
        return panel;
    }
    
    // Métodos de funcionalidad
    
    private void cargarDatos() {
        cargarProductos();
        cargarHistorial();
        cargarCategorias();
        cargarEstadisticas();
    }
    
    private void cargarProductos() {
        try {
            if (port == null) {
                mostrarError("No hay conexión con el servicio");
                return;
            }
            
            List<Producto> productos = port.listarProductos();
            modeloProductos.setRowCount(0);
            
            for (Producto p : productos) {
                String estado = getEstadoStock(p.getStock());
                Object[] fila = {
                    p.getNombre(),
                    String.format("$%.2f", p.getPrecio()),
                    p.getStock(),
                    p.getCategoria(),
                    estado
                };
                modeloProductos.addRow(fila);
            }
            
            lblEstado.setText(String.format("🔌 Estado: %d productos cargados", productos.size()));
            
        } catch (Exception e) {
            mostrarError("Error al cargar productos: " + e.getMessage());
        }
    }
    
    private void cargarCategorias() {
        try {
            if (port == null) return;
            
            List<String> categorias = port.listarCategorias();
            comboCategoria.removeAllItems();
            comboCategoria.addItem("Todas las categorías");
            
            for (String categoria : categorias) {
                comboCategoria.addItem(categoria);
            }
            
        } catch (Exception e) {
            System.err.println("Error al cargar categorías: " + e.getMessage());
        }
    }
    
    private void cargarHistorial() {
        try {
            if (port == null) return;
            
            List<Venta> ventas = port.obtenerHistorialVentas();
            modeloVentas.setRowCount(0);
            
            double totalGeneral = 0;
            int contador = 1;
            
            for (Venta v : ventas) {
                Object[] fila = {
                    contador++,
                    v.getProducto(),
                    v.getCantidad(),
                    String.format("$%.2f", v.getTotal()),
                    new java.util.Date().toString() // Fecha simulada
                };
                modeloVentas.addRow(fila);
                totalGeneral += v.getTotal();
            }
            
            lblTotalVentas.setText(String.format("💰 Total General: $%.2f (%d ventas)", 
                                                totalGeneral, ventas.size()));
            
        } catch (Exception e) {
            mostrarError("Error al cargar historial: " + e.getMessage());
        }
    }
    
    private void cargarEstadisticas() {
        try {
            if (port == null) return;
            
            String estadisticas = port.obtenerEstadisticas();
            txtEstadisticas.setText(estadisticas);
            
        } catch (Exception e) {
            mostrarError("Error al cargar estadísticas: " + e.getMessage());
        }
    }
    
    private void filtrarProductos() {
        // Implementar filtrado por categoría y estado de stock
        String categoriaSeleccionada = (String) comboCategoria.getSelectedItem();
        String estadoStock = (String) comboFiltroStock.getSelectedItem();
        String busqueda = txtBusqueda.getText().trim().toLowerCase();
        
        // Aquí se implementaría el filtrado de la tabla
        // Por simplicidad, se mantiene la funcionalidad básica
    }
    
    private void seleccionarProducto() {
        try {
            List<Producto> productos = port.listarProductosDisponibles();
            String[] opciones = productos.stream()
                    .map(p -> String.format("%s (Stock: %d)", p.getNombre(), p.getStock()))
                    .toArray(String[]::new);
            
            String seleccion = (String) JOptionPane.showInputDialog(this,
                    "Selecciona un producto:",
                    "Lista de Productos",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            
            if (seleccion != null) {
                String nombreProducto = seleccion.split(" \\(Stock:")[0];
                txtProducto.setText(nombreProducto);
            }
            
        } catch (Exception e) {
            mostrarError("Error al cargar productos: " + e.getMessage());
        }
    }
    
    private void registrarVenta() {
        try {
            if (port == null) {
                mostrarError("No hay conexión con el servicio");
                return;
            }
            
            String producto = txtProducto.getText().trim();
            int cantidad = (Integer) spinnerCantidad.getValue();
            
            if (producto.isEmpty()) {
                mostrarAdvertencia("Por favor, ingresa el nombre del producto");
                return;
            }
            
            String resultado = port.registrarVenta(producto, cantidad);
            
            // Agregar al log de resultados
            txtResultado.append("═══════════════════════════\n");
            txtResultado.append("NUEVA VENTA\n");
            txtResultado.append("Fecha: " + new java.util.Date() + "\n");
            txtResultado.append("Producto: " + producto + "\n");
            txtResultado.append("Cantidad: " + cantidad + "\n");
            txtResultado.append("Resultado: " + resultado + "\n\n");
            txtResultado.setCaretPosition(txtResultado.getDocument().getLength());
            
            if (resultado.contains("✅")) {
                txtProducto.setText("");
                spinnerCantidad.setValue(1);
                cargarProductos();
                cargarHistorial();
                JOptionPane.showMessageDialog(this, resultado, "Venta Exitosa", 
                                            JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, resultado, "Error en Venta", 
                                            JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            mostrarError("Error al registrar venta: " + e.getMessage());
        }
    }
    
    private void consultarStock(String producto) {
        try {
            if (producto.isEmpty()) {
                mostrarAdvertencia("Ingresa el nombre del producto");
                return;
            }
            
            String resultado = port.consultarStock(producto);
            JOptionPane.showMessageDialog(this, resultado, "Consulta de Stock", 
                                        JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            mostrarError("Error al consultar stock: " + e.getMessage());
        }
    }
    
    private void agregarStock(String producto, int cantidad) {
        try {
            if (producto.isEmpty()) {
                mostrarAdvertencia("Ingresa el nombre del producto");
                return;
            }
            
            String resultado = port.agregarStock(producto, cantidad);
            JOptionPane.showMessageDialog(this, resultado, "Agregar Stock", 
                                        JOptionPane.INFORMATION_MESSAGE);
            
            if (resultado.contains("✅")) {
                cargarProductos();
            }
            
        } catch (Exception e) {
            mostrarError("Error al agregar stock: " + e.getMessage());
        }
    }
    
    private void mostrarProductosBajoStock() {
        try {
            String umbralStr = JOptionPane.showInputDialog(this, 
                    "Ingresa el umbral de stock bajo:", "10");
            
            if (umbralStr != null && !umbralStr.trim().isEmpty()) {
                int umbral = Integer.parseInt(umbralStr.trim());
                List<Producto> productos = port.listarProductosBajoStock(umbral);
                
                if (productos.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay productos con bajo stock", 
                                                "Bajo Stock", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder mensaje = new StringBuilder("Productos con stock ≤ " + umbral + ":\n\n");
                    for (Producto p : productos) {
                        mensaje.append(String.format("• %s: %d unidades\n", p.getNombre(), p.getStock()));
                    }
                    
                    JOptionPane.showMessageDialog(this, mensaje.toString(), 
                                                "Productos con Bajo Stock", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        } catch (NumberFormatException e) {
            mostrarAdvertencia("Ingresa un número válido");
        } catch (Exception e) {
            mostrarError("Error al consultar productos con bajo stock: " + e.getMessage());
        }
    }
    
    private void mostrarProductosAgotados() {
        try {
            List<Producto> productos = port.listarProductosAgotados();
            
            if (productos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "¡Excelente! No hay productos agotados", 
                                            "Stock Completo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder mensaje = new StringBuilder("Productos agotados:\n\n");
                for (Producto p : productos) {
                    mensaje.append(String.format("• %s (%s)\n", p.getNombre(), p.getCategoria()));
                }
                
                JOptionPane.showMessageDialog(this, mensaje.toString(), 
                                            "Productos Agotados", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            mostrarError("Error al consultar productos agotados: " + e.getMessage());
        }
    }
    
    private void exportarInventario() {
        JOptionPane.showMessageDialog(this, 
                "Funcionalidad de exportación en desarrollo.\n" +
                "Próximamente podrás exportar a Excel/PDF.", 
                "Exportar Inventario", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void exportarHistorial() {
        JOptionPane.showMessageDialog(this, 
                "Funcionalidad de exportación en desarrollo.\n" +
                "Próximamente podrás exportar a Excel/PDF.", 
                "Exportar Historial", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void generarReporte() {
        JOptionPane.showMessageDialog(this, 
                "Funcionalidad de reportes en desarrollo.\n" +
                "Próximamente tendrás reportes detallados.", 
                "Generar Reporte", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(this, 
                "🛒 Sistema de Ventas SOAP - Versión Mejorada\n\n" +
                "Características:\n" +
                "• Gestión de inventario con stock y categorías\n" +
                "• Control de stock en tiempo real\n" +
                "• Historial detallado de ventas\n" +
                "• Estadísticas avanzadas\n" +
                "• Interfaz moderna y funcional\n\n" +
                "Desarrollado con Java y Servicios SOAP\n" +
                "NetBeans 24 - JAX-WS", 
                "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private String getEstadoStock(int stock) {
        if (stock == 0) return "❌ Agotado";
        if (stock <= 5) return "⚠️ Bajo";
        if (stock <= 20) return "🟡 Medio";
        return "✅ Alto";
    }
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        lblEstado.setText("❌ Error: " + mensaje);
    }
    
    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClienteGUI().setVisible(true);
        });
    }
}