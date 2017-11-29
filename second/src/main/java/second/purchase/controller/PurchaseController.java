package second.purchase.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import second.common.common.CommandMap;
import second.sample.service.SampleService;

@Controller
public class PurchaseController {
	Logger log = Logger.getLogger(this.getClass());
	
    @Resource(name="sampleService")
    private SampleService sampleService;

	//인터셉터 및 기본 컨트롤러
	@RequestMapping(value="/sample/openBoardList.do")
	public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardList");
        //log.debug("인터셉터 테스트");
        //System.out.println(commandMap);
        List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
        mv.addObject("list", list);
        //System.out.println(list);
        return mv;
    }
	
	//CustomMapArgumentResolver 테스트
	//MapArguemtResolver를 등록하지 않았다면, 컨트롤러에서 request.getParameter 메서드 등을 이용하여 하나씩 가져와야 함
	@RequestMapping(value="/sample/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("");
	     
	    if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
	    return mv;
	}
	
	//submit 테스트(writeForm)
	@RequestMapping(value="/sample/openBoardWrite.do")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/sample/boardWrite");
	     
	    return mv;
	}
	
	//submit 테스트(insert)
	@RequestMapping(value="/sample/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
	     
	    sampleService.insertBoard(commandMap.getMap());
	     
	    return mv;
	}

}
