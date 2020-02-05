package models;

public enum EmployeeVariable {
    FIRST_NAME("Nombres"), LAST_NAME("Apellidos"), DOCUMENT_TYPE("Tipo documento"),
    DOCUMENT_NUMBER("Numero Documento"), BONDING_TYPE("Tipo vinculacion"), RANKING_CATEGORY("Categoria"), SALARY_POINTS("Puntos salariales"), WORKED_MONTHS("Meses laborados");

    private String jsonName;

    EmployeeVariable(String jsonName){
        this.jsonName = jsonName;
    }

    public String getJsonName(){
        return jsonName;
    }
}