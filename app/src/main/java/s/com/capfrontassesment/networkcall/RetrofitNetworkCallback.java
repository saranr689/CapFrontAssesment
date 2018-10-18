package s.com.capfrontassesment.networkcall;

public interface RetrofitNetworkCallback<E> {
    void success(E s);

    void failure(String s);
}
