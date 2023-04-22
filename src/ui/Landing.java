package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Flight;
import entity.Passenger;
import ui.components.PlaneView;
import utils.Storage;

public class Landing extends javax.swing.JFrame {

    private Flight flight;
    private Passenger currentPassenger;
    int currentX;
    int currentY;

    public Landing(String flightPath) throws FileNotFoundException, IOException {
        flight = Storage.loadJsonFrom(flightPath, Flight.class);
        initComponents();
        currentX = -1;
        currentY = 0;
        nextPassenger();
        setActions();
    }

    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        seatLbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        leftBtn = new javax.swing.JButton();
        planeView = new PlaneView(flight);
        jScrollPane4.setViewportView(planeView);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Pasajero actual");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Asiento:");

        leftBtn.setText("Salió");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 538, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(75, 75, 75)
                                                        .addComponent(jLabel11)
                                                        .addGap(47, 47, 47))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(leftBtn)
                                                                        .addGap(156, 159, Short.MAX_VALUE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel12)
                                                                                .addComponent(jLabel14))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(seatLbl,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(nameLbl,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))))))
                                        .addContainerGap())));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 351, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addComponent(jLabel11)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(nameLbl,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel12))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel14,
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(seatLbl,
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(leftBtn)
                                                        .addGap(249, 249, 249))
                                                .addComponent(jScrollPane4))
                                        .addContainerGap())));

        pack();
    }

    public void setActions() {
        leftBtn.addActionListener((act) -> {
            if (currentPassenger != null) {
                flight.setOnBoard(flight.getOnBoard() - 1);
                flight.getPassengers()[currentY][currentX] = null;
                planeView.setSeatAs(currentY, currentX, PlaneView.FREE);
                Storage.saveJsonTo(Flight.PATH + flight.getPlane().getId() + ".txt", flight);
                nextPassenger();
            }
        });
    }

    public void nextPassenger() {
        nextX();
        for (; currentY < flight.getPlane().getRows(); currentY++) {
            currentPassenger = flight.getPassengers()[currentY][currentX];
            if (currentPassenger != null) {
                planeView.setSeatAs(currentY, currentX, PlaneView.SELECTED);
                nameLbl.setText(currentPassenger.getName());
                seatLbl.setText(currentPassenger.getSeat().toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Descenso terminado.\nNo hay más pasajeros a bordo.");
        Storage.deleteFile(Flight.PATH + flight.getPlane().getId() + ".txt");
        dispose();
    }

    public void nextX() {
        if (currentX == -1) {
            currentX = flight.getPlane().getColumns() / 2 - 1;
            return;
        }
        int middleLeft = flight.getPlane().getColumns() / 2 - 1;
        if (currentX <= middleLeft) {
            currentX = middleLeft + Math.abs(middleLeft - currentX) + 1;
        } else {
            if (currentX != flight.getPlane().getColumns() - 1) {
                currentX = middleLeft - Math.abs(middleLeft - currentX);
            } else {
                currentX = middleLeft;
            }
        }
    }

    public void init() {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setAlwaysOnTop(true);
    }

    public static void run(String path) {
        try {
            Landing landing = new Landing(path);
            landing.init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Archivo inválido");
        }
    }

    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton leftBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel seatLbl;
    private PlaneView planeView;
}
