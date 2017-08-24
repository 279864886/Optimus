package op.com.a804.chenwenhao.optimusprime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import app.Optimus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(Optimus.getApplication(),"Hello World!",Toast.LENGTH_LONG).show();
    }
}