package com.example.oxy.shift;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShiftTest {

    /**
     * 测试demo
     */
    @Test
    public void testDemo() {

        Object input = JsonUtils.classpathToObject("/json/sample/input.json");
        List spec = JsonUtils.classpathToList("/json/sample/spec.json");
        Chainr chainr = Chainr.fromSpec(spec);
        Object transform = chainr.transform(input);
        System.out.println(JsonUtils.toJsonString(transform));
    }















    @Test
    public void testDemo2() {

        Object input = JsonUtils.jsonToObject("{\n" +
                "  \"productClass_name\": \"假体隆鼻\",\n" +
                "  \"hritemdetail\": [\n" +
                "    {\n" +
                "      \"brepair\": \"false\",\n" +
                "      \"bSpecial\": \"false\",\n" +
                "      \"fPromotionDiscount\": \"0.0\",\n" +
                "      \"fMoney\": \"200.0\",\n" +
                "      \"product_cCode\": \"xnczk01\",\n" +
                "      \"fDiscountRate\": \"100.0\",\n" +
                "      \"fRechargeMoney\": \"200.0\",\n" +
                "      \"fQuoteMoney\": \"200.0\",\n" +
                "      \"dealPrice\": \"200.0\",\n" +
                "      \"product_productClass\": \"1935707598950656\",\n" +
                "      \"fSceneDiscountRate\": \"100.0\",\n" +
                "      \"btransform\": \"false\",\n" +
                "      \"bdevelop\": \"false\",\n" +
                "      \"product_cName\": \"虚拟储值卡\",\n" +
                "      \"fQuantity\": \"1.0\",\n" +
                "      \"isBatchManage\": \"false\",\n" +
                "      \"isExpiryDateManage\": \"false\",\n" +
                "      \"id\": \"2906774260027649\",\n" +
                "      \"pubts\": \"2022-08-1610:03:41\",\n" +
                "      \"hrstoreemployeedetail\": [\n" +
                "        {\n" +
                "          \"positionName\": \"测试-咨询人员\",\n" +
                "          \"storeemployee\": \"1648782097240320\",\n" +
                "          \"storeemployee_name\": \"咨询B组组员1\",\n" +
                "          \"id\": \"2906774260027650\",\n" +
                "          \"position\": \"1651541112934656\",\n" +
                "          \"positionauth\": \"1\",\n" +
                "          \"fShareScale\": \"100.0\",\n" +
                "          \"pubts\": \"2022-08-1610:03:41\",\n" +
                "          \"itemdetail\": \"2906774260027649\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"fSceneDiscount\": \"0.0\",\n" +
                "      \"fDiscount\": \"0.0\",\n" +
                "      \"product_productClass_path\": \"|1651629994643712|1935707360399616|1935707598950656|\",\n" +
                "      \"product\": \"1651630831161600\",\n" +
                "      \"ilocalbill\": \"2906774260027648\",\n" +
                "      \"cRechargeActivityId\": \"\",\n" +
                "      \"fPrice\": \"200.0\",\n" +
                "      \"fVIPDiscount\": \"0.0\",\n" +
                "      \"productclass2\": \"其他（储值）\",\n" +
                "      \"productclass1\": \"其他（储值）\",\n" +
                "      \"productclass3\": \"其他储值\",\n" +
                "      \"iPromotionProduct\": \"0\",\n" +
                "      \"productsku\": \"1651630833340672\",\n" +
                "      \"productsku_cCode\": \"xnczk01\",\n" +
                "      \"walletAccount\": \"8225\",\n" +
                "      \"fVIPRate\": \"100.0\",\n" +
                "      \"bshare\": \"true\",\n" +
                "      \"fQuotePrice\": \"200.0\",\n" +
                "      \"remarks\": \"\",\n" +
                "      \"bwhechase\": \"false\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"brepair\": \"false\",\n" +
                "      \"bSpecial\": \"false\",\n" +
                "      \"fPromotionDiscount\": \"0.0\",\n" +
                "      \"fMoney\": \"12800.0\",\n" +
                "      \"product_cCode\": \"xnczk01\",\n" +
                "      \"fDiscountRate\": \"100.0\",\n" +
                "      \"fRechargeMoney\": \"12800.0\",\n" +
                "      \"fQuoteMoney\": \"12800.0\",\n" +
                "      \"product_productClass\": \"1935707598950656\",\n" +
                "      \"fSceneDiscountRate\": \"100.0\",\n" +
                "      \"btransform\": \"false\",\n" +
                "      \"bdevelop\": \"false\",\n" +
                "      \"product_cName\": \"虚拟储值卡\",\n" +
                "      \"fQuantity\": \"1.0\",\n" +
                "      \"isBatchManage\": \"false\",\n" +
                "      \"isExpiryDateManage\": \"false\",\n" +
                "      \"id\": \"2906774260027651\",\n" +
                "      \"pubts\": \"2022-08-1610:03:41\",\n" +
                "      \"hrstoreemployeedetail\": [\n" +
                "        {\n" +
                "          \"positionName\": \"测试-咨询人员\",\n" +
                "          \"storeemployee\": \"1648782097240320\",\n" +
                "          \"storeemployee_name\": \"咨询B组组员1\",\n" +
                "          \"id\": \"2906774260027652\",\n" +
                "          \"position\": \"1651541112934656\",\n" +
                "          \"positionauth\": \"1\",\n" +
                "          \"fShareScale\": \"100.0\",\n" +
                "          \"pubts\": \"2022-08-1610:03:41\",\n" +
                "          \"itemdetail\": \"2906774260027651\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"fSceneDiscount\": \"0.0\",\n" +
                "      \"fDiscount\": \"0.0\",\n" +
                "      \"product_productClass_path\": \"|1651629994643712|1935707360399616|1935707598950656|\",\n" +
                "      \"product\": \"1651630831161600\",\n" +
                "      \"ilocalbill\": \"2906774260027648\",\n" +
                "      \"cRechargeActivityId\": \"792\",\n" +
                "      \"fPrice\": \"12800.0\",\n" +
                "      \"fVIPDiscount\": \"0.0\",\n" +
                "      \"productclass2\": \"其他（储值）\",\n" +
                "      \"productclass1\": \"其他（储值）\",\n" +
                "      \"productclass3\": \"其他储值\",\n" +
                "      \"iPromotionProduct\": \"0\",\n" +
                "      \"productsku\": \"1651630833340672\",\n" +
                "      \"productsku_cCode\": \"xnczk01\",\n" +
                "      \"walletAccount\": \"8225\",\n" +
                "      \"fVIPRate\": \"100.0\",\n" +
                "      \"bshare\": \"true\",\n" +
                "      \"fQuotePrice\": \"12800.0\",\n" +
                "      \"remarks\": \"\",\n" +
                "      \"bwhechase\": \"false\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"code\": \"LC00002022081600002\",\n" +
                "  \"iMemberid_cphone\": \"18812345671\",\n" +
                "  \"bdchanneldoc_name\": \"第三方\",\n" +
                "  \"cdesignscheme\": \"992340\",\n" +
                "  \"iMemberid_levelid_cMemberLevelName\": \"3星\",\n" +
                "  \"hrstoreemployee\": [\n" +
                "    {\n" +
                "      \"positionName\": \"测试-咨询人员\",\n" +
                "      \"storeemployee\": \"1648782097240320\",\n" +
                "      \"ilocalbill\": \"2906774260027648\",\n" +
                "      \"storeemployee_name\": \"咨询B组组员1\",\n" +
                "      \"id\": \"2906774260027653\",\n" +
                "      \"position\": \"1651541112934656\",\n" +
                "      \"positionauth\": \"1\",\n" +
                "      \"fShareScale\": \"100.0\",\n" +
                "      \"pubts\": \"2022-08-1610:03:41\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"positionName\": \"测试-咨询人员\",\n" +
                "      \"storeemployee\": \"1648782097240320\",\n" +
                "      \"ilocalbill\": \"2906774260027648\",\n" +
                "      \"storeemployee_name\": \"咨询B组组员1\",\n" +
                "      \"id\": \"2906774260027654\",\n" +
                "      \"position\": \"1651541112934656\",\n" +
                "      \"positionauth\": \"1\",\n" +
                "      \"fShareScale\": \"100.0\",\n" +
                "      \"pubts\": \"2022-08-1610:03:41\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"iMemberid\": \"5886803\",\n" +
                "  \"bdchanneltype\": \"1648634904563968\",\n" +
                "  \"iMemberid_qq\": \"\",\n" +
                "  \"vouchdate\": \"2022-08-1600:00:00\",\n" +
                "  \"itechoffice\": \"1444951322611968\",\n" +
                "  \"billtype\": \"0\",\n" +
                "  \"bdchanneldoc\": \"1648639280222464\",\n" +
                "  \"iMemberid_name\": \"小一\",\n" +
                "  \"store_name\": \"瑞韩医院\",\n" +
                "  \"cSource1\": \"YX\",\n" +
                "  \"hdesignscheme\": \"992340\",\n" +
                "  \"id\": \"2906774260027648\",\n" +
                "  \"pubts\": \"2022-08-1610:05:14\",\n" +
                "  \"org_name\": \"海南瑞韩医学美容医院有限公司\",\n" +
                "  \"bdchanneltype_name\": \"自营\",\n" +
                "  \"iMemberid_wechatno\": \"\",\n" +
                "  \"DevChannel\": \"1648642378453248\",\n" +
                "  \"triageReceiveTreatment\": \"2\",\n" +
                "  \"iMemberid_iPoints\": \"4000\",\n" +
                "  \"imaker\": \"1444471156396288\",\n" +
                "  \"productClass\": \"1648729820451072\",\n" +
                "  \"store_contactPhone\": \"1233211233\",\n" +
                "  \"org\": \"1444950168817920\",\n" +
                "  \"imaker_name\": \"17689802330\",\n" +
                "  \"localbilltype\": \"0\",\n" +
                "  \"store\": \"1444978456629504\",\n" +
                "  \"dealStatus\": \"2\",\n" +
                "  \"dmakedate\": \"2022-08-1610:03:41\",\n" +
                "  \"breact\": \"false\",\n" +
                "  \"iMemberid_cMemberLevelName\": \"3405\",\n" +
                "  \"complaint\": \"992340\",\n" +
                "  \"iMemberid_code\": \"RH128\",\n" +
                "  \"itechoffice_name\": \"微整科\",\n" +
                "  \"DevChannel_name\": \"会所其他\",\n" +
                "  \"receiveTreatment\": \"2\",\n" +
                "  \"consultantlist\": \"咨询B组组员1\",\n" +
                "  \"consultStatus\": \"1\",\n" +
                "  \"status\": \"1\"\n" +
                "}");

        System.out.println("input = " + JsonUtils.toJsonString(input));

        List spec = JsonUtils.jsonToList("[\n" +
                "  {\n" +
                "    \"operation\": \"modify-overwrite-beta\",\n" +
                "    \"spec\": {\n" +
                "      \"id\": \"=toString\",\n" +
                "      \"org\": \"=toString\",\n" +
                "      \"itechoffice\": \"=toString\",\n" +
                "      \"iMemberid\": \"=toString\",\n" +
                "      \"imaker\": \"=toString\",\n" +
                "      \"productClass\": \"=toString\",\n" +
                "      \"store\": \"=toString\",\n" +
                "      \"consultant\": \"=toString\",\n" +
                "      \"dealStatus\": \"=toString\",\n" +
                "      \"receiveTreatment\": \"=toString\",\n" +
                "      \"billtype\": \"=toString\",\n" +
                "      \"DevChannel\": \"=toString\",\n" +
                "      \"bdchanneldoc\": \"=toString\",\n" +
                "      \"hritemdetail\": {\n" +
                "        \"*\": {\n" +
                "          \"id\": \"=toString\",\n" +
                "          \"product_productClass\": \"=toString\",\n" +
                "          \"product\": \"=toString\",\n" +
                "          \"ilocalbill\": \"=toString\",\n" +
                "          \"productsku\": \"=toString\",\n" +
                "          \"hrstoreemployeedetail\": {\n" +
                "            \"*\": {\n" +
                "              \"id\": \"=toString\",\n" +
                "              \"product\": \"=toString\",\n" +
                "              \"storeemployee\": \"=toString\",\n" +
                "              \"itemdetail\": \"=toString\"\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "\t},\n" +
                "  {\n" +
                "    \"operation\": \"modify-define-beta\",\n" +
                "    \"spec\": {\n" +
                "      \"storeid\": \"@(1,store)\",\n" +
                "      \"cphone\": \"@(1,iMemberid_cphone)\",\n" +
                "      \"orgid\": \"@(1,org)\",\n" +
                "      \"mid\": \"@(1,iMemberid)\"\n" +
                "    }\n" +
                "\t},\n" +

                "  {\n" +
                "    \"operation\": \"shift\",\n" +
                "    \"spec\": {\n" +
                "      \"mid\": \"mid\",\n" +
                "      \"cphone\": \"cphone\",\n" +
                "      \"storeid\": \"storeid\",\n" +
                "      \"orgid\": \"orgid\",\n" +
                "      \"pubts\": \"pubts\",\n" +
                "      \"id\": \"data_id\",\n" +
                "      \"bdchanneltype\": \"Field0005\",\n" +
                "      \"localbilltype\": {\n" +
                "        \"0\": {\n" +
                "          \"#咨询单\": \"Field0002.name\",\n" +
                "          \"#0ecffe4e28c176796da0889cdc262c84\": \"Field0002.value\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "          \"#复查单\": \"Field0002.name\",\n" +
                "          \"#6766fdd45901c52b56dc3c0bf8834c84\": \"Field0002.value\"\n" +
                "        },\n" +
                "        \"2\": {\n" +
                "          \"#二次咨询单\": \"Field0002.name\",\n" +
                "          \"#811ca74d4bc311aa71706b063ac85597\": \"Field0002.value\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"status\": {\n" +
                "        \"0\": {\n" +
                "          \"#保存\": \"Field0013__c.name\",\n" +
                "          \"#ad448ba4ab4155ba03c9cdcb3da0390e\": \"Field0013__c.value\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "          \"#提交\": \"Field0013__c.name\",\n" +
                "          \"#62dc0d187f6f70eaccd888bd2802783b\": \"Field0013__c.value\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"store\": \"Field0018\",\n" +
                "      \"iMemberid\": \"Field0016\",\n" +
                "      \"cModReason\": \"Field0014\",\n" +
                "      \"dLastModifyTime\": \"Field0013\",\n" +
                "      \"dmakedate\": \"Field0008\",\n" +
                "      \"productClass\": \"Field0004__c\",\n" +
                "      \"imaker_name\": \"Field0007\",\n" +
                "      \"ilocalbill\": \"ilocalbill__c\",\n" +
                "      \"breact\": {\n" +
                "        \"true\": {\n" +
                "          \"#是\": \"a499472ca410ec48f7733446a764ff1a.name\",\n" +
                "          \"#5078663054e64f2d6818b55249a09b50\": \"a499472ca410ec48f7733446a764ff1a.value\"\n" +
                "        },\n" +
                "        \"false\": {\n" +
                "          \"#否\": \"a499472ca410ec48f7733446a764ff1a.name\",\n" +
                "          \"#c0b51a1642acde7197ffdfa92fd55c04\": \"a499472ca410ec48f7733446a764ff1a.value\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"triageNotes\": \"a7e4aed9eafc4c41eaa2eb1a3106b63d\",\n" +
                "      \"cdesignscheme\": \"ac58e3c0c1e672ca40f4c4e3a5752d3e\",\n" +
                "      \"hdesignscheme\": \"ad20aa35f6be55ad6c3364218a00ab38\",\n" +
                "      \"diagnosis\": \"ab7403a9aa286d50c23cbe2339a6fbe9\",\n" +
                "      \"complaint\": \"a82b89da8410bfa78ed95727594dc1b6\",\n" +
                "      \"beautyhistory\": \"a48af67fc88d6b3b132278cfcc1582b6\",\n" +
                "      \"itechoffice\": \"Field0003__c\",\n" +
                "      \"receiveTreatment\": {\n" +
                "        \"0\": {\n" +
                "          \"#活动初诊\": \"Field0022.name\",\n" +
                "          \"#723aee21130fded27b8f949ac50ef609\": \"Field0022.value\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "          \"#初诊\": \"Field0022.name\",\n" +
                "          \"#18d325456b968d6aa1a9728cb4f272a4\": \"Field0022.value\"\n" +
                "        },\n" +
                "        \"2\": {\n" +
                "          \"#复诊\": \"Field0022.name\",\n" +
                "          \"#53e85a8426452485552e879d43aa6b9f\": \"Field0022.value\"\n" +
                "        },\n" +
                "        \"3\": {\n" +
                "          \"#复查\": \"Field0022.name\",\n" +
                "          \"#9afec35c0a9a4e231c521779786a3e06\": \"Field0022.value\"\n" +
                "        },\n" +
                "        \"4\": {\n" +
                "          \"#再消费\": \"Field0022.name\",\n" +
                "          \"#6cb8a48cbd63f732213873f2ea52d002\": \"Field0022.value\"\n" +
                "        },\n" +
                "        \"5\": {\n" +
                "          \"#其他\": \"Field0022.name\",\n" +
                "          \"#cbd4f6fea2962f29834a536098bbafa0\": \"Field0022.value\"\n" +
                "        },\n" +
                "        \"6\": {\n" +
                "          \"#线上面诊\": \"Field0022.name\",\n" +
                "          \"#493a3bd2d7d99a8b7ee648a27e071822\": \"Field0022.value\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"billtype\": {\n" +
                "        \"0\": {\n" +
                "          \"#咨询单\": \"Field0005__c.name\",\n" +
                "          \"#4f580a3cb48664f8999277b5a7271b40\": \"Field0005__c.value\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "          \"#复查单\": \"Field0005__c.name\",\n" +
                "          \"#16e18967faf5d3c3d898dffe7ddc8c25\": \"Field0005__c.value\"\n" +
                "        },\n" +
                "        \"2\": {\n" +
                "          \"#二次咨询单\": \"Field0005__c.name\",\n" +
                "          \"#f670375a97c25e2221f0206ffca083ce\": \"Field0005__c.value\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"inmoney\": \"a9549e6dc0a43468bdfb4ce9a244c8e2\",\n" +
                "      \"hrLocalbillfailurereasons\": {\n" +
                "        \"*\": {\n" +
                "          \"failurereasons\": \"CustomObject1016__c.[&1].rowData.Field0001__c\",\n" +
                "          \"id\": \"CustomObject1016__c.[&1].rowData.data_id\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"remarks\": \"ad0608d3eac3eca846beb2b3ac064fc9\",\n" +
                "      \"dealStatus\": {\n" +
                "        \"0\": {\n" +
                "          \"#新单\": \"Field0024.name\",\n" +
                "          \"#0793f903f8da5b760ffd266f24d28a0d\": \"Field0024.value\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "          \"#未成交\": \"Field0024.name\",\n" +
                "          \"#2ed4dc29bc959488eec8f53ab050b474\": \"Field0024.value\"\n" +
                "        },\n" +
                "        \"2\": {\n" +
                "          \"#已成交\": \"Field0024.name\",\n" +
                "          \"#084d378829c7fc44754365f348bb6291\": \"Field0024.value\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"consultStatus\": {\n" +
                "        \"0\": {\n" +
                "          \"#待咨询\": \"Field0008__c.name\",\n" +
                "          \"#78c88d06889b6b1bae3784f5842485bc\": \"Field0008__c.value\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "          \"#已咨询\": \"Field0008__c.name\",\n" +
                "          \"#5f9de8fbda6389ce1133cc17fbb5d533\": \"Field0008__c.value\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"DevChannel\": \"a83d39fe01c3b5731c35210b7ca2d4dd\",\n" +
                "      \"bdchanneldoc\": \"c3ecdace9ee63fcb3c06e0403e7b0e73\",\n" +
                "      \"vouchdate\": \"aae97d9282d6e69124d4c7f84e70d2e1\",\n" +
                "      \"code\": \"f2fb4c607e9595baeea98ec49b5977ae\",\n" +
                "      \"hritemdetail\": {\n" +
                "        \"*\": {\n" +
                "          \"id\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.data_id\",\n" +
                "          \"fDiscount\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.Field0010\",\n" +
                "          \"fSceneDiscountRate\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.Field0006\",\n" +
                "          \"fQuoteMoney\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.Field0005\",\n" +
                "          \"fQuotePrice\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.Field0020\",\n" +
                "          \"fMoney\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.Field0008\",\n" +
                "          \"fPrice\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.Field0007\",\n" +
                "          \"dealPrice\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.dealprice__c\",\n" +
                "          \"product\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.Field0001\",\n" +
                "          \"DevelopChannel\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.ac0e91a344394ec89a8d4182d75972bf\",\n" +
                "          \"fShareAmount\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.ad966642b88b916a842e2525ef4ba7e8\",\n" +
                "          \"fClubShareAmount\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.a1c0dff08a5cece6e6eaa8c1239c622f\",\n" +
                "          \"fClubInShareAmount\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.a84698c8eef0bb9e32048bb1584c94b5\",\n" +
                "          \"fChannelShareAmount\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.a210d8212df636c4cf54dc491f00eb2d\",\n" +
                "          \"fChannelInShareAmount\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.c9359c8989dcdab3755aae44bcdf980a\",\n" +
                "          \"brepair\": {\n" +
                "            \"true\": {\n" +
                "              \"#是\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a9c6bf722579709141d1b10d75285998.name\",\n" +
                "              \"#5078663054e64f2d6818b55249a09b50\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a9c6bf722579709141d1b10d75285998.value\"\n" +
                "            },\n" +
                "            \"false\": {\n" +
                "              \"#否\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a9c6bf722579709141d1b10d75285998.name\",\n" +
                "              \"#c0b51a1642acde7197ffdfa92fd55c04\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a9c6bf722579709141d1b10d75285998.value\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"remarks\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.a92f44d3cf08c87ee67eb73502cd08b6\",\n" +
                "          \"fQuantity\": \"aa40ca3fcaf887997d0d817178910142.[&1].rowData.ff0438dc3a7068dd8eb5e75a87660cf6\",\n" +
                "          \"bshare\": {\n" +
                "            \"true\": {\n" +
                "              \"#是\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a2cdde8679b8b9572a6fb62d03fce1a7.name\",\n" +
                "              \"#5078663054e64f2d6818b55249a09b50\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a2cdde8679b8b9572a6fb62d03fce1a7.value\"\n" +
                "            },\n" +
                "            \"false\": {\n" +
                "              \"#否\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a2cdde8679b8b9572a6fb62d03fce1a7.name\",\n" +
                "              \"#c0b51a1642acde7197ffdfa92fd55c04\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.a2cdde8679b8b9572a6fb62d03fce1a7.value\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"hrstoreemployeedetail\": {\n" +
                "            \"*\": {\n" +
                "              \"id\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.CustomObject0011.[&1].rowData.data_id\",\n" +
                "              \"fShareScale\": \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.CustomObject0011.[&1].rowData.Field0003\",\n" +
                "              \"storeemployee\": [\"aa40ca3fcaf887997d0d817178910142.[&3].rowData.CustomObject0011.[&1].rowData.Field0001\", \"aa40ca3fcaf887997d0d817178910142.[&3].rowData.CustomObject0011.[&1].rowData.Field0005\"],\n" +
                "              \"positionauth\": {\n" +
                "                \"0\": {\n" +
                "                  \"#本单开发人员\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#d43c11b24290b5bf9d6805b8877d01cf\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"1\": {\n" +
                "                  \"#咨询师\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#b3dc82ed3316d23cc1dd2e82eded393c\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"2\": {\n" +
                "                  \"#助理咨询师\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#a554cd415ecf14c22dec5a5ef34e7447\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"3\": {\n" +
                "                  \"#手术医生\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#8d4a00d9d89df900c2bb83aedc0ac4e3\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"4\": {\n" +
                "                  \"#麻醉医生\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#2563f13bcabe1bd7218ddbb8366dd797\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"5\": {\n" +
                "                  \"#助理医生\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#faeb5963010a74ad932e1a000f44873e\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"6\": {\n" +
                "                  \"#配台护士\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#d588fb9011bbedc8f4f493f766330799\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"7\": {\n" +
                "                  \"#美疗师\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#4a5d9e0d7a4c7c7b2e6fde4ed029cb9a\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"9\": {\n" +
                "                  \"#美容师\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#1d481a759bad2beb09bfc8a7b5fda86c\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"10\": {\n" +
                "                  \"#美容顾问\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#786ec79bf985f0f92359586e03e4d841\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"11\": {\n" +
                "                  \"#纹绣师\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#bf8d5db912772d635aa8c8d670420d10\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"12\": {\n" +
                "                  \"#转介绍\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#3f0e8949413b98e68c9f76d70c252486\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"13\": {\n" +
                "                  \"#销售人\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#a9234ec2befa3863b32bd2129292caa7\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"14\": {\n" +
                "                  \"#美导\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#3ff03d81515b622af7408533f16304f5\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"15\": {\n" +
                "                  \"#纹绣顾问\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#d9a7a75d21f8e4572d501a9aa4ef02bf\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"16\": {\n" +
                "                  \"#销售客服\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#e7be0c595eed7082bf8365a6beb01fe6\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"17\": {\n" +
                "                  \"#项目组长\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#29275064945e0fcba6d5695d9213f078\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"18\": {\n" +
                "                  \"#辅助\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#9678dd6d548c2e4e63f3b9af7a9f83dc\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                },\n" +
                "                \"19\": {\n" +
                "                  \"#市场\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.name\",\n" +
                "                  \"#24aa4ce10a632fc376191fbf9a93805f\": \"aa40ca3fcaf887997d0d817178910142.[&5].rowData.CustomObject0011.[&3].rowData.Field0004.value\"\n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"hrstoreemployee\":{\n" +
                "        \"*\":{\n" +
                "          \"id\":\"zx_hrstoreemployee__c.[&1].rowData.data_id\",\n" +
                "          \"fShareScale\":\"zx_hrstoreemployee__c.[&1].rowData.Field0001__c\",\n" +
                "          \"storeemployee\":[\"zx_hrstoreemployee__c.[&1].rowData.positionName__c\",\"zx_hrstoreemployee__c.[&1].rowData.Field0003__c\"],\n" +
                "          \"positionauth\": {\n" +
                "                \"0\": {\n" +
                "                  \"#本单开发人员\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#d43c11b24290b5bf9d6805b8877d01cf\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"1\": {\n" +
                "                  \"#咨询师\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#b3dc82ed3316d23cc1dd2e82eded393c\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"2\": {\n" +
                "                  \"#助理咨询师\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#a554cd415ecf14c22dec5a5ef34e7447\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"3\": {\n" +
                "                  \"#手术医生\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#8d4a00d9d89df900c2bb83aedc0ac4e3\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"4\": {\n" +
                "                  \"#麻醉医生\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#2563f13bcabe1bd7218ddbb8366dd797\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"5\": {\n" +
                "                  \"#助理医生\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#faeb5963010a74ad932e1a000f44873e\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"6\": {\n" +
                "                  \"#配台护士\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#d588fb9011bbedc8f4f493f766330799\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"7\": {\n" +
                "                  \"#美疗师\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#4a5d9e0d7a4c7c7b2e6fde4ed029cb9a\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"9\": {\n" +
                "                  \"#美容师\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#1d481a759bad2beb09bfc8a7b5fda86c\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"10\": {\n" +
                "                  \"#美容顾问\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#786ec79bf985f0f92359586e03e4d841\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"11\": {\n" +
                "                  \"#纹绣师\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#bf8d5db912772d635aa8c8d670420d10\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"12\": {\n" +
                "                  \"#转介绍\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#3f0e8949413b98e68c9f76d70c252486\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"13\": {\n" +
                "                  \"#销售人\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#a9234ec2befa3863b32bd2129292caa7\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"14\": {\n" +
                "                  \"#美导\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#3ff03d81515b622af7408533f16304f5\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"15\": {\n" +
                "                  \"#纹绣顾问\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#d9a7a75d21f8e4572d501a9aa4ef02bf\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"16\": {\n" +
                "                  \"#销售客服\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#e7be0c595eed7082bf8365a6beb01fe6\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"17\": {\n" +
                "                  \"#项目组长\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#29275064945e0fcba6d5695d9213f078\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"18\": {\n" +
                "                  \"#辅助\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#9678dd6d548c2e4e63f3b9af7a9f83dc\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                },\n" +
                "                \"19\": {\n" +
                "                  \"#市场\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.name\",\n" +
                "                  \"#24aa4ce10a632fc376191fbf9a93805f\": \"zx_hrstoreemployee__c.[&3].rowData.Field0002__c.value\"\n" +
                "                }\n" +
                "              }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "\t},\n" +
                "  {\n" +
                "    \"operation\": \"default\",\n" +
                "    \"spec\": {\n" +
                "      \"Field0010\": \"医美\"\n" +
                "    }\n" +
                "\t}\n" +
                "]\n");
        Chainr chainr = Chainr.fromSpec(spec);
        Object transform = chainr.transform(input);
        System.out.println(JsonUtils.toJsonString(transform));
    }

    @Test
    public void test3() {
//        Function<Integer,Integer> fun = (x) -> x*100;
//        System.out.println(fun.apply(5));

        int num = getNum();
        System.out.println("结果："+ num);
        System.out.println(ids().length);


    }
    @Test
    public void test4() {
//        List<Object> list = Arrays.asList("1","2","3","4","5","6");
        List<Long> list = Arrays.asList(1l,2l,3l,4l,5l,6l);
        List<List<Long>> lists = group(list, 2);
        System.out.println(lists);

        System.out.println(Math.pow(2,3));
        System.out.println(Math.round(12.4));
        System.out.println(Math.random());

    }

    private  <T> List<List<T>> group(List<T> records, Integer groupNum) {
        if (CollectionUtils.isEmpty(records)) {
            return Collections.emptyList();
        }
        if (groupNum <= 0) {
            throw new IllegalStateException("每组数据数量有误 groupNum = " + groupNum);
        }
        int size = records.size();
        if (size < groupNum) {
            return Arrays.asList(records);
        }
        Integer page = (size / groupNum) + ((size % groupNum) != 0 ? 1 : 0);
        List<List<T>> groupList = new ArrayList<>(page);
        int index = 0;
        for (int i = 0; i < page; i++) {
            int endIndex = index + groupNum;
            if (endIndex > records.size()) {
                groupList.add(records.subList(index, records.size()));
                continue;
            }
            groupList.add(records.subList(index, endIndex));
            index = endIndex;
        }
        return groupList;
    }

    private int getNum() {
        int num = 0;
        try {
            num = 10 / 0;
            return num+1;
        } catch (Exception e) {
            return num+=2;
        } finally {
            return num+3;
        }
    }


    private String[] ids (){
        String ids = "6230351, 6230352, 6230353, 6230354, 6230355, 6230356, 6230357, 6230358, 6230359, 6230360, 6230361, 6230362, 6230363, 6230364, 6230365, 6230366, 6230367, 6230368, 6230369, 6230370, 6230371, 6230372, 6230373, 6230374, 6230375, 6230376, 6230377, 6230378, 6230379, 6230380, 6230381, 6230382, 6230383, 6230384, 6230385, 6230386, 6230387, 6230388, 6230389, 6230390, 6230391, 6230392, 6230393, 6230394, 6230395, 6230396, 6230397, 6230398, 6230399, 6230400, 6230401, 6230402, 6230403, 6230404, 6230405, 6230406, 6230407, 6230408, 6230409, 6230410, 6230411, 6230412, 6230413, 6230414, 6230415, 6230416, 6230417, 6230418, 6230419, 6230420, 6230421, 6230422, 6230423, 6230424, 6230425, 6230426, 6230427, 6230428, 6230429, 6230430, 6230431, 6230432, 6230433, 6230434, 6230435, 6230436, 6230437, 6230438, 6230439, 6230440, 6230441, 6230442, 6230443, 6230444, 6230445, 6230446, 6230447, 6230448, 6230449, 6230450, 6230452, 6230453, 6230454, 6230455, 6230456, 6230457, 6230458, 6230459, 6230460, 6230461, 6230462, 6230463, 6230464, 6230465, 6230466, 6230467, 6230468, 6230469, 6230470, 6230471, 6230472, 6230473, 6230474, 6230475, 6230476, 6230477, 6230478, 6230479, 6230480, 6230481, 6230482, 6230483, 6230484, 6230485, 6230486, 6230487, 6230488, 6230489, 6230490, 6230491, 6230492, 6230493, 6230494, 6230495, 6230496, 6230497, 6230498, 6230499, 6230500, 6230501, 6230502, 6230503, 6230504, 6230505, 6230506, 6230507, 6230508, 6230509, 6230510, 6230511, 6230512, 6230513, 6230514, 6230515, 6230516, 6230517, 6230518, 6230519, 6230520, 6230521, 6230522, 6230523, 6230524, 6230525, 6230526, 6230527, 6230528, 6230529, 6230530, 6230531, 6230532, 6230533, 6230534, 6230535, 6230536, 6230537, 6230538, 6230539, 6230540, 6230541, 6230542, 6230543, 6230544, 6230545, 6230546, 6230547, 6230548, 6230549, 6230550, 6230551, 6230552, 6230553, 6230554, 6230555, 6230556, 6230557, 6230558, 6230559, 6230560, 6230561, 6230562, 6230563, 6230564, 6230565, 6230566, 6230567, 6230568, 6230569, 6230570, 6230571, 6230572, 6230573, 6230574, 6230575, 6230576, 6230577, 6230578, 6230579, 6230580, 6230581, 6230582, 6230583, 6230584, 6230585, 6230586, 6230587, 6230588, 6230589, 6230590, 6230591, 6230592, 6230593, 6230594, 6230595, 6230596, 6230597, 6230598, 6230599, 6230600, 6230601, 6230602, 6230603, 6230604, 6230605, 6230606, 6230607, 6230608, 6230609, 6230610, 6230611, 6230612, 6230613, 6230614, 6230615, 6230616, 6230617, 6230618, 6230619, 6230620, 6230621, 6230622, 6230623, 6230624, 6230625, 6230626, 6230627, 6230628, 6230629, 6230630, 6230631, 6230632, 6230633, 6230634, 6230635, 6230636, 6230637, 6230638, 6230639, 6230640, 6230641, 6230642, 6230643, 6230644, 6230645, 6230646, 6230647, 6230648, 6230649, 6230650, 6230651, 6230656, 6230657, 6230658, 6230659, 6230660, 6230661, 6230662, 6230663, 6230664, 6230665, 6230666, 6230667, 6230668, 6230669, 6230670, 6230671, 6230672, 6230673, 6230674, 6230675, 6230676, 6230677, 6230678, 6230679, 6230680, 6230681, 6230682, 6230683, 6230684, 6230685, 6230686, 6230687, 6230688, 6230689, 6230690, 6230691, 6230692, 6230693, 6230694, 6230695, 6230696, 6230697, 6230698, 6230699, 6230700, 6230701, 6230702, 6230703, 6230704, 6230705, 6230706, 6230707, 6230708, 6230709, 6230710, 6230711, 6230712, 6230713, 6230714, 6230715, 6230716, 6230717, 6230718, 6230719, 6230720, 6230721, 6230722, 6230723, 6230724, 6230725, 6230726, 6230727, 6230728, 6230729, 6230730, 6230731, 6230732, 6230733, 6230734, 6230735, 6230736, 6230737, 6230738, 6230739, 6230740, 6230741, 6230742, 6230743, 6230744, 6230745, 6230746, 6230747, 6230748, 6230749, 6230750, 6230751, 6230752, 6230753, 6230754, 6230755, 6230756, 6230757, 6230758, 6230759, 6230760, 6230761, 6230762, 6230763, 6230764, 6230765, 6230766, 6230767, 6230768, 6230769, 6230770, 6230771, 6230772, 6230773, 6230774, 6230775, 6230776, 6230777, 6230778, 6230779, 6230780, 6230781, 6230782, 6230783, 6230784, 6230785, 6230786, 6230787, 6230788, 6230789, 6230790, 6230791, 6230792, 6230793, 6230794, 6230795, 6230796, 6230797, 6230798, 6230799, 6230800, 6230801, 6230802, 6230803, 6230804, 6230805, 6230806, 6230807, 6230808, 6230809, 6230810, 6230811, 6230812, 6230813, 6230814, 6230815, 6230816, 6230817, 6230818, 6230819, 6230820, 6230821, 6230822, 6230823, 6230824, 6230825, 6230826, 6230827, 6230828, 6230829, 6230830, 6230831, 6230832, 6230833, 6230834, 6230835, 6230836, 6230837, 6230838, 6230839, 6230840, 6230841, 6230842, 6230843, 6230844, 6230845, 6230846, 6230847, 6230848, 6230849, 6230850, 6230851, 6230852, 6230853, 6230854, 6230855, 6230856, 6230857, 6230858, 6230859, 6230860, 6230861, 6230862, 6230863, 6230864, 6230865, 6230866, 6230867, 6230868, 6230869, 6230870, 6230871, 6230872, 6230873, 6230874, 6230875, 6230876, 6230877, 6230878, 6230879, 6230880, 6230881, 6230882, 6230883, 6230884, 6230885, 6230886, 6230887, 6230888, 6230889, 6230890, 6230891, 6230892, 6230893, 6230894, 6230895, 6230896, 6230897, 6230898, 6230899, 6230900, 6230901, 6230902, 6230903, 6230904, 6230905, 6230906, 6230907, 6230908, 6230909, 6230910, 6230911, 6230912, 6230913, 6230914, 6230915, 6230916, 6230917, 6230918, 6230919, 6230920, 6230921, 6230922, 6230923, 6230924, 6230925, 6230926, 6230927, 6230928, 6230929, 6230930, 6230931, 6230932, 6230933, 6230934, 6230935, 6230936, 6230937, 6230938, 6230939, 6230940, 6230941, 6230942, 6230943, 6230944, 6230945, 6230946, 6230947, 6230948, 6230949, 6230950, 6230951, 6230952, 6230953, 6230954, 6230955, 6230957, 6230958, 6230959, 6230960, 6230961, 6230962, 6230963, 6230964, 6230965, 6230966, 6230967, 6230968, 6230969, 6230970, 6230971, 6230972, 6230973, 6230974, 6230975, 6230976, 6230977, 6230978, 6230979, 6230980, 6230981, 6230982, 6230983, 6230984, 6230985, 6230986, 6230987, 6230988, 6230989, 6230990, 6230991, 6230992, 6230993, 6230994, 6230995, 6230996, 6230997, 6230998, 6230999, 6231000, 6231001, 6231002, 6231003, 6231004, 6231005, 6231006, 6231007, 6231008, 6231009, 6231010, 6231011, 6231012, 6231013, 6231014, 6231015, 6231016, 6231017, 6231018, 6231019, 6231020, 6231021, 6231022, 6231023, 6231024, 6231025, 6231026, 6231027, 6231028, 6231029, 6231030, 6231031, 6231032, 6231033, 6231034, 6231035, 6231036, 6231037, 6231038, 6231039, 6231040, 6231041, 6231042, 6231043, 6231044, 6231045, 6231046, 6231047, 6231048, 6231049, 6231050, 6231051, 6231052, 6231053, 6231054, 6231055, 6231056, 6231057, 6231058, 6231059, 6231060, 6231061, 6231062, 6231063, 6231064, 6231065, 6231066, 6231067, 6231068, 6231069, 6231070, 6231071, 6231072, 6231073, 6231074, 6231075, 6231076, 6231077, 6231078, 6231079, 6231080, 6231081, 6231082, 6231083, 6231084, 6231085, 6231086, 6231087, 6231088, 6231089, 6231090, 6231091, 6231092, 6231093, 6231094, 6231095, 6231096, 6231097, 6231098, 6231099, 6231100, 6231101, 6231102, 6231103, 6231104, 6231105, 6231106, 6231107, 6231108, 6231109, 6231110, 6231111, 6231112, 6231113, 6231114, 6231115, 6231116, 6231117, 6231118, 6231119, 6231120, 6231121, 6231122, 6231123, 6231124, 6231125, 6231126, 6231127, 6231128, 6231129, 6231130, 6231131, 6231132, 6231133, 6231134, 6231135, 6231136, 6231137, 6231138, 6231139, 6231140, 6231141, 6231142, 6231143, 6231144, 6231145, 6231146, 6231147, 6231148, 6231149, 6231150, 6231151, 6231152, 6231153, 6231154, 6231155, 6231156, 6231157, 6231158, 6231159, 6231160, 6231161, 6231162, 6231163, 6231164, 6231165, 6231166, 6231167, 6231168, 6231169, 6231170, 6231171, 6231172, 6231173, 6231174, 6231175, 6231176, 6231177, 6231178, 6231179, 6231180, 6231181, 6231182, 6231183, 6231184, 6231185, 6231186, 6231187, 6231188, 6231189, 6231190, 6231191, 6231192, 6231193, 6231194, 6231195, 6231196, 6231197, 6231198, 6231199, 6231200, 6231201, 6231202, 6231203, 6231204, 6231205, 6231206, 6231207, 6231208, 6231209, 6231210, 6231211, 6231212, 6231213, 6231214, 6231215, 6231216, 6231217, 6231218, 6231219, 6231220, 6231221, 6231222, 6231223, 6231224, 6231225, 6231226, 6231227, 6231228, 6231229, 6231230, 6231231, 6231232, 6231233, 6231234, 6231235, 6231236, 6231237, 6231238, 6231239, 6231240, 6231241, 6231242, 6231243, 6231244, 6231245, 6231246, 6231247, 6231248, 6231249, 6231250, 6231251, 6231252, 6231253, 6231254, 6231255, 6231256, 6231258, 6231259, 6231260, 6231261, 6231262, 6231263, 6231264, 6231265, 6231266, 6231267, 6231268, 6231269, 6231270, 6231271, 6231272, 6231273, 6231274, 6231275, 6231276, 6231277, 6231278, 6231279, 6231280, 6231281, 6231282, 6231283, 6231284, 6231285, 6231286, 6231287, 6231288, 6231289, 6231290, 6231291, 6231292, 6231293, 6231294, 6231295, 6231296, 6231297, 6231298, 6231299, 6231300, 6231301, 6231302, 6231303, 6231304, 6231305, 6231306, 6231307, 6231308, 6231309, 6231310, 6231311, 6231312, 6231313, 6231314, 6231315, 6231316, 6231317, 6231318, 6231319, 6231320, 6231321, 6231322, 6231323, 6231324, 6231325, 6231326, 6231327, 6231328, 6231329, 6231330, 6231331, 6231332, 6231333, 6231334, 6231335, 6231336, 6231337, 6231338, 6231339, 6231340, 6231341, 6231342, 6231343, 6231344, 6231345, 6231346, 6231347, 6231348, 6231349, 6231350, 6231351, 6231352, 6231353, 6231354, 6231355, 6231356, 6231357, 6231215, 6231231, 6230731, 6230561, 6230723, 6230502, 6230524, 6231402, 6230365, 6230628, 6230997, 6231007, 6230967, 6230398, 6231318, 6231391, 6231017, 6230549, 6230679, 6231196, 6231273, 6231140, 6231451, 6231241, 6230462, 6230388, 6231095, 6230837, 6230582, 6230809, 6230846, 6231351, 6230992, 6230692, 6231390, 6231010, 6230761, 6230620, 6231015, 6231115, 6231136, 6230521, 6230397, 6230791, 6231082, 6231427, 6231009, 6230586, 6230750, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6230363, 6230614, 6231075, 6231262, 6230848, 6231352, 6230780, 6230590, 6230950, 6230983, 6230360, 6231274, 6230861, 6230998, 6230411, 6231220, 6230667, 6230748, 6230562, 6231381, 6230408, 6230373, 6230478, 6230595, 6230733, 6231308, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6230800, 6230628, 6231505, 6230997, 6231007, 6230967, 6230398, 6231318, 6231391, 6231017, 6230549, 6230679, 6231196, 6231273, 6231140, 6231451, 6231241, 6230462, 6230388, 6231095, 6230837, 6230582, 6230809, 6231530, 6230846, 6231351, 6230992, 6230692, 6231516, 6231390, 6231010, 6231510, 6230761, 6230620, 6231508, 6231015, 6231115, 6231136, 6230521, 6230397, 6230791, 6231082, 6231427, 6231009, 6230586, 6230750, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6230614, 6231075, 6231262, 6230848, 6231352, 6230780, 6230590, 6230950, 6230983, 6230360, 6231274, 6230861, 6230998, 6230411, 6231220, 6230667, 6230748, 6230562, 6231381, 6230408, 6230373, 6230478, 6230595, 6230733, 6231557, 6231308, 6231502, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6230800, 6231318, 6231391, 6231017, 6230549, 6230679, 6231196, 6231273, 6231140, 6231451, 6231241, 6230462, 6231569, 6230388, 6231095, 6230837, 6230582, 6230809, 6231530, 6230846, 6231351, 6230992, 6230692, 6231516, 6231390, 6231010, 6231510, 6230761, 6231612, 6230620, 6231508, 6231015, 6231115, 6231136, 6230521, 6230397, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231576, 6230750, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6230614, 6231075, 6231262, 6230848, 6231352, 6230780, 6231603, 6230590, 6230950, 6230983, 6230360, 6231274, 6230861, 6230998, 6230411, 6231220, 6230667, 6230748, 6230562, 6231381, 6230408, 6230373, 6230478, 6230595, 6230733, 6231557, 6231308, 6231502, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6230800, 6231601, 6230549, 6230679, 6231196, 6231273, 6231140, 6231451, 6231241, 6230462, 6231569, 6230388, 6231095, 6230837, 6230582, 6230809, 6231530, 6230846, 6231351, 6230992, 6230692, 6231516, 6231390, 6231010, 6231510, 6230761, 6231612, 6230620, 6231508, 6231015, 6231115, 6231136, 6230521, 6230397, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231576, 6230750, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6230614, 6231075, 6231262, 6230848, 6231352, 6230780, 6231603, 6230590, 6231669, 6230950, 6230983, 6230360, 6231274, 6230861, 6230998, 6230411, 6231220, 6230667, 6230748, 6230562, 6231381, 6230408, 6230373, 6230478, 6230595, 6230733, 6231557, 6231308, 6231502, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6230800, 6231601, 6230388, 6231095, 6230837, 6230582, 6230809, 6231801, 6231530, 6230846, 6231351, 6230992, 6230692, 6231516, 6231390, 6231010, 6231510, 6230761, 6231612, 6230620, 6231508, 6231015, 6231115, 6231136, 6230521, 6230397, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231828, 6231576, 6230750, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6230614, 6231075, 6231262, 6230848, 6231352, 6231794, 6230780, 6231603, 6231783, 6230590, 6231669, 6230950, 6230983, 6230360, 6231274, 6231785, 6230861, 6230998, 6230411, 6231833, 6231796, 6231220, 6230667, 6230748, 6230562, 6231381, 6230408, 6230373, 6230478, 6231784, 6230595, 6230733, 6231557, 6231308, 6231502, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6231805, 6230800, 6231601, 6231801, 6231530, 6230846, 6231351, 6230992, 6230692, 6231516, 6231390, 6231010, 6231510, 6230761, 6231612, 6230620, 6231508, 6231015, 6231115, 6231957, 6231136, 6230521, 6230397, 6231950, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231828, 6231576, 6230750, 6231915, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6230614, 6231075, 6231262, 6230848, 6231352, 6231794, 6230780, 6231914, 6231603, 6231783, 6230590, 6231669, 6230950, 6230983, 6230360, 6231274, 6231952, 6231785, 6230861, 6230998, 6230411, 6231833, 6231796, 6231220, 6230667, 6230748, 6230562, 6231381, 6230408, 6230373, 6230478, 6231784, 6230595, 6230733, 6231557, 6231308, 6231502, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6231805, 6230800, 6231601, 6231516, 6231390, 6231010, 6231510, 6230761, 6232022, 6231612, 6232060, 6230620, 6231508, 6231015, 6231115, 6231957, 6231136, 6230521, 6230397, 6231950, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231828, 6231576, 6230750, 6231915, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6232020, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6230614, 6231075, 6231262, 6231972, 6230848, 6231352, 6231794, 6230780, 6231914, 6231603, 6231783, 6230590, 6231997, 6231669, 6230950, 6230983, 6230360, 6231274, 6231952, 6231785, 6230861, 6230998, 6230411, 6231833, 6231796, 6231220, 6230667, 6230748, 6230562, 6231990, 6231381, 6230408, 6230373, 6230478, 6231784, 6230595, 6230733, 6231557, 6231308, 6231502, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6231805, 6230800, 6231601, 6231612, 6232060, 6230620, 6231508, 6231015, 6231115, 6231957, 6231136, 6230521, 6230397, 6231950, 6232151, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231828, 6231576, 6230750, 6231915, 6232159, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6232020, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6230614, 6231075, 6231262, 6231972, 6230848, 6231352, 6231794, 6230780, 6231914, 6231603, 6231783, 6230590, 6232116, 6231997, 6231669, 6230950, 6230983, 6230360, 6232088, 6231274, 6231952, 6232097, 6231785, 6230861, 6230998, 6230411, 6231833, 6231796, 6231220, 6230667, 6230748, 6230562, 6231990, 6231381, 6230408, 6230373, 6230478, 6231784, 6230595, 6230733, 6231557, 6231308, 6231502, 6232081, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6231805, 6230800, 6231601, 6230620, 6231508, 6231015, 6231115, 6232239, 6231957, 6231136, 6230521, 6230397, 6231950, 6232151, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231828, 6231576, 6230750, 6231915, 6232159, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6231333, 6231245, 6231302, 6232020, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6230614, 6231075, 6231262, 6231972, 6230848, 6231352, 6231794, 6230780, 6231914, 6231603, 6231783, 6230590, 6232116, 6231997, 6231669, 6230950, 6230983, 6230360, 6232088, 6231274, 6231952, 6232097, 6231785, 6230861, 6230998, 6230411, 6231833, 6231796, 6231220, 6230667, 6230748, 6230562, 6231990, 6231381, 6230408, 6230373, 6230478, 6231784, 6232248, 6230595, 6230733, 6231557, 6231308, 6231502, 6232081, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6231805, 6230800, 6231601, 6230397, 6231950, 6232151, 6230791, 6231082, 6231568, 6231427, 6231009, 6230586, 6231828, 6231576, 6230750, 6231915, 6232159, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6232304, 6231333, 6231245, 6231302, 6232020, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6232345, 6230614, 6231075, 6231262, 6231972, 6230848, 6231352, 6231794, 6230780, 6231914, 6231603, 6231783, 6230590, 6232116, 6231997, 6231669, 6230950, 6232322, 6232300, 6230983, 6230360, 6232088, 6231274, 6231952, 6232348, 6232097, 6231785, 6230861, 6232283, 6230998, 6230411, 6231833, 6231796, 6231220, 6230667, 6232264, 6232290, 6230748, 6230562, 6231990, 6231381, 6230408, 6230373, 6230478, 6231784, 6232248, 6230595, 6230733, 6231557, 6231308, 6231502, 6232081, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6231805, 6230800, 6231601, 6230750, 6231915, 6232159, 6231153, 6230488, 6230810, 6230584, 6230743, 6230362, 6230456, 6232304, 6232379, 6231333, 6231245, 6231302, 6232020, 6231165, 6230923, 6230755, 6230986, 6230565, 6230790, 6231463, 6230363, 6231691, 6232403, 6232345, 6230614, 6232451, 6231075, 6231262, 6231972, 6232438, 6230848, 6232425, 6231352, 6231794, 6230780, 6231914, 6231603, 6231783, 6230590, 6232116, 6231997, 6231669, 6230950, 6232322, 6232300, 6230983, 6230360, 6232088, 6231274, 6231952, 6232348, 6232097, 6231785, 6230861, 6232283, 6230998, 6232435, 6230411, 6231833, 6231796, 6231220, 6232391, 6230667, 6232387, 6232264, 6232398, 6232290, 6230748, 6230562, 6231990, 6231381, 6232447, 6230408, 6230373, 6230478, 6231784, 6232248, 6230595, 6230733, 6231557, 6231308, 6232444, 6231502, 6232081, 6230632, 6231399, 6231331, 6230508, 6230847, 6230547, 6231335, 6230912, 6231547, 6231739, 6231805, 6230800, 6231601";
        return ids.split(",");
    }


}
