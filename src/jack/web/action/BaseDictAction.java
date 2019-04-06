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
	//��Ҫ���ṩ�й������ֵ��������ֱ�ӵõ���Ӧ������
	@Override
	public String execute() throws Exception {
		//�������� �ֵ��о���һ�����������Բ���Ҫȥ�½���������ֱ����Ĭ��ֵ
		//1.����service,���BaseDice��list����
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//2.��list���ת��Ϊjson
		String json = JSONArray.fromObject(list).toString();
		//3.���������
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json); 
		return null;	//����struts����Ҫ����ҳ�洦��ֻ����ҳ���ڽ���ҵ���߼�
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
