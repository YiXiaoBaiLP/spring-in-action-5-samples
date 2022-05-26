package buzz.yixiaobai.springboot;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author yixiaobai
 * @create 2022/05/23 下午11:29
 */
@Data
public class    Order {
    // @NotBlank：此注解为Hibernate提供，此字段不能为空
    @NotBlank(message="Name is required")
    private String name;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "state is required")
    private String state;
    @NotBlank(message = "Zip code is required")
    private String zip;
    // @CreditCardNumber：注解用来校验是否是一个合法的银行卡号
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    // 使用正则表达式校验
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "格式必须为：MM/YY")
    private String ccExpiration;
    // @Digits：确保包含3位有效数字（integer：表示整数精度，fraction：表示小数精度）
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

}
