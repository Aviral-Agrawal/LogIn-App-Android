package app.com.example.aviral.loginapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Menu_page extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.menu_page);
    }
    

    public void click_button(View v)
    {
        String button_text;
        button_text=((Button) v).getText().toString();
        if(button_text.equals("New Course"))
        {
            Intent intent = new Intent (this,Reg_page.class);
            startActivity(intent);
        }
        else if(button_text.equals("Update Information"))
        {
            Intent intent = new Intent (this,Update_info.class);
            startActivity(intent);
        }

        else if(button_text.equals("Show Details"))
        {
            Intent intent = new Intent (this,Show_info.class);
            startActivity(intent);
        }

        else if(button_text.equals("Log Out"))
        {
            Intent intent = new Intent (this,MainActivity.class);
            startActivity(intent);
        }
    }

}


