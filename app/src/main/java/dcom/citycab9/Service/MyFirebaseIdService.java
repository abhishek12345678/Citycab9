package dcom.citycab9.Service;

import android.media.session.MediaSession;

import dcom.citycab9.Common.Common;
import dcom.citycab9.Model.Token;

public class MyFirebaseIdService  extends  FirebaseInstanceIdService{


    public void onTokenRefresh()
    {
        super.onTokenRefresh();
        String refreshedToken =FirebaseInstanceId.getInstance().getToken();
       // Common.currentToken = refreshedToken; //

        updateTokenToServer(refreshedToken);

    }


    public void  updateTokenToServer(String refreshedToken)
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference(Common.token_th1);


        Token  token = new Token(refreshedToken);
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            tokens.child(FirebaseAuth.getInstance().getCurrentUser.getUid())
                    .setValue(token);
        }



    }



}
