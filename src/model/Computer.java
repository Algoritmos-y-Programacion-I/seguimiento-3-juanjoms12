package model;
import java.util.ArrayList; 

public class Computer {
    private String SerialNumber; 
    private Boolean nextWindow; 
    private Arraylist <> listaDeIncidente = new Arraylist <>();

    public Computer(String SerialNumber, Boolean nextWindow) {
        this.SerialNumber = SerialNumber ;
        this.nextWindow = nextWindow ; 

    }

 public String getSerialNumber () { return SerialNumber;}
 public void setSerialNumber (String SerialNumber) { this.SerialNumber = SerialNumber ;}

 public Boolean getNextWindow () { return nextWindow; }
 public void setNextWindow (Boolean nextWindow) { this.nextWindow = nextWindow ;}

 public ArrayList <> listaDeIncidente () { return listaDeIncidente;}
 public void setListaDeIncidente (Arraylist <> listaDeIncidente) { this.listaDeIncidente = listaDeIncidente ;}

    public void addIncident(LocalDate dateReport, String description ) {
        listaDeIncidente.add(new Incident())
    }

}
