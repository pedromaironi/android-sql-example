package com.example.query_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private static String ip = "dbase.el-domain.com";
    private static String port = "24433";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "account_Chino";
    private static String username = "drustates_user";
    private static String password = "@drustates_pwd@";
    private static String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/"
            + "databaseName=" + database + ";" + "user=" + username + ";" + "password="
            + password + ";";
    String host = "dbase.el-domain.com" + "\\," + "24433;";
    private Connection connection = null;
    String ConnectionURL = null;
    private Button btnConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnection = findViewById(R.id.btnStartConnection);
        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pedro();
            }
        });

    }

    public void pedro() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String ConnectURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String username = "sa";
            System.out.println("eeeeeeeeeeeeeeeeee");
            ConnectURL = "jdbc:jtds:sqlserver://70.23.213.109:24433;databasename=account_Chino;user=drustates_user;password=@drustates_pwd@;";
            connection = DriverManager.getConnection(ConnectURL);

        } catch (Exception e) {
            Log.e("Error is: ", e.getMessage());
            System.out.println("eeeeeeeeeeeeeeeeee");
        }
    }

    public void start() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
//            Class.forName(Classes);
//            connection = DriverManager.getConnection(url);

//            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://dbase.el-domain.com:24433;");
//            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://dbase.el-domain.com:24433;databaseName=account_Chino;");
//            Class.forName("net.sourceforge.jtds.jdbc.Driver");
//            ConnectionURL = "jdbc:sqlserver://" + ip + ":24433;databaseName=account_Chino;";
//            connection = DriverManager.getConnection(ConnectionURL + "encrypt=true;" + "integratedSecurity=true;"
//                    + "trustServerCertificate=false;"
//                    + "loginTimeout=30;", username, password);

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-UTAJMNA/pedro;user=DESKTOP-UTAJMNA;password=;database=inkwave");

            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Class fail", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "No Connected", Toast.LENGTH_SHORT).show();
        }
    }
}