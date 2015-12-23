package com.loftschool.moneytracker;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.loftschool.moneytracker.rest.RestService;
import com.loftschool.moneytracker.rest.UserRegistrationModel;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Muvikui on 23.12.2015.
 */
@EActivity(R.layout.registration_activity)
public class RegistrationActivity extends AppCompatActivity {


    //Finding.......
    @ViewById(R.id.user_name)
    AutoCompleteTextView user_name;

    @ViewById(R.id.password)
    EditText password;

    @ViewById(R.id.registration_button)
    Button registration_button;

    private Context context;
    ConnectivityManager cm =
            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    boolean isConnected = activeNetwork.isConnectedOrConnecting();
    //Finding.......



    @Click(R.id.registration_button)
    void click(View view) {
        if (!isConnected) {
            Snackbar.make(view, R.string.no_internet, Snackbar.LENGTH_SHORT).show();
        }
        else {
            registerUser(view);

        }
    }

    private void registerUser(View view){

        String stringUserName = user_name.getText().toString();
        String stringPassword = password.getText().toString();
        RestService restService = new RestService();
        UserRegistrationModel userRegistrationModel = restService.register(stringUserName, stringPassword);

        if(user_name.length() < 5 || password.length() < 5) {
            Snackbar.make(view, R.string.lengthen_error, Snackbar.LENGTH_LONG).show();
            return;
        } else {

        switch (userRegistrationModel.getStatus()) {

            case "Login busy already":
                Snackbar.make(view, R.string.login_used, Snackbar.LENGTH_LONG).show();
                break;

            case "success":
                Intent s = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(s);
                return;

            default:
                break;

        }

    }
}}