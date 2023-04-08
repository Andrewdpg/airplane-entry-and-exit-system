package ui.tabs;

import entity.Passenger;

public class Passengers extends javax.swing.JPanel {

	public Passengers() {
		initComponents();
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
		pathTf.setText("");
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
