/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package f7motorparts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class HOMEPAGE extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HOMEPAGE.class.getName());

    /**
     * Creates new form HOMEPAGE
     */
    public HOMEPAGE() {
        initComponents();
    setupItemSuggestions();


        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        customername = new javax.swing.JTextField();
        item = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        total1 = new javax.swing.JLabel();
        bal1 = new javax.swing.JLabel();
        pay1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 58, 95));
        jLabel13.setText("F7 MOTOR PARTS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(80, 80, 80));
        jLabel2.setText("Sales and Inventory System");

        jButton15.setBackground(new java.awt.Color(255, 51, 51));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("INVENTORY");
        jButton15.addActionListener(this::jButton15ActionPerformed1);

        jButton18.setBackground(new java.awt.Color(255, 51, 51));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("SALES RECORDS");
        jButton18.addActionListener(this::jButton18ActionPerformed);

        jButton4.setBackground(new java.awt.Color(30, 58, 95));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOGOUT");
        jButton4.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(71, 71, 71)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
        );

        customername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        customername.setForeground(new java.awt.Color(50, 50, 50));

        item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        item.setForeground(new java.awt.Color(50, 50, 50));

        qty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        qty.setForeground(new java.awt.Color(50, 50, 50));

        price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        price.setForeground(new java.awt.Color(50, 50, 50));
        price.addActionListener(this::priceActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 58, 95));
        jLabel3.setText("Customer Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 58, 95));
        jLabel4.setText("ITEM ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 58, 95));
        jLabel5.setText("QUANTITY");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 58, 95));
        jLabel6.setText("TYPE");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 58, 95));
        jLabel7.setText("PRICE");

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setText("ADD");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 58, 95));
        jLabel11.setText("SIZE");

        typeComboBox.addActionListener(this::typeComboBoxActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 225, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(85, 85, 85))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(153, 255, 51));
        jButton2.setText("DELETE");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUSTOMER NAME", "ITEM", "TYPE", "BRAND", "SIZE", "QUANTITY", "PRICE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setText("PAY");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 58, 95));
        jLabel8.setText("CASH :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 58, 95));
        jLabel9.setText("TOTAL :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 58, 95));
        jLabel10.setText("BALANCE :");

        total1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total1.setForeground(new java.awt.Color(30, 58, 95));
        total1.setText("00");

        bal1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bal1.setForeground(new java.awt.Color(30, 58, 95));
        bal1.setText("00");

        pay1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pay1.setForeground(new java.awt.Color(50, 50, 50));
        pay1.addActionListener(this::pay1ActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pay1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(total1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(bal1))
                .addGap(24, 24, 24))
        );

        jPanel6.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(122, 122, 122))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay1ActionPerformed
