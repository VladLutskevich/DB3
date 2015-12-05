package com.example.db3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button2;
    Button button3;
    EditText editText;
    String strId;
    String str;
    RequestQueue queue;
    String url;
    StringRequest request;



    @Override
  public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);

button2 = (Button) findViewById(R.id.button2);
button2.setOnClickListener(this);

button3 = (Button) findViewById(R.id.button3);

editText = (EditText)findViewById(R.id.editText);







FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
fab.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
.setAction("Action", null).show();
}
});
}


public void onClick(View v) {
switch (v.getId()) {
case R.id.button2:
Intent intent = new Intent(this, Main2Activity.class);
startActivity(intent);
break;
default:
break;
}
}

public void onClick2(View view) {
if (str!=""){
Intent intent = new Intent(this, Main2Activity.class);
intent.putExtra("str1", editText.getText().toString());
startActivity(intent);}

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.menu_main, menu);
return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
int id = item.getItemId();

//noinspection SimplifiableIfStatement
if (id == R.id.action_settings) {
return true;
}

return super.onOptionsItemSelected(item);
}
}