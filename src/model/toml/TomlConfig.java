package model.toml;

import model.utility.FileHandler;

import java.io.IOException;
import java.util.Map;

public class TomlConfig implements TomlParser {
    private final String filepath;
    private Map<String, Object> tomlMap;

    public TomlConfig(String filepath) {
        this.filepath = filepath;
        readTomlMap();
    }

    public Map<String, Object> getTomlMap() {
        return tomlMap;
    }

    public void setTomlMap(Map<String, Object> tomlMap) {
        this.tomlMap = tomlMap;
    }

    public void readTomlMap() {
        tomlMap = TomlUtils.readToml(FileHandler.readFile(filepath));
    }

    public void writeTomlMap() {
        try {
            FileHandler.writeFile(TomlUtils.toToml(tomlMap), filepath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return TomlUtils.toToml(tomlMap);
    }
}
