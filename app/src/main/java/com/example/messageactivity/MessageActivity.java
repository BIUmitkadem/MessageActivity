package com.example.messageactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {
    private TextView receivedMessageTextView;
    private EditText messageEditText;
    private Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        receivedMessageTextView = findViewById(R.id.text_received_message);
        messageEditText = findViewById(R.id.edit_message);
        sendMessageButton = findViewById(R.id.button_send_message);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();

                // Create an intent to return the message to MainActivity
                Intent intent = new Intent();
                intent.putExtra("message", message);
                setResult(RESULT_OK, intent);

                finish(); // Close the MessageActivity
            }
        });

        // Check if MainActivity has sent a message
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("message")) {
            String receivedMessage = extras.getString("message");
            receivedMessageTextView.setText(receivedMessage);
        }
    }
}