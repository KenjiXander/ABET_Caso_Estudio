import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaEmpleados {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton ingresarButton;
    private JTextArea textArea1;
    private JButton buscarEmpleadoButton;
    private JButton calcularAntiguedadButton;
    private JTextArea textArea2;
    private JButton calcularFondosDeReservaButton;
    private JTextArea textArea3;
    private JButton calcularAporteAlSeguroButton;
    private JTextArea textArea4;
    private JButton calcularImpuestoALaButton;
    private JTextArea textArea5;
    private JTextField textCedula;
    private JTextField textNombreEmpleado;
    private JTextField textDiaIngreso;
    private JTextField textMesIngreso;
    private JTextField textAnoIngreso;
    private JTextField textSueldoMensual;
    private JButton modificarButton;

    private List<Empleado> empleados;

    public VentanaEmpleados() {

        empleados = new ArrayList<>();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = textField1.getText();
                String nombre = textField2.getText();
                int dia = Integer.parseInt(textField3.getText());
                int mes = Integer.parseInt(textField4.getText());
                int anio = Integer.parseInt(textField5.getText());
                double sueldo = Double.parseDouble(textField6.getText());

                Fechas fechaIngreso = new Fechas(dia, mes, anio);
                Empleado empleado = new Empleado(cedula, nombre, fechaIngreso, sueldo, 0, 0, 0);

                empleado.aporteSeguro();
                empleado.calculaImpuesto(empleado);
                empleado.calcularFondos();

                empleados.add(empleado);
                JOptionPane.showMessageDialog(null, "El empleado ha sido agregado");
                limpiar();
                textArea1.append(empleado.toString() + "\n");
            }
        });
        buscarEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaBuscada = textCedula.getText();
                Empleado empleadoEncontrado = null;
                for (Empleado emp : empleados) {
                    if (emp.getCedula().equals(cedulaBuscada)) {
                        empleadoEncontrado = emp;
                        break;
                    }
                }
                if (empleadoEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "No existe ningun empleado con esa cedula");
                } else {
                    textNombreEmpleado.setText(empleadoEncontrado.getNombreEmpleado());
                    textDiaIngreso.setText(String.valueOf(empleadoEncontrado.getFechaIngreso().getDia()));
                    textMesIngreso.setText(String.valueOf(empleadoEncontrado.getFechaIngreso().getMes()));
                    textAnoIngreso.setText(String.valueOf(empleadoEncontrado.getFechaIngreso().getAnio()));
                    textSueldoMensual.setText(String.valueOf(empleadoEncontrado.getSueldo()));
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaBuscada = textCedula.getText();
                Empleado empleadoEncontrado = null;
                for (Empleado emp : empleados) {
                    if (emp.getCedula().equals(cedulaBuscada)) {
                        empleadoEncontrado = emp;
                        break;
                    }
                }
                if (empleadoEncontrado != null) {
                    empleadoEncontrado.setNombreEmpleado(textNombreEmpleado.getText());
                    int dia = Integer.parseInt(textDiaIngreso.getText());
                    int mes = Integer.parseInt(textMesIngreso.getText());
                    int anio = Integer.parseInt(textAnoIngreso.getText());
                    Fechas nuevaFechaIngreso = new Fechas(dia, mes, anio);
                    empleadoEncontrado.setFechaIngreso(nuevaFechaIngreso);
                    double nuevoSueldo = Double.parseDouble(textSueldoMensual.getText());
                    empleadoEncontrado.setSueldo(nuevoSueldo);

                    empleadoEncontrado.aporteSeguro();
                    empleadoEncontrado.calculaImpuesto(empleadoEncontrado);
                    empleadoEncontrado.calcularFondos();

                    JOptionPane.showMessageDialog(null, "Información del empleado ha sido modificada");
                    limpiarMod();
                    textArea1.setText("");
                    for (Empleado emp : empleados) {
                        textArea1.append(emp.toString() + "\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ningun empleado con esa cedula");
                }
            }
        });

    }

    private void limpiar(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
    }

    private void limpiarMod(){
        textCedula.setText("");
        textNombreEmpleado.setText("");
        textDiaIngreso.setText("");
        textMesIngreso.setText("");
        textAnoIngreso.setText("");
        textSueldoMensual.setText("");
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaEmpleados");
        frame.setContentPane(new VentanaEmpleados().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
    }
}
