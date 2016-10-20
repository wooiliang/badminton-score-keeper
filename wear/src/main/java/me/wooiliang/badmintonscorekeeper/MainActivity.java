package me.wooiliang.badmintonscorekeeper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

  private Game game;
  private TextView topLabel;
  private Button myScore;
  private Button yourScore;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_score);
    topLabel = (TextView) findViewById(R.id.top_label);
    myScore = (Button) findViewById(R.id.my_score);
    yourScore = (Button) findViewById(R.id.your_score);
    game = new Game();
  }

  public void clickMyScore(View v) {
    if (game.addScoreIsWinner(true)) {
      topLabel.setText(R.string.win);
      disableScoreButtons();
    }
    myScore.setText(Integer.toString(game.getMyScore()));
  }

  public void clickYourScore(View v) {
    if (game.addScoreIsWinner(false)) {
      topLabel.setText(R.string.lose);
      disableScoreButtons();
    }
    yourScore.setText(Integer.toString(game.getYourScore()));
  }

  public void clickUndo(View v) {
    game.undo();
    myScore.setText(Integer.toString(game.getMyScore()));
    yourScore.setText(Integer.toString(game.getYourScore()));
    topLabel.setText(R.string.app_name);
    enableScoreButtons();
  }

  private void enableScoreButtons() {
    myScore.setEnabled(true);
    yourScore.setEnabled(true);
  }

  private void disableScoreButtons() {
    myScore.setEnabled(false);
    yourScore.setEnabled(false);
  }
}
