package com.example.CodeBase.model;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
public class ConvertAdapter {

    private Convert trans;
    private Hexadecimal hex;
    private Base64 base64;
    private Bytes bytes;

    private Images images;


    public ConvertAdapter(Convert trans, Hexadecimal hex, Base64 base64) {
        this.trans = trans;
        this.hex = hex;
        this.base64 = base64;

    }

    public String convert(String base64ToString, String hexToString, String from, String to) throws Exception {
        String result = "";
        switch (from) {
            case "String": {
                setTrans(this.hex);
                result = (String) trans.encode(hexToString);
                if (to.equals("Base64")) {
                    setTrans(this.base64);
                    result = (String) trans.encode(base64ToString);
                }
            }
            break;
            case "Base64": {
                setTrans(this.base64);
                result = (String) trans.decode(base64ToString);
                if (to.equals("Hex")) {
                    String smackDown = (String) trans.decode(hexToString);
                    setTrans(this.hex);
                    result = (String) trans.encode(smackDown);
                }
            }
            break;
            case "Hex": {
                setTrans(this.hex);
                result = (String) trans.decode(hexToString);
                if (to.equals("Base64")) {
                    String smackDown = (String) trans.decode(base64ToString);
                    setTrans(this.base64);
                    result = (String) trans.encode(smackDown);
                }
            }
            break;
            default:
                throw new Exception("Loại dữ liệu cần chuyển đổi mà bạn nhập vào, không phù hợp. Hãy lại định dạng!");
        }
        return result;
    }

}

