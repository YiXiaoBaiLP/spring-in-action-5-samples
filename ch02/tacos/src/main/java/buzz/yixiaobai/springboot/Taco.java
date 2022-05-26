package buzz.yixiaobai.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author yixiaobai
 * @create 2022/05/23 下午10:54
 */
@Data
public class Taco {

    @NotNull// 不为空
    @Size(min=5, message="Name must be at least 5 characters long") // 字符长度必须大于等于5
    private String name;
    // 必须选择一个ingredient
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;
}
