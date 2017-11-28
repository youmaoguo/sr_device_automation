package com.sunrun;

import com.sunrun.entity.DevIpSegmentDistributionBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MY {

	public static void main(String[] args)   {
        MY my=new MY();

        try{
            Class<?> demo1=null;
            demo1=Class.forName("com.sunrun.entity.DevIpSegmentDistributionBean");

            my.getFiledName(demo1.newInstance());
        }catch (Exception e){
            e.printStackTrace();
        }




}

    /**
     * 获取属性名数组
     * */
    private void  getFiledName(Object o){


        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        List list = new ArrayList();
        Map infoMap=null;
        for(int i=0;i<fields.length;i++){
            infoMap = new HashMap();
            infoMap.put("type", fields[i].getType().toString());
            infoMap.put("name", fields[i].getName());
            System.out.println(fields[i].getName());
            list.add(infoMap);
        }

    }


    public DevIpSegmentDistributionBean parBean(String selectColumnName,String value){
        DevIpSegmentDistributionBean per=null;
        try {
          String[] selectColumnNameString=  selectColumnName.split(",");
          if(selectColumnNameString!=null && selectColumnNameString.length>0){
              Class<?> demo1=null;
              demo1=Class.forName("com.sunrun.entity.DevIpSegmentDistributionBean");

              //创建实例
              Object devIpSegmentDistributionBean = demo1.newInstance();

              for(String cloum:selectColumnNameString){
                  //获得id 属性
                  Field a = demo1.getDeclaredField( cloum) ;

                  //给id 属性赋值
                  a.set(  devIpSegmentDistributionBean , value) ;
              }




              per=(DevIpSegmentDistributionBean)devIpSegmentDistributionBean;


          }

        } catch (Exception e) {
            e.printStackTrace();
        }

	    return  per ;

}

}
