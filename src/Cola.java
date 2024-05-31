import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Cola {

    private PriorityQueue<Empleado> listaEmpleados;
    public Cola(){
        listaEmpleados=new PriorityQueue<Empleado>();
    }
    public  void encolar (Empleado empleado){
        listaEmpleados.add(empleado);
    }

    public Empleado buscar(String cedula)throws Exception{
        for(Empleado e:listaEmpleados){
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        throw new Exception("No se encontro el empleado");
    }

    public void cambiar(Empleado empleado, String nombre, double sueldo){
        empleado.setNombreEmpleado(nombre);
        empleado.setSueldo(sueldo);
        empleado.calculaImpuesto(empleado);
        empleado.aporteSeguro();

    }

    public List<Empleado> listarEmpleado(){
        List<Empleado> lista = new LinkedList<>();
        for (Empleado e:listaEmpleados){
            lista.add(e);
        }
        return lista;

    }
    public List<Empleado>ordenarAporteB(List<Empleado> empleados){
        for(int i=0; i<empleados.size(); i++){
            boolean swapped = false;
            for(int j=0; j<empleados.size()-i-1; j++){
                Empleado p1=  empleados.get(j);
                Empleado p2 =  empleados.get(j+1);

                if(p1.getAporteSeguro()>p2.getAporteSeguro()){
                    empleados.set(j, p2);
                    empleados.set(j+1, p1);
                    swapped = true;
                }
            }
            if (swapped==false){
                break;
            }
        }
        return  empleados;

    }
    public List<Empleado>ordenarImpuestoB(List<Empleado> empleados){
        for(int i=0; i<empleados.size(); i++){
            boolean swapped = false;
            for(int j=0; j<empleados.size()-i-1; j++){
                Empleado p1=  empleados.get(j);
                Empleado p2 =  empleados.get(j+1);

                if(p1.getImpuestoRenta()>p2.getImpuestoRenta()){
                    empleados.set(j, p2);
                    empleados.set(j+1, p1);
                    swapped = true;
                }
            }
            if (swapped==false){
                break;
            }
        }
        return  empleados;

    }

    public List<Empleado>ordenarFondosB(List<Empleado> empleados){
        for(int i=0; i<empleados.size(); i++){
            boolean swapped = false;
            for(int j=0; j<empleados.size()-i-1; j++){
                Empleado p1=  empleados.get(j);
                Empleado p2 =  empleados.get(j+1);

                if(p1.getFondosReserva()>p2.getFondosReserva()){
                    empleados.set(j, p2);
                    empleados.set(j+1, p1);
                    swapped = true;
                }
            }
            if (swapped==false){
                break;
            }
        }
        return  empleados;

    }


    public PriorityQueue<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(PriorityQueue<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

}
