package com.example.messageactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_MESSAGE = 1;

    private Button messageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageButton = findViewById(R.id.button_message);

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MESSAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MESSAGE && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("message")) {
                String receivedMessage = data.getStringExtra("message");

                // A simple toast message:
                //Toast.makeText(getApplicationContext(), receivedMessage, Toast.LENGTH_SHORT).show();

                // A custom toast message:
                // Inflate the custom layout for the toast message
                View toastView = getLayoutInflater().inflate(R.layout.toast_custom, null);

                TextView textView = toastView.findViewById(R.id.text_message);
                textView.setText(receivedMessage);

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(toastView);
                toast.show();
            }
        }
    }
}
