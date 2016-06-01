// <![CDATA[


	var map = new Map();

	map.init('map', -20.200404, -40.228925, 13, 'roadmap', false);
	map.setAjaxStatus(1);
	map.updateMapsView();



	// AJAX CHANGE CONTENT
		$(document).on('click', 'ul.menu li a', function(e){
			e.preventDefault();
			var $handle = $(this);
			if($handle.hasClass('selected')){ return(false); }
			
			var $box = $('#ajax-content');
			var urlLink = $handle.attr('href').split('|');
			var method = urlLink[1];
			urlLink = urlLink[0];


			$handle.parents('ul.menu').find('a.selected').removeClass('selected');
			$handle.addClass('selected');
			map.setAjaxStatus(0);
			
			$box.stop(true, true).fadeOut('fast', function(){
				$.ajax({
					url: urlLink,
					type: 'post',
					dataType: 'json',
					data: {
						'method': method
					}
				}).done(function(data){
					$box.html(data.html);

					$box.stop(true, true).fadeIn('fast', function(){

						if(/^(get-map-content){1}$/.test(method)){
							map.init('map', -20.200404, -40.228925, 13, 'roadmap', false);
							map.setAjaxStatus(1);
							map.updateMapsView();
						}
						else if(/^(get-form-create-place|get-form-update-place){1}$/.test(method)){
							map.init('map', -20.200404, -40.228925, 13, 'roadmap', true);
						}

					});
				});
			});
		});




	//FORMS
		// CREATE PLACE
			$(document).on('submit', '#form-create-place', function(e){
				e.preventDefault();

				var $form = $(this);
				var $submit = $('#fo-submit');
				var idPlace = $('#fo-place').length > 0 ? Number( $('#fo-place').val() ) : 0;
				var method = $('#fo-place').length > 0 ? 'update-place' : 'create-place';
				var name = $.trim( $('#fo-name').val() );
				var category = Number( $('#fo-category').val() );
				var description = $.trim( $('#fo-description').val() );
				var latitude = $('#fo-latitude').val();
				var longitude = $('#fo-longitude').val();
				var status = $('#fo-status').is(':checked') ? 1 : 0;

					var error = '';
					if($('#fo-place').length > 0 && idPlace == 0){
						error += 'Escolha um place;\n'
					}
					else {
						if(name.length == 0){
							error += 'Forneça o nome do place;\n'
						}
						if(category == 0){
							error += 'Escolha uma categoria;\n'
						}
						if(description.length == 0){
							error += 'Forneça umadescrição para o place;\n'
						}
					}
					if(error.length > 0){
						alert(error);
						return;
					}

				$form.find('input, textarea, select, button').each(function(){
					$(this).attr('disabled', true);
				});
				$submit.html(idPlace > 0 ? 'Atualizando...' : 'Salvando...');
				$.ajax({
					url: map.URL,
					type: 'post',
					dataType: 'json',
					data: {
						'method': method,
						'id-place': idPlace,
						'name': name,
						'category': category,
						'description': description,
						'latitude': latitude,
						'longitude': longitude,
						'status': status
					}
				}).done(function(data){
					$submit.html(idPlace > 0 ? 'Atualizar' : 'Salvar');
					$form.find('input, textarea, select, button').each(function(){
						$(this).attr('disabled', false);
					});

					if(Number(data.feedback) == 1){
						if(idPlace == 0){
							alert('Place criado com sucesso!');
							$('#fo-name').val('');
							$('#fo-category').val(0);
							$('#fo-description').val('');
							$('#fo-latitude').val('-20.200404');
							$('#fo-longitude').val('-40.228925');
							$('#fo-status').prop('checked', true);
							$('#map').html('');
							$('#map-search').val('');
							map.init('map', -20.200404, -40.228925, 13, 'roadmap', true);
						}
						else{
							alert('Place atualizado com sucesso!');
						}
					}
					else{
						alert('FALHOU! Reveja o formulário e tente novamente.');
					}
				});
			});


		// SELECT PLACE FOR UPDATE
			$(document).on('change', '#fo-place', function(){
				var $handle = $(this);
				
				if( Number( $handle.val() ) == 0){
					$('#fo-name').val('');
					$('#fo-category').val(0);
					$('#fo-description').val('');
					$('#fo-latitude').val('-20.200404');
					$('#fo-longitude').val('-40.228925');
					$('#fo-status').prop('checked', true);
					$('#map').html('');
					$('#map-search').val('');
					map.init('map', -20.200404, -40.228925, 13, 'roadmap', true);
				}
				else{
					$.ajax({
						url: map.URL,
						type: 'post',
						dataType: 'json',
						data: {
							'method': 'get-place-data',
							'id-place': $handle.val()
						}
					}).done(function(data){
						$('#fo-name').val( data.place.name );
						$('#fo-category').val( data.place.category.item );
						$('#fo-description').val( data.place.description );
						$('#fo-latitude').val( data.place.latitude );
						$('#fo-longitude').val( data.place.longitude );
						$('#fo-status').prop('checked', Number( data.place.status ) == 1 ? true : false);

						$('#map').html('');
						$('#map-search').val('');
						map.init('map', Number( data.place.latitude ), Number( data.place.longitude ), 13, 'roadmap', true);
					});
				}
			});









	// USEFUL
		function Map(){
			// ATTRIBUTES
				this.myLatlng = null;
				this.time_name = null;
				this.mapOptions = null;
				this.map = null;
				this.pin = null;
				this.marker = null;
				this.input = null;
				this.autocomplete = null;
				this.ajaxStatus = 0;

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
						var markerAux = this.marker;
						this.input = document.getElementById('map-search');
						this.autocomplete = new google.maps.places.Autocomplete(this.input);
						this.autocomplete.bindTo('bounds', this.map);

						google.maps.event.addListener( this.autocomplete, 'place_changed', function(){
							var place = map.autocomplete.getPlace(); // map variable global, not of the class
							if(!place.geometry){
								return;
							}

							// If the place has a geometry, then present it on a map.
							if(place.geometry.viewport) {
								map.fitBounds(place.geometry.viewport); // map variable global, not of the class
							}
							else{
								map.setCenter(place.geometry.location); // map variable global, not of the class
							}
							markerAux.setPosition(place.geometry.location);
							map.setCenter(place.geometry.location); // map variable global, not of the class
							map.atualizaValorHiddenGeo(place.geometry.location); // map variable global, not of the class
						});
						
						// start EVENTS
							google.maps.event.addListener( this.marker, 'mouseout', function(event){
								map.toggleBounce(event.latLng); // map variable global, not of the class
							});
							google.maps.event.addListener(map, 'click', function(event) {
								map.addMarker(event.latLng); // map variable global, not of the class
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
					//this.marker.setIcon('./img/pinsdg.png');
					this.map.setCenter(latLng);
					this.atualizaValorHiddenGeo(latLng);
				}

				
				Map.prototype.toggleBounce = function(latLng) {
					this.atualizaValorHiddenGeo(latLng);
				}
				

				Map.prototype.atualizaValorHiddenGeo = function(latLng){
					if( $('#fo-latitude').length > 0 ){
						document.getElementById('fo-latitude').value = latLng.lat();
						document.getElementById('fo-longitude').value = latLng.lng();
					}
				}


				Map.prototype.fitBounds = function(obj) {
					this.map.fitBounds(obj);
				}

				Map.prototype.setCenter = function(obj) {
					this.map.setCenter(obj);
				}


				Map.prototype.updateMapsView = function(){
					if(this.ajaxStatus == 0){
						return;
					}

					this.ajaxReference = $.ajax({
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


				Map.prototype.setAjaxStatus = function(status){
					this.ajaxStatus = status;
				}
		}
// ]]>