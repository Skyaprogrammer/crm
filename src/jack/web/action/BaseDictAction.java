package jack.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jack.domain.BaseDict;
import jack.service.BaseDictService;
import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{
	
	private BaseDictService baseDictService;
	private String dict_type_code;
	//主要是提供有关数据字典的下拉框直接得到对应的数据
	@Override
	public String execute() throws Exception {
		//整个数据 字典中就这一个方法，所以不需要去新建方法名，直接用默认值
		//1.调用service,获得BaseDice的list集合
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//2.将list结合转化为json
		String json = JSONArray.fromObject(list).toString();
		//3.返回浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json); 
		return null;	//告诉struts不需要进行页面处理，只是在页面内进行业务逻辑
	}
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	
	
}
