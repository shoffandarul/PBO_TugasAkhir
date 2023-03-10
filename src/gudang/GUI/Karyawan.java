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
 * @author Robby Akbar Abdullah
 */
public class Karyawan extends javax.swing.JFrame {

    DefaultTableModel tblmodel;
    Connection conn;
    
    /**
     * Creates new form Karyawan
     */
    public Karyawan() {
        initComponents();
        
        DBConnection openconn = new DBConnection();
        this.conn = openconn.create_connection();
        
        this.tblmodel = (DefaultTableModel)TblBarangMasuk.getModel(); //check
        
        this.load_data();
    }
    
    public void reset_table(){
        int rowCount = this.tblmodel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            this.tblmodel.removeRow(i);
        }
    }
    
    public void load_data(){
        try {
            String sql = "select * from karyawan"; //check
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            this.reset_table();
            
            while (result.next()) {                
                String id = result.getString(1); //check
                String nama = result.getString(2); //check
                String nik = result.getString(3); //check
                String nohp = result.getString(4); //check
                String dataKaryawan[] = {id, nik, nama, nohp}; //check

                this.tblmodel.addRow(dataKaryawan); //check
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void clear_txtfield() {
        TxtIDKaryawan.setText(""); //check
        TxtNIK.setText(""); //check
        TxtNama.setText(""); //check
        TxtNoHP.setText(""); //check
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
        BtnInsert = new javax.swing.JButton();
        TxtNoHP = new javax.swing.JTextField();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TxtIDKaryawan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtNIK = new javax.swing.JTextField();
        TxtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblBarangMasuk = new javax.swing.JTable();
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
        jLabel1.setText("KARYAWAN");

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

        TxtIDKaryawan.setEditable(false);
        TxtIDKaryawan.setBackground(new java.awt.Color(204, 204, 204));
        TxtIDKaryawan.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        TxtIDKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIDKaryawanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel3.setText("NIK");

        jLabel4.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel4.setText("NAMA");

        jLabel5.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jLabel5.setText("NO HP");

        jLabel7.setFont(new java.awt.Font("Product Sans", 2, 12)); // NOI18N
        jLabel7.setText("Otomatis Terbuat");

        TxtNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNIKActionPerformed(evt);
            }
        });

        TblBarangMasuk.setFont(new java.awt.Font("Product Sans", 0, 12)); // NOI18N
        TblBarangMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID ", "NIK", "NAMA", "NO HP"
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(329, 329, 329))
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
                                .addComponent(jLabel5))
                            .addGap(75, 75, 75)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtIDKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addComponent(TxtNIK)
                                .addComponent(TxtNama)
                                .addComponent(TxtNoHP))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28))
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
                    .addGap(77, 77, 77)
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
                                .addComponent(TxtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(TxtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(TxtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(77, Short.MAX_VALUE)))
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
            String nik = TxtNIK.getText(); //check
            String nama = TxtNama.getText(); //check
            String nohp = TxtNoHP.getText(); //check

            String sql = "insert into karyawan (nama_karyawan, nik_karyawan, no_hp_karyawan) values (?,?,?)"; //check

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nama); //check
            statement.setString(2, nik); //check
            statement.setString(3, nohp); //check

            int rows = statement.executeUpdate();

            if (rows > 0) {
                this.load_data();
                JOptionPane.showMessageDialog(this, "Karyawan tersimpan!");
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

            String nik = TxtNIK.getText(); //check
            String nama = TxtNama.getText(); //check
            String nohp = TxtNoHP.getText(); //check

            String idTerpilih = TxtIDKaryawan.getText(); //check

            String sql = "update karyawan set nik_karyawan = ?, nama_karyawan = ?, no_hp_karyawan = ? where id_karyawan = ?"; //check

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nik); //check
            statement.setString(2, nama); //check
            statement.setString(3, nohp); //check
            statement.setString(4, idTerpilih); //check

            int konfirmasiUpdate = JOptionPane.showConfirmDialog(null, "Apakah anda ingin memperbarui karyawan?"); //check

            if (konfirmasiUpdate == 0) {
                int rows = statement.executeUpdate();

                if (rows > 0) {
                    this.load_data();
                    JOptionPane.showMessageDialog(this, "Karyawan diperbarui!"); //check
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
            String idTerpilih = TxtIDKaryawan.getText(); //check

            String sql = "delete from karyawan where id_karyawan = ?"; //check

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idTerpilih);

            int konfirmasiUpdate = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus karyawan?"); //check

            if (konfirmasiUpdate == 0) {
                int rows = statement.executeUpdate();

                if (rows > 0) {
                    this.load_data();
                    JOptionPane.showMessageDialog(this, "Karyawan dihapus!"); //check
                    clear_txtfield();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Infobox: Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void TxtIDKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIDKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIDKaryawanActionPerformed

    private void TxtNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNIKActionPerformed

    private void TblBarangMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblBarangMasukMouseClicked
        int row = TblBarangMasuk.getSelectedRow();

        String selectedID = (String) TblBarangMasuk.getValueAt(row, 0);
        TxtIDKaryawan.setText(selectedID);

        try {
            String sql = "select * from karyawan where id_karyawan = " + selectedID;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                TxtIDKaryawan.setText(result.getString(1));
                TxtNama.setText(result.getString(2));
                TxtNIK.setText(result.getString(3));
                TxtNoHP.setText(result.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_TblBarangMasukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnInsert;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JMenuItem MenuAbout;
    private javax.swing.JMenuItem MenuBarang;
    private javax.swing.JMenuItem MenuBarangKeluar;
    private javax.swing.JMenuItem MenuBarangMasuk;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenu MenuForms;
    private javax.swing.JMenuItem MenuKaryawan;
    private javax.swing.JMenuItem MenuTipeBarang;
    private javax.swing.JTable TblBarangMasuk;
    private javax.swing.JTextField TxtIDKaryawan;
    private javax.swing.JTextField TxtNIK;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtNoHP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
