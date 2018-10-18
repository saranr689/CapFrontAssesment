package s.com.capfrontassesment.networkservices;

public interface RetrofitNetworkCallback<E> {
    void success(E s);

    void failure(String s);
}
