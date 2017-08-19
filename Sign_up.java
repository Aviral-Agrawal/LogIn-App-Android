package app.com.example.aviral.loginapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        e1=(EditText) findViewById(R.id.editText4);
        e1=(EditText) findViewById(R.id.editText10);
        e1=(EditText) findViewById(R.id.editText15);
        e1=(EditText) findViewById(R.id.editText9);
        e1=(EditText) findViewById(R.id.editText6);
        e1=(EditText) findViewById(R.id.editText12);
        e1=(EditText) findViewById(R.id.editText11);
        dbHandler = new DBHandler(this, null, null, 1);
    }



    public void click_button(View v)
    {
        String first=e1.getText().toString();
        String second=e2.getText().toString();
        String username=e3.getText().toString();
        String dob=e4.getText().toString();
        String address=e5.getText().toString();
        String gender=e6.getText().toString();
        String pass=e7.getText().toString();

        Data data=new Data(first,second,username,dob,address,gender,pass);
        dbHandler.addData(data);
        Toast.makeText(this, "Signed Up", Toast.LENGTH_LONG).show();
    }
}
