package com.education.myliteorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.litesuits.orm.LiteOrm;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.button_insert)
    Button buttonInsert;
    @InjectView(R.id.button_delete)
    Button buttonDelete;
    @InjectView(R.id.button_update)
    Button buttonUpdate;
    @InjectView(R.id.button_select)
    Button buttonSelect;
    private static LiteOrm liteOrm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        // init lite-orm
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(this, "test.db");
        }
    }

    @OnClick({R.id.button_insert, R.id.button_delete, R.id.button_update, R.id.button_select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_insert:
                Student zhangsan = new Student("张三", 25, "男");
                liteOrm.insert(zhangsan);
                break;
            case R.id.button_delete:
                break;
            case R.id.button_update:
                Student lisi = new Student("莉丝", 30, "女");
                lisi.setId(3);
                liteOrm.update(lisi);
                break;
            case R.id.button_select:
                List<Student> studentList = liteOrm.query(Student.class);
                for (Student student : studentList) {
                    Log.d("------", "-----" + student.getName() + student.getId());
                }
                break;
        }
    }
}
