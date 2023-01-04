package com.example.query_example;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConSQL {
    Connection con;
    @SuppressLint( "NewApi" )
    public Connection conclass(){

        String host = "dbase.el-domain.com";
        host = "10.0.0.10";
        String port = "1433";
        String databaseName= "master";
        String user = "SATESChinoUser";
        String password = "@SATESChinoUser@";

        user = "sa";
        password = "Juandejesus29";

        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy( a );
        String ConnectURL = null;

        try{
            Class.forName( "net.sourceforge.jtds.jdbc.Driver" );

            ConnectURL = "jdbc:jtds:sqlserver://" + host + ":" + port + ";" + "databaseName="+databaseName + ";" + "user="+user + ";" + "password="+password + ";";
            con = DriverManager.getConnection( ConnectURL );
        } catch (Exception e) {
            Log.e( "Error: ", e.getMessage() + "" );
        }

        return con;

    }


}
