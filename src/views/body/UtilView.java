package views.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.awt.Color;


public class UtilView {

    public static HashMap<String, Double> getPercentValues(HashMap<String, Double> normalValues){
        HashMap<String, Double> percentValues = new HashMap<>();
        double maxValue = getMaxValue(getHasMapValues(normalValues));
        Iterator<Entry<String,Double>> it = normalValues.entrySet().iterator();
        while(it.hasNext()){
            Entry<String,Double> value = it.next();
            percentValues.put(value.getKey(), value.getValue() * 100 / maxValue);
        }
        return percentValues;
    }

    public static double getMaxValue(ArrayList<Double> values){
        double maxValue = 0;
        for (double value : values) {
            if(value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }

    public static int getMaxValueInteger(ArrayList<Integer> values){
        int maxValue = 0;
        for (Integer value : values) {
            if(value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }

    public static Color getRandomColor(){
        int r = getRandomNumBetween(1,255);
        int g = 0;
        int b = 0;
        if(r > 120){
            g = getRandomNumBetween(120,255);
            b = getRandomNumBetween(20,200);
        }else{
            g = getRandomNumBetween(1,125);
            b = getRandomNumBetween(35,240);
        }
        float[] hsbColor = Color.RGBtoHSB(r,g,b,null);
        return Color.getHSBColor(hsbColor[0], hsbColor[1], hsbColor[2]);
    }

    public static int getRandomNumBetween(int minValue, int maxValue){
        return (int) (((Math.random() * (maxValue - minValue))) + minValue);
    }

    public static String getRoundedValue(double value){
        double roundedValue = value;
        String roundedValueFormat = "";
        int count = 0;
        while(roundedValue/1000 >= 1 && count <= getMaxValueInteger(CountValueToRoundNumber.getValueList())){
            roundedValue = calculateRoundedValue(roundedValue);
            count++;
        }
        roundedValueFormat = String.format("%1.1f",roundedValue) + getCountValueToRoundNumber(count);
        return roundedValueFormat;
    }

    public static double calculateRoundedValue(double value){
        return value/1000;
    }

    public static String getCountValueToRoundNumber(int count){
        int countMaxValueToRoundNumber = getMaxValueInteger(CountValueToRoundNumber.getValueList());
        String countText = CountValueToRoundNumber.values()[countMaxValueToRoundNumber].getText();
        for (CountValueToRoundNumber countValue : CountValueToRoundNumber.values()){
            if(count == countValue.getValue()){
                countText = countValue.getText();
            }
        }
        return countText;
    }

	public static ArrayList<Double> getHasMapValues(HashMap<String, Double> hashMap) {
        ArrayList<Double> hashMapValues = new ArrayList<>();
        Iterator<Entry<String, Double>> it = hashMap.entrySet().iterator();
        while(it.hasNext()){
            hashMapValues.add(it.next().getValue());
        }
        return hashMapValues;
	}
}