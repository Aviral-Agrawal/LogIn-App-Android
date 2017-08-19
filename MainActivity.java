package app.com.example.aviral.loginapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter.*;
import android.widget.Spinner;
import android.widget.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

EditText emailField;
EditText passField;
Button loginButton;
DBHandler dbHandler;
CheckedTextView checkedTextView;
CheckedTextView checkedTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailField = (EditText) findViewById(R.id.editText7);
        passField = (EditText) findViewById(R.id.editText8);
        loginButton=(Button) findViewById(R.id.login_button);
        dbHandler = new DBHandler(this, null, null, 1);

        checkedTextView = findViewById(R.id.checkedTextView);
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Sign_up.class);
                startActivity(intent);
            }
        });

        checkedTextView1 = findViewById(R.id.checkedTextView3);
        checkedTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Forgot_pass.class);
                startActivity(intent);
            }
        });



    }


    /*public void click_button(View v)
    {

        else if(button_text.equals("Sign Up"))
        {
            Intent intent = new Intent(this,Sign_up.class);
            startActivity(intent);
        }

        else if(button_text.equals("Forgot Password"))
        {
            Intent intent = new Intent(this,Forgot_pass.class);
            startActivity(intent);
        }
    }*/

    //Login
    public void click_login(View v)
    {
        String username=emailField.getText().toString();
        String pass=passField.getText().toString();
        if(dbHandler.checkCredentials(username,pass)){
            startActivity(new Intent(this, Menu_page.class));
        }else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
        }

    }


}
