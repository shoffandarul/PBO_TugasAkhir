/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gudang.GUI;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import gudang.Tools.DBConnection;

/**
 *
 * @author Shoffan Darul Mufti
 */
public class BarangKeluar extends javax.swing.JFrame {

    DefaultTableModel tblmodel;
    Connection conn;
    
    /**
     * Creates new form BarangMasuk
     */
    public BarangKeluar() {
        initComponents();
        
        DBConnection openconn = new DBConnection();
        this.conn = openconn.create_connection();
        
        this.tblmodel = (DefaultTableModel)TblBarangMasuk.getModel(); //check
        
        this.load_data();
        this.load_barang(); // check
        this.load_karyawan(); // check
    }
    
    public void reset_table(){
        int rowCount = this.tblmodel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            this.tblmodel.removeRow(i);
        }
    }
    
    public void load_data(){
        try {
            String sql = "select * from barang_masuk"; //check
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            this.reset_table();
            
            while (result.next()) {                
                String id = result.getString(1); //check
                String idBarang = result.getString(2); //check
                String namaBarang = load_barang_by_id(idBarang); //check
                String tanggalMasuk = result.getString(3); //check
                String idKaryawan = result.getString(4); //check
                String namaKaryawan = load_karyawan_by_id(idKaryawan);
                String dataBarangMasuk[] = {id, (idBarang + " | " + namaBarang), tanggalMasuk, (idKaryawan + " | " + namaKaryawan)}; //check

                this.tblmodel.addRow(dataBarangMasuk); //check
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void load_barang() {
        try {
            try {
                String sql = "select * from barang"; //check
                Statement statement = this.conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    String idBarang = result.getString(1); //check
                    String namaBarang = result.getString(3); //check
                    CmbIDBarang.addItem(idBarang + " | " + namaBarang); //check
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String load_barang_by_id(String id) {
        try {
            try {
                String sql = "select * from barang where id_barang = " + id; //check
                Statement statement = this.conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                result.next();
                return result.getString(3); //check
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void load_karyawan() {
        try {
            try {
                String sql = "select * from karyawan"; //check
                Statement statement = this.conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {    
                    String idKaryawan = result.getString(1); //check
                    String namaKaryawan = result.getString(2); //check
                    CmbIDKaryawan.addItem(idKaryawan + " | " + namaKaryawan); //check
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String load_karyawan_by_id(String id) {
        try {
            try {
                String sql = "select * from karyawan where id_karyawan = " + id; //check
                Statement statement = this.conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                result.next();
                return result.getString(2); //check
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void clear_txtfield() {
        TxtIDBarangMasuk.setText(""); //check
        CmbIDBarang.setSelectedIndex(0); //check
        TxtTanggalMasuk.setText(""); //check
        CmbIDKaryawan.setSelectedIndex(0); //check
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblBarangMasuk = new javax.swing.JTable();
        BtnInsert = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TxtIDBarangMasuk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CmbIDBarang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtTanggalMasuk = new javax.swing.JTextField();
        CmbIDKaryawan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuForms = new javax.swing.JMenu();
        MenuTipeBarang = new javax.swing.JMenuItem();
        MenuKaryawan = new javax.swing.JMenuItem();
        MenuBarang = new javax.swing.JMenuItem();
        MenuBarangMasuk = new javax.swing.JMenuItem();
        MenuBarangKeluar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Product Sans", 1, 24)); // NOI18N
        jLabel1.setText("BARANG MASUK");

        TblBarangMasuk.setFont(new java.awt.Font("Product Sans", 0, 12)); // NOI18N
        TblBarangMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ID BARANG", "TANGGAL MASUK", "ID KARYAWAN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblBarangMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblBarangMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblBarangMasuk);

        BtnInsert.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        BtnInsert.setText("INSERT");
        BtnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertActionPerformed(evt);
            }
        });

        BtnUpdate.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        BtnUpdate.setText("UPDATE");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        BtnDelete.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        BtnDelete.setText("DELETE");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel2.setText("ID");

        TxtIDBarangMasuk.setEditable(false);
        TxtIDBarangMasuk.setBackground(new java.awt.Color(204, 204, 204));
        TxtIDBarangMasuk.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel3.setText("ID Barang");

        CmbIDBarang.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        CmbIDBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        CmbIDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIDBarangActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel4.setText("Tanggal Masuk");

        jLabel5.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel5.setText("ID Karyawan");

        TxtTanggalMasuk.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        CmbIDKaryawan.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        CmbIDKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));

        jLabel6.setFont(new java.awt.Font("Product Sans", 2, 12)); // NOI18N
        jLabel6.setText("Format yyyy-MM-dd HH:mm:ss");

        jLabel7.setFont(new java.awt.Font("Product Sans", 2, 12)); // NOI18N
        jLabel7.setText("Otomatis Terbuat");

        jMenu1.setText("File");

        MenuForms.setText("Forms");

        MenuTipeBarang.setText("Tipe Barang");
        MenuTipeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTipeBarangActionPerformed(evt);
            }
        });
        MenuForms.add(MenuTipeBarang);

        MenuKaryawan.setText("Karyawan");
        MenuKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuKaryawanActionPerformed(evt);
            }
        });
        MenuForms.add(MenuKaryawan);

        MenuBarang.setText("Barang");
        MenuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBarangActionPerformed(evt);
            }
        });
        MenuForms.add(MenuBarang);

        MenuBarangMasuk.setText("Barang Masuk");
        MenuBarangMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBarangMasukActionPerformed(evt);
            }
        });
        MenuForms.add(MenuBarangMasuk);

        MenuBarangKeluar.setText("Barang Keluar");
        MenuBarangKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBarangKeluarActionPerformed(evt);
            }
        });
        MenuForms.add(MenuBarangKeluar);

        jMenu1.add(MenuForms);
        jMenu1.add(jSeparator2);

        MenuExit.setText("Exit");
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(MenuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        MenuAbout.setText("About this project");
        MenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAboutActionPerformed(evt);
            }
        });
        jMenu2.add(MenuAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CmbIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtIDBarangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtIDBarangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CmbIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuTipeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTipeBarangActionPerformed
        try {
            new TipeBarang().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuTipeBarangActionPerformed

    private void BtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertActionPerformed
        try {
            String[] barang = String.valueOf(CmbIDBarang.getSelectedItem()).split(" | "); //check
            String idBarang = barang[0]; //check
            String tanggalMasuk = TxtTanggalMasuk.getText(); //check //check
            String[] karyawan = String.valueOf(CmbIDKaryawan.getSelectedItem()).split(" | "); //check
            String idKaryawan = karyawan[0]; //check
            
            String sql = "insert into barang_masuk (id_barang, tanggal_masuk, id_karyawan) values (?,?,?)"; //check
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idBarang); //check
            statement.setString(2, tanggalMasuk); //check
            statement.setString(3, idKaryawan); //check
            
            int rows = statement.executeUpdate();
            
            if (rows > 0) {
                this.load_data();
                JOptionPane.showMessageDialog(this, "Barang Masuk tersimpan!");
                clear_txtfield();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnInsertActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        try {
            
            String[] barang = String.valueOf(CmbIDBarang.getSelectedItem()).split(" | "); //check
            String idBarang = barang[0]; //check
            String tanggalMasuk = TxtTanggalMasuk.getText(); //check
            String[] karyawan = String.valueOf(CmbIDKaryawan.getSelectedItem()).split(" | "); //check
            String idKaryawan = karyawan[0]; //check
            
            String idTerpilih = TxtIDBarangMasuk.getText(); //check
            
            String sql = "update barang_masuk set id_barang = ?, tanggal_masuk = ?, id_karyawan = ? where id_barang_masuk = ?"; //check
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, String.valueOf(idBarang)); //check
            statement.setString(2, tanggalMasuk); //check
            statement.setString(3, String.valueOf(idKaryawan)); //check
            statement.setString(4, idTerpilih); //check
            
            int konfirmasiUpdate = JOptionPane.showConfirmDialog(null, "Apakah anda ingin memperbarui barang masuk?"); //check
            
            if (konfirmasiUpdate == 0) {
                int rows = statement.executeUpdate();
            
                if (rows > 0) {
                    this.load_data();
                    JOptionPane.showMessageDialog(this, "Barang masuk diperbarui!"); //check
                    clear_txtfield();
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        try {
            String idTerpilih = TxtIDBarangMasuk.getText(); //check
            
            String sql = "delete from barang_masuk where id_barang_masuk = ?"; //check
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idTerpilih);
            
            int konfirmasiUpdate = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus barang masuk?"); //check
            
            if (konfirmasiUpdate == 0) {
                int rows = statement.executeUpdate();
            
                if (rows > 0) {
                    this.load_data();
                    JOptionPane.showMessageDialog(this, "Barang masuk dihapus!"); //check
                    clear_txtfield();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void MenuKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuKaryawanActionPerformed
        try {
            new Karyawan().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuKaryawanActionPerformed

    private void MenuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBarangActionPerformed
        try {
            new Barang().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuBarangActionPerformed

    private void MenuBarangMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBarangMasukActionPerformed
        try {
            new BarangKeluar().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuBarangMasukActionPerformed

    private void MenuBarangKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBarangKeluarActionPerformed
        try {
            new BarangKeluar().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuBarangKeluarActionPerformed

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        try {
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuExitActionPerformed

    private void MenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAboutActionPerformed
        try {
            new About().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuAboutActionPerformed

    private void TblBarangMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblBarangMasukMouseClicked
        int row = TblBarangMasuk.getSelectedRow();
          
          String selectedID = (String) TblBarangMasuk.getValueAt(row, 0);
          TxtIDBarangMasuk.setText(selectedID);
          
          try {
            String sql = "select * from barang_masuk where id_barang_masuk = " + selectedID;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
              while (result.next()) {
                  CmbIDBarang.getModel().setSelectedItem(result.getString(2));
                  TxtTanggalMasuk.setText(result.getString(3));
                  CmbIDKaryawan.getModel().setSelectedItem(result.getString(4));
              }
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_TblBarangMasukMouseClicked

    private void CmbIDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbIDBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbIDBarangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnInsert;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JComboBox<String> CmbIDBarang;
    private javax.swing.JComboBox<String> CmbIDKaryawan;
    private javax.swing.JMenuItem MenuAbout;
    private javax.swing.JMenuItem MenuBarang;
    private javax.swing.JMenuItem MenuBarangKeluar;
    private javax.swing.JMenuItem MenuBarangMasuk;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenu MenuForms;
    private javax.swing.JMenuItem MenuKaryawan;
    private javax.swing.JMenuItem MenuTipeBarang;
    private javax.swing.JTable TblBarangMasuk;
    private javax.swing.JTextField TxtIDBarangMasuk;
    private javax.swing.JTextField TxtTanggalMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
