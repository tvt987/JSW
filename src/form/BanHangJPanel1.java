/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.snethlios.dao.ChiTietPhieuXuatDao;

import com.snethlios.dao.KhachHangDAO;
import com.snethlios.dao.PhieuXuatDAO;
import com.snethlios.dao.SanPhamDao;
import com.snethlios.dao.ThanhVienDAO;
import com.snethlios.entity.ChiTietPhieuXuat;
import com.snethlios.entity.GioHang;
import com.snethlios.entity.KhachHang;
import com.snethlios.entity.PhieuXuat;
import com.snethlios.entity.SanPham;
import com.snethlios.entity.ThanhVien;
import com.snethlios.utils.Auth;
import com.snethlios.utils.DateHelper;
import com.snethlios.utils.JdbcHelper;
import com.snethlios.utils.MsgBox;
import com.snethlios.utils.XDate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class BanHangJPanel1 extends javax.swing.JPanel implements Runnable, ThreadFactory {

//    int row = -1;
    int index = -1;
    private WebcamPanel panel = null;
    private Webcam webcamBH = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    /**
     * Creates new form Demo
     */
    public BanHangJPanel1() throws SQLException {
        initComponents();
        init();
    }

    public void init() throws SQLException {
//        this.load();
        initWebcam();
        this.loadTableSanPham();
        this.loadTableHoaDon();
        this.fillCombobox();
        new Timer(1000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy:hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                txtNgayTao.setText(format.format(new Date()));
                txtNgayTao_DH.setText(format.format(new Date()));
            }
        }).start();

        txtMaNV_HD.setText(Auth.user.getHoTen());
        txtTenNV_DH.setText(Auth.user.getHoTen());
        this.fillCombobox();
        btnSuDung.setEnabled(false);
        btnSuDungDH.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        btnDeleteGioHang = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        txtTongTien = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        lblTongTien = new javax.swing.JLabel();
        btnDatHang = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnAddGioHang = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtMaSp = new javax.swing.JTextField();
        pnlWebCam = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        tabsHoaDon = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaNV_HD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaTV = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTen_HD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiem_HD = new javax.swing.JTextField();
        btnSuDung = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTongTienHang_HD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboHinhThuc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtKhachCanTra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtKhachTra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTienConLai = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtLyDoHuy = new javax.swing.JTextField();
        btnThanhToanHoaDon = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtTienThua_DH = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtTenNV_DH = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNgayTao_DH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtMaTV_DH = new javax.swing.JTextField();
        btnXacNhanDatHang = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtTen_DH = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtDiem_DH = new javax.swing.JTextField();
        btnSuDungDH = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtSDT_DH = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtDiaChi_DH = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTongTienHang_DH = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGiamGia_DH = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboHinhThucThanhToan_DH = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtKhachCanTra_DH = new javax.swing.JTextField();
        btnThanhToanDatHang = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtTienShip_DH = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cboTrangThai_DH = new javax.swing.JComboBox<>();
        cboTrangThaiHoaDon = new javax.swing.JComboBox<>();
        btnXoaHoaDon = new javax.swing.JButton();
        lbLTrangThai = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "SOPX", "MaNV", "Trạng Thái", "Tên KH", "Thành Tiền", "Tổng Giảm Giá"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏi Hàng"));

        btnDeleteGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete (2).png"))); // NOI18N
        btnDeleteGioHang.setText("XÓA");
        btnDeleteGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGioHangActionPerformed(evt);
            }
        });

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Thể Loại", "Đơn Giá", "Số Lượng", "Thành Tiền", "Giảm Giá"
            }
        ));
        jScrollPane5.setViewportView(tblGioHang);

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(255, 255, 255));

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        lblTongTien.setText("Tổng Tiền:");

        btnDatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/debit-card.png"))); // NOI18N
        btnDatHang.setText("Đặt Hàng");
        btnDatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDatHangMouseClicked(evt);
            }
        });
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnDeleteGioHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteGioHang)
                    .addComponent(btnThanhToan)
                    .addComponent(btnDatHang)
                    .addComponent(lblTongTien)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Thể Loại", "Don Gia", "Màu Sắc", "Hãng", "Mã KM", "Trạng Thái", "Mức Giảm Giá"
            }
        ));
        jScrollPane4.setViewportView(tblSanPham);

        btnAddGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-cart.png"))); // NOI18N
        btnAddGioHang.setText("Thêm Vào Giỏ Hàng");
        btnAddGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddGioHangMouseClicked(evt);
            }
        });
        btnAddGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGioHangActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/google.png"))); // NOI18N
        jButton17.setText("Search");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/first-track.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/previous-track.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next-track.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/last-track.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnFirst)
                                .addGap(66, 66, 66)
                                .addComponent(btnPrev)
                                .addGap(66, 66, 66)
                                .addComponent(btnNext)
                                .addGap(66, 66, 66)
                                .addComponent(btnLast)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddGioHang)))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17)
                    .addComponent(btnAddGioHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast)))
        );

        txtMaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSpActionPerformed(evt);
            }
        });
        txtMaSp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaSpKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSpKeyReleased(evt);
            }
        });

        pnlWebCam.setBackground(new java.awt.Color(255, 255, 255));
        pnlWebCam.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        pnlWebCam.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlWebCamAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pnlWebCam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlWebCamMouseClicked(evt);
            }
        });
        pnlWebCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tạo Hóa Đơn", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tabsHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Chung"));

        jLabel1.setText("Tên NV");

        txtMaNV_HD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNV_HDActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày Tạo:");

        jLabel3.setText("Mã TV:");

        txtMaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTVActionPerformed(evt);
            }
        });

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên:");

        txtTen_HD.setEditable(false);

        jLabel5.setText("Điểm:");

        txtDiem_HD.setEditable(false);

        btnSuDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reward.png"))); // NOI18N
        btnSuDung.setText("Sử Dụng");
        btnSuDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuDungMouseClicked(evt);
            }
        });
        btnSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtMaNV_HD)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiem_HD))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTen_HD)
                                    .addComponent(txtMaTV))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXacNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtMaNV_HD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaTV)
                    .addComponent(btnXacNhan)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtTen_HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiem_HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuDung))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết"));

        jLabel6.setText("Tổng Tiền Hàng");

        txtTongTienHang_HD.setEditable(false);
        txtTongTienHang_HD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongTienHang_HDKeyReleased(evt);
            }
        });

        jLabel7.setText("Giảm Giá:");

        txtGiamGia.setEditable(false);

        jLabel8.setText("HT Thanh Toán:");

        cboHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chuyển Khoản", "Trực Tiếp" }));

        jLabel9.setText("Khách Cần Trả:");

        txtKhachCanTra.setEditable(false);
        txtKhachCanTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachCanTraActionPerformed(evt);
            }
        });
        txtKhachCanTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachCanTraKeyReleased(evt);
            }
        });

        jLabel10.setText("Khách Trả:");

        txtKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKhachTraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachTraKeyReleased(evt);
            }
        });

        jLabel11.setText("Tiền Trả Lại:");

        txtTienConLai.setEditable(false);

        jLabel22.setText("Trạng Thái:");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Chưa Thanh Toán" }));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        jLabel23.setText("Lý Do Hủy:");

        btnThanhToanHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay (1).png"))); // NOI18N
        btnThanhToanHoaDon.setText("Thanh Toán");
        btnThanhToanHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanHoaDonMouseClicked(evt);
            }
        });
        btnThanhToanHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTienHang_HD))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(46, 46, 46)
                        .addComponent(txtGiamGia))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboHinhThuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtKhachCanTra))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(41, 41, 41)
                        .addComponent(txtKhachTra))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(34, 34, 34)
                        .addComponent(txtTienConLai))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTrangThai, 0, 200, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThanhToanHoaDon)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtLyDoHuy))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongTienHang_HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtKhachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTienConLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtLyDoHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToanHoaDon)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabsHoaDon.addTab("Hóa Đơn", jPanel16);

        jLabel21.setText("Tiền Thừa:");

        jButton7.setText("Sử Dụng Thẻ");

        jButton8.setText("Đăng Ký Thẻ");

        jButton9.setText("Tạo Hóa Đơn");

        jButton10.setText("Giao Hàng");

        jButton11.setText("Đã Giao");

        jButton12.setText("Hoàn Trả");

        jLabel25.setText("Tiền Khách Đưa");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Chung"));

        jLabel18.setText("Tên NV");

        txtTenNV_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNV_DHActionPerformed(evt);
            }
        });

        jLabel19.setText("Ngày Tạo:");

        jLabel20.setText("Mã TV:");

        txtMaTV_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTV_DHActionPerformed(evt);
            }
        });

        btnXacNhanDatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        btnXacNhanDatHang.setText("Xác Nhận");
        btnXacNhanDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanDatHangActionPerformed(evt);
            }
        });

        jLabel26.setText("Tên:");

        jLabel27.setText("Điểm:");

        btnSuDungDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reward.png"))); // NOI18N
        btnSuDungDH.setText("Sử Dụng");
        btnSuDungDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuDungDHMouseClicked(evt);
            }
        });
        btnSuDungDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungDHActionPerformed(evt);
            }
        });

        jLabel28.setText("SĐT:");

        txtSDT_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDT_DHActionPerformed(evt);
            }
        });
        txtSDT_DH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDT_DHKeyReleased(evt);
            }
        });

        jLabel29.setText("Địa Chỉ:");

        txtDiaChi_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChi_DHActionPerformed(evt);
            }
        });
        txtDiaChi_DH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiaChi_DHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenNV_DH))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(37, 37, 37)
                        .addComponent(txtNgayTao_DH))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtMaTV_DH)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnXacNhanDatHang))
                                    .addComponent(txtTen_DH)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtSDT_DH)
                                        .addGap(93, 93, 93))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtDiem_DH, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSuDungDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(txtDiaChi_DH)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtTenNV_DH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtNgayTao_DH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaTV_DH)
                    .addComponent(btnXacNhanDatHang)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(txtTen_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtDiem_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuDungDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtSDT_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtDiaChi_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết"));

        jLabel12.setText("Tổng Tiền Hàng");

        txtTongTienHang_DH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongTienHang_DHKeyReleased(evt);
            }
        });

        jLabel13.setText("Giảm Giá:");

        txtGiamGia_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamGia_DHActionPerformed(evt);
            }
        });

        jLabel14.setText("HT Thanh Toán:");

        cboHinhThucThanhToan_DH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thanh Toán Khi Nhận Hàng", "Chuyển Khoản" }));
        cboHinhThucThanhToan_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucThanhToan_DHActionPerformed(evt);
            }
        });

        jLabel15.setText("Khách Cần Trả:");

        txtKhachCanTra_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachCanTra_DHActionPerformed(evt);
            }
        });
        txtKhachCanTra_DH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachCanTra_DHKeyReleased(evt);
            }
        });

        btnThanhToanDatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pay (1).png"))); // NOI18N
        btnThanhToanDatHang.setText("Đặt Hàng");
        btnThanhToanDatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanDatHangMouseClicked(evt);
            }
        });
        btnThanhToanDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanDatHangActionPerformed(evt);
            }
        });

        jLabel16.setText("Tiền Ship");

        txtTienShip_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienShip_DHActionPerformed(evt);
            }
        });
        txtTienShip_DH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienShip_DHKeyReleased(evt);
            }
        });

        jLabel30.setText("Trạng Thái");

        cboTrangThai_DH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Giao", "Đã Giao" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTienHang_DH))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboHinhThucThanhToan_DH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtKhachCanTra_DH))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienShip_DH)
                            .addComponent(txtGiamGia_DH)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(41, 41, 41)
                        .addComponent(cboTrangThai_DH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToanDatHang)
                .addGap(81, 81, 81))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongTienHang_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiamGia_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTienShip_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cboHinhThucThanhToan_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtKhachCanTra_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cboTrangThai_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToanDatHang)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7)
                    .addComponent(jButton9)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(txtTienThua_DH, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(469, 469, 469)
                .addComponent(jLabel25)
                .addGap(10, 10, 10)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTienThua_DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabsHoaDon.addTab("Đặt Hàng", jPanel17);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabsHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(tabsHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cboTrangThaiHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboTrangThaiHoaDonMouseClicked(evt);
            }
        });
        cboTrangThaiHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiHoaDonActionPerformed(evt);
            }
        });
        cboTrangThaiHoaDon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboTrangThaiHoaDonPropertyChange(evt);
            }
        });

        btnXoaHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete (2).png"))); // NOI18N
        btnXoaHoaDon.setText("Xóa");
        btnXoaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHoaDonActionPerformed(evt);
            }
        });

        lbLTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/project.png"))); // NOI18N
        lbLTrangThai.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnXoaHoaDon)
                                .addGap(32, 32, 32)
                                .addComponent(lbLTrangThai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMaSp)
                                .addGap(3, 3, 3))))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlWebCam, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnXoaHoaDon)
                                .addComponent(lbLTrangThai)))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnDeleteGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteGioHangActionPerformed
        // TODO add your handling code here:
