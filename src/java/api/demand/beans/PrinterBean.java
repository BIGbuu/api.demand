/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api.demand.beans;

import api.demand.model.Printer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author BIG_bu
 */
@Named("printerBean")
@RequestScoped
public class PrinterBean {
    List <Printer> printers;
    Printer printer;
    
    public PrinterBean(){
        
    }
    
    public List<Printer> getPrinters(){
        return printers;
    }
    public Printer getDefaultPrinter(){
        return printer;
    }
    
}
