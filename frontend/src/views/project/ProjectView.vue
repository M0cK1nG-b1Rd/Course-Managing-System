<template>
  <a-table :columns="columns" :data-source="data" class="table">
    <a slot="project_id" slot-scope="text">{{ text }}</a>
    <span slot="customTitle">项目ID</span>
    <span slot="group_leader" slot-scope="group_leader">
        {{ group_leader }}
    </span>
    <span slot="action" slot-scope="text, record">
      <a>查看项目</a>
      <a-divider type="vertical" />
      <a>删除项目</a>
    </span>
  </a-table>
</template>
<script>

const columns = [
  {
    dataIndex: 'pid',
    key: 'project_id',
    slots: { title: 'customTitle' },
    scopedSlots: { customRender: 'project_id' }
  },
  {
    title: '项目名称',
    dataIndex: 'projectName',
    key: 'project_name'
  },
  {
    title: '小组名称',
    dataIndex: 'groupName',
    key: 'group_name'
  },
  {
    title: '小组组长',
    key: 'group_leader',
    dataIndex: 'groupLeader',
    scopedSlots: { customRender: 'group_leader' }
  },
  {
    title: '项目开始时间',
    key: 'start_time',
    dataIndex: 'startTime'
  },
  {
    title: '项目结束时间',
    key: 'end_time',
    dataIndex: 'endTime'
  },
  {
    title: '操作',
    key: 'action',
    scopedSlots: { customRender: 'action' }
  }
]

const data = []

export default {
  name: 'ProjectView',
  data () {
    return {
      data,
      columns
    }
  },
  mounted () {
    this.$get('project/all').then((r) => {
      console.log(r.data.data)
      this.data = r.data.data
    })
  }
}
</script>

<style scoped>

.table {
  width: 100%;
  height: 100%;
  margin: 0 auto;
  text-align: center;
}

</style>
