package com.cesar.bitacora;

import android.os.Bundle;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w("FCM", "Error obteniendo token", task.getException());
                        return;
                    }

                    String token = task.getResult();
                    Log.d("FCM_TOKEN", token);
                });
    }
}

