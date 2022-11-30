package ui.movimientosConsultas;

import components.Validaciones;
import model.CtaBancaria;
import model.Movimiento;
import model.TitulosPantallas;
import ui.SubMenuPantallaMovCons;

import javax.swing.*;
import java.text.DecimalFormat;

public class SubPantallasMovimientosConsultas {

    //generador de numero aleatorio
    private static final double CAMBIO=(Math.random() * (190 - 160)) + 160;
    SubMenuPantallaMovCons pantallaMovCon = new SubMenuPantallaMovCons();
    private Validaciones validaciones = new Validaciones();

    public void mostrarMovimientos(CtaBancaria ctaBancaria) {
        int cont=1;
        String listado= "";
        DecimalFormat df = new DecimalFormat("0.00");
        if(ctaBancaria.getMovimientos()!=null) {
            StringBuilder listadoBuilder = new StringBuilder();
            for (Movimiento movimiento : ctaBancaria.getMovimientos()) {
                listadoBuilder.append("\nN°:")
                        .append(cont)
                        .append(" - FECHA: ")
                        .append(validaciones.formatFecha(movimiento.getFecha()))
                        .append(" - CONCEPTO: ")
                        .append(movimiento.getTipoOperacion()).append(" $ ")
                        .append(df.format(movimiento.getMontoOperacion()));
                cont += 1;
            }
            listado = listadoBuilder.toString();
        }
            JOptionPane.showMessageDialog(null, "                                  ULTIMOS MOVIMIENTOS           \n" +
                            "\n" +
                            "" + ctaBancaria.getTipoCuentaBancaria() + " N°" + ctaBancaria.getNumCta() + "\n" +
                            "\n" +
                            "" + (listado!=null?listado:"NO EXISTEN MOVIMIENTOS") + "\n" +
                            "\n" +
                            "Saldo de la  " + ctaBancaria.getTipoCuentaBancaria() + " N°" + ctaBancaria.getNumCta() + " $" + df.format(ctaBancaria.getSaldo())
                    ,TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE);

        pantallaMovCon.pantallaSubMenuMovconsultas(ctaBancaria);
    }

    public void mostrarSaldo(CtaBancaria ctaBancaria) {
        JOptionPane.showMessageDialog(null,"             CONSULTA SALDO CAJA DE AHORRO           \n" +
                "\n" +
                "Saldo de la "+ctaBancaria.getTipoCuentaBancaria()+" N°"+ctaBancaria.getNumCta()+
                " $"+ ctaBancaria.getSaldo()+"\n"+
                "\n", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
        pantallaMovCon.pantallaSubMenuMovconsultas(ctaBancaria);
    }

    public void tipoCambio(CtaBancaria cuentaBancaria) {
       DecimalFormat df = new DecimalFormat("0.00");
       DecimalFormat dfUSD = new DecimalFormat("0.0000");

        JOptionPane.showMessageDialog(null,"              CONSULTA TIPO CAMBIO            \n" +
                "\n" +
                cuentaBancaria.getTipoCuentaBancaria()+" N° " + cuentaBancaria.getNumCta()+"\n" +
                "\n" +
                "El tipo de cambio de ARS a USD es:\n" +
                "\n" +
                "1 USD -"+df.format(CAMBIO)+" ARS\n" +
                "\n" +
                "1 ARS -"+dfUSD.format(1/CAMBIO)+" USD\n", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE );
        pantallaMovCon.pantallaSubMenuMovconsultas(cuentaBancaria);

    }
    public void consultaCBU(CtaBancaria cuentaBancaria){
        JOptionPane.showMessageDialog(null,"              CONSULTA CBU            \n" +
                "\n" +
                cuentaBancaria.getTipoCuentaBancaria()+" N° " + cuentaBancaria.getNumCta()+"\n" +
                "\n" +
                "CBU:"+cuentaBancaria.getCBU()+"\n", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
        pantallaMovCon.pantallaSubMenuMovconsultas(cuentaBancaria);

    }
}