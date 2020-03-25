package fushuai.controller;

import fushuai.entity.FsGoods;
import fushuai.service.FsGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class detailPageController {
    private final FsGoodsService fsGoodsService;

    public detailPageController(FsGoodsService fsGoodsService) {
        this.fsGoodsService = fsGoodsService;
    }

    /**
     * 商品详情页
     * @param request 将商品的信息 放入resquestScope中
     * @param id   商品的id
     * @return  根据商品的id查询商品信息，放入resquestScope中，跳到跳到详情页
     */
    @GetMapping("/detailPage")
    public String detailPage(HttpServletRequest request, Integer id) {
        System.out.println(id);
        FsGoods fsGoods = fsGoodsService.selectByPrimaryKey(id);
        System.out.println(fsGoods.getIntime() + "上架时间");
        request.setAttribute("good", fsGoods);
        return "derailPage";
    }
}
