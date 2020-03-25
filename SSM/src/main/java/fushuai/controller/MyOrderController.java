package fushuai.controller;

import fushuai.dto.Shopcardto;
import fushuai.entity.Member;
import fushuai.service.FsGoodsService;
import fushuai.service.FsGoodsShopcarService;
import fushuai.service.FsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class MyOrderController {
    private final FsMemberService fsMemberService;
    private final FsGoodsShopcarService fsGoodsShopcarService;

    public MyOrderController(FsGoodsShopcarService fsGoodsShopcarService, FsMemberService fsMemberService) {
        this.fsGoodsShopcarService = fsGoodsShopcarService;
        this.fsMemberService = fsMemberService;
    }

    /**
     * 我的订单
     * @param request
     * @return  查询我的所有的订单，在后台页面显示出来
     */
    @GetMapping("/MyOrder")
    public String MyOrder(HttpServletRequest request) {
        List<Shopcardto> list = fsGoodsShopcarService.findAll();
        request.setAttribute("list", list);
        return "MyOrder";
    }
}
