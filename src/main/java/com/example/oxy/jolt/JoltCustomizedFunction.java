package com.example.oxy.jolt;

import com.bazaarvoice.jolt.common.Optional;
import com.bazaarvoice.jolt.modifier.function.Function;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author oxy
 * @date 2022/05/28
 */
public class JoltCustomizedFunction {
    public static class RecursiveReplacementFunc extends Function.ListFunction {
        private static final Integer ARG_LIST_SIZE = 3;

        @Override
        protected Optional<Object> applyList(List<Object> list) {
            if(CollectionUtils.isEmpty(list) || list.size() !=  ARG_LIST_SIZE){
                return Optional.empty();
            }
            if(!(list.get(0) instanceof Map) && !(list.get(0) instanceof List)){
                return Optional.empty();
            }
            if(!(list.get(1) instanceof String) || !(list.get(2) instanceof String)){
                return Optional.empty();
            }
            if(list.get(0) == null || StringUtils.isEmpty(list.get(1)) || StringUtils.isEmpty(list.get(2))){
                return Optional.empty();
            }
              Object data = copyProperties(list.get(0));
            return Optional.of(recursiveReplacement(data, (String) list.get(1), (String) list.get(2)));
        }


    }
    private static Object copyProperties(Object source) {
        if(source instanceof List){

            return clone(new ArrayList((List)source));
        }
        if(source instanceof Map){
            HashMap map = new HashMap();
            map.putAll((Map) source);
            return clone(map);
        }
        return null;
    }
    private static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            ByteOutputStream bos = new ByteOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }

    /**
     *
     * @param data
     * @param source
     * @param target
     * @return
     */
    private static Object recursiveReplacement(Object data,String source,String target){
        if(data == null){
            return null;
        }
        if(data instanceof Map){
            String[] sourceSplit = getSourceSplit(source);
            Object dataSource = data;
            for(int i = 0;i< sourceSplit.length;i++){
                String s = sourceSplit[i];
                if(dataSource instanceof List){
                    for(Object obj : (List)dataSource){
                        recursiveReplacement(obj,s,target);
                    }
                    return dataSource;
                }
                if(!((Map)dataSource).containsKey(s)){
                    return data;
                }

                if(i == (sourceSplit.length - 1)){
                    Object targetObj = recursiveReplacement(((Map)dataSource).get(s),source,target);
                    ((Map)dataSource).put(target,targetObj);
                    ((Map)dataSource).remove(s);
                    break;
                }
                dataSource = ((Map)dataSource).get(s);
            }
        }else if(data instanceof List){
            for(Object obj : (List)data){
                recursiveReplacement(obj,source,target);
            }
        }
        return data;
    }

    private static String[] getSourceSplit(String source) {
        String[] sourceSplit;
        if (source.contains(".")) {
            sourceSplit = source.split("\\.");
        } else {
            sourceSplit = new String[]{source};
        }
        return sourceSplit;
    }

    public static class RecursiveOperationFunc extends Function.ListFunction{
//        "=recursiveOperation(@1,'Children','Name->FirstName',=concat('Hobbies.name->Hobbies'))"
        private static final Integer ARG_LIST_SIZE = 3;
        private static final Integer KEY_SPLIT_SIZE = 2;
        private static final String CONCAT_KEY = "concat";
        @Override
        protected Optional<Object> applyList(List<Object> list) {
            if(CollectionUtils.isEmpty(list) || list.size() <  ARG_LIST_SIZE){
                return Optional.empty();
            }
            if(!(list.get(0) instanceof Map) && !(list.get(0) instanceof List)){
                return Optional.empty();
            }
            if(!(list.get(1) instanceof String) ){
                return Optional.empty();
            }
            Object data = copyProperties(list.get(0));
            String recursiveKey = (String) list.get(1);

            List<Object> newList = list.subList(2, list.size());

            for(Object obj : newList){
                if(!(obj instanceof String)){
                    return Optional.empty();
                }
            }
            ;
            return Optional.of(recursiveOperation(data,recursiveKey,newList));
        }

        private Object recursiveOperation(Object data, String recursiveKey, List<Object> keyList) {
            if(data instanceof Map){
                Object dataSource =  data;
                for(Object key : keyList){
                    String replaceKey = key.toString().replace(" ", "");
                    String methodName = null;
                    if(replaceKey.startsWith("=")){
                        String[] split = replaceKey.split("\\(");
                        methodName = split[0].substring(1);
                        replaceKey = split[1].substring(0,split[1].length()-1);
                    }
                    String[] split = replaceKey.split("->");
                    if(split == null  || split.length != KEY_SPLIT_SIZE){
                        return null;
                    }
                    recursiveReplacement(dataSource,split[0],split[1]);
                    if(methodName != null){
                        callMethod(dataSource,split,methodName);
                    }
                }
                if(!CollectionUtils.isEmpty((List)((Map)dataSource).get(recursiveKey))){
                    recursiveOperation(((Map)dataSource).get(recursiveKey),recursiveKey,keyList);
                }
            }else if(data instanceof List){
                for(Object obj : (List)data){
                    recursiveOperation(obj,recursiveKey,keyList);
                }
            }
            return data;
        }

        private void callMethod(Object dataSource, String[] split, String methodName) {
            if(CONCAT_KEY.equals(methodName)){
                if(dataSource instanceof Map){
                    String[] sourceSplit = getSourceSplit(split[0]);
                    sourceSplit[sourceSplit.length-1] = split[1];
                    List<String> list = new ArrayList<>();
                    Object o = dataSource;
                   a: for(int i = 0; i< sourceSplit.length;i++) {
                        if(o instanceof List){
                            Object o2;
                            b:for(Object o1 : (List)o){
                                 o2 = ((Map) o1).get(sourceSplit[i]);
                                 if(o2 == null){
                                     break b;
                                 }
                                if(i == sourceSplit.length-1){
                                    list.add(o2.toString());
                                }
                            }
                        }else {
                            o = ((Map) o).get(sourceSplit[i]);
                            if(o == null){
                                break a;
                            }
                            if(i == sourceSplit.length-1){
                                list.add(o.toString());
                            }
                        }

                    }

                    StringBuffer stringBuffer = new StringBuffer();
                    for(int i = 0;i< list.size();i++){
                        stringBuffer.append(list.get(i));
                        if(i != list.size()-1){
                            stringBuffer.append(",");
                        }
                    }
                    ((Map) dataSource).put(split[1],stringBuffer.toString());
                    if(!split[1].equals(sourceSplit[0])){
                        ((Map) dataSource).remove(sourceSplit[0]);
                    }
                }else if(dataSource instanceof List){
                    for(Object obj : (List)dataSource){
                        callMethod(obj,split,methodName);
                    }
                }
            }
        }
    }
}
