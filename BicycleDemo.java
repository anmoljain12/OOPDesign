/*
javac -version
javac BicycleDemo.java -d ClassFiles
java -cp ClassFiles learnJava.BicycleDemo
*/

package learnJava;

import java.util.ArrayList;
import java.util.Arrays;

class Part {
    private String name;
    private String value;
    private Boolean needSpare;

    public Part(String name, String value, Boolean needSpare) {
        this.name = name;
        this.value = value;
        this.needSpare = needSpare;
    }

    public String getName() { 
        return this.name; 
    }
    public String getValue() {
        return this.value;
    }
    public Boolean needSpare() { 
        return this.needSpare; 
    }
}

class Parts {
    private ArrayList<Part> parts;

    public Parts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public ArrayList<Part> getPartList() { 
        return this.parts; 
    }
    public void addPart(Part part) {
        this.parts.add(part);
    }
}

class Bicycle {
    private String size;
    private Parts parts;

    public Bicycle(String size, Parts parts) {
        this.size = size;
        this.parts = parts;
    }

    public String getSize() {
        return this.size;
    }
    public Parts getParts() { 
        return this.parts; 
    }
    public Parts getSpares() {
        Parts spares = new Parts(new ArrayList<>());
        for(Part part : this.parts.getPartList()) {
            if(part.needSpare()) spares.addPart(part);
        }
        return spares;
    }
}

class PartsFactory {
    public static Parts build(Object[][] config) {
        Parts parts = new Parts(new ArrayList<>());
        for(Object[] part_config: config){
            Part part = new Part((String)part_config[0], (String)part_config[1], (Boolean)part_config[2]);
            parts.addPart(part);
        }
        return parts;
    }
}

public class BicycleDemo {
    public static void main(String[] args) {

        Object[][] road_config = {
            {"chain", "10-speed", true},
            {"tire_size", "23", true},
            {"tape_color", "red", true}
        };

        Object[][] mountain_config = {
            {"chain", "10-speed", true},
            {"tire_size", "2.1", true},
            {"front_shock", "Manitou", false},
            {"rear_shock", "Fox", true}
        };

        Object[][] recumbent_config = {
            {"chain", "9-speed", true},
            {"tire_size", "28", true},
            {"flag", "tall and orange", true}
        };

        Bicycle roadBike = new Bicycle(
            "L",
            PartsFactory.build(road_config)
        );
        
        Bicycle mountainBike = new Bicycle(
            "M",
            PartsFactory.build(mountain_config)
        );

        Bicycle recumbentBike = new Bicycle(
            "L",
            PartsFactory.build(recumbent_config)
        );

        Parts roadSpares = roadBike.getSpares();
        Parts mountainSpares = mountainBike.getSpares();
        Parts recumbentSpares = recumbentBike.getSpares();

        System.out.println("\nRoad bike spares");
        for(Part part : roadSpares.getPartList()) {
            System.out.println(part.getName() + ": " + part.getValue());
        }
        
        System.out.println("\nMountain bike spares");
        for(Part part : mountainSpares.getPartList()) {
            System.out.println(part.getName() + ": " + part.getValue());
        }

        System.out.println("\nRecumbent bike spares");
        for(Part part : recumbentSpares.getPartList()) {
            System.out.println(part.getName() + ": " + part.getValue());
        }
    }
}