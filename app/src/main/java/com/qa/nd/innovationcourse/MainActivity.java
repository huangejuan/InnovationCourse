package com.qa.nd.innovationcourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.qa.nd.innovationcourse.adapter.TeacherAdapter;
import com.qa.nd.innovationcourse.model.Teacher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //将数据传递给ListView的适配器是ArrayAdapter
        /*第一个参数是this，表示传入的是当前的Activity
        第二个参数是android.R.layout.simple_list_item_1，这是Android系统自带的一个列表元素（即列表中的每一行）布局，只显一串简单的文字
        第三个参数是需要显示的所有数据构成的List，即数据源*/
        //ArrayAdapter<String> teacherAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Teacher.getAllTeachers());
        TeacherAdapter teacherAdapter = new TeacherAdapter(this,R.layout.teacher_item, Teacher.getAllTeachers());
        //通过ID获取listView
        ListView listView = (ListView) findViewById(R.id.teacher_listView);

        //设置listView的Adapter
        listView.setAdapter(teacherAdapter);
    }
}
