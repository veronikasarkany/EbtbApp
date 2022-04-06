package com.example.bejelentkezes;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.sourceforge.jtds.jdbc.*;

public class ConnectionHelper {
    Connection con;

    @SuppressLint("NewApi")

    public Connection connectionclass()
    {



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
                ConnectionURL = "jdbc:jtds:sqlserver: ..adatbazis cime...";
                connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex)
        {
            Log.e("Error  " ,ex.getMessage());
        }


        return connection;
    }
}
