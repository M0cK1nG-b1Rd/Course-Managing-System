<template>
  <div style="width: 100%; padding-left: 90px; padding-right: 90px; font-size: 25px">
    <div style="font-size: 25px;font-weight: bold;text-align: center; margin-bottom: 40px">
      <dv-decoration-7>我的项目</dv-decoration-7>
    </div>
    <a-descriptions  layout="horizontal " bordered >
      <a-descriptions-item label="项目名称" span = "3">
        {{this.projectInfoData[0].projectName}}
      </a-descriptions-item>
      <a-descriptions-item label="项目经理" :span="2">
        {{this.projectInfoData[0].managerName}}
      </a-descriptions-item>
      <a-descriptions-item label="项目ID" :span="2">
        {{this.projectInfoData[0].pid}}
      </a-descriptions-item>
      <a-descriptions-item label="项目开始时间" :span="3">
        {{this.projectInfoData[0].startTime}}
      </a-descriptions-item>
      <a-descriptions-item label="预计完成时间" :span="3">
        {{this.projectInfoData[0].endTime}}
      </a-descriptions-item>
      <a-descriptions-item label="项目状态" :span="3">
        <a-badge status="processing" text="进行中" />
      </a-descriptions-item>
      <a-descriptions-item label="项目总人数">
        {{this.projectMemberData.length}}人
      </a-descriptions-item>
      <a-descriptions-item label="项目预算">
        $0.0
      </a-descriptions-item>
      <a-descriptions-item label="指导人">
        <a href="http://gr.xjtu.edu.cn/web/songyh" text-decoration="none" target="_blank">宋永红老师</a>
      </a-descriptions-item>
    </a-descriptions>
    <GroupMember></GroupMember>
  </div>
</template>

<script>

import GroupMember from './GroupMember'

let projectInfoData = []
let projectMemberData = []

export default {
  name: 'ProjectDetail',
  components: {GroupMember},
  data () {
    return {
      typeDicts:{
         "web":"web应用开发",
         "desktop":"桌面应用开发",
        "wechat":"微信小程序开发",
         "ai":"AI算法应用"
      },
      projectInfoData,
      projectMemberData
    }
  },
  mounted () {
    this.$get('project/my_member_info').then((r) => {
      console.log('Hello I am Tester1!')
      console.log(r.data.data)
      this.projectMemberData = r.data.data
    })

    this.$get('project/my').then((r) => {
      console.log('Hello I am Tester2!')
      console.log(r.data.data)
      this.projectInfoData = r.data.data
    })
    // let that = this
    // this.axios.get('../../static/testData/projectDetail.json').then(function (response) {
    //   console.log(response.data.data)
    //   that.data = response.data.data
    // })
    // console.log(this.data)
  }
}
</script>

<!--<style scoped>-->

<!--</style>-->
