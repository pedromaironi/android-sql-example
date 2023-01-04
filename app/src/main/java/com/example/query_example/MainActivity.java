package com.example.query_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private Button button_Data;

    Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        button_Data =  findViewById(R.id.btnStartConnection);

        button_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConSQL c = new ConSQL();
                connection = c.conclass();
                if(c != null){
                    try {

                        String sqlstatement  = "Select numberId From ticket_line";

                        Statement smt = connection.createStatement();
                        ResultSet set = smt.executeQuery( sqlstatement );

                        int nCount = 0;

                        while (set.next()){
                            String lotteryName = ++nCount + " : " + set.getString( 1 );
                            System.out.println(lotteryName);
                        }
                        connection.close();
                    } catch (Exception e) {
                        Log.d( "Error ", e.getMessage() + "" );
                    }
                }
            }
        });

    }
}