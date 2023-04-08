package ui;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import entity.Plane;
import entity.Section;
import utils.Storage;

public class NewPlane extends javax.swing.JFrame {

    private int rowCount;
    private int columnCount;
    LinkedList<Section> sections;

    public NewPlane() {
        sections = new LinkedList<>();
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
        setActions();
    }

    public void setActions() {
        nextBtn.addActionListener((act) -> {
            if (validRowCount() && validFlightID()) {
                rowsTf.setEnabled(false);
                columnsCB.setEnabled(false);
                flightIdTf.setEnabled(false);
                nextBtn.setEnabled(false);
                table.setEnabled(true);
                saveBtn.setEnabled(true);
                addSectionBtn.setEnabled(true);
                initRowTf.setEnabled(true);
                endRowTf.setEnabled(true);
                columnCount = Integer.valueOf(columnsCB.getItemAt(columnsCB.getSelectedIndex()));
            }
        });

        addSectionBtn.addActionListener((act) -> {
            if (validSection()) {
                int init = Integer.min(Integer.parseInt(endRowTf.getText()), Integer.parseInt(initRowTf.getText()));

                int end = Integer.max(Integer.parseInt(endRowTf.getText()), Integer.parseInt(initRowTf.getText()));

                sections.add(new Section(init, end));
                model.addRow(new String[] { String.valueOf(init), String.valueOf(end) });
                initRowTf.setText("");
                endRowTf.setText("");
            }
        });

        deleteBtn.addActionListener((act) -> {
            if (table.getSelectedRow() != -1) {
                sections.remove(table.getSelectedRow());
                model.removeRow(table.getSelectedRow());
            }
        });

        saveBtn.addActionListener((act) -> {
            if (Storage.saveJsonTo("data/plane/" + flightIdTf.getText() + ".txt",
                    new Plane(flightIdTf.getText(), columnCount, rowCount, sections))) {
                dispose();
            }
        });
    }

    public static void run() {
        new NewPlane().init();
    }

    public boolean validRowCount() {
        try {
            rowCount = Integer.parseInt(rowsTf.getText());
            if (rowCount < 10) {
                JOptionPane.showMessageDialog(null, "Debe haber al menos 10 filas");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor de filas inválido", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean validFlightID() {
        for (String name : Storage.getFileNamesAt("data/plane")) {
            if (name.replace(".txt", "").equals(flightIdTf.getText())) {
                JOptionPane.showMessageDialog(null, "La id del avión ya existe");
                return false;
            }
        }
        return true;
    }

    public boolean validSection() {
        int newInit;
        int newEnd;
        try {
            newInit = Integer.parseInt(initRowTf.getText());
            newEnd = Integer.parseInt(endRowTf.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valores ingresados inválidos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (newInit > rowCount || newEnd > rowCount || newInit <= 0 || newEnd <= 0) {
            JOptionPane.showMessageDialog(null, "Valores fuera del rango de filas", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for (int i = 0; i < sections.size(); i++) {
            int init = sections.get(i).getStart();
            int end = sections.get(i).getEnd();
            if ((newInit >= init && newInit <= end) || (newEnd >= init && newEnd <= end)) {
                JOptionPane.showMessageDialog(null, "Rango de sección ya asignado", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
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