package mv;

import java.util.HashMap;
import java.util.Map;

public class MyMV {

    private String name;
    private Map<String,Object> map = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
