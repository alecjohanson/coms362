package coms362.scoretracker.stats;

import java.util.List;
import java.util.Map;

/**
 * Created by Jack on 4/18/2014.
 */
public class BasketballStatsParser {

    /**
     * Parses raw data from database into a BasketballStats object
     *
     * Note the parsing is hardcoded in. In order for a new custom sport to be
     * supported with stats, a new set of CustomStats classes would have to be built
     * to use the event names in the game_event table.
     *
     * We are hardcoding the parsing here to save time.
     *
     * @param rawRows Raw data from game_event_map table
     * @return
     */
    public static BasketballStats parseRowsIntoStats(List<Map<String, Object>> rawRows) {
        BasketballStats ret = new BasketballStats();
        for(Map<String, Object> row : rawRows) {
            switch((Integer)row.get("eventid")) {
                case 1:
                    ret.add_2FGM(1);
                    ret.add_2FGA(1);
                    break;
                case 2:
                    ret.add_2FGA(1);
                    break;
                case 3:
                    ret.add_3FGM(1);
                    ret.add_3FGA(1);
                    break;
                case 4:
                    ret.add_3FGA(1);
                    break;
                case 5:
                    ret.addFTM(1);
                    ret.addFTA(1);
                    break;
                case 6:
                    ret.addFTA(1);
                    break;
                case 7:
                    ret.addREB(1);
                    break;
                case 8:
                    ret.addAST(1);
                    break;
                case 9:
                    ret.addSTL(1);
                    break;
                case 10:
                    ret.addBLK(1);
                    break;
                case 11:
                    ret.addFLS(1);
                    break;
                case 12:
                    ret.addTNS(1);
                    break;
            }
        }
        return ret;
    }
}
