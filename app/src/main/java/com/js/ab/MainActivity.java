package com.js.ab;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.js.ab.Adapter.ContentItemAdapter;
import com.js.ab.Adapter.TreeItemAdapter;
import com.js.ab.Bean.ContentItemBean;
import com.js.ab.Bean.TreeItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ContentItemBean> mDataContentItem = new ArrayList<>();
    List<TreeItemBean> mDataTreeItem = new ArrayList<>();

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

        initListView();
    }

    public void initListView() {
//        初始化控件
        ListView mainTreeListView = findViewById(R.id.main_lv_tree);
        ListView mainContentListView = findViewById(R.id.main_lv_content);

        mainTreeListView.setAdapter(new TreeItemAdapter(this, mDataTreeItem));
        mainContentListView.setAdapter(new ContentItemAdapter(this, mDataContentItem));
        for (int i = 0; i < 8; i++) {
            mDataTreeItem.add(new TreeItemBean("分类" + i));
        }
        for (int i = 0; i < 20; i++) {
            mDataContentItem.add(new ContentItemBean("账号名称" + i, "账号" + i));
        }
    }

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
                    "再按一次返回键退出",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}