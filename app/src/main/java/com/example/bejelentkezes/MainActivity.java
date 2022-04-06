package com.example.bejelentkezes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GetTextFromSQL(View v)
    {
        TextView tx1 = (TextView) findViewById(R.id.textView2);
        TextView tx2 = (TextView) findViewById(R.id.textView3);

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect =connectionHelper.connectionclass();
            if (connect!=null)
            {
                String query = "Select * Gazdik";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next())
                {
                    tx1.setText(rs.getString(1));
                    tx2.setText(rs.getString(2));
                }
            }
            else
                {
                    ConnectionResult = "Chek Connention";
                }
        }
        catch (Exception ex){

        }
    }

}