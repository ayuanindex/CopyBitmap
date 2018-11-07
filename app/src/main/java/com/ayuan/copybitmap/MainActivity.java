package com.ayuan.copybitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显示原图
        ImageView iv_a = (ImageView) findViewById(R.id.iv_a);
        //显示副本
        ImageView iv_aa = (ImageView) findViewById(R.id.iv_aa);

        //1.先把a.png图片转换成bitmap 显示到iv_a上
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);
        iv_a.setImageBitmap(bitmap);

        //创建原图的副本
        //3.创建一个模板 相当于创建了一个大小和原图的图但是什么都没有
        Bitmap copy = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //4.创建一个可以编辑的类
        Paint paint = new Paint();
        //5.创建一个用于编辑的画板
        Canvas canvas = new Canvas(copy);
        //6.开始创建副本
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        //7.操作拷贝过后的图片
        copy.setPixel(30, 20, Color.GREEN);
        //.把copy显示到控件上
        iv_aa.setImageBitmap(copy);

    }
}
