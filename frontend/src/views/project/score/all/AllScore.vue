<template>

  <div style="width: 100%">
    <!--  全班成绩表格-->
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
        prop="completionScore"
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
      title="修改学生成绩"
      :visible.sync="editDialogVisible"
      width="55%"
      center>

      <el-form  class="demo-form-inline" label-width="15%" label-position="left">
        <el-form-item label="当前">
          <el-row style="font-size: 15px;">
            <el-col :span="8">姓名:{{editingRow.tuserInfo.name}}</el-col>
            <el-col :span="8">班级:{{editingRow.tuserInfo.class}}</el-col>
            <el-col :span="8">学号:{{editingRow.sid}}</el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="过程考核">
          <el-row>
            <el-col :span="16">
              <a-progress
                :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                :percent="editingRow.processScore"
                :format="percent => `${percent} 分`"
                status="active"
              />
            </el-col>
            <el-col :span="2">
              <span>&nbsp</span>
            </el-col>
            <el-col :span="3">
              <el-input
                @input="recalculateTotalcore"
                v-model="editingRow.processScore"
                clearable>
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="文档及报告">
          <el-row>
            <el-col :span="16">
              <a-progress
                :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                :percent="editingRow.docsScore"
                :format="percent => `${percent} 分`"
                status="active"
              />
            </el-col>
            <el-col :span="2">
              <span>&nbsp</span>
            </el-col>
            <el-col :span="3">
              <el-input
                @input="recalculateTotalcore"
                v-model="editingRow.docsScore"
                clearable>
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="完成情况">
          <el-row>
            <el-col :span="16">
              <a-progress
                :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                :percent="editingRow.completionScore"
                :format="percent => `${percent} 分`"
                status="active"
              />
            </el-col>
            <el-col :span="2">
              <span>&nbsp</span>
            </el-col>
            <el-col :span="3">
              <el-input
                @input="recalculateTotalcore"
                v-model="editingRow.completionScore"
                clearable>
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="答辩表现">
          <el-row>
            <el-col :span="16">
              <a-progress
                :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                :percent="editingRow.presentationScore"
                :format="percent => `${percent} 分`"
                status="active"
              />
            </el-col>
            <el-col :span="2">
              <span>&nbsp</span>
            </el-col>
            <el-col :span="3">
              <el-input
                @input="recalculateTotalcore"
                v-model="editingRow.presentationScore"
                clearable>
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="加权总分">
          <el-row>
            <el-col :span="16">
              <a-progress
                :stroke-color="{
                  from: '#ff3503',
                  to: '#ffdc00',}"
                :percent="editingRow.totalScore"
                :format="percent => `${percent} 分`"
                status="active"
              />
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item></el-form-item>
          <el-row>
            <el-col :span="2">&nbsp</el-col>
            <el-col :span="19">
              <el-input
                type="textarea"
                rows="5"
                placeholder="请在此对学生进行点评及反馈"
                v-model="editingRow.feedback">
              </el-input>
            </el-col>
          </el-row>
      </el-form>

      <span slot="footer" class="dialog-footer">
    <el-button @click="quitEdit">取消修改</el-button>
    <el-button type="primary" @click="submitEdit">保存修改</el-button>
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
      // 备份原始成绩
      this.oldRow = row
      this.editingRow = row
    },
    // 放弃成绩修改
    quitEdit() {
      this.editingRow = this.oldRow
      this.$message.info('成绩修改已取消！')
      this.editDialogVisible = false
    },
    // 提交成绩修改
    submitEdit() {
      this.$put('project/score',this.editingRow).then((r)=>{
        this.$message.success('成绩修改成功！')
      })
      this.editDialogVisible = false
    },
    // 小分变化时，重新计算总分
    recalculateTotalcore() {
        this.editingRow.totalScore =
        this.editingRow.processScore*this.markRule.process +
        this.editingRow.presentationScore*this.markRule.presentation +
        this.editingRow.docsScore*this.markRule.docs +
        this.editingRow.completionScore*this.markRule.completion;
        this.editingRow.totalScore /= 100
    }
  },

  mounted() {
    let that = this
    // 获取全班所有成绩
    this.$get('project/all_score').then(r=>{
      that.tableData = r.data.data.stuScore
    })
    // 获取打分规则
    // 从数据库获取已有的打分规则
    this.$get('project/score/rules').then((r) => {
      // this.data = r.data.data
      that.markRule.process = r.data.data[0].ratio
      that.markRule.docs = r.data.data[1].ratio
      that.markRule.completion = r.data.data[2].ratio
      that.markRule.presentation = r.data.data[3].ratio
    })
  },

  data() {
    return {
      // 表中的数据-所有同学的成绩信息
      tableData: [],
      // 编辑成绩对话框的可见性
      editDialogVisible: false,
      // 当前正在编辑的那一行的所有字段
      editingRow: {
        sid: '',
        completionScore: 0,
        docsScore: 0,
        processScore: 0,
        tuserInfo: {
          name: '',
          class: ''
        }
      },
      // 修改前的成绩信息
      oldRow: {},
      // 数据库中已有的打分规则
      markRule: {},
    }
  }
}
</script>
