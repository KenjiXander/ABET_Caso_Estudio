import java.util.GregorianCalendar;

public class Fechas {

    private int dia;
    private int mes;
    private int anio;

    public Fechas(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }


    public Fechas fechaActual(){
        GregorianCalendar cal = new GregorianCalendar();
        int dia = cal.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = cal.get(GregorianCalendar.MONTH) + 1;
        int anio = cal.get(GregorianCalendar.YEAR);

        Fechas fecha = new Fechas(dia,mes,anio);
        return fecha;
    }


    public int tiempoFechas(Fechas ingreso, Fechas fechaActual){
        int inicioMes = ingreso.getAnio() * 12 + ingreso.getMes();
        int finMes = fechaActual.getAnio() * 12 + fechaActual.getMes();

        return finMes - inicioMes;
    }




    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Fecha: " +
                dia + "/" +
                mes + "/" +
                anio;
    }
}
