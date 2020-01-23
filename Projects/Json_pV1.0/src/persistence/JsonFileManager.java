package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonFileManager{
    public ArrayList<Player> readFile(String fileName) throws FileNotFoundException, IOException, DeserializationException{
        ArrayList<Player> playerList = new ArrayList<Player>();
        //JsonObject jsonObject = (JsonObject) Jsoner.deserialize(new FileReader(fileName));
        //JsonArray listOfPlayer = (JsonArray) JsonObject.get("");

    }
}