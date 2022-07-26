package com.js.ab;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnCreate = findViewById(R.id.main_bar_create);
        btnCreate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateActivity.class);
            startActivity(intent);
        });

        ImageButton btnSearch = findViewById(R.id.main_bar_search);
        btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        });

        ImageButton btnMore = findViewById(R.id.main_bar_more);
        btnMore.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MoreActivity.class);
            startActivity(intent);
        });
//        initListView();
    }

//    public void initListView() {
////        初始化控件
//        ListView mainTreeListView = findViewById(R.id.main_content_tree);
//        ListView mainContentListView = findViewById(R.id.main_content_item);
//        List<Item> treeList = new ArrayList<>();
//        List<Item> contentList = new ArrayList<>();
//        ArrayAdapter<Item> treeArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, treeList);
//        ArrayAdapter<Item> contentArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contentList);
//
////       添加目录、内容
//        for (int i = 0; i < 20; i++) {
//            treeList.add(new Item("目录", String.valueOf(i)));
//            contentList.add(new Item("账号", String.valueOf(i)));
//        }
//
////       设置适配器
//        mainTreeListView.setAdapter(treeArrayAdapter);
//        mainContentListView.setAdapter(contentArrayAdapter);
//
////        设置点击、长按响应
//        mainTreeListView.setOnItemClickListener((parent, view, position, id) -> {
//            Toast.makeText(MainActivity.this, "你选择了目录" + position, Toast.LENGTH_LONG).show();
//            mainContentListView.setSelection(position);
//        });
//        mainTreeListView.setOnItemLongClickListener((parent, view, position, id) -> {
//            Toast.makeText(MainActivity.this, "你长按了目录" + position, Toast.LENGTH_LONG).show();
//            return true;
//        });
//        mainContentListView.setOnItemClickListener((parent, view, position, id) ->
//                Toast.makeText(MainActivity.this, "你点击了账号" + position, Toast.LENGTH_LONG).show());
//        mainContentListView.setOnItemLongClickListener((parent, view, position, id) -> {
//            Toast.makeText(MainActivity.this, "你长按了目录" + position, Toast.LENGTH_LONG).show();
//            return true;
//        });
//
//    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(),
                    "再按一次退出登录",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}