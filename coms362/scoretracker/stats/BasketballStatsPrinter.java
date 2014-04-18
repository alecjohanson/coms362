package coms362.scoretracker.stats;

/**
 * Created by Jack on 4/17/2014.
 */
public class BasketballStatsPrinter {

    public static String prettyPrintStats(BasketballStats stats) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + stats.getSubjectName()).append("\n\n");
        sb.append("2FG\t3FG\tFT\tREB\tAST\tSTL\tBLK\tFLS\tTNS");
        //sb.append("2FG\t\t3FG\t\tFT\t\tREB\tAST\tSTL\tBLK\tFLS\tTNS");
        sb.append("\n-----------------------------------------------------------------------\n");
        String twos = stats.get_2FGM() + "/" + stats.get_2FGA();
        sb.append(twos).append("\t");
        /*if (twos.length() < 4)
            sb.append("\t");*/
        String threes = stats.get_3FGM() + "/" + stats.get_3FGA();
        sb.append(threes).append("\t");
        /*if (threes.length() < 4)
            sb.append("\t");*/
        String frees = stats.getFTM() + "/" + stats.getFTA();
        sb.append(frees).append("\t");
        /*if (frees.length() < 4)
            sb.append("\t");*/
        sb.append(stats.getREB()).append("\t");
        sb.append(stats.getAST()).append("\t");
        sb.append(stats.getSTL()).append("\t");
        sb.append(stats.getBLK()).append("\t");
        sb.append(stats.getFLS()).append("\t");
        sb.append(stats.getTNS());
        return sb.toString();
    }
}
