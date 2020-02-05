package models;

public enum RankingCategory{
    AUXILIARY("Auxiliar"),ASSISTANT("Asistente"),ASSOCIATED("Asociado"),HEADLINE("Titular");

    private String text;

    RankingCategory(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}