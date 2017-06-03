package com.surya;

import java.util.ArrayList;

/**
 * Created by Surya Vamsi on 03-Jun-17.
 */
public class Generics {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        //adelaideCrows.addPlayer(pat);
        //adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer>brokenTeam=new Team<>("this wont work");
        brokenTeam.addPlayer(beckham);

    }
}
