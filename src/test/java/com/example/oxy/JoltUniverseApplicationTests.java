package com.example.oxy;

import com.example.oxy.model.TestModel;
import com.example.oxy.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles
class JoltUniverseApplicationTests {
    @Autowired
    private TestService testService;


    @Test
    void contextLoads() {
        List<TestModel> testModels = Arrays.asList(new TestModel("测试1", "1"), new TestModel("测试2", "2"), new TestModel("测试3", "3"));
        boolean save = testService.saveTest(testModels);
        System.out.println("执行成功 save ="+ save);
    }

    @Test
    void test(){
        System.out.println(getHw(123));

    }


    boolean getHw(int num){
        String string = Integer.toString(num);
        int left = 0;
        int right = string.length()-1;
        while (left < right){
            if(string.charAt(left) != string.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }










    int getNum(int num) {
        int temp = num;
        int sign = 10;
        List<Integer> list = new ArrayList<>();
        while (temp != 0) {
            int i = temp % sign;
            list.add(i);
            temp = temp / sign;
        }
        Double sum = 0.0;
        double pow;
        for (int i = 0; i < list.size(); i++) {
            int index = list.size() - 1 - i;
            pow = Math.pow(10, index);
            sum += list.get(i) * pow;
        }
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
           return 0;
        }
        return sum.intValue();
    }















    @Test
    public void test4(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.search(4));


    }


    @Test
    public void test5(){
        List<String> list = Arrays.asList("2950803380293888",
                "2950804302713088",
                "2950813742829824",
                "2950820559966464",
                "2950827601203712",
                "2950840536142336",
                "2950914214121984",
                "2950944451777024",
                "2950984961921536",
                "2951061128630784");
        for(String str :list){
            getCurl(str);
        }
    }
    public void getCurl(String dataId){
        String str = "curl --location --request POST 'http://10.128.87.47:8080/api/data/custom/pull' \\\n" +
                "--header 'X-COMPANY-ID: 530' \\\n" +
                "--header 'companyId: 530' \\\n" +
                "--header 'appkey: uretail_32f2e1' \\\n" +
                "--header 'secret: ffabe451c3a8c28bdcad6812e5420b63e31a0de0' \\\n" +
                "--header 'Content-Type: application/json' \\\n" +
                "--data '{\n" +
                "    \"biz_id\": \"hb_hrlocalbill\",\n" +
                "    \"operate\": \"UPDATE\",\n" +
                "    \"third_user_id\": 2094535510168064,\n" +
                "    \"biz_params\": {\n" +
                "\t\t\t\"data_id\": %s" +
                "\t\t},\n" +
                "    \"request_way\": \"sync\"\n" +
                "}'";
        System.out.println(String.format(str,dataId));
    }










}
