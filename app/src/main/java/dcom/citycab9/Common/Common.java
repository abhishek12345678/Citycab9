package dcom.citycab9.Common;

import android.location.Location;

import dcom.citycab9.Remote.FCMClient;
import dcom.citycab9.Remote.IFCMService;
import dcom.citycab9.Remote.RetrofitClient;

public class Common {

    public static String currentToken = "";

    public  static final String driver_th1 = "Drivers";
    public  static final String user_driver_th1 = "DriversInformation";
    public  static final String user_rider_th1 = "RidersInformation";
    public  static final String pickup_request_th1= "PickupRequest";
    public  static final String token_th1= "Tokens";

    public static Location mLastLocation= null;

    public static final String baseURL=;
    public static final String fcmURL=;


    public static IGoogleAPI getGoogleAPI()
    {

        return  RetrofitClient.getClient(baseURL).create(IGoogleAPI.class);

    }

    public static IFCMService getFCMService()
    {
        return FCMClient.getClient(fcmURL).create(IFCMService.class);

    }
}
