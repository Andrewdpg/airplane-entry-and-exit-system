package ui;

import ui.tabs.Arrival;
import ui.tabs.Home;
import ui.tabs.Passengers;

public class Window extends javax.swing.JFrame {

    public Window() {
        init();
        initComponents();
    }

    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();

        homeTab = new Home((plane) -> {
            passengersTab = new Passengers(plane, (passengers) -> {
                arrivalTab = new Arrival(passengers);
                tabs.setComponentAt(2, arrivalTab);
                tabs.setSelectedIndex(2);
            });
            tabs.setComponentAt(1, passengersTab);
            tabs.setSelectedIndex(1);
        });
        tabs.addTab("Inicio", homeTab);
        tabs.addTab("Pasajeros", new Passengers(null));
        tabs.addTab("Llegada", new Arrival(null));
        tabs.setEnabledAt(1, false);
        tabs.setEnabledAt(2, false);

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

    private javax.swing.JTabbedPane tabs;
    private Home homeTab;
    private Passengers passengersTab;
    private Arrival arrivalTab;
}
