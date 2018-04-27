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
@Table(name = "JENIS_BARANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisBarang.findAll", query = "SELECT j FROM JenisBarang j")
    , @NamedQuery(name = "JenisBarang.findByIdJenisBarang", query = "SELECT j FROM JenisBarang j WHERE j.idJenisBarang = :idJenisBarang")
    , @NamedQuery(name = "JenisBarang.findByNamaJenisBarang", query = "SELECT j FROM JenisBarang j WHERE j.namaJenisBarang = :namaJenisBarang")})
public class JenisBarang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_JENIS_BARANG")
    private String idJenisBarang;
    @Column(name = "NAMA_JENIS_BARANG")
    private String namaJenisBarang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJenisBarang", fetch = FetchType.LAZY)
    private List<Barang> barangList;

    public JenisBarang() {
    }

    public JenisBarang(String idJenisBarang) {
        this.idJenisBarang = idJenisBarang;
    }

    public String getIdJenisBarang() {
        return idJenisBarang;
    }

    public void setIdJenisBarang(String idJenisBarang) {
        this.idJenisBarang = idJenisBarang;
    }

    public String getNamaJenisBarang() {
        return namaJenisBarang;
    }

    public void setNamaJenisBarang(String namaJenisBarang) {
        this.namaJenisBarang = namaJenisBarang;
    }

    @XmlTransient
    public List<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJenisBarang != null ? idJenisBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JenisBarang)) {
            return false;
        }
        JenisBarang other = (JenisBarang) object;
        if ((this.idJenisBarang == null && other.idJenisBarang != null) || (this.idJenisBarang != null && !this.idJenisBarang.equals(other.idJenisBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idJenisBarang + "";
    }
    
}
