package com.example.uisupsearch;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddProducts extends AppCompatActivity {
    EditText product;
    Button addbtn, vwbtn;
    ProductDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);
        product = (EditText) findViewById(R.id.addProduct);
        addbtn = (Button) findViewById(R.id.AddButton);
        vwbtn = (Button) findViewById(R.id.ViewButton);
        dbHelper = new ProductDBHelper(this);

        vwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(AddProducts.this, UserProducts.class);
                startActivity(inte);
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = product.getText().toString();
                if (!newEntry.equals("")) {
                    Toast.makeText(getApplicationContext(), "Product added!", Toast.LENGTH_SHORT).show();
                    //AddData(newEntry);
                    product.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
                } //else if (dbHelper.addData(newEntry) == false){
                //Toast.makeText(getApplicationContext(), "Oops something went wrong again!", Toast.LENGTH_SHORT).show();

                //}
            }
        });
        /**
        public void AddData(String n){
            boolean insertData = dbHelper.addData(n);
            if (insertData == true) {
                Toast.makeText(getApplicationContext(), "Successfully entered data!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Oops something went wrong!", Toast.LENGTH_SHORT).show();
            }
        }
         **/
    }
}
/**listName = new ArrayList<>();
 listPrice = new ArrayList<>();
 listCategory = new ArrayList<>();
 listPhone = new ArrayList<>();
 listEmail = new ArrayList<>();

 userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
String text = userList.getItemAtPosition(position).toString();
Toast.makeText(AddProducts.this, "" + text, Toast.LENGTH_SHORT).show();
}
});

 Cursor cursor = dbHelper.getList();
 if (cursor.getCount() == 0) {
 Toast.makeText(getApplicationContext(), "No products :( YET", Toast.LENGTH_SHORT).show();
 } else {
 hashMap.put(cursor.getString(0), cursor.getString(1));
 List<HashMap<String, String>> listItems = new ArrayList<>();
 SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.item_list, new String[]{"First Line", "Second Line"}, new int[]{R.id.text1, R.id.text2});
 Iterator it = hashMap.entrySet().iterator();
 while (it.hasNext()) {
 HashMap<String, String> resultsMap = new HashMap<>();
 Map.Entry pair = (Map.Entry)it.next();
 resultsMap.put("First Line", pair.getKey().toString());
 resultsMap.put("Second Line", pair.getValue().toString());
 }
 userList.setAdapter(adapter);
 do {
 listName.add(cursor.getString(0));
 listPrice.add(cursor.getString(1));
 listCategory.add(cursor.getString(2));
 listPhone.add(cursor.getString(3));
 listEmail.add(cursor.getString(4));

 //Toast.makeText(getApplicationContext(), "Product:" + cursor.getString(0), Toast.LENGTH_SHORT).show();
 } while (cursor.moveToNext());
 adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listName);
 //adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPrice);
 //adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCategory);
 //adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPhone);
 //adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listEmail);

 userList.setAdapter(adapter);
 //userList.setAdapter(adapter1);
 //userList.setAdapter(adapter2);
 //userList.setAdapter(adapter3);
 //userList.setAdapter(adapter4);
 cursor.close();
 }
 **/

