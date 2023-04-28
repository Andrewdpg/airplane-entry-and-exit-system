package ui.tabs;

import java.awt.Font;

import javax.swing.JOptionPane;

import entity.Flight;
import entity.Plane;
import lambda.ChangeTab;
import ui.Landing;
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
        helpBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        initList();

        jScrollPane1.setViewportView(planeList);
        jScrollPane2.setViewportView(flightList);
        nextBtn.setText("Iniciar nuevo vuelo");
        addPlaneBtn.setText("Nuevo avión");
        updateBtn.setText("Actualizar lista");
        deleteBtn.setText("Eliminar avión");
        landingBtn.setText("Comenzar descenso");
        helpBtn.setText("?");
        helpBtn.setFocusPainted(false);
        helpBtn.setBorderPainted(false);
        helpBtn.setFont(new Font("Segoe UI", 1, 12));

        jLabel1.setText("Aviones disponibles");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Sistema de vuelos");
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
                                .addGap(215, 215, 215)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)
                                .addGap(0, 0, 10))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(landingBtn)
                                                        .addGap(0, 0, 10))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                        .addComponent(helpBtn)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(helpBtn)
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
                    onContinue.change(Storage.loadJsonFrom(Plane.PATH + planeList.getSelectedValue()
                            + ".json", Plane.class));
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
            if (planeList.getSelectedValue().equals("Default")) {
                JOptionPane.showMessageDialog(null, "No puede eliminarse el avión por defecto", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Storage.deleteFile(Plane.PATH + planeList.getSelectedValue() + ".json")) {
                initList();
            }
        });
        landingBtn.addActionListener((act) -> {
            if (flightList.getSelectedValue() != null) {
                Landing.run(Flight.PATH + flightList.getSelectedValue() + ".json");
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un vuelo");
            }
        });
        helpBtn.addActionListener((act) -> {
            JOptionPane.showMessageDialog(this.getParent(), ""
                    + "Aviones disponibles: Lista de aviones creados y no en vuelo actualmente.\n"
                    + "Vuelos en curso: Lista de vuelos pendientes de desembarcar pasajeros.\n"
                    + "Iniciar nuevo vuelo: Inicia el proceso de un vuelo tomando el avión seleccionado.\n"
                    + "Comenzar descenso: Inicia/continúa el desembarque de pasajeros del vuelo seleccionado.");
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
    private javax.swing.JButton helpBtn;
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