//        deleteHoaDon();
        deleteGioHang();
    }//GEN-LAST:event_btnDeleteGioHangActionPerformed

    private void btnAddGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddGioHangMouseClicked
        // TODO add your handling code here
        //        gioHang();
    }//GEN-LAST:event_btnAddGioHangMouseClicked

    private void btnAddGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGioHangActionPerformed
        // TODO add your handling code here:
//        this.addGioHang();
        this.searchSp();
//        duplicateCodes(); //        gioHang();
    }//GEN-LAST:event_btnAddGioHangActionPerformed

    private void txtMaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSpActionPerformed

    private void txtKhachCanTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachCanTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachCanTraActionPerformed

    private void pnlWebCamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWebCamMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_pnlWebCamMouseClicked

    private void pnlWebCamAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlWebCamAncestorAdded
        // TODO add your handling code here:
        //        initWebcam();
    }//GEN-LAST:event_pnlWebCamAncestorAdded

    private void txtMaNV_HDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNV_HDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNV_HDActionPerformed

    private void txtMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTVActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        this.setKhachHang();
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtKhachTraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachTraKeyPressed
        // TODO add your handling code here:ách


    }//GEN-LAST:event_txtKhachTraKeyPressed

    private void txtKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachTraKeyReleased
        // TODO add your handling code here0:
        try {
            double tongTien = Double.parseDouble(txtTongTienHang_HD.getText());
            double tienKhachDua = Double.parseDouble(txtKhachTra.getText());
            double giamGia = Double.parseDouble(txtGiamGia.getText());
            double khachCanTra = (tongTien - giamGia);
            txtKhachCanTra.setText(String.valueOf(khachCanTra));
            ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat();
            double tienThua = (tienKhachDua - khachCanTra);
            txtTienConLai.setText(String.valueOf(tienThua));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtKhachTraKeyReleased

    private void txtKhachCanTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachCanTraKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtKhachCanTraKeyReleased

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
        this.setFormHoaDon();
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnSuDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuDungMouseClicked
        // TODO add your handling code here:
        try {
            String maKh = txtMaTV.getText();
            KhachHang kh = new KhachHang();
            ThanhVien tv = new ThanhVien();
            tv = tvDao.selectByID(maKh);
            kh = khDao.selectByID(maKh);
//        txtTen_HD.setText(kh.getTenkh());
//        txtDiem_HD.setText(Integer.toString(kh.getDiem()));
            double giamGia1 = Double.parseDouble(txtGiamGia.getText());
            txtGiamGia.setText(String.valueOf(giamGia1 + kh.getDiem()));

            double tongTien = Double.parseDouble(txtTongTienHang_HD.getText());
            double giamGia = Double.parseDouble(txtGiamGia.getText());
            double khachCanTra = (tongTien - giamGia);
            txtKhachCanTra.setText(String.valueOf(khachCanTra));
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSuDungMouseClicked

    private void txtTongTienHang_HDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongTienHang_HDKeyReleased
        // TODO add your handling code here:
        if (txtGiamGia.getText().equals("")) {
            txtKhachCanTra.setText(Double.toString(getSum()));
        } else {
            double tongTien = Double.parseDouble(txtTongTien.getText());
            double giamGia = Double.parseDouble(txtGiamGia.getText());
            double khachCanTra = (tongTien - giamGia);
            txtKhachCanTra.setText(String.valueOf(khachCanTra));

        }
    }//GEN-LAST:event_txtTongTienHang_HDKeyReleased

    private void btnSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuDungActionPerformed

    private void btnThanhToanHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanHoaDonMouseClicked
        // TODO add your handling code here:

        if (checkFormHoaDon()) {
            try {
                try {
                    this.insertHoaDon();
                } catch (SQLException ex) {
                    Logger.getLogger(BanHangJPanel1.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.loadTableHoaDon();
                int row = 0;
                int sopx = (int) tblHoaDon.getValueAt(row, 1);
                for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                    String masp = (String) tblGioHang.getValueAt(i, 0);
                    double dongia = (double) tblGioHang.getValueAt(i, 3);
                    int soluong = (int) tblGioHang.getValueAt(i, 4);
                    ChiTietPhieuXuat ct = new ChiTietPhieuXuat();
                    ct.setSoPX(sopx);
                    ct.setMaSp(masp);
                    ct.setGiaBan(dongia);
                    ct.setSoLuong(soluong);
                    ctpxDao.insert(ct);
                }
                index = 0;
                tblHoaDon.setRowSelectionInterval(index, index);
                this.clearFormHoaDon();
                listGH.removeAll(listGH);
                this.loadGioHang();
                listGH.removeAll(listGH);
                this.loadGioHang();
                PhieuXuat px = new PhieuXuat();
                this.setFormHoaDon();
            } catch (Exception e) {
            }

        }

    }//GEN-LAST:event_btnThanhToanHoaDonMouseClicked

    private void txtMaSpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSpKeyReleased
        // TODO add your handling code here:
//        this.search();
    }//GEN-LAST:event_txtMaSpKeyReleased

    private void txtMaSpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSpKeyPressed
        // TODO add your handling code here:
