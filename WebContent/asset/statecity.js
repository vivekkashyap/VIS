$('document').ready(function(){
$.getJSON('FetchAllStatesJSON',{ajax:true},function(data){
  $.each(data,function(index,item){
	$('#states').append($('<option>').text(item.STATENAME).val(item.STATEID));	
  });
});	
$('#states').change(function(){
	$.getJSON('FetchAllCitiesJSON',{ajax:true,stateid:$('#states').val()},function(data){
		 $('#city').empty();
			$('#city').append($('<option>').text('-City-'));	
		$.each(data,function(index,item){
			$('#city').append($('<option>').text(item.CITYNAME).val(item.CITYID));	
		  });	
	
});});
	
});