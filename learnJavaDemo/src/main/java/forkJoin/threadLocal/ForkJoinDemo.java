package forkJoin.threadLocal;

import com.google.common.collect.ImmutableList;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinDemo {
   private static ImmutableList<String> TES_LIST = ImmutableList.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
   private static ThreadLocal<ThreadDemoFork> threadLocal=new ThreadLocal<>();
    private static InheritableThreadLocal<ThreadDemoFork> threadLocalWithInheritable=new InheritableThreadLocal<>();
static {
    threadLocalWithInheritable.set(ThreadDemoFork.builder().msg("InheritableThreadLocal 父线程").build());
    threadLocal.set(ThreadDemoFork.builder().msg("threadLocal 父线程").build());
}
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        threadLocalWithInheritable.set(ThreadDemoFork.builder().msg("子线程").build());
        threadLocal.set(ThreadDemoFork.builder().msg("子线程").build());
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        ForkJoinPool.ForkJoinWorkerThreadFactory factory = forkJoinPool.getFactory();
        ForkJoinTask<?> submit = forkJoinPool.submit(() -> {
            TES_LIST.parallelStream().forEach(num -> {
//                System.out.println(num + "ThreadLocal 线程" + threadLocal.get());
                System.out.println(num + "InheritableThreadLocal 线程1" + threadLocalWithInheritable.get());
            });
        });
        threadLocalWithInheritable.set(ThreadDemoFork.builder().msg("子线程2").build());
        ForkJoinTask<?> submit2 = forkJoinPool.submit(() -> {
            TES_LIST.parallelStream().forEach(num -> {
//                System.out.println(num + "ThreadLocal 线程" + threadLocal.get());
                System.out.println(num + "InheritableThreadLocal 线程2" + threadLocalWithInheritable.get());
            });
        });
        threadLocalWithInheritable.set(ThreadDemoFork.builder().msg("子线程3").build());
        ForkJoinTask<?> submit3 = forkJoinPool.submit(() -> {
            TES_LIST.parallelStream().forEach(num -> {
//                System.out.println(num + "ThreadLocal 线程" + threadLocal.get());
                System.out.println(num + "InheritableThreadLocal 线程3" + threadLocalWithInheritable.get());
            });
        });
        threadLocalWithInheritable.set(ThreadDemoFork.builder().msg("子线程4").build());
        ForkJoinTask<?> submit4 = forkJoinPool.submit(() -> {
            TES_LIST.parallelStream().forEach(num -> {
//                System.out.println(num + "ThreadLocal 线程" + threadLocal.get());
                System.out.println(num + "InheritableThreadLocal 线程4" + threadLocalWithInheritable.get());
            });
        });
        Object o = submit.get();
        Object o1 = submit2.get();
        Object o2 = submit3.get();
        Object o3 = submit4.get();

    }
}
