
//上一页 
function previous(){
	var toPage = parseInt($('#currentPage').val())-1;
	if(toPage>0){
  		requestForThePage(toPage);
	}
}
//下一页 
function next(){
	var toPage = parseInt($('#currentPage').val())+1;
	var totalPage = $('#totalPage').val();
	if(toPage<=totalPage){
  		requestForThePage(toPage);
	}
} 
//搜索栏的隐藏与显示 
function showAndHide(){
	var temp=$("#searchForm").is(":hidden");
	if(temp){
		$("#searchForm").css('display','block'); 
	}else{
		$("#searchForm").css('display','none'); 
	}
}
//发出请求
function requestForThePage(toPage){
	$('#toPage').val(toPage);
	$('#searchForm').submit();
}