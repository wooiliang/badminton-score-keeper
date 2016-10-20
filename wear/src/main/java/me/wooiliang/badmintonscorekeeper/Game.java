package me.wooiliang.badmintonscorekeeper;

import java.util.ArrayList;

public class Game {
  private static final int winScore = 21;
  private int myScore = 0;
  private int yourScore = 0;
  private ArrayList<String> history = new ArrayList<>();

  public boolean addScoreIsWinner(boolean isMyScore) {
    if (isMyScore) {
      history.add("me");
      if (++myScore == winScore) {
        return true;
      }
    } else {
      history.add("you");
      if (++yourScore == winScore) {
        return true;
      }
    }
    return false;
  }

  public void undo() {
    if (history.size() > 0) {
      if (history.get(history.size() - 1) == "me") {
        myScore--;
      } else {
        yourScore--;
      }
      history.remove(history.size() - 1);
    }
  }

  public int getMyScore() {
    return myScore;
  }

  public int getYourScore() {
    return yourScore;
  }
}
