package fushuai.controller;


import fushuai.entity.FsGoods;
import fushuai.service.FsGoodsService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;



@Controller
public class GoodsController {
    private final FsGoodsService fsGoodsService;

    public GoodsController(FsGoodsService fsGoodsService) {
        this.fsGoodsService = fsGoodsService;
    }

    /**
     * 跳转到添加商品页
     * @return  添加商品页
     */
    @GetMapping("/addGoods")
    public String addGoods() {
        return "addGoods";
    }

    /**
     * 添加商品
     * @param fsGoods  获取的商品信息
     * @return  添加成功返回后台商品列表
     */
    @PostMapping("/addGood")
    public String addGood(FsGoods fsGoods) {
     int  a=   fsGoodsService.insertSelective(fsGoods);
        System.out.println(a+"添加chengg");
        return "redirect:/selectGoods";
    }

    /**
     * 查询所有的商品
     * @param request  将查询的商品放进requestScope中
     * @return  后台商品列表页
     */
    @GetMapping("/selectGoods")
    public String SelectGoods(HttpServletRequest request) {
        List<FsGoods> list = fsGoodsService.findByAll(new FsGoods());
        request.setAttribute("list", list);
        return "SelectGoods";
    }

    /**
     * 删除商品
     * @param id  商品id
     * @return  根据商品id删除该商品
     */
    @GetMapping("/removeGoods")
    public String removeGoods(String id) {
        fsGoodsService.deleteByPrimaryKey(Integer.valueOf(id.trim()));
        return "redirect:/selectGoods";
    }
}
