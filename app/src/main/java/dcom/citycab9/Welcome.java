package dcom.citycab9;

import java.io.FileReader;

import dcom.citycab9.Common.Common;

public class Welcome {

    updateFirebaseToken();



}

    private void updateFirebaseToken()
    {
         FirebaseDatabase db=FirebaseDatabase.getInstance();
            DatabaseReference tokens=db.getReference(Common.token_th1);

            Token token=new Token(FilebaseInstanceId.getInstance().getToken());
            token.child(FirebaseAuth.getInstance().getCurrentUser().getId())
                        .setValue(token);



            }
