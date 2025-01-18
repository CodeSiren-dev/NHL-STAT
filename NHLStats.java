// Full Name: Sandra S Thadathil
// ID No: B00939988

// NHLStats class holds a list of records of every player and contains topPlayer(), mostAggressivePlayer(), mostValuablePlayer(),
// mostPromisingPlayer(), mostPenaltyTeam(), mostWinningGoalTeam()


import java.io.PrintWriter;
import java.util.ArrayList;

public class NHLStats {
    private List<PlayerRecord> records;

    // constructor
    public NHLStats() {
        records = new List<>();
    }

    // add a rec to the records list
    public void add(PlayerRecord rec) {
        records.add(rec);
    }

    // checks if the records list is empty
    public boolean isEmpty() {
        return records.isEmpty();
    }

    // checks if the records list contains a rec.
    public boolean contains(PlayerRecord rec) {
        return records.contains(rec);
    }

    // gets the first item from the records list
    public PlayerRecord first() {
        return records.first();
    }

    // gets the next item from the records list
    public PlayerRecord next() {
        return records.next();
    }

    // scan the list and display the items
    public void enumerate() {
        records.enumerate();
    }

    /*
     * topPlayer method - Display the name and team name for the player with the most points (Goals+Assists).
     * If more than one player had the greatest number of points, display all the players and their teams.
     * @param - PrintWriter output
     * @return None
     */
    public void topPlayer(PrintWriter output) {

        if (records.isEmpty()) {
            return;
        }

        PlayerRecord rec = records.first();

        double max = rec.getGoalsScored() + rec.getAssists();

        // loop through the record and find the maximum points
        while (rec != null) {
            double points = rec.getGoalsScored() + rec.getAssists();

            if (points > max) {
                max = points;
            }

            rec = records.next();
        }

        rec = records.first();

        // check if there is more than one player with the same maximum points, if then print all of them
        while (rec != null) {
            double points = rec.getGoalsScored() + rec.getAssists();

            if (points == max) {
                output.println("Player Name: " + rec.getName() + ", Team Name: " + rec.getTeamName());
            }

            rec = records.next();
        }

    }

    /*
     * mostAggressivePlayer method - Display the name, team name, and position for the player who was the most aggressive (had
     * the most penalty minutes).
     * If more than one player had the greatest number of penalty minutes, display all the players and their teams.
     * @param - PrintWriter output
     * @return None
     */

    public void mostAggressivePlayer(PrintWriter output) {

        if (records.isEmpty()) {
            return;
        }

        PlayerRecord rec = records.first();

        double max = rec.getPenalties();

        // loop through the record and find the maximum points
        while (rec != null) {
            double points = rec.getPenalties();

            if (points > max) {
                max = points;
            }

            rec = records.next();
        }

        rec = records.first();

        // check if there is more than one player with the same maximum points, if then print all of them
        while (rec != null) {
            double points = rec.getPenalties();

            if (points == max) {
                output.println("Player Name: " + rec.getName() + ", Team Name: " + rec.getTeamName() + ",  Position: " + rec.getPosition());
            }

            rec = records.next();
        }

    }

    /*
     * mostValuablePlayer method - Display the name and team name for the player who was the MVP (scored the most game
     *  winning goals).
     * If more than one player had the greatest number of game winning goals, display all the players and their teams.
     * @param - PrintWriter output
     * @return None
     */

    public void mostValuablePlayer(PrintWriter output) {

        if (records.isEmpty()) {
            return;
        }

        PlayerRecord rec = records.first();

        double max = rec.getWinningGoals();

        // loop through the record and find the maximum points
        while (rec != null) {
            double points = rec.getWinningGoals();

            if (points > max) {
                max = points;
            }

            rec = records.next();
        }

        rec = records.first();

        // check if there is more than one player with the same maximum points, if then print all of them
        while (rec != null) {
            double points = rec.getWinningGoals();

            if (points == max) {
                output.println("Player Name: " + rec.getName() + ", Team Name: " + rec.getTeamName());
            }

            rec = records.next();
        }

    }

