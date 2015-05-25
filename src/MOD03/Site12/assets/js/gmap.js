var map;
var infoWindow;

//CÃ¡lculo do raio
var rad = function(x) {
   return x * Math.PI / 180;
};

var getDistance = function(p1, p2) {
   var R = 6378137; // Raio
   var dLat = rad(p2.lat - p1.lat);
   var dLong = rad(p2.lng - p1.lng);
   var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(rad(p1.lat)) * Math.cos(rad(p2.lat)) * Math.sin(dLong / 2) * Math.sin(dLong / 2);
   var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
   var d = R * c;
   return d; // retorna a distancia em metros
};

function ValidarTextBox(evt){
         
         evt.value = evt.value.replace(/[^a-zA-Z0-9]/g,'');
         
          
          
}

//VARIÃVEL QUE CONTÃ‰M AS POSIÃ‡Ã•ES DOS PONTOS DE COLETA
var markersData = [
   {
      lat: -30.042827946123374,
      lng: -51.21888667345047,
      nome: "Sua localizaÃ§Ã£o",
      site: "",
      telefone: "",
      morada1:"",
      morada2: "",
      codPostal: "",
      horario: ""
   },
   {
      lat: -30.047318,
      lng: -51.215622,
      nome: "Procempa",
      site: "procempa.com.br",
      telefone: "(51) 3289-6000",
      morada1:"Avenida Ipiranga, 1200 - Azenha",
      morada2: "Porto Alegre - RS",
      codPostal: "90160-091",
      horario: "Seg. Ã  Sex. 08:30 â€“ 17:30"
   },
   {
      lat: -30.028155,
   	lng: -51.219750,
   	nome: "DMLU - Capatazia ConceiÃ§Ã£o",
   	site: "portoalegre.rs.gov.br",
   	telefone: "(51) 3226-1950",
   	morada1:"Rua Alberto Bins s/nÂº, Centro HistÃ³rico",
   	morada2: "Porto Alegre - RS",
   	codPostal: "90030-142",
   	horario: ""
   },
   {
      lat: -30.019153,
   	lng: -51.204620,
   	nome: "DMLU - SeÃ§Ã£o Norte",
   	site: "portoalegre.rs.gov.br",
   	telefone: "(51) 3268-8330",
   	morada1:"Travessa Carmen, 111, Floresta",
   	morada2: "Porto Alegre - RS",
   	codPostal: "90560-040",
   	horario: ""
   },
   {
      lat: -30.079770,
      lng: -51.201854,
      nome: "DMLU - Capatazia da GlÃ³ria",
      site: "",
      telefone: "(51)3332-0340",
      morada1:"R Prof. Carvalho de Freitas, 1012, Cascata",
      morada2: "Porto Alegre - RS",
      codPostal: "91720-090",
      horario: ""
   },
   {
      lat: -29.997990,
      lng: -51.140869,
      nome: "Loja Leroy Merlin",
      site: "leroymerlin.com.br",
      telefone: "",
      morada1:"Avenida SertÃ³rio, 6767, Sarandi",
      morada2: "Porto Alegre - RS",
      codPostal: "91110-581",
      horario: "Seg. Ã  sex. 8:00 Ã s 22:00, Dom. 10:00 Ã s 20:00"



   }
];


function initialize() {

  
   var endereco = document.getElementById("caixaPesquisa").value;
   var loc=[];
   var geocoder;
   geocoder = new google.maps.Geocoder();

    geocoder.geocode( { 'address': endereco}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        markersData[0].lat = loc[0] = results[0].geometry.location.lat();
        markersData[0].lng = loc[1] = results[0].geometry.location.lng();


      } else {
        loc[0] = markersData[0].lat;
        loc[1] = markersData[0].lng;
      }

      
      var mapOptions = {
            center: new google.maps.LatLng(-30.0329784324,),
            zoom: 14,
            mapTypeId: 'roadmap'
         };

         map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

         // cria a nova Info Window com referÃªncia Ã  variÃ¡vel infowindow
         // o conteÃºdo da Info Window serÃ¡ atribuÃ­do mais tarde
         infoWindow = new google.maps.InfoWindow();

         // evento que fecha a infoWindow com click no mapa
         google.maps.event.addListener(map, 'click', function() {
            infoWindow.close();
         });

         // Chamada para a funÃ§Ã£o que vai percorrer a informaÃ§Ã£o
         // contida na variÃ¡vel markersData e criar os marcadores a mostrar no mapa
         displayMarkers();
    });

   
}
google.maps.event.addDomListener(window, 'load', initialize);

