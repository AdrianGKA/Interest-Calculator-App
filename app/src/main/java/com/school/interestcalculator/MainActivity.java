package com.school.interestcalculator;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.lifecycle.ViewModelProvider;
import androidx.compose.runtime.Composable;
import com.patrykandpatrick.vico.core.cartesian.CartesianChart;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ComponentActivity {
    private InterestCalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContent {

        }

        //initialize the view model
        viewModel = new ViewModelProvider(this).get(InterestCalculatorViewModel.class);
    }
}