package com.example.giftoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage extends AppCompatActivity {

    private ImageButton home, profile, settings;
    private Spinner hobbySpinner, ageSpinner, genderSpinner, categorySpinner;
    private Button searchButton;
    private ListView giftList;

    private String selectedCategory;
    private String selectedHobby;
    private String selectedAge;
    private String selectedGender;

    private TextView giftIdeasTextView;

    private Button showGiftsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchpage);
        home = (ImageButton) findViewById(R.id.home);
        profile = (ImageButton) findViewById(R.id.profile);
        settings = (ImageButton) findViewById(R.id.settings);
        categorySpinner = findViewById(R.id.categorySpinner);
        hobbySpinner = findViewById(R.id.hobbySpinner);
        ageSpinner = findViewById(R.id.ageSpinner);
        genderSpinner = findViewById(R.id.genderSpinner);

        giftIdeasTextView = findViewById(R.id.gift_ideas_text_view);

        showGiftsButton = findViewById(R.id.showGiftsButton);
        showGiftsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGiftIdeas();
            }
        });

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCategory=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedCategory="";

            }
        });


        hobbySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedHobby = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedHobby = "";
            }
        });

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedAge = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedAge = "";
            }
        });

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGender = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedGender = "";
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity4();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity5();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity7();
            }
        });
    }

    public void openactivity4() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openactivity5() {
        Intent intent = new Intent(this, UserPage.class);
        startActivity(intent);
    }

    public void openactivity7() {
        Intent intent = new Intent(this, SettingsPage.class);
        startActivity(intent);
    }

    private void showGiftIdeas() {
        String giftIdeas = "";

        // Add gift ideas and links based on selected dropdown list values
        if (selectedCategory.equals("Books")) {
            if (selectedHobby.equals("Cooking")) {
                if (selectedAge.equals("Under 18")) {
                    giftIdeas += "The Baking Cookbook for Teens: 75 Delicious Recipes for Sweet and Savory Treats";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Baking-Cookbook-Teens-Delicious-Treats/dp/1641529825";
                } else if (selectedAge.equals("18-24")) {
                    giftIdeas += "Salt, Fat, Acid, Heat: Mastering the Elements of Good Cooking";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Salt-Fat-Acid-Heat-Mastering/dp/1476753830";
                } else if (selectedAge.equals("25-34")) {
                    giftIdeas += "The Joy of Cooking: 2019 Edition Fully Revised and Updated";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Joy-Cooking-2019-Revised-Updated/dp/1439130822";
                } else if (selectedAge.equals("35+")) {
                    giftIdeas += "Mastering the Art of French Cooking, Vol. 1";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Mastering-Art-French-Cooking-Anniversary/dp/0375413405";
                }
            } else if (selectedHobby.equals("Gardening")) {
                if (selectedAge.equals("Under 18")) {
                    giftIdeas += "The Vegetable Gardener's Bible, 2nd Edition: Discover Ed's High-Yield W-O-R-D System for All North American Gardening Regions: Wide Rows, Organic Methods, Raised Beds, Deep Soil";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Vegetable-Gardeners-Bible-2nd/dp/160342475X";
                } else if (selectedAge.equals("18-24")) {
                    giftIdeas += "The Vegetable Gardener's Answer Book: Solutions to Every Problem You'll Ever Face; Answers to Every Question You'll Ever Ask";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Vegetable-Gardeners-Answer-Book-Solutions/dp/160342024X";
                } else if (selectedAge.equals("25-34")) {
                    giftIdeas += "The Vegetable Gardener's Bible: Discover Ed's High-Yield W-O-R-D System for All North American Gardening Regions: Wide Rows, Organic Methods, Raised Beds, Deep Soil";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Vegetable-Gardeners-Bible-High-Yield-Regions/dp/1580172121";
                } else if (selectedAge.equals("35+")) {
                    giftIdeas += "The Well-Tempered Garden";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Well-Tempered-Garden-Christopher-Lloyd/dp/088192975X";
                }
            }
        } else if (selectedCategory.equals("Electronics")) {
            if (selectedHobby.equals("Gaming")) {
                if (selectedAge.equals("Under 18")) {
                    giftIdeas += "Nintendo Switch Lite - Turquoise";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Nintendo-Switch-Lite-Turquoise/dp/B07VJRZ62R";
                } else if (selectedAge.equals("18-24")) {
                    giftIdeas += "PlayStation 5 Digital Edition";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/PlayStation-5-Digital/dp/B08FC5L3RG";
                } else if (selectedAge.equals("25-34")) {
                    giftIdeas += "Xbox Series S";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Xbox-Series-S/dp/B08G9J44ZN";
                } else if (selectedAge.equals("35+")) {
                    giftIdeas += "Super NES Classic";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Super-NES-Classic/dp/B0721GGGS9";
                }
            } else if (selectedHobby.equals("Music")) {
                if (selectedAge.equals("Under 18")) {
                    giftIdeas += "Apple iPod Touch 32GB Blue (Latest Model)";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Apple-iPod-touch-32GB-Blue/dp/B07PZCZ1VQ";
                } else if (selectedAge.equals("18-24")) {
                    giftIdeas += "Sony WH-1000XM4 Wireless Industry Leading Noise Canceling Overhead Headphones";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Sony-WH-1000XM4-Canceling-Headphones/dp/B08C5J1GYY";
                } else if (selectedAge.equals("25-34")) {
                    giftIdeas += "Apple AirPods Pro";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Apple-MWP22AM-A-AirPods-Pro/dp/B07ZPC9QD4";
                } else if (selectedAge.equals("35+")) {
                    giftIdeas += "Bose Wave Music System IV - Espresso Black";
                    giftIdeas += "\n\n";
                    giftIdeas += "https://www.amazon.com/Bose-Wave-Music-System-IV/dp/B011IH6MBO";
                }
            }
        }

        // Display the gift ideas and links in the activity
        TextView giftIdeasTextView = findViewById(R.id.gift_ideas_text_view);
        giftIdeasTextView.setText(giftIdeas);
    }

}