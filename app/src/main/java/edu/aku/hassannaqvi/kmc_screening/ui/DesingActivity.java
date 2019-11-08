package edu.aku.hassannaqvi.kmc_screening.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivityABinding;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitydesignBinding;
import edu.aku.hassannaqvi.kmc_screening.generated.callback.OnClickListener;
import edu.aku.hassannaqvi.kmc_screening.other.DiseaseCode;
import edu.aku.hassannaqvi.kmc_screening.util.Util;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class DesingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ActivitydesignBinding bi;

    String MY_PREFS_NAME="desing";
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bi = DataBindingUtil.setContentView(this, R.layout.activitydesign);
        bi.setCallback(this);

        events();

        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();


    }

    public  void events()
    {

        bi.rbSmall.setOnCheckedChangeListener(this);
        bi.rbNormal.setOnCheckedChangeListener(this);
        bi.rbLarage.setOnCheckedChangeListener(this);
        bi.rbXlarage.setOnCheckedChangeListener(this);



        bi.rbRbSmall.setOnCheckedChangeListener(this);
        bi.rbRbNormal.setOnCheckedChangeListener(this);
        bi.rbRbLarage.setOnCheckedChangeListener(this);
        bi.rbRbXlarage.setOnCheckedChangeListener(this);



        bi.rbCbSmall.setOnCheckedChangeListener(this);
        bi.rbCbNormal.setOnCheckedChangeListener(this);
        bi.rbCbLarage.setOnCheckedChangeListener(this);
        bi.rbCbXlarage.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(buttonView==bi.rbSmall && bi.rbSmall.isChecked())
        {

            bi.labqexp.setTextSize(16);
            bi.labqexp.setText("Question Lable Size is Small");

            editor.putInt("qtxt", 16);
        }
        else if(buttonView==bi.rbLarage && bi.rbLarage.isChecked())
        {

            bi.labqexp.setTextSize(24);

            bi.labqexp.setText("Question Lable Size is Large");
            editor.putInt("qtxt", 24);
        }
        else if(buttonView==bi.rbNormal && bi.rbNormal.isChecked())
        {

            bi.labqexp.setTextSize(20);

            editor.putInt("qtxt", 20);



            bi.labqexp.setText("Question Lable Size is Normal");
        }

        else if(buttonView==bi.rbXlarage && bi.rbXlarage.isChecked())
        {


            bi.labqexp.setTextSize(26);

            editor.putInt("qtxt", 26);



            bi.labqexp.setText("Question Lable Size is Extra Large");
        }

        // txt label ends


        if(buttonView==bi.rbRbSmall && bi.rbRbSmall.isChecked())
        {

            bi.rbexp.setTextSize(16);
            bi.rbexp.setText("Question Lable Size is Small");

            editor.putInt("rbtxt", 16);
        }
        else if(buttonView==bi.rbRbLarage && bi.rbRbLarage.isChecked())
        {

            bi.rbexp.setTextSize(24);

            bi.rbexp.setText("Question Lable Size is Large");
            editor.putInt("rbtxt", 24);
        }
        else if(buttonView==bi.rbRbNormal && bi.rbRbNormal.isChecked())
        {

            bi.rbexp.setTextSize(18);

            editor.putInt("rbtxt", 18);



            bi.rbexp.setText("Question Lable Size is Normal");
        }

        else if(buttonView==bi.rbRbXlarage && bi.rbRbXlarage.isChecked())
        {


            bi.rbexp.setTextSize(26);

            editor.putInt("rbtxt", 26);



            bi.rbexp.setText("Question Lable Size is Extra Large");
        }





        if(buttonView==bi.rbCbSmall && bi.rbCbSmall.isChecked())
        {

            bi.cbexp.setTextSize(16);
            bi.cbexp.setText("Checkbox Lable Size is Small");

            editor.putInt("rbtxt", 16);
        }
        else if(buttonView==bi.rbCbLarage && bi.rbCbLarage.isChecked())
        {

            bi.cbexp.setTextSize(24);

            bi.cbexp.setText("Checkbox Lable Size is Large");
            editor.putInt("rbtxt", 24);
        }
        else if(buttonView==bi.rbCbNormal && bi.rbCbNormal.isChecked())
        {

            bi.cbexp.setTextSize(20);

            editor.putInt("rbtxt", 20);



            bi.cbexp.setText("Checkbox Lable Size is Normal");
        }

        else if(buttonView==bi.rbCbXlarage && bi.rbCbXlarage.isChecked())
        {


            bi.cbexp.setTextSize(26);

            editor.putInt("rbtxt", 26);



            bi.cbexp.setText("Checkbox Lable Size is Extra Large");
        }

// txt label ends




        if(buttonView==bi.rbCbSmall && bi.rbCbSmall.isChecked())
        {

            bi.cbexp.setTextSize(16);
            bi.cbexp.setText("Checkbox Lable Size is Small");

            editor.putInt("cbtxt", 16);
        }
        else if(buttonView==bi.rbCbLarage && bi.rbCbLarage.isChecked())
        {

            bi.cbexp.setTextSize(24);

            bi.cbexp.setText("Checkbox Lable Size is Large");
            editor.putInt("cbtxt", 24);
        }
        else if(buttonView==bi.rbCbNormal && bi.rbCbNormal.isChecked())
        {

            bi.cbexp.setTextSize(20);

            editor.putInt("cbtxt", 20);



            bi.cbexp.setText("Checkbox Lable Size is Normal");
        }

        else if(buttonView==bi.rbCbXlarage && bi.rbCbXlarage.isChecked())
        {


            bi.cbexp.setTextSize(26);

            editor.putInt("cbtxt", 26);



            bi.cbexp.setText("Checkbox Lable Size is Extra Large");
        }

// txt label ends



        editor.apply();

    }
}