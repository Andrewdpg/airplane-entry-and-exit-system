package ui.tabs;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import entity.Passenger;
import entity.Plane;
import lambda.ChangeTab;
import utils.HashTable;
import utils.MaxHeap;

public class Arrival extends javax.swing.JPanel {

    private HashTable<String, Passenger> passengers;
    private Plane plane;
    private MaxHeap<Passenger> entranceList;
    private Long initTime;
    private Passenger selectedPassenger;
    private ChangeTab<MaxHeap<Passenger>> onContinue;

    public Arrival() {
        initComponents();
        setActions();
    }

    public Arrival(HashTable<String, Passenger> passengers, ChangeTab<MaxHeap<Passenger>> onContinue) {
        initComponents();
        setActions();
        this.passengers = passengers;
        if (passengers != null) {
            entranceList = new MaxHeap<>(passengers.size());
            initTime = System.currentTimeMillis();
            this.onContinue = onContinue;
        }
    }

    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        passengerList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        passengerIdTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ageLbl = new javax.swing.JLabel();
        registerArrivalBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        continueBtn = new javax.swing.JButton();
        helpBtn = new javax.swing.JButton();
        registerArrivalBtn.setEnabled(false);
        model = new DefaultListModel<>();

        passengerList.setModel(model);
        jScrollPane3.setViewportView(passengerList);
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel5.setText("Pasajeros presentes");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel6.setText("Llegada de pasajero");
        jLabel7.setText("ID:");
        jLabel8.setText("Nombre:");
        jLabel9.setText("Edad:");
        registerArrivalBtn.setText("Registrar llegada");
        searchBtn.setText("Buscar");
        continueBtn.setText("Continuar");
        helpBtn.setText("?");
        helpBtn.setFocusPainted(false);
        helpBtn.setBorderPainted(false);
        helpBtn.setFont(new Font("Segoe UI", 1, 12));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(continueBtn))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel9)
                                                                        .addGap(24, 24, 24)
                                                                        .addComponent(ageLbl,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(searchBtn)
                                                                        .addComponent(
                                                                                registerArrivalBtn)))
                                                        .addGap(0, 76, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(passengerIdTf)))
                                        .addContainerGap()))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                        .addComponent(helpBtn)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
                        .addComponent(helpBtn)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        300,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(passengerIdTf,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel7))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(jLabel8,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(nameLbl,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel9)
                                                                .addComponent(ageLbl,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(registerArrivalBtn)
                                                                .addComponent(
                                                                        searchBtn))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(continueBtn)
                                        .addContainerGap())));
    }

    public void setActions() {
        searchBtn.addActionListener((act) -> {
            selectedPassenger = passengers.get(passengerIdTf.getText());
            if (selectedPassenger != null) {
                if (selectedPassenger.getState() == Passenger.UNLISTED) {
                    ageLbl.setText(String.valueOf(selectedPassenger.getAge()));
                    nameLbl.setText(selectedPassenger.getName());
                    registerArrivalBtn.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "El pasajero ya se encuentra en la lista");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pasajero no encontrado");
            }

        });
        registerArrivalBtn.addActionListener((act) -> {
            registerArrivalBtn.setEnabled(false);
            passengerIdTf.setText("");
            nameLbl.setText("");
            ageLbl.setText("");
            entranceList.insert(selectedPassenger.getPriority(initTime, plane), selectedPassenger);
            model.addElement(selectedPassenger.getName());
            selectedPassenger.setState(Passenger.LISTED);
        });
        continueBtn.addActionListener((act) -> onContinue.change(entranceList));
        helpBtn.addActionListener((act) -> {
            JOptionPane.showMessageDialog(this.getParent(), ""
                    + "Pasajeros presentes: Lista de pasajeros que se han registrado (En orden de llegada).\n"
                    + "Buscar: Busca al parajero, por su ID, en la lista cargada previamente.\n"
                    + "Registrar llegada: Agrega al pasajero a la lista de llegada.\n"
                    + "ID: Número de ID del pasajero a buscar y registrar.\n\n"
                    + "Nota: No es necesario registrar pasajeros para continuar.");
        });
    }

    public MaxHeap<Passenger> getEntranceList() {
        return entranceList;
    }

    public Long getInitTime() {
        return this.initTime;
    }

    public HashTable<String, Passenger> getPassengers() {
        return passengers;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }

    private javax.swing.JLabel ageLbl;
    private javax.swing.JButton continueBtn;
    private javax.swing.JButton helpBtn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField passengerIdTf;
    private javax.swing.JList<String> passengerList;
    private DefaultListModel<String> model;
    private javax.swing.JButton registerArrivalBtn;
    private javax.swing.JButton searchBtn;
}
