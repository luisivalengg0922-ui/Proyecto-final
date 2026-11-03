/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visual;
import com.mycompany.proyectofinal_f1.Fachada;
/**
 *
 * @author lucky
 */
public class Generalroot extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Generalroot.class.getName());

    /**
     * Creates new form General
     */
    public Generalroot() {
    initComponents();
    cargarDatos();
    jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
}
private void cargarDatos() {

    String seleccion = jComboBox1.getSelectedItem().toString();

    switch (seleccion) {
        case "Autos":
            jTable1.setModel(Fachada.getInstancia().obtenerAutos());
            break;

        case "Circuitos":
            jTable1.setModel(Fachada.getInstancia().obtenerCircuito());
            break;

        case "Escuderias":
            jTable1.setModel(Fachada.getInstancia().obtenerEscuderia());
            break;

        case "Grandes Premios":
            jTable1.setModel(Fachada.getInstancia().obtenerGranPremio());
            break;

        case "Indumentaria":
            jTable1.setModel(Fachada.getInstancia().obtenerIndumentaria());
            break;

        case "Motores":
            jTable1.setModel(Fachada.getInstancia().obtenerMotores());
            break;

        case "Pilotos":
            jTable1.setModel(Fachada.getInstancia().obtenerPilotos());
            break;

        case "Proveedores":
            jTable1.setModel(Fachada.getInstancia().obtenerProveedores());
            break;

        case "Resultados":
            jTable1.setModel(Fachada.getInstancia().obtenerResultados());
            break;

        case "Temporada":
            jTable1.setModel(Fachada.getInstancia().obtenerTemporada());
            break;
    }
}
private String[] obtenerEtiquetas(String tabla, boolean incluirClaves) {

    switch (tabla) {

        case "Autos":
            return incluirClaves
                    ? new String[]{"Identificador", "Año de fabricación", "Modelo"}
                    : new String[]{"Año de fabricación", "Modelo"};

        case "Pilotos":
            return incluirClaves
                    ? new String[]{"Código", "Nombre", "Nacionalidad", "Fecha de nacimiento"}
                    : new String[]{"Nombre", "Nacionalidad", "Fecha de nacimiento"};

        case "Circuitos":
            return incluirClaves
                    ? new String[]{"Identificador", "Nombre", "País", "Longitud", "Cantidad de vueltas"}
                    : new String[]{"Nombre", "País", "Longitud", "Cantidad de vueltas"};

        case "Grandes Premios":
            return incluirClaves
                    ? new String[]{"Identificador", "Fecha", "Nombre", "Año"}
                    : new String[]{"Fecha", "Nombre", "Año"};

        case "Temporada":
            return new String[]{"Año"};

        case "Escuderias":
            return incluirClaves
                    ? new String[]{"Identificador", "Nombre"}
                    : new String[]{"Nombre"};

        case "Indumentaria":
            return new String[]{"Nombre"};

        case "Motores":
            return new String[]{"Número de chasis"};

        case "Proveedores":
            return incluirClaves
                    ? new String[]{"Identificador", "Nombre"}
                    : new String[]{"Nombre"};

        case "Resultados":
            return incluirClaves
                    ? new String[]{
                        "Código del piloto",
                        "Identificador del auto",
                        "Identificador del Gran Premio",
                        "Tiempo en horas",
                        "Vueltas",
                        "Puntos",
                        "Posición"
                    }
                    : new String[]{
                        "Tiempo en horas",
                        "Vueltas",
                        "Puntos",
                        "Posición"
                    };

        default:
            return new String[]{};
    }
}
private Object[] solicitarValores(String[] etiquetas) {

    Object[] valores = new Object[etiquetas.length];

    for (int i = 0; i < etiquetas.length; i++) {

        String valor = javax.swing.JOptionPane.showInputDialog(
                this,
                "Ingresá " + etiquetas[i] + ":"
        );

        if (valor == null) {
            return null;
        }

        if (valor.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "El campo " + etiquetas[i] + " no puede estar vacío."
            );
            return null;
        }

        valores[i] = valor.trim();
    }

    return valores;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autos", "Circuitos", "Escuderias", "Grandes Premios", "Indumentaria", "Motores", "Pilotos", "Proveedores", "Resultados", "Temporada" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 150, 255));
        jLabel5.setText("Cambiar de cuenta");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 194, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        cargarDatos();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String tabla = jComboBox1.getSelectedItem().toString();

    String[] etiquetas = obtenerEtiquetas(tabla, true);

    Object[] valores = solicitarValores(etiquetas);

    if (valores == null) {
        return;
    }

    boolean agregado = Fachada.getInstancia()
            .insertarRegistro(tabla, valores);

    if (agregado) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Registro agregado correctamente."
        );

        cargarDatos();

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "No se pudo agregar el registro. "
                + "Revisá los datos ingresados y las relaciones.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = jTable1.getSelectedRow();

    if (fila == -1) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Seleccioná un registro para modificar."
        );
        return;
    }

    String tabla = jComboBox1.getSelectedItem().toString();

    String[] etiquetas = obtenerEtiquetas(tabla, false);

    if (etiquetas.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Esta tabla no tiene campos modificables."
        );
        return;
    }

    int cantidadClaves = tabla.equals("Resultados") ? 3 : 1;

    Object[] claves = new Object[cantidadClaves];

    for (int i = 0; i < cantidadClaves; i++) {
        claves[i] = jTable1.getValueAt(fila, i);
    }

    int confirmar = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "¿Querés modificar este registro?",
            "Confirmar modificación",
            javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (confirmar != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    Object[] valores = solicitarValores(etiquetas);

    if (valores == null) {
        return;
    }

    boolean modificado = Fachada.getInstancia()
            .modificarRegistro(tabla, claves, valores);

    if (modificado) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Registro modificado correctamente."
        );

        cargarDatos();

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "No se pudo modificar el registro. "
                + "Revisá los datos ingresados.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jTable1.getSelectedRow();

    if (fila == -1) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Seleccioná un registro para eliminar."
        );
        return;
    }

    String tabla = jComboBox1.getSelectedItem().toString();

    int confirmar = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que querés eliminar este registro?",
            "Confirmar eliminación",
            javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (confirmar != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    Object[] claves;

    switch (tabla) {

        case "Autos":
        case "Circuitos":
        case "Grandes Premios":
        case "Escuderias":
        case "Proveedores":
            claves = new Object[]{jTable1.getValueAt(fila, 0)};
            break;

        case "Pilotos":
        case "Temporada":
        case "Indumentaria":
        case "Motores":
            claves = new Object[]{jTable1.getValueAt(fila, 0)};
            break;

        case "Resultados":
            claves = new Object[]{
                jTable1.getValueAt(fila, 0),
                jTable1.getValueAt(fila, 1),
                jTable1.getValueAt(fila, 2)
            };
            break;

        default:
            return;
    }

    boolean eliminado = Fachada.getInstancia()
            .eliminarRegistro(tabla, claves);

    if (eliminado) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Registro eliminado correctamente."
        );

        cargarDatos();

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "No se pudo eliminar el registro. "
                + "Puede estar relacionado con otros registros.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Login li = new Login();
        li.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Generalroot().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
