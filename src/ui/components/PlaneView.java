package ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import entity.Flight;

public class PlaneView extends JPanel {

    public static final int SELECTED = 2;
    public static final int TAKEN = 1;
    public static final int FREE = 0;

    private Flight flight;

    public PlaneView() {
    }

    public PlaneView(Flight flight) {
        this.flight = flight;
        initPlaneGrid();
    }

    private void initPlaneGrid() {
        int spaceBetween = 3;
        int size = 55;
        int panelWidth = size * flight.getPlane().getColumns() + spaceBetween * (flight.getPlane().getColumns() - 1);
        int panelHeight = size * flight.getPlane().getRows() + spaceBetween * (flight.getPlane().getRows() - 1);
        setLayout(new GridLayout(flight.getPlane().getColumns(), flight.getPlane().getRows(), spaceBetween,
                spaceBetween));
        setSize(panelWidth, panelHeight);
        try {
            LookAndFeel previous = UIManager.getLookAndFeel();
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            for (int i = 0; i < flight.getPlane().getColumns(); i++) {
                for (int index = 0; index < flight.getPlane().getRows(); index++) {
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(size, 20));
                    button.setText((index + 1) + "" + Character.valueOf((char) (65 + i)));
                    button.setFont(new Font("Segoe UI", 1, 11));
                    add(button);
                    if (flight.getPassengers()[index][i] != null) {
                        setSeatAs(index, i, TAKEN);
                    } else {
                        setSeatAs(index, i, FREE);
                    }
                }
            }
            UIManager.setLookAndFeel(previous);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al iniciar la vista del avión");
        }
    }

    public void setSeatAs(int row, int column, int state) {
        int panelIndex = (flight.getPlane().getRows() * column) + row;
        switch (state) {
            case FREE:
                getComponent(panelIndex).setForeground(new Color(245, 245, 245));
                getComponent(panelIndex).setBackground(new Color(50, 200, 50));
                break;
            case TAKEN:
                getComponent(panelIndex).setForeground(new Color(245, 245, 245));
                getComponent(panelIndex).setBackground(new Color(200, 50, 50));
                break;
            case SELECTED:
                getComponent(panelIndex).setForeground(new Color(245, 245, 245));
                getComponent(panelIndex).setBackground(new Color(255, 140, 0));
                break;
            default:
                break;
        }
    }
}
