<template>
  <div>
    <a-descriptions title= 我的项目 layout="horizontal " bordered >
      <a-descriptions-item label="项目名称" span = "3">
        {{ this.data.project_name }}
      </a-descriptions-item>
      <a-descriptions-item label="项目经理" :span="2">
        {{ this.data.group_leader }}
      </a-descriptions-item>
      <a-descriptions-item label="项目ID" :span="2">
        {{this.data.pid}}
      </a-descriptions-item>
      <a-descriptions-item label="项目开始时间" :span="3">
        {{ this.data.start_time }}
      </a-descriptions-item>
      <a-descriptions-item label="预计完成时间" :span="3">
        {{ this.data.end_time }}
      </a-descriptions-item>
      <a-descriptions-item label="项目状态" :span="3">
        <a-badge status="processing" text="进行中" />
      </a-descriptions-item>
      <a-descriptions-item label="项目总人数">
        {{ this.data.group_info.length }}
      </a-descriptions-item>
      <a-descriptions-item label="项目预算">
        $0.0
      </a-descriptions-item>
      <a-descriptions-item label="指导人">
        <a href="http://gr.xjtu.edu.cn/web/songyh" text-decoration="none" target="_blank">宋永红</a>
      </a-descriptions-item>
    </a-descriptions>
    <GroupMember></GroupMember>
  </div>
</template>

<script>

import GroupMember from './GroupMember'

const data = []

export default {
  name: 'ProjectDetail',
  components: {GroupMember},
  data () {
    return {
      data
    }
  },
  mounted () {
    // this.$get('project/details?pid=1').then((r) => {
    //   console.log('Hello I am Tester!')
    //   console.log(r.data.data)
    //   this.data = r.data.data
    // })
    let that = this
    this.axios.get('../../static/testData/projectDetail.json').then(function (response) {
      console.log(response.data.data)
      that.data = response.data.data
    })
    console.log(this.data)
  }
}
</script>

<!--<style scoped>-->

<!--</style>-->
