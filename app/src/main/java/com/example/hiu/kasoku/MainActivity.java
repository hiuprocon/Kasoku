package com.example.hiu.kasoku;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

//Javaのswingで言えばJFrameのような物
public class MainActivity extends Activity implements SensorEventListener
{
    private MyView myView;//実際に描画を担当するオブジェクト
    private SensorManager mSensorManager;

    /* Activityが始めて生成された時に呼び出される */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
        // センサーマネージャの取得
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 使用するセンサーの設定
        Sensor acceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // センサーを有効にする
        mSensorManager.registerListener(this, acceleration, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // センサーを無効にする
        if (mSensorManager != null) {
            mSensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor s, int i) {
        // 通常は真面目に処理しなくて良いメソッドなので省略。
    }

    @Override
    public void onSensorChanged(SensorEvent se) {
        // TODO Auto-generated method stub
        float x = se.values[0];
        float y = se.values[1];
        float z = se.values[2];
        myView.x = x;
        myView.y = y;
        myView.z = z;
        myView.invalidate();
    }
}
