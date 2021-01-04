/* eslint-disable */
<template>
  <el-table
    :data="tableData"
    style="width: 100%"
    :row-class-name="tableRowClassName">
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="class"
      label="班级"
      width="180">
    </el-table-column>
    <el-table-column
      prop="sid"
      label="学号">
    </el-table-column>
    <el-table-column
      prop="position"
      label="岗位">
    </el-table-column>
  </el-table>
</template>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>

<script>
export default {
  name: "GroupMember",
  methods: {
    tableRowClassName({row, rowIndex}) {
      if (rowIndex === 1) {
        return 'warning-row';
      } else if (rowIndex === 3) {
        return 'success-row';
      }
      return '';
    }
  },
  data() {
    return {
      tableData: [{
        name: '马冬梅',
        class: '软件81',
        sid: '2187654321',
        position: '项目经理'
      },{
        name: '马秋梅',
        class: '软件82',
        sid: '2177654321',
        position: '前端工程师'
      },{
        name: '马夏梅',
        class: '软件83',
        sid: '2167654321',
        position: '后端工程师'
      },{
        name: '马春梅',
        class: '软件84',
        sid: '2157654321',
        position: '测试工程师'
      }]
    }
  },
  mounted () {
    this.$get('project/my_member_info').then((r) => {
      this.tableData = r.data.data
      this.tableData.forEach(function(value, index, array){
        value.class=value.tuserInfo.class;
        value.name=value.tuserInfo.name;
      })
    })
  }
}
</script>
