package com.sunrun.task;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;


public class KvmInfo {
	
	private static final Logger logger = LoggerFactory.getLogger(KvmInfo.class);
	
	 public static void main(String[] args) {
        try {
            List<String> list = completionServiceCount(5, "",null,"","");
            System.out.println(list.toString());
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
	    public static List<String> completionServiceCount(int number, String url, JSONObject param, String method, String auth) throws InterruptedException, ExecutionException {
	        ExecutorService executorService = Executors.newCachedThreadPool();
	        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
	        List<String> list = new ArrayList<String>();
	        for (int i = 0; i < number; i++) {
	            Future<String> s = completionService.submit(getTask(url, param, method, auth));
	            list.add(s.get());
	        }
	        executorService.shutdown();
	        return list;
	    }
	    
	    public static Callable<String> getTask(String url, JSONObject param, String method, String auth) {
	        final Random rand = new Random();
	        Callable<String> task = new Callable<String>() {
	            @Override
	            public String call() throws Exception {
	            	//这里去调用交换机接口
	            	//......
	    			String s = rand.nextInt()+"";
	    			logger.info("s="+s);
					return s;
	            }
	        };
	        return task;
	    }
	

}
