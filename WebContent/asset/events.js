
$('document').ready(function(){
	function showEvent(data)
	{var htm='<link href="asset/bootstrap.min.css" rel="stylesheet" type="text/css"><link href="admin/main/css/style.css" rel="stylesheet">'
		$.each(data,function(index,item){
			htm+="<table class='table table-bordered' style='width:80%; font-size:12px;'><tr>";
			htm+="<td style='text-align: center; vertical-align: middle;'><img class='img-responsive' src=images/"+item.ICON+" width='80' height='80'></td><td valign='top'><b>Event:</b>"+item.EVENTNAME+" [Duration:"+item.DAYS+"] Organized by "+item.ORGANIZEDBY+"<br>";
			htm+="<b>Date:</b>"+item.EVENTDATE+"<br>";
			htm+="<b>Timings:</b> From "+item.TIMESTART+" to "+item.TIMEEND+"<br>";
			htm+="<b>Venue:</b>"+item.ADDRESS+","+item.EVENTCITY+","+item.EVENTSTATE+"<br></td>";
			htm+="<td style='text-align: center; vertical-align: middle;'><input  type=button class='btnapply btn btn-info' eventid='"+item.EVENTID+"'eventname='"+item.EVENTNAME+"' value='Apply Now'></td></tr></table><br>";
		});
			 
	   return(htm);	
	}
$.getJSON('AllEventJSON',{ajax:true,param:''},function(data){
        htm=showEvent(data);
        $('#result').html(htm);	 
     });	 

 
	
$('#event').keyup(function(){
	$.getJSON('AllEventJSON',{ajax:true,param:$('#event').val()},function(data){
		 htm=showEvent(data);
		});	 
		$('#result').html(htm);	 
		 });	
	 
 
 $('#result').on('click','.btnapply',function(){
	// alert($(this).attr('eventid')+","+$(this).attr('eventname'));
	 qs="eventid="+$(this).attr('eventid')+"&eventname="+$(this).attr('eventname')
	 window.location.href='UserLogin?'+qs; 
 });
 
 
 
});