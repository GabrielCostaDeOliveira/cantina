package cantina.dados;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import javafx.collections.ObservableList;

public class Pedido {

    private Pessoa donoDoPedido;
    private Calendar data;
    private ObservableList<ItemDoCardapio> comanda;
   
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/Y");

    public Pedido(Pessoa donoDoPedido, ObservableList<ItemDoCardapio> comanda){
        this.comanda=comanda;
        this.donoDoPedido = donoDoPedido;
        data = Calendar.getInstance();
    }

    public Pessoa getPessoa(){
        return donoDoPedido;
    }

    public Calendar getCalendar(){
        return data;
    }

    public void setItemDoCardapio(ItemDoCardapio itemDoCardapio){
        this.comanda.add(itemDoCardapio);
    }
    public ObservableList<ItemDoCardapio> getComanda(){
        return comanda;
    }

    public String getDataFormatada(){
        return sdf.format(data.getTime());
    }

    public String getNomesDosItemsFormatados(){
        String nomeDosItemsFormatados="";
        for (ItemDoCardapio itemDoCardapio : comanda) {
            nomeDosItemsFormatados+=itemDoCardapio.getNome().toString()+"\n";
        }
        return nomeDosItemsFormatados;
    }

}