package risky.javaclasss;

import java.util.ArrayList;

/**
 * Created by D2J-00 on 01/02/2017.
 */
public class transaksi {

    private ArrayList<barang> listBarang = new ArrayList<>();

    public void addBarang(barang barang)
    {
        this.listBarang.add(barang);
    }

    public int totalTransaksi()
    {
        int hasil=0;
        for(int i=0; i<listBarang.size(); i++)
        {
            hasil+=listBarang.get(i).getHarga();
        }
        return hasil;
    }

    public String printTransaksi()
    {
        String text = "Barang yang dibeli pada transaksi ini adalah : \n";
        text+="----------------------------------------------\n";
        for(int i=0; i<listBarang.size(); i++)
        {
            text+=listBarang.get(i).toString();
        }
        text+="----------------------------------------------\n";
        text+="Total Pembelian : "+totalTransaksi()+"\n";
        text+="----------------------------------------------\n";
        return text;
    }

    public double averageTransaksi()
    {
        double hasil=0;

        hasil=totalTransaksi()/listBarang.size();

        return hasil;
    }

    public String maxBarang()
    {   barang max;

        max=listBarang.get(0);
        for(int i=0; i<listBarang.size(); i++)
        {
            if(listBarang.get(i).getHarga()>max.getHarga())
            {
                max=listBarang.get(i);
            }
        }

        String namaBarang=max.getNama();
        String  text="----------------------------------------------\n";
        text+="Barang dengan harga termahal adalah "+namaBarang;
        return text;
    }
}

