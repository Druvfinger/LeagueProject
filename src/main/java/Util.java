import Champion.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class Util {
    public static final List<Champion> champions = mapChampionsJsonFilesToChampionClass();
    public ImageIcon getChampPortrait(ChampionImage championImage){
        return new ImageIcon("src/main/resources/dragontail-14.19.1/14.19.1/img/champion/" + championImage.full());
    }

    public static List<Champion> mapChampionsJsonFilesToChampionClass(){
        List<Champion> champions = new ArrayList<>();
        Path directoryPath = Paths.get("src/main/resources/dragontail-14.19.1/14.19.1/data/en_GB/champion");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)){
            for (Path filePath : stream){
                File champFile = filePath.toFile();
                ObjectMapper mapper = new ObjectMapper();
                ChampionData championData = mapper.readValue(champFile, ChampionData.class);
                champions.add(championData.data().get(championData.data().keySet().stream().toList().get(0)));
            }
        }catch (DirectoryIteratorException | IOException e){
            e.printStackTrace();
        }
        return champions;
    }
    public List<String> getChampionNameList(){
        List<String> championNames = new ArrayList<>();
        champions.forEach(champ -> championNames.add(champ.name()));
        return championNames;
    }

    public Champion getChampion(String championName){
        for (Champion champion : champions){
            if (championName.equals(champion.name())){
                return champion;
            }
        }
        return null;
    }

}
