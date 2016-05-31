// <![CDATA[


	var map = new Map();

	map.init('ajax-content', -20.200404, -40.228925, 13, 'roadmap', false);
	map.updateMapsView();



	// USEFUL
		function Map(){
			// ATTRIBUTES
				this.myLatlng = null;
				this.time_name = null;
				this.mapOptions = null;
				this.map = null;
				this.pin = null;
				this.pin = null;
				this.marker = null;
				this.input = null;
				this.autocomplete = null;

				this.URL = 'package/ctrl/CtrlMap.php';
				this.METHOD_UPDATE_COORDS = 'get-last-map-coords';


			// METHODS
				Map.prototype.init = function(idBox, latitude, longitude, zoom_map, map_type, lock_eventos, pin){
					this.myLatlng = new google.maps.LatLng(latitude, longitude);
					this.time_name = idBox.split('-');
					this.mapOptions = {
						center: this.myLatlng,
						zoom: zoom_map,
						mapTypeId: map_type
					};
					
					this.map = new google.maps.Map(document.getElementById(idBox), this.mapOptions);
					
					this.pin = (pin == undefined || pin.length == 0) ? './img/pin.png' : pin;
					this.marker = new google.maps.Marker({
						map: this.map,
						position: this.myLatlng,
						icon: this.pin,
						draggable:true,
						animation: google.maps.Animation.DROP
					});


					if(lock_eventos){
						this.input = document.getElementById('fct-location');
						this.autocomplete = new google.maps.places.Autocomplete(this.input);
						this.autocomplete.bindTo('bounds', map);

						google.maps.event.addListener( this.autocomplete, 'place_changed', function(){
							var place = autocomplete.getPlace();
							if(!place.geometry){
								return;
							}

							// If the place has a geometry, then present it on a map.
							if(place.geometry.viewport) {
								map.fitBounds(place.geometry.viewport);
							}
							else{
								map.setCenter(place.geometry.location);
							}
							marker.setPosition(place.geometry.location);
							map.setCenter(place.geometry.location);
							atualizaValorHiddenGeo(place.geometry.location);
						});
						
						// start EVENTS
							google.maps.event.addListener( this.marker, 'mouseout', function(event){
								this.toggleBounce(event.latLng);
							});
							google.maps.event.addListener(map, 'click', function(event) {
								this.addMarker(event.latLng);
							});
						// end EVENTS
					}
					else{
						this.marker.setDraggable(false);
					}
				}


				Map.prototype.setupClickListener = function(id, types) {
					var radioButton = document.getElementById(id);
					google.maps.event.addDomListener(radioButton, 'click', function(){
						autocomplete.setTypes(types);
					});
				}

				
				Map.prototype.addMarker = function(latLng) {
					this.marker.setPosition(latLng);
					this.map.setCenter(latLng);
					this.atualizaValorHiddenGeo(latLng);
				}

				
				Map.prototype.toggleBounce = function(latLng) {
					atualizaValorHiddenGeo(latLng);
				}
				

				Map.prototype.atualizaValorHiddenGeo = function(latLng){
					//document.getElementById('fct-latitude').value = latLng.lat();
					//document.getElementById('fct-longitude').value = latLng.lng();
				}


				Map.prototype.updateMapsView = function(){
					$.ajax({
						url: this.URL,
						type: 'post',
						dataType: 'json',
						data: {
							'method': this.METHOD_UPDATE_COORDS
						}
					}).done(function(data){
						//alert(data);
						map.addMarker( new google.maps.LatLng( Number( data.map.latitude ) , Number( data.map.longitude ) ) );

						setTimeout(function(){
							map.updateMapsView()	
						}, 5000);
					});
				}
		}
// ]]>