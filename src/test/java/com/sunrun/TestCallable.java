package com.sunrun;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sunrun.util.StringUtil;


public class TestCallable {
    public static void main(String[] args) {
        try {
            List<String> l = completionServiceCount2();
            System.out.println("the end state="+l.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

  
    /**
     * 使用completionService收集callable结果
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public static void completionServiceCount() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
        int threadNum = 5;
        for (int i = 0; i < threadNum; i++) {
            completionService.submit(getTask(i));
        }
        int sum = 0;
        int temp = 0;
        for(int i=0;i<threadNum;i++){
            temp = completionService.take().get();
            sum += temp;
            System.out.print(temp + "\t");
        }
        System.out.println("CompletionService all is : " + sum);
        executorService.shutdown();
    }

    public static Callable<Integer> getTask(final int no) {
        final Random rand = new Random();
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int time = rand.nextInt(100)*100;
                System.out.println("thead:"+no+" time is:"+time);
                Thread.sleep(time);
                return no;
            }
        };
        return task;
    }
    
    /**
     * 使用completionService收集callable结果
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public static List<String> completionServiceCount2() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        List<String> list = new ArrayList<String>();
        int threadNum = 5;
        for (int i = 0; i < threadNum; i++) {
            Future<String> s = completionService.submit(getTask2(i));
            System.out.println("s.get():===="+s.get());
            list.add(s.get());
        }
        executorService.shutdown();
        System.out.println(list.toString());
		return list;
    }
    
    public static Callable<String> getTask2(final int no) {
        final Random rand = new Random();
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
            	//这里去调用交换机接口
            	//......
    			String s = rand.nextInt()+"";
    			System.out.println("--------------s="+s);
    			int time = rand.nextInt(100)*100;
    			//Thread.sleep(time);
                System.out.println("thead:"+no+" time is:"+time + " s:"+s);
				return doSomeThing();
            }
        };
        return task;
    }
    
    public static String doSomeThing(){
    	String s = StringUtil.read("D:\\zipText\\host.sql").substring(0,5);
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
    	return s;
    }
    
}