$(function(){
	//콜백함수 정의
	//main서블릿에서 받은 데이터를 화면에 비동기로 출력
	function getTodos(json){
		console.log(json);
		$.each(json.data, function(index, item){
			$('#TODO').append('<div class = "resultBox">제목 : ' + item.TITLE +'<br>' +  
									 '작성자 : ' + item.NAME + 
									 '<input id = "idGetter" type = "hidden" value = "' + item.ID + '">' +  
									 '<div id = "btns"><button class = "rightBtn">>>></button></div>' +  
									 '</div>');
		});
		
	};
	
	function getDoings(json){
		console.log(json);
		$.each(json.data, function(index, item){
			$('#DOING').append('<div class = "resultBox">제목 : ' + item.TITLE +'<br>' +  
									 '작성자 : ' + item.NAME +
									 '<input id = "idGetter" type = "hidden" value = "' + item.ID + '">' +
									 '<div id = "btns"><button class = "leftBtn"><<<</button> <button class = "rightBtn">>>></button></div>' +  
									 '</div>');
		});
		
	};
	
	function getDones(json){
		console.log(json);
		$.each(json.data, function(index, item){
			$('#DONE').append('<div class = "resultBox">제목 : ' + item.TITLE +'<br>' +  
									 '작성자 : ' + item.NAME +
									 '<input id = "idGetter" type = "hidden" value = "' + item.ID + '">' + 
									 '<div id = "btns"><button class = "leftBtn"><<<</button> <button id = "deleteBtn">삭제</button></div>' +  
									 '</div>');
		});
		
	};
	
	$.ajax({
		type : "get",
		url : "main",
		data : {
			type : "TODO"
		},
		success : getTodos,
		dataType : "json"
	});
	console.log('ajax 통신 요청 TODO');
	
		$.ajax({
		type : "get",
		url : "main",
		data : {
			type : "DOING"
		},
		success : getDoings,
		dataType : "json"
	});
	console.log('ajax 통신 요청 DOING');
	
		$.ajax({
		type : "get",
		url : "main",
		data : {
			type : "DONE"
		},
		success : getDones,
		dataType : "json"
	});
	console.log('ajax 통신 요청 DONE');
	
	//우측이동버튼
	//동적으로 추가된것들에 대한 호출은 $(document).on()을 사용할 것
	$(document).on('click', '.rightBtn', function(){
		let $this = $(this);
	    let id = $('.resultBox input[id = "idGetter"]').val();
	    let type = $('.resultBox').parent().attr('id');
	    console.log('id = ' + id);
	    console.log('type = ' + type);
	    $.ajax({
			url : 'btnController',
			type : 'get',
			dataType : 'json',
			data : {
				"id" : id,
				"type" : type,
				"btnType" : 'right'
			},
			success : function(json){
				console.log('콜백함수 실행');
				$.each(json.data, function(index, item){
					let title = item.TITLE;
					let name = item.NAME;
					let newId = item.ID;
					let newType = item.TYPE;
					
					console.log('title : ' + title + 'name : ' + name + 'newId : ' + newId + 'newType : ' + newType);
					
					$this.parent().parent().remove();
					
					if(newType == 'DOING'){
						$('#' + newType).append('<div class = "resultBox">제목 : ' + title +'<br>' +  
								 				  '작성자 : ' + name +
												  '<input type = "hidden" value = "' + newId + '">' + 
												  '<div id = "btns"><button class = "leftBtn"><<<</button> <button class = "rightBtn">>>></button></div>' +  
												  '</div>');		
					} else if(newType == 'DONE'){
						$('#' + newType).append('<div class = "resultBox">제목 : ' + item.TITLE +'<br>' +  
												 '작성자 : ' + item.NAME + 
												 '<input type = "hidden" value = "' + item.ID + '">' +
												 '<div id = "btns"><button class = "leftBtn"><<<</button> <button class = "deleteBtn">삭제</button></div>' +  
												 '</div>');
					}
	
				});
				
			} 
		});
	});
	
	$(document).on('click', '.leftBtn', function(){
		let $this = $(this);
	    let id = $('.resultBox input[id = "idGetter"]').val();
	    let type = $('.resultBox').parent().attr('id');
	    console.log('id = ' + id);
	    console.log('type = ' + type);
	    $.ajax({
			url : 'btnController',
			type : 'get',
			dataType : 'json',
			data : {
				"id" : id,
				"type" : type,
				"btnType" : 'left'
			},
			success : function(json){
				console.log('콜백함수 실행');
				$.each(json.data, function(index, item){
					let title = item.TITLE;
					let name = item.NAME;
					let newId = item.ID;
					let newType = item.TYPE;
					
					console.log('title : ' + title + 'name : ' + name + 'newId : ' + newId + 'newType : ' + newType);
					
					$this.parent().parent().remove();
					
					if(newType == 'DOING'){
						$('#' + newType).append('<div class = "resultBox">제목 : ' + title +'<br>' +  
								 				  '작성자 : ' + name +
												  '<input type = "hidden" value = "' + newId + '">' + 
												  '<div id = "btns"><button class = "leftBtn"><<<</button> <button class = "rightBtn">>>></button></div>' +  
												  '</div>');		
					} else if(newType == 'TODO'){
						$('#' + newType).append('<div class = "resultBox">제목 : ' + item.TITLE +'<br>' +  
												 '작성자 : ' + item.NAME + 
												 '<input type = "hidden" value = "' + item.ID + '">' +
												 '<div id = "btns"><button class = "rightBtn">>>></button></div>' +  
												 '</div>');
					}
			
	
				})
				
			} 
		});
	});

	$(document).on('click', '#deleteBtn', function(){
		$(this).parent().parent().remove();
	});

	
});