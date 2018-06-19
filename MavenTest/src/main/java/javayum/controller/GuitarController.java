package javayum.controller;

import javayum.domain.*;
import javayum.service.GuitarService;
import javayum.service.GuitarSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Controller
public class GuitarController {

    @Autowired
    @Qualifier("GuitarService")
    private GuitarService guitarService;

    @Autowired
    @Qualifier("GuitarSpecService")
    private GuitarSpecService guitarSpecService;


    //首页
    @RequestMapping(value="/index")
    public String index(Model model){
        List<Guitar> guitars=guitarService.findAll();

        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            //查询guitar
            Guitar guitar1=guitarService.selectGuitar(guitar.getId());
            matchingGuitars.add(guitar1);
        }
        model.addAttribute("matchingGuitars",matchingGuitars);
        return "index";
    }


    //处理提交表单查询
    @RequestMapping(value="/search")
    public String selectGuitar(Model model, @RequestParam String builder,@RequestParam String model1,
                               @RequestParam String type,@RequestParam String topWood,@RequestParam String backWood,
                               @RequestParam String numStrings) {
        //初始化,同时对数据库进行操作,仅供一次使用
        guitarSpecService.insertGuitarSpec();
        guitarService.addGuitar();

        Integer numStrings1=Integer.valueOf(numStrings).intValue();
      //创建之后查询这样的spec
        guitarSpecService.addSpec(builder,model1,type,numStrings1,backWood,topWood);
        //获取 guitars的List
        List<Guitar> guitars=guitarService.findAll();
        System.out.println(guitars);

        //根据表单提交的是数据来构造函数
        GuitarSpec whatErinLikes =guitarSpecService.formmer();
        //查询符合要求的guitar，得到matchingGuitars
        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            //查询guitar
            Guitar guitar1=guitarService.selectGuitar(guitar.getId());
            if (guitar1.getSpec().matches(whatErinLikes))
                matchingGuitars.add(guitar1);
        }
        model.addAttribute("matchingGuitars",matchingGuitars);
        return "index";
    }
}
