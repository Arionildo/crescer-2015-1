//EXERCÍCIO 01
$(".module");
$("#myList:nth-child(2)");
$("#search label[for='q']");
$("img[alt]").length;
$("tbody tr:even").length;
$("h2:contains('B'):contains('e')").length;
$("#myList li:not(.current)");
$("img:last, h3:last");
$("#myList .current ~ li").text().length;
//------------------------------------------------------


//EXERCÍCIO 02

//------------------------------------------------------


//EXERCÍCIO 03
$("div.module").last().after(
	$("<div/>").addClass("module").append(
		$("img:eq(0)").clone()));
//------------------------------------------------------