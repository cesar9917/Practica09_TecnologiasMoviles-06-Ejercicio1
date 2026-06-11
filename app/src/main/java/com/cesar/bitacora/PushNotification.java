package com.cesar.bitacora;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import androidx.annotation.NonNull;
import android.util.Log;

public class PushNotification extends FirebaseMessagingService {

    private static final String TAG = "PushNotification";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "Mensaje recibido");

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Titulo: "
                    + remoteMessage.getNotification().getTitle());

            Log.d(TAG, "Cuerpo: "
                    + remoteMessage.getNotification().getBody());
        }
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d(TAG, "Nuevo token: " + token);
    }
}