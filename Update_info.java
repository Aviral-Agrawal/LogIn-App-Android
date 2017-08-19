package app.com.example.aviral.loginapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Update_info extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);
        e1=(EditText) findViewById(R.id.editText5);
        e1=(EditText) findViewById(R.id.editText13);
        e1=(EditText) findViewById(R.id.editText14);
        e1=(EditText) findViewById(R.id.editText16);
        e1=(EditText) findViewById(R.id.editText17);
        dbHandler = new DBHandler(this, null, null, 1);
    }

    String id=e1.getText().toString();
    String username=e2.getText().toString();
    String dob=e3.getText().toString();
    String address=e4.getText().toString();
    String pass=e5.getText().toString();

    public void click_button(View v)
    {
        if(dbHandler.checkCredentials(username,pass)){
            startActivity(new Intent(this, Menu_page.class));
        }else{
            Toast.makeText(this, "Could Not Update", Toast.LENGTH_LONG).show();
        }
    }
}
