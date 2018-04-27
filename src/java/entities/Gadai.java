/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TAMU
 */
@Entity
@Table(name = "GADAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gadai.findAll", query = "SELECT g FROM Gadai g")
    , @NamedQuery(name = "Gadai.findByIdGadai", query = "SELECT g FROM Gadai g WHERE g.idGadai = :idGadai")
    , @NamedQuery(name = "Gadai.findByJumlahPinjaman", query = "SELECT g FROM Gadai g WHERE g.jumlahPinjaman = :jumlahPinjaman")
    , @NamedQuery(name = "Gadai.findByTanggalPinjaman", query = "SELECT g FROM Gadai g WHERE g.tanggalPinjaman = :tanggalPinjaman")
    , @NamedQuery(name = "Gadai.findByJatuhTempo", query = "SELECT g FROM Gadai g WHERE g.jatuhTempo = :jatuhTempo")
    , @NamedQuery(name = "Gadai.findBySisa", query = "SELECT g FROM Gadai g WHERE g.sisa = :sisa")
    , @NamedQuery(name = "Gadai.findByTanggalDiterima", query = "SELECT g FROM Gadai g WHERE g.tanggalDiterima = :tanggalDiterima")})
public class Gadai implements Serializable {

    @Column(name = "KETERANGAN")
    private String keterangan;
    @Column(name = "STATUS")
    private String status;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GADAI")
    private String idGadai;
    @Column(name = "JUMLAH_PINJAMAN")
    private Long jumlahPinjaman;
    @Column(name = "TANGGAL_PINJAMAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalPinjaman;
    @Column(name = "JATUH_TEMPO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jatuhTempo;
    @Column(name = "SISA")
    private Long sisa;
    @Column(name = "TANGGAL_DITERIMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalDiterima;
    @JoinColumn(name = "ID_BARANG", referencedColumnName = "ID_BARANG")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Barang idBarang;
    @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "ID_CUSTOMER")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer idCustomer;

    public Gadai() {
    }

    public Gadai(String idGadai) {
        this.idGadai = idGadai;
    }

    public String getIdGadai() {
        return idGadai;
    }

    public void setIdGadai(String idGadai) {
        this.idGadai = idGadai;
    }

    public Long getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void setJumlahPinjaman(Long jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public Date getTanggalPinjaman() {
        return tanggalPinjaman;
    }

    public void setTanggalPinjaman(Date tanggalPinjaman) {
        this.tanggalPinjaman = tanggalPinjaman;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public Long getSisa() {
        return sisa;
    }

    public void setSisa(Long sisa) {
        this.sisa = sisa;
    }

    public Date getTanggalDiterima() {
        return tanggalDiterima;
    }

    public void setTanggalDiterima(Date tanggalDiterima) {
        this.tanggalDiterima = tanggalDiterima;
    }

    public Barang getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Barang idBarang) {
        this.idBarang = idBarang;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGadai != null ? idGadai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gadai)) {
            return false;
        }
        Gadai other = (Gadai) object;
        if ((this.idGadai == null && other.idGadai != null) || (this.idGadai != null && !this.idGadai.equals(other.idGadai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idGadai + "";
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
