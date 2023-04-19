package ui.tabs;

import javax.swing.JOptionPane;

import entity.Plane;
import lambda.ChangeTab;
import ui.NewPlane;
import utils.Storage;

public class Home extends javax.swing.JPanel {

    ChangeTab<Plane> onContinue;

    public Home(ChangeTab<Plane> onContinue) {
        initComponents();
        setActions();
        this.onContinue = onContinue;
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        planeList = new javax.swing.JList<>();
        flightList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        addPlaneBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        landingBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        initList();

        jScrollPane1.setViewportView(planeList);
        jScrollPane2.setViewportView(flightList);
        nextBtn.setText("Siguiente");
        addPlaneBtn.setText("Nuevo");
        updateBtn.setText("Actualizar");
        deleteBtn.setText("Eliminar");
        landingBtn.setText("Comenzar descenso");

        jLabel1.setText("Selecciona un avión disponible");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Avión");
        jLabel3.setText("Vuelos en curso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 178, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(updateBtn)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(deleteBtn)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(addPlaneBtn))
                                                                        .addComponent(nextBtn)))
                                                        .addComponent(jScrollPane1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(landingBtn)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addPlaneBtn)
                                        .addComponent(updateBtn)
                                        .addComponent(deleteBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(landingBtn)
                                .addContainerGap(40, Short.MAX_VALUE)));
    }

    public void setActions() {
        addPlaneBtn.addActionListener((act) -> NewPlane.run());
        updateBtn.addActionListener((act) -> initList());
        nextBtn.addActionListener((act) -> {
            if (planeList.getSelectedValue() != null) {
                try {
                    onContinue.change(Storage.loadJsonFrom(Plane.PATH + planeList.getSelectedValue(), Plane.class));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
            JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la lista", "Error",
                    JOptionPane.ERROR_MESSAGE);

        });
        deleteBtn.addActionListener((act) -> {
            if (planeList.getSelectedValue() == null) {
                return;
            }
            if (planeList.getSelectedValue().equals("Default.txt")) {
                JOptionPane.showMessageDialog(null, "No puede eliminarse el avión por defecto", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Storage.deleteFile(Plane.PATH + planeList.getSelectedValue())) {
                initList();
            }
        });
    }

    public void initList() {
        PlaneListModel = new javax.swing.AbstractListModel<String>() {
            String[] strings = Storage.availablePlanes();

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        };
        planeList.setModel(PlaneListModel);

        FlightListModel = new javax.swing.AbstractListModel<String>() {
            String[] strings = Storage.currentFlights();

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        };
        flightList.setModel(FlightListModel);
    }

    private javax.swing.JButton updateBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton landingBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton addPlaneBtn;
    private javax.swing.JList<String> planeList;
    private javax.swing.JList<String> flightList;
    private javax.swing.AbstractListModel<String> PlaneListModel;
    private javax.swing.AbstractListModel<String> FlightListModel;
}
