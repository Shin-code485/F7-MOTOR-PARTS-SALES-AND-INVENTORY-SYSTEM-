/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package f7motorparts;

import static com.mysql.cj.conf.PropertyKey.logger;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class SalesForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SalesForm.class.getName());

    /**
     * Creates new form SalesForm
     */
 public SalesForm() {
    initComponents();
    
    
     setupItemSuggestions();
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
}
    

private javax.swing.JPopupMenu suggestionPopup =
        new javax.swing.JPopupMenu();

private javax.swing.JList<String> suggestionList =
        new javax.swing.JList<>();


private void setupItemSuggestions() {


    suggestionList.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    javax.swing.JScrollPane scrollPane =
        new javax.swing.JScrollPane(suggestionList);

    scrollPane.setPreferredSize(
        new java.awt.Dimension(250, 140)
    );

    suggestionPopup.add(scrollPane);

    // Select a product suggestion
    suggestionList.addMouseListener(
        new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                String selected = suggestionList.getSelectedValue();

                if (selected != null) {
                    item.setText(selected);

                    loadItemOptions(selected, true);

                    suggestionPopup.setVisible(false);
                }
            }
        }
    );

    item.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyReleased(java.awt.event.KeyEvent e) {

            if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                return;
            }

            String keyword = item.getText().trim();

            if (keyword.isEmpty()) {
                suggestionPopup.setVisible(false);
                clearItemOptions();
                return;
            }

            // Update the three combo boxes while typing
            loadItemOptions(keyword, false);

            javax.swing.DefaultListModel<String> model =
                new javax.swing.DefaultListModel<>();

            String sql =
                "SELECT DISTINCT product FROM inventory "
                + "WHERE product LIKE ? "
                + "ORDER BY product LIMIT 10";

            try (Connection con = DBconnection.connect()) {

                if (con == null) {
                    suggestionPopup.setVisible(false);
                    return;
                }

                try (PreparedStatement pst = con.prepareStatement(sql)) {

                    pst.setString(1, "%" + keyword + "%");

                    try (ResultSet rs = pst.executeQuery()) {
                        while (rs.next()) {
                            model.addElement(rs.getString("product"));
                        }
                    }
                }

                suggestionList.setModel(model);

                if (!model.isEmpty() && item.isFocusOwner()) {
                    suggestionPopup.show(item, 0, item.getHeight());
                } else {
                    suggestionPopup.setVisible(false);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
}


private void setComboOptions(
        javax.swing.JComboBox<String> combo,
        java.util.Set<String> values,
        String placeholder) {

    combo.removeAllItems();
    combo.addItem(placeholder);

    for (String value : values) {
        combo.addItem(value);
    }

    combo.setSelectedIndex(0);
}


private void clearItemOptions() {

    setComboOptions(
        jComboBox1,
        new java.util.LinkedHashSet<>(),
        "SELECT BRAND"
    );

    setComboOptions(
        typeComboBox,
        new java.util.LinkedHashSet<>(),
        "SELECT TYPE"
    );

    setComboOptions(
        jComboBox2,
        new java.util.LinkedHashSet<>(),
        "SELECT SIZE"
    );
}


   private void loadItemOptions(String product, boolean exactMatch) {

    java.util.Set<String> brands = new java.util.LinkedHashSet<>();
    java.util.Set<String> types = new java.util.LinkedHashSet<>();
    java.util.Set<String> sizes = new java.util.LinkedHashSet<>();

    String sql;

    if (exactMatch) {
        sql = "SELECT DISTINCT brand, type, size "
            + "FROM inventory "
            + "WHERE LOWER(product) = LOWER(?) "
            + "ORDER BY brand, type, size";
    } else {
        sql = "SELECT DISTINCT brand, type, size "
            + "FROM inventory "
            + "WHERE LOWER(product) LIKE LOWER(?) "
            + "ORDER BY brand, type, size";
    }

    try (Connection con = DBconnection.connect()) {

        if (con == null) {
            clearItemOptions();
            return;
        }

        try (PreparedStatement pst = con.prepareStatement(sql)) {

            if (exactMatch) {
                pst.setString(1, product);
            } else {
                pst.setString(1, "%" + product + "%");
            }

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    String brand = rs.getString("brand");
                    String type = rs.getString("type");
                    String size = rs.getString("size");

                    if (brand != null && !brand.trim().isEmpty()) {
                        brands.add(brand);
                    }

                    if (type != null && !type.trim().isEmpty()) {
                        types.add(type);
                    }

                    if (size != null && !size.trim().isEmpty()) {
                        sizes.add(size);
                    }
                }
            }
        }

        setComboOptions(jComboBox1, brands, "SELECT BRAND");
        setComboOptions(typeComboBox, types, "SELECT TYPE");
        setComboOptions(jComboBox2, sizes, "SELECT SIZE");

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        total1 = new javax.swing.JLabel();
        bal1 = new javax.swing.JLabel();
        pay1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        customername = new javax.swing.JTextField();
        item = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(24, 38, 55));

        jPanel4.setBackground(new java.awt.Color(15, 27, 42));

        jButton2.setBackground(new java.awt.Color(200, 16, 46));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DELETE");
        jButton2.setToolTipText("");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(16, 28, 42));

        jButton15.setBackground(new java.awt.Color(24, 38, 55));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("INVENTORY");
        jButton15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton15.addActionListener(this::jButton15ActionPerformed1);

        jButton18.setBackground(new java.awt.Color(24, 38, 55));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("SALES RECORDS");
        jButton18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton18.addActionListener(this::jButton18ActionPerformed);

        jButton4.setBackground(new java.awt.Color(36, 59, 85));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOGOUT");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setBackground(new java.awt.Color(200, 16, 46));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SALES");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("F7 MOTOR PARTS");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jButton6.setBackground(new java.awt.Color(24, 38, 55));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("HOME");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton6.addActionListener(this::jButton6ActionPerformed);

        jButton7.setBackground(new java.awt.Color(24, 38, 55));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("LOGIN HISTORY");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(this::jButton7ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );

        jPanel6.setBackground(new java.awt.Color(200, 16, 46));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("MOTOR PARTS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sales and Inventory System");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 26)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("F7");
        jLabel15.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(200, 16, 46));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(15, 27, 42));

        jButton3.setBackground(new java.awt.Color(32, 196, 99));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PAY");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CASH :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TOTAL :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BALANCE :");

        total1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total1.setForeground(new java.awt.Color(255, 255, 255));
        total1.setText("00");

        bal1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bal1.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pay1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bal1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 713, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(total1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bal1))
                .addGap(33, 33, 33))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(15, 27, 42));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        customername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        customername.setForeground(new java.awt.Color(50, 50, 50));

        item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        item.setForeground(new java.awt.Color(50, 50, 50));

        qty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        qty.setForeground(new java.awt.Color(50, 50, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ITEM ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QUANTITY");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TYPE");

        jButton1.setBackground(new java.awt.Color(32, 196, 99));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SIZE");

        typeComboBox.addActionListener(this::typeComboBoxActionPerformed);

        jPanel9.setBackground(new java.awt.Color(200, 16, 46));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD NEW ITEM");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qty, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(item, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(85, 85, 85))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(236, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton15ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed1
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
        this.dispose();    
    
        // TODO add your handling code here:
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
        }        
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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

    // Confirm payment
    int confirmPayment = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to proceed with payment?\n\n"
        + "Please make sure all items and quantities are correct.",
        "Confirm Payment",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (confirmPayment != JOptionPane.YES_OPTION) {
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

        // Calculate total
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

        // Start transaction
        con.setAutoCommit(false);

        try {

            // ==========================================
            // 1. CHECK AND REDUCE INVENTORY STOCK
            // ==========================================

            String stockSQL =
                "UPDATE inventory "
                + "SET stock = stock - ? "
                + "WHERE LOWER(product) = LOWER(?) "
                + "AND stock >= ?";

            PreparedStatement stockPst =
                con.prepareStatement(stockSQL);

            for (int row = 0; row < model.getRowCount(); row++) {

                String productName =
                    model.getValueAt(row, 1).toString();

                int quantity =
                    Integer.parseInt(
                        model.getValueAt(row, 5).toString()
                    );

                stockPst.setInt(1, quantity);
                stockPst.setString(2, productName);
                stockPst.setInt(3, quantity);

                int updated =
                    stockPst.executeUpdate();

                // If stock was not updated
                if (updated == 0) {

                    throw new SQLException(
                        "Not enough stock for product: "
                        + productName
                    );
                }
            }

            stockPst.close();


            // ==========================================
            // 2. SAVE SALES RECORD
            // ==========================================

            String salesSQL =
                "INSERT INTO sales "
                + "(customer_name, product_name, quantity, type, "
                + "price, total, cash, balance) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement salesPst =
                con.prepareStatement(salesSQL);

            for (int row = 0; row < model.getRowCount(); row++) {

                String tableCustomer =
                    model.getValueAt(row, 0).toString();

                String productName =
                    model.getValueAt(row, 1).toString();

                int quantity =
                    Integer.parseInt(
                        model.getValueAt(row, 5).toString()
                    );

                String productType =
                    model.getValueAt(row, 2).toString();

                double unitPrice =
                    Double.parseDouble(
                        model.getValueAt(row, 6).toString()
                    );

                double itemTotal =
                    quantity * unitPrice;

                salesPst.setString(1, tableCustomer);
                salesPst.setString(2, productName);
                salesPst.setInt(3, quantity);
                salesPst.setString(4, productType);
                salesPst.setDouble(5, unitPrice);
                salesPst.setDouble(6, itemTotal);
                salesPst.setDouble(7, cash);
                salesPst.setDouble(8, balance);

                salesPst.addBatch();
            }

            salesPst.executeBatch();
            salesPst.close();


            // ==========================================
            // 3. SAVE EVERYTHING
            // ==========================================

            con.commit();

            con.setAutoCommit(true);
            con.close();


            // ==========================================
            // 4. SUCCESS
            // ==========================================

            JOptionPane.showMessageDialog(
                this,
                String.format(
                    "Payment successful!\n\n"
                    + "Total: ₱%.2f\n"
                    + "Cash: ₱%.2f\n"
                    + "Change: ₱%.2f\n\n"
                    + "Inventory has been updated.",
                    total,
                    cash,
                    balance
                ),
                "Payment Successful",
                JOptionPane.INFORMATION_MESSAGE
            );


            // Clear cart
            model.setRowCount(0);

            customername.setText("");
            item.setText("");
            qty.setText("");

            typeComboBox.setSelectedIndex(0);
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);

            total1.setText("00");
            pay1.setText("");
            bal1.setText("00");


        } catch (SQLException e) {

            // Undo everything if something fails
            con.rollback();
            con.setAutoCommit(true);
            con.close();

            JOptionPane.showMessageDialog(
                this,
                "Payment failed:\n" + e.getMessage(),
                "Payment Error",
                JOptionPane.ERROR_MESSAGE
            );
        }

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

    private void pay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay1ActionPerformed

