package com.chartwithmongo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.chartwithmongo.model.Fruit;
import com.chartwithmongo.service.MongoService;

@Controller
public class MongoChartController {
@Autowired
private MongoService mongoService;

@RequestMapping(value ="/mongo", method = RequestMethod.GET)
public String FruitList(ModelMap model){
	model.addAttribute("fruitList", mongoService.listFruit());
	model.addAttribute("fruit", new Fruit());
	return "index";  /* String returned will be resolved into output.jsp by view resolver */ 
}

@RequestMapping(value = "/mongo/save", method = RequestMethod.POST)  
public View createFruit(@ModelAttribute Fruit fruit, ModelMap model) { 
	System.out.println("Fname:" + fruit.getFrName());
	System.out.println("FId:" + fruit.getF_id());
	
	mongoService.addFruit(fruit);
	
	return new RedirectView("/MongoWeb/mongo"); /*  control goes to getBookList() which is mapped to /mongo*/   
}


}
