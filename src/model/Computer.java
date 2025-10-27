package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Computer {

    private String serialNumber;
    private boolean nextWindow;
    private ArrayList<Incident> listaDeIncidente;

    public Computer(String serialNumber, boolean nextWindow) {
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;
        this.listaDeIncidente = new ArrayList<Incident>();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean getNextWindow() {
        return nextWindow;
    }

    public ArrayList<Incident> getListaDeIncidente() {
        return listaDeIncidente;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }

    public void setListaDeIncidente(ArrayList<Incident> listaDeIncidente) {
        this.listaDeIncidente = listaDeIncidente;
    }

    
    public void addIncident(LocalDate dateReport, String description, boolean solution, int solutionHours) {
        Incident nuevo = new Incident(dateReport, description);
        nuevo.setSolution(solution);
        nuevo.setSolutionHours(solutionHours);
        listaDeIncidente.add(nuevo);
    }
}
