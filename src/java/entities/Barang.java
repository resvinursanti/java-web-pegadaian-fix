/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TAMU
 */
@Entity
@Table(name = "BARANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b")
    , @NamedQuery(name = "Barang.findByIdBarang", query = "SELECT b FROM Barang b WHERE b.idBarang = :idBarang")
    , @NamedQuery(name = "Barang.findByNamaBarang", query = "SELECT b FROM Barang b WHERE b.namaBarang = :namaBarang")
    , @NamedQuery(name = "Barang.findByKualitas", query = "SELECT b FROM Barang b WHERE b.kualitas = :kualitas")})
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BARANG")
    private String idBarang;
    @Column(name = "NAMA_BARANG")
    private String namaBarang;
    @Column(name = "KUALITAS")
    private String kualitas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarang", fetch = FetchType.LAZY)
    private List<Gadai> gadaiList;
    @JoinColumn(name = "ID_JENIS_BARANG", referencedColumnName = "ID_JENIS_BARANG")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private JenisBarang idJenisBarang;

    public Barang() {
    }

    public Barang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKualitas() {
        return kualitas;
    }

    public void setKualitas(String kualitas) {
        this.kualitas = kualitas;
    }

    @XmlTransient
    public List<Gadai> getGadaiList() {
        return gadaiList;
    }

    public void setGadaiList(List<Gadai> gadaiList) {
        this.gadaiList = gadaiList;
    }

    public JenisBarang getIdJenisBarang() {
        return idJenisBarang;
    }

    public void setIdJenisBarang(JenisBarang idJenisBarang) {
        this.idJenisBarang = idJenisBarang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarang != null ? idBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idBarang + "";
    }
    
}
