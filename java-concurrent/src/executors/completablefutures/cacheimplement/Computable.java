package executors.completablefutures.cacheimplement;


// p164
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
