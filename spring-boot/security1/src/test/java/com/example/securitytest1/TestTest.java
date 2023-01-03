package com.example.securitytest1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestTest {

    public static final String jsonStr = "{\n" +
            "  \"result\": [\n" +
            "    {\n" +
            "      \"0\": {\n" +
            "        \"cmd\": \"configure terminal\", \n" +
            "        \"err_code\": 0, \n" +
            "        \"err_reason\": \"\", \n" +
            "        \"error\": false, \n" +
            "        \"sequence\": 0, \n" +
            "        \"sourceDetails\": \" configure terminal \\r\\nEnter configuration commands, one per line. End with CNTL/Z.\\r\\n\"\n" +
            "      }, \n" +
            "      \"1\": {\n" +
            "        \"cmd\": \"no vlan 10\", \n" +
            "        \"err_code\": 0, \n" +
            "        \"err_reason\": \"\", \n" +
            "        \"error\": false, \n" +
            "        \"sequence\": 1, \n" +
            "        \"sourceDetails\": \" no vlan 10 \\r\\n\"\n" +
            "      }, \n" +
            "      \"2\": {\n" +
            "        \"cmd\": \"vlan range 10, 20\", \n" +
            "        \"err_code\": 0, \n" +
            "        \"err_reason\": \"\", \n" +
            "        \"error\": false, \n" +
            "        \"sequence\": 2, \n" +
            "        \"sourceDetails\": \" vlan range 10, 20 \\r\\n\"\n" +
            "      }, \n" +
            "      \"3\": {\n" +
            "        \"cmd\": \"end\", \n" +
            "        \"err_code\": 0, \n" +
            "        \"err_reason\": \"\", \n" +
            "        \"error\": false, \n" +
            "        \"sequence\": 3, \n" +
            "        \"sourceDetails\": \" end \\r\\n\"\n" +
            "      }, \n" +
            "      \"4\": {\n" +
            "        \"cmd\": \"show running-config\", \n" +
            "        \"err_code\": 0, \n" +
            "        \"err_reason\": \"\", \n" +
            "        \"error\": false, \n" +
            "        \"sequence\": 4, \n" +
            "        \"sourceDetails\": \" show running-config \\r\\nBuilding configuration...\\r\\nversion 5.2.5\\r\\n!\\r\\nhostname OJT\\r\\n!\\r\\n!\\r\\nusername admin privilege 4 password admin\\r\\n!\\r\\n!\\r\\nservice rpc-api enable\\r\\n!\\r\\n!\\r\\nmanagement ip address dhcp\\r\\n!\\r\\nvlan range 10,20,30,60\\r\\n!\\r\\n!\\r\\n!\\r\\ninterface eth-0-1\\r\\n!\\r\\ninterface eth-0-2\\r\\n!\\r\\ninterface eth-0-3\\r\\n!\\r\\ninterface eth-0-4\\r\\n!\\r\\ninterface eth-0-5\\r\\n!\\r\\ninterface eth-0-6\\r\\n!\\r\\ninterface eth-0-7\\r\\n!\\r\\ninterface eth-0-8\\r\\n!\\r\\ninterface eth-0-9\\r\\n!\\r\\ninterface eth-0-10\\r\\n!\\r\\ninterface eth-0-11\\r\\n!\\r\\ninterface eth-0-12\\r\\n!\\r\\n!\\r\\n!\\r\\nline console 0\\r\\n no line-password\\r\\n no login\\r\\nline vty 0 7\\r\\n privilege level 4\\r\\n no line-password\\r\\n no login\\r\\n\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    public void test() {
        ObjectMapper om = new ObjectMapper();
        try {
            ResultData data = om.readValue(jsonStr, ResultData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Getter
    @Setter
    public class ResultData {
        List<CommandResult> crList = new ArrayList<>();

        @Getter
        @Setter
        static class CommandResult {
            private String cmd;
            @JsonProperty("err_reason")
            private String errReason;
            @JsonProperty("err_code")
            private String errCode;
            private String error;
            private String sequence;
            private String sourceDetails;
        }
    }


}
