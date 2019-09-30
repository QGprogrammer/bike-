var stationVue = new Vue({
        el: "#station",
        data: {
            station_name: '',
            address: '',
            station_id: '',
            longitude: '',
            latitude: '',
            bicycle_pile_num: '',
        },
        methods: {
            show1: function () {
                show(dataList);

            },
            search: function () {
                var data = {
                    station_name: this.station_name,
                    address: this.address
                };
                this.$http.post("/bike/inform/getBicycle_stationListByNameOrAdd.do", data).then(
                    (resp) => {
                        show(resp.body);
                    }
                );
            }
        },
        mounted: function () {
            // show(dataList);
        }
        ,
    });
   	var station_pileVue = new Vue({
   		el : "#station_pile",
   		data : {
   			station_pileList : '',
   			station_name : ''
   		},
   		methods : {
   			clear : function(){
   				this.station_pileList = '';
   				this.station_name = '';
   			},
   			back : function(){
   				this.clear();
   				back();
   			},
   			getBicycle_info : function(bicycle_id){
   			this.$http.get("/bike/inform/getBicycle_catagoryById.do",{params:{bicycle_id : bicycle_id}}).then(
   				(resp)=>{
   					var data = resp.body;
   					alert("车辆类型："+data.catagory_name+"\n车架类型："+data.frame_type+"\n轮胎类型："+data.tire_type
   						  +"\n车重："+data.weight+"\n车长："+data.length+"\n车高："+data.height+"\n铃类型："+data.ring_type+"\n车座类型："+data.bicycle_seat);
   				});
   			}
   		}
   		
   		
   		
   	});
    function back() {
        $("#station").show();
        $("#station_pile").hide();
    }
    function showPile(){
    	 $("#station").hide();
         $("#station_pile").show();
    }

    var map;
    function show(data_info) {

        // 百度地图API功能
        map = new BMap.Map("container");
        var point1 = new BMap.Point(120.1617445782, 30.2799186759);
        map.centerAndZoom(point1, 15);
        // 功能
        map.enableScrollWheelZoom(); // 激活滚轮调整大小功能

        map.addControl(new BMap.NavigationControl()); // 添加控件：缩放地图的控件，默认在左上角；

        map.addControl(new BMap.MapTypeControl()); // 添加控件：地图类型控件，默认在右上方；

        map.addControl(new BMap.ScaleControl()); // 添加控件：地图显示比例的控件，默认在左下方；

        map.addControl(new BMap.OverviewMapControl()); // 添加控件：地图的缩略图的控件，默认在右下方；
        // TrafficControl
        var bounds = map.getBounds();
        var sw = bounds.getSouthWest();
        var ne = bounds.getNorthEast();
        var lngSpan = Math.abs(sw.lng - ne.lng);
        var latSpan = Math.abs(ne.lat - sw.lat);


        var points = []; // 方便放同一个视图中
        for (var i = 0; i < data_info.length; i++) {
            // alert(data_info[i].longitude+"...."+ data_info[i].latitude);
            var point = new BMap.Point(data_info[i].longitude, data_info[i].latitude);
            points.push(point)
            var marker = new BMap.Marker(point); // 创建标注
            var content = "【车点地址】：" + data_info[i].address + "\n【车桩数量】：" + data_info[i].bicycle_pile_num + "\n【在桩车数】：" + data_info[i].bicycle_num;
            addClickHandler(content, marker); // 开启信息窗口
            map.addOverlay(marker); // 将标注添加到地图中
        }
        // 让所有点在视野范围内
        map.setViewport(points);
    }
    function addClickHandler(content, marker) {
        marker.addEventListener("click", function (e) {
            openInfo(content, e)
        }
        );
        marker.addEventListener("dblclick", function (e) {
            var obj = {
                longitude: e.target.getPosition().lng,
                latitude: e.target.getPosition().lat
            };
            $.post("/bike/inform/getBicycle_pileListByLogAndLat.do", obj, function (data) {
                //console.log(data);
                station_pileVue.station_pileList = data;
                station_pileVue.station_name = data[0].station_name;
                showPile();
            }, "json");
        }
        );
    }
    function openInfo(content, e) {
        var opts = {
            width: 280, // 信息窗口宽度
            height: 80, // 信息窗口高度
            title: "车点信息", // 信息窗口标题
            enableMessage: true
            // 设置允许信息窗发送短息
        };
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow, point); // 开启信息窗口
    }
