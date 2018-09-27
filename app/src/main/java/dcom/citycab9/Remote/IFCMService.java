package dcom.citycab9.Remote;

import dcom.citycab9.Model.FCMResponse;
import dcom.citycab9.Model.Sender;

public interface IFCMService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:ker=<SERVER KEY>" +

    })

    @POST("fcm/send")
    call<FCMResponse> sendMessage(@Body Sender body);



}
