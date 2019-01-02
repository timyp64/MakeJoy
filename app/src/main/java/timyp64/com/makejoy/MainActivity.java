package timyp64.com.makejoy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // прячим лейаут с информационными кнопками
        if (getSharedPreferences("UserSettings", MODE_PRIVATE).getString("HIDDEN_START", "").equals("hidden")) {  // проверяем что у нас сохранено в настройках, сравниваем текст UserSettings - `это название файла с настройками
            findViewById(R.id.linearLayoutTargetApp).setVisibility(View.GONE);     // прячим целый лейаут
        }
    }

    // скрываем лейаут с информационными кнопками и записываем нажатие пользователя на кнопку "Ок, раззобрался!" в настройки андроида
    public void onClick(View view) {
        findViewById(R.id.linearLayoutTargetApp).setVisibility(View.GONE);
        getSharedPreferences("UserSettings", MODE_PRIVATE).edit().putString("HIDDEN_START", "hidden").apply();    // записываем настройкки, UserSettings - это название файла с настройками
    }
}

