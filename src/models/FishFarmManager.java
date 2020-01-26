package models;

import exeptions.UnfoundObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FishFarmManager{

    public  static final int VALUE_NOT_FOUND_CODE = -1;
    public static final String SPECIES_UNFOUNDED_MESSAGE = "Especie no encontrada.";
    public static final String TOWN_UNFOUNDED_MESSAGE = "Municipio no encontrado.";

    private ArrayList<Town> townList;
    private ArrayList<Species> speciesList;

    public FishFarmManager(){
        this.townList = new ArrayList<>();
        this.speciesList = new ArrayList<>();
    }



    public void addTown(Town town){
        this.townList.add(town);
    }

    public int getTownId(int position){
        return this.townList.get(position).getId();
    }

    public int searchTown(int id) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < townList.size(); i++)
            if(townList.get(i).getId() == id){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(TOWN_UNFOUNDED_MESSAGE);
        else return position;
	}
	
    public int searchTownByName(String name) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < townList.size(); i++)
            if(townList.get(i).getName().equalsIgnoreCase(name)){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(TOWN_UNFOUNDED_MESSAGE);
        else return position;
    }

    public Town createTown(String name){
        return new Town(name);
    }

    public void removeTown(int townId) throws UnfoundObject{
        this.townList.remove(this.searchTown(townId));
    }

    public void addSpecies(Species species){
        this.speciesList.add(species);
    }

    public Species getSpecies(int position){
        return this.speciesList.get(position);
	}
	

    public int searchSpecies(int id) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < speciesList.size(); i++)
            if(speciesList.get(i).getId() == id){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(SPECIES_UNFOUNDED_MESSAGE);
        else return position;
    }

    public int searchSpeciesByName(String name) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < speciesList.size(); i++)
            if(speciesList.get(i).getName().equalsIgnoreCase(name)){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(SPECIES_UNFOUNDED_MESSAGE);
        else return position;
    }


    public Species createSpecies(int id, String name, double costByPound, WaterType waterType, Food food){
        return new Species(id, name, costByPound, waterType, food);
    }

    public void removeSpecies(int speciesId) throws UnfoundObject{
        this.speciesList.remove(this.searchSpecies(speciesId));
    }

    public void addCultive(Cultive cultive, int townId) throws UnfoundObject{
        this.townList.get(this.searchTown(townId)).addCultive(cultive);
    }

    public Cultive createCultive(int year, Species species,int cultivatedQuantity, int harvestedQuantity, double averageWeightByHarvestedAnimalKg, double costByKg){
        return new Cultive(year, species, cultivatedQuantity, harvestedQuantity, averageWeightByHarvestedAnimalKg, costByKg);
    }

    public void removeCultive(int cultiveId, int townId) throws UnfoundObject{
        this.townList.get(searchTown(townId)).removeCultive(cultiveId);
    }
    
    public ArrayList<Object[]> toObjectVectorTown() {
    	ArrayList<Object[]> toObjectVectorTown = new ArrayList<>();
    	for (Town town : townList) {
    		toObjectVectorTown.add(town.toObjectVector());
		}
    	return toObjectVectorTown;
    }

    public HashMap<String, ArrayList<Object[]>> townsAndCultives(){
    	HashMap<String, ArrayList<Object[]>> townsAndCultives = new HashMap<>();
		for (Town town : townList) {
			townsAndCultives.put(town.getName(), town.toObjectVectorCultives());
		}
		return townsAndCultives;
    }

//Esto es solo de prueba
    public void showConsoleReport(){
        for(Town tow: this.townList){
            System.out.println(tow.getId() + ". " + tow.getName());
            for(Cultive cultive: tow.getCultiveList()){
                System.out.println("\t" + cultive.getId() + ". Cultivo de " + cultive.getSpecies().getName() + "\n\t\t(" + cultive.getYear() + ") Catidad: " + cultive.getCultivatedQuantity());
            }
        }
    }
}