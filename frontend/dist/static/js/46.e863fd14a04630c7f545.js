webpackJsonp([46],{SqvU:function(n,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",{staticStyle:{width:"100%",height:"100%","text-align":"center","margin-left":"50px","margin-right":"50px"}},[e("el-row",{staticStyle:{"font-size":"25px","font-weight":"bold"}},[e("dv-decoration-7",[n._v("绩效考核")])],1),n._v(" "),e("el-row",[e("div",{staticStyle:{height:"40px"}},[n._v(" ")])]),n._v(" "),e("el-row",[e("el-col",{attrs:{span:12}},[e("el-row",{staticStyle:{"font-size":"20px","font-weight":"bolder"}},[n._v("\n          成员活跃度\n        ")]),n._v(" "),e("el-row",[e("div",{staticStyle:{height:"90%",width:"80%"}},[e("ve-heatmap",{attrs:{data:n.activeDegree}})],1)])],1),n._v(" "),e("el-col",{attrs:{span:12}},[e("el-row",{staticStyle:{"font-size":"20px","font-weight":"bolder","padding-bottom":"45px"}},[n._v("\n          提交文档数量\n        ")]),n._v(" "),e("el-row",[e("ve-pie",{attrs:{data:n.docsNum}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:12}},[e("el-row",{staticStyle:{"font-size":"20px","font-weight":"bolder","padding-bottom":"45px"}},[n._v("\n          考勤表现\n        ")]),n._v(" "),e("el-row",[e("div",{staticStyle:{height:"90%",width:"80%"}},[e("ve-line",{attrs:{data:n.attendanceData,settings:n.attendanceSettings}})],1)])],1),n._v(" "),e("el-col",{attrs:{span:12}},[e("el-row",{staticStyle:{"font-size":"20px","font-weight":"bolder"}},[n._v("\n          任务完成情况\n        ")]),n._v(" "),e("el-row",[e("div",{staticStyle:{height:"90%",width:"80%","margin-top":"40px"}},[e("ve-bar",{attrs:{data:n.completeData}})],1)])],1)],1)],1)};a._withStripped=!0;var i={render:a,staticRenderFns:[]},o=i;var s=!1;var r=e("VU/8")({data:function(){return{activeDegree:{columns:["时间","姓名","活跃度"],rows:[{"时间":"星期一","姓名":"成员1","活跃度":1e3},{"时间":"星期二","姓名":"成员2","活跃度":400},{"时间":"星期三","姓名":"成员4","活跃度":800},{"时间":"星期二","姓名":"成员3","活跃度":200},{"时间":"星期三","姓名":"成员3","活跃度":100},{"时间":"星期五","姓名":"成员5","活跃度":300},{"时间":"星期四","姓名":"成员1","活跃度":800},{"时间":"星期一","姓名":"成员1","活跃度":700},{"时间":"星期三","姓名":"成员2","活跃度":300},{"时间":"星期二","姓名":"成员4","活跃度":500}]},docsNum:{columns:["姓名","文档数量"],rows:[{"姓名":"成员1","文档数量":1},{"姓名":"成员2","文档数量":2},{"姓名":"成员3","文档数量":2},{"姓名":"成员4","文档数量":5},{"姓名":"成员5","文档数量":3}]},attendanceData:{columns:["姓名","迟到次数","早退次数","旷工次数"],rows:[{"姓名":"成员1","迟到次数":1,"早退次数":3,"旷工次数":3},{"姓名":"成员2","迟到次数":1,"早退次数":5,"旷工次数":1},{"姓名":"成员3","迟到次数":3,"早退次数":1,"旷工次数":2},{"姓名":"成员4","迟到次数":4,"早退次数":4,"旷工次数":6},{"姓名":"成员5","迟到次数":2,"早退次数":2,"旷工次数":0}]},attendanceSettings:{yAxisType:["次","percent"],yAxisName:["次数",""]},completeData:{columns:["日期","完成数","取消数","逾期数"],rows:[{"日期":"成员1","完成数":13,"取消数":2,"逾期数":5},{"日期":"成员2","完成数":20,"取消数":5,"逾期数":2},{"日期":"成员3","完成数":15,"取消数":6,"逾期数":1},{"日期":"成员4","完成数":17,"取消数":4,"逾期数":3},{"日期":"成员5","完成数":10,"取消数":7,"逾期数":1}]}}}},o,!1,function(n){s||e("lc0C")},null,null);r.options.__file="src/views/statistics/Performance.vue";t.default=r.exports},YzDB:function(n,t,e){(n.exports=e("FZ+f")(!0)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n","",{version:3,sources:[],names:[],mappings:"",file:"Performance.vue",sourceRoot:""}])},lc0C:function(n,t,e){var a=e("YzDB");"string"==typeof a&&(a=[[n.i,a,""]]),a.locals&&(n.exports=a.locals);e("rjj0")("42829205",a,!1,{})}});
//# sourceMappingURL=46.e863fd14a04630c7f545.js.map