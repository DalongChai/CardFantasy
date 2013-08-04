package cfvbaibai.cardfantasy.data;

import java.util.HashMap;
import java.util.Map;

public class Legion {
    private Map <Race, Integer> buffLevels;
    
    public Legion() {
        this(0, 0, 0, 0);
    }
    
    public Legion(int kingdomBuffLevel, int forestBuffLevel, int savageBuffLevel, int hellBuffLevel) {
        buffLevels = new HashMap <Race, Integer>();
        buffLevels.put(Race.����, kingdomBuffLevel);
        buffLevels.put(Race.ɭ��, forestBuffLevel);
        buffLevels.put(Race.����, savageBuffLevel);
        buffLevels.put(Race.����, hellBuffLevel);
    }
    
    public Map <Race, Integer> getBuffLevels() {
        return new HashMap <Race, Integer>(buffLevels);
    }

    public int getBuffLevel(Race race) {
        if (this.buffLevels.containsKey(race)) {
            return this.buffLevels.get(race);
        } else {
            return 0;
        }
    }
}