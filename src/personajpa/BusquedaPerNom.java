/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajpa;

import controlador.Client_Controller;
import controlador.Persona_Controller;
import controlador.Polissa_Controller;
import controlador.Usuari_Controller;
import controlador.Vehicle_Controller;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Adreca;
import modelo.Client;
import modelo.Persona;
import modelo.Polissa;
import modelo.Vehicle;

/**
 *
 * @author Jorge
 */
public class BusquedaPerNom extends javax.swing.JFrame {

    Client_Controller cc = new Client_Controller();
    Client cli;
    Vehicle vehi;
    Vehicle_Controller vc = new Vehicle_Controller();
    Polissa_Controller pc = new Polissa_Controller();

    /**
     * Creates new form BusquedaPerNom
     */
    public BusquedaPerNom() {
        initComponents();
        BuidarTabla();
    }

    private void BuidarCamps() {
        tfNom.setText("");
        tfNif.setText("");
        tfId.setText("");
        tfCarrer.setText("");
        tfCarrer.setText("");
        tfNum.setText("");
        tfPoblacio.setText("");
        campBusquedaNom.setText("");
        tfAnyFabricacio.setText("");
        tfIDVehicle.setText("");
        tfMatricula.setText("");
        tfMarcaModel.setText("");
        tfPropietari.setText("");
        campBusquedaMatriculaVehicle.setText("");
    }

    private void BuidarTabla() {
        String col[] = {"IDVehicle", "Matricula", "MarcaModel", "AnyFabricacio"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        taulaVehicles.setModel(tableModel);           
        String colPolissa[] = {"IDPolissa", "Numero", "Vehicle", "ClientID", "DataInici", "DataFi", "Tipus", "Prima", "AsseguradoraID"};
        DefaultTableModel tablePolissa = new DefaultTableModel(colPolissa, 0);
        taulaPolissa.setModel(tablePolissa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNom = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        tfNif = new javax.swing.JTextField();
        jLabelId = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCarrer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNum = new javax.swing.JTextField();
        tfPoblacio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        campBusquedaNom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taulaPolissa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        taulaVehicles = new javax.swing.JTable();
        btnAfegir = new javax.swing.JButton();
        btnNetejar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfMarcaModel = new javax.swing.JTextField();
        tfIDVehicle = new javax.swing.JTextField();
        jLabelId2 = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfAnyFabricacio = new javax.swing.JTextField();
        tfPropietari = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        campBusquedaMatriculaVehicle = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnAfegir2 = new javax.swing.JButton();
        btnNetejar2 = new javax.swing.JButton();
        jLabelId3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("nom");

        tfNom.setToolTipText("");
        tfNom.setName(""); // NOI18N
        tfNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomActionPerformed(evt);
            }
        });

        jLabel.setText("Nif");

        jLabelId.setText("id");

        jLabel5.setText("carrer");

        jLabel6.setText("numero");

        jLabel7.setText("poblacio");

        jButton1.setText("Buscar per nom");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Nom a buscar:");

