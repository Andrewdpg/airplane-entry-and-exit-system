package ui.tabs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import entity.Location;
import entity.Passenger;
import entity.Plane;
import entity.Seat;
import entity.enums.PassengerPreference;
import entity.enums.SeatType;
import exception.InvalidPassengerException;
import lambda.ChangeTab;
import utils.HashTable;

/**
 * @author Andrewpg
 */
public class Passengers extends javax.swing.JPanel {

	private ChangeTab<HashTable<String, Passenger>> onContinue;
	private HashTable<String, Passenger> passengers;
	private Plane plane;

	public Passengers(Plane plane) {
		initComponents();
		setActions();
		this.plane = plane;
	}

	public Passengers(Plane plane, ChangeTab<HashTable<String, Passenger>> onContinue) {
		initComponents();
		setActions();
		this.onContinue = onContinue;
		this.plane = plane;
	}

	private void initComponents() {
		pathTf = new javax.swing.JTextField();
		pathLbl = new javax.swing.JLabel();
		rowCountLbl = new javax.swing.JLabel();
		tableScroll = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		title = new javax.swing.JLabel();
		fileBtn = new javax.swing.JButton();
		goBtn = new javax.swing.JButton();
		continueBtn = new javax.swing.JButton();
		clearBtn = new javax.swing.JButton();
		model = new javax.swing.table.DefaultTableModel(null,
				Passenger.headers()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		title.setText("CARGAR LISTA DE PASAJEROS");
		pathLbl.setText("Ruta al archivo:");
		pathTf.setText("data/Passengers.txt");
		rowCountLbl.setText("Número de pasajeros: 0");
		fileBtn.setText("Archivo");
		goBtn.setText("Ir");
		continueBtn.setText("Continuar");
		clearBtn.setText("Limpiar");
		table.setModel(model);
		tableScroll.setViewportView(table);

		javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(this);
		setLayout(panelLayout);
		panelLayout.setHorizontalGroup(
				panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelLayout.createSequentialGroup()
								.addGroup(panelLayout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(panelLayout
												.createSequentialGroup()
												.addGap(149, 149, 149)
												.addComponent(title))
										.addGroup(panelLayout
												.createSequentialGroup()
												.addContainerGap()
												.addComponent(pathLbl)
												.addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(pathTf,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														282,
														Short.MAX_VALUE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(goBtn)
								.addGap(5, 5, 5)
								.addComponent(fileBtn)
								.addGap(12, 12, 12))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout
								.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(clearBtn)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(continueBtn)
								.addGap(7, 7, 7))
						.addGroup(panelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(rowCountLbl,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										0, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(panelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tableScroll,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										0, Short.MAX_VALUE)
								.addContainerGap()));
		panelLayout.setVerticalGroup(
				panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(title)
								.addGap(18, 18, 18)
								.addGroup(panelLayout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(pathLbl)
										.addComponent(pathTf,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(goBtn)
										.addComponent(fileBtn))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(rowCountLbl,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										223,
										javax.swing.GroupLayout.DEFAULT_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(tableScroll,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										223,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelLayout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(clearBtn)
										.addComponent(continueBtn))
								.addContainerGap()));
	}

	public void setActions() {
		fileBtn.addActionListener((act) -> {
			JFileChooser chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				if (chooser.getSelectedFile() == null) {
					return;
				}
				pathTf.setText(chooser.getSelectedFile().getPath());
				loadPassengers(chooser.getSelectedFile().getPath());
			}
		});
		pathTf.addActionListener((act) -> {
			loadPassengers(pathTf.getText());
		});
		goBtn.addActionListener((act) -> {
			loadPassengers(pathTf.getText());
		});
		clearBtn.addActionListener((act) -> {
			passengers = null;
			model.setRowCount(0);
		});
		model.addTableModelListener((l) -> {
			rowCountLbl.setText("Número de pasajeros: " + model.getRowCount());
		});
		continueBtn.addActionListener((act) -> {
			if (passengers == null) {
				JOptionPane.showMessageDialog(null, "Debes proporcionar una lista de pasajeros");
				return;
			}
			onContinue.change(passengers);
		});
	}

	public void loadPassengers(String path) {
		try {
			model.setRowCount(0);
			System.out.println(passengers);
			passengers = null;
			passengers = loadPassengersTxtFrom(path);
			System.out.println(passengers);
			rowCountLbl.setText("Número de pasajeros: " + model.getRowCount());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ruta inválida");
		} catch (InvalidPassengerException e) {
			passengers = null;
			model.setRowCount(0);
			JOptionPane.showMessageDialog(this, "El pasajero " + e.getPassenger().getName()
					+ " tiene un número de silla inválido (" + e.getPassenger().getSeat().toString() + ")"
					+ "En un vuelo de " + plane.getRows() + " filas y " + plane.getColumns() + " Columnas",
					"Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "El archivo seleccionado tiene un formato inválido");
		}
	}

	public HashTable<String, Passenger> loadPassengersTxtFrom(String path)
			throws IOException, FileNotFoundException, InvalidPassengerException {
		File file = new File(path);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		HashTable<String, Passenger> hashTable = new HashTable<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			
			Passenger passenger = new Passenger();
			passenger.setName(line.split(";")[0]);
			passenger.setId(line.split(";")[1]);
			passenger.setNationality(line.split(";")[2]);
			passenger.setBirthday(LocalDate.of(Integer.parseInt(line.split(";")[3].split("/")[2]),
					Integer.parseInt(line.split(";")[3].split("/")[1]),
					Integer.parseInt(line.split(";")[3].split("/")[0])));
			passenger.setSeat(new Seat(SeatType.values()[Integer.parseInt(
					line.split(";")[5])], new Location(
							Integer.parseInt(line.split(";")[7]), line.split(";")[6])));
			passenger.setPreference(PassengerPreference.values()[Integer.parseInt(
					line.split(";")[8])]);
			hashTable.put(passenger.getId(), passenger);
			loadToTable(passenger);
		}
		reader.close();
		if(hashTable.size() == 0){
			return null;
		}
		return hashTable;
	}

	public void loadToTable(Passenger passenger) throws InvalidPassengerException {
		if (passenger.getSeat().getLocation().getColumnValue() > plane.getColumns() ||
				passenger.getSeat().getLocation().getRow() > plane.getRows()) {
			throw new InvalidPassengerException(passenger);
		}
		model.addRow(passenger.getTableData());
	}

	private javax.swing.JButton continueBtn;
	private javax.swing.JButton fileBtn;
	private javax.swing.JButton goBtn;
	private javax.swing.JButton clearBtn;
	private javax.swing.JLabel pathLbl;
	private javax.swing.JLabel title;
	private javax.swing.JLabel rowCountLbl;
	private javax.swing.JScrollPane tableScroll;
	private javax.swing.JTable table;
	private javax.swing.JTextField pathTf;
	private javax.swing.table.DefaultTableModel model;
}