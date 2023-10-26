package executors.completablefutures.cacheimplement;

import java.math.BigInteger;

public class Factorizer {
    private final Computable<BigInteger, BigInteger[]> computable = new Computable<BigInteger, BigInteger[]>() {
        @Override
        public BigInteger[] compute(BigInteger arg) throws InterruptedException {
            return new BigInteger[0];
        }
    };
    private final Computable<BigInteger, BigInteger[]> cache = new Memoizer<>(computable);

    public void service(BigInteger request) {
        try {
            cache.compute(request);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
