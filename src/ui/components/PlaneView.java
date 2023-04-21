package ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import entity.Flight;

public class PlaneView extends JPanel {

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
        int size = 50;
        int panelWidth = size * flight.getPlane().getColumns() + spaceBetween * (flight.getPlane().getColumns() - 1);
        int panelHeight = size * flight.getPlane().getRows() + spaceBetween * (flight.getPlane().getRows() - 1);

        setLayout(new GridLayout(flight.getPlane().getColumns(), flight.getPlane().getRows(), spaceBetween,
                spaceBetween));
        setSize(panelWidth, panelHeight);
        for (int i = 0; i < flight.getPlane().getColumns(); i++) {
            for (int index = 0; index < flight.getPlane().getRows(); index++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(size, 20));
                button.setFont(new Font("Segoe UI", 0, 8));
                button.setText((index + 1) + "" + Character.valueOf((char) (65 + i)));
                add(button);
            }
        }
    }

    public void setSeatAs(int row, int column, int state) {
        int panelIndex = (flight.getPlane().getRows() * column) + row;
        switch (state) {
            case FREE:
                break;
            case TAKEN:
                getComponent(panelIndex).setFont(new Font("Segoe UI", 1, 8));
                getComponent(panelIndex).setForeground(new Color(50, 200, 50));
                break;
            default:
                break;
        }
    }
}
