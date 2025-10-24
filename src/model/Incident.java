package model;
import java.time.LocalDate;

public class Incident {
    private LocalDate dateReport;
    private String description; 
    private Boolean solution;
    private Int solutionHours; 

    public Incident(LocalDate dateReport, String description ) {
     this.dateReport = dateReport;
     this.description = description;
    }

    public LocalDate getDateReport () { return dateReport; }
    public String getDescription () {return description; }
    public Boolean getSolution () { return solution; }
    public Int getSolutionHours () { return solutionHours; }

    public void setDateReport ( LocalDate dateReport) { this.dateReport = dateReport; }
    public void setDescription ( String description) { this.description = description; }
    public void setSolution ( Boolean solution) { this.solution = solution; }
    public void setSolutionHours ( Int solutionHours) { this.solutionHours = solutionHours; }


}
 