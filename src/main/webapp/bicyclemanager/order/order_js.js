var orderVm = new Vue({
		el: "#order",
		data: {
			orderList: [],
		},
		methods: {
			goPage: function () {
				this.orderList = [];
				this.$http.get("/bike/buy/getBicycle_orderList.do").then(
					(resp) => {
						this.orderList = resp.body;
					}, (resp) => { });
				back();

			},
			getBicycle_infoList: function (order_id) {
				// 向服务器发起请求，获得全部的bicycle_codeList
				addDetailVue.bicycle_codeList = [];
				this.$http.get("/bike/buy/getBicycle_codeListByOrder_id.do", { params: { order_id: order_id } }).then(
					(resp) => {
						if (resp.bodyText == "noPhase") {
							location.href = "/bike/noPhase.html";
						} else {
							addDetailVue.bicycle_codeList = resp.body;
						}
					}
				);
			},
			getBicycle_catagoryList: function () {
				// 向服务器发起请求，获得全部的bicycle_catagoryList
				addDetailVue.bicycle_catagoryList = [];
				this.$http.get("/bike/buy/getBicycle_catagoryList.do").then(
					(resp) => {
						addDetailVue.bicycle_catagoryList = resp.body;
					},
					(resp) => { }
				);
			},
			addShow: function () {
				addShow();
			},
			addDetailShow: function (order_id) {
				this.getBicycle_infoList(order_id);
				this.getBicycle_catagoryList();
				addDetailVue.detail.order_id = order_id;
				addDetailShow();
			}
		},
		mounted: function () {
			// 获得主单List
			this.goPage();
		}
	});
	// 新增vue
	var addVue = new Vue({
		el: "#addOrder",
		data: {
			// 采购单对象
			order: {
				buy_num: 1,
				buy_price: '',
				person_in_charge: '',
				invoice_no: '',
				remark: '',
				vender_id: 1,
				buy_date: '',
			},
			venderList: [
				{
					vender_id: 1,
					vender_name: "膜拜"
				}
			],
			laydate: window.laydate
		},
		methods: {
			submit: function () {
				if (this.order.buy_price == '' || this.order.person_in_charge == '' || this.order.invoice_no == '' || this.order.buy_date == '') {
					alert("请输入完整信息！");
				} else if (!/^[1-9][0-9]{0,7}(\.[0-9]{0,2})?$/.test(this.order.buy_price)) {
					alert("价格格式输入有误，总位数10位以内，小数不超两位！");

				} else {
					this.$http.post("/bike/buy/addBicycle_order.do", this.order).then(
						(resp) => {
							if (resp.bodyText == "success") {
								alert("新增成功！");
								orderVm.goPage();
								this.clear();
								back();
							} else {
								alert("新增失败，请稍后再试！");
							}

						}, (resp) => { });
				}
			},
			clear: function () {
				this.order.buy_price = '';
				this.order.buy_num = 1;
				this.order.person_in_charge = '';
				this.order.invoice_no = '';
				this.order.vender_id = 1;
				this.order.remark = '';
				this.order.buy_date = '';
			},
			layShow: function () {
				// 时间控件
				laydate.render({
					elem: "#tim5",
					done: (value) => {
						this.order.buy_date = value;
					}
				});
			}
		},
		mounted: function () {
			// 向服务器发起请求，获得全部的venderList
			this.venderList = [];
			this.$http.get("/bike/buy/getVenderList.do").then(
				(resp) => {
					if (resp.bodyText == "noPhase") {
						$("#page-wrapper").load("/bike/noPhase.html");
					} else if (resp.bodyText == "noSyUser") {
						$("#page-wrapper").load("/bike/login.html");
					} else {
						this.venderList = resp.body;
					}

				}
			);
			this.layShow();
		}
	});
	// 增加明细
	var addDetailVue = new Vue({
		el: "#addDetail",
		data: {
			// 明细单对象
			detail: {
				order_id: '',
				catagory_id: '1',
				batch_no: '',
				price: '',
				remark: ''
			},
			bicycle_codeList: [],
			bicycle_catagoryList: []
		},
		methods: {
			submit: function () {
				if (this.detail.batch_no == '' || this.detail.price == '' || this.detail.remark == '') {
					alert("请输入完整信息！");
				} else if (!/^[1-9][0-9]{0,7}(\.[0-9]{0,2})?$/.test(this.detail.price)) {
					alert("价格格式输入有误，总位数10位以内，小数不超两位！");

				} else {
					this.$http.post("/bike/buy/updateBicycle_order_detail.do", this.detail).then(
						(resp) => {
							if (resp.bodyText == "noPhase") {
								$("#page-wrapper").load("/bike/noPhase.html");
							} else if (resp.bodyText == "noSyUser") {
								$("#page-wrapper").load("/bike/login.html");
							} else {
								if (resp.bodyText == "success") {
									alert("新增成功！");
									orderVm.goPage();
									this.clear();
									back();
								} else {
									alert("新增失败，请稍后再试！");
								}

							}

						});
				}
			},
			clear: function () {
				this.detail.catagory_id = '1';
				this.detail.price = '';
				this.detail.batch_no = '';
				this.detail.remark = '';

			}
		},
		mounted: function () {

		}
	});
	function addShow() {
		$("#order").hide();
		$("#addDetail").hide();
		$("#addOrder").show();
	}
	function addDetailShow() {
		$("#order").hide();
		$("#addDetail").show();
		$("#addOrder").hide();
	}
	function back() {
		$("#order").show();
		$("#addDetail").hide();
		$("#addOrder").hide();
	}