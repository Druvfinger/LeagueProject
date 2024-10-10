import Champion.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
    public void addToChampPool(String championName){
        File file = new File("src/main/resources/ChampPool.txt");
        if (!getChampPool().contains(championName)){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(championName);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
        }
    }
    public List<String> getChampPool() {
        File file = new File("src/main/resources/ChampPool.txt");
        List<String> champPool = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNext()){
            champPool.add(scanner.nextLine());
        }
        return champPool;
    }
    public void removeFromChampPool(String champName){
        File file = new File("src/main/resources/ChampPool.txt");
        List<String> champPool = getChampPool();
        clearChampPool();
        champPool.remove(champName);
        for (String champ : champPool){ addToChampPool(champ); }
    }
    public void clearChampPool() {
        File file = new File("src/main/resources/ChampPool.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write nothing to the file, which will clear its content
            writer.write("");
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file.");
            e.printStackTrace();
        }
    }
}