private void setupItemSuggestions() {

    item.addKeyListener(new KeyAdapter() {

        @Override
        public void keyReleased(KeyEvent e) {

            String product = item.getText()
                    .trim()
                    .toUpperCase();

            // =========================
            // TIRE
            // =========================
            if (product.contains("TIRE")) {

                // TYPE
                typeComboBox.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT TYPE",
                            "TUBELESS",
                            "TUBE TYPE"
                        }
                    )
                );

                // BRAND
                jComboBox1.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT BRAND",
                            "MICHELIN",
                            "DUNLOP",
                            "BRIDGESTONE",
                            "IRC",
                            "PIRELLI",
                            "MAXXIS",
                            "KENDA",
                            "YOKOHAMA"
                        }
                    )
                );

                // SIZE
                jComboBox2.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT SIZE",
                            "60/90-17",
                            "70/90-17",
                            "80/90-17",
                            "90/80-17",
                            "90/90-17",
                            "100/80-17",
                            "110/70-17",
                            "120/70-17"
                        }
                    )
                );
            }

            // =========================
            // OIL FILTER
            // =========================
            else if (product.contains("OIL FILTER")) {

                // TYPE
                typeComboBox.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT TYPE",
                            "SPIN-ON",
                            "CARTRIDGE"
                        }
                    )
                );

                // BRAND
                jComboBox1.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT BRAND",
                            "BOSCH",
                            "SAKURA",
                            "VIC",
                            "DENSO",
                            "MANN",
                            "WIX"
                        }
                    )
                );

                // SIZE
                jComboBox2.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT SIZE",
                            "SMALL",
                            "MEDIUM",
                            "LARGE"
                        }
                    )
                );
            }

            // =========================
            // PIPE
            // =========================
            else if (product.contains("PIPE")) {

                // TYPE
                typeComboBox.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT TYPE",
                            "PVC",
                            "STEEL",
                            "STAINLESS STEEL",
                            "ALUMINUM"
                        }
                    )
                );

                // BRAND
                jComboBox1.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT BRAND",
                            "PHILPIPE",
                            "NELTEX",
                            "ATLANTIC",
                            "LOCAL"
                        }
                    )
                );

                // SIZE
                jComboBox2.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT SIZE",
                            "1/2 INCH",
                            "3/4 INCH",
                            "1 INCH",
                            "1 1/2 INCH",
                            "2 INCH",
                            "3 INCH",
                            "4 INCH"
                        }
                    )
                );
            }

            // =========================
            // UNKNOWN ITEM
            // =========================
            else {

                typeComboBox.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT TYPE"
                        }
                    )
                );

                jComboBox1.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT BRAND"
                        }
                    )
                );

                jComboBox2.setModel(
                    new javax.swing.DefaultComboBoxModel<>(
                        new String[] {
                            "SELECT SIZE"
                        }
                    )
                );
            }
        }
    });
}



    private void jButton15ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed1
        if (!userSession.isAdmin()) {

        JOptionPane.showMessageDialog(
            this,
            "Access Denied!\n\nOnly administrators can access the Inventory.",
            "Access Denied",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    InventoryForm inventory = new InventoryForm();
    inventory.setLocationRelativeTo(null);
    inventory.setVisible(true);
    this.dispose();
      // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed1

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (!userSession.isAdmin()) {

        JOptionPane.showMessageDialog(
            this,
            "Access Denied!\n\nOnly administrators can access Sales Records.",
            "Access Denied",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    SalesRecordsForm records = new SalesRecordsForm();
    records.setLocationRelativeTo(null);
    records.setVisible(true);
    this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int choice = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to logout?",
            "Logout",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (choice == javax.swing.JOptionPane.YES_OPTION) {
            LoginForm login = new LoginForm();
            login.setVisible(true);
            this.dispose();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        
       String customer = customername.getText().trim();
    String productItem = item.getText().trim();
    String quantityText = qty.getText().trim();
String productType = typeComboBox.getSelectedItem().toString();
String productBrand = jComboBox1.getSelectedItem().toString();
String productSize = jComboBox2.getSelectedItem().toString(); 

String priceText = price.getText().trim();
if (productType.equals("SELECT TYPE")) {

    JOptionPane.showMessageDialog(
        this,
        "Please select type.",
        "Warning",
        JOptionPane.WARNING_MESSAGE
    );

    typeComboBox.requestFocus();
    return;
}

if (productBrand.equals("SELECT BRAND")) {

    JOptionPane.showMessageDialog(
        this,
        "Please select brand.",
        "Warning",
        JOptionPane.WARNING_MESSAGE
    );

    jComboBox1.requestFocus();
    return;
}

if (productSize.equals("SELECT SIZE")) {

    JOptionPane.showMessageDialog(
        this,
        "Please select size.",
        "Warning",
        JOptionPane.WARNING_MESSAGE
    );

    jComboBox2.requestFocus();
    return;
}

    // Validate customer
    if (customer.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Please enter customer name.",
            "Warning",
            JOptionPane.WARNING_MESSAGE
        );
        customername.requestFocus();
        return;
    }

    // Validate item
    if (productItem.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Please enter item.",
            "Warning",
            JOptionPane.WARNING_MESSAGE
        );
        item.requestFocus();
        return;
    }

    // Validate quantity
    if (quantityText.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Please enter quantity.",
            "Warning",
            JOptionPane.WARNING_MESSAGE
        );
        qty.requestFocus();
        return;
    }

    // Validate type
    if (productType.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Please enter type.",
            "Warning",
            JOptionPane.WARNING_MESSAGE
        );
typeComboBox.setSelectedIndex(0);
jComboBox1.setSelectedIndex(0);
jComboBox2.setSelectedIndex(0);        return;
    }

    // Validate price
    if (priceText.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Please enter price.",
            "Warning",
            JOptionPane.WARNING_MESSAGE
        );
        price.requestFocus();
        return;
    }

    try {

        int quantity = Integer.parseInt(quantityText);
        double unitPrice = Double.parseDouble(priceText);

        if (quantity <= 0) {
            JOptionPane.showMessageDialog(
                this,
                "Quantity must be greater than 0.",
                "Invalid Quantity",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (unitPrice < 0) {
            JOptionPane.showMessageDialog(
                this,
                "Price cannot be negative.",
                "Invalid Price",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Get table model
        DefaultTableModel model =
            (DefaultTableModel) jTable1.getModel();

        // Add row
       model.addRow(new Object[]{
    customer,
    productItem,
    productType,
    productBrand,
    productSize,
    quantity,
    String.format("%.2f", unitPrice)
});

        // Calculate total from ALL rows
        double grandTotal = 0;

        for (int row = 0; row < model.getRowCount(); row++) {

           int rowQuantity = Integer.parseInt(
    model.getValueAt(row, 5).toString()
);

double rowPrice = Double.parseDouble(
    model.getValueAt(row, 6).toString()
);

            grandTotal += rowQuantity * rowPrice;
        }

        // Display total
        total1.setText(String.format("%.2f", grandTotal));

        // Clear product fields
        item.setText("");
        qty.setText("");
typeComboBox.setSelectedIndex(0);
jComboBox1.setSelectedIndex(0);
jComboBox2.setSelectedIndex(0);        price.setText("");

        item.requestFocus();

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
            this,
            "Quantity must be a whole number and price must be a valid number.",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE
        );
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        



         DefaultTableModel model =
        (DefaultTableModel) jTable1.getModel();
         
          // Check cart
    if (model.getRowCount() == 0) {

        JOptionPane.showMessageDialog(
            this,
            "Cart is empty!",
            "Payment",
            JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    // CONFIRM PAYMENT
    int confirmPayment = JOptionPane.showConfirmDialog(this, """
                                                             Are you sure you want to proceed with payment?
                                                             
                                                             Please make sure all items and quantities are correct.""",
        "Confirm Payment",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (confirmPayment != JOptionPane.YES_OPTION) {
        return;
    }


    // Check cart
    if (model.getRowCount() == 0) {

        JOptionPane.showMessageDialog(
            this,
            "Cart is empty!",
            "Payment",
            JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    String customer = customername.getText().trim();

    if (customer.isEmpty()) {

        JOptionPane.showMessageDialog(
            this,
            "Please enter customer name.",
            "Payment",
            JOptionPane.WARNING_MESSAGE
        );

        customername.requestFocus();
        return;
    }

    try {

        // Calculate total from JTable
        double total = 0;

        for (int row = 0; row < model.getRowCount(); row++) {

           int quantity = Integer.parseInt(
    model.getValueAt(row, 5).toString()
);

double unitPrice = Double.parseDouble(
    model.getValueAt(row, 6).toString()
);

            total += quantity * unitPrice;
        }

        // Show total
        total1.setText(String.format("%.2f", total));

        // Get cash
        String cashText = pay1.getText().trim();

        if (cashText.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter cash.",
                "Payment",
                JOptionPane.WARNING_MESSAGE
            );

            pay1.requestFocus();
            return;
        }

        double cash = Double.parseDouble(cashText);

        // Check cash
        if (cash < total) {

            double shortage = total - cash;

            JOptionPane.showMessageDialog(
                this,
                String.format(
                    "Insufficient payment!\n"
                    + "You need ₱%.2f more.",
                    shortage
                ),
                "Payment Error",
                JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Calculate balance/change
        double balance = cash - total;

        bal1.setText(String.format("%.2f", balance));

        // Connect database
       Connection con = DBconnection.connect();

if (con == null) {
    JOptionPane.showMessageDialog(
        this,
        "Unable to connect to database.",
        "Database Error",
        JOptionPane.ERROR_MESSAGE
    );
    return;
}

String sql =
    "INSERT INTO sales "
    + "(customer_name, product_name, quantity, type, "
    + "price, total, cash, balance) "
    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

PreparedStatement pst = con.prepareStatement(sql);

        // Save every item
        for (int row = 0; row < model.getRowCount(); row++) {

            String tableCustomer =
                model.getValueAt(row, 0).toString();

            String productName =
                model.getValueAt(row, 1).toString();

           int quantity = Integer.parseInt(
    model.getValueAt(row, 5).toString()
);

String productType =
    model.getValueAt(row, 2).toString();

double unitPrice = Double.parseDouble(
    model.getValueAt(row, 6).toString()
);

            double itemTotal =
                quantity * unitPrice;

            pst.setString(1, tableCustomer);
            pst.setString(2, productName);
            pst.setInt(3, quantity);
            pst.setString(4, productType);
            pst.setDouble(5, unitPrice);
            pst.setDouble(6, itemTotal);
            pst.setDouble(7, cash);
            pst.setDouble(8, balance);

            pst.addBatch();
        }

        pst.executeBatch();

        pst.close();
        con.close();

        // SUCCESS MESSAGE
        JOptionPane.showMessageDialog(
            this,
            String.format(
                "Payment successful!\n\n"
                + "Total: ₱%.2f\n"
                + "Cash: ₱%.2f\n"
                + "Change: ₱%.2f",
                total,
                cash,
                balance
            ),
            "Payment Successful",
            JOptionPane.INFORMATION_MESSAGE
        );
      

        // Clear table
        model.setRowCount(0);

        // Reset fields
        customername.setText("");
        item.setText("");
        qty.setText("");
typeComboBox.setSelectedIndex(0);
jComboBox1.setSelectedIndex(0);
jComboBox2.setSelectedIndex(0);        price.setText("");

        total1.setText("00");
        pay1.setText("");
        bal1.setText("00");

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
            this,
            "Please enter valid numbers.",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE
        );

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            this,
            "Database error:\n" + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );

        e.printStackTrace();
    }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

    int selectedRow = jTable1.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(
            this,
            "Please select an item to delete.",
            "Delete Item",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Get item information
    String productName =
        jTable1.getValueAt(selectedRow, 1).toString();

    int choice = JOptionPane.showConfirmDialog(
        this,
        """
        Are you sure you want to delete this item?
        
        Item: """ + productName,
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );

    if (choice != JOptionPane.YES_OPTION) {
        return;
    }

    DefaultTableModel model =
        (DefaultTableModel) jTable1.getModel();

    // Remove selected row
    model.removeRow(selectedRow);

    // Recalculate total
    double grandTotal = 0;

    for (int row = 0; row < model.getRowCount(); row++) {

        // Column 5 = QUANTITY
        int quantity = Integer.parseInt(
            model.getValueAt(row, 5).toString()
        );

        // Column 6 = PRICE
        double itemPrice = Double.parseDouble(
            model.getValueAt(row, 6).toString()
        );

        grandTotal += quantity * itemPrice;
    }

    // Display updated total
    total1.setText(String.format("%.2f", grandTotal));

    // Reset balance because cart changed
    bal1.setText("00");



        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboBoxActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new HOMEPAGE().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bal1;
    private javax.swing.JTextField customername;
    private javax.swing.JTextField item;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pay1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField qty;
    private javax.swing.JLabel total1;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables
}
