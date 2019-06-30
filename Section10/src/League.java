import java.util.ArrayList;
import java.util.Collections;

public class League<U extends Player, T extends Team<U>>{
    private String name;
    private int played = 0;

    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
    }

    public void playMatch(int homeTeamIndex, int homeTeamScore,
                          int awayTeamIndex, int awayTeamScore) {
        if (homeTeamIndex < 0 || homeTeamIndex > teams.size()) {
            System.out.println("Invalid home team index");
            return;
        } else if (awayTeamIndex < 0 || awayTeamIndex > teams.size()) {
            System.out.println("Invalid away team index");
            return;
        } else if (awayTeamIndex == homeTeamIndex) {
            System.out.println("Team cannot play itself in league");
            return;
        }

        teams.get(homeTeamIndex).matchResult(teams.get(awayTeamIndex), homeTeamScore, awayTeamScore);
        ++played;
    }

    public boolean addTeam(T team) {
        if (teams.contains(team))
            return false;

        teams.add(team);
        return true;
    }

    public void showLeagueTable() {
        Collections.sort(teams);
        int i = 0;
        for (Team team : teams) {
            ++i;
            System.out.println("[" + i + "]: " + team.getName() + ", rank: " + team.ranking());
        }
    }
}
