package cn.oreo.server.pay.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 微信⽀付通知映射的POJO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class WxPayNotifyVO implements Serializable {

    private String appid;
    private String attach;
    private String bank_type;
    private String fee_type;
    private String is_subscribe;
    private String mch_id;
    private String nonce_str;
    private String openid;
    private String out_trade_no;
    private String result_code;
    private String return_code;
    private String sign;
    private String time_end;
    private String total_fee;
    private String coupon_fee;
    private String coupon_count;
    private String coupon_type;
    private String coupon_id;
    private String trade_type;
    private String transaction_id;

}
