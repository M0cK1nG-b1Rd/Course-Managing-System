<template>
  <div>
    <el-dialog
      center
      title="项目详细信息"
      :visible.sync="dialogVisible"
      width="50%">
<!--对话框表单信息-->
      <span>
<!--        <ViewDialogContent :projectInfo="projectInfo" :memberInfo="memberInfo"></ViewDialogContent>-->
        <div>
          <!--    项目基本信息表单-->
          <el-form ref="projectForm" :model="projectInfo" label-width="80px" inline >
            <el-form-item label="项目名称" >
              <el-input v-model="projectInfo.projectName" style="width: 485px" disabled></el-input>
            </el-form-item>
            <el-form-item label="项目经理">
              <el-input v-model="projectInfo.managerName" disabled></el-input>
            </el-form-item>
            <el-form-item label="指导老师">
              <el-input v-model="projectInfo.teacherName" disabled></el-input>
            </el-form-item>
            <el-form-item label="项目类型">
              <el-input v-model="projectInfo.projectType" disabled></el-input>
            </el-form-item>
            <el-form-item label="特殊资源">
              <el-input v-model="resource" disabled></el-input>
            </el-form-item>
            <el-form-item label="开始时间">
                <el-date-picker type="date"
                                disabled
                                v-model="projectInfo.startTime"
                                style="width: 195px;"
                                format="yyyy 年 MM 月 dd 日"
                                value-format="yyyy-MM-dd">
                </el-date-picker>
            </el-form-item>
                <el-form-item label="开始时间">
                <el-date-picker type="date"
                                disabled
                                v-model="projectInfo.endTime"
                                style="width: 195px;"
                                format="yyyy 年 MM 月 dd 日"
                                value-format="yyyy-MM-dd">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="项目描述">
              <el-input type="textarea" v-model="projectInfo.projectDesc" style="width: 485px" disabled></el-input>
            </el-form-item>
            <el-form-item label="项目成员">
              <div>
                <!-- 用户列表区域 -->
                <el-row>
                  <el-table :data="memberInfo" border stripe disabled>
                    <el-table-column label="姓名" prop="tuserInfo.name" width="100px" align="center"></el-table-column>
                    <el-table-column label="班级" prop="tuserInfo.class" width="100px" align="center"></el-table-column>
                    <el-table-column label="学号" prop="sid" width="135px" align="center"></el-table-column>
                    <el-table-column label="岗位" prop="position" width="150px" align="center"></el-table-column>
                  </el-table>
                </el-row>
              </div>
            </el-form-item>
          </el-form>
        </div>
      </span>
<!--对话框底部按钮-->
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>

    </el-dialog>
  </div>
</template>

<script>

export default {
  name: 'projectViewDialog',
  props: ['projectInfo', 'memberInfo','dialogVisible'],
  data() {
    return {
      // 需要的特殊资源，不必传给后端，仅在前端展示
      resource: '服务器算力资源'
    }
  },
  mounted() {
  },
  methods: {

  }
};
</script>
