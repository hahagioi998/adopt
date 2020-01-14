package club.controller;

import club.pojo.AdoptAnimal;
import club.service.AdoptAnimalService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("adopt")
public class AdoptAnimalController {

    @Resource
    private AdoptAnimalService aas;
    @RequestMapping("/adopts")
    @ResponseBody
    public Message adopts(@RequestParam(required = false) String adoptTime,@RequestParam(required = false,value = "pn") Integer pageNum){
        int pageSize = 3 ;
        if(pageNum == null){
            pageNum = 1;
        }
        PageInfo<AdoptAnimal> pageInfo = aas.all(adoptTime, pageNum, pageSize);
        return Message.success().add("pageInfo",pageInfo);
    }

    @RequestMapping("/disAgree")
    @ResponseBody
    public Message disAgree(Integer id){
        int update = aas.update(id, 0);
        if(update>0){
           return Message.success();
        }
        return Message.fail();
    }

    @RequestMapping("/agree")
    @ResponseBody
    public Message agree(Integer id){
        System.out.println(id);
        int update = aas.update(id, 2);
        if(update>0){
            return Message.success();
        }
        return Message.fail();
    }
}
