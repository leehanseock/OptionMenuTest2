package kr.ac.kopo.optionmenutest2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    ImageView imgv;
    EditText editAngle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linear), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linear = findViewById(R.id.linear);
        imgv = findViewById(R.id.imgv);
        editAngle = findViewById(R.id.edit_angle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        item.setChecked(true);
        if (item.getItemId() == R.id.item_rotation){
            int angle = Integer.parseInt(editAngle.getText().toString());
            imgv.setRotation(angle);
            return true;
        } else if (item.getItemId() == R.id.simple){
            imgv.setImageResource(R.drawable.simple3);
            return true;
        } else if (item.getItemId() == R.id.realistic){
            imgv.setImageResource(R.drawable.realistic);
            return true;
        } else if (item.getItemId() == R.id.artNouveau){
            imgv.setImageResource(R.drawable.artnubo2);
            return true;
        }
        return false;
    }
}