private double getInventoryPrice(String product) {

    String sql =
        "SELECT price FROM inventory "
        + "WHERE LOWER(product) = LOWER(?) LIMIT 1";

    try (Connection con = DBconnection.connect()) {

        if (con == null) {
            return -1;
        }

        try (PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, product);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    return rs.getDouble("price");
                }
            }
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
            this,
            "Unable to get product price:\n"
                + ex.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    return -1;
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:


    String customer = customername.getText().trim();
    String productItem = item.getText().trim();
    String quantityText = qty.getText().trim();

    String productType =
        typeComboBox.getSelectedItem().toString();

    String productBrand =
        jComboBox1.getSelectedItem().toString();

    String productSize =
        jComboBox2.getSelectedItem().toString();


    // =========================
    // VALIDATION
    // =========================

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


    try {

        int quantity = Integer.parseInt(quantityText);

        if (quantity <= 0) {
            JOptionPane.showMessageDialog(
                this,
                "Quantity must be greater than 0.",
                "Invalid Quantity",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }


        // =========================
        // CHECK INVENTORY
        // =========================

        if (!checkInventoryStock(productItem, quantity)) {
            return;
        }


        // =========================
        // ADD TO CART
        // =========================

     
double productPrice = getInventoryPrice(productItem);

if (productPrice < 0) {
    JOptionPane.showMessageDialog(
        this,
        "Unable to retrieve product price.",
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
    return;
}

DefaultTableModel model =
    (DefaultTableModel) jTable1.getModel();

model.addRow(new Object[]{
    customer,
    productItem,
    productType,
    productBrand,
    productSize,
    quantity,
    productPrice
});



        // =========================
        // CALCULATE TOTAL
        // =========================

        double grandTotal = 0;

        for (int row = 0; row < model.getRowCount(); row++) {

            int rowQuantity =
                Integer.parseInt(
                    model.getValueAt(row, 5).toString()
                );

            double rowPrice =
                Double.parseDouble(
                    model.getValueAt(row, 6).toString()
                );

            grandTotal += rowQuantity * rowPrice;
        }

        total1.setText(
            String.format("%.2f", grandTotal)
        );


        // =========================
        // CLEAR PRODUCT INPUTS
        // =========================

        item.setText("");
        qty.setText("");

        typeComboBox.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);


        item.requestFocus();


    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
            this,
            "Quantity must be a whole number.",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE
        );

    }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboBoxActionPerformed

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
            "Are you sure you want to delete this item?\n\n"
            + "Item: " + productName,
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
private boolean checkInventoryStock(String product, int quantity) {

    String sql = "SELECT price, stock FROM inventory WHERE LOWER(product) = LOWER(?)";

    try {

        Connection con = DBconnection.connect();

        if (con == null) {
            JOptionPane.showMessageDialog(
                this,
                "Unable to connect to database.",
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, product);

        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {

            JOptionPane.showMessageDialog(
                this,
                "Product '" + product + "' was not found in inventory.",
                "Product Not Found",
                JOptionPane.WARNING_MESSAGE
            );

            rs.close();
            pst.close();
            con.close();

            return false;
        }

        double inventoryPrice = rs.getDouble("price");
        int stock = rs.getInt("stock");

        if (quantity > stock) {

            JOptionPane.showMessageDialog(
                this,
                "Not enough stock!\n\n"
                + "Product: " + product + "\n"
                + "Available Stock: " + stock + "\n"
                + "Requested Quantity: " + quantity,
                "Insufficient Stock",
                JOptionPane.WARNING_MESSAGE
            );

            rs.close();
            pst.close();
            con.close();

            return false;
        }

        // Use inventory price

        rs.close();
        pst.close();
        con.close();

        return true;

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            this,
            "Unable to check inventory:\n" + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );

        return false;
    }
}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        HomeForm home = new HomeForm();
        home.setVisible(true);
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        LoginHistoryForm LoginHistory = new LoginHistoryForm();
        LoginHistory.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new SalesForm().setVisible(true));
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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pay1;
    private javax.swing.JTextField qty;
    private javax.swing.JLabel total1;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables

}