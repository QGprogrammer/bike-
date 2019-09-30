
var mainVm = new Vue({
    el: "#main",
    data: {
        bicycle_infoList: [],
        bicycle_chooseList: []
    },
    methods: {
        goPage: function () {
            //获得未入桩车辆List
            this.bicycle_infoList = [];
            this.$http.get("/bike/instation/getBicycle_infoByStatus.do?status=1").then(
               (resp) => {
		if (resp.bodyText == "noPhase") {
			$("#page-wrapper").load("/bike/noPhase.html");
		} else if (resp.bodyText == "noSyUser") {
			$("#page-wrapper").load("/bike/login.html");
		} else {
			var data = resp.body;
                    for (var i = 0; i < data.length; i++) {
                        this.bicycle_infoList.push({ 
                        bicycle_id: data[i].bicycle_id, 
                        bicycle_code: data[i].bicycle_code,
                        station_id : '0',
                    	pile_id : '0',
                    	pileList : '',
                        });
                    }
		}

	});
            back();

        },
        instation: function () {
        	 insShow();
        },
        clickCb: function () {
        	this.bicycle_chooseList = [];
            if ($("#main #cb_all").prop("checked")) {
                for (var i = 0; i < this.bicycle_infoList.length; i++) {
                    this.bicycle_chooseList.push({
                    bicycle_id : this.bicycle_infoList[i].bicycle_id,
                    bicycle_code : this.bicycle_infoList[i].bicycle_code,
                    station_id : '0',
                    pile_id : '0',
                    pileList : '',
                    });
                }
                insVue.bicycle_chooseList = this.bicycle_chooseList;
            }
        },
        checkCb: function () {
            setTimeout(() => {
                if (this.bicycle_chooseList.length == this.bicycle_infoList.length) {
                    $("#main #cb_all").prop("checked", true);
                } else {
                    $("#main #cb_all").prop("checked", false);
                }
           		insVue.bicycle_chooseList = this.bicycle_chooseList;  //防止传空值过去
            }, 200);
        }
    },
    mounted: function () {
        this.goPage();
    }
});
// 入桩vue
var insVue = new Vue({
    el: "#ins",
    data: {
     	bicycle_chooseList : '',
     	bicycle_stationList : ''
    },
    methods: {
        submit: function () {
        	//alert(JSON.stringify(this.bicycle_chooseList));
        	var flag = false;
        	var arr = [];
        	for (var i=0;i<this.bicycle_chooseList.length;i++){
        		if (this.bicycle_chooseList[i].station_id == 0 || this.bicycle_chooseList[i].pile_id == 0){
        			flag = true;  //信息不完整
        		}else {
        			var str = this.bicycle_chooseList[i].station_id+""+this.bicycle_chooseList[i].pile_id;
        			pushUnRepeated(arr,str);
        		}
        	}
        	if (flag){
        		alert("请选择车桩或者站点！");
        	}else if (arr.length != this.bicycle_chooseList.length){
        		alert("车桩重复，请重新选择");
        	}else {
        		var submitList = [];
        		var data = this.bicycle_chooseList;
        		for (var i=0;i<data.length;i++){
        			var pile = {
        				station_id : data[i].station_id,
        				bicycle_id : data[i].bicycle_id,
        				pile_id : data[i].pile_id
        			};
        			submitList.push(pile);
        		}
        		this.$http.post("/bike/instation/instationByBatch.do",submitList).then(
        			(resp) =>{
        				if (resp.bodyText == 'success'){
        					alert("入桩成功！");
        				}else {
        					alert("入桩失败，请稍后再试！");
        				}
        				mainVm.goPage();
        				this.clear();
        				back();
        			}
        		);
        	}
        },
        clear : function () {
            $("#main :checkbox").prop("checked",false);
            for (var i = 0;i<this.bicycle_chooseList.length;i++){
            	this.bicycle_chooseList[i].pileList = '';
            	this.bicycle_chooseList[i].station_id = '0';
            	this.bicycle_chooseList[i].pile_id = '0';
            }
            this.bicycle_chooseList = [];
            mainVm.bicycle_chooseList = [];
            
        },
        backToMain : function(){
        	this.clear();
        	back();
        },
        getBicycle_pileList : function(obj){
        	// 向服务器发起请求，获得该对象车点对应的车桩list
        	obj.pileList = [];
        	 this.$http.get("/bike/instation/getBicycle_pileListByStationId.do",{params:{station_id : obj.station_id}}).then(
            (resp) => {
                obj.pileList = resp.body;
            },
            (resp) => { }
        );
        }
    },
    mounted: function () {
        // 向服务器发起请求，获得全部的stationList
        this.bicycle_stationList = [];
        this.$http.get("/bike/instation/getBicycle_stationList.do").then(
            (resp) => {
                this.bicycle_stationList = resp.body;
            },
            (resp) => { }
        );
    }
});
function insShow() {
    $("#main").hide();
    $("#ins").show();
}
function back() {
    $("#main").show();
    $("#ins").hide();
}
function pushUnRepeated(Object,str){
	var flag = true;
	for (var i=0;i<Object.length;i++){
		if (Object[i] == str){
			flag = false;
		}
	}
	if (flag){
	Object.push(str);
	}
}
