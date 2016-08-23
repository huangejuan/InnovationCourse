package com.qa.nd.innovationcourse.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qa.nd.innovationcourse.R;
import com.qa.nd.innovationcourse.TeacherDetailActivity;
import com.qa.nd.innovationcourse.model.Teacher;

import java.util.List;


/**
 * Created by Administrator on 2016/8/10.
 */
public class TeacherAdapter extends ArrayAdapter<Teacher>{

    public TeacherAdapter(Context context, int resource, List<Teacher> objects){
        super(context,resource,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 获取老师的数据
        //不加final：错误: 从内部类中访问本地变量teacher; 需要被声明为最终类型
        final Teacher teacher = getItem(position);

        // 创建布局
        View oneTeacherView = LayoutInflater.from(getContext()).inflate(R.layout.teacher_item, parent, false);

        // 获取ImageView和TextView
        ImageView imageView = (ImageView) oneTeacherView.findViewById(R.id.teacher_small_imageView);
        TextView textView = (TextView) oneTeacherView.findViewById(R.id.teacher_name_textView);

        // 根据老师数据设置ImageView和TextView的展现
        imageView.setImageResource(teacher.getImageId());
        textView.setText(teacher.getName());
        oneTeacherView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TeacherDetailActivity.class);
                // 往Intent中传入Teacher相关的数据，供TeacherDetailActivity使用
                intent.putExtra("teacher_image", teacher.getImageId());
                intent.putExtra("teacher_desc", teacher.getDesc());
                getContext().startActivity(intent);
            }
        });
        return oneTeacherView;
    }
}