        taulaPolissa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "IDPolissa"
            }
        ));
        jScrollPane1.setViewportView(taulaPolissa);

        taulaVehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "IDVehicle"
            }
        ));
        jScrollPane2.setViewportView(taulaVehicles);

        btnAfegir.setText("Afegir");
        btnAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirActionPerformed(evt);
            }
        });

        btnNetejar.setText("Netejar");
        btnNetejar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetejarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campBusquedaNom, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabelId)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel)
                                            .addGap(7, 7, 7))
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfNom)
                                        .addComponent(tfPoblacio)
                                        .addComponent(tfNum)
                                        .addComponent(tfCarrer)
                                        .addComponent(tfId)
                                        .addComponent(tfNif, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(116, 116, 116)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnNetejar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAfegir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel)
                        .addComponent(tfNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelId)
                        .addComponent(btnAfegir))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNetejar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tfCarrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tfPoblacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(campBusquedaNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addGap(47, 47, 47)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Clients", jPanel3);

        jLabel4.setText("MarcaModel");

        tfMarcaModel.setToolTipText("");
        tfMarcaModel.setName(""); // NOI18N
        tfMarcaModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMarcaModelActionPerformed(evt);
            }
        });

        jLabelId2.setText("Matricula");

        jLabel14.setText("AnyFabricacio");

        jLabel15.setText("Propietari");

        jButton3.setText("Buscar per Matricula");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setText("Matricula de vehicle a buscar:");

        btnAfegir2.setText("Afegir");
        btnAfegir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegir2ActionPerformed(evt);
            }
        });

        btnNetejar2.setText("Netejar");
        btnNetejar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetejar2ActionPerformed(evt);
            }
        });

        jLabelId3.setText("ID");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabelId3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campBusquedaMatriculaVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(235, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14)
                        .addComponent(jLabelId2)
                        .addComponent(jLabel4))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfMarcaModel)
                        .addComponent(tfPropietari)
                        .addComponent(tfAnyFabricacio)
                        .addComponent(tfMatricula)
                        .addComponent(tfIDVehicle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(116, 116, 116)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnNetejar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAfegir2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(51, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelId3)
                .addGap(162, 162, 162)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campBusquedaMatriculaVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel17))
                .addContainerGap(299, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tfIDVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelId2)
                        .addComponent(btnAfegir2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(tfMarcaModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNetejar2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(tfAnyFabricacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(tfPropietari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(358, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Vehicles", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Polissas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        campBusquedaNom.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = campBusquedaNom.getText();
        cli = cc.BuscarPerNom(nombre);
        tfNom.setText(cli.getNom());
        tfId.setText(Long.toString(cli.getId()));
        tfNif.setText(cli.getNif());
        tfCarrer.setText(cli.getAdreca().getCarrer());
        tfNum.setText(Integer.toString(cli.getAdreca().getNumero()));
        tfPoblacio.setText(cli.getAdreca().getPoblacio());

        List<Vehicle> listaVehicles = cc.obtenirVehiclesClient(cli.getId());
        String colVehicles[] = {"IDVehicle", "Matricula", "MarcaModel", "AnyFabricacio"};
        DefaultTableModel tableVehicle = new DefaultTableModel(colVehicles, 0);
        taulaVehicles.setModel(tableVehicle);

        for (Vehicle vehicle : listaVehicles) {
            tableVehicle.addRow(new Object[]{vehicle.getVehicleId(),
                vehicle.getMatricula(), vehicle.getMarcaModel(), vehicle.getAnyFabricacio()});

        }
        List<Polissa> listaPolissas = pc.BuscarPerClientLlista(cli.getId());
        String colPolissa[] = {"IDPolissa", "Numero", "Vehicle", "ClientID", "DataInici", "DataFi", "Tipus", "Prima", "AsseguradoraID"};
        DefaultTableModel tablePolissa = new DefaultTableModel(colPolissa, 0);
        taulaPolissa.setModel(tablePolissa);
        for (Polissa polissa : listaPolissas) {
            tablePolissa.addRow(new Object[]{polissa.getIdPolissa(),
                polissa.getNumero(), polissa.getVehicle().getVehicleId(),
                polissa.getCliente().getId(), polissa.getDataInici(), polissa.getDataFi(), polissa.isTipus(),
                polissa.getPrima(), polissa.getAsseguradora().getAsseguradoraId()
            });
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNetejarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetejarActionPerformed
        BuidarCamps();
        BuidarTabla();        
    }//GEN-LAST:event_btnNetejarActionPerformed

    private void btnAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirActionPerformed
        Adreca afegirAdreca = new Adreca(tfCarrer.getText(),Integer.parseInt(tfNum.getText()),tfPoblacio.getText());
        Client afegir = new Client(0,tfNif.getText(), tfNom.getText(),afegirAdreca);
        cc.Insertar(afegir);
    }//GEN-LAST:event_btnAfegirActionPerformed

    private void tfMarcaModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMarcaModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMarcaModelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String matricula = campBusquedaMatriculaVehicle.getText();
        vehi = vc.cercaVehicleMatricula(matricula);
        tfIDVehicle.setText(Long.toString(vehi.getVehicleId()));
        tfMatricula.setText(vehi.getMatricula());
        tfMarcaModel.setText(vehi.getMarcaModel());
        tfAnyFabricacio.setText(Integer.toString(vehi.getAnyFabricacio()));
        tfPropietari.setText(Long.toString(vehi.getPropietari().getId()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAfegir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegir2ActionPerformed
        Client cliAfegir = cc.Buscar(Long.parseLong(tfPropietari.getText()));
        Vehicle afegir = new Vehicle(0, tfMatricula.getText(), tfMarcaModel.getText(), Integer.parseInt(tfAnyFabricacio.getText()), cliAfegir, null);
        vc.Insertar(afegir);
    }//GEN-LAST:event_btnAfegir2ActionPerformed

    private void btnNetejar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetejar2ActionPerformed
        BuidarCamps();
    }//GEN-LAST:event_btnNetejar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusquedaPerNom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaPerNom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaPerNom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaPerNom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaPerNom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfegir;
    private javax.swing.JButton btnAfegir2;
    private javax.swing.JButton btnNetejar;
    private javax.swing.JButton btnNetejar2;
    private javax.swing.JTextField campBusquedaMatriculaVehicle;
    private javax.swing.JTextField campBusquedaNom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelId2;
    private javax.swing.JLabel jLabelId3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable taulaPolissa;
    private javax.swing.JTable taulaVehicles;
    private javax.swing.JTextField tfAnyFabricacio;
    private javax.swing.JTextField tfCarrer;
    private javax.swing.JTextField tfIDVehicle;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfMarcaModel;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNif;
    private javax.swing.JTextField tfNom;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfPoblacio;
    private javax.swing.JTextField tfPropietari;
    // End of variables declaration//GEN-END:variables
}
