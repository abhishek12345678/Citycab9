package dcom.citycab9;

import android.media.session.MediaSession;
import android.view.View;
import android.widget.Toast;

import javax.security.auth.callback.Callback;

import dcom.citycab9.Common.Common;
import dcom.citycab9.Model.FCMResponse;
import dcom.citycab9.Model.Sender;
import dcom.citycab9.Remote.IFCMService;

public class Home {

    IFCMService mService;
    mService = common.getFCMService();
    updateFirebaseToken();

    public  void  onClick(View)
    {
         if(!isDriverFound)
         {
             requestPickupHere(FirebaseAuth.getInstance().getCurrentUser().getUid());
         }
         else
         {
             sendRequestToDriver(driverId);
         }
    }

    private  void sendRequestToDriver(String driverId)
    {
        DatabaseReference tokens=FirebaseDatabase.getInstance().getReference(Common.token_th1);
        tokens.orderByKey().equalTo(driverId);
        .addListenerForSingleValueEvent(new ValueEventListener())
        {
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
                {
                    Token token=postSnapshot.getValue(Token.class);

                    String json_lat_lng = new Gson.toJSon(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()))
                    Data data=new Data("check",json_lat_lng);
                    Sender content = new Sender(data.token.getToken());

                    mService.sendMessage(sender)
                            .enqueue(new Callback<FCMResponse>())
                    {
                        public void onResponse(Call<FCMResponse> call,Response<FCMResponse> onResponse)
                        {
                            if(response.body(),success == 1)
                            Toast.makeText(Home.this,"Request send",Toast.LENGTH_LONG).show();
                            else
                            Toast.makeText(Home.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                        void onFailure(Call<FCMResponse> call,Throwable t)
                        {
                            Log.e("ERROR",t.getMessage());
                        }
                    }
                }
            }
        }

        private void updateFirebaseToken()
        {
            FirebaseDatabase db=FirebaseDatabase.getInstance();
            DatabaseReference tokens=db.getReference(Common.token_th1);

            Token token=new Token(FilebaseInstanceId.getInstance().getToken());
            token.child(FirebaseAuth.getInstance().getCurrentUser().getId())
                    .setValue(token);



        }
    }
}
