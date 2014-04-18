package coms362.scoretracker.stats;

/**
 * Created by Jack on 4/17/2014.
 */
public class BasketballStats {
    private String subjectName;
    private int _2FGM;
    private int _2FGA;
    private int _3FGM;
    private int _3FGA;
    private int FTM;
    private int FTA;
    private int REB;
    private int AST;
    private int STL;
    private int BLK;
    private int FLS;
    private int TNS;

    public BasketballStats() {

    }

    public void addBasketballStats(BasketballStats stats) {
        this._2FGM += stats.get_2FGM();
        this._2FGA += stats.get_2FGA();
        this._3FGA += stats.get_3FGA();
        this._3FGM += stats.get_3FGM();
        this.FTM += stats.getFTM();
        this.FTA += stats.getFTA();
        this.REB += stats.getREB();
        this.AST += stats.getAST();
        this.STL += stats.getSTL();
        this.BLK += stats.getBLK();
        this.FLS += stats.getFLS();
        this.TNS += stats.getTNS();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int get_2FGM() {
        return _2FGM;
    }

    public void add_2FGM(int _2FGM) {
        this._2FGM += _2FGM;
    }

    public int get_2FGA() {
        return _2FGA;
    }

    public void add_2FGA(int _2FGA) {
        this._2FGA += _2FGA;
    }

    public int get_3FGM() {
        return _3FGM;
    }

    public void add_3FGM(int _3FGM) {
        this._3FGM += _3FGM;
    }

    public int get_3FGA() {
        return _3FGA;
    }

    public void add_3FGA(int _3FGA) {
        this._3FGA += _3FGA;
    }

    public int getFTM() {
        return FTM;
    }

    public void addFTM(int FTM) {
        this.FTM += FTM;
    }

    public int getFTA() {
        return FTA;
    }

    public void addFTA(int FTA) {
        this.FTA += FTA;
    }

    public int getREB() {
        return REB;
    }

    public void addREB(int REB) {
        this.REB += REB;
    }

    public int getAST() {
        return AST;
    }

    public void addAST(int AST) {
        this.AST += AST;
    }

    public int getSTL() {
        return STL;
    }

    public void addSTL(int STL) {
        this.STL += STL;
    }

    public int getBLK() {
        return BLK;
    }

    public void addBLK(int BLK) {
        this.BLK += BLK;
    }

    public int getFLS() {
        return FLS;
    }

    public void addFLS(int FLS) {
        this.FLS += FLS;
    }

    public int getTNS() {
        return TNS;
    }

    public void addTNS(int TNS) {
        this.TNS += TNS;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void addGamesPlayed(int gamesPlayed) {
        this.gamesPlayed += gamesPlayed;
    }

    private int gamesPlayed;
}
