public class Empleado implements Comparable<Empleado> {

    private String cedula;
    private String nombreEmpleado;
    private Fechas fechaIngreso;
    private double sueldoMensual;
    private double aporteSeguro;
    private double impuestoRenta;

    private double fondosReserva;

    public Empleado(String cedula, String nombreEmpleado, Fechas fechaIngreso, double sueldo, double aporteSeguro, double impuestoRenta, double fondosReserva) {
        this.cedula = cedula;
        this.nombreEmpleado = nombreEmpleado;
        this.fechaIngreso = fechaIngreso;
        this.sueldoMensual = sueldo;
        this.aporteSeguro = aporteSeguro;
        this.impuestoRenta = impuestoRenta;
        this.fondosReserva = fondosReserva;
    }

    public void aporteSeguro(){
        setAporteSeguro((getSueldo()*9.35)/100);
    }

    public void impuestoRenta(Empleado empleado){
        if (empleado.getSueldo()>0 && empleado.getSueldo()<=5000){
            empleado.setImpuestoRenta(0);
        } else if (empleado.getSueldo()>5000&& empleado.getSueldo()<=10000) {
            double exceso= empleado.getSueldo()-5000;
            empleado.setImpuestoRenta((exceso*(10))/100);
        } else if (empleado.getSueldo()>10000 && empleado.getSueldo()<=18000) {
            double exceso= empleado.getSueldo()-10000;
            empleado.setImpuestoRenta((exceso*(20))/100);
        } else if (empleado.getSueldo()>18000) {
            double exceso= empleado.getSueldo()-18000;
            empleado.setImpuestoRenta(exceso*((exceso*(30))/100));
        }
    }

    public void calcularFondos(){
        int  tiempoTotal = (fechaIngreso.tiempoFechas(fechaIngreso, fechaIngreso.fechaActual()))/12;

        if (tiempoTotal>=1){
            fondosReserva=tiempoTotal*sueldoMensual;
        }else {
            fondosReserva=0;
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Fechas getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fechas fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSueldo() {
        return sueldoMensual;
    }

    public void setSueldo(double sueldo) {
        this.sueldoMensual = sueldo;
    }

    public double getAporteSeguro() {
        return aporteSeguro;
    }

    public void setAporteSeguro(double aporteSeguro) {
        this.aporteSeguro = aporteSeguro;
    }

    public double getImpuestoRenta() {
        return impuestoRenta;
    }

    public void setImpuestoRenta(double impuestoRenta) {
        this.impuestoRenta = impuestoRenta;
    }

    public double getFondosReserva() {
        return fondosReserva;
    }

    public void setFondosReserva(double fondosReserva) {
        this.impuestoRenta = fondosReserva;
    }


    @Override
    public String toString() {
        return "Cedula: " + cedula + "\n" +
                "Nombre del Empleado: " + nombreEmpleado + "\n" +
                "Fecha de ingreso: " + fechaIngreso + "\n" +
                "Sueldo mensual: " + sueldoMensual + "\n" +
                "Aporte al Seguro Social: " + aporteSeguro + "\n" +
                "Impuesto a la renta: " + impuestoRenta + "\n" +
                "Fondos de reserva: " + fondosReserva + "\n";
    }

    @Override
    public int compareTo(Empleado o) {
        if(sueldoMensual < o.getSueldo()){
            return 1;
        } else if(sueldoMensual > o.getSueldo()){
            return -1;
        } else{
            return 0;
        }
    }
}
