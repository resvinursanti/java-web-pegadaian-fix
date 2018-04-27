/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controller.LoginController;
import dao.AngsuranDAO;
import dao.CustomerDAO;
import dao.GadaiDAO;
import dao.LoginDAO;
import entities.Angsuran;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TAMU
 */
public class tes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
//        System.out.println(new CustomerDAO().check("c001", "12345"));
//String idlogin= "1";
//   String DATE_FORMAT = "yyyy/MM/dd";
//   DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
//   DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
//                        Date now = new Date();
//                        
//                        LocalDateTime localDateTime = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                        String pen = dateFormat8.format(localDateTime);
//                        System.out.println("localDateTime : " + pen);
//                        
//                        localDateTime = localDateTime.plusMonths(3).plusDays(7);
//                        String tanggalPengajuan = localDateTime.toString();
//                           Date jatuhTempo = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//                           String jat = dateFormat.format(jatuhTempo);
//                           System.out.println("\nOutput : " + jat );

//List<Object> datas = (List<Object>) session.getAttribute("angsurann");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                                int i = 1;
//                                for (Object data : datas) {
//        Angsuran c = (Angsuran) new AngsuranDAO().getAll().get(0);
        List<Object> ac = new AngsuranDAO().getByIdCustomer("C002");
        System.out.println(ac.size());
        for (Object object : ac) {
            Angsuran c = (Angsuran) object;
            System.out.println(c.getTanggalAngsuran().after(c.getIdGadai().getJatuhTempo()));
            String tgl = dateFormat.format(c.getTanggalAngsuran());
            Date tgl1 = dateFormat.parse(c.getTanggalAngsuran() + "");
            Date tgl2 = dateFormat.parse(c.getIdGadai().getJatuhTempo() + "");
            String tgl1s = new SimpleDateFormat("dd-MM-yyyy").format(tgl1);
            String tgl2s = new SimpleDateFormat("dd-MM-yyyy").format(tgl2);
            System.out.println(c.getTanggalAngsuran()+", "+c.getIdGadai().getJatuhTempo());
            System.out.println(tgl+", "+tgl1+" - before - "+tgl2+"? "+tgl1.before(tgl2));
            System.out.println(tgl+", "+tgl1+" - after - "+tgl2+"? "+tgl1.after(tgl2));
            System.out.println(tgl+" == "+tgl1s+"?");
            System.out.println(tgl+" == "+tgl2s+"?");
        }
//        String tgl = dateFormat.format(c.getTanggalAngsuran());
//        Date tgl1 = dateFormat.parse(c.getTanggalAngsuran() + "");
//        Date tgl2 = dateFormat.parse(c.getIdGadai().getJatuhTempo() + "");
//        tgl1.compareTo(tgl2);
//        float denda = c.getIdGadai().getJumlahPinjaman().floatValue();
//        float a = 12;
//        float b = 100;
//        if (tgl1.before(tgl2)) {
//System.out.println(tgl);
//            System.out.println(tgl1+", 0");
////        } else {
//            System.out.println(tgl2+", denda");
//        }

    }

}
