<template>
  <div id="components-layout-demo-basic">
<!--    成绩已发布时显示的页面-->
    <a-layout v-if="isReleased==1">
      <a-layout-header>查看项目评分</a-layout-header>
      <a-layout-content>
<!--         第一行，个人成绩及反馈-->
        <a-row>
            <!--           第一行第一列，展示自己的成绩-->
            <a-col :span="12">
              <!--              加权总分-->
              <a-row>
                <a-col :span="4">加权总分</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                    :percent="myScore.total"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
              <!--              过程考核-->
              <a-row>
                <a-col :span="4">过程考核</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#fad900',
                  to: '#e5772c',}"
                    :percent="myScore.process"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
              <!--              文档及报告-->
              <a-row>
                <a-col :span="4">文档报告</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
                    :percent="myScore.docs"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
              <!--              完成情况-->
              <a-row>
                <a-col :span="4">完成情况</a-col>
                <a-col :span="20">
                  <a-progress
                    :stroke-color="{
                  from: '#fad900',
                  to: '#e5772c',}"
                    :percent="myScore.completion"
                    :format="percent => `${percent} 分`"
                    status="active"
                  />
                </a-col>
              </a-row>
            </a-col>
            <a-col :span="2"><div>&nbsp</div></a-col>
            <!--              第一行第二列，展示评价及反馈-->
            <a-col :span="10">
              <a-row><div style="height: 20px"></div></a-row>
              <!--            老师评价-->
              <a-row>
                <Comment :commenter="'老师反馈'" :content="teacherFeedback"></Comment>
              </a-row>
              <!--            项目经理评价-->
              <a-row><div style="height: 20px"></div></a-row>
              <a-row>
                <Comment :commenter="'项目经理反馈'" :content="managerFeedback"></Comment>
              </a-row>
            </a-col>
        </a-row>
        <a-divider />
<!--        第二行，全班统计信息-->
        <a-row>
          <a-col :span="12">
<!--            最高、最低、平均分-->
            <dv-capsule-chart :config="stasticsConfig" style="width:100%;height:200px;color: #000c17;font-size: 20px;!important" />
<!--            <ve-histogram :data="stasticsData" :settings="stasticsSetting"></ve-histogram>-->
          </a-col>
          <a-col :span="2"><div>&nbsp</div></a-col>
          <a-divider type="vertical" />
          <a-col :span="4">
            <dv-water-level-pond :config="greaterThanClassConfig" style="width:100%;height:100%" />
            击败全班
          </a-col>
          <a-divider type="vertical" />
          <a-col :span="4">
            <dv-water-level-pond :config="greaterThanProjectConfig" style="width:100%;height:100%" />
            击败全组
          </a-col>
        </a-row>

      </a-layout-content>
    </a-layout>

<!--    成绩尚未发布时显示的页面-->
    <a-result status="500" title="成绩尚未发布" sub-title="请别着急，好成绩马上就来！" v-else>
      <template #extra>
        <a-button type="primary">
          祝君好运
        </a-button>
      </template>
    </a-result>

  </div>
</template>

<script>
import Comment from "./Comment";

export default {
  name: 'GiveScore',
  components: {
    Comment
  },
  // 属性区
  data() {
    return {
      // 成绩是否已发布，已发布为1
      isReleased: 0,
      // 学生的成绩
      myScore: {
        total: 98,
        process: 100,
        docs: 95,
        completion: 95,
        presentation: 100
      },
      // 老师反馈
      teacherFeedback: '你在本次项目过程中团队意识强，善于倾听他人的意见，乐于助人。你的技术水平也十分高超，感谢你对本次项目成功做出的贡献！',
      // 项目经理反馈
      managerFeedback: '你在本次项目过程中团队意识强，善于倾听他人的意见，乐于助人。你的技术水平也十分高超，感谢你对本次项目成功做出的贡献！',
      // 全班成绩统计数据
      classStatistics: {
        avgScore: 0,
        maxScore: 0,
        minScore: 0
      },
      // 平均分，最高，最低分柱状图配置数据
      stasticsConfig: {
        data: [
          {
            name: '最高分',
            value: 0
          },
          {
            name: '最低分',
            value: 0
          },
          {
            name: '平均分',
            value: 0
          },
        ],
        unit: '分'
      },
      // 个人成绩排行
      myRank: {
        greaterThanClass: 0,
        greaterThanProject: 0
      },
      // 超过全班百分比水位图配置
      greaterThanClassConfig: {
        data: [],
        shape: 'roundRect'
      }
      ,
      // 超过全组百分比水位图配置
      greaterThanProjectConfig: {
        data: [],
        shape: 'roundRect'
      }

    }
  },
  // 钩子
  created () {
    let that = this
    // 从后台获得个人成绩信息及统计数据
    this.$get('project/score').then((r) => {
      console.log(r)
      that.myScore.total = r.data.data.stuScore.totalScore
      that.myScore.completion = r.data.data.stuScore.completeScore
      that.myScore.process = r.data.data.stuScore.processScore
      that.myScore.presentation = r.data.data.stuScore.presentationScore
      that.myScore.docs = r.data.data.stuScore.docsScore
      that.teacherFeedback = r.data.data.stuScore.feedback
      that.isReleased = r.data.data.stuScore.isReleased
      that.classStatistics.avgScore = r.data.data.classStatistics.avgScore
      that.classStatistics.maxScore = r.data.data.classStatistics.maxScore
      that.classStatistics.minScore = r.data.data.classStatistics.minScore
      that.myRank.greaterThanClass = r.data.data.greaterThanInClass
      that.myRank.greaterThanProject = r.data.data.greaterThanInProject
      that.greaterThanClassConfig.data[0] = r.data.data.greaterThanInClass*100
      that.greaterThanClassConfig.data[0] = r.data.data.greaterThanInProject*100
      that.stasticsConfig.data[0].value = r.data.data.classStatistics.maxScore
      that.stasticsConfig.data[1].value = r.data.data.classStatistics.minScore
      that.stasticsConfig.data[2].value = r.data.data.classStatistics.avgScore

    })
  },
  // 行为区
  methods: {

  }
}
</script>

<style>
#components-layout-demo-basic {
  width: 95%;
}
#components-layout-demo-basic .ant-layout-header{
  background: #ffffff;
  color: #000c17;
  font-size: 30px;
  text-align: center;
}
#components-layout-demo-basic .ant-layout-footer {
  background: #7dbcea;
  color: #fff;
}
#components-layout-demo-basic .ant-layout-footer {
  line-height: 1.5;
}

#components-layout-demo-basic .ant-layout-content {
  background: #fff;
  color: #000c17;
  min-height: 120px;
  line-height: 120px;
  text-align: center;
  font-size: 18px;
}
#components-layout-demo-basic > .ant-layout {
  margin-bottom: 48px;
}
#components-layout-demo-basic > .ant-layout:last-child {
  margin: 0;
}

</style>
