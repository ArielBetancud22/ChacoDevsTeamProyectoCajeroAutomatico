package model;

import java.util.ArrayList;
import java.util.List;

public class CtaBancaria {
    private static final int NRO_CTA_BANCARIA=(int) (Math.random() * (999999 - 100000)) + 100000 ;
    private Persona persona;
    private int numCta;
    private double saldo;
    private String tipoCuentaBancaria;
    private List<Movimiento> movimientos;
    private String CBU;
    private User user;

    public CtaBancaria() {
        armarCBU();
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria) {
        this.persona = persona;
        this.numCta = NRO_CTA_BANCARIA;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        armarCBU();
        crearUsuarioAdmin();
    }

    public CtaBancaria(double saldo, String tipoCuentaBancaria) {
        this.numCta = NRO_CTA_BANCARIA;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        armarCBU();
        crearUsuarioAdmin();
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria, List<Movimiento> movimientos) {
        this.persona = persona;
        this.numCta = NRO_CTA_BANCARIA;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.movimientos = movimientos;
        armarCBU();
        crearUsuarioAdmin();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User usario) {
        this.user = usario;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public boolean guardarValidarMovimiento(Movimiento movimiento){
        if(movimiento!=null){
            List<Movimiento> movimientoList = new ArrayList<>();
            if (this.validarSaldo(movimiento.getMontoOperacion())) {
                movimientoList.add(movimiento);
                if (this.getMovimientos() != null)
                    this.getMovimientos().add(movimiento);
                else
                    this.setMovimientos(movimientoList);
                this.actualizaSaldoCta(movimiento);
                return true;
            } else return false;
        }else return false;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getNumCta() {
        return numCta;
    }

    public void setNumCta(int numCta) {
        this.numCta = numCta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuentaBancaria() {
        return tipoCuentaBancaria;
    }

    public void setTipoCuentaBancaria(String tipoCuentaBancaria) {
        this.tipoCuentaBancaria = tipoCuentaBancaria;
    }

    private void armarCBU(){
        String CBU="311000000000"+this.getNumCta();
        this.setCBU(CBU);
    }

    public void sumaSaldo(double montoOperacion){
        this.setSaldo(this.getSaldo()+montoOperacion);
    }

    public boolean validarSaldo(double montoOperacion){
        return this.getSaldo() + montoOperacion > 0;
    }

    public void restaSaldo( double montoOperacion){
        if (validarSaldo(montoOperacion))
            this.setSaldo(this.getSaldo()+montoOperacion);
    }

    public void actualizaSaldoCta(Movimiento movimiento){
        if (movimiento.getMontoOperacion()<0){
            restaSaldo(movimiento.getMontoOperacion());
        }else
            sumaSaldo(movimiento.getMontoOperacion());
    }

    public void crearUsuarioAdmin(){
        this.setUser(new User("ADMIN","1234"));
    }
}
