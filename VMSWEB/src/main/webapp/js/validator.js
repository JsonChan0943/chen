$(function(){    
	$("form :input.required").each(function(){   
		var $required = $("<strong class='high' style='color:red'> *</strong>"); //创建元素   
		$(this).parent().append($required); //然后将它追加到文档中  
	});  
	//文本框失去焦点后  
	$('form :input').blur(function(){    
		var $parent = $(this).parent();    
		$parent.find(".formtips").remove(); 
		//验证用户名    
		if( $(this).is('#username') ){     
			if( this.value=="" || this.value.length ==0 ){      
				var errorMsg = '用户名必填.';      
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');     
			}else{      
				var okMsg = 'OK.';      
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');     
			}    
		}   
		//验证密码
		if($(this).is('#password')){
			if(this.value==''||this.value.length==0){
				var errorMsg = '密码必填.';
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//验证昵称
		if($(this).is("#nickname")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "昵称必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//验证手机号码 
		if(($(this).is('#phonenumber'))||($(this).is("#edit_telephone"))){
			if(this.value==""||(!$(this).val().match(/^[1][3|8|5|4|7][0-9]{9}$/))){
				var errorMsg = '请输入正确的手机号码.';
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//验证邮件    
		if( $(this).is('#email') ){   
			if( this.value=="" || ( this.value!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value) ) ){      
				var errorMsg = '请输入正确的eMail地址.';      
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');    
			}else{      
				var okMsg = 'OK.';      
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');    
			}    
		}  
		//验证部门
		if($(this).is("#dept")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "部门必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//验证地址    
		if(($(this).is('#address'))||($(this).is('#edit_address'))){   
			if( this.value=="" || this.value.length==10){      
				var errorMsg = '地址必填.';      
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');    
			}else{      
				var okMsg = 'OK.';      
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');    
			}    
		} 
		//公司id必填
		if($(this).is("#company_id")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "公司id必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//公司名称必填
		if(($(this).is("#company_name"))||($(this).is("#edit_company_name"))){
			if(this.value==""||this.value.length==0){
				var errorMsg = "公司名称必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//公司manager必填
		if(($(this).is("#manager"))||($(this).is("#edit_manager"))){
			if(this.value==""||this.value.length==0){
				var errorMsg = "公司总经理必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//设备名称必填
		if(($(this).is("#car_name"))||($(this).is("#edit_name"))){
			if(this.value==""||this.value.length==0){
				var errorMsg = "设备名称必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//设备型号必填
		if(($(this).is("#car_type"))||($(this).is("#edit_type"))){
			if(this.value==""||this.value.length==0){
				var errorMsg = "设备型号必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//车牌号
		if(($(this).is("#plate_num"))||($(this).is("#edit_plate_num"))){
			if(this.value==""||this.value.length==0){
				var errorMsg = "车牌号必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//承租方必填 
		if($(this).is("#sbook_lessee")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "承租方必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//出租方必填 
		if($(this).is("#sbook_lease")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "出租方必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//起租时间必填 
		if($(this).is("#startDate")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "起租时间必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//到租时间必填 
		if($(this).is("#endDate")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "到租时间必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//承载人必填 
		if($(this).is("#driver")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "承载人必填";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
		//备注不能为空
		if($(this).is("#comment")){
			if(this.value==""||this.value.length==0){
				var errorMsg = "备注不能为空";
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			}else{
				var okMsg = 'OK.';
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>');
			}
		}
	}).keyup(function(){   
		$(this).triggerHandler("blur");  
	}).focus(function(){   
		$(this).triggerHandler("blur");  
	}); 
	
	//对公司下拉选的处理
	$("#company,#car_origin,#edit_origin,#edit_company").each(function(){   
		var $required = $("<strong class='high' style='color:red'> *</strong>"); //创建元素   
		$(this).parent().append($required); //然后将它追加到文档中  
	});  
	$("#company,#car_origin,#edit_origin,#edit_company").change(function(){
		var $parent = $(this).parent();    
		$parent.find(".formtips").remove(); 
		if(($(this).is("#company"))||($(this).is("#edit_company"))){	
			if( this.value!='default'){      
				var okMsg = 'OK.';      
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>'); 
			}else{      
				var errorMsg = '公司必填.';      
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');     
			}    
		}
		if(($(this).is("#car_origin"))||($(this).is("#edit_origin"))){
			if( this.value!='default'){      
				var okMsg = 'OK.';      
				$parent.append('<span class="formtips onSuccess success">'+okMsg+'</span>'); 
			}else{      
				var errorMsg = '汽车来源必填.';      
				$parent.append('<span class="formtips onError error">'+errorMsg+'</span>');     
			}    
		}
	}).focus(function(){   
		$(this).triggerHandler("change");  
	}).select(function(){
		$(this).triggerHandler("change");  
	}); 
})