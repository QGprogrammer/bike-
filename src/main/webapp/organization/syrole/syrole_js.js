var rolevm = new Vue({
    el: "#role",
    data: {
        pageInfo: {
            navigatepageNums: '5', // 总页数
            pageSize: '', // 每页的记录数
            total: '',  // 总记录数
            pageNum: 1,  // 当前页数
            isLastPage: '',  // 是否最后一页
            isFirstPage: ''  // 是否第一页
        },
        list: [],  // 角色list
        role_name: "",
        role_describe: "",
        allPhaseList : []
    },
    methods: {
        goPage: function (pageNum) {
            var params = {
                params: {
                    pageNum: pageNum,
                    role_name: this.role_name,
                    role_describe: this.role_describe
                }
            }
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
            this.$http.get("/bike/role/getSyRoleList.do", params).then(
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
        // 删除权限
        deleteRole: function (role_id) {
            if(confirm("确定删除么？")){
            this.$http.get("/bike/role/deleteSyRole.do", { params: { role_id: role_id } }).then(function (resp) {
                if (resp.bodyText == "success") {
                    alert("删除成功！");
                    this.goPage(1);
                } else {
                    alert("删除失败，已有用户分配该角色！");
                }
            }, function (resp) {
            });
            }
        },
        addShow : function(){
        	addShow();
        },
        // 修改权限
        modifyRole: function (roleid) {
            modifyShow();
            mdVue.getRole(roleid);
        }
    },
    mounted: function () {
        this.goPage(1);
       // 向服务器发起请求，获得全部的权限List
        this.allPhaseList = [];
        this.$http.get("/bike/msphase/getAllMsPhaseList.do").then(
        		(resp) => {
		if (resp.bodyText == "noPhase") {
			$("#page-wrapper").load("/bike/noPhase.html");
		} else if (resp.bodyText == "noSyUser") {
			$("#page-wrapper").load("/bike/login.html");
		} else {
			var data = resp.body;
        		for (var i = 0; i< data.length; i++){
        			this.allPhaseList.push({description:data[i].description,phaseid:data[i].phaseid});
        		}

		}

	});
    },
});
// 新增vue
var addVue = new Vue({
    el: "#addRole",
    data: {
    	//角色对象
        role : {
        	role_id : '',
    		role_name: "",
        	role_describe: "",
        	msPhaseList : ''
    	},
    	allPhaseList : [], //全部权限
    	phaseIdList : []
    },
    methods: {
       submit: function () {
            if (this.role.role_name == '' || this.role.role_describe == '') {
                alert("请输入完整信息！");
            } else {
            	this.role.msPhaseList = [];
            	for (var i=0;i<this.phaseIdList.length;i++){
            		this.role.msPhaseList.push({phaseid:this.phaseIdList[i]});
            	
            	}
                this.$http.post("/bike/role/addSyRole.do",JSON.stringify(this.role)).then(function (resp) {
                    if (resp.bodyText == "success") {
                        alert("新增成功！");
                        this.clear();
                     	rolevm.goPage(1);
                       	back();
                    } else {
                        alert("新增失败，该角色已存在！");
                    }

                }, function (resp) {

                });
        	}
        },
        clear : function(){
        	this.phaseIdList = [];
        	this.role.role_id = '';
        	this.role.role_describe = '';
        	this.role.role_name = '';
        }
    },
    mounted : function(){
    	this.allPhaseList = rolevm.allPhaseList;
    }
});
// 修改vue 先用mounted从服务器获取全部的权限List 再从服务器获取角色具备的权限 v-model
var mdVue = new Vue({
    el: "#modifyRole",
    data: {
    	//角色对象
        role : {
        	role_id : '',
    		role_name: "",
        	role_describe: "",
        	msPhaseList : ''
    	},
    	allPhaseList : [], //全部权限
    	phaseIdList : []
    },
    methods: {
       submit: function () {
            if (this.role.role_name == '' || this.role.role_describe == '') {
                alert("请输入完整信息！");
            } else {
            	this.role.msPhaseList = [];
            	for (var i=0;i<this.phaseIdList.length;i++){
            		this.role.msPhaseList.push({phaseid:this.phaseIdList[i]});
            	
            	}
                this.$http.post("/bike/role/updateSyRole.do",JSON.stringify(this.role)).then(function (resp) {
                    if (resp.bodyText == "success") {
                        alert("修改成功！");
                     	rolevm.goPage(1);
                       	back();
                    } else {
                        alert("修改失败，请稍后再试！");
                    }

                }, function (resp) {

                });
        	}
        },
        getRole: function (roleid) {
        	this.phaseIdList = [];
            this.$http.get("/bike/role/getSyRole.do",{params : {role_id:roleid}}).then(function (resp) {
                this.role.role_name = resp.body.role_name;
                this.role.role_describe = resp.body.role_describe;
                this.role.role_id = roleid;
               	var list = resp.body.msPhaseList;
               	for (var i=0;i<list.length;i++){
               		//this.phaseList.push(list[i].description);
               		this.phaseIdList.push(list[i].phaseid);
               	}
            }, function (resp) {
            });
        }
    },
    mounted : function(){
    	this.allPhaseList = rolevm.allPhaseList;
    }
});
function addShow() {
    $("#role").hide();
    $("#addRole").show();
}
function back() {
    $("#role").show();
    $("#modifyRole").hide();
    $("#addRole").hide();
}
function modifyShow() {
    $("#modifyRole").show();
    $("#role").hide();
}
