package com.huyg.autumn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class MainActivity extends AppCompatActivity {

    private TextView mContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContent = findViewById(R.id.content);
        init();

    }

    private void init() {
        StringBuilder stringBuffer = new StringBuilder();
        Globals globals = LuaLoader.getInstance().getGlobals();
        globals.loadfile("Hello.lua").call();
        // 获取函数:pi()
        LuaValue func = globals.get(LuaValue.valueOf("pi"));
// 执行pi()方法获取圆周率
        double pi = func.call().todouble();
        stringBuffer.append("pi" + pi);

// 获取带参函数circle_area()
        LuaValue func1 = globals.get(LuaValue.valueOf("circle_area"));
// 执行circle_area方法,传入double类型的半径参数
        double area = func1.call(LuaValue.valueOf(3.0)).todouble();
// 打印lua函数回传的数据
        stringBuffer.append("\n半径为3.0的圆形面积为：" + area);

        mContent.setText(stringBuffer.toString());
    }
}
