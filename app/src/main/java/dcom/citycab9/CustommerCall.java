package dcom.citycab9;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dcom.citycab9.Common.Common;
import dcom.citycab9.R;
import dcom.citycab9.Remote.IFCMService;


public class CustommerCall extends AppCompatActivity {

    TextView txtTime,txtAddress,txtDistance;
    MediaPlayer mediaPlayer;
    IGoogleApi   mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custommer_call);

        mService = Common.getGoogleAPI();
        txtTime = findViewById(R.id.txtTime);
        txtAddress = findViewById(R.id.txtAddress);
        txtDistance = findViewById(R.id.txtDistance);

        mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        if(getIntent() != null)
        {
            double lat= getIntent().getDoubleExtra("lat",);
            double lng= getIntent().getDoubleExtra("lng",);
            getDirection();

        }
    }

    private void  getDirection()

    {
        String requestApi = null;
        try{
            requestApi=;
            Log.d("eddec",requestApi);
            mService.getPath(requestApi)
                    .enqueue(new callback<String>(){
                        public void onResponce(call<String> call,Response<String> response)
                        {

                        }
                    }
        }catch ()

        {}

        try{
            JSONObject jsonObject = new JSONObject(response.body().toString());
            JSONArray routes = jsonObject.getJSONArray("routes");

            //just get the first element of routes

            JSONObject object=routes.getJSONObject(0);

            JSONArray legs=object.getJSONArray("legs");

            JSONObject legsObject = legs.getJSONObject(0);

            JSONObject distance = legsObject.getJSONObject("distance");

            txtDistance.setText(distance.getString("text"));

            JSONObject time = legsObject.getJSONObject("duration");
            txtTime.setText(time.getString("text"));


            String address = legsObject.getString("end_address");
            txtAddress.setText(address.getString("text"));


        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        public void onFailure(Call<String> call,Throwable  t)
        {
            Toast.makeText(CustommerCall.this,""+t.getMessage(),Toast.LENGTH_LONG).show();
        }



}


    @Override
    protected void onStop() {
        mediaPlayer.release();
        super.onStop();
    }

    @Override
    protected void onPause() {
        mediaPlayer.release();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mediaPlayer.start();
        super.onResume();
    }
}


