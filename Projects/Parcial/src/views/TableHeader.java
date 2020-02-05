package views;

public enum TableHeader {
    EMPLOYEE_LIST(new String[]{"ID","Nombre","Apellido", "Categoria","Tipo de Documento","Puntos Salariales","Meses Trabajados","Salario Basico","Salario Neto"},new int[]{50,120,120,80,150,50,50,50,50}),
    EMPLOYEE_WINNER(new String[]{"ID","PRIMER NOMBRE","SEGUNDO NOMBRE","APELLIDO"},new int[]{50,200,200,200});

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
