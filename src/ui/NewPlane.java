package ui;

public class NewPlane extends javax.swing.JFrame {

    public NewPlane() {
    }

    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        flightIdTf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        columnsCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        rowsTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tableScroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        endRowTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        initRowTf = new javax.swing.JTextField();
        addSectionBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        model = new javax.swing.table.DefaultTableModel(
                null, new String[] { "Fila inicio", "Fila final" }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jLabel3.setText("ID de avión");
        jLabel1.setText("No. Columnas");
        jLabel2.setText("No. Filas");
        jLabel5.setText("Nuevo avión");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel6.setText("Secciones del avión");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel7.setText("Desde fila:");
        jLabel8.setText("Hasta fila:");
        jLabel9.setText("Agregar sección");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12));

        columnsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "6", "8" }));

        table.setEnabled(false);
        saveBtn.setEnabled(false);
        addSectionBtn.setEnabled(false);
        initRowTf.setEnabled(false);
        endRowTf.setEnabled(false);

        table.setModel(model);
        tableScroll.setViewportView(table);

        addSectionBtn.setText("Agregar");
        saveBtn.setText("Guardar");
        deleteBtn.setText("Eliminar");
        nextBtn.setText("Siguiente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                .createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(saveBtn,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                93,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteBtn,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                93,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(initRowTf)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(endRowTf)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(addSectionBtn))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addGroup(jPanel2Layout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(flightIdTf)
                                                                        .addGroup(jPanel2Layout
                                                                                .createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addGroup(jPanel2Layout
                                                                                .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(nextBtn)
                                                                                .addGroup(jPanel2Layout
                                                                                        .createSequentialGroup()
                                                                                        .addGroup(jPanel2Layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(columnsCB,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        109,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel1))
                                                                                        .addGap(18, 18, 18)
                                                                                        .addGroup(jPanel2Layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabel2)
                                                                                                .addComponent(rowsTf,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        109,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                .addComponent(tableScroll,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        0,
                                                        Short.MAX_VALUE)
                                                .addComponent(jLabel9)))
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(columnsCB,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rowsTf,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(flightIdTf,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextBtn)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout
                                                .createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jLabel9))
                                        .addComponent(jLabel6))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(initRowTf,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(endRowTf,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                        .addComponent(addSectionBtn))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tableScroll,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        190,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn)
                                .addComponent(saveBtn)
                                .addGap(0, 0, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                .createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jPanel2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        pack();
    }

    public void init() {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewPlane.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPlane.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPlane.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPlane.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setAlwaysOnTop(true);
        initComponents();
    }

    public static void run() {
        new NewPlane().init();
    }

    private javax.swing.JButton addSectionBtn;
    private javax.swing.JComboBox<String> columnsCB;
    private javax.swing.JTextField endRowTf;
    private javax.swing.JTextField flightIdTf;
    private javax.swing.JTextField initRowTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTextField rowsTf;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScroll;
    private javax.swing.table.DefaultTableModel model;
}