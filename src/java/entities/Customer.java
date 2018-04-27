/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TAMU
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByIdCustomer", query = "SELECT c FROM Customer c WHERE c.idCustomer = :idCustomer")
    , @NamedQuery(name = "Customer.findByNomorKtp", query = "SELECT c FROM Customer c WHERE c.nomorKtp = :nomorKtp")
    , @NamedQuery(name = "Customer.findByNamaCustomer", query = "SELECT c FROM Customer c WHERE c.namaCustomer = :namaCustomer")
    , @NamedQuery(name = "Customer.findByNomorTelepon", query = "SELECT c FROM Customer c WHERE c.nomorTelepon = :nomorTelepon")
    , @NamedQuery(name = "Customer.findByPekerjaan", query = "SELECT c FROM Customer c WHERE c.pekerjaan = :pekerjaan")
    , @NamedQuery(name = "Customer.findByAlamat", query = "SELECT c FROM Customer c WHERE c.alamat = :alamat")
    , @NamedQuery(name = "Customer.findByJenisKelamin", query = "SELECT c FROM Customer c WHERE c.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password")
    , @NamedQuery(name = "Customer.findByUsername", query = "SELECT c FROM Customer c WHERE c.username = :username")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CUSTOMER")
    private String idCustomer;
    @Column(name = "NOMOR_KTP")
    private Long nomorKtp;
    @Column(name = "NAMA_CUSTOMER")
    private String namaCustomer;
    @Column(name = "NOMOR_TELEPON")
    private String nomorTelepon;
    @Column(name = "PEKERJAAN")
    private String pekerjaan;
    @Column(name = "ALAMAT")
    private String alamat;
    @Column(name = "JENIS_KELAMIN")
    private String jenisKelamin;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;

    public Customer() {
    }

    public Customer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(String idCustomer, String password, String username) {
        this.idCustomer = idCustomer;
        this.password = password;
        this.username = username;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(Long nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idCustomer + "";
    }
    
}
