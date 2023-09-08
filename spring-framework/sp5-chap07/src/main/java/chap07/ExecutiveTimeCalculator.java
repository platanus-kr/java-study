package chap07;

public class ExecutiveTimeCalculator implements Calculator {

    private Calculator delegate;

    public ExecutiveTimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(long num) {
        long start = System.nanoTime();
        long result = delegate.factorial(num);
        long end = System.nanoTime();
        System.out.printf("%s.factorial(%d) runtime = %d\n",
            delegate.getClass().getSimpleName(),
            num,
            (end - start));
        return result;
    }

}
