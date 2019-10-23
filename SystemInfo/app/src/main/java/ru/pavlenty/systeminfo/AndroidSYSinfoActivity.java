package ru.pavlenty.systeminfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AndroidSYSinfoActivity extends AppCompatActivity {

    @Override
    //saveInstanceState объект типа Bundle
    //метод вызывается когда создается активити
    //http://doc.artofweb.ru/doc/%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B_Android
    // Метод onCreate() принимает объект Bundle, содержащий состояние пользовательского интерфейса,
    // сохраненное в последнем вызове обработчика onSaveInstanceState


    public void onCreate(Bundle savedInstanceState) {
        // при реализации метода всегда нужно вызывать метод суперкласса
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_sysinfo);


       // Log.e(TAG, "Найдем TextView элемент...");
       // Log.d(TAG, "DEBAG!!!!!!");
        TextView SYSinfo = (TextView) findViewById(R.id.SYSinfo);
        SYSinfo.setText(ReadSYSinfo());

      //  Log.e(TAG, "Done...");
    }

    private static StringBuffer SYSinfoBuffer;

    private String ReadSYSinfo()
    {
        SYSinfoBuffer = new StringBuffer();

        getProperty("OS", "os.name", SYSinfoBuffer);
        getProperty("Version", "os.version", SYSinfoBuffer);

        getProperty("URL vendor", "java.vendor.url", SYSinfoBuffer);
        getProperty("JAVA version", "java.version", SYSinfoBuffer);


        return SYSinfoBuffer.toString();
    }

    private void getProperty(String desc, String property, StringBuffer tBuffer)
    {
        tBuffer.append(desc);
        tBuffer.append(" : ");
        tBuffer.append(System.getProperty(property));
        tBuffer.append("\n");
    }
}
