$.ajax({
  url: "/redirecionar",
  type: "GET"
}).done(function() {
  window.location.href="/consulta";
});