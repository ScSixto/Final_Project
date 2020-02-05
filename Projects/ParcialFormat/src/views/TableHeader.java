package views;

public enum TableHeader {
    ALGO_LIST(new String[]{"ID","Primer Nombre","Segundo Nombre","Apellido", "Equipo","Tiempo de Carrera"},new int[]{50,200,200,200, 80,150}),
    ALGO_WINNER(new String[]{"ID","PRIMER NOMBRE","SEGUNDO NOMBRE","APELLIDO"},new int[]{50,200,200,200});

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
