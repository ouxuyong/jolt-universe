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

        private Object copyProperties(Object source) {
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
        private <T extends Serializable> T clone(T obj) {
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
            String[] sourceSplit;
            if(source.contains(".")){
                sourceSplit = source.split("\\.");
            }else {
                sourceSplit = new String[]{source};
            }
            Object dataSource = data;
            for(int i = 0;i< sourceSplit.length;i++){
                String s = sourceSplit[i];
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
}
