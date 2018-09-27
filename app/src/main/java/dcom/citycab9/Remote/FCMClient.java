package dcom.citycab9.Remote;

public class FCMClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseURL)
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConvertorFactory(Gson.create());
                     .build();


        }

        return retrofit;
    }
}
