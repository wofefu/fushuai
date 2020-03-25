package fushuai.controller;


import fushuai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class houtaiController {
    final
    UserService uSer;

    public houtaiController(UserService uSer) {
        this.uSer = uSer;
    }

    /**
     * 查询所有的用户
     * @param pageon  当前页数
     * @return   返回后台用户列表详情页
     */
    @GetMapping("/userlist")
        public ModelAndView userlist(@RequestParam(value = "pageon", defaultValue = "1") int pageon
    ) {

            ModelAndView mv=new ModelAndView();
            mv.addAllObjects(uSer.UserList(pageon));
            mv.setViewName("userlist");
            return mv;
    }

    /**
     * 删除用户
     * @param id   用户id
     * @param pageon  当前页数
     * @return   返回后台用户列表详情页
     */
    @GetMapping("/remove")
    public ModelAndView remove(String id,@RequestParam(value = "pageon", defaultValue = "1") int pageon){
        System.out.println(id);
        boolean flag=  uSer.dropMember(Integer.valueOf(id));
        ModelAndView mv=new ModelAndView();
        mv.addAllObjects(uSer.UserList(pageon));
        mv.setViewName("userlist");
        return mv;
    }
}
