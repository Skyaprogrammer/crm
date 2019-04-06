	//动态选择 下拉选（ajax加载动态字典）
	//typecode  有三个，客户来源，公司，级别
	//positionId   下拉选所在处的ID，select，或者div
	//selectname	选择属性的姓名属性
	//selectedId	选中标签的id，回显值
	function loadSelect(typecode,positionId,selectname,selectedId){
		
		//1.先创建一个select对象，将name属性指定（用jquery方便）
		var $select = $("<select name="+selectname+"></select>");//新建jquery对象都是要加入美元符号
		
		//2.添加提示选项  eg：------请选择---------
		$select.append($("<option value=''>----请选择----</option>"));
		//3.将其他的数据进行ajax获取、
		$.post(
				//url,data,callback,type
			"${pageContext.request.contextPath}/BaseDictAction",
			{dict_type_code:typecode},
			function(data){
				$.each( data, function(i, json){
					var $option = $("<option value='"+json["dict_id"]+"'>"+json["dict_item_name"]+"</option>")
					//加一個判斷，如果显示和我们得到的数据一致，直接回显
					if(json["dict_id"] == selectedId){
						$option.attr("selected","selected");
					}
					$select.append($option);
				});
			},
			"json"
				);
		//4.返回json，遍历数组
			//每次遍历创建option并且添加到1中的select对象中（加判断，是否需要回显）
		
		//5.将组装好的select放入div中，就是positionId
		$("#"+positionId).append($select);
	}