    /*
     * mostPromisingPlayer method - Display the name and team name for the most promising player (had the most shots
     *  on goal).
     * If more than one player had the greatest number of shot on goals, display all the players and their teams.
     * @param - PrintWriter output
     * @return None
     */
    public void mostPromisingPlayer(PrintWriter output) {

        if (records.isEmpty()) {
            return;
        }

        PlayerRecord rec = records.first();

        double max = rec.getShot();

        // loop through the record and find the maximum points
        while (rec != null) {
            double points = rec.getShot();

            if (points > max) {
                max = points;
            }

            rec = records.next();
        }

        rec = records.first();

        // check if there is more than one player with the same maximum points, if then print all of them
        while (rec != null) {
            double points = rec.getShot();

            if (points == max) {
                output.println("Player Name: " + rec.getName() + ", Team Name: " + rec.getTeamName());
            }

            rec = records.next();
        }

    }

    /*
     * mostPenaltyTeam method - Display the team name for the team that had the most penalty minutes (sum of all penalty
     * minutes for all players on a team).
     * If more than one team had the greatest number of penalty minutes, display all the teams.
     * @param - PrintWriter output
     * @return None
     */
    public void mostPenaltyTeam(PrintWriter output) {

        if (records.isEmpty()) {
            return;
        }

        ArrayList<String> teamList = new ArrayList<>();

        PlayerRecord rec = records.first();

        // loop the records to add each team and their points into the teamList.
        while (rec != null) {
            String teamName = rec.getTeamName();
            int penalty = rec.getPenalties();

            boolean found = false;

            for (int i = 0; i < teamList.size(); i++) {
                String[] entry = teamList.get(i).split(" ");
                String currTeamName = entry[0];
                int currPenalty = Integer.parseInt(entry[1]);

                if (teamName.equals(currTeamName)) {
                    currPenalty += penalty;
                    teamList.set(i, currTeamName + " " + currPenalty);
                    found = true;
                    break;
                }
            }

            if (!found) {
                teamList.add(teamName + " " + penalty);
            }

            rec = records.next();
        }

        int max = 0;

        // loop through the teamList to find  the maximum points.
        for (int i = 0; i < teamList.size(); i++) {
            String[] entry = teamList.get(i).split(" ");
            int currPenalty = Integer.parseInt(entry[1]);

            if (currPenalty > max) {
                max = currPenalty;
            }
        }

        // check if there is more than one team with the same maximum points
        for (int i = 0; i < teamList.size(); i++) {
            String[] entry = teamList.get(i).split(" ");
            String currTeamName = entry[0];
            int currPenalty = Integer.parseInt(entry[1]);

            if (currPenalty == max) {
                output.println(currTeamName);
            }
        }

    }

    /*
     * mostWinningGoalTeam method - Display the team name for the team that had the most game winning goals (sum of all
     * game winning goals for all players on a team).
     * If more than one team had the greatest number of game winning goals, display all the teams.
     * @param - PrintWriter output
     * @return None
     */

    public void mostWinningGoalTeam(PrintWriter output) {
        ArrayList<String> teamList = new ArrayList<>();

        if (records.isEmpty()) {
            return;
        }

        PlayerRecord rec = records.first();

        // loop the records to add each team and their points into the teamList.
        while (rec != null) {
            String teamName = rec.getTeamName();
            int winningGoals = rec.getWinningGoals();

            boolean found = false;

            for (int i = 0; i < teamList.size(); i++) {
                String[] entry = teamList.get(i).split(" ");
                String currTeamName = entry[0];
                int currWinningGoals = Integer.parseInt(entry[1]);

                if (teamName.equals(currTeamName)) {
                    currWinningGoals += winningGoals;
                    teamList.set(i, currTeamName + " " + currWinningGoals);
                    found = true;
                    break;
                }
            }

            if (!found) {
                teamList.add(teamName + " " + winningGoals);
            }

            rec = records.next();
        }

        int max = 0;

        // loop through the teamList to find the maximum points.
        for (int i = 0; i < teamList.size(); i++) {
            String[] entry = teamList.get(i).split(" ");
            int currWinningGoals = Integer.parseInt(entry[1]);

            if (currWinningGoals > max) {
                max = currWinningGoals;
            }
        }

        // check if there is more than one team with the same maximum points, if then print them as well
        for (int i = 0; i < teamList.size(); i++) {
            String[] entry = teamList.get(i).split(" ");
            String currTeamName = entry[0];
            int currWinningGoals = Integer.parseInt(entry[1]);

            if (currWinningGoals == max) {
                output.println(currTeamName);
            }
        }

    }
}

