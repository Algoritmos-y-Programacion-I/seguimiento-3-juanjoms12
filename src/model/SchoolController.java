package model;

import java.time.LocalDate;

public class SchoolController {

    private String name;
    private int hourSpentSupport;
    private final int FLOORS = 5;
    private final int COL = 10;
    private final int HOURSMAXSUPPORT = 100;
    private Computer[][] computersMatrix;

    public SchoolController() {
        this.name = "Escuela Computaricemos";
        this.hourSpentSupport = 0;
        this.computersMatrix = new Computer[FLOORS][COL];
    }

    public String agregarComputador(String serialNumber, boolean nextWindow, int floor) {
        if (floor < 1 || floor > FLOORS) {
            return "Piso inválido. Debe estar entre 1 y " + FLOORS;
        }

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COL; j++) {
                if (computersMatrix[i][j] != null &&
                    computersMatrix[i][j].getSerialNumber().equals(serialNumber)) {
                    return "Ya existe un computador con ese número serial.";
                }
            }
        }

        int row = floor - 1;
        for (int j = 0; j < COL; j++) {
            if (computersMatrix[row][j] == null) {
                computersMatrix[row][j] = new Computer(serialNumber, nextWindow);
                return "Computador agregado correctamente en el piso " + floor + ", columna " + (j + 1);
            }
        }

        return "No hay espacio disponible en el piso " + floor;
    }

    public String agregarIncidenteEnComputador(String serialNumber, LocalDate dateReport,
                                               String description, boolean solution, int solutionHours) {

        Computer comp = buscarComputador(serialNumber);

        if (comp == null) {
            return "No se encontró el computador con el serial: " + serialNumber;
        }

        if ((hourSpentSupport + solutionHours) > HOURSMAXSUPPORT) {
            return "No hay horas de soporte disponibles.";
        }

        // Llamamos al método addIncident de Computer (mismo nombre que definimos)
        comp.addIncident(dateReport, description, solution, solutionHours);
        hourSpentSupport += solutionHours;

        return "Incidente agregado correctamente. Horas de soporte restantes: " + (HOURSMAXSUPPORT - hourSpentSupport);
    }

    public String getComputerList() {
        String info = "";

        for (int i = 0; i < FLOORS; i++) {
            info += "=== Piso " + (i + 1) + " ===\n";
            for (int j = 0; j < COL; j++) {
                Computer c = computersMatrix[i][j];
                if (c != null) {
                    info += "Serial: " + c.getSerialNumber() + "\n";
                    info += "Próxima ventana activa: " + (c.getNextWindow() ? "Sí" : "No") + "\n";

                    if (c.getListaDeIncidente().isEmpty()) {
                        info += "   (Sin incidentes registrados)\n";
                    } else {
                        info += "   Incidentes:\n";
                        for (Incident inc : c.getListaDeIncidente()) {
                            info += "     - " + inc.toString() + "\n";
                        }
                    }
                }
            }
        }

        if (info.equals("")) {
            info = "No hay computadores registrados.";
        }

        return info;
    }

    private Computer buscarComputador(String serial) {
        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COL; j++) {
                if (computersMatrix[i][j] != null &&
                    computersMatrix[i][j].getSerialNumber().equals(serial)) {
                    return computersMatrix[i][j];
                }
            }
        }
        return null;
    }
}
