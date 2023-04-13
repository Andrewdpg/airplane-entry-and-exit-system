package ui.tabs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Flight;
import entity.Passenger;
import entity.Plane;
import lambda.ChangeTab;
import utils.HashTable;
import utils.MaxHeap;
import utils.Storage;

public class Entrance extends javax.swing.JPanel {

    private HashTable<String, Passenger> passengersTable;
    private MaxHeap<Passenger> arrived;
    private Passenger currentPassenger;
    private ChangeTab<Flight> onChange;
    private Flight flight;
    private Long initTime;

    public Entrance() {
        initComponents();
    }

    public Entrance(Plane plane, MaxHeap<Passenger> arrived) {
        initComponents();
        this.flight = new Flight(plane, new Passenger[plane.getRows()][plane.getColumns()]);
        this.arrived = arrived;
        nextPassenger();
        initPlaneGrid();
        setActions();
    }

    private void initPlaneGrid() {
        int spaceBetween = 3;
        int size = 50;
        int panelWidth = size * flight.getPlane().getColumns() + spaceBetween * (flight.getPlane().getColumns() - 1);
        int panelHeight = size * flight.getPlane().getRows() + spaceBetween * (flight.getPlane().getRows() - 1);

        panel.setLayout(new GridLayout(flight.getPlane().getColumns(), flight.getPlane().getRows(), spaceBetween,
                spaceBetween));
        panel.setSize(panelWidth, panelHeight);
        for (int i = 0; i < flight.getPlane().getColumns(); i++) {
            for (int index = 0; index < flight.getPlane().getRows(); index++) {
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

        passengerIdTf = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        entranceBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        finishBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        panel = new JPanel();

        setPreferredSize(new java.awt.Dimension(538, 329));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel11.setText("Pasajero actual");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel12.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel14.setText("ID:");

        entranceBtn.setText("Entró");
        finishBtn.setText("Comenzar vuelo");
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
                                                                        .addComponent(searchBtn))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                        .addComponent(finishBtn)))

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
                                                .addGap(0, 143, Short.MAX_VALUE)
                                                .addComponent(finishBtn))
                                        .addComponent(jScrollPane4))
                                .addContainerGap()));
    }

    public void setActions() {
        entranceBtn.addActionListener((act) -> {
            if (currentPassenger != null) {
                currentPassenger.setState(Passenger.ON_BOARD);
                flight.addPassenger(currentPassenger);
                passengersTable.put(currentPassenger.getId(), currentPassenger);
                int panelID = (flight.getPlane().getRows() * currentPassenger.getColumn()) + currentPassenger.getRow();
                panel.getComponent(panelID).setFont(new Font("Segoe UI", 1, 8));
                panel.getComponent(panelID).setForeground(new Color(50, 200, 50));
                nextPassenger();
            }
        });
        nextBtn.addActionListener((act) -> {
            passengersTable.get(currentPassenger.getId()).setState(Passenger.UNLISTED);
            nextPassenger();
        });
        searchBtn.addActionListener((act) -> {
            if (currentPassenger != null) {
                arrived.insert(Double.MAX_VALUE, currentPassenger);
            }
            currentPassenger = passengersTable.get(passengerIdTf.getText());
            if (currentPassenger != null) {
                nextBtn.setEnabled(true);
                switch (currentPassenger.getState()) {
                    case Passenger.UNLISTED:
                        arrived.insert(currentPassenger.getPriority(initTime, flight.getPlane()), currentPassenger);
                        currentPassenger.setState(Passenger.LISTED);
                        JOptionPane.showMessageDialog(null, "Agregado a la lista de espera");
                        break;
                    case Passenger.LISTED:
                        JOptionPane.showMessageDialog(null, "El pasajero ya se encuentra en lista de espera");
                        break;
                    case Passenger.ON_BOARD:
                        JOptionPane.showMessageDialog(null, "El pasajero ya se encuentra a bordo del avión");
                        break;
                    default:
                        break;
                }
                nextPassenger();
            } else {
                JOptionPane.showMessageDialog(null, "Pasajero no encontrado");
            }
        });
        finishBtn.addActionListener((act) -> {
            if (flight.getOnBoard() == 0) {
                JOptionPane.showMessageDialog(null, "Debe haber pasajeros");
            } else if (currentPassenger != null) {
                JOptionPane.showMessageDialog(null, "Aún hay pasajeros en espera");
            } else {
                Storage.saveJsonTo(Flight.PATH + flight.getPlane().getId() + ".txt", flight);
                onChange.change(flight);
            }
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

    public void setInitTime(Long time) {
        this.initTime = time;
    }

    public void setPassengersTable(HashTable<String, Passenger> passengersTable) {
        this.passengersTable = passengersTable;
    }

    public void setOnChange(ChangeTab<Flight> onChange) {
        this.onChange = onChange;
    }

    private javax.swing.JLabel idLbl;
    private javax.swing.JButton entranceBtn;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton finishBtn;
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
