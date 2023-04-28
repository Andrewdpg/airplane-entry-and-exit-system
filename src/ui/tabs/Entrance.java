package ui.tabs;

import java.awt.Font;

import javax.swing.JOptionPane;

import entity.Flight;
import entity.Passenger;
import entity.Plane;
import lambda.ChangeTab;
import ui.components.PlaneView;
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
        this.flight = new Flight(plane, new Passenger[plane.getRows()][plane.getColumns()]);
        this.arrived = arrived;
        initComponents();
        nextPassenger();
        setActions();
        planeView = new PlaneView(flight);
        jScrollPane4.setViewportView(planeView);
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
        helpBtn = new javax.swing.JButton();
        planeView = new PlaneView();
        jScrollPane4.setViewportView(planeView);

        setPreferredSize(new java.awt.Dimension(538, 329));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel11.setText("Pasajero actual");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel12.setText("Nombre:");
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel14.setText("ID:");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel13.setText("Búsqueda de pasajeros");
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel16.setText("ID:");
        entranceBtn.setText("Entró");
        finishBtn.setText("Comenzar vuelo");
        nextBtn.setText("Saltar");
        searchBtn.setText("Buscar");
        helpBtn.setText("?");
        helpBtn.setFocusPainted(false);
        helpBtn.setBorderPainted(false);
        helpBtn.setFont(new Font("Segoe UI", 1, 12));

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

                                                .addContainerGap())))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                        .addComponent(helpBtn)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(helpBtn)
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
                planeView.setSeatAs(currentPassenger.getRow(), currentPassenger.getColumn(), PlaneView.TAKEN);
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
                Storage.saveJsonTo(Flight.PATH + flight.getPlane().getId() + ".json", flight);
                onChange.change(flight);
            }
        });
        helpBtn.addActionListener((act) -> {
            JOptionPane.showMessageDialog(this.getParent(), ""
                    + "Panel izquierdo: Vista del estado de los asientos del avión:\n"
                    + "         - Verde: Asiento libre.\n"
                    + "         - Rojo: Asiento ocupado.\n\n"
                    + "Pasajero actual: Pasajero con prioridad de entrada actual (quien debería entrar actualmente).\n"
                    + "Entró: Indica que el pasajero actual ha abordado el avión y continúa con el siguiente en la lista/fila.\n"
                    + "Saltar: Indica que el pasajero actual no ha abordado el avión y continúa con el siguiente en la lista/fila.\n"
                    + "Busqueda de pasajeros: Busca un pasajero que no esté en lista de llegada para agregarlo a la lista/fila de entrada.\n"
                    + "Comenzar vuelo: Guarda la información del vuelo (el avión seleccionado y los pasajeros a bordo)");
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
    private javax.swing.JButton helpBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField passengerIdTf;
    private PlaneView planeView;
}
