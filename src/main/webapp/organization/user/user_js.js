var userVm = new Vue({
    el: "#user",
    data: {
        pageInfo: {
            navigatepageNums: '5', // 总页数
            pageSize: '', // 每页的记录数
            total: '',  // 总记录数
            pageNum: 1,  // 当前页数
            isLastPage: '',  // 是否最后一页
            isFirstPage: ''  // 是否第一页
        },
        user: {
            user_id: '',
            role_id: '-1',
            role_name: '',
            login_name: '',
            office_phone: '',
            mobile_phone: '',
            email: '',
            zxbj: '-1',
            pageNum: ''
        },
        roleList: [{ role_id: 1, role_name: "admin" }, { role_id: 2, role_name: "game" }],
        list: [],  // 用户list
    },
    methods: {
        goPage: function (pageNum) {
            this.user.pageNum = pageNum;
            var params = this.user;
            // 基本判断
            if (pageNum < 1) {
                this.pageInfo.isFirstPage = true;
            } else {
                this.pageInfo.isFirstPage = false;
            } if (pageNum > this.pageInfo.navigatepageNums) {
                this.pageInfo.isLastPage = true;
            } else {
                this.pageInfo.isLastPage = false;
            }
            // ajax
            this.$http.post("/bike/syuser/getSyUserList.do", this.user).then(
                	(resp) => {
		if (resp.bodyText == "noPhase") {
			$("#page-wrapper").load("/bike/noPhase.html");
		} else if (resp.bodyText == "noSyUser") {
			$("#page-wrapper").load("/bike/login.html");
		} else {
			var data = resp.body;
                    if (data.flag == 'nothing') {
                        alert("空空如也拉");
                    } else {
                        this.list = []; // 清空list
                        for (var i = 0; i < data.length - 1; i++) {
                            this.list.push(data[i]);
                        }
                        this.pageInfo.pageSize = data[data.length - 1].pageSize;
                        this.pageInfo.total = data[data.length - 1].total;
                        this.pageInfo.navigatepageNums = data[data.length - 1].navigatepageNums;
                        this.pageInfo.pageNum = pageNum;
                    }
		}

	});
        },
        // 注销用户
        cancelUser: function (user_id) {
            if (confirm("确定要注销么？")) {
                this.$http.get("/bike/syuser/cancelSyUser.do", { params: { user_id: user_id } }).then(function (resp) {
                    if (resp.bodyText == "success") {
                        alert("注销成功！");
                        this.goPage(1);
                    } else {
                        alert("注销失败，请稍后再试！");
                    }
                }, function (resp) {
                });
            }
        },
        // 修改用户
        modifyUser: function (user_id) {
            modifyShow();
            mdVue.getSyUser(user_id);
        }
    },
    mounted: function () {
        this.goPage(1);
        // 向服务器发起请求，获得全部的角色List
        this.roleList = [];
        this.$http.get("/bike/syuser/getSyRoleList.do").then(
            (resp) => {
		if (resp.bodyText == "noPhase") {
			$("#page-wrapper").load("/bike/noPhase.html");
		} else if (resp.bodyText == "noSyUser") {
			$("#page-wrapper").load("/bike/login.html");
		} else {
			var data = resp.body;
                for (var i = 0; i < data.length; i++) {
                    this.roleList.push({ role_id: data[i].role_id, role_describe: data[i].role_describe });
                }
		}

	});
    },
});
// 新增vue
var addVue = new Vue({
    el: "#addUser",
    data: {
        // 用户对象
        user: {
            login_name: '',
            username: "",
            password: "",
            office_phone: '',
            mobile_phone: '',
            email: '',
            zxbj: '0',
            role_id: '-1'
        },
        roleList: [], // 全部权限
        message: ''  // 提示信息
    },
    methods: {
        submit: function () {
            if (this.message != '') {
                alert("请填写正确的登录名！");
            } else if (this.user.login_name == '' || this.user.username == '' || this.user.password == '') {
                alert("请输入完整信息！");
            } else if (!/^[A-Z a-z 0-9]+@[A-Z a-z 0-9]+\.com$/.test(this.user.email) && this.user.email != '') {
                alert("电子邮箱格式不正确！");
            } else {
                this.$http.post("/bike/syuser/addSyUser.do", this.user).then(function (resp) {
                    if (resp.bodyText == "success") {
                        alert("新增成功！");
                        this.message = '';
                        this.clear();
                        userVm.goPage(1);
                        back();
                    } else {
                        alert("新增失败，请稍后再试！");
                    }

                }, function (resp) {

                });
            }
        },
        addShow: function () {
            addShow();
        },
        checkLogin_name: function () {
            this.$http.get("/bike/syuser/checkLogin_name.do", { params: { login_name: this.user.login_name } }).then(
                (resp) => {
                    if (resp.bodyText == "existed") {
                        this.message = "登录名已存在，请更换！";
                    } else {
                        this.message = '';
                    }
                }, (resp) => { }
            );
        },
        clear: function () {
            this.user.login_name = '';
            this.user.username = '';
            this.user.password = '';
            this.user.office_phone = '';
            this.user.mobile_phone = '';
            this.user.email = '';
            this.user.zxbj = '0';
            this.user.role_id = '-1';
        }
    },
    mounted: function () {
        this.roleList = userVm.roleList;
    }
});
// 修改vue 先用mounted从服务器获取全部的角色List
var mdVue = new Vue({
    el: "#modifyUser",
    data: {
        // 用户对象
        user: {
        	user_id : '',
            username: "",
            password: "",
            office_phone: '',
            mobile_phone: '',
            email: '',
            zxbj: '0',
            role_id: '-1'
        },
        roleList: [], // 全部权限
        message: ''  // 提示信息
    },
    methods: {
        submit: function () {
            if (this.user.login_name == '' || this.user.username == '') {
                alert("请输入完整信息！");
            } else if (!/^[A-Z a-z 0-9]+@[A-Z a-z 0-9]+\.com$/.test(this.user.email) && this.user.email != '') {
                alert("电子邮箱格式不正确！");
            }else {
               	console.log(this.user);
                this.$http.post("/bike/syuser/updateSyUser.do", this.user).then(function
                    (resp) {
                    if (resp.bodyText == "success") {
                        alert("修改成功！");
                        userVm.goPage(1);
                        this.user.password = "";
                        hidepwd();
                        back();
                    } else { alert("修改失败，请稍后再试！"); }
                }, function (resp) {

                });
            }

        },
        getSyUser: function (user_id) {
        	this.user.user_id = user_id;
            this.$http.get("/bike/syuser/getSyUser.do", { params: { user_id: user_id } }).then(function (resp) {
                var obj = resp.body;
                this.user.username = obj.username;;
                this.user.office_phone = obj.office_phone;
                this.user.mobile_phone = obj.mobile_phone;
                this.user.email = obj.email;
                this.user.zxbj = obj.zxbj;
                if (obj.role_id != null){
                	this.user.role_id = obj.role_id;
                }else {
                	this.user.role_id = -1;
                }
            }, function (resp) {
            });
        }
    },
    mounted: function () {
        this.roleList = userVm.roleList;
    }

});

function addShow() {
    $("#user").hide();
    $("#addUser").show();
}
function back() {
    $("#user").show();
    $("#modifyUser").hide();
    $("#addUser").hide();
}
function modifyShow() {
    $("#modifyUser").show();
    $("#user").hide();
}
function showpwd() {
    $('#pwd').show();
}
function hidepwd() {
    $('#pwd').hide();
}
