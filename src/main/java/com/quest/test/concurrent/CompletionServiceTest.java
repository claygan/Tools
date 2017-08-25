package com.quest.test.concurrent;

import com.quest.test.concurrent.pojos.MyCompletionService;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Quest on 2017/8/25.
 */
public class CompletionServiceTest {
    @Test
    public void test() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<String> completion = new ExecutorCompletionService<String>(service);
        for (int i = 0; i < 10; i++) {
            completion.submit(new MyCompletionService(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(completion.take().get());
        }
        service.shutdown();
    }
}