//        this.searchPoint();
    }//GEN-LAST:event_txtMaSpKeyPressed

    private void btnThanhToanHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanHoaDonActionPerformed

    private void txtTenNV_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNV_DHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNV_DHActionPerformed

    private void txtMaTV_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTV_DHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTV_DHActionPerformed

    private void btnXacNhanDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanDatHangActionPerformed
        // TODO add your handling code here:
        this.setFormKH_DH();
    }//GEN-LAST:event_btnXacNhanDatHangActionPerformed

    private void btnSuDungDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuDungDHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuDungDHMouseClicked

    private void btnSuDungDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungDHActionPerformed
        // TODO add your handling code here:
        try {
            String maKh = txtMaTV_DH.getText();
            KhachHang kh = new KhachHang();
            kh = khDao.selectByID(maKh);
            txtGiamGia_DH.setText(String.valueOf(getGiamGia() + kh.getDiem()));
//            txtTienShip_DH.setText("0");

            if (txtTienShip_DH.getText().length() == 0) {
//                txtTienShip_DH.setText("0");
                double tongTien = Double.parseDouble(txtTongTienHang_DH.getText());
                double giamGia = Double.parseDouble(txtGiamGia_DH.getText());
//                double tienShip = Double.parseDouble(txtTienShip_DH.getText());
                Double khachCanTra = (tongTien - giamGia);
                txtKhachCanTra_DH.setText(String.valueOf(khachCanTra));
            } else {
                double tongTien = Double.parseDouble(txtTongTienHang_DH.getText());
                double giamGia = Double.parseDouble(txtGiamGia_DH.getText());
                double tienShip = Double.parseDouble(txtTienShip_DH.getText());
                Double khachCanTra = (tongTien - giamGia + tienShip);
                txtKhachCanTra_DH.setText(String.valueOf(khachCanTra));
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSuDungDHActionPerformed

    private void txtTongTienHang_DHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongTienHang_DHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienHang_DHKeyReleased

    private void txtKhachCanTra_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachCanTra_DHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachCanTra_DHActionPerformed

    private void txtKhachCanTra_DHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachCanTra_DHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachCanTra_DHKeyReleased

    private void btnThanhToanDatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanDatHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanDatHangMouseClicked

    private void btnThanhToanDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanDatHangActionPerformed
        // TODO add your handling code here:
        if (checkFormDatHang()) {
            this.insertHoaDonDatHang();
            this.loadTableHoaDon();
            int row = 0;
            int sopx = (int) tblHoaDon.getValueAt(row, 1);
            System.out.println(sopx);
            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                String masp = (String) tblGioHang.getValueAt(i, 0);
                double dongia = (double) tblGioHang.getValueAt(i, 3);
                int soluong = (int) tblGioHang.getValueAt(i, 4);
                ChiTietPhieuXuat ct = new ChiTietPhieuXuat();
                ct.setSoPX(sopx);
                ct.setMaSp(masp);
                ct.setGiaBan(dongia);
                ct.setSoLuong(soluong);
                ctpxDao.insert(ct);
                this.clearFormDatHang();
            }
            index = 0;
            tblHoaDon.setRowSelectionInterval(index, index);

        }

    }//GEN-LAST:event_btnThanhToanDatHangActionPerformed

    private void txtSDT_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDT_DHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDT_DHActionPerformed

    private void txtSDT_DHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDT_DHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDT_DHKeyReleased

    private void txtGiamGia_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamGia_DHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamGia_DHActionPerformed

    private void txtTienShip_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienShip_DHActionPerformed
        // TODO add your handling code here:
        try {
            double tongTien = Double.parseDouble(txtTongTienHang_DH.getText());
            double giamGia = Double.parseDouble(txtGiamGia_DH.getText());
            double tienShip = Double.parseDouble(txtTienShip_DH.getText());
            Double khachCanTra = (tongTien - giamGia + tienShip);
            txtKhachCanTra_DH.setText(String.valueOf(khachCanTra));
        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtTienShip_DHActionPerformed

    private void txtDiaChi_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChi_DHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi_DHActionPerformed

    private void txtDiaChi_DHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChi_DHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi_DHKeyReleased

    private void btnDatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatHangMouseClicked
        // TODO add your handling code here:
        this.setFormDatHang();
    }//GEN-LAST:event_btnDatHangMouseClicked

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatHangActionPerformed

    private void cboHinhThucThanhToan_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThucThanhToan_DHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThucThanhToan_DHActionPerformed

    private void txtTienShip_DHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienShip_DHKeyReleased
        // TODO add your handling code here:
