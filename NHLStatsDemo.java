// Full Name: Sandra S Thadathil
// ID No: B00939988

// NHLStatsDemo class to read from the input file and write to the output file, calls the methods to show the NHL results

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class NHLStatsDemo {

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        // Get the input file name
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        // Get the output file name
        System.out.print("Enter the name of the file to write to: ");
        String outputFile = keyboard.nextLine();
        PrintWriter output = new PrintWriter(outputFile);

        String name, position, teamName;
        int gamesPlayed, goalsScored, assists, penalties, shot, winningGoals;

        NHLStats stat = new NHLStats();
        PlayerRecord rec1 = null;

        // while loop to read from the input file.
        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            StringTokenizer token = new StringTokenizer(line, "\t");

            name = token.nextToken();
            position = token.nextToken();
            teamName = token.nextToken();

            gamesPlayed = Integer.parseInt(token.nextToken());
            goalsScored = Integer.parseInt(token.nextToken());
            assists = Integer.parseInt(token.nextToken());
            penalties = Integer.parseInt(token.nextToken());
            shot = Integer.parseInt(token.nextToken());
            winningGoals = Integer.parseInt(token.nextToken());

            rec1= new PlayerRecord(name, position, teamName, gamesPlayed, goalsScored, assists, penalties, shot, winningGoals);
            stat.add(rec1);
        }

        // Write to the output file and calling necessary methods.
        output.println("NHL Results Summary");
        output.println();
        output.println("Players with highest points and their teams:");
        stat.topPlayer(output);
        output.println();

        output.println("Most aggressive players, their teams and their positions:");
        stat.mostAggressivePlayer(output);
        output.println();

        output.println("Most valuable players and their teams:");
        stat.mostValuablePlayer(output);
        output.println();

        output.println("Most promising players and their teams:");
        stat.mostPromisingPlayer(output);
        output.println();

        output.println("Teams that had the most number of penalty minutes:");
        stat.mostPenaltyTeam(output);
        output.println();

        output.println("Teams that had the most number of game winning goals:");
        stat.mostWinningGoalTeam(output);

        inputFile.close();
        output.close();

        System.out.println("Content has been written to " + outputFile);
    }

}