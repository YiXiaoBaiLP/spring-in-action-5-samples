package buzz.yixiaobai.springboot;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author yixiaobai
 * @create 2022/05/23 上午1:02
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    // 通过以final定义的属性来创建构造器
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
