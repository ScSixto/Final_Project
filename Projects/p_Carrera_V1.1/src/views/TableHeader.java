package views;

public enum TableHeader {
    RUNNER_LIST(new String[]{"ID","Primer Nombre","Segundo Nombre","Apellido", "Fecha de Nacimiento", "Genero", "Equipo","Tiempo de Carrera","Edad"},new int[]{50,200,200,200,150,100, 80,150,40}),
    RUNNER_WINNER(new String[]{"ID","PRIMER NOMBRE","SEGUNDO NOMBRE","APELLIDO"},new int[]{50,200,200,200});

    private String[] headerTextArray;
    private int[] headerColsWidthArray;

    TableHeader(String[] headerText, int[] headerColsWidth) {
        this.headerTextArray = headerText;
        this.headerColsWidthArray = headerColsWidth;
    }

    public int[] getHeaderColsWidthArray() {
        return headerColsWidthArray;
    }

    public String[] getHeaderTextArray() {
        return headerTextArray;
    }
}