//        if(txtGiamGia_DH.getText().length()==0){}
        try {
            double tongTien = Double.parseDouble(txtTongTienHang_DH.getText());
            double giamGia = Double.parseDouble(txtGiamGia_DH.getText());
            double tienShip = Double.parseDouble(txtTienShip_DH.getText());
            Double khachCanTra = (tongTien - giamGia + tienShip);
            txtKhachCanTra_DH.setText(String.valueOf(khachCanTra));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTienShip_DHKeyReleased

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void cboTrangThaiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiHoaDonActionPerformed
        // TODO add your handling code here:
        this.fillComboboxHoaDon();
    }//GEN-LAST:event_cboTrangThaiHoaDonActionPerformed

    private void cboTrangThaiHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboTrangThaiHoaDonMouseClicked
        // TODO add your handling code here:
        this.fillComboboxHoaDon();

    }//GEN-LAST:event_cboTrangThaiHoaDonMouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        this.searchID();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        index--;
        if (index < 0) {
            index = tblSanPham.getRowCount() - 1;
        }
        tblSanPham.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        index = 0;
        tblSanPham.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        index++;
        if (index > tblSanPham.getRowCount() - 1) {
            index = 0;
        }
        tblSanPham.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        index = tblSanPham.getRowCount() - 1;
        tblSanPham.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnXoaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHoaDonActionPerformed
        // TODO add your handling code here:
        this.deleteHoaDon();
    }//GEN-LAST:event_btnXoaHoaDonActionPerformed

    private void cboTrangThaiHoaDonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboTrangThaiHoaDonPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangThaiHoaDonPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGioHang;
    private javax.swing.JButton btnDatHang;
    private javax.swing.JButton btnDeleteGioHang;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSuDung;
    private javax.swing.JButton btnSuDungDH;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToanDatHang;
    private javax.swing.JButton btnThanhToanHoaDon;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXacNhanDatHang;
    private javax.swing.JButton btnXoaHoaDon;
    private javax.swing.JComboBox<String> cboHinhThuc;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan_DH;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JComboBox<String> cboTrangThaiHoaDon;
    private javax.swing.JComboBox<String> cboTrangThai_DH;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbLTrangThai;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlWebCam;
    private javax.swing.JTabbedPane tabsHoaDon;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDiaChi_DH;
    private javax.swing.JTextField txtDiem_DH;
    private javax.swing.JTextField txtDiem_HD;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtGiamGia_DH;
    private javax.swing.JTextField txtKhachCanTra;
    private javax.swing.JTextField txtKhachCanTra_DH;
    private javax.swing.JTextField txtKhachTra;
    private javax.swing.JTextField txtLyDoHuy;
    private javax.swing.JTextField txtMaNV_HD;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtMaTV;
    private javax.swing.JTextField txtMaTV_DH;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayTao_DH;
    private javax.swing.JTextField txtSDT_DH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNV_DH;
    private javax.swing.JTextField txtTen_DH;
    private javax.swing.JTextField txtTen_HD;
    private javax.swing.JTextField txtTienConLai;
    private javax.swing.JTextField txtTienShip_DH;
    private javax.swing.JTextField txtTienThua_DH;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTongTienHang_DH;
    private javax.swing.JTextField txtTongTienHang_HD;
    // End of variables declaration//GEN-END:variables

    SanPhamDao spDao = new SanPhamDao();
    ArrayList<SanPham> listSp = new ArrayList<SanPham>();

    public void loadTableSanPham() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        String selectKm = "select sp.MASP, sp.TENSP,sp.LOAI,sp.DONGIA,sp.SOLUONG,sp.MAUSAC,sp.KICHTHUOC, sp.HANG, sp.MAHINH, sp.NGAYNHAP, sp.MANV, sp.MAKM, km.TRANGTHAI, km.MUCGIAMGIA from SANPHAM sp inner join KHUYENMAI km on sp.MAKM = km.MAKM; ";
        ResultSet rs = JdbcHelper.query(selectKm);
        while (rs.next()) {
            String maSp = rs.getString("MASP");
            String tenSp = rs.getString("TENSP");
            String loai = rs.getString("LOAI");
            double donGia = rs.getDouble("DONGIA");
            int soluong = rs.getInt("SOLUONG");
            String mauSac = rs.getString("MAUSAC");
            int KichThuoc = rs.getInt("KICHTHUOC");
            String hang = rs.getString("HANG");
            String hinh = rs.getString("MAHINH");
            Date ngayNhap = rs.getDate("NGAYNHAP");
            String maNV = rs.getString("MANV");
            String maKM = rs.getString("MAKM");
            boolean trangThai = rs.getBoolean("TrangThai");
            int mucGiamGia = rs.getInt("MUCGIAMGIA");
            listSp.add(new SanPham(maSp, tenSp, loai, donGia, soluong, maKM, KichThuoc, hang, ngayNhap, hinh, maNV, maKM, trangThai, mucGiamGia));
            Object[] row = {
                maSp,
                tenSp,
                loai,
                donGia,
                mauSac,
                hang,
                maKM,
                trangThai ? "Đang Hoạt Động" : "Ngưng Hoạt Động",
                mucGiamGia

            };
            model.addRow(row);
        }
    }

    public void load() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        try {

            listSp = (ArrayList<SanPham>) spDao.selectAll();
            String sql = "Select * from  ";

            for (SanPham sp : listSp) {
                Object[] row = {
                    sp.getMaSp(),
                    sp.getTenSp(),
                    sp.getLoai(),
                    sp.getDonGia(),
                    sp.getMau(),
                    sp.getHang(),
                    sp.getMaHinh()
//                    sp.getMaNV()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    ArrayList<GioHang> listGH = new ArrayList<GioHang>();

    void addGioHang() {
        GioHang gh = new GioHang();
        try {
            int check = 0;
            for (int row : tblSanPham.getSelectedRows()) {
                SanPham sp = new SanPham();
                gh.setMaSp((String) tblSanPham.getValueAt(row, 0));
                gh.setTenSp((String) tblSanPham.getValueAt(row, 1));
                gh.setLoai((String) tblSanPham.getValueAt(row, 2));
                gh.setDonGia((Double) tblSanPham.getValueAt(row, 3));
                String number = JOptionPane.showInputDialog("Nhập Số Lượng Bạn Muốn Thêm Vào Giỏ Hàng!");
                check = 0;
                for(GioHang rowInGH : listGH){
                     if(rowInGH.getMaSp() == tblSanPham.getValueAt(row, 0)){
                         rowInGH.setSoLuong(rowInGH.getSoLuong() + Integer.parseInt(number));
                         check++;
                     }
                }
                if(check == 0 ){
                    gh.setSoLuong(Integer.parseInt(number));
                }
                gh.setHang((String) tblSanPham.getValueAt(row, 5));
                gh.setMaKM((String) tblSanPham.getValueAt(row, 6));
                gh.setThanhTien(gh.getThanhTien());
                if (tblSanPham.getValueAt(row, 7).toString().equalsIgnoreCase("Ngưng Hoạt Động")) {
                    gh.setMucGiamGia((int) 0);
                } else {
                    gh.setMucGiamGia((int) tblSanPham.getValueAt(row, 8));
                }
            }
            if(check == 0 ){
                listGH.add(gh);
            }
            
            loadGioHang();
            txtTongTien.setText(Double.toString(getSum()));
            MsgBox.alert(this, "Thêm vào giỏ hành thành công thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }

    }

    private boolean checkId(String str) {
        for (GioHang gh : listGH) {
            String check = String.valueOf(gh.getMaSp());
            if (check.equalsIgnoreCase(str)) {
                index = listGH.indexOf(gh);
            }
        }
        return false;
    }

    public int getSum() {
        int rowCount = tblGioHang.getRowCount();
        int sum = 0;
        for (int i = 0; i < rowCount; i++) {
            sum = sum + Integer.parseInt(tblGioHang.getValueAt(i, 5).toString());
        }
        return sum;
    }

    public int getGiamGia() {
        int row = tblGioHang.getRowCount();
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum = sum + Integer.parseInt(tblGioHang.getValueAt(i, 6).toString());
        }
        return sum;

    }

    void loadGioHang() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        double sum = 0.0;
        model.setRowCount(0);
        for (GioHang gh : listGH) {
            sum += Double.parseDouble(String.valueOf(gh.getThanhTien()));
            Object[] row = new Object[]{gh.getMaSp(), gh.getTenSp(), gh.getLoai(), gh.getDonGia(), gh.getSoLuong(), gh.getThanhTien(), gh.getMucGiamGia()};
            model.addRow(row);
        }
        txtTongTien.setText(String.valueOf(sum));
    }

    PhieuXuat getForm() {
        PhieuXuat px = new PhieuXuat();
        Date now = new Date();
        px.setNgayTao(XDate.addDays(now, 0));
        px.setLyDoHuy(txtLyDoHuy.getText());
        px.setTrangThai(cboTrangThai.getSelectedItem().toString());
        px.setHinhThucThanhToan(cboHinhThuc.getSelectedItem().toString());
        px.setMaNV(Auth.user.getMaNV());
//        px.setMaKH(txtMaTV.getText());
        if (txtMaTV.getText().equals("")) {
            px.setMaKH("");
        } else {
            px.setMaKH(txtMaTV.getText());
        }
        px.setTongTien(Double.parseDouble(txtKhachCanTra.getText()));
        px.setTongGiamGia(Double.parseDouble(txtGiamGia.getText()));

        return px;

    }

    PhieuXuat getFormDatHang() {
        PhieuXuat px = new PhieuXuat();
        Date now = new Date();
        px.setNgayTao(XDate.addDays(now, 10));
        px.setLyDoHuy(txtLyDoHuy.getText());
        px.setTrangThai(cboTrangThai_DH.getSelectedItem().toString());
        px.setHinhThucThanhToan(cboHinhThucThanhToan_DH.getSelectedItem().toString());
        px.setMaNV(Auth.user.getMaNV());
        px.setMaKH(txtMaTV_DH.getText());
        px.setTongTien(Double.parseDouble(txtKhachCanTra_DH.getText()));
        px.setTongGiamGia(Double.parseDouble(txtGiamGia_DH.getText()));
        return px;
    }

    void insertHoaDon() throws SQLException {
        PhieuXuat px = getForm();
        if ((txtMaTV.getText().length() == 0)) {
            try {
                pxDao.insert2(px);
                MsgBox.alert(this, "Thêm mới thành công");
                px.getSoPX();
                this.loadTableHoaDon();
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại Hóa Đơn!");
            }
        } else {
            try {
                pxDao.insert(px);
                MsgBox.alert(this, "Thêm mới thành công");
                px.getSoPX();
                this.loadTableHoaDon();
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại Hóa Đơn!");
            }
        }

    }

    void insertHoaDonDatHang() {
        PhieuXuat px = getFormDatHang();
        try {
            pxDao.insert(px);
            MsgBox.alert(this, "Thêm Mới Thành Công!");
            this.loadTableHoaDon();
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại");
        }

    }

    PhieuXuatDAO pxDao = new PhieuXuatDAO();
    ChiTietPhieuXuatDao ctpxDao = new ChiTietPhieuXuatDao();

    public void loadTableHoaDon() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            List<PhieuXuat> list = pxDao.selectAll();
            int i = 0;
            for (PhieuXuat px : list) {
                Object[] row = {
                    ++i,
                    px.getSoPX(),
                    px.getMaNV(),
                    px.getTrangThai(),
                    px.getMaKH(),
                    px.getTongTien(),
                    px.getTongGiamGia()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    boolean checkFormHoaDon() {
        boolean check = true;
        if (txtKhachCanTra.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập số tiền khách cần trả");
            txtKhachCanTra.setBackground(Color.yellow);
            txtKhachCanTra.requestFocus();
            check = false;
        } else {
            txtKhachCanTra.setBackground(Color.white);
            check = true;
        }
        if (txtKhachTra.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập số tiền khách  trả");
            txtKhachTra.setBackground(Color.yellow);
            txtKhachTra.requestFocus();
            check = false;
        } else {
            txtKhachTra.setBackground(Color.white);
            check = true;
        }
        try {
            double checkKhanhTra = Double.parseDouble(String.valueOf(txtKhachTra.getText()));
            
        } catch (Exception e) {
            MsgBox.alert(this, "Xin lỗi vì đã bị ngu");
            txtKhachTra.setText("");
        }
        if (cboHinhThuc.getSelectedItem() == null) {
            MsgBox.alert(this, "Vui lòng chọn hình Thức Thanh Toán");
            cboHinhThuc.setBackground(Color.yellow);
            check = false;
            cboHinhThuc.requestFocus();
        } else {
            cboHinhThuc.setBackground(Color.white);
            check = true;
        }

        if (cboTrangThai.getSelectedItem() == null) {
            MsgBox.alert(this, "Vui lòng chọn trạng thạí");
            cboTrangThai.setBackground(Color.yellow);
            check = false;
            cboTrangThai.requestFocus();
        } else {
            cboTrangThai.setBackground(Color.white);
            check = true;
        }

        double khachCanTra = Double.parseDouble(txtKhachCanTra.getText());
        double khachTra = Double.parseDouble(txtKhachTra.getText());

        if (khachTra < khachCanTra) {
            txtKhachTra.setBackground(Color.yellow);
            check = false;
            txtKhachTra.requestFocus();
            MsgBox.alert(this, "Tiền khách trả phải lớn hơn tiền khách cần trả");
        } else {
            txtKhachTra.setBackground(Color.white);
            check = true;
        }

        try {
            Double tongTienHang = Double.parseDouble(txtTongTienHang_HD.getText());
            double giamGia = Double.parseDouble(txtGiamGia.getText());
            double khacCanTra = Double.parseDouble(txtKhachCanTra.getText());
            double khachTra1 = Double.parseDouble(txtKhachTra.getText());
        } catch (Exception e) {
            MsgBox.alert(this, "Vui lòng kiểm tra định dạng");
            return false;
        }
        return check;
    }

    public void clearFormHoaDon() {
        txtMaTV.setText("");
        txtTen_HD.setText("");
        txtTongTienHang_HD.setText("");
        txtGiamGia.setText("");
        txtKhachCanTra.setText("");
        txtKhachTra.setText("");
        txtTienConLai.setText("");
        txtLyDoHuy.setText("");
        txtDiem_HD.setText("");
    }

    public void clearFormDatHang() {
        txtMaTV_DH.setText("");
        txtTen_DH.setText("");
        txtSDT_DH.setText("");
        txtDiaChi_DH.setText("");
        txtTongTienHang_DH.setText("");
        txtGiamGia_DH.setText("");
        txtKhachCanTra_DH.setText("");
        txtKhachTra.setText("");
        txtTienConLai.setText("");
        txtLyDoHuy.setText("");
        txtTienShip_DH.setText("");
        txtDiem_DH.setText("");
    }

    boolean checkFormDatHang() {
        boolean check = true;
        if (txtMaTV_DH.getText().equals("")) {
            MsgBox.alert(this, "Vui Lòng Nhập Mã Khách Hàng");
            txtMaTV_DH.setBackground(Color.yellow);
            txtMaTV_DH.requestFocus();
            check = false;
        } else {
            txtMaTV_DH.setBackground(Color.white);
            check = true;
        }
        if (txtTen_DH.getText().equals("")) {
            MsgBox.alert(this, "Vui Lòng Nhập Tên Khách Hàng");
            txtTen_DH.setBackground(Color.yellow);
            txtTen_DH.requestFocus();
            check = false;
        } else {
            txtTen_DH.setBackground(Color.white);
            check = true;
        }
        if (txtTen_DH.getText().equals("")) {
            MsgBox.alert(this, "Vui Lòng Nhập Tên Khách Hàng");
            txtTen_DH.setBackground(Color.yellow);
            txtTen_DH.requestFocus();
            check = false;
        } else {
            txtTen_DH.setBackground(Color.white);
            check = true;
        }
        if (txtSDT_DH.getText().equals("")) {
            MsgBox.alert(this, "Vui Lòng Nhập Tên Khách Hàng");
            txtSDT_DH.setBackground(Color.yellow);
            txtSDT_DH.requestFocus();
            check = false;
        } else {
            txtSDT_DH.setBackground(Color.white);
            check = true;
        }

        if (txtDiaChi_DH.getText().equals("")) {
            MsgBox.alert(this, "Vui Lòng Nhập Địa Chỉ Nhận Hàng");
            txtDiaChi_DH.setBackground(Color.yellow);
            txtDiaChi_DH.requestFocus();
            check = false;
        } else {
            txtDiaChi_DH.setBackground(Color.white);
            check = true;
        }
        if (txtTienShip_DH.getText().equals("")) {
            MsgBox.alert(this, "Vui Lòng Nhập Tiền Ship");
            txtTienShip_DH.setBackground(Color.yellow);
            txtTienShip_DH.requestFocus();
            check = false;
        } else {
            txtTienShip_DH.setBackground(Color.white);
            check = true;
        }
        if (cboHinhThucThanhToan_DH.getSelectedItem() == null) {
            MsgBox.alert(this, "Vui lòng chọn hình Thức Thanh Toán");
            cboHinhThucThanhToan_DH.setBackground(Color.yellow);
            check = false;
            cboHinhThucThanhToan_DH.requestFocus();
        } else {
            cboHinhThucThanhToan_DH.setBackground(Color.white);
            check = true;
        }
        if (cboTrangThai_DH.getSelectedItem() == null) {
            MsgBox.alert(this, "Vui lòng chọn trạng thạí");
            cboTrangThai_DH.setBackground(Color.yellow);
            check = false;
            cboTrangThai_DH.requestFocus();
        } else {
            cboTrangThai_DH.setBackground(Color.white);
            check = true;
        }
        if (txtKhachCanTra_DH.getText().equals("")) {
            MsgBox.alert(this, "Vui Lòng Nhập Tiền Ship");
            txtKhachCanTra_DH.setBackground(Color.yellow);
            txtKhachCanTra_DH.requestFocus();
            check = false;
        } else {
            txtKhachCanTra_DH.setBackground(Color.white);
            check = true;
        }
        try {
            String maTv = txtMaTV_DH.getText();
            Double tongTienHang = Double.parseDouble(txtTongTienHang_DH.getText());
            Double giamGia = Double.parseDouble(txtGiamGia_DH.getText());
            Double tienShip = Double.parseDouble(txtTienShip_DH.getText());
            double khachCanTra = Double.parseDouble(txtKhachCanTra_DH.getText());
        } catch (Exception e) {
            MsgBox.alert(this, "Vui Vòng Kiểm Tra Định Dạng!");
            return false;
        }
        return check;
    }

    void fillCombobox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboTrangThaiHoaDon.getModel();
        model.removeAllElements();
        try {
            List<String> list = pxDao.selectAllHang();
            for (String cd : list) {
                model.addElement(cd);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void fillComboboxHoaDon() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            String TrangThai = (String) cboTrangThaiHoaDon.getSelectedItem();
            if (TrangThai != null) {
                List<PhieuXuat> list = pxDao.selectByCBO(TrangThai);
                for (PhieuXuat pXuat : list) {
                    Object[] row = {
                        pXuat.getSoPX(),
                        pXuat.getMaNV(),
                        pXuat.getTrangThai(),
                        pXuat.getMaKH(),
                        pXuat.getTongTien(),
                        pXuat.getTongGiamGia()
                    };
                    model.addRow(row);
                }
            }
        } catch (Exception e) {
        }
    }
    ThanhVienDAO tvDao = new ThanhVienDAO();
    KhachHangDAO khDao = new KhachHangDAO();

    void setKhachHang() {

        String maKh = txtMaTV.getText();
        KhachHang kh = new KhachHang();
        ThanhVien tv = new ThanhVien();
//        tv = tvDao.selectByID(maKh);
        try {
            kh = khDao.selectByID(maKh);
            txtTen_HD.setText(kh.getTenkh());
            txtDiem_HD.setText(Integer.toString(kh.getDiem()));
            btnSuDung.setEnabled(true);
        } catch (Exception e) {
            MsgBox.alert(this, "Mã khách hàng nhập sai!");
            return;
        }

    }

    void setFormHoaDon() {
        tabsHoaDon.setSelectedIndex(0);
        txtTongTienHang_HD.setText(Double.toString(getSum()));
        txtGiamGia.setText(Double.toString(getGiamGia()));
        if (txtGiamGia.getText().equals("")) {
            txtKhachCanTra.setText(Double.toString(getSum()));
        } else {
            double tongTien = Double.parseDouble(txtTongTienHang_HD.getText());
            double giamGia = Double.parseDouble(txtGiamGia.getText());
            double khachCanTra = (tongTien - giamGia);
            txtKhachCanTra.setText(String.valueOf(khachCanTra));
        }
//        txtKhachCanTra.setText(Double.toString(getSum()));

    }

    void setFormDatHang() {
        tabsHoaDon.setSelectedIndex(1);
        txtTongTienHang_DH.setText(Double.toString(getSum()));
        txtGiamGia_DH.setText(Double.toString(getGiamGia()));
        if (txtGiamGia_DH.getText().equals("")) {
            txtKhachCanTra_DH.setText(Double.toString(getSum()));
        } else {
//            txtTienShip_DH.setText("0");
            double tongTien = Double.parseDouble(txtTongTienHang_DH.getText());
            double giamGia = Double.parseDouble(txtGiamGia_DH.getText());
//            double tienShip = Double.parseDouble(txtTienShip_DH.getText());
            Double khachCanTra = (tongTien - giamGia);
            txtKhachCanTra_DH.setText(String.valueOf(khachCanTra));
        }

    }

    void setFormKH_DH() {
        try {
            String maTV = txtMaTV_DH.getText();
            KhachHang kh = new KhachHang();
//        ThanhVien tv = new ThanhVien();
//        tv = tvDao.selectByID(maTV);
            kh = khDao.selectByID(maTV);
            txtTen_DH.setText(kh.getTenkh());
            txtDiem_DH.setText(Integer.toString(kh.getDiem()));
            txtSDT_DH.setText(kh.getDienThoai());
            txtDiaChi_DH.setText(kh.getDiaChi());
            btnSuDungDH.setEnabled(true);
        } catch (Exception e) {
            MsgBox.alert(this, "Mã khách hàng chưa có");
        }

    }

    private void initWebcam() {
        try {
            Dimension size = WebcamResolution.QVGA.getSize();
            webcamBH = Webcam.getWebcams().get(0);
            webcamBH.setViewSize(size);
            panel = new WebcamPanel(webcamBH);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(true);
            pnlWebCam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 213, 163));
            executor.execute(this);
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                Logger.getLogger(BanHangJPanel1.class
                        .getName()).log(Level.SEVERE, null, e);
            }
            Result result = null;
            BufferedImage image = null;
            try {
                if (webcamBH.isOpen()) {
                    if ((image = webcamBH.getImage()) == null) {
                        continue;
                    }
                }

            } catch (Exception e) {
            }

            try {
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                result = new MultiFormatReader().decode(bitmap);

            } catch (Exception e) {
                Logger.getLogger(BanHangJPanel1.class
                        .getName()).log(Level.SEVERE, null, e);
            }

            if (result != null) {
                txtMaSp.setText(result.getText());
                String text = txtMaSp.getText();
                if (findId(text)) {
                    tblSanPham.setRowSelectionInterval(index, index);
                    this.searchSp();
                    txtMaSp.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "The employee you are looking for could not be found"); // nếu không tìm thấy nhân viên thì thông báo cho người dùng 

                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    public void searchID() {
        String text = txtSearch.getText();
        if (findId(text)) {
            JOptionPane.showMessageDialog(this, "Tìm kiếm thành công", "notification", JOptionPane.INFORMATION_MESSAGE); // thông báo 
            tblSanPham.setRowSelectionInterval(index, index);
            
            this.addGioHang();
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã sản phẩm");

        }
    }

    private boolean findId(String str) {
        for (SanPham st : listSp) {
            String check = String.valueOf(st.getMaSp()); // chuyển sang thành chuỗi 
            if (check.equalsIgnoreCase(str)) {
                index = listSp.indexOf(st);
                return true;
            }
        }
        return false;
    }

    public void searchSp() {
        GioHang gh = new GioHang();

        for (int row : tblSanPham.getSelectedRows()) {
            String text = (String) tblSanPham.getValueAt(row, 0);
            System.out.println(text);
            if (findSp(text)) {
                tblGioHang.setRowSelectionInterval(index, index);
                tblGioHang.getSelectedRow();
                index = tblGioHang.getSelectedRow();
                gh = listGH.get(index);
                gh.setMaSp((String) tblSanPham.getValueAt(row, 0));
                gh.setTenSp((String) tblSanPham.getValueAt(row, 1));
                gh.setLoai((String) tblSanPham.getValueAt(row, 2));
                gh.setDonGia((Double) tblSanPham.getValueAt(row, 3));
                String number = JOptionPane.showInputDialog("Nhập Số Lượng Bạn Muốn Thêm Vào Giỏ Hàng!");
                gh.setSoLuong(Integer.parseInt(number) + gh.getSoLuong());
                gh.setHang((String) tblSanPham.getValueAt(row, 5));
                gh.setMaKM((String) tblSanPham.getValueAt(row, 6));
                gh.setThanhTien(gh.getThanhTien());
                if (tblSanPham.getValueAt(row, 7).toString().equalsIgnoreCase("Ngưng Hoạt Động")) {
                    gh.setMucGiamGia((int) 0);
                } else {
                    gh.setMucGiamGia((int) tblSanPham.getValueAt(row, 8));
                }
                this.loadGioHang();
            } else {
                SanPham sp = new SanPham();
                gh.setMaSp((String) tblSanPham.getValueAt(row, 0));
                gh.setTenSp((String) tblSanPham.getValueAt(row, 1));
                gh.setLoai((String) tblSanPham.getValueAt(row, 2));
                gh.setDonGia((Double) tblSanPham.getValueAt(row, 3));
                String number = JOptionPane.showInputDialog("Nhập Số Lượng Bạn Muốn Thêm Vào Giỏ Hàng!");
                gh.setSoLuong(Integer.parseInt(number));
                gh.setHang((String) tblSanPham.getValueAt(row, 5));
                gh.setMaKM((String) tblSanPham.getValueAt(row, 6));
//                gh.setHinh((String) tblSanPham.getValueAt(row, 6));
                gh.setThanhTien(gh.getThanhTien());
//                gh.setTrangThai((boolean) tblSanPham.getValueAt(row, 7));
                if (tblSanPham.getValueAt(row, 7).toString().equalsIgnoreCase("Ngưng Hoạt Động")) {
                    gh.setMucGiamGia((int) 0);
                } else {
                    gh.setMucGiamGia((int) tblSanPham.getValueAt(row, 8));
                }
                listGH.add(gh);
                loadGioHang();
            }

        }

    }

    private boolean findSp(String str) {
        for (GioHang gh : listGH) {
            String check = String.valueOf(gh.getMaSp());
            if (check.equalsIgnoreCase(str)) {
                index = listGH.indexOf(gh);
                return true;
            }
        }
        return false;
    }

    private void deleteHoaDon() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa");
        } else {
            if (MsgBox.confirm(this, "Bạn muốn xóa hóa đơn được chọn được chọn")) {
                for (int row : tblHoaDon.getSelectedRows()) {
                    int maHd = (int) tblHoaDon.getValueAt(row, 1);
                    pxDao.delete(maHd);
                    MsgBox.alert(this, "Xóa thành công!");
                }
                this.loadTableHoaDon();
            } else {
                MsgBox.alert(this, "xóa thất bại!");
            }
        }
    }

    void removeHoaDon() {
        if (MsgBox.confirm(this, "Bạn muốn xóa các học viên được chọn")) {
            for (int row : tblHoaDon.getSelectedRows()) {
                int mahv = (Integer) tblHoaDon.getValueAt(row, 1);
                pxDao.delete(mahv);
            }
            this.loadTableHoaDon();
//            }
        }
    }

    private void deleteGioHang() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa");
        } else {
            if (MsgBox.confirm(this, "Bạn  Có Muốn Xóa Khỏi Giỏ Hàng")) {
                index = tblGioHang.getSelectedRow();
                listGH.remove(index);
                this.loadGioHang();
            }
        }
    }

}
