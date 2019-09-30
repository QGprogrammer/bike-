// 主vue
var phasevm = new Vue({
    el: "#phase",
    data: {
        pageInfo: {
            navigatepageNums: '5', // 总页数
            pageSize: '', // 每页的记录数
            total: '',  // 总记录数
            pageNum: 1,  // 当前页数
            isLastPage: '',  // 是否最后一页
            isFirstPage: ''  // 是否第一页
        },
        list: [],
        url: "",
        description: ""
    },
    methods: {
        goPage: function (pageNum) {
            var params = {
                params: {
                    pageNum: pageNum,
                    url: this.url,
                    description: this.description
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
            this.$http.get("/bike/msphase/getMsPhaseList.do", params).then(
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
        deletePhase: function (phaseid) {
           if (confirm("确定删除么？")){
            this.$http.get("/bike/msphase/deleteMsPhase.do", { params: { phaseid: phaseid } }).then(function (resp) {
                if (resp.bodyText == "success") {
                    alert("删除成功！");
                    this.goPage(1);

                } else {
                    alert("删除失败，已有角色分配该权限！");
                }

            }, function (resp) {
            });
           }
        },
        // 修改权限
        modifyPhase: function (phaseid) {
            modifyShow();
            mdVue.getPhase(phaseid);
        }
    },
    mounted: function () {
        this.goPage(1);
    }

});
// 新增vue
var addVue = new Vue({
    el: "#addPhase",
    data: {
        url: '',
        description: ''
    },
    methods: {
        submit: function () {
            if (this.url == '' || this.description == '') {
                alert("请输入完整信息！");
            } else if (!/^\/\w*$/.test(this.url)) {
                alert("url不合法，请输入形如/xxx格式");
            } else {
                this.$http.get("/bike/msphase/addMsPhase.do", { params: { url: this.url, description: this.description } }).then(function (resp) {
                    if (resp.bodyText == "success") {
                        alert("新增成功！");
                        phasevm.goPage(1);
                        back();
                        this.clear();

                    }else {
                        alert("新增失败，该权限已存在！");
                    }

                }, function (resp) {

                });

            }
        },
        clear: function () {
            this.url = '';
            this.description = '';
        }
    }
});
// 修改vue
var mdVue = new Vue({
    el: "#modifyPhase",
    data: {
        url: '',
        description: '',
        phaseid: ''
    },
    methods: {
        submit: function () {
            if (this.url == '' || this.description == '') {
                alert("请输入完整信息！");
            } else if (!/^\/\w*$/.test(this.url)) {
                alert("url不合法，请输入形如/xxx格式");
            } else {
                this.$http.get("/bike/msphase/updateMsPhase.do", { params: { url: this.url, description: this.description, phaseid: this.phaseid } }).then(function (resp) {
                    if (resp.bodyText == "success") {
                        alert("修改成功！");
                        phasevm.goPage(1);
                        back();
                    } else {
                        alert("修改失败，请稍后再试！");
                    }

                }, function (resp) {

                });
            }
        },
        getPhase: function (phaseid) {
            this.$http.get("/bike/msphase/getMsPhase.do", { params: { phaseid: phaseid } }).then(function (resp) {
                this.url = resp.body.url;
                this.description = resp.body.description;
                this.phaseid = phaseid;
            }, function (resp) {
            });
        },
    },
});
function addShow() {
    $("#phase").hide();
    $("#addPhase").show();
}
function back() {
    $("#phase").show();
    $("#modifyPhase").hide();
    $("#addPhase").hide();
}
function modifyShow() {
    $("#modifyPhase").show();
    $("#phase").hide();
}