// Esta funÃ§Ã£o vai percorrer a informaÃ§Ã£o contida na variÃ¡vel markersData
// e cria os marcadores atravÃ©s da funÃ§Ã£o createMarker
function displayMarkers(){

   // esta variÃ¡vel vai definir a Ã¡rea de mapa a abranger e o nÃ­vel do zoom
   // de acordo com as posiÃ§Ãµes dos marcadores
   var bounds = new google.maps.LatLngBounds();
   
   // Loop que vai estruturar a informaÃ§Ã£o contida em markersData
   // para que a funÃ§Ã£o createMarker possa criar os marcadores 
   for (var i = 0; i < markersData.length; i++){

      var latlng = new google.maps.LatLng(markersData[i].lat, markersData[i].lng);
      var nome = markersData[i].nome;
      var site = markersData[i].site;
      var telefone = markersData[i].telefone;
      var morada1 = markersData[i].morada1;
      var morada2 = markersData[i].morada2;
      var codPostal = markersData[i].codPostal;
      var horario = markersData[i].horario;

      createMarker(latlng, nome, site, telefone, morada1, morada2, codPostal, horario);

      // Os valores de latitude e longitude do marcador sÃ£o adicionados Ã 
      // variÃ¡vel bounds
      bounds.extend(latlng);  
   }



   //PEGA O MARCADOR MAIS PRÃ“XIMO DA PESSOA
   var posicaoAtual = markersData[0];
   var localMaisProximo = 1000000000000;
   var respostaDaDistancia;
   var paragrafoDeTeste = document.getElementById("distancia");
   
   
   for (var i = 1; i < markersData.length; i++) {
      //var posicaoFinal = ;
      var novaDistancia = getDistance(posicaoAtual, markersData[i]).toFixed(2);
	  novaDistancia = parseFloat(novaDistancia);

      if (novaDistancia < localMaisProximo) {
         localMaisProximo = novaDistancia;
         
      }

      
      //localMaisProximo = novaDistancia < localMaisProximo ? ;
   };

   
   respostaDaDistancia = "A distancia entre vocÃª e o ponto de coleta mais prÃ³ximo Ã© de "+ localMaisProximo + " metros.";
   paragrafoDeTeste.innerHTML = respostaDaDistancia;



   // Depois de criados todos os marcadores
   // a API atravÃ©s da sua funÃ§Ã£o fitBounds vai redefinir o nÃ­vel do zoom
   // e consequentemente a Ã¡rea do mapa abrangida.
   //map.fitBounds(bounds);
}

// FunÃ§Ã£o que cria os marcadores e define o conteÃºdo de cada Info Window.
function createMarker(latlng, nome, site, telefone, morada1, morada2, codPostal, horario){
   
   if(nome == "Sua localizaÃ§Ã£o") {
      var marker = new google.maps.Marker({
         map: map,
         position: latlng,
         title: nome
      });
   } else {
      var marker = new google.maps.Marker({
         map: map,
         position: latlng,
         title: nome,
         icon: "assets/imagens/icon.png"
      });
   }

   // Evento que dÃ¡ instruÃ§Ã£o Ã  API para estar alerta ao click no marcador.
   // Define o conteÃºdo e abre a Info Window.
   google.maps.event.addListener(marker, 'click', function() {
      
      // VariÃ¡vel que define a estrutura do HTML a inserir na Info Window.
      var iwContent = '<div id="iw_container">' +
            '<div class="iw_title">' + nome + '</div>' +
         '<div class="iw_content">' +
         site + '<br />' +
         telefone + '<br />' +
         morada1 + '<br />' +
         morada2 + '<br />' +
         codPostal + '<br />' +
         horario + '<br />' +
         '</div></div>';
      
      // O conteÃºdo da variÃ¡vel iwContent Ã© inserido na Info Window.
      infoWindow.setContent(iwContent);

      // A Info Window Ã© aberta.
      infoWindow.open(map, marker);
   });
}