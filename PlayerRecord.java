// Full Name: Sandra S Thadathil
// ID No: B00939988

// PlayerRecord class holds record of each player.

public class PlayerRecord {
    private String name, position, teamName;

    private int gamesPlayed, goalsScored, assists, penalties, shot, winningGoals;

    // constructor to initialize the instance variables.
    public PlayerRecord (String name, String position, String teamName, int gamesPlayed, int goalsScored, int assists,
                        int penalties, int shot, int winningGoals) {
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.penalties = penalties;
        this.shot = shot;
        this.winningGoals = winningGoals;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public  String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getWinningGoals() {
        return winningGoals;
    }

    public void setWinningGoals(int winningGoals) {
        this.winningGoals = winningGoals;
    }

}
