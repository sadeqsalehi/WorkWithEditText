package ir.sadeqsalehi.workwithedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    EditText txtName;
    Button btnSayHello;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtName = findViewById(R.id.txtName);
        tvName = findViewById(R.id.tvName);
        btnSayHello = findViewById(R.id.btnSayHello);
        txtName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    tvName.setText("Got Focus");
                else
                    tvName.setText("Lost Focus");
            }
        });
        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //  tvName.setText(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String result = String.format(Locale.ENGLISH, "start = %d , before = %d , count = %d", start, before, count);

                tvName.setText(result);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //   tvName.setText(s);
            }
        });
    }

    public void sayHelloOnClick(View view) {
        String result = "Hello " + txtName.getText().toString().trim();
        tvName.setText(result);
    }

}
