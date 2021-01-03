<template>
  <div style="width: 100%;height: 100%;text-align: center;margin-left: 50px;margin-right: 50px">
    <el-row style="font-size: 25px;font-weight: bold">
      <dv-decoration-7>绩效考核</dv-decoration-7>
    </el-row>
    <el-row><div style="height: 40px">&nbsp</div></el-row>
<!--    第一行-->
    <el-row>
<!--      第一行，第一列-->
      <el-col :span="12">
        <el-row style="font-size: 20px;font-weight: bolder">
          成员活跃度
        </el-row>
        <el-row>
          <div style="height: 90%;width: 80%">
            <ve-heatmap :data="activeDegree"></ve-heatmap>
          </div>
        </el-row>
      </el-col>
<!--      第一行，第二列-->
      <el-col :span="12">
        <el-row style="font-size: 20px;font-weight: bolder;padding-bottom: 45px">
          提交文档数量
        </el-row>
        <el-row>
          <ve-pie :data="docsNum"></ve-pie>
        </el-row>
      </el-col>
    </el-row>

    <!--    第二行-->
    <el-row>
      <!--      第二行，第一列-->
      <el-col :span="12">
        <el-row style="font-size: 20px;font-weight: bolder;padding-bottom: 45px">
          考勤表现
        </el-row>
        <el-row>
          <div style="height: 90%;width: 80%">
            <ve-line :data="attendanceData" :settings="attendanceSettings"></ve-line>
          </div>
        </el-row>
      </el-col>
      <!--      第二行，第二列-->
      <el-col :span="12">
        <el-row style="font-size: 20px;font-weight: bolder">
          任务完成情况
        </el-row>
        <el-row>
          <div style="height: 90%;width: 80%; margin-top: 40px">
            <ve-bar :data="completeData"></ve-bar>
          </div>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        // 成员活跃度
        activeDegree: {
          columns: ['时间', '姓名', '活跃度'],
          rows: [
            { '时间': '星期一', '姓名': '成员1', '活跃度': 1000 },
            { '时间': '星期二', '姓名': '成员2', '活跃度': 400 },
            { '时间': '星期三', '姓名': '成员4', '活跃度': 800 },
            { '时间': '星期二', '姓名': '成员3', '活跃度': 200 },
            { '时间': '星期三', '姓名': '成员3', '活跃度': 100 },
            { '时间': '星期五', '姓名': '成员5', '活跃度': 300 },
            { '时间': '星期四', '姓名': '成员1', '活跃度': 800 },
            { '时间': '星期一', '姓名': '成员1', '活跃度': 700 },
            { '时间': '星期三', '姓名': '成员2', '活跃度': 300 },
            { '时间': '星期二', '姓名': '成员4', '活跃度': 500 }
          ]
        },
        // 文档数量
        docsNum:{
            columns: ['姓名', '文档数量'],
            rows: [
              { '姓名': '成员1', '文档数量': 1 },
              { '姓名': '成员2', '文档数量': 2 },
              { '姓名': '成员3', '文档数量': 2 },
              { '姓名': '成员4', '文档数量': 5 },
              { '姓名': '成员5', '文档数量': 3 }
            ]
          },
        // 考勤状况
        attendanceData: {
          columns: ['姓名', '迟到次数', '早退次数', '旷工次数'],
          rows: [
            { '姓名': '成员1', '迟到次数': 1, '早退次数': 3, '旷工次数': 3 },
            { '姓名': '成员2', '迟到次数': 1, '早退次数': 5, '旷工次数': 1 },
            { '姓名': '成员3', '迟到次数': 3, '早退次数': 1, '旷工次数': 2 },
            { '姓名': '成员4', '迟到次数': 4, '早退次数': 4, '旷工次数': 6 },
            { '姓名': '成员5', '迟到次数': 2, '早退次数': 2, '旷工次数': 0 }
          ]
        },
        attendanceSettings: {
          yAxisType: ['次', 'percent'],
          yAxisName: ['次数', '']
        },
        // 任务完成情况
        completeData: {
          columns: ['日期', '完成数', '取消数', '逾期数'],
          rows: [
            {'日期': '成员1', '完成数': 13, '取消数': 2, '逾期数': 5},
            {'日期': '成员2', '完成数': 20, '取消数': 5, '逾期数': 2},
            {'日期': '成员3', '完成数': 15, '取消数': 6, '逾期数': 1},
            {'日期': '成员4', '完成数': 17, '取消数': 4, '逾期数': 3},
            {'日期': '成员5', '完成数': 10, '取消数': 7, '逾期数': 1}
          ]
        }
      }
    }
  }

</script>

<style>

</style>
