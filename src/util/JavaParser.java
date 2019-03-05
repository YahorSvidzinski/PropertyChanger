package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaParser {
    private List<Path> files;
    //hello.keys

    public void parseFile(){
        try {
            Stream<Path> PathStream = Files.walk(Paths.get("src/"))
                    .filter(Files::isRegularFile)
                    .filter(f -> f.getFileName().toString().endsWith(".java"))
                    .map(Path::toAbsolutePath);
            files = PathStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void changeFile(String pattern){
        for (Path file : files){
            List<String> lineList;
            try {
                lineList = Files.readAllLines(file);
                for (int i = 0; i < lineList.size(); i++) {
                    String line = lineList.get(i);
                    if (line.contains(pattern)){
                        String newpattern = StringCalc.done(pattern);
                        lineList.remove(i);
                        lineList.add(i,line.replace(pattern,newpattern));
                    }
                }
                Files.write(file,lineList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
