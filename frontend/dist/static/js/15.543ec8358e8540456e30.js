webpackJsonp([15,45],{"+2Pn":function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=function(){var e=this.$createElement,t=this._self._c||e;return t("el-table",{staticStyle:{width:"100%"},attrs:{data:this.tableData,"row-class-name":this.tableRowClassName}},[t("el-table-column",{attrs:{prop:"name",label:"姓名",width:"180"}}),this._v(" "),t("el-table-column",{attrs:{prop:"class",label:"班级",width:"180"}}),this._v(" "),t("el-table-column",{attrs:{prop:"sid",label:"学号"}}),this._v(" "),t("el-table-column",{attrs:{prop:"position",label:"岗位"}})],1)};r._withStripped=!0;var a={render:r,staticRenderFns:[]},s=a;var o=!1;var l=n("VU/8")({name:"GroupMember",methods:{tableRowClassName:function(e){e.row;var t=e.rowIndex;return 1===t?"warning-row":3===t?"success-row":""}},data:function(){return{tableData:[{name:"马冬梅",class:"软件81",sid:"2187654321",position:"项目经理"},{name:"马秋梅",class:"软件82",sid:"2177654321",position:"前端工程师"},{name:"马夏梅",class:"软件83",sid:"2167654321",position:"后端工程师"},{name:"马春梅",class:"软件84",sid:"2157654321",position:"测试工程师"}]}},mounted:function(){var e=this;this.$get("project/my_member_info").then(function(t){e.tableData=t.data.data,e.tableData.forEach(function(e,t,n){e.class=e.tuserInfo.class,e.name=e.tuserInfo.name})})}},s,!1,function(e){o||n("xYvm")},null,null);l.options.__file="src/views/project/view/GroupMember.vue";t.default=l.exports},A0V2:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=[],a={name:"ProjectDetail",components:{GroupMember:n("+2Pn").default},data:function(){return{typeDicts:{web:"web应用开发",desktop:"桌面应用开发",wechat:"微信小程序开发",ai:"AI算法应用"},projectInfoData:[{pid:""}],projectMemberData:r}},mounted:function(){var e=this;this.$get("project/my_member_info").then(function(t){console.log("Hello I am Tester1!"),console.log(t.data.data),e.projectMemberData=t.data.data}),this.$get("project/my").then(function(t){console.log("Hello I am Tester2!"),console.log(t.data.data),e.projectInfoData=t.data.data})}},s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[""==e.projectInfoData[0].pid?n("div",{staticStyle:{width:"100%",height:"100%","padding-left":"290px"}},[n("a-result",{attrs:{status:"500",title:"尚未加入任何项目","sub-title":"快去找一个你感兴趣的项目吧~"},scopedSlots:e._u([{key:"extra",fn:function(){return[n("a-button",{attrs:{type:"primary"}},[e._v("\n          加油打工人\n        ")])]},proxy:!0}],null,!1,3879477415)})],1):n("div",{staticStyle:{width:"100%","padding-left":"90px","padding-right":"90px","font-size":"25px"}},[n("div",{staticStyle:{"font-size":"25px","font-weight":"bold","text-align":"center","margin-bottom":"40px"}},[n("dv-decoration-7",[e._v("我的项目")])],1),e._v(" "),n("a-descriptions",{attrs:{layout:"horizontal ",bordered:""}},[n("a-descriptions-item",{attrs:{label:"项目名称",span:"3"}},[e._v("\n        "+e._s(this.projectInfoData[0].projectName)+"\n      ")]),e._v(" "),n("a-descriptions-item",{attrs:{label:"项目经理",span:2}},[e._v("\n        "+e._s(this.projectInfoData[0].managerName)+"\n      ")]),e._v(" "),n("a-descriptions-item",{attrs:{label:"项目ID",span:2}},[e._v("\n        "+e._s(this.projectInfoData[0].pid)+"\n      ")]),e._v(" "),n("a-descriptions-item",{attrs:{label:"项目开始时间",span:3}},[e._v("\n        "+e._s(this.projectInfoData[0].startTime)+"\n      ")]),e._v(" "),n("a-descriptions-item",{attrs:{label:"预计完成时间",span:3}},[e._v("\n        "+e._s(this.projectInfoData[0].endTime)+"\n      ")]),e._v(" "),n("a-descriptions-item",{attrs:{label:"项目状态",span:3}},[n("a-badge",{attrs:{status:"processing",text:"进行中"}})],1),e._v(" "),n("a-descriptions-item",{attrs:{label:"项目总人数"}},[e._v("\n        "+e._s(this.projectMemberData.length)+"人\n      ")]),e._v(" "),n("a-descriptions-item",{attrs:{label:"项目预算"}},[e._v("\n        $0.0\n      ")]),e._v(" "),n("a-descriptions-item",{attrs:{label:"指导人"}},[n("a",{attrs:{href:"http://gr.xjtu.edu.cn/web/songyh","text-decoration":"none",target:"_blank"}},[e._v("宋永红老师")])])],1),e._v(" "),n("GroupMember")],1)])};s._withStripped=!0;var o={render:s,staticRenderFns:[]},l=o;var i=n("VU/8")(a,l,!1,null,null,null);i.options.__file="src/views/project/view/ProjectDetail.vue";t.default=i.exports},X5px:function(e,t,n){(e.exports=n("FZ+f")(!0)).push([e.i,"\n.el-table .warning-row {\r\n  background: oldlace;\n}\n.el-table .success-row {\r\n  background: #f0f9eb;\n}\r\n","",{version:3,sources:["C:/Users/shinelon/Desktop/Course-Managing-System/frontend/src/views/project/view/src/views/project/view/GroupMember.vue"],names:[],mappings:";AA4BA;EACA,oBAAA;CACA;AAEA;EACA,oBAAA;CACA",file:"GroupMember.vue",sourcesContent:["/* eslint-disable */\r\n<template>\r\n  <el-table\r\n    :data=\"tableData\"\r\n    style=\"width: 100%\"\r\n    :row-class-name=\"tableRowClassName\">\r\n    <el-table-column\r\n      prop=\"name\"\r\n      label=\"姓名\"\r\n      width=\"180\">\r\n    </el-table-column>\r\n    <el-table-column\r\n      prop=\"class\"\r\n      label=\"班级\"\r\n      width=\"180\">\r\n    </el-table-column>\r\n    <el-table-column\r\n      prop=\"sid\"\r\n      label=\"学号\">\r\n    </el-table-column>\r\n    <el-table-column\r\n      prop=\"position\"\r\n      label=\"岗位\">\r\n    </el-table-column>\r\n  </el-table>\r\n</template>\r\n\r\n<style>\r\n.el-table .warning-row {\r\n  background: oldlace;\r\n}\r\n\r\n.el-table .success-row {\r\n  background: #f0f9eb;\r\n}\r\n</style>\r\n\r\n<script>\r\nexport default {\r\n  name: \"GroupMember\",\r\n  methods: {\r\n    tableRowClassName({row, rowIndex}) {\r\n      if (rowIndex === 1) {\r\n        return 'warning-row';\r\n      } else if (rowIndex === 3) {\r\n        return 'success-row';\r\n      }\r\n      return '';\r\n    }\r\n  },\r\n  data() {\r\n    return {\r\n      tableData: [{\r\n        name: '马冬梅',\r\n        class: '软件81',\r\n        sid: '2187654321',\r\n        position: '项目经理'\r\n      },{\r\n        name: '马秋梅',\r\n        class: '软件82',\r\n        sid: '2177654321',\r\n        position: '前端工程师'\r\n      },{\r\n        name: '马夏梅',\r\n        class: '软件83',\r\n        sid: '2167654321',\r\n        position: '后端工程师'\r\n      },{\r\n        name: '马春梅',\r\n        class: '软件84',\r\n        sid: '2157654321',\r\n        position: '测试工程师'\r\n      }]\r\n    }\r\n  },\r\n  mounted () {\r\n    this.$get('project/my_member_info').then((r) => {\r\n      this.tableData = r.data.data\r\n      this.tableData.forEach(function(value, index, array){\r\n        value.class=value.tuserInfo.class;\r\n        value.name=value.tuserInfo.name;\r\n      })\r\n    })\r\n  }\r\n}\r\n<\/script>\r\n"],sourceRoot:""}])},xYvm:function(e,t,n){var r=n("X5px");"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);n("rjj0")("37b95eca",r,!1,{})}});
//# sourceMappingURL=15.543ec8358e8540456e30.js.map