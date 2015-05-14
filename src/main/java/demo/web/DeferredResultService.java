package demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by geek on 2015/5/14.
 */
public class DeferredResultService implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(DeferredResultService.class);

    private final BlockingQueue<DeferredResult<Message>> resultQuene = new LinkedBlockingDeque<>();

    @Autowired
    private LinkedBlockingDeque<Message> queue;

    private Thread thread;

//    private MatchReporter matchReporter;

    private volatile boolean start = true;

    public void subscribe(){

//        matchReporter.start();
        startThread();
    }

    private void startThread(){
        if(start){
            synchronized (this){
                if(start){
                    start = false;
                    thread = new Thread(this,"Sut Tel");
                    thread.start();
                }
            }
        }
    }

    @Override
    public void run() {
        while (true){
            DeferredResult<Message> result = null;
            try {
                result = resultQuene.take();
                Message message = queue.take();
                result.setResult(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getUpdate(DeferredResult<Message> result){
        resultQuene.add(result);
    }
}
