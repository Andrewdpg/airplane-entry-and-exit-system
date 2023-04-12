package ui.tabs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Passenger;
import entity.Plane;
import utils.MaxHeap;

public class Entrance extends javax.swing.JPanel {

    private Plane plane;
    private MaxHeap<Passenger> arrived;
    private Passenger currentPassenger;
    private Passenger[][] passengers;

    public Entrance() {
        initComponents();
    }

    public Entrance(Plane plane, MaxHeap<Passenger> arrived) {
        initComponents();
        this.plane = plane;
        this.arrived = arrived;
        passengers = new Passenger[plane.getRows()][plane.getColumns()];
        nextPassenger();
        initPlaneGrid();
        setActions();
    }

    private void initPlaneGrid() {
        int spaceBetween = 3;
        int size = 50;
        int panelWidth = size * plane.getColumns() + spaceBetween * (plane.getColumns() - 1);
        int panelHeight = size * plane.getRows() + spaceBetween * (plane.getRows() - 1);

        panel.setLayout(new GridLayout(plane.getColumns(), plane.getRows(), spaceBetween, spaceBetween));
        panel.setSize(panelWidth, panelHeight);
        for (int i = 0; i < plane.getColumns(); i++) {
            for (int index = 0; index < plane.getRows(); index++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(size, 20));
                button.setFont(new Font("Segoe UI", 0, 8));
                button.setText((index + 1) + "" + Character.valueOf((char) (65 + i)));
                panel.add(button);
            }
        }
        jScrollPane4.setViewportView(panel);
    }

    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        entranceBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        passengerIdTf = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        panel = new JPanel();

        setPreferredSize(new java.awt.Dimension(538, 329));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel11.setText("Pasajero actual");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel12.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel14.setText("ID:");

        entranceBtn.setText("Entró");

        nextBtn.setText("Saltar");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel13.setText("Búsqueda de pasajeros");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel16.setText("ID:");

        searchBtn.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        300,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jLabel13))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(75, 75, 75)
                                                                .addComponent(jLabel11)))
                                                .addGap(0, 53, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel16)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(passengerIdTf))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel14)
                                                                .addGap(39, 39, 39)
                                                                .addComponent(idLbl,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(entranceBtn)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(nextBtn)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(nameLbl,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                        .addComponent(searchBtn)))
                                                .addContainerGap()))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(nameLbl,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                16,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel14,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(idLbl,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                16,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(entranceBtn)
                                                        .addComponent(nextBtn))
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passengerIdTf,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel16))
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchBtn)
                                                .addGap(0, 143, Short.MAX_VALUE))
                                        .addComponent(jScrollPane4))
                                .addContainerGap()));
    }

    public void setActions() {
        entranceBtn.addActionListener((act) -> {
            if (currentPassenger != null) {
                int row = currentPassenger.getSeat().getLocation().getRow() - 1;
                int column = currentPassenger.getSeat().getLocation().getColumnValue() - 1;
                passengers[row][column] = currentPassenger;
                nextPassenger();
            }
        });
        nextBtn.addActionListener((act) -> {
            nextPassenger();
        });
    }

    private void nextPassenger() {
        currentPassenger = arrived.extract();
        if (currentPassenger != null) {
            nameLbl.setText(currentPassenger.getName());
            idLbl.setText(currentPassenger.getId());
        } else {
            nameLbl.setText("");
            idLbl.setText("");
            nextBtn.setEnabled(false);
            JOptionPane.showMessageDialog(null, "No hay más pasajeros en lista de llegada.");
        }
    }

    private javax.swing.JLabel idLbl;
    private javax.swing.JButton entranceBtn;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField passengerIdTf;
    private javax.swing.JPanel panel;

}
