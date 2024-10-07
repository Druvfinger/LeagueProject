import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {




    public ImageIcon getChampPortrait(String champion){
        return new ImageIcon("C:/Users/Richard/IdeaProjects/LeagueProject/src/main/resources/dragontail-14.19.1/14.19.1/img/champion/" + champion + ".png");
    }
    public List<String> getChampionsList(){
        List<String> championsList = new ArrayList<>();
        Path directoryPath = Paths.get("src/main/resources/dragontail-14.19.1/14.19.1/data/en_GB/champion");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)){
            for (Path filePath : stream){
                championsList.add(Arrays.stream(filePath.toString().split("\\\\")).toList().get(8).replace(".json",""));
            }
        }catch (DirectoryIteratorException | IOException e){
            e.printStackTrace();
        }
        return championsList;
    }
    public Path getChampFile(String champion){
        Path directoryPath = Paths.get("src/main/resources/dragontail-14.19.1/14.19.1/data/en_GB/champion");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)){
            for (Path filePath : stream){
                if (filePath.endsWith(champion + ".json")){
                    return filePath;
                }
            }
        }catch (DirectoryIteratorException | IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void readChampJSON(Path path){

    }

    public Util(){
        System.out.println(getChampionsList());
    }
    public static void main(String[] args) {
        Util util = new Util();
    }
}
