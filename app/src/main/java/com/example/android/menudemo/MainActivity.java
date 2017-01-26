package com.example.android.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // String names[]= {"imran","Sagar","Sujon","Hafeez","Aslam"};
        list=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            list.add("Imran");
        }


        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                saveName();
                break;
            case R.id.action_delete:
                delete();
                break;
            default:
                break;



        }
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "View Details");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "Delete");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo
                = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String name=list.get(adapterContextMenuInfo.position);

        if(item.getTitle()=="View Details"){
            Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="Delete"){
            Toast.makeText(getApplicationContext(),"Sorry Sir! Cant make it functional now",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

    public void saveName()
    {
        Intent intent=new Intent(MainActivity.this,AddActivity.class);
        startActivityForResult(intent,1);

    }
    public void delete()
    {
        Intent intent=new Intent(MainActivity.this,DeleteActivity.class);
        startActivityForResult(intent,2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                String nameSave = data.getStringExtra("name");
                list.add(nameSave);
                arrayAdapter.notifyDataSetChanged();
                System.out.println(requestCode);
                break;

            case 2:
                String nameDelete = data.getStringExtra("name");
                int position = list.indexOf(nameDelete);
                list.remove(position);
                arrayAdapter.notifyDataSetChanged();
                break;
            default:
                break;
            }
        }
    }

