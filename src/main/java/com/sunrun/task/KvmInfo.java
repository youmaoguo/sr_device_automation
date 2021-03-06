package com.sunrun.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.util.RestfulRequestUtil;

@Component
public class KvmInfo {
	
	private static final Logger logger = LoggerFactory.getLogger(KvmInfo.class);
	
	public static void main(String[] args) {
		
	}
	
	 /**
	     * 使用completionService收集callable结果
	     * @throws ExecutionException 
	     * @throws InterruptedException 
	     */
	    public static List<String> completionServiceCount(List<String> ports, String models, String url, String method, String auth, String brandName) throws InterruptedException, ExecutionException {
	        ExecutorService executorService = Executors.newCachedThreadPool();
	        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
	        List<String> list = new ArrayList<String>();
	        for (int i = 0; i < ports.size(); i++) {
	        	JSONObject param = new JSONObject();
				param.put("method_name", "/interchanger/v1/checkModel");
				param.put("port", ports.get(i));
				param.put("type", models);
				param.put("deviceBrand", brandName);
	            /*Future<String> s = */completionService.submit(getTask(i, url, param, method, auth));
	            //list.add(s.get());
	        }
	        for(int i=0;i<ports.size();i++){
	        	String s = completionService.take().get();
	        	list.add(s);
	        }
	        executorService.shutdown();
	        return list;
	    }
	    
	    public static Callable<String> getTask(final int i, final String url, final JSONObject param, final String method, final String auth) {
	        Callable<String> task = new Callable<String>() {
	            @Override
	            public String call() throws Exception {
	            	//这里去调用交换机接口
	            	String s = RestfulRequestUtil.getResponse(url, param, method, auth);
	    			logger.info("thead:"+i+" time is:"+new Date() + " s:"+s);
					return s;
	            }
	        };
	        return task;
	    }
	

}
