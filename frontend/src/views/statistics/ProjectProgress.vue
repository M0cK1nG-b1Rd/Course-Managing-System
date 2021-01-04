<template>
  <div style="width: 100%;height: 100%;text-align: center">
<!--    标题-->
    <el-row style="font-size: 25px;font-weight: bold;margin-bottom: 60px">
      <dv-decoration-7>项目进度</dv-decoration-7>
    </el-row>
<!--    装饰-->
    <el-row style="margin-bottom: 30px">
      <dv-decoration-6 style="width:600px;height:30px;" />
    </el-row>
<!--    项目里程碑，时间线-->
    <el-row style="font-size:18px; margin-left: 150px; margin-right: 150px; margin-top: 60px; padding-bottom: 0px">
        <a-timeline mode="alternate">
          <a-timeline-item>提交项目章程，项目正式启动 2020-11-20</a-timeline-item>
          <a-timeline-item color="green">
            召开第一次组会，确定前后端框架和技术选型 2020-11-25
          </a-timeline-item>
          <a-timeline-item color="green">
            前端后端明确学习任务，开始基础知识学习 2020-11-27
          </a-timeline-item>
          <a-timeline-item color="green">
            项目概要设计文档产生，召开会议讨论审核并全体表决通过 2020-12-5
          </a-timeline-item>
          <a-timeline-item>
            <a-icon slot="dot" type="clock-circle-o" style="font-size: 16px;" />
            由于项目小组成员考试密集，原定于12月10号召开的项目集中开发延迟 2020-12-10
          </a-timeline-item>
          <a-timeline-item color="red">
            取消了原本计划的聊天功能，变更请求通过审核 2020-12-12
          </a-timeline-item>
          <a-timeline-item>组织项目小组成员集中开发，为按期交付产品，开始赶工 2020-12-20</a-timeline-item>
          <a-timeline-item>
            <a-icon slot="dot" type="clock-circle-o" style="font-size: 16px;" />
           用户验收项目，项目成功交付 2021-01-05
          </a-timeline-item>
        </a-timeline>
    </el-row>
<!--    图表区-->
    <el-row style="margin-left: 150px; margin-right: 150px; margin-bottom: 80px;">
<!--      图1-->
      <el-col :span="10" >
        <el-row>
          <dv-decoration-9 style="width:150px;
          height:150px;margin-top: 50px;
          font-size: 20px;font-weight: bolder">
            100%
          </dv-decoration-9>
        </el-row>
        <el-row style="text-align: left; font-size: 20px; font-weight: bolder">
          项目完成百分比
        </el-row>
      </el-col>
<!--      图2-->
      <el-col :span="10" >
        <el-row>
          <dv-conical-column-chart :config="config1" style="width:400px;height:200px;" />
        </el-row>
        <el-row style="text-align: center; font-size: 20px; font-weight: bolder">
          <span style="width: 30px; margin-right: 70px">&nbsp</span><span>统计数据</span>
        </el-row>
      </el-col>
    </el-row>


  </div>
</template>

<script>
export default {
  name: "ProjectProgress",
  data() {
    return {
      config1: {
        data: [
          {
            name: '实现功能',
            value: 80
          },
          {
            name: '修复缺陷',
            value: 120
          },
          {
            name: '提交文档',
            value: 50
          }
        ],
        showValue: true,
        fontSize: 15,
        textColor: '#000'
      }
    }
  }
}
</script>

<style scoped>

</style>
