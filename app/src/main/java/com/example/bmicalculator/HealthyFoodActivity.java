package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HealthyFoodActivity extends AppCompatActivity {

    Button buttonGoToFullList;
    Button buttonGoBack;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_food);

        buttonGoToFullList = findViewById(R.id.buttonGoToFullList);
        buttonGoBack = findViewById(R.id.buttonGoBackView);

        listView = findViewById(R.id.listView);

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), BMIActivity.class);
                startActivity(intent2);
            }
        });

        buttonGoToFullList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FullFoodsActivity.class);
                startActivity(intent);
            }
        });

        List<Food> listFromBase = changeGoodFood(fromJsonString(loadJsonString()));

//        changeGoodFood((ArrayList<Food>) listFromBase);

        ArrayAdapter<String> adapter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            adapter = new ArrayAdapter<>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_activated_1,
//                    changeGoodFood((ArrayList<Food>) listFromBase)
                    listFromBase
                            .stream().map(Food::toListElement)
                            .collect(Collectors.toList())


            );
        }

        listView.setAdapter(adapter);

    }


        private ArrayList<Food> changeGoodFood(ArrayList<Food> foods) {

            ArrayList<Food> foods1 = new ArrayList<Food>();

            for (int i = 0; i < foods.size(); ++i) {
                if (foods.get(i).getCalories() < 80) {
                    foods1.add(foods.get(i));
                    //System.out.println(foods1.get(i));
                }
            }
            return foods1;
        }



        private ArrayList<Food> fromJsonString(String json) {
            try {
                return new ObjectMapper().readValue(json, new TypeReference<ArrayList<Food>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<Food>();
            }
        }

        private String loadJsonString () {
            /// функция должна лезть в файл и возвращать содержимое
            return "[\n" +
                    "  {\n" +
                    "    \"name\": \"Абрикосы\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 45\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Авокадо\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 19,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 197\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Аджика\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 59\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Айва\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 41\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Айсберг\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 17\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Активиа кефирная 1%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 39\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Ананас\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 12,\n" +
                    "    \"calories\": 50\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Ананас консервированный\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 65\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Ананас цукаты\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 15,\n" +
                    "    \"calories\": 78\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Апельсин\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 43\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Апельсиновый сок\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 44\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Арахис\",\n" +
                    "    \"proteins\": 25,\n" +
                    "    \"fats\": 46,\n" +
                    "    \"carbohydrates\": 13,\n" +
                    "    \"calories\": 561\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Арахис в сахаре\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 30,\n" +
                    "    \"carbohydrates\": 51,\n" +
                    "    \"calories\": 535\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Базилик свежий\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 27\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Баклажаны\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 27\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Банан\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 22,\n" +
                    "    \"calories\": 97\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Баранина вареная\",\n" +
                    "    \"proteins\": 24,\n" +
                    "    \"fats\": 21,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 286\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Батон\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 49,\n" +
                    "    \"calories\": 264\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Бедро индейки\",\n" +
                    "    \"proteins\": 16,\n" +
                    "    \"fats\": 9,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 143\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Бекон\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 45,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 469\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Блины обычные\",\n" +
                    "    \"proteins\": 6,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 25,\n" +
                    "    \"calories\": 178\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Борщ лёгкий\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 58\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Брокколи\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 33\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Брусника\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 42\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Бульон из говядины\",\n" +
                    "    \"proteins\": 6,\n" +
                    "    \"fats\": 4,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 57\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Бульон из куриной грудки\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 42\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Бульон куриный\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 33\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вареная говядина\",\n" +
                    "    \"proteins\": 23,\n" +
                    "    \"fats\": 16,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 236\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вареная колбаса\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 22,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 253\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вареная куриная грудка\",\n" +
                    "    \"proteins\": 27,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 138\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вареная курица\",\n" +
                    "    \"proteins\": 19,\n" +
                    "    \"fats\": 9,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 150\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вареная морковь\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 31\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вареная чечевица\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 20,\n" +
                    "    \"calories\": 111\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Варёная сгущёнка\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 9,\n" +
                    "    \"carbohydrates\": 55,\n" +
                    "    \"calories\": 326\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вермишель\",\n" +
                    "    \"proteins\": 11,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 72,\n" +
                    "    \"calories\": 347\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Ветчина\",\n" +
                    "    \"proteins\": 16,\n" +
                    "    \"fats\": 19,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 246\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вино белое сухое\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 67\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Виноград\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 69\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вино красное сухое\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 70\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Вишня\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 54\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Геркулес\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 56,\n" +
                    "    \"calories\": 327\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Говядина\",\n" +
                    "    \"proteins\": 20,\n" +
                    "    \"fats\": 13,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 192\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Говяжья печень\",\n" +
                    "    \"proteins\": 17,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 110\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Голень куриная\",\n" +
                    "    \"proteins\": 20,\n" +
                    "    \"fats\": 9,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 168\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Голландский сыр\",\n" +
                    "    \"proteins\": 24,\n" +
                    "    \"fats\": 30,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 373\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Голубика\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 46\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Горбуша\",\n" +
                    "    \"proteins\": 21,\n" +
                    "    \"fats\": 7,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 143\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Горох\",\n" +
                    "    \"proteins\": 19,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 42,\n" +
                    "    \"calories\": 256\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Гороховое пюре\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 23,\n" +
                    "    \"calories\": 106\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Горошек зеленый\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 59\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Горчица\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 11,\n" +
                    "    \"carbohydrates\": 13,\n" +
                    "    \"calories\": 184\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Гранат\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 14,\n" +
                    "    \"calories\": 67\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грейпфрут\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 41\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грецкие орехи\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 65,\n" +
                    "    \"carbohydrates\": 14,\n" +
                    "    \"calories\": 697\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Гречневая каша рассыпчатая\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 24,\n" +
                    "    \"calories\": 131\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Гречневая крупа\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 4,\n" +
                    "    \"carbohydrates\": 63,\n" +
                    "    \"calories\": 329\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы белые\",\n" +
                    "    \"proteins\": 9,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 28\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы белые сушеные\",\n" +
                    "    \"proteins\": 27,\n" +
                    "    \"fats\": 7,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 239\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы грузди\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы лисички\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 20\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы маслята\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 9\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы опята\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 17\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы подберёзовики свежие\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 17\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы подосиновики свежие\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 26\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы рыжики\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 17\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Грибы шампиньоны\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 22\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Груша\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 12,\n" +
                    "    \"calories\": 51\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Груша (сухофрукты)\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 62,\n" +
                    "    \"calories\": 246\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Дайкон\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 21\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Джем мандариновый\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 72,\n" +
                    "    \"calories\": 276\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Дрожжи\",\n" +
                    "    \"proteins\": 29,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 23,\n" +
                    "    \"calories\": 263\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Дрожжи сухие\",\n" +
                    "    \"proteins\": 49,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 40,\n" +
                    "    \"calories\": 410\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Дыня\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 35\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Ежевика\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 31\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Жареное яйцо\",\n" +
                    "    \"proteins\": 14,\n" +
                    "    \"fats\": 14,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 183\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Желатин\",\n" +
                    "    \"proteins\": 86,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 343\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Зеленая фасоль\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 30\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Зеленый лук\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 19\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Зелень петрушки\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 50\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Зелёный горошек \\\"Бондюэль\\\"\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 60\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Зелёный горошек \\\"Фрау Марта\\\"\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 40\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Земляника\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 38\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Зефир бело-розовый\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 80,\n" +
                    "    \"calories\": 304\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Изюм\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 68,\n" +
                    "    \"calories\": 280\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Имбирь свежий\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 72\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Индейка (грудка)\",\n" +
                    "    \"proteins\": 19,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 94\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Индейка (филе)\",\n" +
                    "    \"proteins\": 20,\n" +
                    "    \"fats\": 12,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 188\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Инжир (сухофрукты)\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 57,\n" +
                    "    \"calories\": 239\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Йогурт Активия\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 97\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кабачки жареные\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 91\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кабачки цукини\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кабачковая икра\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 90\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кабачок\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 28\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Какао\",\n" +
                    "    \"proteins\": 14,\n" +
                    "    \"fats\": 9,\n" +
                    "    \"carbohydrates\": 26,\n" +
                    "    \"calories\": 234\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Какао порошок\",\n" +
                    "    \"proteins\": 23,\n" +
                    "    \"fats\": 15,\n" +
                    "    \"carbohydrates\": 29,\n" +
                    "    \"calories\": 326\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кальмар\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 97\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кальмар вареный\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 103\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Каперсы\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 21\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста белокочаная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 28\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста белокочанная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 29\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста брокколи замороженая\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 21\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста брюссельская\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 47\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста жареная\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 88\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста квашенная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 23\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста китайская\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста кольраби\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 42\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста краснокочанная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 29\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста морская\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 5,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 58\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста пекинская\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 15\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Капуста цветная\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 34\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Картофель\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 20,\n" +
                    "    \"calories\": 84\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Картофель молодой\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 61\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Картофельные хлопья\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 83,\n" +
                    "    \"calories\": 366\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Картофель отварной\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 83\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Картофель печеный\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 22,\n" +
                    "    \"calories\": 113\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Картофель фри\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 17,\n" +
                    "    \"carbohydrates\": 40,\n" +
                    "    \"calories\": 323\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Картошка\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 21,\n" +
                    "    \"calories\": 105\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Каша рисовая\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 26,\n" +
                    "    \"calories\": 130\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Квас хлебный\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 24\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кедровые орехи\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 63,\n" +
                    "    \"carbohydrates\": 17,\n" +
                    "    \"calories\": 652\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кетчуп\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 90\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кефир 1%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 45\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кефир 2,5%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 52\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кефир 3,2%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 58\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кешью\",\n" +
                    "    \"proteins\": 21,\n" +
                    "    \"fats\": 48,\n" +
                    "    \"carbohydrates\": 20,\n" +
                    "    \"calories\": 607\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Киви\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 51\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Клубника\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 32\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Клюква\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 43\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Клюква сушеная\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 70,\n" +
                    "    \"calories\": 305\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Козий сыр\",\n" +
                    "    \"proteins\": 19,\n" +
                    "    \"fats\": 23,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 296\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Колбаса вареная \\\"докторская\\\"\",\n" +
                    "    \"proteins\": 13,\n" +
                    "    \"fats\": 22,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 254\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Конфеты Батончики Рот Фронт с орехами\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 32,\n" +
                    "    \"carbohydrates\": 49,\n" +
                    "    \"calories\": 379\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Корень имбиря\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 18,\n" +
                    "    \"calories\": 90\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Корень сельдерея\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 31\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Коричневый сахар\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 92,\n" +
                    "    \"calories\": 393\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Корнишоны маринованные\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 36\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Котлеты полтавские\",\n" +
                    "    \"proteins\": 26,\n" +
                    "    \"fats\": 32,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 415\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кофе молотый Арабика\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 14,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 193\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кофе растворимый (сухой)\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 4,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 116\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кофе эспрессо крепкий\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 19\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кофе \\\"якобз монарх\\\" (растворимый)\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 97\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крабовые палочки\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 85\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Краковская колбаса\",\n" +
                    "    \"proteins\": 17,\n" +
                    "    \"fats\": 39,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 420\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Красная фасоль консервированная\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 17,\n" +
                    "    \"calories\": 99\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крахмал картофельный\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 82,\n" +
                    "    \"calories\": 335\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крахмал кукурузный\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 87,\n" +
                    "    \"calories\": 348\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Краюшка\",\n" +
                    "    \"proteins\": 9,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 43,\n" +
                    "    \"calories\": 226\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Креветки (отварные)\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 90\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа гречневая\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 65,\n" +
                    "    \"calories\": 326\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа кукурузная\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 75,\n" +
                    "    \"calories\": 337\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа манная\",\n" +
                    "    \"proteins\": 11,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 70,\n" +
                    "    \"calories\": 330\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа овсяная\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 65,\n" +
                    "    \"calories\": 342\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа перловая\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 65,\n" +
                    "    \"calories\": 328\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа пшеничная\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 63,\n" +
                    "    \"calories\": 322\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа рис длиннозерный пропаренный\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 74,\n" +
                    "    \"calories\": 333\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа рисовая\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 11,\n" +
                    "    \"carbohydrates\": 63,\n" +
                    "    \"calories\": 330\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крупа ячневая\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 59,\n" +
                    "    \"calories\": 318\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Крыжовник\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 41\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кукуруза консервированная\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 17,\n" +
                    "    \"calories\": 87\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кукурузные хлопья\",\n" +
                    "    \"proteins\": 6,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 73,\n" +
                    "    \"calories\": 353\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кунжут\",\n" +
                    "    \"proteins\": 20,\n" +
                    "    \"fats\": 50,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 562\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Курага\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 54,\n" +
                    "    \"calories\": 232\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Куриная печень\",\n" +
                    "    \"proteins\": 19,\n" +
                    "    \"fats\": 7,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 140\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Куриные грудки\",\n" +
                    "    \"proteins\": 23,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 144\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Куриные окорочка\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 11,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 170\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Курица\",\n" +
                    "    \"proteins\": 21,\n" +
                    "    \"fats\": 11,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 186\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Кус-Кус (крупа)\",\n" +
                    "    \"proteins\": 13,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 77,\n" +
                    "    \"calories\": 373\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лаваш грузинский\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 53,\n" +
                    "    \"calories\": 269\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лайм\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 20\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лапша гречневая\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 71,\n" +
                    "    \"calories\": 348\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лапша рисовая\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 81,\n" +
                    "    \"calories\": 350\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лапша яичная\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 64,\n" +
                    "    \"calories\": 330\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лимон\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 27\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лимонный сок\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 20\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лосось\",\n" +
                    "    \"proteins\": 21,\n" +
                    "    \"fats\": 10,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 172\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лук\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 40\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лук зелёный перо\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Лук красный салатный\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 42\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Льняное масло\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 92,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 849\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Майонез\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 57,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 550\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Майонез 15%\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 15,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 156\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Майонез провансаль 67%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 369,\n" +
                    "    \"carbohydrates\": 25,\n" +
                    "    \"calories\": 619\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мак\",\n" +
                    "    \"proteins\": 17,\n" +
                    "    \"fats\": 46,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 519\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Макаронные изделия\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 72,\n" +
                    "    \"calories\": 344\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Макароны отварные\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 23,\n" +
                    "    \"calories\": 119\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Малина\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 41\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Манго\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 13,\n" +
                    "    \"calories\": 62\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Манго цукаты\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 60,\n" +
                    "    \"calories\": 278\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мандарин\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 40\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Манная крупа\",\n" +
                    "    \"proteins\": 11,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 68,\n" +
                    "    \"calories\": 334\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Маргарин молочный\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 82,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 745\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Маргарин солнечный\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 72,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 653\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мармелад\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 75,\n" +
                    "    \"calories\": 302\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Маслины\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 14,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 167\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Маслины без косточки\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 13,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 133\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Масло кукурузное\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 101,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 916\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Масло льняное\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 96,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 895\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Масло оливковое\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 91,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 851\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Масло подсолнечное\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 96,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 864\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Масло растительное\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 97,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 897\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Масло сливочное\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 74,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 674\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Масло топленое\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 86,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 890\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мед\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 80,\n" +
                    "    \"calories\": 315\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Миндаль\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 51,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 601\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Молоко\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 66\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Молоко 0,5%\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 35\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Молоко 1,5%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 44\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Молоко 2,5%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 64\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Молоко 3,2%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 67\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Молоко сгущёное\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 9,\n" +
                    "    \"carbohydrates\": 56,\n" +
                    "    \"calories\": 317\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Молоко сухое\",\n" +
                    "    \"proteins\": 31,\n" +
                    "    \"fats\": 22,\n" +
                    "    \"carbohydrates\": 36,\n" +
                    "    \"calories\": 446\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Морковь отварная\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 32\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Морковь печеная\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 31\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Морковь свежая\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 35\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мороженое Пломбир\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 15,\n" +
                    "    \"carbohydrates\": 24,\n" +
                    "    \"calories\": 245\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Морская капуста\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 37\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мука кукурузная\",\n" +
                    "    \"proteins\": 9,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 65,\n" +
                    "    \"calories\": 333\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мука пшеничная в/с\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 71,\n" +
                    "    \"calories\": 332\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мука ржаная\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 65,\n" +
                    "    \"calories\": 307\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мюстли с фруктами\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 68,\n" +
                    "    \"calories\": 314\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мясо свинина\",\n" +
                    "    \"proteins\": 26,\n" +
                    "    \"fats\": 29,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 293\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Мясо свинина постная\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 8,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 151\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Нектарин\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 47\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Облепиха\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 47\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Овощная смесь “Весенние овощи”\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 30\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Овсяная мука\",\n" +
                    "    \"proteins\": 13,\n" +
                    "    \"fats\": 7,\n" +
                    "    \"carbohydrates\": 65,\n" +
                    "    \"calories\": 368\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Овсянка\",\n" +
                    "    \"proteins\": 9,\n" +
                    "    \"fats\": 5,\n" +
                    "    \"carbohydrates\": 46,\n" +
                    "    \"calories\": 271\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Овсянные хлопья \\\"геркулес\\\"\",\n" +
                    "    \"proteins\": 11,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 51,\n" +
                    "    \"calories\": 305\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Огурцы\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 19\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Огурцы грунтовые\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 14\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Огурцы маринованные\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Огурцы солёные\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 14\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Оливки\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 17,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 178\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Оливки зеленые без косточки\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 17,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 157\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Омлет\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 14,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 175\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Орех грецкий\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 64,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 671\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Отруби овсяные\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 7,\n" +
                    "    \"carbohydrates\": 45,\n" +
                    "    \"calories\": 305\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Отруби пшеничные очищенные\",\n" +
                    "    \"proteins\": 13,\n" +
                    "    \"fats\": 4,\n" +
                    "    \"carbohydrates\": 23,\n" +
                    "    \"calories\": 214\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Отруби ржаные очищенные\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 167\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Паприка\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 112\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Патиссон\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 19\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Перепелиное яйцо\",\n" +
                    "    \"proteins\": 13,\n" +
                    "    \"fats\": 13,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 167\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Перец сладкий\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 26\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Перец чили\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 40\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Перловка (крупа)\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 76,\n" +
                    "    \"calories\": 346\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Перловка отварная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 27,\n" +
                    "    \"calories\": 121\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Персики\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 12,\n" +
                    "    \"calories\": 51\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Персики (сухофрукты)\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 42,\n" +
                    "    \"calories\": 168\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Петрушка корень\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 48\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Петрушка свежая\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 38\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Печенье \\\"Юбилейное\\\" Молочное\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 18,\n" +
                    "    \"carbohydrates\": 66,\n" +
                    "    \"calories\": 455\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Печень куриная\",\n" +
                    "    \"proteins\": 27,\n" +
                    "    \"fats\": 7,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 144\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Пиво светлое\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 50\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Плавленный сыр\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 20,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 280\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Помидоры консервированные\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 23\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Помидоры свежие\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 33\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Простокваша\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 52\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Пшено\",\n" +
                    "    \"proteins\": 11,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 68,\n" +
                    "    \"calories\": 337\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Ревень черешковый\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Редис\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 20\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Редька\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 35\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Редька зеленая\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 35\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Репа\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 29\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Рис\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 75,\n" +
                    "    \"calories\": 331\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Рис отварной\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 25,\n" +
                    "    \"calories\": 134\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Рожки отварные\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 24,\n" +
                    "    \"calories\": 115\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Рожки (сухой продукт)\",\n" +
                    "    \"proteins\": 11,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 72,\n" +
                    "    \"calories\": 344\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Руккола\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 24\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Рыба скумбрия\",\n" +
                    "    \"proteins\": 16,\n" +
                    "    \"fats\": 13,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 187\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Рыба треска\",\n" +
                    "    \"proteins\": 17,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 80\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Рябина черноплодная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 12,\n" +
                    "    \"calories\": 54\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Ряженка\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 62\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Салат лист\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сахар песок\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 109,\n" +
                    "    \"calories\": 396\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Свежая капуста\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 25\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Свежий укроп\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 38\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Свекла\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 12,\n" +
                    "    \"calories\": 61\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Свекла отварная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 50\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Свинина\",\n" +
                    "    \"proteins\": 16,\n" +
                    "    \"fats\": 27,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 304\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сельдерей\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 13\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сельдерей стебель\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 11\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сельдь атлантическая жирная\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 15,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 204\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Семена тыквы неочищенные с солью\",\n" +
                    "    \"proteins\": 29,\n" +
                    "    \"fats\": 47,\n" +
                    "    \"carbohydrates\": 13,\n" +
                    "    \"calories\": 596\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Семечки подсолнечные\",\n" +
                    "    \"proteins\": 26,\n" +
                    "    \"fats\": 50,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 583\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сладкая кукуруза в початках\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 21,\n" +
                    "    \"calories\": 124\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Слива садовая\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 45\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сливки 10%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 10,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 118\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сливки 20%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 20,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 206\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сливки 22%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 22,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 224\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сливки 33%\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 33,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 322\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Смесь орехов и сухофруктов экзотик\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 26,\n" +
                    "    \"carbohydrates\": 52,\n" +
                    "    \"calories\": 466\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сметана 10 %\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 10,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 117\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сметана 15%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 15,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 159\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сметана 20%\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 19,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 204\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сметана 30 %\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 30,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 291\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Смородина красная\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 8,\n" +
                    "    \"calories\": 40\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Смородина чёрная\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 41\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Соевый соус\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 22,\n" +
                    "    \"calories\": 36\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок апельсиновый\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 47\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок грейпфрутовый\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 44\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок лайма\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 22\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок лимона\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 18\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок лимонный\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 29\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок мандарина\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 43\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок свекольный\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 14,\n" +
                    "    \"calories\": 61\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок томатный\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 21\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сок яблочный\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 44\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Соленый огурец\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 14\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Соус соевый\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 53\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Соя\",\n" +
                    "    \"proteins\": 34,\n" +
                    "    \"fats\": 12,\n" +
                    "    \"carbohydrates\": 27,\n" +
                    "    \"calories\": 359\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Спагетти отварные\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 46,\n" +
                    "    \"calories\": 223\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Спагетти (сухой продукт)\",\n" +
                    "    \"proteins\": 10,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 72,\n" +
                    "    \"calories\": 344\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сухари панировочные\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 74,\n" +
                    "    \"calories\": 362\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыворотка\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 22\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыр 45%\",\n" +
                    "    \"proteins\": 26,\n" +
                    "    \"fats\": 26,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 336\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыр 50% «Сливочный»\",\n" +
                    "    \"proteins\": 23,\n" +
                    "    \"fats\": 28,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 288\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыр Адыгейский\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 16,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 224\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыр гауда\",\n" +
                    "    \"proteins\": 24,\n" +
                    "    \"fats\": 27,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 350\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыр «Лёгкий»\",\n" +
                    "    \"proteins\": 23,\n" +
                    "    \"fats\": 17,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 300\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сырок плавленный \\\"Дружба\\\"\",\n" +
                    "    \"proteins\": 6,\n" +
                    "    \"fats\": 19,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 178\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыр \\\"российский\\\"\",\n" +
                    "    \"proteins\": 23,\n" +
                    "    \"fats\": 29,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 361\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Сыр твердый\",\n" +
                    "    \"proteins\": 25,\n" +
                    "    \"fats\": 27,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 358\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Тархун\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 41\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Творог 0%\",\n" +
                    "    \"proteins\": 16,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 75\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Творог 1%\",\n" +
                    "    \"proteins\": 17,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 82\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Творог 10%\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 9,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 150\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Творог 5 %\",\n" +
                    "    \"proteins\": 17,\n" +
                    "    \"fats\": 5,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 122\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Творог 9%\",\n" +
                    "    \"proteins\": 16,\n" +
                    "    \"fats\": 8,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 153\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Творожная масса с цукатами\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 21,\n" +
                    "    \"carbohydrates\": 33,\n" +
                    "    \"calories\": 349\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Тесто дрожжевое\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 4,\n" +
                    "    \"carbohydrates\": 43,\n" +
                    "    \"calories\": 238\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Тесто слоеное дрожжевое\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 19,\n" +
                    "    \"carbohydrates\": 40,\n" +
                    "    \"calories\": 356\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Тесто слоёное бездрожжевое\",\n" +
                    "    \"proteins\": 6,\n" +
                    "    \"fats\": 18,\n" +
                    "    \"carbohydrates\": 38,\n" +
                    "    \"calories\": 335\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Томат\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 27\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Томатная паста помидорка\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 15,\n" +
                    "    \"calories\": 77\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Томатный сок\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 25\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Томаты (парниковые)\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 14\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Томаты черри\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 17\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Треска филе\",\n" +
                    "    \"proteins\": 17,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 78\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Тушенка говядина высший сорт\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 17,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 213\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Тыква\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 22\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Укроп\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 38\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Уксус столовый 6-7%\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 13\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Урюк (сухофрукты)\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 51,\n" +
                    "    \"calories\": 213\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фарш говяжий\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 16,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 214\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фарш куриный\",\n" +
                    "    \"proteins\": 19,\n" +
                    "    \"fats\": 10,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 166\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фасоль\",\n" +
                    "    \"proteins\": 18,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 44,\n" +
                    "    \"calories\": 263\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фасоль «Бондюэль»\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 10,\n" +
                    "    \"calories\": 74\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фасоль стручковая\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 29\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фасоль стручковая замороженная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 26\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фасоль Фрау Марта\",\n" +
                    "    \"proteins\": 6,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 16,\n" +
                    "    \"calories\": 92\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фасоль \\\"Фрау Марта\\\" в томатном соусе\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 15,\n" +
                    "    \"calories\": 86\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фасоль Фрау Марта Лобио\",\n" +
                    "    \"proteins\": 5,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 13,\n" +
                    "    \"calories\": 80\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фенхель\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 31\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Филе куринное\",\n" +
                    "    \"proteins\": 23,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 114\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Филе куриной грудки\",\n" +
                    "    \"proteins\": 22,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 0,\n" +
                    "    \"calories\": 109\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Финики (сухофрукты)\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 72,\n" +
                    "    \"calories\": 280\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фруктоза\",\n" +
                    "    \"proteins\": 0,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 100,\n" +
                    "    \"calories\": 390\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Фундук\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 62,\n" +
                    "    \"carbohydrates\": 11,\n" +
                    "    \"calories\": 665\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хлеб белый\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 54,\n" +
                    "    \"calories\": 254\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хлеб \\\"бородинский\\\"\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 42,\n" +
                    "    \"calories\": 210\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хлеб пшеничный\",\n" +
                    "    \"proteins\": 8,\n" +
                    "    \"fats\": 3,\n" +
                    "    \"carbohydrates\": 50,\n" +
                    "    \"calories\": 263\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хлеб ржаной\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 36,\n" +
                    "    \"calories\": 187\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хлебцы пшеничные\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 60,\n" +
                    "    \"calories\": 305\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хлопья кукурузные\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 84,\n" +
                    "    \"calories\": 373\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хлопья овсяные\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 6,\n" +
                    "    \"carbohydrates\": 52,\n" +
                    "    \"calories\": 308\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хрен\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 5,\n" +
                    "    \"carbohydrates\": 14,\n" +
                    "    \"calories\": 113\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Хурма\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 15,\n" +
                    "    \"calories\": 65\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Цветная капуста отварная\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 29\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Цедра апельсина\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 6,\n" +
                    "    \"calories\": 36\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Цедра лимона\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 4,\n" +
                    "    \"calories\": 28\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Цукаты\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 56,\n" +
                    "    \"calories\": 224\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Цукини\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 3,\n" +
                    "    \"calories\": 18\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Черемша\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 7,\n" +
                    "    \"calories\": 37\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Черешня\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 12,\n" +
                    "    \"calories\": 51\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Черника\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 9,\n" +
                    "    \"calories\": 39\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Чернослив (сухофрукты)\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 62,\n" +
                    "    \"calories\": 256\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Чеснок\",\n" +
                    "    \"proteins\": 6,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 23,\n" +
                    "    \"calories\": 115\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Чечевица зелёная\",\n" +
                    "    \"proteins\": 24,\n" +
                    "    \"fats\": 2,\n" +
                    "    \"carbohydrates\": 44,\n" +
                    "    \"calories\": 286\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Чечевица красная\",\n" +
                    "    \"proteins\": 22,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 49,\n" +
                    "    \"calories\": 312\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шампиньоны\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 26\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шампиньоны замороженные\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 27\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шампиньоны резанные консервированные\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 16\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шелковица\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 13,\n" +
                    "    \"calories\": 52\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шиповник сушёный\",\n" +
                    "    \"proteins\": 4,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 60,\n" +
                    "    \"calories\": 253\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шоколад горький 75%\",\n" +
                    "    \"proteins\": 9,\n" +
                    "    \"fats\": 41,\n" +
                    "    \"carbohydrates\": 39,\n" +
                    "    \"calories\": 550\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шоколад горький 80%\",\n" +
                    "    \"proteins\": 12,\n" +
                    "    \"fats\": 39,\n" +
                    "    \"carbohydrates\": 34,\n" +
                    "    \"calories\": 527\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шоколад молочный\",\n" +
                    "    \"proteins\": 7,\n" +
                    "    \"fats\": 34,\n" +
                    "    \"carbohydrates\": 52,\n" +
                    "    \"calories\": 539\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Шпинат\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 2,\n" +
                    "    \"calories\": 22\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Щавель\",\n" +
                    "    \"proteins\": 2,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 5,\n" +
                    "    \"calories\": 25\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Яблоки\",\n" +
                    "    \"proteins\": 1,\n" +
                    "    \"fats\": 1,\n" +
                    "    \"carbohydrates\": 13,\n" +
                    "    \"calories\": 60\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Яблоки сушёные (сухофрукты)\",\n" +
                    "    \"proteins\": 3,\n" +
                    "    \"fats\": 0,\n" +
                    "    \"carbohydrates\": 66,\n" +
                    "    \"calories\": 269\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Яйца\",\n" +
                    "    \"proteins\": 15,\n" +
                    "    \"fats\": 13,\n" +
                    "    \"carbohydrates\": 1,\n" +
                    "    \"calories\": 162\n" +
                    "  }\n" +
                    "]";
        }
}