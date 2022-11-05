package ui;

import components.Validaciones;
import model.CtaBancaria;
import ui.movimientosConsultas.SubPantallasMovimientosConsultas;

import javax.swing.*;

public class SubMenuPantallaMovCons {

    public void pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE EL TIPO DE               \n")
                .append("           OPERACION QUE DESEA EFECTUAR              \n")
                .append("\n").append("         CONSULTA DE      TIPO DE    \n")
                .append("1<--------SALDOS          CAMBIO------------>2\n")
                .append("\n").append("3<--CONSULTA CBU      ULTIMOS\n")
                .append("                                           MOVIMIENTOS------->4\n")
                .append("0<--------VOLVER                                  ")
                .toString()));
        opcionSeleccion(opcion,ctaBancaria);
    }
    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallasMovimientosConsultas subPantallasMovimientosConsultas = new SubPantallasMovimientosConsultas();
        Validaciones validaciones = new Validaciones();
        while (validaciones.validaIngMenuPrin(opcion)) {
            switch(opcion) {
                case 1:
                    subPantallasMovimientosConsultas.mostrarSaldo(ctaBancaria);
                    break;
                case 2: subPantallasMovimientosConsultas.tipoCambio(ctaBancaria);
                    break;
                case 3: subPantallasMovimientosConsultas.consultaCBU(ctaBancaria);
                    break;
                case 4:
                    subPantallasMovimientosConsultas.mostrarMovimientos(ctaBancaria);
                    break;
                case 0:
                    break;
            }
            opcion=-10;
        }
    }

}
