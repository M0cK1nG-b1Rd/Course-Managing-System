<template>

  <div>
    <!--  所有成绩信息的表格-->
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="tuserInfo.name"
        label="姓名"
        width="120">
      </el-table-column>
      <el-table-column
        prop="tuserInfo.class"
        label="班级"
        width="120">
      </el-table-column>
      <el-table-column
        prop="sid"
        label="学号"
        width="120">
      </el-table-column>
      <el-table-column
        sortable
        prop="totalScore"
        label="总成绩"
        width="100">
      </el-table-column>
      <el-table-column
        sortable
        prop="processScore"
        label="过程考核"
        width="120">
      </el-table-column>
      <el-table-column
        sortable
        prop="docsScore"
        label="文档报告"
        width="120">
      </el-table-column>
      <el-table-column
        sortable
        prop="completeScore"
        label="完成度"
        width="120">
      </el-table-column>
      <el-table-column
        sortable
        prop="presentationScore"
        label="答辩表现"
        width="120">
      </el-table-column>
      <el-table-column
        prop="feedback"
        label="评价及反馈"
        width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-edit"
            @click="handleEdit(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--  编辑成绩的对话框-->
    <el-dialog
      title="修改成绩"
      :visible.sync="editDialogVisible"
      width="60%"
      center>

      <el-container>
        <!--    学生信息对象-->
        <el-divider content-position="center"></el-divider>
        <el-header id="selectStuHeader" height="34px">当前编辑中的学生信息</el-header>
        <el-main id="selectStuMain">
          <!--学生，作为打分对象-->
          <el-select v-model="markingObj.sid"
                     placeholder="选择成员姓名" clearable
                     size="medium">
            <el-option
              v-for="item in studentOptions"
              v-if="markingObj.pid==item.pid"
              :key="item.sid"
              :label="item.tuserInfo.name"
              :value="item.sid">
            </el-option>
          </el-select>
        </el-main>

        <!--   打分区-->
        <el-divider content-position="center" ></el-divider>
        <el-header id="markHeader" height="34px">开始打分</el-header>
        <el-main id="markMain">
          <el-form  class="demo-form-inline" label-width="15%" label-position="left">
            <el-form-item label="过程考核">
              <el-col :span="22">
                <el-slider v-model="markResult.processScore"
                           show-input input-size="mini" @change="onGiveSubScore">
                </el-slider>
              </el-col>
            </el-form-item>
            <el-form-item label="文档及报告">
              <el-col :span="22">
                <el-slider v-model="markResult.docsScore"
                           show-input input-size="mini" @change="onGiveSubScore">
                </el-slider>
              </el-col>
            </el-form-item>
            <el-form-item label="完成情况">
              <el-col :span="22">
                <el-slider v-model="markResult.completionScore"
                           show-input input-size="mini" @change="onGiveSubScore">
                </el-slider>
              </el-col>
            </el-form-item>
            <el-form-item label="答辩表现">
              <el-col :span="22">
                <el-slider v-model="markResult.presentationScore"
                           show-input input-size="mini" @change="onGiveSubScore">
                </el-slider>
              </el-col>
            </el-form-item>
            <el-form-item label="加权总分">
              <el-col :span="22">
                <a-progress
                  :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                  :percent="markResult.totalScore"
                  :format="percent => `${percent} 分`"
                  status="active"
                />
              </el-col>
            </el-form-item>
          </el-form>
        </el-main>

        <!--   点评区-->
        <el-divider content-position="center" ></el-divider>
        <el-header id="commentHeader" height="34px">点评及反馈</el-header>
        <el-main id="commentMain">
          <el-input
            type="textarea"
            rows="5"
            placeholder="请在此对学生进行点评及反馈"
            v-model="markResult.feedback">
          </el-input>
        </el-main>
        <el-main style="{align-content: center;}">
          <el-form>
            <el-form-item>
              <el-col :span="1">&nbsp</el-col>
              <el-col :span="6">
                <el-popover
                  placement="top-start"
                  title="温馨提示"
                  width="200"
                  trigger="hover"
                  content="点击按钮后即可提交对当前同学的打分结果。">
                  <el-button type="primary" @click="onSubmitScore" slot="reference">提交本次评价</el-button>
                </el-popover>
              </el-col>
              <el-col :span="1">&nbsp</el-col>
              <el-col :span="6">
                <el-popover
                  placement="top-start"
                  title="请注意"
                  width="200"
                  trigger="hover"
                  content="请注意，点击按钮后将发布全班成绩，请先确保已完成所有学生的评价。">
                  <el-button type="success" @click="onReleaseScore" slot="reference">发布全班成绩</el-button>
                </el-popover>
              </el-col>
              <el-col :span="1">&nbsp</el-col>
              <el-col :span="6">
                <el-popover
                  placement="top-start"
                  title="温馨提示"
                  width="200"
                  trigger="hover"
                  content="点击按钮后将取消已发布发的成绩，原来的评分记录仍然存在，但学生无法查看。">
                  <el-button type="warning" @click="onUnReleaseScore" slot="reference">暂停成绩发布</el-button>
                </el-popover>
              </el-col>
            </el-form-item>
          </el-form>
        </el-main>
      </el-container>

      <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="editDialogVisible = false">确 定</el-button>

  </span>
    </el-dialog>
  </div>

</template>

<script>
export default {
  methods: {
    // 处理老师修改成绩事件
    handleEdit(row) {
      this.editDialogVisible = true
      this.editingRow = row
    },
    // 发布全班成绩
    onReleaseScore() {
      this.$put('project/release_score').then(r=>{
        this.$message.success('成绩已发布！')
      })
    },

    // 取消发布全班成绩
    onUnReleaseScore() {
      this.$put('project/unrelease_score').then(r=>{
        this.$message.info('成绩已暂停发布！')
      })
    }
  },

  mounted() {
    let that = this
    this.$get('project/stu_score').then(r=>{
      that.tableData = r.data.data.stuScore
    })
  },

  data() {
    return {
      // 表中的数据-所有同学的成绩信息
      tableData: [],
      // 被编辑后的这一位同学的成绩成员信息
      editedScore: {

      },
      // 编辑成绩对话框的可见性
      editDialogVisible: false,
      // 当前正在编辑的那一行的所有字段
      editingRow: {}
    }
  }
}
</script>
