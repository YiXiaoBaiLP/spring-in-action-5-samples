package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author yixiaobai
 * @create 2022/05/23 下午11:27
 */
@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order", new Order());
        // 返回一个名叫orderForm的视图逻辑名
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {

        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted: " + order);

        return "rediect:/";
    }
}
