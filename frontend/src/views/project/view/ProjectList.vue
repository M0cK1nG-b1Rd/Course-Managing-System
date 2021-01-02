<template>
  <div style="width: 100%">
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="pid"
        label="项目ID"
        width="80">
      </el-table-column>
      <el-table-column
        prop="projectName"
        label="项目名称"
        width="160">
      </el-table-column>
      <el-table-column
        show-overflow-tooltip
        prop="projectDesc"
        label="项目简介"
        width="160">
      </el-table-column>
      <el-table-column
        prop="projectType"
        label="类型"
        width="120">
      </el-table-column>
      <el-table-column
        prop="managerName"
        label="项目经理"
        width="120">
      </el-table-column>
      <el-table-column
        prop="teacherName"
        label="指导老师"
        width="120">
      </el-table-column>
      <el-table-column
        prop="startTime"
        label="开始时间"
        width="160">
      </el-table-column>
      <el-table-column
        prop="endTime"
        label="结束时间"
        width="160">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="145">
        <template slot-scope="scope">
          <!--        查看按钮-->
          <el-tooltip class="item" effect="dark" content="查看项目细节" placement="top">
            <el-button @click="handleViewClick(scope.row)"
                       size="mini" type="success"
                       icon="el-icon-view" circle >
            </el-button>
          </el-tooltip>
          <!--        编辑按钮-->
          <el-tooltip class="item" effect="dark" content="修改项目信息" placement="top">
            <el-button @click="handleEditClick(scope.row)"
                       size="mini" type="primary"
                       icon="el-icon-edit" circle >
            </el-button>
          </el-tooltip>
          <!--        删除按钮-->
          <el-tooltip class="item" effect="dark" content="删除该项目" placement="top">
            <el-button @click="handleDeleteClick(scope.row)"
                       size="mini" type="danger"
                       icon="el-icon-delete" circle >
            </el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>

    <!--  查看项目细节对话框组件-->
    <projectViewDialog :project-info="projectInfo" :member-info="memberInfo"></projectViewDialog>
  </div>

</template>

<script>
import projectViewDialog from "./dialogs/projectViewDialog";

export default {
  name: 'ProjectView',
  components: {projectViewDialog},
  methods: {
    // 处理查看项目细节请求
    handleViewClick(row) {
      // console.log(row);
      let that = this
      let pid = row.pid
      this.$get(`project/all?pid=${pid}`).then(r=>{
        that.projectInfo = r.data.data
      })
      this.$get(`project/member_info?pid=${pid}`).then(r=>{
        console.log(r)
      })
    },
    // 处理编辑项目信息请求
    handleEditClick(row) {
      // this.$get('project/all_member_info').then(r=>{
      //   // console.log(r)
      // })
    },
    // 处理删除项目信息请求
    handleDeleteClick(row) {

    }
  },
  data() {
    return {
      // 表格内容信息，包含所有项目的简要信息，不含成员信息
      tableData: [],
      // 项目基本信息
      projectInfo: {},
      // 成员信息
      memberInfo: {}
    }
  },
  mounted () {
    this.$get('project/all').then((r) => {
      // console.log(r.data.data)
      this.tableData = r.data.data
    })
  }
}
</script>



<style scoped>

</style>
