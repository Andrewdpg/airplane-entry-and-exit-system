package ui;

import entity.Passenger;
import entity.Plane;
import ui.tabs.Arrival;
import ui.tabs.Entrance;
import ui.tabs.Home;
import ui.tabs.Passengers;
import utils.HashTable;

public class Window extends javax.swing.JFrame {

    public Window() {
        init();
        initComponents();
    }

    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();

        homeTab = new Home((plane) -> homeChangeTab(plane));
        tabs.addTab("Inicio", homeTab);
        tabs.addTab("Pasajeros", new Passengers());
        tabs.addTab("Llegada", new Arrival());
        tabs.addTab("Entrada", new Entrance());
        tabs.setEnabledAt(1, false);
        tabs.setEnabledAt(2, false);
        tabs.setEnabledAt(3, false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tabs,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tabs,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }

    public void init() {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void homeChangeTab(Plane plane) {
        passengersTab = new Passengers((passengers) -> passengersChangeTab(passengers));
        passengersTab.setPlane(plane);
        tabs.setComponentAt(1, passengersTab);
        tabs.setSelectedIndex(1);
    }

    private void passengersChangeTab(HashTable<String, Passenger> passengers) {
        arrivalTab = new Arrival(passengers, (none) -> arrivalChangeTab());
        arrivalTab.setPlane(passengersTab.getPlane());
        tabs.setComponentAt(2, arrivalTab);
        tabs.setSelectedIndex(2);
    }

    private void arrivalChangeTab() {
        entranceTab = new Entrance();
        tabs.setComponentAt(3, entranceTab);
        tabs.setSelectedIndex(3);
    }

    private javax.swing.JTabbedPane tabs;
    private Home homeTab;
    private Passengers passengersTab;
    private Arrival arrivalTab;
    private Entrance entranceTab;
}
