package dcom.citycab9.Service;

import android.content.Intent;

import dcom.citycab9.CustommerCall;

public class MyFirebaseMessaging extends FirebaseMessagingService {

    public void  OnMessaging(RemoteMessage remoteMessage)
    {
        super.OnMessaging(remoteMessage);

        LatLng customer_location = new Gson().fromJson(remoteMessage.getNotification().getBody(),LatLng.class);

        Intent intent= new Intent(getBaseContext(), CustommerCall.class);
        intent.putExtra("lag",customer_location.latitude);
        intent.putExtra("lng",customer_location.longitude);

        startActivity(intent);
    }

}
