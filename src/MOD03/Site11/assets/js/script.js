function main() {
	var noticias = $("#noticias");

	$.ajax({
		url: "http://content.guardianapis.com/search?q=manchester%20united&api-key=test",
		type: "GET"
	}).done(function(res) {
		console.log(res.response.results.forEach(function(i) {
			noticias.append(
				$("<li>").append(
					$("<a>")
					.attr("target", "_blank")
					.attr("href", i.webUrl)
					.text(i.webTitle)));
		}));
	});
}