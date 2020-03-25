package fushuai.controller;

import fushuai.dto.Shopcardto;
import fushuai.entity.FsGoodsShopcar;
import fushuai.entity.FsMember;
import fushuai.entity.Member;
import fushuai.service.FsGoodsShopcarService;
import fushuai.service.FsMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class ShopCarController {
    private final FsMemberService fsMemberService;
    private final FsGoodsShopcarService fsGoodsShopcarService;

    public ShopCarController(FsGoodsShopcarService fsGoodsShopcarService, FsMemberService fsMemberService) {
        this.fsGoodsShopcarService = fsGoodsShopcarService;
        this.fsMemberService = fsMemberService;
    }

    /**
     * 查询该用户购物车中的所有商品
     * @param request
     * @return   在购物车页面中显示
     */
    @GetMapping("/shopcar")
    public String shopcar(HttpServletRequest request) {
        Member fsMember = (Member) request.getSession().getAttribute("user");
        List<Shopcardto> list = fsGoodsShopcarService.findByMemberId(fsMember.getId());
        int moneytotal = 0;
        int numtotal = 0;
        for (Shopcardto shopcardto : list) {
            numtotal += shopcardto.getNum();
            moneytotal += (shopcardto.getNum() * shopcardto.getNowprice());
        }
        request.setAttribute("moneytotal", moneytotal);
        request.setAttribute("numtotal", numtotal);
        request.setAttribute("list", list);
        return "shopcar";
    }

    /**
     * 添加商品到购物车中
     * @param fsGoodsShopcar  商品信息
     * @return  添加成功返回到首页
     */
    @GetMapping("/addgoodsinshopcar")
    public String addgoodsinshopcar(FsGoodsShopcar fsGoodsShopcar) {
        fsGoodsShopcar.setCreatetime(new Date());
        fsGoodsShopcar.setNum(1);
        fsGoodsShopcarService.insertSelective(fsGoodsShopcar);
        return "index";
    }

    /**
     * 查看该用户的所有订单
     * @param request
     * @return 返回我的订单页
     */
    @GetMapping("/shopcarsettle")
    public String shopcarsettle(HttpServletRequest request) {
        Member fsMember = (Member) request.getSession().getAttribute("user");
        List<Shopcardto> list = fsGoodsShopcarService.findByMemberId(fsMember.getId());
        int moneytotal = 0;
        int numtotal = 0;
        for (Shopcardto shopcardto : list) {
            numtotal += shopcardto.getNum();
            moneytotal += (shopcardto.getNum() * shopcardto.getNowprice());
        }
       /* if (fsMember.getMoney()+moneytotal>10000&&fsMember.getMoney()+moneytotal<100000){
            //更新数据库中的角色折扣count-0.1
        }else if (fsMember.getMoney()+moneytotal>100000&&fsMember.getMoney()+moneytotal<500000){
            //更新数据库中的角色折扣count-0.3
        }else {
            //更新数据库中的角色折扣count-0.5
        }*/
        request.setAttribute("moneytotal", moneytotal);
        request.setAttribute("numtotal", numtotal);
        request.setAttribute("list", list);
        return "shopcarsettle";
    }

    /**
     * 在我的订单中修改收货地址
     * @param fsMember 获取用户id 和收货地址
     * @return  ajax一步请求，修改成功，直接可以看到
     */
    @PostMapping("/updateInfo")
    @ResponseBody
    public String updateInfo(@RequestBody FsMember fsMember) {
        String result = "更新失败";
        System.out.println(fsMember+"传参对象");
        int a = fsMemberService.updateByPrimaryKeySelective(fsMember);
        System.out.println(a+"更新地址后的返回类型");
        if (a==1){
            result="更新成功";
        }
        return result;
    }
}
