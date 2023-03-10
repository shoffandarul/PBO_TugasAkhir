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
 * @author William Nison M
 */
public class Barang extends javax.swing.JFrame {

    DefaultTableModel tblmodel;
    Connection conn;
    
    /**
     * Creates new form BarangMasuk
     */
    public Barang() {
        initComponents();
        
        DBConnection openconn = new DBConnection();
        this.conn = openconn.create_connection();
        
        this.tblmodel = (DefaultTableModel)TblBarangMasuk.getModel(); //check
        
        this.load_data();
        this.load_tipe_barang(); // check
    }
    
    public void reset_table(){
        int rowCount = this.tblmodel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            this.tblmodel.removeRow(i);
        }
    }
    
    public void load_data(){
        try {
            String sql = "select * from barang"; //check
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            this.reset_table();
            
            while (result.next()) {                
                String id = result.getString(1); //check
                String id_tipe_barang = result.getString(2); //check
                String tipe_barang = load_tipe_barang_by_id(id_tipe_barang); //check
                String nama_barang = result.getString(3); //check
                String ukuran_barang = result.getString(4); //check
                String berat_barang = result.getString(5); //check
                String dataBarang[] = {id, (id_tipe_barang + " | " + tipe_barang), nama_barang, ukuran_barang, berat_barang }; //check

                this.tblmodel.addRow(dataBarang); //check
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void load_tipe_barang() {
        try {
            try {
                String sql = "select * from tipe_barang"; //check
                Statement statement = this.conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    String id_tipe_barang = result.getString(1); //check
                    String tipe_barang = result.getString(2); //check
                    CmbIDTipeBarang.addItem(id_tipe_barang + " | " + tipe_barang); //check
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String load_tipe_barang_by_id(String id) {
        try {
            try {
                String sql = "select * from tipe_barang where id_tipe_barang = " + id; //check
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
        TxtIDBarang.setText(""); //check
        CmbIDTipeBarang.setSelectedIndex(0); //check
        TxtNamaBarang.setText(""); //check
        TxtUkuran.setText(""); //check
        TxtBerat.setText(""); //check
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
        jLabel8 = new javax.swing.JLabel();
        BtnInsert = new javax.swing.JButton();
        TxtNamaBarang = new javax.swing.JTextField();
        BtnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BtnDelete = new javax.swing.JButton();
        TxtBerat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtIDBarang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CmbIDTipeBarang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        TxtUkuran = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblBarangMasuk = new javax.swing.JTable();
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
        jLabel1.setText("FORM BARANG");

        jLabel8.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel8.setText("Nama Barang");

        BtnInsert.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        BtnInsert.setText("INSERT");
        BtnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertActionPerformed(evt);
            }
        });

        TxtNamaBarang.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        TxtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNamaBarangActionPerformed(evt);
            }
        });

        BtnUpdate.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        BtnUpdate.setText("UPDATE");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel6.setText("Berat Barang");

        BtnDelete.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        BtnDelete.setText("DELETE");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        TxtBerat.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel9.setFont(new java.awt.Font("Product Sans", 2, 12)); // NOI18N
        jLabel9.setText("CM");

        TxtIDBarang.setEditable(false);
        TxtIDBarang.setBackground(new java.awt.Color(204, 204, 204));
        TxtIDBarang.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Product Sans", 2, 12)); // NOI18N
        jLabel10.setText("Gram");

        jLabel3.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel3.setText("ID Tipe Barang");

        CmbIDTipeBarang.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        CmbIDTipeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        CmbIDTipeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIDTipeBarangActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel4.setText("Ukuran Barang");

        TxtUkuran.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        TblBarangMasuk.setFont(new java.awt.Font("Product Sans", 0, 12)); // NOI18N
        TblBarangMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "ID TIPE BARANG", "NAMA BARANG", "UKURAN BARANG", "BERAT BARANG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel7.setFont(new java.awt.Font("Product Sans", 2, 12)); // NOI18N
        jLabel7.setText("Otomatis Terbuat");

        jMenu1.setText("Gudang");

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
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6))
                            .addGap(75, 75, 75)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CmbIDTipeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TxtUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7)
                                        .addComponent(TxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BtnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(TxtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(555, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CmbIDTipeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(TxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(TxtUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(TxtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addContainerGap(62, Short.MAX_VALUE)))
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
            new BarangMasuk().setVisible(true);
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

    private void BtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertActionPerformed
        try {
            String[] tipe_barang = String.valueOf(CmbIDTipeBarang.getSelectedItem()).split(" | "); //check
            String id_tipe_barang = tipe_barang[0]; //check
            String nama_barang = TxtNamaBarang.getText(); //check //check
            String ukuran_barang = TxtUkuran.getText(); //check //check
            String berat_barang = TxtBerat.getText(); //check //check

            String sql = "insert into barang (id_tipe_barang, nama_barang, ukuran_barang, berat_barang) values (?,?,?,?)"; //check

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id_tipe_barang); //check
            statement.setString(2, nama_barang); //check
            statement.setString(3, ukuran_barang); //check
            statement.setString(4, berat_barang); //check

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

    private void TxtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNamaBarangActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        try {

            String[] tipe_barang = String.valueOf(CmbIDTipeBarang.getSelectedItem()).split(" | "); //check
            String id_tipe_barang = tipe_barang[0]; //check
            String nama_barang = TxtNamaBarang.getText(); //check //check
            String ukuran_barang = TxtUkuran.getText(); //check //check
            String berat_barang = TxtBerat.getText(); //check //check

            String idTerpilih = TxtIDBarang.getText(); //check

            String sql = "update barang set id_tipe_barang = ?, nama_barang = ?, ukuran_barang = ?, berat_barang = ? where id_barang = ?"; //check

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id_tipe_barang); //check
            statement.setString(2, nama_barang); //check
            statement.setString(3, ukuran_barang); //check
            statement.setString(4, berat_barang); //check
            statement.setString(5, idTerpilih); //check

            int konfirmasiUpdate = JOptionPane.showConfirmDialog(null, "Apakah anda ingin memperbarui data barang ?"); //check

            if (konfirmasiUpdate == 0) {
                int rows = statement.executeUpdate();

                if (rows > 0) {
                    this.load_data();
                    JOptionPane.showMessageDialog(this, "Data Barang berhasil diperbarui!"); //check
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
            String idTerpilih = TxtIDBarang.getText(); //check

            String sql = "delete from barang where id_barang = ?"; //check

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idTerpilih);

            int konfirmasiUpdate = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data barang ?"); //check

            if (konfirmasiUpdate == 0) {
                int rows = statement.executeUpdate();

                if (rows > 0) {
                    this.load_data();
                    JOptionPane.showMessageDialog(this, "Data BArang berhasil dihapus!"); //check
                    clear_txtfield();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void CmbIDTipeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbIDTipeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbIDTipeBarangActionPerformed

    private void TblBarangMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblBarangMasukMouseClicked
        int row = TblBarangMasuk.getSelectedRow();

        String selectedID = (String) TblBarangMasuk.getValueAt(row, 0);
        TxtIDBarang.setText(selectedID);

        try {
            String sql = "select * from barang where id_barang = " + selectedID;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                CmbIDTipeBarang.getModel().setSelectedItem(result.getString(2));
                TxtNamaBarang.setText(result.getString(3));
                TxtUkuran.setText(result.getString(4));
                TxtBerat.setText(result.getString(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_TblBarangMasukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnInsert;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JComboBox<String> CmbIDTipeBarang;
    private javax.swing.JMenuItem MenuAbout;
    private javax.swing.JMenuItem MenuBarang;
    private javax.swing.JMenuItem MenuBarangKeluar;
    private javax.swing.JMenuItem MenuBarangMasuk;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenu MenuForms;
    private javax.swing.JMenuItem MenuKaryawan;
    private javax.swing.JMenuItem MenuTipeBarang;
    private javax.swing.JTable TblBarangMasuk;
    private javax.swing.JTextField TxtBerat;
    private javax.swing.JTextField TxtIDBarang;
    private javax.swing.JTextField TxtNamaBarang;
    private javax.swing.JTextField TxtUkuran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
