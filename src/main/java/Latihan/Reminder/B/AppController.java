/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latihan.Reminder.B;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class AppController {
    
    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model Diskon){
        
        String Nama = data.getParameter("nama_sayur");
        String Jumlah = data.getParameter("jumlah_sayur");
        String Harga = data.getParameter("harga_sayur");
        String Uang = data.getParameter("pembayaran");
        String diskon = "";
      
        Double Quantity = Double.valueOf(Jumlah);
        Double Price = Double.valueOf(Harga);
        Double Money = Double.valueOf(Uang);
        Double Total = Price * Quantity;
        Double getTotal = null;
      
        if (Total < 16000)
        {
          getTotal = Total - (0 * Total/100);
          diskon = "0%";
        }
       else if (Total >= 16000 && Total < 25000)
        {
           getTotal = Total - (10 * Total/100);
           diskon = "10%";
        }
        else if (Total >= 25000)
        {
           getTotal = Total - (15 * Total/100);
           diskon = "15%";
        }
        
        Double Kembalian = Money - getTotal;
        
        Diskon.addAttribute("nama_sayur", Nama);
        Diskon.addAttribute("harga_sayur", Total);
        Diskon.addAttribute("jumlah_sayur", Jumlah);
        Diskon.addAttribute("pembayaran", Uang);
        Diskon.addAttribute("diskon_harga",diskon);
        Diskon.addAttribute("total", getTotal);
        Diskon.addAttribute("kembalian", Kembalian);
        
        return "daftarview";
    }
}
