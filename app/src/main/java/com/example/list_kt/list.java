package com.example.list_kt;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list extends AppCompatActivity {
    ListView listview;
    ArrayList<sodienthoai> list;
    sodienthoaiAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listview=findViewById(R.id.listview);
        list=new ArrayList<>();
        list.add(new sodienthoai("Phước Dưỡng",R.drawable.utelogo));
        list.add(new sodienthoai("Dương Vương",R.drawable.utelogo));
        list.add(new sodienthoai("Phước Duy",R.drawable.utelogo));
        list.add(new sodienthoai("Nguyễn Long",R.drawable.utelogo));
        list.add(new sodienthoai("Duy Khoa",R.drawable.utelogo));
        list.add(new sodienthoai("Phước Lộc",R.drawable.utelogo));
        list.add(new sodienthoai("Tấn Tuấn",R.drawable.utelogo));
        list.add(new sodienthoai("Thảo Trinh",R.drawable.utelogo));
        list.add(new sodienthoai("Nhật Hào",R.drawable.utelogo));
        list.add(new sodienthoai("Minh Tân",R.drawable.utelogo));
        list.add(new sodienthoai("Ngọc Đức",R.drawable.utelogo));
        adapter=new sodienthoaiAdapter( this,R.layout.list_item,list);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(list.this,list.get(position).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete:
                list.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
//        return super.onContextItemSelected(item);

    }

}