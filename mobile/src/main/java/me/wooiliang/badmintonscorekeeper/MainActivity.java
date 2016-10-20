package me.wooiliang.badmintonscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private TextView content;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    content = (TextView) findViewById(R.id.content);
    content.setText(R.string.content);
  }
}
